package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector3;

/*
      Created by Andrey Mikheev on 15.03.2018
      Contact me → http://vk.com/id17317
 */

public class LifeComponent implements Component {

    public int life;


    public LifeComponent () {
        life = 100;
    }
}
