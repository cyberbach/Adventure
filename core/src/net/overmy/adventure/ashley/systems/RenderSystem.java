package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.collision.BoundingBox;

import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;

/*
      Created by Andrey Mikheev on 29.09.2017
      Contact me → http://vk.com/id17317
 */

public class RenderSystem extends IteratingSystem {

    private final ModelBatch  modelBatch;
    private final Environment environment;

    private int visibleModelsCount = 0;
    private int totalModelsCount   = 0;


    public int getVisibleModelsCount () {
        return visibleModelsCount;
    }


    public int getTotalModelsCount () {
        return totalModelsCount;
    }


    @SuppressWarnings( "unchecked" )
    public RenderSystem () {
        super( Family.all( ModelComponent.class ).get() );

        environment = MyRender.getEnvironment();
        modelBatch = MyRender.getModelBatch();
    }


    @Override
    public void update ( float delta ) {
        visibleModelsCount = 0;
        totalModelsCount = 0;

        modelBatch.begin( MyCamera.get() );
        super.update( delta );
        modelBatch.end();
    }


    @Override
    protected void processEntity ( Entity entity, float deltaTime ) {
        totalModelsCount++;
        // Это код для уровней, только у них есть границы
        if ( MyMapper.BOUNDS.has( entity ) ) {
            final BoundingBox boundingBox = MyMapper.BOUNDS.get( entity ).boundingBox;
            if ( MyCamera.isVisible( boundingBox ) ) {
                if ( MyMapper.OUT_OF_CAMERA.has( entity ) ) {
                    entity.remove( OutOfCameraComponent.class );
                }
                final ModelInstance modelInstance = MyMapper.MODEL.get( entity ).modelInstance;
                modelBatch.render( modelInstance, environment );
                visibleModelsCount++;
            } else {
                entity.add( new OutOfCameraComponent() );
            }
        } else {
            // Код для всех остальных моделей (не уровней)
            final ModelInstance modelInstance = MyMapper.MODEL.get( entity ).modelInstance;
            if ( MyCamera.isVisible( modelInstance.transform ) ) {
                if ( MyMapper.OUT_OF_CAMERA.has( entity ) ) {
                    entity.remove( OutOfCameraComponent.class );
                }
                modelBatch.render( modelInstance, environment );
                visibleModelsCount++;
            } else {
                entity.add( new OutOfCameraComponent() );
            }
        }
    }
}
