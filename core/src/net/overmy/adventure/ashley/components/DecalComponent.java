package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g3d.decals.Decal;

import net.overmy.adventure.utils.Vector3Animator;
/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

public class DecalComponent implements Component {

    public Decal           decal;
    public Vector3Animator animator;

    public DecalComponent( Decal decal, Vector3Animator animator ) {
        this.decal = decal;
        this.animator = animator;
    }
}
