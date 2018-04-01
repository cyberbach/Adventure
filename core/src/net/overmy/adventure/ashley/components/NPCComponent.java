package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.utils.ImmutableArray;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.NPCAction;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class NPCComponent extends TimeComponent {
    public ImmutableArray< NPCAction > actionArray;

    public int     currentAction = 0;
    public boolean hunting       = false;
    public boolean hurt          = false;
    public float   damage        = 0.0f;
    public boolean die           = false;
    public Item dropItem = null;


    public NPCComponent ( ImmutableArray< NPCAction > actionArray ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
    }


    public NPCComponent ( ImmutableArray< NPCAction > actionArray, float newDamage ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
        this.damage = newDamage;
    }

    public NPCComponent ( ImmutableArray< NPCAction > actionArray, float newDamage, Item dropItem ) {
        this.actionArray = actionArray;
        this.time = actionArray.get( 0 ).durationTime;
        this.damage = newDamage;
        this.dropItem = dropItem;
    }
}
