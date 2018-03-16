package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.scenes.scene2d.Group;

/*
      Created by Andrey Mikheev on 16.03.2018
      Contact me → http://vk.com/id17317
 */

public class ActorComponent implements Component {
    public Group group;


    public ActorComponent ( Group group ) {
        this.group = group;
    }


    public ActorComponent () {
        this.group = new Group();
    }
}
