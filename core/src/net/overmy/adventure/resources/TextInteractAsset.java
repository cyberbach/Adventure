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



    HogPrickle( "ежик\nКолючка" ),
    Dialog1Text( "Ты ищешь своего братишку? Я видел его последний раз рядом с большой елкой на поляне с бабочками. Тебе пригодятся в пути припасы, которые ты можешь купить у меня." ),
    Dialog1TextV1( "Купить бутылку жизни 10 монет" ),
    Dialog1TextV2( "Купить бутылку ускорения 10 монет" ),
    Dialog1TextV3( "Купить метлу 15 монет" ),

    HogPester( "ежик\nПриставучка" ),
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
    Dialog3Text2V2( "Костер" ),
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
    Dialog3Text5( "Великолепно! (звук клевый) Держи свою подушку!" ),

    BasilioTheCat("Котик Базилио"),
    Dialog4Text("Привет бельчонок! Тебя... случайно... не интересует? КЛЮЧ! Немного ржавый, но очень нужный."),
    Dialog4TextV("Ржавый ключ за 50 монет"),

    Kaksonic("Ежик Каксоник"),
    Dialog5Text("Бельчонок Квики. Тебе нужно зелье ускорения?"),
    Dialog5TextV("Ускорение за 5 монет"),

    TopaElephant("Слоник Топа"),
    Dialog6Text("Бельчонок Квики. Отгадаешь мои загадки?"),
    Dialog6Text1V1("Попробую!"),
    Dialog6Text2("Чтож начнем! Попробуй отгадай:\nКонь бежит, Земля дрожит."),
    Dialog6Text2V1("Гром+"),
    Dialog6Text2V2("Слон"),
    Dialog6Text2V3("Муравей"),
    Dialog6Text3("Правильно. Отгадай такую загадку:\nРаскаленная стрела дуб свалила у села."),
    Dialog6Text3V1("Молния+"),
    Dialog6Text3V2("Глупость"),
    Dialog6Text3V3("Метла"),
    Dialog6Text4("Ты очень смышленый бельчонок. Попробуй отгадай такую загадку:\nДва братца в воду глядятся, Век не сойдутся."),
    Dialog6Text4V1("Берега+"),
    Dialog6Text4V2("Заяц и волк"),
    Dialog6Text4V3("Ладошки"),
    Dialog6Text5("Отлично. Держи монеты!"),

    RacoonBaby("Енотик Крошка"),
    Dialog7Text1("Здравствуй Квики. Наверное ты хочешь разгадать интересные загадки?"),
    Dialog7Text1V1("Конечно!"),
    Dialog7Text2("Отгадай загадку:\nРазноцветное коромысло\nНад рекой повисло."),
    Dialog7Text2V1("Радуга+"),
    Dialog7Text2V2("Мост"),
    Dialog7Text2V3("Дерево"),
    Dialog7Text3("Правильно, Квики. Попробуй отгадать такую загадку:\nРогатый, а не бодается."),
    Dialog7Text3V1("Месяц+"),
    Dialog7Text3V2("Муж"),
    Dialog7Text3V3("Лосяш"),
    Dialog7Text4("Опять ты прав! Но сможешь ли ты отгадать последнюю загадку?\nБез рук, без ног,\nПод окном стучится,\nВ дом просится."),
    Dialog7Text4V1("Ветер+"),
    Dialog7Text4V2("Солнечный зайчик"),
    Dialog7Text4V3("Ветка дерева"),
    Dialog7Text5("Отлично, Квики. Вот твоя награда! (сверху падает кусок забора)"),

    NigelBird("Птичка Найджел"),
    Dialog8Text1("Квики, как рад тебя видеть! У меня кое-что есть, и я тебе это дам, если отгадаешь мои загадки."),
    Dialog8Text1V1("Я попробую."),
    Dialog8Text2("Первая загадка:\nБелый камушек растаял, на доске следы оставил."),
    Dialog8Text2V1("Мел+"),
    Dialog8Text2V2("Снег"),
    Dialog8Text2V3("Дождь"),
    Dialog8Text3("Верно. Вторая загадка. Слушай:\nБез рук, а рисует,\nБез зубов, а кусает."),
    Dialog8Text3V1("Мороз+"),
    Dialog8Text3V2("Пришелец"),
    Dialog8Text3V3("Крапива"),
    Dialog8Text4("И снова правильно.\nТретья загадка:\nЗимой - звезда,\nВесной - вода."),
    Dialog8Text4V1("Снежинка+"),
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
    Dialog9Text2V1("Гриб+"),
    Dialog9Text2V2("Рояль"),
    Dialog9Text3("Верно. Квики, кросавчик, но\n" +
                 "Моя речь вопросами обрастает:\n" +
                 "Целый день летает, всем надоедает,\n" +
                 "Ночь настанет, тогда перестанет."),
    Dialog9Text3V1("Муха+"),
    Dialog9Text3V2("Сова"),
    Dialog9Text3V3("Жаворонок"),
    Dialog9Text4("Правильно, белочонок. \n" +
                 "У меня от твоих ответов шерсть столбом,\n" +
                 "Отгадай еще и получишь приз потом:\n" +
                 "Вырос в поле дом - Полон дом зерном.\n" +
                 "Стены позолочены, Ставни заколочены.\n" +
                 "И стоит новый дом \n" +
                 "На столбе золотом."),
    Dialog9Text4V1("Колосок+"),
    Dialog9Text4V2("Золотая клетка"),
    Dialog9Text4V3("Звезда"),
    Dialog9Text5("Все верно, все правильно.\nДержи свой зеленый квас!\n" +
                 "Встретишь Мики, передавай привет.\nНе забывай нас,\n" +
                 "Ракета на марс, Ракета на марс,\n" +
                 "Порой мы незаметны но быстры как барс."),



    NPC2text( "Беги вперед и найдешь!", "1 eng" ),
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
