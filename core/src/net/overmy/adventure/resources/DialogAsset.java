package net.overmy.adventure.resources;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;

import net.overmy.adventure.DEBUG;

public enum DialogAsset {
    Empty( "" ),
    CloseDialog( "Закончить диалог", "End the dialogue" ),
    CloseBook( "Закрыть книгу", "Close the book" ),
    Back( "Назад", "Back" ),
    Next( "Далее", "Next" ),


    Miki( "Братишка Мики", "Brother Mickey" ),
    Dialog10Text1( "О! Квики, ты нашел меня!", "Oh, Quicky, you've found me!" ),
    Dialog10Text1V( "Мики, как ты здесь очутился?", "Mickey, how did you end up here?" ),
    Dialog10Text2( "Я гулял и забыл куда шел =) Надеюсь мама не будет сердиться! =)",
                   "I walked and I forgot where I was going =) I hope my mother will not be angry! =) " ),
    Dialog10Text2V( "Отправляемся домой =)", "We go home =)" ),
    Dialog10Text3( "Хорошо. Твои приключения закончились? =)",
                   "Well, are your adventures over? =)" ),
    Dialog10Text3V( "Посмотрим... =)", "We'll see ... =)" ),


    HogPrickle( "Ежик Колючка", "Prickle Hog" ),
    Dialog1Text(
            "Ты ищешь своего братишку? Я видел его последний раз рядом с большой елкой на поляне с бабочками. Тебе пригодятся в пути припасы, которые ты можешь купить у меня.",
            "Have you been looking for your brother? I saw him last time next to a big tree in a meadow with butterflies. You will need supplies that you can buy from me. " ),

    HogPester( "Ежик Приставучка", "Pester Hog" ),
    Dialog2Text( "Если тебе нужны припасы, то у меня кое-что есть.",
                 "If you need supplies, then I have something." ),

    FoxAlice( "Лисичка Алиса", "Chanterelle Alice" ),
    Dialog3Text1(
            "Послушай дружок. Если сможешь отгадать 3 моих загадки, я дам отдам тебе подушку.",
            "If you can guess my 3 riddles, I'll give you all I have." ),
    Dialog3Text1V3( "Я попробую.", "I'll try." ),
    Dialog3Text2( "Первый вопрос, слушай внимательно! Что такое:\n\n" +
                  "Не огонь, А жжется?",
                  "The first question, listen carefully! What is:\n\n" +
                  "Do not fire, but burns?" ),
    Dialog3Text2V1( "Крапива", "Nettle" ),
    Dialog3Text2V2( "Костер", "Bonfire" ),
    Dialog3Text2V3( "Спичка", "Matches" ),
    Dialog3Text3( "Верно! Теперь вторая загадка:\n\n" +
                  "Красна девица Сидит в темнице,\n" +
                  "А коса на улице?",
                  "Now, the second riddle:\n\n" +
                  "Beaty sits in the dungeon,\n" +
                  "And the scythe on the street?" ),
    Dialog3Text3V1( "Рапунцель", "Rapunzel" ),
    Dialog3Text3V2( "Варвара-краса", "Barbie" ),
    Dialog3Text3V3( "Морковка", "Carrot" ),
    Dialog3Text4( "Отлично! А сейчас самый сложная загадка:\n\n" +
                  "Кто по елкам ловко скачет\n" +
                  "И взлетает на дубы?\n" +
                  "Кто в дупле орешки прячет,\n" +
                  "Сушит на зиму грибы?",
                  "Great! But now the most difficult riddle:\n\n" +
                  "Who on the fir trees deftly jumps \n" +
                  "And takes off on the oaks? \n" +
                  "Who hides nuts in a hollow, \n" +
                  "Does it dry mushrooms for the winter?" ),
    Dialog3Text4V1( "Белка", "Squirrel" ),
    Dialog3Text4V2( "Лисичка", "Chanterelles" ),
    Dialog3Text4V3( "Медвежонок", "Bear cub" ),
    Dialog3Text5( "Великолепно! Держи свою подушку!", "Keep your pillow!" ),

    Kaksonic( "Ежик Кексоник", "Keksonik the hog " ),
    Dialog5Text( "Бельчонок Квики. Тебе нужно зелье ускорения?",
                 "Quicky, do you need an acceleration stuff?" ),

