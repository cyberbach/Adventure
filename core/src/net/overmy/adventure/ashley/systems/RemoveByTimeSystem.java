package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class RemoveByTimeSystem extends IteratingSystem {

    @SuppressWarnings ( "unchecked" )
    public RemoveByTimeSystem() {
        super( Family.all( RemoveByTimeComponent.class ).get() );
    }

    @Override
    protected void processEntity( Entity entity, float delta ) {
        RemoveByTimeComponent removeByTimeComponent = MyMapper.REMOVE_BY_TIME.get( entity );
        removeByTimeComponent.time -= delta;
        if ( removeByTimeComponent.time < 0.0f ) {
            getEngine().removeEntity( entity );
        }
    }
}
