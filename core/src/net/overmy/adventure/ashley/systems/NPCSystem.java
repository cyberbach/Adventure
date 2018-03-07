package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.ashley.DecalSubs;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.PositionComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TextDecalComponent;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class NPCSystem extends IteratingSystem {
    private static final Vector2 direction      = new Vector2();
    private static final Vector3 velocity       = new Vector3();
    private static       Matrix4 bodyTransform  = new Matrix4();
    private static final Vector3 notFilteredPos = new Vector3();
    private static       float   modelAngle     = 0.0f;
    private static       float   dustTime       = 0.1f;
    private static float speed;


    @SuppressWarnings( "unchecked" )
    public NPCSystem () {
        super( Family.all( NPCComponent.class ).get() );
    }

    //Vector3 position      = new Vector3();


    @Override
    protected void processEntity ( Entity entity, float delta ) {
        NPCComponent npcComponent = MyMapper.NPC.get( entity );
        int action = npcComponent.currentAction;
        npcComponent.time -= delta;
        if ( npcComponent.time < 0 ) {
            action++;
            if ( action > npcComponent.actionArray.size - 1 ) {
                action = 0;
            }

            npcComponent.time = npcComponent.actionArray.get( action ).durationTime;
            npcComponent.currentAction = action;
        }

        final btRigidBody body = MyMapper.PHYSICAL.get( entity ).body;
        body.getWorldTransform( bodyTransform );
        bodyTransform.getTranslation( notFilteredPos );

        switch ( npcComponent.actionArray.get( action ).id ) {
            case WAIT:
                direction.set( 0, 0 );
                break;

            case MOVE:
                direction.set( npcComponent.actionArray.get( action ).targetPosition.x,
                               npcComponent.actionArray.get( action ).targetPosition.y );
                direction.sub( notFilteredPos.x, notFilteredPos.z );

                if ( direction.len() <= 0.1f ) {
                    direction.set( 0, 0 );
                    npcComponent.time = 0;
                } else {
                    direction.nor();
                }

                break;

            case SAY:
                entity.add( new TextDecalComponent( npcComponent.actionArray.get( action ).text,
                                                    npcComponent.actionArray.get(
                                                            action ).durationTime ) );
                npcComponent.currentAction = action + 1;
                npcComponent.time = 0;
                direction.set( 0, 0 );
                break;
        }

        final AnimationComponent animationComponent = MyMapper.ANIMATION.get( entity );
        final String ID_CURRENT = animationComponent.getID();
        final String ID_RUN = "RUN";
        final String ID_IDLE = "IDLE";

        final boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        final boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );

        final int IDLE = 0;
        final int RUN = 1;
        //final int HIT = 2;

        final float directionLen = direction.len();
        // Мы управляем персонажем джойстиком
        if ( directionLen != 0 ) {
            // Персонаж на земле
            final float animationSpeed = 3.0f + 2.0f * directionLen;
            if ( playerIsRunning ) {
                animationComponent.queue( RUN, animationSpeed );
            } else {
                animationComponent.play( RUN, animationSpeed );
            }

            final float runSpeed = 6.0f;
            speed = ( runSpeed + 1 ) * directionLen;

            //direction.rotate( -MyCamera.getCameraAngle() );

            // Сохраняем угол для поворота модели
            modelAngle = 90 - direction.angle();

            // СОздаем пыль под ногами

            dustTime -= delta;
            if ( dustTime < 0 ) {
                dustTime = MathUtils.random( 0.05f, 0.25f );
                //notFilteredPos.sub( 0, 0.5f, 0 );
                /*AshleyWorld.getPooledEngine().addEntity(
                        EntitySubs.LightDustEffect( notFilteredPos, dustTime * 6 ) );*/

                Entity entity2 = AshleyWorld.getPooledEngine().createEntity();
                entity2.add( DecalSubs.LightDustEffect( dustTime * 6 ) );
                entity2.add( new PositionComponent( notFilteredPos ) );
                entity2.add( new RemoveByTimeComponent( dustTime * 6 ) );
                AshleyWorld.getPooledEngine().addEntity( entity2 );
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

        //bodyTransform.getTranslation( notFilteredPos );
        bodyTransform.idt();
        bodyTransform.setToTranslation( notFilteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
        body.setWorldTransform( bodyTransform );

/*
        // Применяем физику к рендер-модели
        final float ALPHA = 0.45f;
        filteredPos.x = filteredPos.x + ALPHA * ( notFilteredPos.x - filteredPos.x );
        filteredPos.y = filteredPos.y + ALPHA * ( notFilteredPos.y - filteredPos.y );
        filteredPos.z = filteredPos.z + ALPHA * ( notFilteredPos.z - filteredPos.z );
        bodyTransform.setToTranslation( filteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
*/
    }


    public void move ( float x, float y ) {
        direction.set( x, y );
    }
}
