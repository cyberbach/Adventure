package net.overmy.adventure.logic;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject.CollisionFlags;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.BulletWorld;
import net.overmy.adventure.PhysicalBuilder;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.CollectableComponent;
import net.overmy.adventure.ashley.components.GroundedComponent;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.LevelObjectComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyAnimationComponent;
import net.overmy.adventure.ashley.components.NPCAction;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.ashley.components.TypeOfComponent;
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


    LevelObject ( OBJECT_TYPE type, ModelAsset models, Vector3 position ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
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

        // Из свича вынесены вверх одинаковые кусочки для всех вариантов сборки
        entity = AshleyWorld.getPooledEngine().createEntity();

        ModelInstance modelInstance = modelAsset.get();
        modelInstance.transform.setToTranslation( position );

        // У всех объектов есть какие-то физические тела,
        // и всем объектам нужна modelInstance для генерации физического тела
        PhysicalBuilder physicalBuilder = new PhysicalBuilder()
                .setModelInstance( modelInstance );

        switch ( type ) {
            case LADDER:
                physicalBuilder
                        .defaultMotionState()
                        .zeroMass()
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_NO_CONTACT_RESPONSE )
                        .setCallbackFlag( BulletWorld.LADDER_FLAG )
                        .setCallbackFilter( BulletWorld.PLAYER_FLAG );

                entity.add( new TypeOfComponent( COMP_TYPE.LADDER ) );
                break;

            case PICKABLE:
                physicalBuilder
                        .defaultMotionState()
                        .setMass( 1.0f )
                        .hullShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.PICKABLE_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG );

                entity.add( new ModelComponent( modelInstance ) );
                entity.add( new TypeOfComponent( COMP_TYPE.PICKABLE ) );
                entity.add( new InteractComponent( TYPE_OF_INTERACT.LOOT, item ) );
                entity.add( new LevelObjectComponent( this ) );
                break;

            case COLLECTABLE:
                physicalBuilder
                        .defaultMotionState()
                        .setMass( 1.0f )
                        .boxShape()
                        .setCollisionFlag( CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG );

                entity.add( new ModelComponent( modelInstance ) );
                entity.add( new MyAnimationComponent() );
                entity.add( new TypeOfComponent( COMP_TYPE.COLLECTABLE ) );
                entity.add( new CollectableComponent( item ) );
                entity.add( new LevelObjectComponent( this ) );
                break;

            case HOVER_COLLECTABLE:
                physicalBuilder
                        .defaultMotionState()
                        .zeroMass()
                        .boxShape()
                        .setCollisionFlag( CollisionFlags.CF_KINEMATIC_OBJECT )
                        .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG );

                entity.add( new ModelComponent( modelInstance ) );
                entity.add( new MyAnimationComponent() );
                entity.add( new TypeOfComponent( COMP_TYPE.COLLECTABLE ) );
                entity.add( new CollectableComponent( item ) );
                entity.add( new LevelObjectComponent( this ) );
                break;

            case NPC:
                physicalBuilder
                        .defaultMotionState()
                        .setMass( 60.0f )
                        .capsuleShape()
                        .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                        .setCallbackFlag( BulletWorld.NPC_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entity.add( new ModelComponent( modelInstance ) );
                entity.add( new AnimationComponent( modelInstance ) );
                entity.add( new InteractComponent( TYPE_OF_INTERACT.TALK, textBlock ) );
                entity.add( new TypeOfComponent( COMP_TYPE.NPC ) );
                entity.add( new NPCComponent( actionArray ) );
                break;

            case ENEMY:
                physicalBuilder
                        .defaultMotionState()
                        .setMass( 60.0f )
                        .capsuleShape()
                        .setCollisionFlag( CollisionFlags.CF_CHARACTER_OBJECT )
                        .setCallbackFlag( BulletWorld.NPC_FLAG )
                        .setCallbackFilter( BulletWorld.ALL_FLAG )
                        .disableDeactivation();

                entity.add( new ModelComponent( modelInstance ) );
                entity.add( new AnimationComponent( modelInstance ) );
                entity.add( new TypeOfComponent( COMP_TYPE.NPC ) );
                entity.add( new NPCComponent( actionArray, true ) );
                break;
        }

        entity.add( physicalBuilder.buildPhysicalComponent() );
        AshleyWorld.getPooledEngine().addEntity( entity );
    }


    void buildModel () {
        if ( entity == null && !used ) {
            modelAsset.build();
        }
    }
}
