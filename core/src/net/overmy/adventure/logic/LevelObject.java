package net.overmy.adventure.logic;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject.CollisionFlags;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.BulletWorld;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.PhysicalBuilder;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.CollectableComponent;
import net.overmy.adventure.ashley.components.ContainerComponent;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.LevelObjectComponent;
import net.overmy.adventure.ashley.components.LifeComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyAnimationComponent;
import net.overmy.adventure.ashley.components.NPCAction;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.ashley.components.TypeOfComponent;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.resources.ModelAsset;

/**
 * Created by Andrey (cb) Mikheev
 * 17.03.2017
 */

public class LevelObject {

    ModelAsset modelAsset;
    protected Vector3     position;
    private   OBJECT_TYPE type;
    private   Item               item        = null;
    private   TextBlock          textBlock   = null;
    private   Array< NPCAction > actionArray = null;
    protected Entity             entity      = null;
    private   boolean            used        = false;
    float height = 0.0f;


    LevelObject ( OBJECT_TYPE type, ModelAsset models, Vector3 position ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
    }

    LevelObject ( OBJECT_TYPE type, ModelAsset models, Vector3 position, float height ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
        this.height = height;
    }


    LevelObject ( OBJECT_TYPE type, Item id, ModelAsset models, Vector3 position ) {
        this.type = type;
        this.item = id;
        this.modelAsset = models;
        this.position = position;
    }


    LevelObject ( OBJECT_TYPE type, TextBlock textBlock, Array< NPCAction > actionArray,
                  ModelAsset models, Vector3 position ) {
        this.type = type;
        this.textBlock = textBlock;
        this.modelAsset = models;
        this.position = position;
        this.actionArray = actionArray;
    }


    LevelObject ( OBJECT_TYPE type, Array< NPCAction > actionArray,
                  ModelAsset models, Vector3 position ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
        this.actionArray = actionArray;
    }


    public void useEntity () {
        used = true;
        entity.add( new RemoveByTimeComponent( 0 ) );
        entity = null;

        Gdx.app.debug( "useEntity", "" + item );
    }


    void removeEntity () {
        if ( entity != null ) {
            entity.add( new RemoveByTimeComponent( 0 ) );
        }
        entity = null;
    }


    void buildEntity () {
        if ( entity != null || used ) {
            return;
        }

        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
            Gdx.app.debug( "Need to build OBJECT", "" + this.type );
        }

        // Из свича вынесены вверх одинаковые кусочки для всех вариантов сборки
        entity = AshleyWorld.getPooledEngine().createEntity();

        switch ( type ) {
            case LADDER:
                PhysicalBuilder physicalBuilderLADDER = new PhysicalBuilder();

                physicalBuilderLADDER
                        .defaultMotionState()
                        .zeroMass()
                        .cylinderShape( 0.5f, height )
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.LADDER_FLAG )
                        .setCallbackFilter( BulletWorld.PLAYER_FLAG )
                        .setPosition( position );

                entity.add( physicalBuilderLADDER.buildPhysicalComponent() );
                entity.add( new TypeOfComponent( COMP_TYPE.LADDER ) );
                break;

            case PICKABLE:
                ModelInstance modelInstancePICKABLE = modelAsset.get();
                modelInstancePICKABLE.transform.setToTranslation( position );

                PhysicalBuilder physicalBuilderPICKABLE = new PhysicalBuilder()
                        .setModelInstance( modelInstancePICKABLE );

