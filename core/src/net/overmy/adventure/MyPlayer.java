package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject.CollisionFlags;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.EntityTypeComponent;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_ENTITY;
import net.overmy.adventure.logic.DynamicLevels;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.ItemInBagg;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.Settings;
import net.overmy.adventure.resources.SoundAsset;

import java.util.ArrayList;

public final class MyPlayer {
    private static final Vector2 v2Position     = new Vector2();
    private static final Vector2 direction      = new Vector2();
    private static final Vector3 velocity       = new Vector3();
    private static       Matrix4 bodyTransform  = new Matrix4();
    private static final Vector3 notFilteredPos = new Vector3();
    private static       float   modelAngle     = 0.0f;

    private static float dustTimer = 0.1f;

    public static boolean live = true;

    private static ModelAsset    modelAsset    = null;
    private static Entity        playerEntity  = null;
    public static  ModelInstance modelInstance = null; // for menu screen

    private static Node  rightArmNode = null;
    public static  float damage       = 5.0f;

    private static ArrayList< ItemInBagg > bag = null;

    public static boolean hurt = false;

    public static float extraSpeed2 = 0.0f;

    private static       boolean jump             = false;
    public static        boolean canJump          = true;
    private static       float   jumpDelayCounter = 0.0f;
    public static        float   extraJump        = 0.0f;
    private final static float   JUMP_DELAY       = 1.1f;

    private static       boolean attack             = false;
    public static        boolean canAttack          = true;
    private static       float   attackDelayCounter = 0.0f;
    private final static float   ATTACK_DELAY       = 0.4f;


    public static ArrayList< ItemInBagg > getBag () {
        return bag;
    }


    private static float moveY = 0.0f;

    private static float speed;

    public static  boolean    onLadder = false;
    private static SoundAsset walk     = null;

    private static btRigidBody playerBody = null;


    private static ModelInstance weaponInstance = null;
    private static Entity        weaponEntity   = null;
    private static ItemInBagg    itemInHand     = null;

    public static boolean isAttacking = false;


    private MyPlayer () {
    }


    public static void load () {
        int n = ModelAsset.PLAYER01.ordinal() + Settings.PLAYER_MODEL.getInteger();
        modelAsset = ModelAsset.values()[ n ];

        modelAsset.load();

        //Gdx.app.debug( "" + dynamicModelAsset.toString(), "n of model " + n );
    }


    public static void addToBag ( Item item ) {
        //Gdx.app.debug( "Добавлено в сумку", "" + item.getName() );

        boolean alreadyPresent = false;

        if ( bag.size() > 0 ) {
            for ( ItemInBagg itemInBag : bag ) {
                if ( itemInBag.item.equals( item ) ) {
                    itemInBag.count++;
                    alreadyPresent = true;
                }
            }
        }

        if ( !alreadyPresent ) {
            bag.add( new ItemInBagg( item ) );
        }

        AshleySubs.addItemToBad( item );
    }


    public static void init () {

        if ( playerEntity != null ) {
            return;
        }
        bag = new ArrayList< ItemInBagg >();

        modelInstance = modelAsset.get();

        // Здесь достаём нод руки игрока
        rightArmNode = modelInstance.getNode( "rightArm", true );

        playerEntity = AshleySubs.createPlayer( modelInstance );
        playerBody = MyMapper.PHYSICAL.get( playerEntity ).body;
        //body.setSpinningFriction( 0.1f );
        //body.setRollingFriction( 0.1f );

        onLadder = false;

        walk = SoundAsset.Step3;
        walk.playLoop();
        walk.setVolume( 0.0f );

        /////// create empty-hand weapon

        PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .defaultMotionState()
                .zeroMass()
                .boxShape( 0.4f )
                .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                .setCallbackFilter( BulletWorld.FILTER_ALL )
                .disableDeactivation();

        weaponEntity = new Entity();
        weaponEntity.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
        weaponEntity.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
        weaponEntity.add( physicalBuilder.buildPhysicalComponent() );
        AshleyWorld.getEngine().addEntity( weaponEntity );

        // set position by loaded dynamic level n

        Matrix4 loadedPosition = new Matrix4();
        loadedPosition.setToTranslation( startPositions[ DynamicLevels.getCurrent() ] );
        playerBody.setWorldTransform( loadedPosition );
    }


