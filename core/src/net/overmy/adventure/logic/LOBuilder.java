package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 25.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.ModelAsset;

public class LOBuilder {
    public ModelAsset modelAsset;
    protected Vector3     position;
    private   OBJECT_TYPE type;
    private   Item               item         = null;
    private   TextInteract       textInteract = null;
    private   Array< NPCAction > actionArray  = null;
    protected Entity             entity       = null;
    private   boolean            used         = false;
    private   float              height       = 0.0f;
    private   float              rotation     = 0.0f;
}
