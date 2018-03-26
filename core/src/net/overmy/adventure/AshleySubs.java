package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 17.03.2018
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject.CollisionFlags;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.ashley.DecalSubs;
import net.overmy.adventure.ashley.components.ActorComponent;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.BoundingComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_ENTITY;
import net.overmy.adventure.ashley.components.CollectableComponent;
import net.overmy.adventure.ashley.components.ContainerComponent;
import net.overmy.adventure.ashley.components.GroundedComponent;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.LevelIDComponent;
import net.overmy.adventure.ashley.components.LevelObjectComponent;
import net.overmy.adventure.ashley.components.LifeComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyAnimationComponent;
import net.overmy.adventure.ashley.components.MyPlayerComponent;
import net.overmy.adventure.logic.NPCAction;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;
import net.overmy.adventure.ashley.components.PositionComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.ashley.components.EntityTypeComponent;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.LevelObject;
import net.overmy.adventure.logic.TextInteract;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextureAsset;
import net.overmy.adventure.utils.UIHelper;

public final class AshleySubs {


    private static Engine engine = null;


    private AshleySubs () {
    }


    public static void init ( Engine engineIn ) {
        engine = engineIn;
    }


    protected static void dispose () {
        engine = null;
    }

    // GUI entities


    static Label createTopTimer ( Item item, int numberOfPosition ) {

        int iconSize = (int) ( Core.HEIGHT * 0.1f );
        float offset = iconSize * 1.5f * numberOfPosition;
        float x = Core.WIDTH - offset - iconSize * 1.5f;

        Group fullGroup = new Group();
        fullGroup.setPosition( x, Core.HEIGHT - iconSize );

        Image rotateImage = new Image( TextureAsset.CD.getSprite() );
        rotateImage.setSize( iconSize, iconSize );
        rotateImage.setOrigin( iconSize / 2, iconSize / 2 );
        rotateImage.addAction( Actions.forever(
                Actions.sequence(
                        Actions.rotateTo( 0, 0 ),
                        Actions.rotateTo( 360.0f, 2.0f )
                                )
                                              ) );
        rotateImage.setPosition( -iconSize/2,-iconSize );

        Image iconImage = item.getImage( iconSize, iconSize );
        iconImage.setOrigin( iconSize / 2, iconSize / 2 );
        iconImage.setPosition( -iconSize/2,0 );

        Label label = UIHelper.Label( "16", FontAsset.DIALOG_VARIANT );
        label.setPosition( -label.getWidth() / 2, -label.getHeight() / 2 - iconSize/2 );

        fullGroup.addActor( rotateImage );
        fullGroup.addActor( iconImage );
        fullGroup.addActor( label );

        // build

        Entity timerEntity = new Entity(); // engine.createEntity();
        timerEntity.add( new ActorComponent( fullGroup ) );
        timerEntity.add( new RemoveByTimeComponent( 15 ) );
        engine.addEntity( timerEntity );

        return label;
    }


    public static void createText ( String myText ) {
        Label text = UIHelper.Label( myText, FontAsset.IVENTORY_ITEM );
        text.setAlignment( Align.center );
        text.setWrap( true );

        Group textGroup = UIHelper.convertActorToGroup( text );
        textGroup.setPosition( Core.WIDTH_HALF, Core.HEIGHT * 0.8f );
        textGroup.setScale( 0, 0 );
        UIHelper.scaleIn( textGroup );

        Entity timerEntity = new Entity(); // engine.createEntity();
        timerEntity.add( new ActorComponent( textGroup ) );
        timerEntity.add( new RemoveByTimeComponent( 5 ) );
        engine.addEntity( timerEntity );
    }


