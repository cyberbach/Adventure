package net.overmy.adventure.ashley;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btIndexedMesh;
import com.badlogic.gdx.physics.bullet.collision.btTriangleIndexVertexArray;
import com.badlogic.gdx.physics.bullet.linearmath.btMotionState;
import com.badlogic.gdx.utils.StringBuilder;

import net.overmy.adventure.BulletWorld;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.ashley.components.BVHPhysicalComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;


/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class MyEntityListener implements EntityListener {

    private StringBuilder log = new StringBuilder();


    public MyEntityListener () {
    }


    @Override
    public void entityAdded ( Entity entity ) {
        /*if(true *//*add cut-scene*//*){
            game.player.getPlayerBodyEntity().remove( InputComponent.class );
        }*/

        if ( DEBUG.ENTITIES.get() ) {
            log.setLength( 0 );
            if ( MyMapper.TYPE.has( entity ) ) {
                log.append( MyMapper.TYPE.get( entity ).type.toString() );
                log.append( " " );
            }
        }
        if ( MyMapper.PHYSICAL.has( entity ) ) {
            BulletWorld.addBody( MyMapper.PHYSICAL.get( entity ).body );
        }

        if ( DEBUG.ENTITIES.get() ) {
            if ( "DecalComponent".equals(
                    entity.getComponents()
                          .get( 0 )
                          .getClass()
                          .getSimpleName() ) && !DEBUG.DECAL_ENTITIES.get() ) {
                return;
            }

            log.append( " [" );
            int size = entity.getComponents().size();
            for ( int i = 0; i < size; i++ ) {
                Component c = entity.getComponents().get( i );
                String name = c.getClass().getSimpleName();
                log.append( name.replace( "Component", "" ) );
                if ( i != size - 1 ) {
                    log.append( ", " );
                }
            }
            log.append( "]" );
            Gdx.app.debug( "Entity Listener ♦ ADD", log.toString() );
        }
    }


    @Override
    public void entityRemoved ( Entity entity ) {

        if ( DEBUG.ENTITIES.get() ) {
            log.setLength( 0 );
            if ( MyMapper.TYPE.has( entity ) ) {
                log.append( MyMapper.TYPE.get( entity ).type.toString() );
                log.append( " " );
            }
        }

        if ( MyMapper.PHYSICAL.has( entity ) ) {
            PhysicalComponent physicalComponent = MyMapper.PHYSICAL.get( entity );
            BulletWorld.removeBody( physicalComponent.body );

            btMotionState motionState = physicalComponent.body.getMotionState();
            if ( motionState != null ) {
                motionState.dispose();
            }

            btCollisionShape shape = physicalComponent.body.getCollisionShape();
            if ( shape != null ) {
                shape.dispose();
            }

            physicalComponent.constructionInfo.dispose();
            physicalComponent.body.dispose();

            if ( MyMapper.BVH_PHYSICAL.has( entity ) ) {
                BVHPhysicalComponent bvhPhysicalComponent = MyMapper.BVH_PHYSICAL.get( entity );

                btIndexedMesh indexedMesh = bvhPhysicalComponent.indexedMesh;
                indexedMesh.dispose();

                btTriangleIndexVertexArray meshInterface = bvhPhysicalComponent.meshInterface;
                meshInterface.dispose();
            }
        }

        if ( MyMapper.MODEL.has( entity ) ) {
            ModelComponent modelComponent = MyMapper.MODEL.get( entity );
            modelComponent.modelInstance.transform.setToRotation( Vector3.Y, 0 );
        }

        if ( DEBUG.ENTITIES.get() ) {
            if ( "DecalComponent".equals(
                    entity.getComponents()
                          .get( 0 )
                          .getClass()
                          .getSimpleName() ) && !DEBUG.DECAL_ENTITIES.get() ) {
                return;
            }

            log.append( " [" );
            int size = entity.getComponents().size();
            for ( int i = 0; i < size; i++ ) {
                Component c = entity.getComponents().get( i );
                String name = c.getClass().getSimpleName();
                log.append( name.replace( "Component", "" ) );
                if ( i != size - 1 ) {
                    log.append( ", " );
                }
            }
            log.append( "]" );

            Gdx.app.debug( "Entity Listener ♦ REMOVED", log.toString() );
        }
    }
}
