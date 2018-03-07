package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import net.overmy.adventure.ashley.DecalSubs;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.GroundedComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyPlayerComponent;
import net.overmy.adventure.ashley.components.PositionComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TypeOfComponent;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.Settings;

import java.util.ArrayList;

public final class MyPlayer {
    private static final Vector2    direction      = new Vector2();
    private static final Vector3    velocity       = new Vector3();
    private static       Matrix4    bodyTransform  = new Matrix4();
    private static final Vector3    notFilteredPos = new Vector3();
    private static final Vector3    filteredPos    = new Vector3();
    private static       ModelAsset modelAsset     = null;
    private static       Entity     playerEntity   = null;
    private static       boolean    jump           = false;
    private static       float      modelAngle     = 0.0f;
    private static       float      dustTime       = 0.1f;

    private static ArrayList< Item > bag = null;


    public static ArrayList< Item > getBag () {
        return bag;
    }


    private static float moveY = 0.0f;

    private static float speed;

    public static boolean onLadder = false;


    private MyPlayer () {
    }


    public static void load () {
        int n = ModelAsset.PLAYER01.ordinal() + Settings.PLAYER_MODEL.getInteger();
        modelAsset = ModelAsset.values()[ n ];

        modelAsset.load();

        //Gdx.app.debug( "" + modelAsset.toString(), "n of model " + n );
    }


    public static void addToBag ( Item item ) {
        Gdx.app.debug( "Добавлено в сумку", "" + item.getName() );
        bag.add( item );
    }


    public static void init () {
        bag = new ArrayList< Item >();

        if ( playerEntity != null ) {
            return;
        }

        modelAsset.build();

        final ModelInstance modelInstance = modelAsset.get();

/*
        TextureRegion region = IMG.BUTTON.getRegion();

        modelInstance.materials.get( 0 ).clear();
        modelInstance.materials.get( 0 ).set( TextureAttribute.createDiffuse( region ) );
*/

        final PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .setModelInstance( modelInstance )
                .defaultMotionState()
                .setMass( 60.0f )
                //.capsuleShape( 0.5f, 0.2f )
                .capsuleShape()
                .setCollisionFlag( btCollisionObject.CollisionFlags.CF_CHARACTER_OBJECT )
                .setCallbackFlag( BulletWorld.PLAYER_FLAG )
                .setCallbackFilter( BulletWorld.ALL_FLAG )
                .disableDeactivation();

        playerEntity = AshleyWorld.getPooledEngine().createEntity();
        playerEntity.add( physicalBuilder.buildPhysicalComponent() );
        playerEntity.add( new ModelComponent( modelInstance ) );
        playerEntity.add( new AnimationComponent( modelInstance ) );
        playerEntity.add( new GroundedComponent() );
        playerEntity.add( new TypeOfComponent( COMP_TYPE.MYPLAYER ) );
        playerEntity.add( new MyPlayerComponent() );

        AshleyWorld.getPooledEngine().addEntity( playerEntity );

        onLadder = false;
    }


    public static void dispose () {
        if ( bag != null ) {
            bag.clear();
        }
        bag = null;

        modelAsset = null;
        playerEntity = null;
    }


