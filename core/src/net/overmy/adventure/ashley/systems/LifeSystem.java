package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.LifeComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class LifeSystem extends IteratingSystem {

    private final DecalBatch        decalBatch;
    private final PerspectiveCamera camera;

    private final Vector3 position = new Vector3();


    @SuppressWarnings( "unchecked" )
    public LifeSystem () {
        super( Family.all( LifeComponent.class ).get() );

        this.decalBatch = MyRender.getDecalBatch();
        this.camera = MyCamera.get();
    }


    @Override
    protected void processEntity ( Entity entity, float delta ) {
        LifeComponent lifeComponent = MyMapper.LIFE.get( entity );
        float hideTime = lifeComponent.time;
        if ( hideTime < 0 ) {
            return;
        }

        Gdx.app.debug( "life",""+lifeComponent.life );

        lifeComponent.time = hideTime - delta;

        MyMapper.MODEL.get( entity ).modelInstance.transform.getTranslation( position );
        position.add( 0, lifeComponent.heightOffset, 0 );

        Decal decal = lifeComponent.decal;

        if ( lifeComponent.life > 0.0f ) {
            float width = lifeComponent.width * lifeComponent.getLifePercent();
            decal.setWidth( width );
            decal.setPosition( position );
            decal.lookAt( camera.position, camera.up );
            decalBatch.add( decal );
        } else {
            Matrix4 transform = MyMapper.PHYSICAL.get( entity ).body.getWorldTransform();
            transform.getTranslation( position );

            if ( MyMapper.TYPE.get( entity ).type.equals( COMP_TYPE.DESTROYABLE_BOX ) ) {
                AshleySubs.createCrateParts( position );

                if ( MyMapper.CONTAINER.has( entity ) ) {
                    AshleySubs.createGift( position, MyMapper.CONTAINER.get( entity ).item );
                }
            }

            if ( MyMapper.TYPE.get( entity ).type.equals( COMP_TYPE.DESTROYABLE_ROCK ) ) {
                AshleySubs.createRockParts( position );
            }

            // Это чтобы компонент не пересоздавался при смене локаций
            if ( MyMapper.LEVEL_OBJECT.has( entity ) ) {
                MyMapper.LEVEL_OBJECT.get( entity ).levelObject.useEntity();
            } else {
                entity.add( new RemoveByTimeComponent( 0 ) );
            }
        }
    }
}