                physicalBuilderPICKABLE
                        .defaultMotionState()
                        .setMass( 1.0f )
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.PICKABLE_FLAG )
                        .setCallbackFilter( BulletWorld.GROUND_FLAG | BulletWorld.PLAYER_FLAG );

                if ( modelInstancePICKABLE.animations.size > 0 ) {
                    entity.add( new AnimationComponent( modelInstancePICKABLE ) );
                }

                entity.add( new MyAnimationComponent() );
                entity.add( new ModelComponent( modelInstancePICKABLE ) );
                entity.add( new TypeOfComponent( COMP_TYPE.PICKABLE ) );
                entity.add( new InteractComponent( TYPE_OF_INTERACT.LOOT, item ) );
                entity.add( new LevelObjectComponent( this ) );
                entity.add( physicalBuilderPICKABLE.buildPhysicalComponent() );
                break;

            case BOX:
                ModelInstance modelInstanceBOX = modelAsset.get();
                modelInstanceBOX.transform.setToTranslation( position );
/*

                TextureRegion region = IMG.BOX_TEXTURE.getRegion();
                modelInstanceBOX.materials.get( 0 ).clear();
                modelInstanceBOX.materials.get( 0 ).set( TextureAttribute.createDiffuse( region ) );
*/

                PhysicalBuilder physicalBuilderBOX = new PhysicalBuilder()
                        .setModelInstance( modelInstanceBOX );

                physicalBuilderBOX
                        .defaultMotionState()
                        .setMass( 20.0f )
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.DESTROYABLE_FLAG )
                        .setCallbackFilter( BulletWorld.MYWEAPON_FLAG );

                if ( modelInstanceBOX.animations.size > 0 ) {
                    entity.add( new AnimationComponent( modelInstanceBOX ) );
                }

                entity.add( new LifeComponent() );
                if ( item != null ) {
                    entity.add( new ContainerComponent( item ) );
                }
                entity.add( new ModelComponent( modelInstanceBOX ) );
                entity.add( new TypeOfComponent( COMP_TYPE.DESTROYABLE_BOX ) );
                entity.add( new LevelObjectComponent( this ) );
                entity.add( physicalBuilderBOX.buildPhysicalComponent() );
                break;

            case COLLECTABLE:
                ModelInstance modelInstanceCOLLECTABLE = modelAsset.get();
                modelInstanceCOLLECTABLE.transform.setToTranslation( position );




                PhysicalBuilder physicalBuilderCOLLECTABLE = new PhysicalBuilder()
                        .setModelInstance( modelInstanceCOLLECTABLE );

                physicalBuilderCOLLECTABLE
                        .defaultMotionState()
                        .setMass( 1.0f )
                        .boxShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                        .setCallbackFilter( BulletWorld.PLAYER_FLAG );

                entity.add( new ModelComponent( modelInstanceCOLLECTABLE ) );

                if ( modelInstanceCOLLECTABLE.animations.size > 0 ) {
                    entity.add( new AnimationComponent( modelInstanceCOLLECTABLE ) );
                }

                entity.add( new MyAnimationComponent() );
                entity.add( new TypeOfComponent( COMP_TYPE.COLLECTABLE ) );
                entity.add( new CollectableComponent( item ) );
                entity.add( new LevelObjectComponent( this ) );
                entity.add( physicalBuilderCOLLECTABLE.buildPhysicalComponent() );
                break;

            case HOVER_COLLECTABLE:
                ModelInstance modelInstanceHOVER_COLLECTABLE = modelAsset.get();
                modelInstanceHOVER_COLLECTABLE.transform.setToTranslation( position );

