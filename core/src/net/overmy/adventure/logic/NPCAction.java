package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 02.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.resources.TextAsset;

public class NPCAction {
    public NPC_ACTION_ID id;
    public float         durationTime;
    public Vector2 targetPosition = null;
    public TextAsset text = null;
    public int nOfAnimation;

    public enum NPC_ACTION_ID {
        WAIT,
        MOVE,
        SAY,
        ANIMATE,
        HUNT
    }


    public NPCAction ( NPC_ACTION_ID id, float durationTime ) {
        this.id = id;
        this.durationTime = durationTime;
    }

    public NPCAction ( NPC_ACTION_ID id, float durationTime, int n ) {
        this.id = id;
        this.durationTime = durationTime;
        this.nOfAnimation=n;
    }


    public NPCAction ( NPC_ACTION_ID id, Vector2 targetPosition, float durationTime ) {
        this.id = id;
        this.targetPosition = targetPosition;
        this.durationTime = durationTime;
    }

    public NPCAction ( NPC_ACTION_ID id, TextAsset text, float durationTime ) {
        this.id = id;
        this.text = text;
        this.durationTime = durationTime;
    }
}
