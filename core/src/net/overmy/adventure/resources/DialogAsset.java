package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

import net.overmy.adventure.DEBUG;

public enum DialogAsset {
    Empty( "" ),
    CloseDialog( "Закончить диалог" ),
    CloseBook( "Закрыть книгу" ),
    Back( "Назад" ),
    Next( "Далее" ),



    Miki( "Братишка Мики" ),
    Dialog10Text1( "О! Квики, ты нашел меня!" ),
    Dialog10Text1V( "Мики, как ты здесь очутился?" ),
    Dialog10Text2( "Я гулял и забыл куда шел. Надеюсь мама не будет сердиться!" ),
    Dialog10Text2V( "Отправляемся домой. Дома поговорим." ),
    Dialog10Text3( "Хорошо. Твои приключения закончились?" ),
    Dialog10Text3V( "Посмотрим..." ),


    HogPrickle( "Ежик Колючка" ),
    Dialog1Text( "Ты ищешь своего братишку? Я видел его последний раз рядом с большой елкой на поляне с бабочками. Тебе пригодятся в пути припасы, которые ты можешь купить у меня." ),

    HogPester( "Ежик Приставучка" ),
    Dialog2Text( "Если тебе нужны припасы, то у меня кое-что есть." ),

    FoxAlice( "Лисичка Алиса" ),
    Dialog3Text1( "Послушай дружок. Если сможешь отгадать 3 моих загадки, я дам отдам тебе подушку." ),
    Dialog3Text1V3( "Я попробую." ),
    Dialog3Text2( "Первый вопрос, слушай внимательно! Что такое: Не огонь, А жжется?" ),
    Dialog3Text2V1( "Крапива" ),
    Dialog3Text2V2( "Костер" ),
    Dialog3Text2V3( "Спичка" ),
    Dialog3Text3( "Верно! Теперь вторая загадка: Красна девица Сидит в темнице, А коса на улице?" ),
    Dialog3Text3V1( "Рапунцель" ),
    Dialog3Text3V2( "Варвара-краса" ),
    Dialog3Text3V3( "Морковка" ),
    Dialog3Text4( "Отлично! А сейчас самый сложная загадка:\n" +
                  "Кто по елкам ловко скачет\n" +
                  "И взлетает на дубы?\n" +
                  "Кто в дупле орешки прячет,\n" +
                  "Сушит на зиму грибы?" ),
    Dialog3Text4V1( "Белка" ),
    Dialog3Text4V2( "Лисичка" ),
    Dialog3Text4V3( "Медвежонок" ),
    Dialog3Text5( "Великолепно! Держи свою подушку!" ),

    Kaksonic("Ежик Каксоник"),
    Dialog5Text("Бельчонок Квики. Тебе нужно зелье ускорения?"),

    TopaElephant("Слоник Топа"),
    Dialog6Text("Бельчонок Квики. Отгадаешь мои загадки?"),
    Dialog6Text1V1("Попробую!"),
    Dialog6Text2("Чтож начнем! Попробуй отгадай:\nКонь бежит, Земля дрожит."),
    Dialog6Text2V1("Гром"),
    Dialog6Text2V2("Слон"),
    Dialog6Text2V3("Муравей"),
    Dialog6Text3("Правильно. Отгадай такую загадку:\nРаскаленная стрела дуб свалила у села."),
    Dialog6Text3V1("Молния"),
    Dialog6Text3V2("Глупость"),
    Dialog6Text3V3("Метла"),
    Dialog6Text4("Ты очень смышленый бельчонок. Попробуй отгадай такую загадку:\nДва братца в воду глядятся, Век не сойдутся."),
    Dialog6Text4V1("Берега"),
    Dialog6Text4V2("Заяц и волк"),
    Dialog6Text4V3("Ладошки"),
    Dialog6Text5("Отлично. Держи монеты!"),

    RacoonBaby("Енотик Крошка"),
    Dialog7Text1_afterQuest("Здравствуй Квики."),
    Dialog7Text1("Здравствуй Квики. Наверное ты хочешь разгадать интересные загадки?"),
    Dialog7Text1V1("Конечно!"),
    Dialog7Text2("Отгадай загадку:\nРазноцветное коромысло\nНад рекой повисло."),
    Dialog7Text2V1("Радуга"),
    Dialog7Text2V2("Мост"),
    Dialog7Text2V3("Дерево"),
    Dialog7Text3("Правильно, Квики. Попробуй отгадать такую загадку:\nРогатый, а не бодается."),
    Dialog7Text3V1("Месяц"),
    Dialog7Text3V2("Муж"),
    Dialog7Text3V3("Лосяш"),
    Dialog7Text4("Опять ты прав! Но сможешь ли ты отгадать последнюю загадку?\nБез рук, без ног,\nПод окном стучится,\nВ дом просится."),
    Dialog7Text4V1("Ветер"),
    Dialog7Text4V2("Солнечный зайчик"),
    Dialog7Text4V3("Ветка дерева"),
    Dialog7Text5("Отлично, Квики. Вот твоя награда!"),

