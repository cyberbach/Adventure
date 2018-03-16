package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 28.02.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import net.overmy.adventure.resources.IMG;

public enum Item {
    DIALOG( "test", "test2", 0 ),

    YELLOW_STAR("Желтая звезда","Это валюта"),
    BLUE_STAR("Синяя звезда","Это валюта"),
    GREEN_STAR("Зеленая звезда","Это валюта"),

    RED_BOTTLE("Красная бутылочка","Ускоряет передвижение на 10 секунд"),

    COIN("Золотая монета","Это валюта"),

    BROOM_WEAPON( "Метла", "Это оружие"),
    RAKE_WEAPON( "Грабли", "Это оружие"),
    KALASH_WEAPON( "AK-74", "Это оружие"),
    BORDER_WEAPON( "Забор", "Это оружие"),

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

    public static void setImages (){
        Item.YELLOW_STAR.setID( IMG.YSTAR );
        Item.BLUE_STAR.setID( IMG.BSTAR );
        Item.GREEN_STAR.setID( IMG.GSTAR );
        Item.COIN.setID( IMG.COIN );
        Item.RED_BOTTLE.setID( IMG.BOTTLE );

        Item.BROOM_WEAPON.setID( IMG.WEAPON1 );
        Item.RAKE_WEAPON.setID( IMG.WEAPON2 );
        Item.KALASH_WEAPON.setID( IMG.WEAPON3 );
        Item.BORDER_WEAPON.setID( IMG.WEAPON4 );

    }


    private void setID ( IMG img ) {
        this.imageID = img.ordinal();
    }


    public int getImageID () {
        return imageID;
    }


    Item ( String name, String about, int imageID ) {
        this.name = name;
        this.about = about;
        this.imageID = imageID;
    }

    Item ( String name, String about ) {
        this.name = name;
        this.about = about;
        this.imageID = 0;
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
