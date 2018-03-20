package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

public enum TextAsset {
    Title( "Приключения зверят", "EnimalKids Adventures" ),
    // buttons
    START_GAME( "Начать игру", "Start game" ),
    OPTIONS( "Настройки", "Options" ),
    MUSIC( "Музыка", "Music" ),
    SOUND( "Звуки", "Sound" ),
    END( "конец игры", "Game over" ),
    VERT( "вертикально", "Vertical" ),
    HORIZ( "горизонтально", "Horizontal" ),
    // ingame text
    INVENTORY( "Инвентарь", "Inventory" ),
    LOOT( "Подобрать : ", "Loot : " ),
    TALK( "Начать диалог : ", "Talk to : " ),
    USE( "Использовать : ", "Use : " ),

    // item section
    YELLOW_STAR( "Желтая звезда", "Yellow star" ),
    MONEY_ABOUT( "Это валюта", "It's a money" ),
    BLUE_STAR( "Синяя звезда", "Blue star" ),
    GREEN_STAR( "Зеленая звезда", "Green star" ),

    GREEN_BOTTLE( "Зелёный сироп", "Green syrup" ),
    GREEN_BOTTLE_ABOUT( "Ускоряет передвижение на 15 секунд",
                        "Accelerates movement for 15 seconds" ),
    RED_BOTTLE( "Красный сок", "Red juice" ),
    RED_BOTTLE_ABOUT( "Восполняет здоровье", "Restore health points" ),

    COIN( "Золотая монета", "Gold coin" ),

    BROOM_WEAPON( "Метла", "The broom" ),
    BROOM_WEAPON_ABOUT( "Это оружие. Подробное описание этого первого предмета\nУрон:35",
                        "This weapon. A detailed description of this first subject\nDamage: 35" ),
    RAKE_WEAPON( "Грабли", "Rake" ),
    RAKE_WEAPON_ABOUT( "Это оружие. Описание второго предмета, Описание второго предмета.\nУрон:60",
                       "This weapon. Description of the second subject, Description of the second subject.\nDamage: 60" ),
    KALASH_WEAPON( "AK-74", "AK-74" ),
    KALASH_WEAPON_ABOUT(
            "Это оружие. Очень Очень Очень Очень Очень длинное Очень длинное Очень длинное описание третьего предмета\nУрон:110",
            "This weapon. Very Very Very Very Very Long Very Long Very long description of the third item\nDamage: 110" ),
    FENCE_WEAPON( "Забор", "Fence" ),
    FENCE_WEAPON_ABOUT( "Это оружие\nУрон:150", "Weapon.\nDamage: 150" ),;

    public static boolean russianLocale = true;
    private final String russianText;
    private final String englishText;


    TextAsset ( String russianText ) {
        this.russianText = russianText;
        this.englishText = "";
    }


    TextAsset ( String russianText, String englishText ) {
        this.russianText = russianText;
        this.englishText = englishText;
    }


    public static void init () {
        String defaultLocale = java.util.Locale.getDefault().toString();
        Gdx.app.debug( "Default locale", "" + defaultLocale );
        //russianLocale = "ru_RU".equals( defaultLocale );
        russianLocale=false;
    }


    public String get () {
        return russianLocale ? russianText : englishText;
    }
}