    static void addItemToBad ( Item item ) {
        int iconSize = (int) ( Core.HEIGHT * 0.1f );
        /*
        iconImage2.setSize( iconSize, iconSize );
        iconImage2.setOrigin( iconSize / 2, iconSize / 2 );
        iconImage2.setPosition( Core.WIDTH - iconSize * 3.0f, Core.HEIGHT - iconSize );
        iconImage2.addAction( Actions.forever(
                Actions.sequence(
                        Actions.rotateTo( 0, 0 ),
                        Actions.rotateTo( 360.0f, 2.0f )
                                )
                                             ) );*/

        Image iconImage = item.getImage( iconSize, iconSize );
        iconImage.setSize( iconSize, iconSize );
        //iconImage.setPosition( Core.WIDTH - iconSize * 3.0f, Core.HEIGHT - iconSize );
        UIHelper.roller( iconImage,
                         Core.WIDTH_HALF - iconSize / 2, Core.HEIGHT_HALF - iconSize / 2,
                         Core.WIDTH - iconSize * 1.5f, Core.HEIGHT - iconSize * 1.5f );
        //iconImage.addAction( Actions.rotateTo( 360,Core.FADE ) );

        ActorComponent actorComponent = new ActorComponent();
        actorComponent.group.addActor( iconImage );
        actorComponent.group.setPosition( 0, 0 );

        Entity timerEntity = new Entity(); // engine.createEntity();
        timerEntity.add( actorComponent );
        timerEntity.add( new RemoveByTimeComponent( Core.FADE * 2.0f ) );
        engine.addEntity( timerEntity );
    }

    // Game Entities


    static Entity createPlayer ( ModelInstance modelInstance ) {
        modelInstance.transform.setToTranslation( new Vector3( 0, 3, 0 ) );

        modelInstance.materials.get( 0 ).clear();
        //modelInstance.materials.get( 0 ).set( TextureAttribute.createDiffuse( region ) );
        modelInstance.materials.get( 0 )
                               .set( ColorAttribute.createDiffuse( GameColor.SQUIREL.get() ) );

        PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .setModelInstance( modelInstance )
                .defaultMotionState()
                .setMass( 20.0f )
                //.capsuleShape( 0.5f, 0.2f )
                .capsuleShape()
                .setCollisionFlag( btCollisionObject.CollisionFlags.CF_CHARACTER_OBJECT )
                .setCallbackFlag( BulletWorld.PLAYER_FLAG )
                .setCallbackFilter( BulletWorld.FILTER_ALL )
                .disableDeactivation();

        PhysicalComponent physicalComponent = physicalBuilder.buildPhysicalComponent();
        physicalComponent.body.setFriction( 0.1f );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( physicalComponent );
        entity.add( new ModelComponent( modelInstance ) );
        entity.add( new AnimationComponent( modelInstance ) );
        entity.add( new GroundedComponent() );
        entity.add( new LifeComponent( 100.0f, 1, 2 ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.MYPLAYER ) );
        entity.add( new MyPlayerComponent() );

        engine.addEntity( entity );
        return entity;
    }