    TopaElephant( "Слоник Топа", "Elephant Boomer" ),
    Dialog6Text( "Бельчонок Квики. Отгадаешь мои загадки?", "Squirrel Quicky, guess my riddles?" ),
    Dialog6Text1V1( "Попробую!", "Ok. I'll try!" ),
    Dialog6Text2( "Чтож начнем! Попробуй отгадай:\n\n" +
                  "Конь бежит, Земля дрожит.",
                  "Let's start! Try to guess:\n\n" +
                  "The horse is running,\n" +
                  "the Earth is trembling." ),
    Dialog6Text2V1( "Гром", "Thunder" ),
    Dialog6Text2V2( "Слон", "Elephant" ),
    Dialog6Text2V3( "Муравей", "Ant" ),
    Dialog6Text3( "Правильно. Отгадай такую загадку:\n\nРаскаленная стрела дуб свалила у села.",
                  "Correctly, guess this riddle:\n\n" +
                  "The stunned arrow of an oak fell off the village." ),
    Dialog6Text3V1( "Молния", "Lightning" ),
    Dialog6Text3V2( "Глупость", "Stupidity" ),
    Dialog6Text3V3( "Метла", "Broom" ),
    Dialog6Text4(
            "Ты очень смышленый бельчонок. Попробуй отгадай такую загадку:\n\n" +
            "Два братца в воду глядятся,\n" +
            "Век не сойдутся.",
            "You are a very intelligent little squirrel. Try to guess this riddle:\n\n" +
            "Two brothers look into the water,\n" +
            "Age does not converge." ),
    Dialog6Text4V1( "Берега", "Coasts" ),
    Dialog6Text4V2( "Заяц и волк", "Tom and Jerry" ),
    Dialog6Text4V3( "Ладошки", "Arms" ),
    Dialog6Text5( "Отлично. Держи монеты!", "Fine, hold the coins!" ),

    RacoonBaby( "Енотик Крошка", "Raccoon Little One" ),
    Dialog7Text1( "Здравствуй Квики. Наверное ты хочешь разгадать интересные загадки?",
                  "Helloб Quicky, do you want to solve interesting riddles?" ),
    Dialog7Text1V1( "Конечно!", "Of course!"
    ),
    Dialog7Text2( "Отгадай загадку:\n\n" +
                  "Разноцветное коромысло\n" +
                  "Над рекой повисло.",
                  "Guess the riddle:\n\n" +
                  "Only colored rocker \n" +
                  "Let the river hang." ),
    Dialog7Text2V1( "Радуга", "Rainbow" ),
    Dialog7Text2V2( "Мост", "Bridge" ),
    Dialog7Text2V3( "Дерево", "Tree" ),
    Dialog7Text3( "Правильно, Квики. Попробуй отгадать такую загадку:\n\n" +
                  "Рогатый, а не бодается.",
                  "Quite right, Quicky. Try to guess this riddle:\n\n" +
                  "Horned, not baked." ),
    Dialog7Text3V1( "Месяц", "The moon" ),
    Dialog7Text3V2( "Муж", "Husband" ),
    Dialog7Text3V3( "Лосяш", "Elk" ),
    Dialog7Text4(
            "Опять ты прав! Но сможешь ли ты отгадать последнюю загадку?\n\n" +
            "Без рук, без ног,\n" +
            "Под окном стучится,\n" +
            "В дом просится.",
            "Again, you're right, but can you guess the last riddle?\n\n" +
            "Without a hand, without legs,\n" +
            "On the window it knocks,\n" +
            "I ask for a house." ),
    Dialog7Text4V1( "Ветер", "Wind" ),
    Dialog7Text4V2( "Солнечный зайчик", "Sunny bunny" ),
    Dialog7Text4V3( "Ветка дерева", "Tree branch" ),
    Dialog7Text5( "Отлично, Квики. Вот твоя награда!", "Fine, Quicky, here's your reward!" ),

