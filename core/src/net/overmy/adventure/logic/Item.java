package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 28.02.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.TextAsset;

public enum Item {
    //DIALOG(),

    YELLOW_STAR,
    BLUE_STAR,
    GREEN_STAR,

    GREEN_BOTTLE,
    RED_BOTTLE,
    PURPLE_BOTTLE,

    COIN,

    BROOM_WEAPON,
    RAKE_WEAPON,
    KALASH_WEAPON,
    FENCE_WEAPON,
    PILLOW_WEAPON,

    /*GAME_STUFF1( "Первый предмет", "Подробное описание этого первого предмета", 0 ),
    GAME_STUFF2( "Какой-то второй предмет", "Описание второго предмета", 1 ),
    GAME_STUFF3( "Третий", "Очень длинное описание третьего предмета", 2 ),
    GAME_STUFF4( "Четвертый предмет", "Описание четвертого", 3 ),
    GAME_STUFF5( "предмет 5", "Описание пятое", 4 ),
    GAME_STUFF6( "6 предмет", "Описание шестое", 5 ),*/
    TRIGGER1,// не забудь взять оружие
    TRIGGER2;

    private TextAsset  name       = null;
    private TextAsset  about      = null;
    private IMG        imageID    = null;
    private ModelAsset modelAsset = null;


    public static void init () {
        // connect Item enum to IMG enum, TextAsset enum, ModelAsset enum
        Item.COIN.setIMG( IMG.COIN )
                 .setName( TextAsset.COIN )
                 .setAbout( TextAsset.MONEY_ABOUT )
                 .setModel( ModelAsset.COIN );

        Item.YELLOW_STAR.setIMG( IMG.YSTAR )
                        .setName( TextAsset.YELLOW_STAR )
                        .setAbout( TextAsset.MONEY_ABOUT )
                        .setModel( ModelAsset.YSTAR );

        Item.BLUE_STAR.setIMG( IMG.BSTAR )
                      .setName( TextAsset.BLUE_STAR )
                      .setAbout( TextAsset.MONEY_ABOUT )
                      .setModel( ModelAsset.BSTAR );

        Item.GREEN_STAR.setIMG( IMG.GSTAR )
                       .setName( TextAsset.GREEN_STAR )
                       .setAbout( TextAsset.MONEY_ABOUT )
                       .setModel( ModelAsset.GSTAR );

        Item.GREEN_BOTTLE.setIMG( IMG.GREEN_BOTTLE )
                         .setName( TextAsset.GREEN_BOTTLE )
                         .setAbout( TextAsset.GREEN_BOTTLE_ABOUT )
                         .setModel( ModelAsset.GREEN_BOTTLE );

        Item.RED_BOTTLE.setIMG( IMG.RED_BOTTLE )
                       .setName( TextAsset.RED_BOTTLE )
                       .setAbout( TextAsset.RED_BOTTLE_ABOUT )
                       .setModel( ModelAsset.RED_BOTTLE );

        Item.PURPLE_BOTTLE.setIMG( IMG.PURPLE_BOTTLE )
                          .setName( TextAsset.PURPLE_BOTTLE )
                          .setAbout( TextAsset.PURPLE_BOTTLE_ABOUT )
                          .setModel( ModelAsset.PURPLE_BOTTLE );

        Item.BROOM_WEAPON.setIMG( IMG.WEAPON1 )
                         .setName( TextAsset.BROOM_WEAPON )
                         .setAbout( TextAsset.BROOM_WEAPON_ABOUT )
                         .setModel( ModelAsset.BROOM_WEAPON );

        Item.RAKE_WEAPON.setIMG( IMG.WEAPON2 )
                        .setName( TextAsset.RAKE_WEAPON )
                        .setAbout( TextAsset.RAKE_WEAPON_ABOUT )
                        .setModel( ModelAsset.RAKE_WEAPON );

        Item.KALASH_WEAPON.setIMG( IMG.WEAPON3 )
                          .setName( TextAsset.KALASH_WEAPON )
                          .setAbout( TextAsset.KALASH_WEAPON_ABOUT )
                          .setModel( ModelAsset.KALASH_WEAPON );

        Item.FENCE_WEAPON.setIMG( IMG.WEAPON4 )
                         .setName( TextAsset.FENCE_WEAPON )
                         .setAbout( TextAsset.FENCE_WEAPON_ABOUT )
                         .setModel( ModelAsset.FENCE_WEAPON );

        Item.PILLOW_WEAPON.setIMG( IMG.PILLOW )
                         .setName( TextAsset.PILLOW_WEAPON )
                         .setAbout( TextAsset.PILLOW_WEAPON_ABOUT )
                         .setModel( ModelAsset.PILLOW_WEAPON );
    }


    public Item setModel ( ModelAsset modelAsset ) {
        this.modelAsset = modelAsset;
        return this;
    }


    public Item setName ( TextAsset name ) {
        this.name = name;
        return this;
    }


    public Item setAbout ( TextAsset about ) {
        this.about = about;
        return this;
    }


    public Item setIMG ( IMG imageID ) {
        this.imageID = imageID;
        return this;
    }


    public ModelAsset getModelAsset () {
        return modelAsset;
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
