package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class NPCComponent extends TimeComponent {
    public Array< NPCAction > actionArray = new Array< NPCAction >();

    public int currentAction = 0;
    public boolean agressive;


    public NPCComponent ( Array< NPCAction > actionArray ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
        this.agressive = false;
    }


    public NPCComponent ( Array< NPCAction > actionArray, boolean agressive ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
        this.agressive = agressive;
    }
}