/*

                TextureRegion region3 = IMG.BOX_TEXTURE.getRegion();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).clear();
                modelInstanceHOVER_COLLECTABLE.materials.get( 0 ).set( TextureAttribute.createDiffuse( region3 ) );
*/


                PhysicalBuilder physicalBuilderHOVER_COLLECTABLE = new PhysicalBuilder()
                        .setModelInstance( modelInstanceHOVER_COLLECTABLE );

                physicalBuilderHOVER_COLLECTABLE
                        .defaultMotionState()
                        .zeroMass()
                        .boxShape()
                        .setCollisionFlag( CollisionFlags.CF_KINEMATIC_OBJECT )
                        .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                        .setCallbackFilter( BulletWorld.PLAYER_FLAG );

                if ( modelInstanceHOVER_COLLECTABLE.animations.size > 0 ) {
                    entity.add( new AnimationComponent( modelInstanceHOVER_COLLECTABLE ) );
                }

                entity.add( new ModelComponent( modelInstanceHOVER_COLLECTABLE ) );
                entity.add( new MyAnimationComponent() );
                entity.add( new TypeOfComponent( COMP_TYPE.COLLECTABLE ) );
                entity.add( new CollectableComponent( item ) );
                entity.add( new LevelObjectComponent( this ) );
                entity.add( physicalBuilderHOVER_COLLECTABLE.buildPhysicalComponent() );
                break;

            case NPC:
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
                        .setModelInstance( modelInstanceNPC );

                physicalBuilderNPC
                        .defaultMotionState()
                        .setMass( 60.0f )
                        .capsuleShape()
                        .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                        .setCallbackFlag( BulletWorld.NPC_FLAG )
                        .setCallbackFilter(
                                BulletWorld.GROUND_FLAG | BulletWorld.NPC_FLAG | BulletWorld.PLAYER_FLAG )
                        .disableDeactivation();

                entity.add( new ModelComponent( modelInstanceNPC ) );
                entity.add( new AnimationComponent( modelInstanceNPC ) );
                if ( textBlock != null ) {
                    entity.add( new InteractComponent( TYPE_OF_INTERACT.TALK, textBlock ) );
                }
                entity.add( new TypeOfComponent( COMP_TYPE.NPC ) );
                Gdx.app.debug( "", "" + actionArray );
                entity.add( new NPCComponent( actionArray ) );
                entity.add( physicalBuilderNPC.buildPhysicalComponent() );
                break;

            case ENEMY:
                ModelInstance modelInstanceENEMY = modelAsset.get();
                modelInstanceENEMY.transform.setToTranslation( position );

                PhysicalBuilder physicalBuilderENEMY = new PhysicalBuilder()
                        .setModelInstance( modelInstanceENEMY );

                physicalBuilderENEMY
                        .defaultMotionState()
                        .setMass( 60.0f )
                        .capsuleShape()
                        .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                        .setCallbackFlag( BulletWorld.NPC_FLAG )
                        .setCallbackFilter(
                                BulletWorld.GROUND_FLAG | BulletWorld.NPC_FLAG | BulletWorld.PLAYER_FLAG )
                        .disableDeactivation();

                entity.add( new ModelComponent( modelInstanceENEMY ) );
                entity.add( new AnimationComponent( modelInstanceENEMY ) );
                entity.add( new TypeOfComponent( COMP_TYPE.NPC ) );
                entity.add( new NPCComponent( actionArray, true ) );
                entity.add( physicalBuilderENEMY.buildPhysicalComponent() );
                break;

            case WEAPON:
                ModelInstance modelInstanceWEAPON = modelAsset.get();
                modelInstanceWEAPON.transform.setToTranslation( position );

                PhysicalBuilder physicalBuilderWEAPON = new PhysicalBuilder()
                        .setModelInstance( modelInstanceWEAPON );

                physicalBuilderWEAPON
                        .defaultMotionState()
                        .setMass( 3.0f )
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.MYWEAPON_FLAG )
                        .setCallbackFilter( BulletWorld.NPC_FLAG )
                        .disableDeactivation();

                entity.add( new ModelComponent( modelInstanceWEAPON ) );
                entity.add( new TypeOfComponent( COMP_TYPE.WEAPON ) );
                entity.add( new InteractComponent( TYPE_OF_INTERACT.LOOT, item ) );
                entity.add( new LevelObjectComponent( this ) );
                entity.add( physicalBuilderWEAPON.buildPhysicalComponent() );
                break;
        }

        AshleyWorld.getPooledEngine().addEntity( entity );
    }


    void buildModel () {
        if ( entity == null && !used ) {
            modelAsset.build();
        }
    }
}
