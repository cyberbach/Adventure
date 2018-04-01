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
    BLUE_BOTTLE,

    COIN,
    KEY1,
    KEY2,
    KEY3,
    KEY4,
    KEY5,
    KEY6,

    BROOM_WEAPON,
    RAKE_WEAPON,
    KALASH_WEAPON,
    FENCE_WEAPON,
    PILLOW_WEAPON,
    GUN_WEAPON,
    BAT_WEAPON,

    BROOM_WEAPON_UPGRADED,
    RAKE_WEAPON_UPGRADED,
    KALASH_WEAPON_UPGRADED,
    FENCE_WEAPON_UPGRADED,
    PILLOW_WEAPON_UPGRADED,
    GUN_WEAPON_UPGRADED,
    BAT_WEAPON_UPGRADED,

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
    private boolean    weapon     = false;


    public boolean isWeapon () {
        return weapon;
    }


    public static void init () {
        // connect Item enum to IMG enum, TextAsset enum, ModelAsset enum
        Item.KEY1
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY1 )
                .setAbout( TextAsset.KEY1_ABOUT )
                .setModel( ModelAsset.KEY );
        Item.KEY2
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY2 )
                .setAbout( TextAsset.KEY2_ABOUT )
                .setModel( ModelAsset.KEY );
        Item.KEY3
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY3 )
                .setAbout( TextAsset.KEY3_ABOUT )
                .setModel( ModelAsset.KEY );
        Item.KEY4
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY4 )
                .setAbout( TextAsset.KEY4_ABOUT )
                .setModel( ModelAsset.KEY );
        Item.KEY5
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY5 )
                .setAbout( TextAsset.KEY5_ABOUT )
                .setModel( ModelAsset.KEY );
        Item.KEY6
                .setIMG( IMG.KEY )
                .setName( TextAsset.KEY6 )
                .setAbout( TextAsset.KEY6_ABOUT )
                .setModel( ModelAsset.KEY );

        Item.COIN
                .setIMG( IMG.COIN )
                .setName( TextAsset.COIN )
                .setAbout( TextAsset.MONEY_ABOUT );

        Item.YELLOW_STAR
                .setIMG( IMG.YSTAR )
                .setName( TextAsset.YELLOW_STAR )
                .setAbout( TextAsset.MONEY_ABOUT );

        Item.BLUE_STAR
                .setIMG( IMG.BSTAR )
                .setName( TextAsset.BLUE_STAR )
                .setAbout( TextAsset.MONEY_ABOUT );

        Item.GREEN_STAR
                .setIMG( IMG.GSTAR )
                .setName( TextAsset.GREEN_STAR )
                .setAbout( TextAsset.MONEY_ABOUT );

        Item.GREEN_BOTTLE
                .setIMG( IMG.GREEN_BOTTLE )
                .setName( TextAsset.GREEN_BOTTLE )
                .setAbout( TextAsset.GREEN_BOTTLE_ABOUT );

        Item.RED_BOTTLE
                .setIMG( IMG.RED_BOTTLE )
                .setName( TextAsset.RED_BOTTLE )
                .setAbout( TextAsset.RED_BOTTLE_ABOUT );

        Item.PURPLE_BOTTLE
                .setIMG( IMG.PURPLE_BOTTLE )
                .setName( TextAsset.PURPLE_BOTTLE )
                .setAbout( TextAsset.PURPLE_BOTTLE_ABOUT );

        Item.BLUE_BOTTLE
                .setIMG( IMG.BLUE_BOTTLE )
                .setName( TextAsset.BLUE_BOTTLE )
                .setAbout( TextAsset.BLUE_BOTTLE_ABOUT );

        // weapons

        Item.BROOM_WEAPON
                .itIsWeapon()
                .setIMG( IMG.WEAPON1 )
                .setName( TextAsset.BROOM_WEAPON )
                .setAbout( TextAsset.BROOM_WEAPON_ABOUT )
                .setModel( ModelAsset.BROOM_WEAPON );

        Item.RAKE_WEAPON
                .itIsWeapon()
                .setIMG( IMG.WEAPON2 )
                .setName( TextAsset.RAKE_WEAPON )
                .setAbout( TextAsset.RAKE_WEAPON_ABOUT )
                .setModel( ModelAsset.RAKE_WEAPON );

        Item.KALASH_WEAPON
                .itIsWeapon()
                .setIMG( IMG.WEAPON3 )
                .setName( TextAsset.KALASH_WEAPON )
                .setAbout( TextAsset.KALASH_WEAPON_ABOUT )
                .setModel( ModelAsset.KALASH_WEAPON );

        Item.FENCE_WEAPON
                .itIsWeapon()
                .setIMG( IMG.WEAPON4 )
                .setName( TextAsset.FENCE_WEAPON )
                .setAbout( TextAsset.FENCE_WEAPON_ABOUT )
                .setModel( ModelAsset.FENCE_WEAPON );

        Item.PILLOW_WEAPON
                .itIsWeapon()
                .setIMG( IMG.PILLOW )
                .setName( TextAsset.PILLOW_WEAPON )
                .setAbout( TextAsset.PILLOW_WEAPON_ABOUT )
                .setModel( ModelAsset.PILLOW_WEAPON );

        Item.GUN_WEAPON
                .itIsWeapon()
                .setIMG( IMG.GUN )
                .setName( TextAsset.GUN_WEAPON )
                .setAbout( TextAsset.GUN_WEAPON_ABOUT )
                .setModel( ModelAsset.GUN_WEAPON );

        Item.BAT_WEAPON
                .itIsWeapon()
                .setIMG( IMG.BAT )
                .setName( TextAsset.BAT_WEAPON )
                .setAbout( TextAsset.BAT_WEAPON_ABOUT )
                .setModel( ModelAsset.BAT_WEAPON );

        // улучшенное оружие

        Item.BROOM_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.WEAPON1 )
                .setName( TextAsset.BROOM_WEAPON_UPGRADED  )
                .setAbout( TextAsset.BROOM_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.BROOM_WEAPON );

        Item.RAKE_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.WEAPON2 )
                .setName( TextAsset.RAKE_WEAPON_UPGRADED )
                .setAbout( TextAsset.RAKE_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.RAKE_WEAPON );

        Item.KALASH_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.WEAPON3 )
                .setName( TextAsset.KALASH_WEAPON_UPGRADED )
                .setAbout( TextAsset.KALASH_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.KALASH_WEAPON );

        Item.FENCE_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.WEAPON4 )
                .setName( TextAsset.FENCE_WEAPON_UPGRADED )
                .setAbout( TextAsset.FENCE_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.FENCE_WEAPON );

        Item.PILLOW_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.PILLOW )
                .setName( TextAsset.PILLOW_WEAPON_UPGRADED )
                .setAbout( TextAsset.PILLOW_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.PILLOW_WEAPON );

        Item.GUN_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.GUN )
                .setName( TextAsset.GUN_WEAPON_UPGRADED )
                .setAbout( TextAsset.GUN_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.GUN_WEAPON );

        Item.BAT_WEAPON_UPGRADED
                .itIsWeapon()
                .setIMG( IMG.BAT )
                .setName( TextAsset.BAT_WEAPON_UPGRADED )
                .setAbout( TextAsset.BAT_WEAPON_UPGRADED_ABOUT )
                .setModel( ModelAsset.BAT_WEAPON );
    }


    private Item setModel ( ModelAsset modelAsset ) {
        this.modelAsset = modelAsset;
        return this;
    }


    private Item setName ( TextAsset name ) {
        this.name = name;
        return this;
    }


    private Item itIsWeapon () {
        this.weapon = true;
        return this;
    }


    private Item setAbout ( TextAsset about ) {
        this.about = about;
        return this;
    }


    private Item setIMG ( IMG imageID ) {
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
