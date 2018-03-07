package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

import net.overmy.adventure.logic.LevelObject;
/*
      Created by Andrey (cb) Mikheev on 03.03.2018
      Contact me → http://vk.com/id17317
 */

public class LevelObjectComponent implements Component {

    public final LevelObject levelObject;


    public LevelObjectComponent ( LevelObject levelObject ) {
        this.levelObject = levelObject;
    }
}
