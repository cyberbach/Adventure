package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.TextBlock;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class InteractComponent implements Component {

    private TYPE_OF_INTERACT type;
    private Item             item;
    private TextBlock        textBlock;


    public Item getItem () {
        return item;
    }


    public TextBlock getTextBlock () {
        return textBlock;
    }


    public InteractComponent ( TYPE_OF_INTERACT type, Item id ) {
        this.type = type;
        this.item = id;
        this.textBlock = null;
    }

    public InteractComponent ( TYPE_OF_INTERACT type, TextBlock        textBlock ) {
        this.type = type;
        this.item = null;
        this.textBlock = textBlock;
    }


    public InteractComponent ( TYPE_OF_INTERACT type ) {
        this.type = type;
    }


    public TYPE_OF_INTERACT getType () {
        return type;
    }
}