    NigelBird( "Птичка Найджел", "Birdie Nigel" ),
    Dialog8Text1(
            "Квики, как рад тебя видеть! У меня кое-что есть, и я тебе это дам, если отгадаешь мои загадки.",
            "Quicky, it's good to see you. I have something, and I'll give it to you, if you guess my riddles." ),
    Dialog8Text1V1( "Я попробую.", "I'll try." ),
    Dialog8Text2( "Первая загадка:\n" +
                  "Белый камушек растаял,\n" +
                  "на доске следы оставил.",
                  "The first riddle:\n\n" +
                  "The white pebble melted,\n" +
                  "left traces on the board." ),
    Dialog8Text2V1( "Мел", "A piece of chalk" ),
    Dialog8Text2V2( "Снег", "Snow" ),
    Dialog8Text2V3( "Дождь", "Rain" ),
    Dialog8Text3( "Верно. Вторая загадка. Слушай:\n\n" +
                  "Без рук, а рисует,\n" +
                  "Без зубов, а кусает.",
                  "True, the second riddle. Listen:\n" +
                  "Without hand, but draws,\n" +
                  "Without teeth, but bites." ),
    Dialog8Text3V1( "Мороз", "Frost" ),
    Dialog8Text3V2( "Пришелец", "The newcomer" ),
    Dialog8Text3V3( "Крапива", "Nettle" ),
    Dialog8Text4( "И снова правильно.\n" +
                  "Третья загадка:\n" +
                  "Зимой - звезда,\n" +
                  "Весной - вода.",
                  "And again it's right.\n" +
                  "Third puzzle:\n\n" +
                  "The star is the one, \n" +
                  "The spring is water." ),
    Dialog8Text4V1( "Снежинка", "Snowflake" ),
    Dialog8Text4V2( "Солнце", "The sun" ),
    Dialog8Text4V3( "Луна", "Moon" ),
    Dialog8Text5( "Молодец, бельчонок Квики. Держи, это убойный аппарат!",
                  "Well done, little squirrel Quicky. Take it, it's a killer device!" ),

    CheinieRacoon( "Енотик Чейни", "Raccoon Cheney" ),
    Dialog9Text1( "Квики. Ты просто скажи мне: когда\n" +
                  "Мне ничто осветит этот путь в никуда?\n" +
                  "Трудна твоя дорога в поиске Мики? Да!\n" +
                  "Хочешь ускориться? Отгадай тогда.",
                  "Quicky, you just tell me: when \n" +
                  "Nothing will illuminate this path to nowhere? \n" +
                  "Is your path in finding Miki difficult? Yes! \n" +
                  "Do you want to accelerate? Guess then." ),
    Dialog9Text1V1( "Я попробую.", "I will try." ),
    Dialog9Text2( "Я такие простые загадки загадываю кошке:\n\n" +
                  "Стоял на крепкой ножке, Теперь лежит в лукошке.",
                  "I'm guessing such simple riddles for a cat: \n" +
                  "Standing on a sturdy leg, Now lies in a basket." ),
    Dialog9Text2V1( "Гриб", "Mushroom" ),
    Dialog9Text2V2( "Рояль", "Piano" ),
    Dialog9Text3( "Верно. Квики, кросавчик, но\n" +
                  "Моя речь вопросами обрастает:\n\n" +
                  "Целый день летает, всем надоедает,\n" +
                  "Ночь настанет, тогда перестанет.",
                  "True, Quicky, beauty, but \n" +
                  "My speech is becoming obsolete:\n\n" +
                  "The whole day flies, all bored, \n" +
                  "The night will come, then it will stop." ),
    Dialog9Text3V1( "Муха", "Fly" ),
    Dialog9Text3V2( "Сова", "Owl" ),
    Dialog9Text3V3( "Жаворонок", "Skylark" ),
    Dialog9Text4(
            "Правильно, белочонок. \n" +
            "У меня от твоих ответов шерсть столбом,\n" +
            "Отгадай еще и получишь приз потом:\n\n" +
            "Вырос в поле дом - Полон дом зерном.\n" +
            "Стены позолочены, Ставни заколочены.\n" +
            "И стоит новый дом \n" +
            "На столбе золотом.",
            "That's right, a little squirrel.\n" +
            "At me from your answers a wool a column,\n" +
            "Guess more and get a prize later:\n\n" +
            "Grew up in the field house - The house is full of grain.\n" +
            "The walls are gilded, The shutters are boarded up.\n" +
            "And there is a new house\n" +
            "On a pillar of gold." ),
    Dialog9Text4V1( "Колосок", "Spikelet" ),
    Dialog9Text4V2( "Золотая клетка", "The Golden Cage" ),
    Dialog9Text4V3( "Звезда", "Star" ),
    Dialog9Text5(
            "Все верно, все правильно.\n" +
            "Держи свой зеленый квас!\n" +
            "Встретишь Мики, передавай привет.\n" +
            "Не забывай нас,\n" +
            "Ракета на марс, Ракета на марс,\n" +
            "Порой мы незаметны но быстры как барс.",
            "All right, all right. \n" +
            "Keep your green syrup! \n" +
            "Meet Miki, say hello." +
            "\nDo not forget us," +
            "\n Mars rocket, rocket to Mars," +
            "\n Sometimes we are invisible, but fast as a leopard." ),


    Dialog_afterQuest( "Здравствуй, Квики.", "Hello, Quicky." ),

    // BOOOOOKS

