package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.NPCAction;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.TextDecalComponent;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.SoundAsset;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class NPCSystem extends IteratingSystem {


    private static Vector2 direction      = new Vector2();
    private static Vector3 velocity       = new Vector3();
    private static Matrix4 bodyTransform  = new Matrix4();
    private static Vector3 notFilteredPos = new Vector3();
    private static float   dustTime       = 0.1f;

    private float modelAngle = 0.0f;

    private Vector2 tmp = new Vector2();


    private Vector2 npcPosition = new Vector2();


    private static SoundAsset walk = null;


    @SuppressWarnings( "unchecked" )
    public NPCSystem () {
        super( Family.all( NPCComponent.class ).get() );
    }


    public void setWalkSound () {
        walk = SoundAsset.Step1;
        walk.playLoop();
        walk.setVolume( 0.0f );
    }


    public void disableWalkSound () {
        if ( walk != null ) {
            walk.stop();
        }
        walk = null;
    }


    @Override
    protected void processEntity ( Entity entity, float delta ) {
        NPCComponent npcComponent = MyMapper.NPC.get( entity );
        int action = npcComponent.currentAction;

        boolean needToSkip = MyMapper.SKIP.has( entity );

        if ( !needToSkip ) {
            npcComponent.time -= delta;
        }

        NPCAction npcAction;

        if ( npcComponent.time < 0 ) {

            action++;
            if ( action > npcComponent.actionArray.size - 1 ) {
                action = 0;
            }

            npcAction = npcComponent.actionArray.get( action );
            npcComponent.time = npcAction.durationTime;
            npcComponent.currentAction = action;

            if ( DEBUG.NPC_ACTIONS.get() ) {
                Gdx.app.debug( "action " + npcAction.id, "time " + npcComponent.time );
                if ( npcComponent.actionArray.get( action ).targetPosition != null ) {
                    Gdx.app.debug( "targetPosition", "" + npcAction.targetPosition );
                }
            }
        } else {
            npcAction = npcComponent.actionArray.get( action );
        }

        btRigidBody body = MyMapper.PHYSICAL.get( entity ).body;
        body.getWorldTransform( bodyTransform );
        bodyTransform.getTranslation( notFilteredPos );

        boolean attack = false;

        if ( needToSkip ) {
            direction.set( 0, 0 );
        } else {
            switch ( npcAction.id ) {
                case WAIT:
                    npcComponent.hunting = false;
                    keepCalm();
                    break;

                case MOVE:
                    npcComponent.hunting = false;
                    npcPosition.set( notFilteredPos.x, notFilteredPos.z );
                    direction.set( npcAction.targetPosition.x, npcAction.targetPosition.y );
                    direction.sub( npcPosition );

                    if ( direction.len() <= 0.1f ) {
                        npcComponent.time = 0;
                        keepCalm();
                    } else {
                        direction.nor();
                        soundByDistance( entity );
                    }

                    break;

                case HUNT:
                    attack = true;

                    npcPosition.set( notFilteredPos.x, notFilteredPos.z );
                    tmp.set( MyPlayer.getPosition() ).sub( npcPosition );
                    if ( tmp.len() > 8.0f || !MyPlayer.live ) {
                        npcComponent.time = 0;
                        npcComponent.hunting = false;
                    } else {
                        tmp.nor();
                        direction.set( tmp );
                        npcComponent.hunting = true;
                        soundByDistance( entity );
                    }

                    break;

                case SAY:
                    npcComponent.hunting = false;
                    keepCalm();
                    entity.add( new TextDecalComponent( npcAction.text, npcAction.durationTime ) );
                    npcComponent.time = 0;
                    break;
            }
        }

        AnimationComponent animationComponent = MyMapper.ANIMATION.get( entity );
        String ID_CURRENT = animationComponent.getID();
        String ID_RUN = "RUN";
        String ID_IDLE = "IDLE";
        String ID_ATTACK = "ATTACK";

        boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );
        boolean playerIsAttacking = ID_ATTACK.equals( ID_CURRENT );

        int IDLE = 0;
        int RUN = 1;
        int ATTACK = 2;
        //int DIE = 3;

        float directionLen = direction.len();
        // Мы управляем персонажем джойстиком
        float speed;
        if ( directionLen != 0 ) {
            // Персонаж на земле
            float animationSpeed = 3.0f + 2.0f * directionLen;
            if ( playerIsRunning && !attack ) {
                animationComponent.queue( RUN, animationSpeed );
            } else {
                if ( attack ) {
                    if ( !playerIsAttacking ) {
                        animationComponent.play( ATTACK, animationSpeed );
                    } else {
                        animationComponent.queue( ATTACK, animationSpeed );
                    }
                } else {
                    animationComponent.play( RUN, animationSpeed );
                }
            }

            float runSpeed = 4.0f;
            speed = ( runSpeed + 1 ) * directionLen;

            // Сохраняем угол для поворота модели
            modelAngle = 90 - direction.angle();

            // СОздаем пыль под ногами

            dustTime -= delta;
            if ( dustTime < 0 ) {
                dustTime = 0.16f;

                AshleySubs.createDustFX( notFilteredPos, 1.0f );
            }
        }
        // Мы не управляем персонажем джойстиком
        else {
            // Персонаж на земле
            if ( playerInIDLE ) {
                animationComponent.queue( IDLE, 2.0f );
            } else {
                animationComponent.play( IDLE, 2.0f );
            }
            speed = 0.0f;
        }

        //////////////////
        // Двигаем или останавливаем физическое тело
        velocity.set( direction.x, 0, direction.y );
        velocity.scl( speed );
        velocity.add( 0, body.getLinearVelocity().y, 0 );

        body.setLinearVelocity( velocity );

        bodyTransform.idt();
        bodyTransform.setToTranslation( notFilteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
        body.setWorldTransform( bodyTransform );
    }


    private void keepCalm () {
        direction.set( 0, 0 );
        walk.setVolume( 0.0f );
    }


    private void soundByDistance ( Entity entity ) {
        float MAX_LISTEN_DISTANCE = 20.0f;
        // Set NPC step-sounds by distance of player
        Vector2 playerPosition = MyPlayer.getPosition();
        float distance = MAX_LISTEN_DISTANCE - npcPosition.sub( playerPosition ).len();

        boolean isFlyingNPC = false;
        if ( MyMapper.LEVEL_OBJECT.has( entity ) ) {
            ModelAsset npcAsset = MyMapper.LEVEL_OBJECT.get( entity ).levelObject.modelAsset;
            isFlyingNPC = npcAsset.equals( ModelAsset.BUTTERFLY )||
                          npcAsset.equals( ModelAsset.BIRD1 )||
                          npcAsset.equals( ModelAsset.BIRD2ANGRY );
        }

        if ( !isFlyingNPC ) {
            float walkVolume = distance < MAX_LISTEN_DISTANCE ? distance / MAX_LISTEN_DISTANCE : 0;
            walk.setVolume( walkVolume );
        }
    }


    @Override
    public void removedFromEngine ( Engine engine ) {
        super.removedFromEngine( engine );

        disableWalkSound();
    }
}
