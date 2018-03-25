package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

import net.overmy.adventure.DEBUG;

public enum TextInteractAsset {
    Empty( "" ),
    CloseDialog( "Закончить диалог", "1 eng" ),
    CloseBook( "Закрыть книгу", "Close book" ),
    Back( "Назад", "1 eng" ),

    NPC1Name( "Ёжик","npc 1 name" ),
    Next( "Далее","next eng" ),
    NPC1text( "Что ты хочешь узнать?", "1 eng" ),
    NPC1variant1( "Как добежать до следующего острова?", "2 eng" ),
    NPC1variant2( "Что нужно собирать?", "3 eng" ),
    NPC1variant3( "Нет времени с тобой говорить.", "3 eng" ),

    NPC2text( "Беги вперёд и найдешь!", "1 eng" ),
    NPC3text( "Собирай бонусы.", "1 eng" ),
    NPC4text( "Не хочешь говорить - твои проблемы!", "1 eng" ),

    BookName( "Книга помощи","Help Book" ),
    Book1Body( "asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    ;

    public static boolean russianLocale = true;
    private final String russianText;
    private final String englishText;



    TextInteractAsset ( String russianText ) {
        this.russianText = russianText;
        this.englishText = "";
    }



    TextInteractAsset ( String russianText, String englishText ) {
        this.russianText = russianText;
        this.englishText = englishText;
    }



    public static void init() {
        String defaultLocale = java.util.Locale.getDefault().toString();
        Gdx.app.debug( "Default locale", "" + defaultLocale );
        russianLocale = !DEBUG.ENABLE_ENGLISH_TEXT.get() && "ru_RU".equals( defaultLocale );
    }



    public String get() {
        return russianLocale ? russianText : englishText;
    }
}
