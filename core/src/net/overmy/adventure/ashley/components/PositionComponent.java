package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class PositionComponent implements Component {
    
    public final Vector3 position = new Vector3();

    public PositionComponent( Vector3 position ) {
        this.position.set( position );
    }
}
