package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;

import net.overmy.adventure.ashley.components.ModelComponent;

import java.util.Comparator;

/*
     Created by Andrey Mikheev on 30.09.2017
     Contact me → http://vk.com/id17317
 */

public class BlendComparator implements Comparator< Entity > {

    private ComponentMapper< ModelComponent > modelMapper = null;


    BlendComparator () {
        modelMapper = ComponentMapper.getFor( ModelComponent.class );
    }


    @Override
    public int compare ( Entity entity1, Entity entity2 ) {
        if ( modelMapper.get( entity1 ).blendingPresent ) {
            return 1;
        }
        if ( modelMapper.get( entity2 ).blendingPresent ) {
            return 2;
        }
        return 0;
    }
}
