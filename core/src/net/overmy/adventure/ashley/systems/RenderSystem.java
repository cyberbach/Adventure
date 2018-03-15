package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.collision.BoundingBox;

import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;

/*
      Created by Andrey Mikheev on 29.09.2017
      Contact me → http://vk.com/id17317
 */

public class RenderSystem extends SortedIteratingSystem {

    private final ModelBatch  batch;
    private final Environment environment;

    private int modelsCount      = 0;
    private int totalModelsCount = 0;


    public int getModelsCount () {
        return modelsCount;
    }


    public int getTotalModelsCount () {
        return totalModelsCount;
    }


    @SuppressWarnings( "unchecked" )
    public RenderSystem () {
        super( Family.all( ModelComponent.class ).
                exclude( MyWeaponComponent.class).get(), new BlendComparator() );

        environment = MyRender.getEnvironment();
        batch = MyRender.getModelBatch();
   }


    @Override
    public void update ( float delta ) {
        modelsCount = 0;
        totalModelsCount = 0;

        batch.begin( MyCamera.get() );
        super.update( delta );
        batch.end();
    }


    @Override
    protected void processEntity ( Entity entity, float deltaTime ) {
        totalModelsCount++;
        if ( MyMapper.BOUNDS.has( entity ) ) {
            final BoundingBox boundingBox = MyMapper.BOUNDS.get( entity ).boundingBox;
            if ( MyCamera.isVisible( boundingBox ) ) {
                if ( MyMapper.OUT_OF_CAMERA.has( entity ) ) {
                    entity.remove( OutOfCameraComponent.class );
                }
                final ModelInstance modelInstance = MyMapper.MODEL.get( entity ).modelInstance;
                batch.render( modelInstance, environment );
                modelsCount++;
            } else {
                entity.add( new OutOfCameraComponent() );
            }
        } else {
            final ModelInstance modelInstance = MyMapper.MODEL.get( entity ).modelInstance;
            if ( MyCamera.isVisible( modelInstance.transform ) ) {
                if ( MyMapper.OUT_OF_CAMERA.has( entity ) ) {
                    entity.remove( OutOfCameraComponent.class );
                }
                batch.render( modelInstance, environment );
                modelsCount++;
            } else {
                entity.add( new OutOfCameraComponent() );
            }
        }
    }
}
