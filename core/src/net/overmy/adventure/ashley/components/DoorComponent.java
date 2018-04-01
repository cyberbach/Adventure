package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.scenes.scene2d.Group;

import net.overmy.adventure.logic.Item;

/*
      Created by Andrey Mikheev on 16.03.2018
      Contact me → http://vk.com/id17317
 */

public class DoorComponent implements Component {
    public Item itemForOpenDoor;
    public float startAngle;
    public float endAngle;
    public float currentAngle;


    public DoorComponent ( Item itemForOpenDoor, float startAngle, float endAngle ) {
        this.itemForOpenDoor = itemForOpenDoor;
        this.startAngle = startAngle;
        this.currentAngle = startAngle;
        this.endAngle = endAngle;
    }
}
