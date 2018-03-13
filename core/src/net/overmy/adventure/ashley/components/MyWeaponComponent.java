package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Matrix4;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.TextBlock;


/**
 * Created by Andrey (cb) Mikheev
 * 13.03.2018
 */

public class MyWeaponComponent implements Component {
    public final Node    hand;
    public final Matrix4 transform;


    public MyWeaponComponent ( Node hand, Matrix4 transform ) {
        this.hand = hand;
        this.transform = transform;
    }
}
