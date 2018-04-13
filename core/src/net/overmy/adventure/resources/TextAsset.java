package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

import net.overmy.adventure.DEBUG;

public enum TextAsset {
    Title( "Квики\nв поисках Мики", "Quicky\nin search of Mikkey" ),
    // buttons
    END_GAME( "Приключения закончились", "Adventures are finished" ),
    START_GAME( "Начать игру", "Start game" ),
    RESUME_GAME( "Продолжить", "Resume" ),
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
    READ( "Прочитать : ", "Read : " ),
    USE( "Использовать : ", "Use : " ),

    // item section
    YELLOW_STAR( "Желтая звезда", "Yellow star" ),
    MONEY_ABOUT( "Это валюта", "It's a money" ),
    BLUE_STAR( "Синяя звезда", "Blue star" ),
    GREEN_STAR( "Зеленая звезда", "Green star" ),

    KEY1( "Песочный ключ", "Sand key" ),
    KEY1_ABOUT( "Открывает дверь на острове", "Opens the door on the island" ),
    KEY2( "Цветочный ключ", "Flower key" ),
    KEY2_ABOUT( "Возможно этот ключ подойдет к замку, где-то за невидимой стеной",
                "Perhaps this key will fit the lock, somewhere behind the invisible wall" ),
    KEY3( "Деревянный ключ", "Wooden key" ),
    KEY3_ABOUT( "Открывает деревянные двери на зелёной поляне",
                "Opens the wooden door on a green meadow" ),
    KEY4( "Каменный ключ", "Stone key" ),
    KEY4_ABOUT( "Открывает ворота замка", "Opens the gate of the castle" ),
    KEY5( "Ледяной ключ", "Ice key" ),
    KEY5_ABOUT( "Подойдет к замку на снежных тропах", "Will fit the lock on the snowy trails" ),
    KEY6( "Ржавый ключ", "Rusty key" ),
    KEY6_ABOUT( "Этим ключом можно открыть двери на задворках замка",
                "With this key you can open the doors at the back of the castle." ),

    BLUE_BOTTLE( "Синий компот", "Blue compote" ),
    BLUE_BOTTLE_ABOUT( "Бессмертие на 30 секунд", "Immortality for 30 seconds" ),
    GREEN_BOTTLE( "Зелёный сироп", "Green syrup" ),
    GREEN_BOTTLE_ABOUT( "Ускоряет передвижение на 15 секунд",
                        "Accelerates movement for 15 seconds" ),
    RED_BOTTLE( "Красный сок", "Red juice" ),
    RED_BOTTLE_ABOUT( "Восполняет здоровье", "Restore health points" ),
    PURPLE_BOTTLE( "Виноградный нектар", "Grape nectar" ),
    PURPLE_BOTTLE_ABOUT( "Большие прыжки на 15 секунд", "Big jumps for 15 seconds" ),

    COIN( "Золотая монета", "Gold coin" ),

    // Фразы NPC

    BEWARE_ME_BUNNY( "Ну, заяц, погоди!", "Feel my power!" ),

    // Оружие

    BAT_WEAPON( "Примадонна Дорогуша", "Famous bat Darlin" ),
    BAT_WEAPON_ABOUT( "Этой битой была выиграна известная игра в Чикаго.\nУрон: 50",
                      "This bat won a famous game in Chicago.\nDamage: 50" ),

    PILLOW_WEAPON( "Подушка", "Pillow" ),
    PILLOW_WEAPON_ABOUT(
            "Эпичная подушка героя на которой возможно спала Принцесса на горошине.\nУрон: 10",
            "Epic pillow of the hero on which the Princess on the pea probably slept.\nDamage: 10" ),

    BROOM_WEAPON( "Метла", "The broom" ),
    BROOM_WEAPON_ABOUT( "Любимая метла Золушки. Она ей очень дорожила.\nУрон: 35",
                        "Favorite Cinderella broom. She treasured her very much.\nDamage: 35" ),
    RAKE_WEAPON( "Грабли", "Rake" ),
    RAKE_WEAPON_ABOUT( "Джек ухаживал этими граблями за волшебными бобами.\nУрон:60",
                       "Jack took care of these rakes for magic beans.\nDamage: 60" ),
    KALASH_WEAPON( "Убойный аппарат", "Slaughter machine" ),
    KALASH_WEAPON_ABOUT(
            "Это знаменитый аппарат, который не поделили Братья Гавс.\nУрон: 110",
            "This is a famous device that the Beagle Boys did not share.\nDamage: 110" ),
    FENCE_WEAPON( "Забор", "Fence" ),
    FENCE_WEAPON_ABOUT( "Эту часть забора разрушил Фердинанд, перед своим побегом.\nУрон: 150",
                        "This part of the fence was destroyed by Ferdinand, before his escape.\nDamage: 150" ),
    GUN_WEAPON( "Пистолет. На палке", "Gun. On stick" ),
    GUN_WEAPON_ABOUT(
            "Черный плащ потерял это оружие во время последней схватки с Морганой Макабр.\nУрон: 120",
            "Darkwing Duck lost this weapon during the last fight with Morgana McCawber.\nDamage: 120" ),

    // Улучшенное оружие

