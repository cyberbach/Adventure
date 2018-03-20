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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject.CollisionFlags;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TypeOfComponent;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.ItemInBagg;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.Settings;
import net.overmy.adventure.resources.SoundAsset;

import java.util.ArrayList;

public final class MyPlayer {
    private static final Vector2    v2Position     = new Vector2();
    private static final Vector2    direction      = new Vector2();
    private static final Vector3    velocity       = new Vector3();
    private static       Matrix4    bodyTransform  = new Matrix4();
    private static final Vector3    notFilteredPos = new Vector3();
    private static final Vector3    filteredPos    = new Vector3();
    private static       ModelAsset modelAsset     = null;
    private static       Entity     playerEntity   = null;
    private static       boolean    jump           = false;
    private static       boolean    attack         = false;
    private static       float      modelAngle     = 0.0f;
    private static       float      dustTime       = 0.1f;

    private static boolean weaponInHand = false;

    private static Node rightArmNode = null;

    private static ArrayList< ItemInBagg > bag         = null;
    public static  float                   damage      = 5.0f;
    public static  float                   extraJump   = 0.0f;
    public static  float                   extraSpeed2 = 0.0f;


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

        modelAsset.build();

        ModelInstance modelInstance = modelAsset.get();

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

        /////// create empty weapon

        PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .defaultMotionState()
                .zeroMass()
                .boxShape( 0.2f )
                .setCollisionFlag( btCollisionObject.CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                .setCallbackFilter( BulletWorld.ALL_FLAG )
                .disableDeactivation();

        entityWeaponInHand = AshleyWorld.getPooledEngine().createEntity();
        entityWeaponInHand.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
        entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
        entityWeaponInHand.add( physicalBuilder.buildPhysicalComponent() );
        AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );
    }


    public static void updateControls ( float deltaTime ) {

        if ( Gdx.input.isKeyJustPressed( Input.Keys.SPACE ) ) {
            startJump();
        }

        updateAnimation( deltaTime );

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;

        // Двигаем или останавливаем физическое тело
        velocity.set( direction.x, 0 + extraJump, direction.y );
        extraJump = 0.0f;
        velocity.scl( speed );
        if ( !onLadder ) {
            velocity.add( 0, playerBody.getLinearVelocity().y, 0 );
        } else {
            velocity.add( 0, -moveY * 5, 0 );
        }

        playerBody.setLinearVelocity( velocity );

        if ( jump && !attack ) {
            if ( playerOnGround ) {
                final float jumpSpeed = 148.0f;
                velocity.set( direction.x, jumpSpeed, direction.y );
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

        if ( attack ) {
            final int HIT = 2;
            final AnimationComponent animationComponent = MyMapper.ANIMATION.get(
                    playerEntity );
            animationComponent.play( HIT, 2.4f );
            attack = false;

            isAttacking = true;
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

        final AnimationComponent animationComponent = MyMapper.ANIMATION.get( playerEntity );
        final String ID_CURRENT = animationComponent.getID();
        final String ID_ATTACK = "ATTACK";
        final String ID_RUN = "RUN";
        final String ID_IDLE = "IDLE";

        final boolean playerOnGround = MyMapper.GROUNDED.get( playerEntity ).grounded;
        final boolean playerInIDLE = ID_IDLE.equals( ID_CURRENT );
        final boolean playerIsRunning = ID_RUN.equals( ID_CURRENT );
        final boolean playerHitSomething = ID_ATTACK.equals( ID_CURRENT );
//        final boolean playerJump = ID_JUMP.equals( ID_CURRENT );

        final int IDLE = 0;
        final int RUN = 1;

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
            int textSpeed = (int) speedUpTime + 1;
            speedUpTimerLabel.setText( "" + textSpeed );
            GlyphLayout layout = speedUpTimerLabel.getGlyphLayout();
            int iconSize = (int) ( Core.HEIGHT * 0.1f );
            speedUpTimerLabel.setPosition(
                    Core.WIDTH - iconSize * 2.5f - layout.width / 2,
                    Core.HEIGHT - iconSize * 1.5f - layout.height );
            extraSpeed = 5.0f;
        }

        final float directionLen = direction.len();
        // Мы управляем персонажем джойстиком
        if ( directionLen != 0 ) {
            // Персонаж на земле
            if ( playerOnGround ) {
                final float animationSpeed = 3.0f + 2.0f * directionLen;
                if ( !playerHitSomething ) {
                    if ( playerIsRunning ) {
                        animationComponent.queue( RUN, animationSpeed );
                    } else {
                        animationComponent.play( RUN, animationSpeed );
                        isAttacking = false;
                    }
                }
            }
            // Персонаж в воздухе
            else {
                if ( !playerHitSomething ) {
                    if ( playerInIDLE ) {
                        animationComponent.queue( IDLE, 2.0f );
                    } else {
                        animationComponent.play( IDLE, 2.0f );
                        isAttacking = false;
                    }
                }
            }
            final float runSpeed = 5.0f + extraSpeed2;
            speed = ( runSpeed + extraSpeed ) * directionLen;

            direction.nor();
            direction.rotate( -MyCamera.getCameraAngle() );

            // Сохраняем угол для поворота модели
            modelAngle = 90 - direction.angle();

            // СОздаем пыль под ногами

            dustTime -= deltaTime;
            if ( dustTime < 0 ) {
                dustTime = MathUtils.random( 0.05f, 0.25f );
                //notFilteredPos.sub( 0, 0.5f, 0 );

                AshleySubs.createDustFX( notFilteredPos, dustTime );
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


    public static void startAttack () {
        attack = true;
    }

    //static Vector2 tmpDirection = new Vector2(  );


    public static void move ( float x, float y ) {
        direction.set( x, y );
        moveY = y;
    }


    public static void dispose () {
        if ( bag != null ) {
            bag.clear();
        }
        bag = null;

        modelAsset = null;
        playerEntity = null;

        if ( walk != null ) {
            walk.stop();
        }
        walk = null;

        playerBody = null;
        rightArmNode = null;
    }


    public static Vector2 getPosition () {
        return v2Position;
    }


    public static btRigidBody getBody () {
        return playerBody;
    }


    private static float speedUpTime = 0.0f;

    private static Label speedUpTimerLabel = null;


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

            if(entityWeaponInHand!=null){
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

                speedUpTimerLabel = AshleySubs.createSpeedUpTimer( item.item );

                break;

            case KALASH_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.KALASH_WEAPON3.get();
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
                entityWeaponInHand.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderWEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 110;

                break;

            case FENCE_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.FENCE_WEAPON4.get();
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
                entityWeaponInHand.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderBORDER_WEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 150;

                break;

            case BROOM_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.BROOM_WEAPON1.get();
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
                entityWeaponInHand.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderBROOM_WEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 35;

                break;

            case RAKE_WEAPON:
                // create weapon in ashley
                modelInstanceWeaponInHand = ModelAsset.RAKE_WEAPON2.get();
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
                entityWeaponInHand.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
                entityWeaponInHand.add( new MyWeaponComponent( rightArmNode, bodyTransform ) );
                entityWeaponInHand.add( physicalBuilderSwordWEAPON.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityWeaponInHand );

                weaponInHand = true;
                damage = 60;

                break;
        }
    }
}
