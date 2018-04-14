package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.MyDialog;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class InteractComponent implements Component {

    private TYPE_OF_INTERACT type;
    private Item             item;
    private MyDialog         myDialog;


    public Item getItem () {
        return item;
    }


    public MyDialog getMyDialog () {
        return myDialog;
    }


    public InteractComponent ( TYPE_OF_INTERACT type, Item id ) {
        this.type = type;
        this.item = id;
        this.myDialog = null;
    }


    public InteractComponent ( TYPE_OF_INTERACT type, MyDialog myDialog ) {
        this.type = type;
        this.item = null;
        this.myDialog = myDialog;
    }


    public InteractComponent ( TYPE_OF_INTERACT type ) {
        this.type = type;
    }


    public TYPE_OF_INTERACT getType () {
        return type;
    }
}
