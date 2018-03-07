package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class AnimationSystem extends IteratingSystem {

    @SuppressWarnings( "unchecked" )
    public AnimationSystem() {
        super( Family.all( AnimationComponent.class )
                     .exclude( OutOfCameraComponent.class ).get() );
    }



    @Override
    protected void processEntity( Entity entity, float delta ) {
        AnimationComponent component = MyMapper.ANIMATION.get( entity );
        component.controller.update( delta );
    }
}
