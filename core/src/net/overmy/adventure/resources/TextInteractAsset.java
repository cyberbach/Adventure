package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

import net.overmy.adventure.DEBUG;

public enum TextInteractAsset {
    Empty( "" ),
    CloseDialog( "Закончить диалог" ),
    CloseBook( "Закрыть книгу" ),
    Back( "Назад" ),
    Next( "Далее" ),



    HogPrickle( "Ёжик\nКолючка" ),
    Dialog1Text( "Ты ищешь своего братишку? Я видел его последний раз рядом с большой ёлкой на поляне с бабочками. Тебе пригодятся в пути припасы, которые ты можешь купить у меня." ),
    Dialog1TextV1( "Купить бутылку жизни 10 монет" ),
    Dialog1TextV2( "Купить бутылку ускорения 10 монет" ),
    Dialog1TextV3( "Купить метлу 15 монет" ),

    HogPester( "Ёжик\nПриставучка" ),
    Dialog2Text( "Если тебе нужны припасы, то у меня кое-что есть." ),
    Dialog2TextV1( "Купить бутылку жизни 10 монет" ),
    Dialog2TextV2( "бутылка ускорения 10 монет" ),
    Dialog2TextV3( "бутылка прыжок 3 фиалетовых звезды" ),

    FoxAlice( "Лисичка\nАлиса" ),
    Dialog3Text1( "Послушай дружок. Если сможешь отгадать 3 моих загадки, я дам отдам тебе подушку." ),
    Dialog3Text1V1( "Купить бутылка прыжок 3 фиалетовых звезды" ),
    Dialog3Text1V2( "Купить подушку за 20 монет" ),
    Dialog3Text1V3( "Я попробую." ),
    Dialog3Text2( "Первый вопрос, слушай внимательно! Что такое: Не огонь, А жжется?" ),
    Dialog3Text2V1( "Крапива +" ),
    Dialog3Text2V2( "Костёр" ),
    Dialog3Text2V3( "Спичка" ),
    Dialog3Text3( "Верно! Теперь вторая загадка: Красна девица Сидит в темнице, А коса на улице?" ),
    Dialog3Text3V1( "Рапунцель" ),
    Dialog3Text3V2( "Варвара-краса" ),
    Dialog3Text3V3( "Морковка +" ),
    Dialog3Text4( "Отлично! А сейчас самый сложная загадка:\n" +
                  "Кто по елкам ловко скачет\n" +
                  "И взлетает на дубы?\n" +
                  "Кто в дупле орешки прячет,\n" +
                  "Сушит на зиму грибы?" ),
    Dialog3Text4V1( "Белка" ),
    Dialog3Text4V2( "Лисичка" ),
    Dialog3Text4V3( "Медвежонок" ),
    Dialog3Text5( "Великолепно! (звук клёвый) Держи свою подушку!" ),





    NPC2text( "Беги вперёд и найдешь!", "1 eng" ),
    NPC3text( "Собирай бонусы.", "1 eng" ),
    NPC4text( "Не хочешь говорить - твои проблемы!", "1 eng" ),

    BookName( "Книга помощи","Help Book" ),
    Book1Body( "asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),

    BuyRedBottle( "Купить бутылку жизни 10 монет","BuyRedBottle 10 coins" ),
    BuyGreenBottle( "Купить бутылку ускорения 10 монет","BuyGreenBottle 10 coins" ),
    BuyRake( "Купить метлу 15 монет","BuyRake 15 coins" ),
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
