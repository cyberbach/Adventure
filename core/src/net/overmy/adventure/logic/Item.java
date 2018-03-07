package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 28.02.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import net.overmy.adventure.resources.IMG;

public enum Item {
    DIALOG( "test", "test2", 0 ),

    GAME_STUFF1( "Первый предмет", "Подробное описание этого первого предмета", 0 ),
    GAME_STUFF2( "Какой-то второй предмет", "Описание второго предмета", 1 ),
    GAME_STUFF3( "Третий", "Очень длинное описание третьего предмета", 2 ),
    GAME_STUFF4( "Четвертый предмет", "Описание четвертого", 3 ),
    GAME_STUFF5( "предмет 5", "Описание пятое", 4 ),
    GAME_STUFF6( "6 предмет", "Описание шестое", 5 ),
    ;

    private String name;
    private String about;
    private int    imageID;


    Item ( String name, String about, int imageID ) {
        this.name = name;
        this.about = about;
        this.imageID = imageID;
    }


    public String getName () {
        return name;
    }


    public String getAbout () {
        return about;
    }


    public Image getImage ( final float width, final float height ) {
        return IMG.values()[ imageID ].getImageActor( width, height );
    }
}