    NigelBird("Птичка Найджел"),
    Dialog8Text1("Квики, как рад тебя видеть! У меня кое-что есть, и я тебе это дам, если отгадаешь мои загадки."),
    Dialog8Text1V1("Я попробую."),
    Dialog8Text2("Первая загадка:\nБелый камушек растаял, на доске следы оставил."),
    Dialog8Text2V1("Мел"),
    Dialog8Text2V2("Снег"),
    Dialog8Text2V3("Дождь"),
    Dialog8Text3("Верно. Вторая загадка. Слушай:\nБез рук, а рисует,\nБез зубов, а кусает."),
    Dialog8Text3V1("Мороз"),
    Dialog8Text3V2("Пришелец"),
    Dialog8Text3V3("Крапива"),
    Dialog8Text4("И снова правильно.\nТретья загадка:\nЗимой - звезда,\nВесной - вода."),
    Dialog8Text4V1("Снежинка"),
    Dialog8Text4V2("Солнце"),
    Dialog8Text4V3("Луна"),
    Dialog8Text5("Молодец, бельчонок Квики. Держи, это убойный аппарат!"),

    CheinieRacoon("Енотик Чейни"),
    Dialog9Text1("Квики. Ты просто скажи мне: когда\n" +
                 "Мне ничто осветит этот путь в никуда?\n" +
                 "Трудна твоя дорога в поиске Мики? Да!\n" +
                 "Хочешь ускориться? Отгадай тогда."),
    Dialog9Text1V1("Я попробую."),
    Dialog9Text2("Я такие простые загадки загадываю кошке:\n" +
                 "Стоял на крепкой ножке, Теперь лежит в лукошке."),
    Dialog9Text2V1("Гриб"),
    Dialog9Text2V2("Рояль"),
    Dialog9Text3("Верно. Квики, кросавчик, но\n" +
                 "Моя речь вопросами обрастает:\n" +
                 "Целый день летает, всем надоедает,\n" +
                 "Ночь настанет, тогда перестанет."),
    Dialog9Text3V1("Муха"),
    Dialog9Text3V2("Сова"),
    Dialog9Text3V3("Жаворонок"),
    Dialog9Text4("Правильно, белочонок. \n" +
                 "У меня от твоих ответов шерсть столбом,\n" +
                 "Отгадай еще и получишь приз потом:\n" +
                 "Вырос в поле дом - Полон дом зерном.\n" +
                 "Стены позолочены, Ставни заколочены.\n" +
                 "И стоит новый дом \n" +
                 "На столбе золотом."),
    Dialog9Text4V1("Колосок"),
    Dialog9Text4V2("Золотая клетка"),
    Dialog9Text4V3("Звезда"),
    Dialog9Text5("Все верно, все правильно.\nДержи свой зеленый квас!\n" +
                 "Встретишь Мики, передавай привет.\nНе забывай нас,\n" +
                 "Ракета на марс, Ракета на марс,\n" +
                 "Порой мы незаметны но быстры как барс."),


/*

    NPC2text( "Беги вперед и найдешь!", "1 eng" ),
    NPC3text( "Собирай бонусы.", "1 eng" ),
    NPC4text( "Не хочешь говорить - твои проблемы!", "1 eng" ),
*/

    // BOOOOOKS

    BookName( "Интересная книга","Interesting book" ),
    Book1Body( "1111111 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book2Body( "22 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book3Body( "3333 as3Bofsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book4Body( "asdfsda4Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book5Body( "asdfsda5Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book6Body( "asdfsda6Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book7Body( "asdfsda7Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book8Body( "asdfsda8Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book9Body( "asdfsda9Bo sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book10Body( "asdfsd10Bf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),

    Book11Body( "11 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book12Body( "12 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book13Body( "13 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book14Body( "14 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book15Body( "15 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book16Body( "16 1 6 16 1 61 6 16 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book17Body( "17 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book18Body( "18 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book19Body( "19 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book20Body( "20 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),

    Book21Body( "21 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ), // про секрет под мостом
    Book22Body( "22 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book23Body( "23 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book24Body( "24 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book25Body( "25 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book26Body( "26 1 6 16 1 61 6 16 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book27Body( "27 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book28Body( "28 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book29Body( "29 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),
    Book30Body( "30 asdfsdaf sdf dsf sdfds fsd fdКнига помощи","Help Book" ),

    // Покупки в магазине

    BuyBlueBottle3blue( "Синий компот 3 синих звезды" ),
    BuyPurpleBottle5coins( "Виноградный нектар за 5 монет" ),
    BuyRedBottle10coins( "Красный сок 10 монет", "BuyRedBottle10coins 10 coins" ),
    BuyGreenBottle10coins( "Зелёный сироп 10 монет", "BuyGreenBottle10coins 10 coins" ),
    BuyGreenBottle2green( "Зелёный сироп 2 зелёные звезды", "BuyGreenBottle10coins 10 coins" ),
    BuyBlueBottle3yellow( "Синий компот за 3 желтых звезды" ),
    BuyBroom15coins( "Купить метлу за 15 монет", "BuyRake 15 coins" ),
    ;

    public static boolean russianLocale = true;
    private final String russianText;
    private final String englishText;



    DialogAsset ( String russianText ) {
        this.russianText = russianText;
        this.englishText = "";
    }



    DialogAsset ( String russianText, String englishText ) {
        this.russianText = russianText;
        this.englishText = englishText;
    }



    public static void init() {
        String defaultLocale = java.util.Locale.getDefault().toString();
        String clsName = DialogAsset.class.getSimpleName();
        Gdx.app.debug( "" + clsName + " locale", "" + defaultLocale );
        russianLocale = !DEBUG.ENABLE_ENGLISH_TEXT.get() && "ru_RU".equals( defaultLocale );
    }



    public String get() {
        return russianLocale ? russianText : englishText;
    }
}