    public static void updateControls ( float deltaTime ) {
        if ( Gdx.input.isKeyJustPressed( Input.Keys.SPACE ) ) {
            startJump();
        }

        updateAnimation( deltaTime );

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;

        // Двигаем или останавливаем физическое тело
        final btRigidBody body = MyMapper.PHYSICAL.get( playerEntity ).body;
        velocity.set( direction.x, 0, direction.y );
        velocity.scl( speed );
        if ( !onLadder ) {
            velocity.add( 0, body.getLinearVelocity().y, 0 );
        } else {
            velocity.add( 0, -moveY * 5, 0 );
        }
        body.setLinearVelocity( velocity );

        if ( jump ) {
            if ( playerOnGround ) {
                final int HIT = 2;
                final AnimationComponent animationComponent = MyMapper.ANIMATION.get(
                        playerEntity );
                animationComponent.play( HIT, 2.6f );
                final float jumpSpeed = 8.0f;
                velocity.set( direction.x, jumpSpeed, direction.y );
                body.setLinearVelocity( velocity );
            }
            jump = false;
        }
        body.getWorldTransform( bodyTransform );
        bodyTransform.getTranslation( notFilteredPos );
        bodyTransform.idt();
        bodyTransform.setToTranslation( notFilteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
        body.proceedToTransform( bodyTransform );

/*        // Применяем физику к рендер-модели
        final float ALPHA = 0.45f;
        filteredPos.x = filteredPos.x + ALPHA * ( notFilteredPos.x - filteredPos.x );
        filteredPos.y = filteredPos.y + ALPHA * ( notFilteredPos.y - filteredPos.y );
        filteredPos.z = filteredPos.z + ALPHA * ( notFilteredPos.z - filteredPos.z );
        bodyTransform.setToTranslation( filteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );*/
/*

        // Поворачиваем модель контроллером на экране
        // после работы PhysicalSystem
        body.getWorldTransform( bodyTransform );
        bodyTransform.getTranslation( notFilteredPos );
        bodyTransform.idt();
        bodyTransform.setToTranslation( notFilteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
        body.proceedToTransform( bodyTransform );

        // Применяем физику к рендер-модели
        final float ALPHA = 0.45f;
        filteredPos.x = filteredPos.x + ALPHA * ( notFilteredPos.x - filteredPos.x );
        filteredPos.y = filteredPos.y + ALPHA * ( notFilteredPos.y - filteredPos.y );
        filteredPos.z = filteredPos.z + ALPHA * ( notFilteredPos.z - filteredPos.z );
        bodyTransform.setToTranslation( filteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
*/

        //MyMapper.MODEL.get( playerEntity ).modelInstance.transform.set( bodyTransform );

        MyCamera.setCameraPosition( notFilteredPos );
    }


    private static void updateAnimation ( float deltaTime ) {

        final AnimationComponent animationComponent = MyMapper.ANIMATION.get( playerEntity );
        final String ID_CURRENT = animationComponent.getID();
        final String ID_ATTACK = "ATTACK";
        final String ID_RUN = "RUN";
        final String ID_IDLE = "IDLE";

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;
        final boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        final boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );
        final boolean playerHitSomething = ID_ATTACK.equals( ID_CURRENT );

        final int IDLE = 0;
        final int RUN = 1;
        //final int HIT = 2;

        final float directionLen = direction.len();
        // Мы управляем персонажем джойстиком
        if ( directionLen != 0 ) {
            // Персонаж на земле
            if ( playerOnGround ) {
                final float animationSpeed = 3.0f + 2.0f * directionLen;
                if ( playerIsRunning ) {
                    animationComponent.queue( RUN, animationSpeed );
                } else {
                    animationComponent.play( RUN, animationSpeed );
                }
            }
            // Персонаж в воздухе
            else {
                if ( playerInIDLE ) {
                    animationComponent.queue( IDLE, 2.0f );
                } else {
                    animationComponent.play( IDLE, 2.0f );
                }
            }
            final float runSpeed = 6.0f;
            speed = ( runSpeed + 1 ) * directionLen;

            direction.nor();
            direction.rotate( -MyCamera.getCameraAngle() );

            // Сохраняем угол для поворота модели
            modelAngle = 90 - direction.angle();

            // СОздаем пыль под ногами

            dustTime -= deltaTime;
            if ( dustTime < 0 ) {
                dustTime = MathUtils.random( 0.05f, 0.25f );
                //notFilteredPos.sub( 0, 0.5f, 0 );

                Entity entity = AshleyWorld.getPooledEngine().createEntity();
                entity.add( DecalSubs.LightDustEffect( dustTime * 6 ) );
                entity.add( new PositionComponent( notFilteredPos ) );
                entity.add( new RemoveByTimeComponent( dustTime * 6 ) );
                AshleyWorld.getPooledEngine().addEntity( entity );
            }
        }
        // Мы не управляем персонажем джойстиком
        else {
            // Персонаж на земле
            if ( playerOnGround ) {
                if ( !playerHitSomething ) {
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                    }
                }
            }
            speed = 0.0f;
        }
    }


    public static void startJump () {
        jump = true;
    }

    //static Vector2 tmpDirection = new Vector2(  );


    public static void move ( float x, float y ) {
        direction.set( x, y );
        moveY = y;
    }
}