    BAT_WEAPON_UPGRADED( "Бита Люсиль", "Lucille bat" ),
    BAT_WEAPON_UPGRADED_ABOUT( "Любимая бита Нигана.\nУрон: 250",
                               "Favorite bat of Nigan.\nDamage: 250" ),

    PILLOW_WEAPON_UPGRADED( "Тяжелая подушка", "Heavy pillow" ),
    PILLOW_WEAPON_UPGRADED_ABOUT(
            "Эпичная тяжелая подушка героя, на которой возможно спал Шрэк.\nУрон: 30",
            "Epic heavy pillow of the hero, on which Shrek could have slept.\nDamage: 30" ),
    BROOM_WEAPON_UPGRADED( "Метла уборщика", "The cleaner broom" ),
    BROOM_WEAPON_UPGRADED_ABOUT(
            "Любимая метла Золушки. После волшеного вмешательства Крёстной она получила удивительные ствойства.\nУрон: 80",
            "Favorite Cinderella broom. After the wolf intervention of the godmother, she received amazing characteristics.\nDamage: 80" ),
    RAKE_WEAPON_UPGRADED( "Новые грабли", "New Rake" ),
    RAKE_WEAPON_UPGRADED_ABOUT( "Джек ухаживал этими граблями за волшебным стеблем.\nУрон: 120",
                                "Jack took care of these rakes for the magic stalk.\nDamage: 120" ),
    KALASH_WEAPON_UPGRADED( "Мощный аппарат", "Power machine" ),
    KALASH_WEAPON_UPGRADED_ABOUT(
            "Это любимый аппарат Мамаши Гавс.\nУрон: 170",
            "This is the favorite device of Ma Beagle.\nDamage: 170" ),
    FENCE_WEAPON_UPGRADED( "Укреплённый забор", "Fortified Fence" ),
    FENCE_WEAPON_UPGRADED_ABOUT(
            "Часть нового укрепленного забора, которую опять разрушил Фердинанд, перед своим побегом.\nУрон: 190",
            "Part of the new fortified fence, which Ferdinand again destroyed, before his escape.\nDamage: 190" ),
    GUN_WEAPON_UPGRADED( "Крутой пистолет. На палке", "Cool gun. On a stick" ),
    GUN_WEAPON_UPGRADED_ABOUT(
            "Зигзаг МакКряк потерял это оружие в поиске несметных сокровищ.\nУрон: 190",
            "Launchpad McQuack lost this weapon in the search for untold treasures.\nDamage: 190" ),

    // Разное

    TRIGGER_HELP1( "Не забудь взять оружие!", "Do not forget\nto take the weapon!" ),
    TRIGGER_HELP2( "Чтобы использовать оружие,\nзайди в инвентарь и возьми его в руку.",
                   "To use weapons,\nopen inventory and put it in your hand." ),
    TRIGGER_HELP3( "Зелёные бутылки\nускоряют передвижение!",
                   "Green Bottles\naccelerate the movement!" ),
    TRIGGER_HELP4( "Разрушай коробки.\nОни могут содержать интересные вещи!",
                   "Destroy the boxes.\nThey can contain interesting things inside!" ),
    TRIGGER_HELP5( "Поговори с ежиком", "Talk to a hedgehog" ),
    TRIGGER_HELP6( "В инвентаре можно объединить\nдва одинаковых оружия\nв одно более мощное!",
                   "In inventory, you can combine\ntwo identical weapons\nto one more powerful!" ),
    TRIGGER_HELP7( "Не все стены одинаково прочны.", "Not all walls are equally strong." ),
    TRIGGER_HELP8( "Попробуй прыгнуть", "Try to jump" ),
    TRIGGER_HELP9( "Бельчонку предстоит длинное путешествие", "The squirrel will have a long journey" ),
    TRIGGER_HELP10( "У акулы ключ от ворот!", "The shark has the key to the gate!" ),
    TRIGGER_HELP11( "Ворота можно открыть только\nподходящим ключом.",
                    "The gate can only be opened\nthe right key." ),
    TRIGGER_HELP12( "Зелье неуязвимости пригодится в битве",
                    "The invulnerability potion is useful in battle" ),
    TRIGGER_HELP13( "Лиса Алиса хочет загадать несколько загадок",
                    "Alice the Fox wants to make a few riddles" ),
    TRIGGER_HELP14( "Это место полно секретов", "This place is full of secrets" ),

    BEARTEXT1( "Гульман, выходи!", "Gulman, come on!" ),
    BEARTEXT2( "Опять шедевр делает...", "New masterpiece is coming..." ),

    //33 43
    TestString1(
            "aaaaa12345aaaaa 6789 , 9876 aaaaa54321aaaaa\naaaaa12345aaaaa 6789 , 9876 aaaaa54321aaaaa",
            "Опять шедевр делает...\nasdf sdaf dsfsdfdsfsdf sdf dsfdsfds" ),
    TestString2( "12345 6789 0 9876 54321" ),
    TestString3( "a . b" ),
    ;

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
        String clsName = TextAsset.class.getSimpleName();
        Gdx.app.debug( "" + clsName + " locale", "" + defaultLocale );
        russianLocale = !DEBUG.ENABLE_ENGLISH_TEXT.get() && "ru_RU".equals( defaultLocale );
    }


    public String get () {
        return russianLocale ? russianText : englishText;
    }
}
