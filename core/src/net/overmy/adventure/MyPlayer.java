package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
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
    //private static final Vector3 filteredPos    = new Vector3();
    private static       float   modelAngle     = 0.0f;

    private static float dustTimer = 0.1f;

    public static boolean live = true;

    private static ModelAsset    modelAsset    = null;
    private static Entity        playerEntity  = null;
    public static  ModelInstance modelInstance = null; // for menu screen

    private static boolean weaponInHand = false;
    private static Node    rightArmNode = null;
    public static  float   damage       = 5.0f;

    private static ArrayList< ItemInBagg > bag = null;

    private static boolean attack      = false;
    private static boolean jump        = false;
    public static  float   extraJump   = 0.0f;
    public static  float   extraSpeed2 = 0.0f;


    public static ArrayList< ItemInBagg > getBag () {
        return bag;
    }


    private static float moveY = 0.0f;

    private static float speed;

    public static  boolean    onLadder = false;
    private static SoundAsset walk     = null;

    private static btRigidBody playerBody = null;


    private static ModelInstance modelInstanceWeaponInHand = null;
    private static Entity        entityWeaponInHand        = null;
    private static ItemInBagg    itemInHand                = null;

    public static boolean isAttacking = false;


    private MyPlayer () {
    }


    public static void load () {
        int n = ModelAsset.PLAYER01.ordinal() + Settings.PLAYER_MODEL.getInteger();
        modelAsset = ModelAsset.values()[ n ];

        modelAsset.load();

        //Gdx.app.debug( "" + modelAsset.toString(), "n of model " + n );
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
                .boxShape( 0.2f )
                .setCollisionFlag( btCollisionObject.CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                .setCallbackFilter( BulletWorld.ALL_FLAG )
                .disableDeactivation();

        entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
        entityWeaponInHand.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
        entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
        entityWeaponInHand.add( physicalBuilder.buildPhysicalComponent() );
        AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

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
            new Vector3( -111.20825f, 2.5875528f, -439.92386f ),
            new Vector3( -143.16548f, -2.9934058f, -463.16727f ),
            };


    public static void updateControls ( float deltaTime ) {

        if ( !live ) {
            return;
        }

        if ( Gdx.input.isKeyJustPressed( Input.Keys.SPACE ) ) {
            startJump();
        }

        updateAnimation( deltaTime );

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;

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

                final int JUMP = 3;
                final AnimationComponent animationComponent = MyMapper.ANIMATION.get(
                        playerEntity );
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

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;
        final boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        final boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );
        final boolean playerIsAttacking = ID_ATTACK.equals( ID_CURRENT );
//        final boolean playerJump = ID_JUMP.equals( ID_CURRENT );

        final int IDLE = 0;
        final int RUN = 1;
        final int ATTACK = 2;

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

        speedUpTime -= deltaTime;
        float extraSpeed = 0.0f;
        if ( speedUpTime > 0 ) {
            int textOfTimer = (int) speedUpTime + 1;
            speedUpTimerLabel.setText( "" + textOfTimer );
            GlyphLayout layout = speedUpTimerLabel.getGlyphLayout();
            int iconSize = (int) ( Core.HEIGHT * 0.1f );
            speedUpTimerLabel.setPosition( -layout.width / 2, -layout.height / 2 - iconSize / 2 );
            extraSpeed = 5.0f;
        }

        jumpUpTime -= deltaTime;
        if ( jumpUpTime > 0 ) {
            int textOfTimer = (int) jumpUpTime + 1;
            jumpUpTimerLabel.setText( "" + textOfTimer );
            GlyphLayout layout = jumpUpTimerLabel.getGlyphLayout();
            int iconSize = (int) ( Core.HEIGHT * 0.1f );
            jumpUpTimerLabel.setPosition( -layout.width / 2, -layout.height / 2 - iconSize / 2 );
            extraJump = 150.0f;
        } else {
            extraJump = 0.0f;
        }


        if ( attack ) {
            animationComponent.play( ATTACK, 2.4f );
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
                if ( !playerIsAttacking ) {
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
                if ( !playerIsAttacking ) {
                    isAttacking = false;
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                    }
                }else{
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

            dustTimer -= deltaTime;
            if ( dustTimer < 0 ) {
                //dustTimer = MathUtils.random( 0.05f, 0.25f );
                dustTimer = 0.14f;
                notFilteredPos.sub( 0, 0.5f, 0 );

                AshleySubs.createDustFX( notFilteredPos, 0.72f );
            }
        }
        // Мы не управляем персонажем джойстиком
        else {
            // Персонаж на земле
            if ( playerOnGround ) {
                if ( !playerIsAttacking ) {
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                    }
                }
            }else{
                animationComponent.queue( IDLE, 2.0f );
            }
            speed = 0.0f;
        }
    }


    public static void startJump () {
        jump = true;
    }


    public static void startAttack () {
        attack = true;
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
        entityWeaponInHand = null;
        itemInHand = null;
        modelInstanceWeaponInHand = null;
    }


    public static void clearAll () {
        if ( bag != null ) {
            bag.clear();
        }
        bag = null;

        entityWeaponInHand = null;
        itemInHand = null;

        if ( modelInstanceWeaponInHand != null ) {
            modelInstanceWeaponInHand.nodes.get( 0 ).detach();
        }
        modelInstanceWeaponInHand = null;

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


    private static float speedUpTime       = 0.0f;
    private static Label speedUpTimerLabel = null;

    private static float jumpUpTime       = 0.0f;
    private static Label jumpUpTimerLabel = null;


    public static void useItemInBag ( ItemInBagg item ) {

        boolean broomIsItem = item.item.equals( Item.BROOM_WEAPON );
        boolean kalashIsItem = item.item.equals( Item.KALASH_WEAPON );
        boolean rakeIsItem = item.item.equals( Item.RAKE_WEAPON );
        boolean fenceIsItem = item.item.equals( Item.FENCE_WEAPON );

        if ( broomIsItem || kalashIsItem || rakeIsItem || fenceIsItem ) {
            if ( weaponInHand ) {
                if ( modelInstanceWeaponInHand != null ) {
                    modelInstanceWeaponInHand.nodes.get( 0 ).detach();
                }

                if ( itemInHand != null ) {
                    bag.add( itemInHand );
                }
            }

            if ( entityWeaponInHand != null ) {
                entityWeaponInHand.add( new RemoveByTimeComponent( 0 ) );
                entityWeaponInHand = null;
            }

            itemInHand = item;
            bag.remove( item );
        } else {
            if ( item.count < 2 ) {
                bag.remove( item );
            } else {
                item.count -= 1;
            }
        }

        switch ( item.item ) {
            case GREEN_BOTTLE:
                speedUpTime = 15.0f;
                if ( speedUpTimerLabel != null ) {
                    speedUpTimerLabel.clear();
                    speedUpTimerLabel = null;
                }
                speedUpTimerLabel = AshleySubs.createTopTimer( item.item, 2 );
                break;

            case PURPLE_BOTTLE:
                jumpUpTime = 15.0f;
                if ( jumpUpTimerLabel != null ) {
                    jumpUpTimerLabel.clear();
                    jumpUpTimerLabel = null;
                }
                jumpUpTimerLabel = AshleySubs.createTopTimer( item.item, 3 );
                break;

            case RED_BOTTLE:
                MyMapper.LIFE.get( playerEntity ).life = 100;

                break;

            case KALASH_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.KALASH_WEAPON.get();
                // attach only model without physics
                modelInstanceWeaponInHand.nodes.get( 0 ).attachTo( rightArmNode );

                PhysicalBuilder physicalBuilderWEAPON = new PhysicalBuilder()
                        .setModelInstance( modelInstanceWeaponInHand );

                physicalBuilderWEAPON
                        .defaultMotionState()
                        .zeroMass()
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
                entityWeaponInHand.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderWEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 110;

                break;

            case FENCE_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.FENCE_WEAPON.get();
                // attach only model without physics
                modelInstanceWeaponInHand.nodes.get( 0 ).attachTo( rightArmNode );

                PhysicalBuilder physicalBuilderBORDER_WEAPON = new PhysicalBuilder()
                        .setModelInstance( modelInstanceWeaponInHand );

                physicalBuilderBORDER_WEAPON
                        .defaultMotionState()
                        .zeroMass()
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
                entityWeaponInHand.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderBORDER_WEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 150;

                break;

            case BROOM_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.BROOM_WEAPON.get();
                // attach only model without physics
                modelInstanceWeaponInHand.nodes.get( 0 ).attachTo( rightArmNode );

                PhysicalBuilder physicalBuilderBROOM_WEAPON = new PhysicalBuilder()
                        .setModelInstance( modelInstanceWeaponInHand );

                physicalBuilderBROOM_WEAPON
                        .defaultMotionState()
                        .zeroMass()
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
                entityWeaponInHand.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderBROOM_WEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 35;

                break;

            case RAKE_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.RAKE_WEAPON.get();
                // attach only model without physics
                modelInstanceWeaponInHand.nodes.get( 0 ).attachTo( rightArmNode );

                PhysicalBuilder physicalBuilderSwordWEAPON = new PhysicalBuilder()
                        .setModelInstance( modelInstanceWeaponInHand );

                physicalBuilderSwordWEAPON
                        .defaultMotionState()
                        .zeroMass()
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
                entityWeaponInHand.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderSwordWEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 60;

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
