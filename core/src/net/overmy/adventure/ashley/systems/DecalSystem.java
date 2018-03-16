package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.DecalComponent;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.utils.Vector3Animator;

/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class DecalSystem extends IteratingSystem {

    private Vector3 offsetByAnimator = new Vector3();
    private int     decalCount       = 0;

    @SuppressWarnings ( "unchecked" )
    public DecalSystem(  ) {
        super( Family.all( DecalComponent.class )
                     .exclude( OutOfCameraComponent.class ).get() );
    }

    @Override
    protected void processEntity( Entity entity, float delta ) {
        final DecalComponent decalComponent = MyMapper.DECAL.get( entity );

        final Vector3Animator animator = decalComponent.animator;

        animator.update( delta );

        final Color decalColor = decalComponent.decal.getColor();
        decalColor.a = animator.getAlphaPercentage();
        decalComponent.decal.setColor( decalColor );

        final Vector3 position = MyMapper.POSITION.get( entity ).position;

        offsetByAnimator.set(
                animator.getCurrent().x,
                animator.getCurrent().y,
                animator.getCurrent().z
                            );
        offsetByAnimator.add( position );

        if ( MyCamera.isVisible( offsetByAnimator ) ) {
            decalComponent.decal.setPosition( offsetByAnimator );

            // facing overrides all rotations
            decalComponent.decal.lookAt( MyCamera.get().position, MyCamera.get().up );
            MyRender.getDecalBatch().add( decalComponent.decal );
        }

        decalCount++;
    }

    @Override
    public void update( float delta ) {
        decalCount = 0;
        super.update( delta );
    }

    public int getDecalCount() {
        return decalCount;
    }
}