    public static Entity createGround ( ModelAsset zoneModel ) {
        ModelInstance physics = zoneModel.getSimple();
        PhysicalBuilder physicalBuilder = null;
        if ( physics != null ) {
            physicalBuilder = new PhysicalBuilder()
                    .setModelInstance( physics )
                    .defaultMotionState()
                    .zeroMass()
                    .bvhShape()
                    .setCollisionFlag( CollisionFlags.CF_STATIC_OBJECT )
                    .setCallbackFlag( BulletWorld.GROUND_FLAG )
                    .setCallbackFilter( BulletWorld.FILTER_ALL );
        }

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new LevelIDComponent( zoneModel.ordinal() ) );
        entity.add( new ModelComponent( zoneModel.get() ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.GROUND ) );
        if ( physics != null ) {
            entity.add( physicalBuilder.buildPhysicalComponent() );
            entity.add( physicalBuilder.buildBVHPhysicalComponent() );
        }
        entity.add( new BoundingComponent( zoneModel.getBoundingBox() ) );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createLadder ( Vector3 position, float height ) {

        PhysicalBuilder physicalBuilderLADDER = new PhysicalBuilder()
                .defaultMotionState()
                .zeroMass()
                .cylinderShape( 0.5f, height )
                .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.LADDER_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG )
                .setPosition( position );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( physicalBuilderLADDER.buildPhysicalComponent() );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.LADDER ) );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createPickable ( Vector3 position,
                                          Item item,
                                          ModelAsset modelAsset,
                                          LevelObject object ) {
        ModelInstance modelInstancePICKABLE = modelAsset.get();
        modelInstancePICKABLE.transform.setToTranslation( position );

        PhysicalBuilder physicalBuilderPICKABLE = new PhysicalBuilder()
                .setModelInstance( modelInstancePICKABLE )
                .defaultMotionState()
                .setMass( 1.0f )
                .hullShape()
                .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                .setCallbackFlag( BulletWorld.PICKABLE_FLAG )
                .setCallbackFilter( BulletWorld.GROUND_FLAG | BulletWorld.PLAYER_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        if ( modelInstancePICKABLE.animations.size > 0 ) {
            entity.add( new AnimationComponent( modelInstancePICKABLE ) );
        }
        entity.add( new MyAnimationComponent() );
        entity.add( new ModelComponent( modelInstancePICKABLE ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.PICKABLE ) );
        entity.add( new InteractComponent( TYPE_OF_INTERACT.LOOT, item ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalBuilderPICKABLE.buildPhysicalComponent() );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createCollectable ( Vector3 position,
                                             Item item,
                                             ModelAsset modelAsset,
                                             LevelObject object ) {
        ModelInstance modelInstanceCOLLECTABLE = modelAsset.get();
        modelInstanceCOLLECTABLE.transform.setToTranslation( position );

        PhysicalBuilder physicalBuilderCOLLECTABLE = new PhysicalBuilder()
                .setModelInstance( modelInstanceCOLLECTABLE )
                .defaultMotionState()
                .setMass( 1.0f )
                .boxShape()
                .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new ModelComponent( modelInstanceCOLLECTABLE ) );
        if ( modelInstanceCOLLECTABLE.animations.size > 0 ) {
            entity.add( new AnimationComponent( modelInstanceCOLLECTABLE ) );
        }
        entity.add( new MyAnimationComponent() );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.COLLECTABLE ) );
        entity.add( new CollectableComponent( item ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalBuilderCOLLECTABLE.buildPhysicalComponent() );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createHoverCollectable ( Vector3 position,
                                                  Item item,
                                                  ModelAsset modelAsset,
                                                  LevelObject object ) {

        //Gdx.app.debug( "",""+item.getModelAsset() );

        ModelInstance modelInstanceHOVER_COLLECTABLE = modelAsset.get();
        //Gdx.app.debug( "",""+modelInstanceHOVER_COLLECTABLE );
        ///Gdx.app.debug( "",""+position );
        modelInstanceHOVER_COLLECTABLE.transform.setToTranslation( position );

/*

                TextureRegion region3 = IMG.BOX_TEXTURE.getRegion();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).clear();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).set( TextureAttribute.createDiffuse( region3 ) );
*/

        PhysicalBuilder physicalBuilderHOVER_COLLECTABLE = new PhysicalBuilder()
                .setModelInstance( modelInstanceHOVER_COLLECTABLE )
                .defaultMotionState()
                .zeroMass()
                .boxShape()
                .setCollisionFlag( CollisionFlags.CF_KINEMATIC_OBJECT )
                .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        if ( modelInstanceHOVER_COLLECTABLE.animations.size > 0 ) {
            entity.add( new AnimationComponent( modelInstanceHOVER_COLLECTABLE ) );
        }
        entity.add( new ModelComponent( modelInstanceHOVER_COLLECTABLE ) );
        entity.add( new MyAnimationComponent() );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.COLLECTABLE ) );
        entity.add( new CollectableComponent( item ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalBuilderHOVER_COLLECTABLE.buildPhysicalComponent() );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createNPC ( Vector3 position,
                                     ModelAsset modelAsset,
                                     TextInteract textInteract,
                                     Array< NPCAction > actionArray ) {
        ModelInstance modelInstanceNPC = modelAsset.get();
        modelInstanceNPC.transform.setToTranslation( position );

        if ( modelAsset.equals( ModelAsset.HOG ) ) {
            modelInstanceNPC.materials.get( 0 ).clear();
            modelInstanceNPC.materials.get( 0 )
                                      .set( ColorAttribute.createDiffuse(
                                              GameColor.HOG.get() ) );
        }

        if ( modelAsset.equals( ModelAsset.FOX ) ) {
            modelInstanceNPC.materials.get( 0 ).clear();
            modelInstanceNPC.materials.get( 0 )
                                      .set( ColorAttribute.createDiffuse(
                                              GameColor.FOX.get() ) );
        }

        PhysicalBuilder physicalBuilderNPC = new PhysicalBuilder()
                .setModelInstance( modelInstanceNPC )
                .defaultMotionState()
                .setMass( 60.0f )
                .capsuleShape()
                .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                .setCallbackFlag( BulletWorld.NPC_FLAG )
                .setCallbackFilter(
                        BulletWorld.GROUND_FLAG | BulletWorld.NPC_FLAG | BulletWorld.PLAYER_FLAG )
                .disableDeactivation();

        PhysicalComponent physicalComponent = physicalBuilderNPC.buildPhysicalComponent();
        physicalComponent.body.setRollingFriction( 0.1f );
        physicalComponent.body.setFriction( 0.1f );
        physicalComponent.body.setSpinningFriction( 0.1f );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new ModelComponent( modelInstanceNPC ) );
        entity.add( new AnimationComponent( modelInstanceNPC ) );
        if ( textInteract != null ) {
            entity.add( new InteractComponent( TYPE_OF_INTERACT.TALK, textInteract ) );
        }
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.NPC ) );
        entity.add( new NPCComponent( actionArray ) );
        entity.add( physicalComponent );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createEnemy ( Vector3 position,
                                       ModelAsset modelAsset,
                                       Array< NPCAction > actionArray,
                                       LevelObject object ) {
        ModelInstance modelInstanceENEMY = modelAsset.get();
        modelInstanceENEMY.transform.setToTranslation( position );

        PhysicalBuilder physicalBuilderENEMY = new PhysicalBuilder()
                .setModelInstance( modelInstanceENEMY )
                .defaultMotionState()
                .setMass( 60.0f )
                .capsuleShape()
                .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                .setCallbackFlag( BulletWorld.NPC_FLAG )
                .setCallbackFilter(BulletWorld.FILTER_ENEMY )
                .disableDeactivation();

        float damage = 1.0f;
        switch ( modelAsset ) {
            case CRAB:
                physicalBuilderENEMY.capsuleShape( 0.5f, 0.15f );
                damage = 20.0f;
                break;
            case STAR:
                physicalBuilderENEMY.capsuleShape();
                damage = 10.0f;
                break;
            default:
                physicalBuilderENEMY.capsuleShape();
                break;
        }

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new ModelComponent( modelInstanceENEMY ) );
        entity.add( new AnimationComponent( modelInstanceENEMY ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.NPC ) );
        entity.add( new NPCComponent( actionArray, damage ) );
        entity.add( physicalBuilderENEMY.buildPhysicalComponent() );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( new LifeComponent( 100, 1.5f, 2.0f ) );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createWeapon ( Vector3 position,
                                        Item item,
                                        LevelObject object ) {
        ModelInstance modelInstanceWEAPON = item.getModelAsset().get();
        modelInstanceWEAPON.transform.setToTranslation( position );

        PhysicalBuilder physicalBuilderWEAPON = new PhysicalBuilder()
                .setModelInstance( modelInstanceWEAPON )
                .defaultMotionState()
                .setMass( 3.0f )
                .hullShape()
                .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                .setCallbackFilter( BulletWorld.NPC_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new ModelComponent( modelInstanceWEAPON ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.WEAPON ) );
        entity.add( new InteractComponent( TYPE_OF_INTERACT.LOOT, item ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalBuilderWEAPON.buildPhysicalComponent() );
        engine.addEntity( entity );

        return entity;
    }


    public static void createGift ( Vector3 position, Item item ) {
        ModelInstance modelInstanceFromBox = ModelAsset.GIFT.get();
        //modelInstanceFromBox.transform.setToTranslation( position );

        PhysicalBuilder physicalBuilderFromBox = new PhysicalBuilder()
                .setModelInstance( modelInstanceFromBox )
                .defaultMotionState()
                .setPosition( position )
                .setMass( 5.0f )
                .boxShape()
                .setCollisionFlag( btCollisionObject.CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG );

        Entity entityFromBox = new Entity(); // engine.createEntity();
        entityFromBox.add( new ModelComponent( modelInstanceFromBox ) );
        entityFromBox.add( new MyAnimationComponent() );
        entityFromBox.add( new EntityTypeComponent( TYPE_OF_ENTITY.COLLECTABLE ) );
        entityFromBox.add( new CollectableComponent( item ) );
        entityFromBox.add( physicalBuilderFromBox.buildPhysicalComponent() );
        engine.addEntity( entityFromBox );
    }


    public static Entity createCrate ( Vector3 position,
                                       ModelAsset modelAsset,
                                       Item item,
                                       LevelObject object ) {
        ModelInstance modelInstance = modelAsset.get();
/*

                TextureRegion region = IMG.BOX_TEXTURE.getRegion();
                modelInstanceBOX.materials.get( 0 ).clear();
                modelInstanceBOX.materials.get( 0 ).set( TextureAttribute.createDiffuse( region ) );
*/

        PhysicalBuilder physicalBuilderBOX = new PhysicalBuilder()
                .setModelInstance( modelInstance )
                .defaultMotionState()
                .setPosition( position )
                .setMass( 20.0f )
                .boxShape()
                .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                .setCallbackFlag( BulletWorld.DESTROYABLE_FLAG )
                .setCallbackFilter( BulletWorld.MYWEAPON_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        if ( modelInstance.animations.size > 0 ) {
            entity.add( new AnimationComponent( modelInstance ) );
        }
        entity.add( new LifeComponent( 20.0f, 0.8f, 1.0f ) );
        if ( item != null ) {
            entity.add( new ContainerComponent( item ) );
        }
        entity.add( new ModelComponent( modelInstance ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.DESTROYABLE_BOX ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalBuilderBOX.buildPhysicalComponent() );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createRock ( Vector3 position, ModelAsset modelAsset,
                                      LevelObject object ) {
        ModelInstance modelInstance = modelAsset.get();

        PhysicalBuilder physicalBuilderBOX = new PhysicalBuilder()
                .setModelInstance( modelInstance )
                .defaultMotionState()
                .setPosition( position )
                //.setMass(1500)
                .zeroMass()
                .hullShape()
                .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.DESTROYABLE_FLAG )
                .setCallbackFilter( BulletWorld.MYWEAPON_FLAG )
                .disableDeactivation();

        PhysicalComponent physicalComponent = physicalBuilderBOX.buildPhysicalComponent();
        //physicalComponent.body.setFriction( 100.0f );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new LifeComponent( 300.0f, 1.5f, 1.0f ) );
        entity.add( new ModelComponent( modelInstance ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.DESTROYABLE_ROCK ) );
        entity.add( new LevelObjectComponent( object ) );
        entity.add( physicalComponent );
        engine.addEntity( entity );

        return entity;
    }

    // FX entities

    private static Vector3 randomPosition = new Vector3();
    private static Vector3 partPosition   = new Vector3();


    public static void createCrateParts ( Vector3 position ) {
        int parts = MathUtils.random( 3, 7 );
        for ( int i = 0; i < parts; i++ ) {
            float timeOfLife = MathUtils.random( 1.0f, 2.0f );

            randomPosition.x = MathUtils.random( -1.0f, 1.0f );
            randomPosition.y = MathUtils.random( -1.0f, 1.0f );
            randomPosition.z = MathUtils.random( -1.0f, 1.0f );

            partPosition.set( position );
            partPosition.add( randomPosition ).add( 0, 0.5f, 0 );

            ModelInstance modelInstance = ModelAsset.CRATE_PART.get();
            float scale = MathUtils.random( 0.3f, 1.0f );
            modelInstance.transform.scl( scale, scale, scale );

            randomPosition.scl( 0.6f );

            PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                    .setModelInstance( modelInstance )
                    .defaultMotionState()
                    .setMass( 0.1f )
                    .setRotation( MathUtils.random( 360.0f ),
                                  MathUtils.random( 360.0f ),
                                  MathUtils.random( 360.0f ) )
                    .setPosition( partPosition )
                    .setScale( MathUtils.random( 0.4f, 1.0f ) )
                    .boxShape()
                    .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                    .setCallbackFlag( BulletWorld.PART_FLAG )
                    .setStartImpulse( randomPosition )
                    .setCallbackFilter( 0 );

            Entity partEntity = new Entity(); // engine.createEntity();
            partEntity.add( new ModelComponent( modelInstance ) );
            partEntity.add( new RemoveByTimeComponent( timeOfLife ) );
            partEntity.add( physicalBuilder.buildPhysicalComponent() );
            engine.addEntity( partEntity );

            SoundAsset.BoxCrush.play();
        }
    }


    public static void createDustFX ( Vector3 position, float timeToRemove ) {
        Entity entity = new Entity(); // engine.createEntity();
        entity.add( DecalSubs.LightDustEffect( timeToRemove ) );
        entity.add( new PositionComponent( position ) );
        entity.add( new RemoveByTimeComponent( timeToRemove ) );
        engine.addEntity( entity );
    }


    public static void create5StarsFX ( Vector3 position ) {
        for ( int i = 0; i < 4; i++ ) {
            float fxTime = MathUtils.random( 0.25f, 0.65f );
            Entity entity = new Entity(); // engine.createEntity();
            entity.add( DecalSubs.StarsEffect( fxTime ) );
            entity.add( new PositionComponent( position ) );
            entity.add( new RemoveByTimeComponent( fxTime ) );
            engine.addEntity( entity );
        }
    }


    public static void create5coinsFX ( Vector3 position ) {
        for ( int i = 0; i < 5; i++ ) {
            float fxTime = MathUtils.random( 0.25f, 0.65f );
            Entity entity = new Entity(); // engine.createEntity();
            entity.add( DecalSubs.CoinEffect( fxTime ) );
            entity.add( new PositionComponent( position ) );
            entity.add( new RemoveByTimeComponent( fxTime ) );
            engine.addEntity( entity );
        }
    }


    public static void create5greenBubblesFX ( Vector3 position ) {
        for ( int i = 0; i < 5; i++ ) {
            float bubbleTime = MathUtils.random( 0.25f, 0.65f );
            Entity entity = new Entity(); // engine.createEntity();
            entity.add( DecalSubs.GreenBubbleEffect( bubbleTime ) );
            entity.add( new PositionComponent( position ) );
            entity.add( new RemoveByTimeComponent( bubbleTime ) );
            engine.addEntity( entity );
        }
    }


    public static void create5redBubblesFX ( Vector3 position ) {
        for ( int i = 0; i < 5; i++ ) {
            float bubbleTime = MathUtils.random( 0.25f, 0.65f );
            Entity entity = new Entity(); // engine.createEntity();
            entity.add( DecalSubs.RedBubbleEffect( bubbleTime ) );
            entity.add( new PositionComponent( position ) );
            entity.add( new RemoveByTimeComponent( bubbleTime ) );
            engine.addEntity( entity );
        }
    }


    public static void createCloudFX () {
        float fxTime = MathUtils.random( 25.25f, 35.65f );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( DecalSubs.CloudEffect( MyPlayer.getPosition().x,
                                           MyPlayer.getPosition().y,
                                           fxTime ) );
        entity.add( new PositionComponent( new Vector3() ) );
        entity.add( new RemoveByTimeComponent( fxTime ) );
        engine.addEntity( entity );
    }


    public static void createRockParts ( Vector3 position ) {
        int parts = MathUtils.random( 4, 10 );
        for ( int i = 0; i < parts; i++ ) {
            float timeOfLife = MathUtils.random( 1.0f, 2.0f );

            randomPosition.x = MathUtils.random( -1.0f, 1.0f );
            randomPosition.y = MathUtils.random( -1.0f, 1.0f );
            randomPosition.z = MathUtils.random( -1.0f, 1.0f );

            partPosition.set( position );
            partPosition.add( randomPosition ).add( 0, 0.5f, 0 );

            float scale = MathUtils.random( 0.3f, 1.0f );

            ModelInstance modelInstance = ModelAsset.ROCK_PART.get();
            modelInstance.transform.scl( scale, scale, scale );

            randomPosition.scl( 0.6f );

            PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                    .setModelInstance( modelInstance )
                    .defaultMotionState()
                    .setMass( 0.1f )
                    .setRotation( MathUtils.random( 360.0f ),
                                  MathUtils.random( 360.0f ),
                                  MathUtils.random( 360.0f ) )
                    .setScale( scale )
                    .setPosition( partPosition )
                    .hullShape()
                    .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                    .setCallbackFlag( BulletWorld.PART_FLAG )
                    .setStartImpulse( randomPosition )
                    .setCallbackFilter( 0 );

            Entity partEntity = new Entity(); // engine.createEntity();
            partEntity.add( new ModelComponent( modelInstance ) );
            partEntity.add( new RemoveByTimeComponent( timeOfLife ) );
            partEntity.add( physicalBuilder.buildPhysicalComponent() );
            engine.addEntity( partEntity );

            SoundAsset.BoxCrush.play();
        }
    }


    public static Entity createTrigger ( Vector3 position, Item item ) {

        PhysicalBuilder physicalBuilderLADDER = new PhysicalBuilder()
                .defaultMotionState()
                .zeroMass()
                .boxShape( 4 )
                .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG )
                .setPosition( position )
                .disableDeactivation();

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( physicalBuilderLADDER.buildPhysicalComponent() );
        entity.add( new CollectableComponent( item ) );
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.COLLECTABLE ) );
        engine.addEntity( entity );

        return entity;
    }


    public static Entity createInteractive ( Vector3 position, ModelAsset modelAsset,
                                             TextInteract textInteract, float rotation ) {

        ModelInstance modelInstance = modelAsset.get();
        modelInstance.transform.idt();
        modelInstance.transform.translate( position );
        modelInstance.transform.rotate( Vector3.Y,rotation );

/*

                TextureRegion region3 = IMG.BOX_TEXTURE.getRegion();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).clear();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).set( TextureAttribute.createDiffuse( region3 ) );
*/

        PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .setModelInstance( modelInstance )
                .defaultMotionState()
                .zeroMass()
                .boxShape()
                .setCollisionFlag( CollisionFlags.CF_KINEMATIC_OBJECT )
                .setCallbackFlag( BulletWorld.PICKABLE_FLAG )
                .setCallbackFilter( BulletWorld.PLAYER_FLAG );

        Entity entity = new Entity(); // engine.createEntity();
        entity.add( new ModelComponent( modelInstance ) );
        entity.add( physicalBuilder.buildPhysicalComponent() );
        if ( textInteract != null ) {
            entity.add( new InteractComponent( TYPE_OF_INTERACT.READ, textInteract ) );
        }
        entity.add( new EntityTypeComponent( TYPE_OF_ENTITY.INTERACTIVE ) );
        engine.addEntity( entity );

        return entity;
    }
}
