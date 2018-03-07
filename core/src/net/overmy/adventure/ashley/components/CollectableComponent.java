package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.collision.BoundingBox;

import net.overmy.adventure.logic.Item;


/*
      Created by Andrey Mikheev on 28.02.2018
      Contact me → http://vk.com/id17317
 */

public class CollectableComponent implements Component {

    public final Item item;


    public CollectableComponent ( Item item ) {
        this.item = item;
    }
}
