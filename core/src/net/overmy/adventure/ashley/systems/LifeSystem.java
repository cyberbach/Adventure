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

import net.overmy.adventure.AshleySubs;
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

    private final Vector3 position = new Vector3();


    @SuppressWarnings( "unchecked" )
    public LifeSystem () {
        super( Family.all( LifeComponent.class ).get() );
    }


    @Override
    protected void processEntity ( Entity entity, float deltaTime ) {
        LifeComponent component = MyMapper.LIFE.get( entity );
        // entity is dead
        if ( component.life <= 0 ) {
            Matrix4 transform = MyMapper.PHYSICAL.get( entity ).body.getWorldTransform();
            transform.getTranslation( position );

            AshleySubs.createCrateParts( position );

            if ( MyMapper.CONTAINER.has( entity ) ) {
                AshleySubs.createGift( position, MyMapper.CONTAINER.get( entity ).item );
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
