package net.overmy.adventure.ashley.components;


import com.badlogic.ashley.core.Component;

import net.overmy.adventure.resources.TextAsset;

/**
 * Created by Andrey (cb) Mikheev
 * 03.03.2017
 */

public class TextDecalComponent extends TimeComponent {

    public  final TextAsset text;

    public TextDecalComponent( TextAsset text, float time ) {
        this.text = text;
        this.time=time;
    }
}
