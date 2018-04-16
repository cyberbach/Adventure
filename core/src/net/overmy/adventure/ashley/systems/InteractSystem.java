package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

import net.overmy.adventure.Core;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.SkipActionComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.MyDialog;
import net.overmy.adventure.resources.SoundAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class InteractSystem extends IteratingSystem {

    private final Camera camera;

    private final Vector3 position = new Vector3();
    private       Ray     ray      = null;

    private boolean actOnEntity = false;

    private TYPE_OF_INTERACT type            = TYPE_OF_INTERACT.EMPTY;
    private Item             currentItem     = null;
    private MyDialog         currentMyDialog = null;


    @SuppressWarnings( "unchecked" )
    public InteractSystem () {
        super( Family.all( InteractComponent.class )
                     .exclude( OutOfCameraComponent.class ).get() );

        this.camera = MyCamera.get();
    }


    @Override
    public void update ( float delta ) {
        type = TYPE_OF_INTERACT.EMPTY;
        ray = camera.getPickRay( Core.WIDTH_HALF, Core.HEIGHT_HALF );

        super.update( delta );
        actOnEntity = false;
    }


    @Override
    protected void processEntity ( Entity entity, float deltaTime ) {
        MyMapper.MODEL.get( entity ).modelInstance.transform.getTranslation( position );

        final float distance = ray.origin.dst2( position );
        final boolean onMyWay = Intersector.intersectRaySphere( ray, position, 1, null );
        if ( distance < 50.0f && onMyWay ) {
            final InteractComponent interactComponent = MyMapper.INTERACT.get( entity );

            type = interactComponent.getType();
            currentItem = interactComponent.getItem();
            currentMyDialog = interactComponent.getMyDialog();

            if ( actOnEntity ) {
                switch ( type ) {
                    case LOOT:
                        MyPlayer.addToBag( currentItem );

                        // Устанавливаем в levelObject флаг, чтобы предмет
                        // не создался снова, при перезагрузке уровня
                        if ( MyMapper.LEVEL_OBJECT.has( entity ) ) {
                            MyMapper.LEVEL_OBJECT.get( entity ).levelObject.useEntity();
                        }

                        SoundAsset.Collect3.play();

                        getEngine().removeEntity( entity );
                        break;

                    case TALK:
                        //Gdx.app.debug( "говорим с нпс", "" + currentMyDialog.getTitle() );
                        break;

                    case USE:
                        DoorSystem doorSystem = getEngine().getSystem( DoorSystem.class );
                        doorSystem.processKey( currentItem );
                        //Gdx.app.debug( "используем", "" + currentItem.getName() );

                        break;
                }
                actOnEntity = false;
            }

            entity.add( new SkipActionComponent() );
        } else {
            entity.remove( SkipActionComponent.class );
        }
    }


    public MyDialog getCurrentMyDialog () {
        return currentMyDialog;
    }


    public Item getCurrentItem () {
        return currentItem;
    }


    public TYPE_OF_INTERACT getCurrentType () {
        return type;
    }


    public void act () {
        actOnEntity = true;
    }
}