    BookName( "Интересная книга", "Interesting book" ),

    Book1Body( "Бельчонок Квики всегда сильно переживает, когда Мики убегает.",
               "The little squirrel Quicky always experiences a lot when Mickey runs away." ),
    Book2Body(
            "Мики всегда больше любили в семье, из-за этого он вырос избалованным. Любитель пошалить!",
            "Mickey always liked more in the family, because of this he grew spoiled. Lover to fool around!" ),
    Book3Body( "Квики очень много помогает по дому своей маме. Она его за это хвалит.",
               "Quicky helps a lot in the house of her mother. She praises him for it." ),
    Book4Body(
            "Родители Квики и Мики часто купали их вместе. А бельчата резво плескались в воде и играли.",
            "The parents of Quicky and Mickey often bathed them together. And the belchachas briskly splashed in the water and played." ),
    Book5Body(
            "Квики выращивал возле дома морковку, а Мики часто вытаскивал морковь с грядки и менял ее за Зеленый сироп. Он называл сироп - гликодин.",
            "Quicky grew a carrot near the house, and Mickey often pulled carrots from the bed and changed it for Green Syrup. He called syrup - glycodin." ),
    Book6Body(
            "Мики приходилось часто восстанавливаться после зеленого сиропа, ведь он отнимал не только силы, но и разум.",
            "Mickey often had to recover from the green syrup, because he took away not only the strength, but also the mind." ),
    Book7Body( "За Квики и Мики ухаживала бабушка, она им часто готовила пирожки с мясом.",
               "Grandma took care of Quicky and Mickey, she often cooked pies with meat." ),
    Book8Body( "Квики испытывал нежные чувства к бабушке. Она ему никогда ни в чем не отказывала.",
               "Quicky had tender feelings for his grandmother. She never refused anything to him." ),
    Book9Body(
            "У Квики и Мики был еще один братишка - белка летяга. Он рано покинул родное гнездо.",
            "Quicky and Mickey had one more brother - a flying squirrel. He left his native nest early." ),
    Book10Body(
            "Белки девочки часто собирают в лесу всякий хлам. За это их ласково называют - Гаечка.",
            "Proteins girls often collect in the forest any rubbish. For this they are affectionately called - Gadget." ),

    Book11Body(
            "В семье Квики иногда рождались сестренки. Но они куда-то исчезали. А бабушка в отчаянии пекла пирожки, чтобы успокоить бельчат.",
            "In the Quicky family, sisters were sometimes born. But they disappeared somewhere. Grandmother, in desperation, baked pies to appease the squirrels." ),
    Book12Body(
            "Одним голодным летом бельчатам приходилось питаться тем, что находили в лесу. Они искали свежие кучки, странно что они не питались ягодами.",
            "One hungry summer squirrels had to eat what they found in the forest. They were looking for fresh heaps, it's strange that they did not eat berries." ),
    Book13Body(
            "Когда Мики сильно шалил, его мама запирала в подвале. Но все равно очень любила его.",
            "When Mickey was very naughty, his mother locked in the basement. But still very fond of him." ),
    Book14Body(
            "Квики любил пошутить над Мики. Когда Мики заперли в подвале, Квики использовал подвал в качестве туалета.",
            "Quicky liked to make fun of Mickey. When Mickey was locked in the basement, Quicky used the basement as a toilet." ),
    Book15Body(
            "Отец Квики рано ушел из семьи и их мать постоянно приводила чужих белочек в дом. Эти чужие плохо относились к бельчатам, об этом говорят постоянные синяки под глазами.",
            "Quicky's father left the family early and their mother constantly brought in other people's squirrels into the house. These strangers treated poorly little squirrels, this is indicated by permanent bruises under the eyes." ),
    Book16Body(
            "Семью Квики и Мики ненавидят в волшебном лесу. Всем известно, что они любители поохотится на других белок. А потом рядом с их домом очень неприятные запахи.",
            "The family Quicky and Mickey hate in the magic forest. Everyone knows that they like hunters for other proteins. And then next to their house very unpleasant smells." ),
    Book17Body(
            "Пока Мики был совсем малышом, Квики забирался в его кроватку и оставлял в ней небольшую кучку. Родители никак не могли догадаться, что это делал Квики.",
            "While Mickey was quite a kid, Quicky climbed into his crib and left in it a small pile. Parents could not guess what Quicky did." ),
    Book18Body(
            "Семья бельчат любит отмечать праздники. Они накрывают стол перед домом, зовут гостей и угощают их пирожками с мясом. Очень дружелюбная семья.",
            "The squirrels family likes to celebrate holidays. They set the table in front of the house, call the guests and treat them to meat pies. Very friendly family." ),
    Book19Body(
            "Квики часто показывает Мики как нужно себя вести, как добывать себе еду и что пригодно в пищу. Мики не очень нравятся нравоучения и он все делает по-своему.",
            "Quicky often shows Mickey how to behave, how to get your own food and what is suitable for food. Mickey does not really like moralizing and he does everything in his own way." ),
    Book20Body(
            "Мики и Квики очень любят пирожки. Но пока что мама и бабушка их не пускают на кухню. Хранят кулинарные секретики!",
            "Mickey and Quicky are very fond of pies. But meanwhile, mother and grandmother are not allowed to enter the kitchen. Keep culinary secrets!" ),

