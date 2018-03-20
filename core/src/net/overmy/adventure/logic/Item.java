package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 28.02.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.resources.TextAsset;

public enum Item {
    //DIALOG(),

    YELLOW_STAR,
    BLUE_STAR,
    GREEN_STAR,

    GREEN_BOTTLE,
    RED_BOTTLE,

    COIN,

    BROOM_WEAPON,
    RAKE_WEAPON,
    KALASH_WEAPON,
    FENCE_WEAPON,

    /*GAME_STUFF1( "Первый предмет", "Подробное описание этого первого предмета", 0 ),
    GAME_STUFF2( "Какой-то второй предмет", "Описание второго предмета", 1 ),
    GAME_STUFF3( "Третий", "Очень длинное описание третьего предмета", 2 ),
    GAME_STUFF4( "Четвертый предмет", "Описание четвертого", 3 ),
    GAME_STUFF5( "предмет 5", "Описание пятое", 4 ),
    GAME_STUFF6( "6 предмет", "Описание шестое", 5 ),*/;

    private TextAsset name;
    private TextAsset about;
    private IMG       imageID;


    public static void init () {
        // connect Item enum to IMG enum
        // connect Item enum to TextAsset enum
        Item.YELLOW_STAR.setData( IMG.YSTAR, TextAsset.YELLOW_STAR, TextAsset.MONEY_ABOUT );
        Item.BLUE_STAR.setData( IMG.BSTAR, TextAsset.BLUE_STAR, TextAsset.MONEY_ABOUT );
        Item.GREEN_STAR.setData( IMG.GSTAR, TextAsset.GREEN_STAR, TextAsset.MONEY_ABOUT );
        Item.COIN.setData( IMG.COIN, TextAsset.COIN, TextAsset.MONEY_ABOUT );

        Item.GREEN_BOTTLE.setData( IMG.GREEN_BOTTLE, TextAsset.GREEN_BOTTLE,
                                   TextAsset.GREEN_BOTTLE_ABOUT );
        Item.RED_BOTTLE.setData( IMG.RED_BOTTLE, TextAsset.RED_BOTTLE, TextAsset.RED_BOTTLE_ABOUT );

        Item.BROOM_WEAPON.setData( IMG.WEAPON1, TextAsset.BROOM_WEAPON,
                                   TextAsset.BROOM_WEAPON_ABOUT );
        Item.RAKE_WEAPON.setData( IMG.WEAPON2, TextAsset.RAKE_WEAPON, TextAsset.RAKE_WEAPON_ABOUT );
        Item.KALASH_WEAPON.setData( IMG.WEAPON3, TextAsset.KALASH_WEAPON,
                                    TextAsset.KALASH_WEAPON_ABOUT );
        Item.FENCE_WEAPON.setData( IMG.WEAPON4, TextAsset.FENCE_WEAPON,
                                   TextAsset.FENCE_WEAPON_ABOUT );
    }


    private void setData ( IMG i, TextAsset n, TextAsset a ) {
        this.imageID = i;
        this.name = n;
        this.about = a;
    }


    public String getName () {
        return name.get();
    }


    public String getAbout () {
        return about.get();
    }


    public Image getImage ( final float width, final float height ) {
        return imageID.getImageActor( width, height );
    }
}