    private final static Vector3[] startPositions = new Vector3[] {
            new Vector3( -8.883699f, 3.3939111f, 5.062443f ),
            new Vector3( -46.313328f, 3.857123f, -54.17792f ),
            new Vector3( 0.59057057f, 2.7008367f, -149.63187f ),
            new Vector3( -85.78828f, 0.69114524f, -168.87808f ),
            new Vector3( -136.69661f, 2.7439363f, -362.21973f ),
            new Vector3( -245.94257f, 1.0721123f, -401.8604f ),
            new Vector3( -45.45584f, 3.2740111f, -442.94907f ),
            new Vector3( -115.261314f, 2.7465405f, -436.0399f ),
            new Vector3( -191.47537f, 6.3835006f, -473.49835f ), // 08
            new Vector3( -101.14407f, 3.693308f, -473.77426f ),
            new Vector3( -20.104654f, 8.933582f, -457.48343f ),//10
            new Vector3( -116.753716f, 2.1432183f, -535.78394f ),
            new Vector3( -59.840767f, 4.429752f, -620.98224f ),//12 с камнями
            new Vector3( -26.71163f, 2.1870565f, -656.59534f ),// с мостом
            new Vector3( -3.0696986f, -12.057977f, -620.8561f ),//труба
            new Vector3( -222.9113f, 13.589132f, -601.74225f ),//15 - продолжение 8-го
            new Vector3( 4.819017f, 5.0487814f, -753.78217f ),//зимняя
            new Vector3( -7.4517694f, 6.3198724f, -832.11035f ),//зимняя 17
    };


    public static void updateControls ( float deltaTime ) {

        if ( !live ) {
            return;
        }

        if ( !canJump ) {
            jumpDelayCounter -= deltaTime;
            if ( jumpDelayCounter < 0 ) {
                canJump = true;
            }
        }

        if ( !canAttack ) {
            attackDelayCounter -= deltaTime;
            if ( attackDelayCounter < 0 ) {
                canAttack = true;
            }
        }

        updateAnimation( deltaTime );

        boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;

        // Двигаем или останавливаем физическое тело
        velocity.set( direction.x, 0, direction.y );
        velocity.scl( speed );
        if ( !onLadder ) {
            velocity.add( 0, playerBody.getLinearVelocity().y, 0 );
        } else {
            velocity.add( 0, -moveY * 5, 0 );
        }

        playerBody.setLinearVelocity( velocity );

        if ( jump && !attack ) {
            if ( playerOnGround ) {
                final float jumpPower = 150.0f + extraJump;
                velocity.set( direction.x, jumpPower, direction.y );
                //body.setLinearVelocity( velocity );
                playerBody.applyCentralImpulse( velocity );

                SoundAsset.Jump1.play();

                int JUMP = 3;
                AnimationComponent animationComponent = MyMapper.ANIMATION.get( playerEntity );
                animationComponent.play( JUMP, 2.0f );

                isAttacking = false;
            }
            jump = false;
        }

        playerBody.getWorldTransform( bodyTransform );
        bodyTransform.getTranslation( notFilteredPos );
        bodyTransform.idt();
        bodyTransform.setToTranslation( notFilteredPos );
        bodyTransform.rotate( Vector3.Y, modelAngle );
        playerBody.proceedToTransform( bodyTransform );

        MyCamera.setCameraPosition( notFilteredPos );

        v2Position.set( notFilteredPos.x, notFilteredPos.z );
    }


    private static void updateAnimation ( float deltaTime ) {

        if ( !live ) {
            return;
        }

        final AnimationComponent animationComponent = MyMapper.ANIMATION.get( playerEntity );
        final String ID_CURRENT = animationComponent.getID();
        final String ID_ATTACK = "ATTACK";
        final String ID_RUN = "RUN";
        final String ID_IDLE = "IDLE";
        final String ID_HURT = "HURT";

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;
        final boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        final boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );
        final boolean playerIsAttacking = ID_ATTACK.equals( ID_CURRENT );
        final boolean playerIsHurt = ID_HURT.equals( ID_CURRENT );
//        final boolean playerJump = ID_JUMP.equals( ID_CURRENT );

        final int IDLE = 0;
        final int RUN = 1;
        final int ATTACK = 2;
        final int HURT = 4;