    Book21Body( "Раньше Квики и Мики часто играли под мостом. Что же они там делали?",
                "Previously, Quicky and Mickey often played under the bridge. What did they do there?" ),
    Book22Body(
            "Квики никогда долго не сердился над Мики. Даже если подвешивал его за хвост на дереве, Квики быстро успокаивался и снимал его.",
            "Quicky never longed to be angry with Mickey. Even if he hung it by the tail on a tree, Quicky is quickly calmed down and took it off." ),
    Book23Body(
            "Дома у Квики на полу лежит болшая шкура белого медведя. Бельчата любят валяться на шкуре и играть.",
            "At home, Quicky has a big polar bear skin on the floor. Squirrels like to wallow on the skin and play." ),
    Book24Body( "В особенно холодные зимы, бельчата носят варежки из кроличьего меха.",
                "In especially cold winters, squirrels wear rabbit fur." ),
    Book25Body(
            "Мики очень любит играть с зайчатами и кроликами. Что он с ними только не делает. Вот озорник-затейник!",
            "Mickey likes to play with rabbits and rabbits very much. What he does with them just does not. Here is a mischievous inventor!" ),
    Book26Body(
            "Папа Квики пропал. Мама никак не могла прекратить плакать. Одно не понятно - откуда у них дома под кроватью валяется чей-то оторванный хвост.",
            "Quicky's farther is disappeared. Mom could not stop crying. One thing is not clear - whence they have someone's tail torn off under the bed." ),
    Book27Body(
            "Однажды Мики и Квики нашли далеко от дома чьи-то лапки, торчащие из земли. Они были очень похожи на лапки их отца, но это скорее всего совпадение.",
            "Once Mickey and Quicky found far away from the house someone's paws sticking out of the ground. They were very similar to their father's paws, but this is most likely a coincidence." ),
    Book28Body(
            "Квики часто снился сон. Он разговаривал с Богом, вернее выслушивал его нравоучения. Но на утро всегда забывал сон.",
            "Quicky often dreamed a dream. He talked with God, or rather listened to his moralizing. But in the morning he always forgot a dream." ),
    Book29Body(
            "Квики старше своего братика на 15 лет. Квики умнее Мики и часто объясняет ему простые вещи.",
            "Quicky is older than his brother for 15 years. Quicky is smarter than Mickey and often explains simple things to him." ),
    Book30Body( "Мики никогда не помогал Квики ни в чем. Он только радуется жизни и бездельничает.",
                "Mickey never helped Quicky in anything. He only enjoys life and idles." ),

    // Покупки в магазине

    BuyGreenBottle10coins( "Зеленый сироп 10 монет", "Green syrup 10 coins" ),
    BuyGreenBottle2green( "Зеленый сироп 2 зеленые звезды", "Green syrup 2 green stars" ),
    BuyRedBottle10coins( "Красный сок 10 монет", "Red juice 10 coins" ),
    BuyBlueBottle3blue( "Синий компот 3 синих звезды", "Blue compote 3 blue stars" ),
    BuyBlueBottle3yellow( "Синий компот за 3 желтых звезды", "Blue compote 3 yellow stars" ),
    BuyPurpleBottle5coins( "Виноградный нектар за 5 монет", "Grape nectar 5 coins" ),
    BuyBroom15coins( "Купить метлу за 15 монет", "Broom 15 coins" ),;

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


    public static void init () {
        String defaultLocale = java.util.Locale.getDefault().toString();
        String clsName = DialogAsset.class.getSimpleName();
        Gdx.app.debug( "" + clsName + " locale", "" + defaultLocale );
        russianLocale = !DEBUG.ENABLE_ENGLISH_TEXT.get() && "ru_RU".equals( defaultLocale );
    }


    public String get () {
        return russianLocale ? russianText : englishText;
    }
}
