package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class TypeOfComponent implements Component {

    public final COMP_TYPE type;

    public TypeOfComponent( COMP_TYPE type ) {
        this.type = type;
    }
}