        // SET sound of walking steps
        if ( !onLadder ) {
            if ( direction.len() > 0 && playerOnGround ) {
                float walkSpeed = ( 2.5f + direction.len() * 0.5f ) / 4;
                walk.setVolume( 1.0f );
                walk.setPitch( walkSpeed );
            } else {
                walk.setVolume( 0.0f );
            }
        } else {
            walk.setVolume( 0.0f );
        }

        boolean timerWorked = speedUpTime >= 0;
        speedUpTime -= deltaTime;
        float extraSpeed = 0.0f;
        boolean speedUpFX = speedUpTime >= 0;
        if ( speedUpFX ) {
            int textOfTimer = (int) speedUpTime + 1;
            speedUpTimerLabel.setText( "" + textOfTimer );
            GlyphLayout layout = speedUpTimerLabel.getGlyphLayout();
            int iconSize = (int) ( Core.HEIGHT * 0.1f );
            speedUpTimerLabel.setPosition( -layout.width / 2, -layout.height / 2 - iconSize / 2 );
            extraSpeed = 6.0f;
        } else {
            if ( timerWorked ) {
                SoundAsset.ENDBOTTLE.play();
            }
        }

        timerWorked = jumpUpTime >= 0;
        jumpUpTime -= deltaTime;
        boolean jumpUpFX = jumpUpTime >= 0;
        if ( jumpUpFX ) {
            int textOfTimer = (int) jumpUpTime + 1;
            jumpUpTimerLabel.setText( "" + textOfTimer );
            GlyphLayout layout = jumpUpTimerLabel.getGlyphLayout();
            int iconSize = (int) ( Core.HEIGHT * 0.1f );
            jumpUpTimerLabel.setPosition( -layout.width / 2, -layout.height / 2 - iconSize / 2 );
            extraJump = 150.0f;
        } else {
            extraJump = 0.0f;
            if ( timerWorked ) {
                SoundAsset.ENDBOTTLE.play();
            }
        }

        if ( attack && !playerIsHurt ) {
            animationComponent.play( ATTACK, 3.0f );
            animationComponent.queue( IDLE, 2.0f );
            attack = false;
            isAttacking = true;
        }

        final float directionLen = direction.len();
        // Мы управляем персонажем джойстиком
        if ( directionLen != 0 ) {
            // Персонаж на земле
            if ( playerOnGround ) {
                final float animationSpeed = 3.0f + 2.0f * directionLen;
                if ( !playerIsAttacking && !playerIsHurt ) {
                    isAttacking = false;
                    if ( playerIsRunning ) {
                        animationComponent.queue( RUN, animationSpeed );
                    } else {
                        animationComponent.play( RUN, animationSpeed );
                    }
                }
            }
            // Персонаж в воздухе
            else {
                canJump = false;
                if ( !playerIsAttacking && !playerIsHurt ) {
                    isAttacking = false;
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                    }
                } else {
                    animationComponent.queue( IDLE, 2.0f );
                }
            }
            final float runSpeed = 5.0f + extraSpeed2;
            speed = ( runSpeed + extraSpeed ) * directionLen;

            direction.nor();
            direction.rotate( -MyCamera.getCameraAngle() );

            // Сохраняем угол для поворота модели
            modelAngle = 90 - direction.angle();

