package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

public enum TextAsset {
    Title( "Приключения зверят" ),
    START_GAME( "Начать игру" ),
    OPTIONS( "Настройки" ),
    MUSIC( "Музыка", "Music" ),
    SOUND( "Звуки", "Sound" ),
    END( "конец игры" ),
    VERT( "вертикально" ),
    HORIZ( "горизонтально" ),
    INVENTORY( "Инвентарь" ),
    LOOT( "Подобрать : " ),
    TALK( "Начать диалог : " ),
    USE( "Использовать : " ),
    ;

    public static boolean russianLocale = true;
    private final String russianText;
    private final String englishText;



    TextAsset( String russianText ) {
        this.russianText = russianText;
        this.englishText = "";
    }



    TextAsset( String russianText, String englishText ) {
        this.russianText = russianText;
        this.englishText = englishText;
    }



    public static void init() {
        String defaultLocale = java.util.Locale.getDefault().toString();
        Gdx.app.debug( "Default locale", "" + defaultLocale );
        russianLocale = "ru_RU".equals( defaultLocale );
    }



    public String get() {
        return russianLocale ? russianText : englishText;
    }
}
