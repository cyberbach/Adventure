package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.BulletWorld;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.PhysicalBuilder;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.CollectableComponent;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.LevelObjectComponent;
import net.overmy.adventure.ashley.components.LifeComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyAnimationComponent;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.ashley.components.TypeOfComponent;
import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.SoundAsset;

/*
      Created by Andrey Mikheev on 15.03.2018
      Contact me → http://vk.com/id17317
 */

public class LifeSystem extends IteratingSystem {


    @SuppressWarnings( "unchecked" )
    public LifeSystem () {
        super( Family.all( LifeComponent.class ).get() );

   }



    @Override
    protected void processEntity ( Entity entity, float deltaTime ) {
        LifeComponent component = MyMapper.LIFE.get( entity );
        // entity is dead
        if(component.life<=0){
            Matrix4 entityTransform = MyMapper.PHYSICAL.get( entity ).body.getWorldTransform();
            Vector3 position = new Vector3(  );
            entityTransform.getTranslation( position );


            ///////////////////

            int parts = MathUtils.random( 3, 7 );
            for(int i=0;i<parts;i++) {
                float timeOfLife = MathUtils.random( 1.0f, 2.0f );

                Vector3 randomPosition = new Vector3();
                randomPosition.x = MathUtils.random( -1.0f, 1.0f );
                randomPosition.y = MathUtils.random( -1.0f, 1.0f );
                randomPosition.z = MathUtils.random( -1.0f, 1.0f );

                Vector3 partPosition = new Vector3( position );
                partPosition.add( randomPosition );

                ModelInstance modelInstance = ModelAsset.BOX_PART.get();
/*

                TextureRegion region = IMG.BOX_TEXTURE.getRegion();
                modelInstance.materials.get( 0 ).clear();
                modelInstance.materials.get( 0 ).set( TextureAttribute.createDiffuse( region ) );
*/

                PhysicalBuilder physicalBuilderPICKABLE = new PhysicalBuilder()
                        .setModelInstance( modelInstance );

                randomPosition.scl( 0.6f );

                // rotations by vectors
                float a = MathUtils.random( 360.0f );
                float b = MathUtils.random( 360.0f );
                float c = MathUtils.random( 360.0f );

                physicalBuilderPICKABLE
                        .defaultMotionState()
                        .setMass( 0.1f )
                        .setPosition( partPosition )
                        .setRotation(a,b,c)
                        .boxShape()
                        .setCollisionFlag(
                                btCollisionObject.CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.PART_FLAG )
                        .setStartImpulse( randomPosition )
                        .setCallbackFilter( 0 );

                Entity partEntity = AshleyWorld.getPooledEngine().createEntity();
                partEntity.add( new ModelComponent( modelInstance ) );
                partEntity.add( new RemoveByTimeComponent( timeOfLife ) );
                partEntity.add( physicalBuilderPICKABLE.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( partEntity );

                SoundAsset.BoxCrush.play();
            }

            ///////////////////

            if(MyMapper.CONTAINER.has( entity )){
                /////////////////////////

                ModelInstance modelInstanceFromBox = ModelAsset.GIFT.get();
                //modelInstanceFromBox.transform.setToTranslation( position );

                PhysicalBuilder physicalBuilderFromBox = new PhysicalBuilder()
                        .setModelInstance( modelInstanceFromBox );

                physicalBuilderFromBox
                        .defaultMotionState()
                        .setPosition( position )
                        .setMass( 5.0f )
                        .boxShape()
                        .setCollisionFlag( btCollisionObject.CollisionFlags.CF_CUSTOM_MATERIAL_CALLBACK )
                        .setCallbackFlag( BulletWorld.COLLECTABLE_FLAG )
                        .setCallbackFilter( BulletWorld.PLAYER_FLAG );

                Entity entityFromBox = AshleyWorld.getPooledEngine().createEntity();
                entityFromBox.add( new ModelComponent( modelInstanceFromBox ) );
                entityFromBox.add( new MyAnimationComponent() );
                entityFromBox.add( new TypeOfComponent( COMP_TYPE.COLLECTABLE ) );
                entityFromBox.add( new CollectableComponent( MyMapper.CONTAINER.get( entity ).item ) );
                entityFromBox.add( physicalBuilderFromBox.buildPhysicalComponent() );
                AshleyWorld.getPooledEngine().addEntity( entityFromBox );
                //////////////////////////
            }

            if ( MyMapper.LEVEL_OBJECT.has( entity ) ) {
                MyMapper.LEVEL_OBJECT.get( entity ).levelObject.useEntity();
            }else {
                entity.add( new RemoveByTimeComponent( 0 ) );
            }
        }
    }
}
