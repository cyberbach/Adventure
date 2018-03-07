package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.RemoveByLevelComponent;
import net.overmy.adventure.logic.DynamicLevels;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class RemoveByLevelSystem extends IteratingSystem {

    private boolean needToProcess = false;



    @SuppressWarnings( "unchecked" )
    public RemoveByLevelSystem () {
        super( Family.all( RemoveByLevelComponent.class ).get() );
    }



    @Override
    public void update( float delta ) {
        if ( needToProcess ) {
            super.update( delta );
            needToProcess = false;
        }
    }



    @Override
    protected void processEntity( Entity entity, float deltaTime ) {
        if ( !MyMapper.TYPE.has( entity ) ) { return; }

        final COMP_TYPE type = MyMapper.TYPE.get( entity ).type;
        if ( !type.equals( COMP_TYPE.GROUND ) ) {
            final int currentZone = DynamicLevels.getCurrent();
            if ( currentZone != MyMapper.REMOVE_BY_ZONE.get( entity ).id ) {
                getEngine().removeEntity( entity );
            }
        }
    }



    public void process() {
        needToProcess = true;
    }
}
