package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

import net.overmy.adventure.logic.Item;


/*
      Created by Andrey Mikheev on 15.03.2018
      Contact me → http://vk.com/id17317
 */

public class ContainerComponent implements Component {

    public final Item item;


    public ContainerComponent ( Item item ) {
        this.item = item;
    }
}
