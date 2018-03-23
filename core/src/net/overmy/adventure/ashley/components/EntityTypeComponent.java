package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class EntityTypeComponent implements Component {

    public final TYPE_OF_ENTITY type;

    public EntityTypeComponent ( TYPE_OF_ENTITY type ) {
        this.type = type;
    }
}