            // СОздаем пыль под ногами
            dust( deltaTime, speedUpFX, jumpUpFX );
        }
        // Мы не управляем персонажем джойстиком
        else {
            // Персонаж на земле
            if ( playerOnGround ) {
                if ( !playerIsAttacking && !playerIsHurt ) {
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                    }
                }
            } else {
                animationComponent.queue( IDLE, 2.0f );
            }
            speed = 0.0f;
        }

        if ( hurt ) {
            hurt = false;
            animationComponent.play( HURT, 3.5f );
        }
    }


    private static void dust ( float deltaTime, boolean speedUpFX, boolean jumpUpFX ) {
        dustTimer -= deltaTime;
        if ( dustTimer < 0 ) {
            if ( jumpUpFX ) {
                dustTimer = 0.1f;
                AshleySubs.createDustFX( notFilteredPos, 0.72f, GameColor.PURPLE );
            }
            if ( speedUpFX ) {
                dustTimer = 0.08f;
                AshleySubs.createDustFX( notFilteredPos, 0.72f, GameColor.GREEN );
            }

            if ( !jumpUpFX && !speedUpFX ) {
                dustTimer = 0.14f;
                notFilteredPos.sub( 0, 0.5f, 0 );
                AshleySubs.createDustFX( notFilteredPos, 0.72f, GameColor.WHITEGL );
            }
        }
    }


    public static void startJump () {
        jump = true;
        jumpDelayCounter = JUMP_DELAY;
        canJump = false;
    }


    public static void startAttack () {
        attack = true;
        attackDelayCounter = ATTACK_DELAY;
        canAttack = false;
    }


    public static void move ( float x, float y ) {
        direction.set( x, y );
        moveY = y;
    }


    public static void dispose () {
        if ( bag != null ) {
            bag.clear();
        }
        bag = null;
        modelInstance = null;

        modelAsset = null;
        playerEntity = null;

        if ( walk != null ) {
            walk.stop();
        }
        walk = null;

        playerBody = null;
        rightArmNode = null;
        weaponEntity = null;
        itemInHand = null;
        weaponInstance = null;
    }


    public static void clearAll () {
        if ( bag != null ) {
            bag.clear();
        }
        bag = null;

        weaponEntity = null;
        itemInHand = null;

        if ( weaponInstance != null ) {
            weaponInstance.nodes.get( 0 ).detach();
        }
        weaponInstance = null;

        playerEntity = null;

        stopSound();

        playerBody = null;
        rightArmNode = null;

        v2Position.set( 0, 0 );

        live = true;
    }


    public static Vector2 getPosition () {
        return v2Position;
    }


    public static btRigidBody getBody () {
        return playerBody;
    }


    private static float speedUpTime       = -0.1f;
    private static Label speedUpTimerLabel = null;

    private static float jumpUpTime       = -0.1f;
    private static Label jumpUpTimerLabel = null;


    public static void useItemInBag ( ItemInBagg item ) {
        if ( item.item.isWeapon() ) {
            if ( weaponInstance != null ) {
                // attach in AshleySubs, detach here
                weaponInstance.nodes.get( 0 ).detach();
            }

            if ( itemInHand != null ) {
                bag.add( itemInHand );
            }

            if ( weaponEntity != null ) {
                weaponEntity.add( new RemoveByTimeComponent( 0 ) );
                weaponEntity = null;
            }

            itemInHand = item;
            bag.remove( item );
            SoundAsset.EQUIP.play();

            // EQUIP weapon (attach in AshleySubs, detach here)
            weaponInstance = item.item.getModelAsset().get();
            weaponEntity = AshleySubs.createHandWeapon( weaponInstance,
                                                        rightArmNode,
                                                        bodyTransform );

            switch ( item.item ) {
                case PILLOW_WEAPON:
                    damage = 10;
                    break;
                case GUN_WEAPON:
                    damage = 120;
                    break;
                case KALASH_WEAPON:
                    damage = 110;
                    break;
                case FENCE_WEAPON:
                    damage = 150;
                    break;
                case BROOM_WEAPON:
                    damage = 35;
                    break;
                case RAKE_WEAPON:
                    damage = 60;
                    break;
            }
            return;
        }

        if ( item.count < 2 ) {
            bag.remove( item );
        } else {
            item.count -= 1;
        }
        SoundAsset.OPENBOTTLE.play();

        // USE item, not weapon
        switch ( item.item ) {
            case GREEN_BOTTLE:
                speedUpTime = 15.0f;
                if ( speedUpTimerLabel != null ) {
                    speedUpTimerLabel.clear();
                    speedUpTimerLabel = null;
                }
                speedUpTimerLabel = AshleySubs.createTopTimer( item.item, 1 );
                break;

            case PURPLE_BOTTLE:
                jumpUpTime = 15.0f;
                if ( jumpUpTimerLabel != null ) {
                    jumpUpTimerLabel.clear();
                    jumpUpTimerLabel = null;
                }
                jumpUpTimerLabel = AshleySubs.createTopTimer( item.item, 2 );
                break;

            case RED_BOTTLE:
                MyMapper.LIFE.get( playerEntity ).decLife( 0 );
                MyMapper.LIFE.get( playerEntity ).life = 100;
                AshleySubs.createRaiseRedFX( notFilteredPos );
                break;
        }
    }


    public static void stopSound () {
        if ( walk != null ) {
            walk.setVolume( 0.0f );
            walk.stop();
        }
    }
}
