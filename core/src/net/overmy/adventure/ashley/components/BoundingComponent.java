package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.collision.BoundingBox;


/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class BoundingComponent implements Component {

    public final BoundingBox boundingBox;



    public BoundingComponent( BoundingBox boundingBox ) {
        this.boundingBox = boundingBox;
    }
}
