package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.TextInteract;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class InteractComponent implements Component {

    private TYPE_OF_INTERACT type;
    private Item             item;
    private TextInteract     textInteract;


    public Item getItem () {
        return item;
    }


    public TextInteract getTextInteract () {
        return textInteract;
    }


    public InteractComponent ( TYPE_OF_INTERACT type, Item id ) {
        this.type = type;
        this.item = id;
        this.textInteract = null;
    }


    public InteractComponent ( TYPE_OF_INTERACT type, TextInteract textInteract ) {
        this.type = type;
        this.item = null;
        this.textInteract = textInteract;
    }


    public InteractComponent ( TYPE_OF_INTERACT type ) {
        this.type = type;
    }


    public TYPE_OF_INTERACT getType () {
        return type;
    }
}
