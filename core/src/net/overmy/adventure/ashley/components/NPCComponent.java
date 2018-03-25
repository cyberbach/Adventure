package net.overmy.adventure.ashley.components;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.logic.NPCAction;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class NPCComponent extends TimeComponent {
    public Array< NPCAction > actionArray = new Array< NPCAction >();

    public int     currentAction = 0;
    public boolean hunting       = false;
    public boolean hurt       = false;
    public float   damage        = 0.0f;


    public NPCComponent ( Array< NPCAction > actionArray ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
    }


    public NPCComponent ( Array< NPCAction > actionArray, float newDamage ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
        this.damage = newDamage;
    }
}
