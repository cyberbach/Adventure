package net.overmy.adventure.logic;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.TextInteractAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 14.06.2017
 */

public enum TextInteract {

    // prickle

    Dialog1HogPrickle,
    Dialog1HogPrickleV1,
    Dialog1HogPrickleV2,
    Dialog1HogPrickleV3,

    // pester

    Dialog2HogPester,
    Dialog2HogPesterV1,
    Dialog2HogPesterV2,
    Dialog2HogPesterV3,

    // alice

    Dialog3FoxAlice,
    Dialog3FoxAliceV1,
    Dialog3FoxAliceV2,
    Dialog3FoxAliceV3,

    Dialog3FoxAliceQ1V1,
    Dialog3FoxAliceQ1V2,
    Dialog3FoxAliceQ1V3,

    Dialog3FoxAliceQ2V1,
    Dialog3FoxAliceQ2V2,
    Dialog3FoxAliceQ2V3,

    Dialog3FoxAliceQ3V1,
    Dialog3FoxAliceQ3V2,
    Dialog3FoxAliceQ3V3,

    // basilio

    Dialog4Basilio,
    Dialog4BasilioV1,

    // kaksonik
    Dialog5Kaksonik,
    Dialog5KaksonikV1,

    // Topa
    Dialog6Topa,
    Dialog6TopaQ1V1,
    Dialog6TopaQ2V1,
    Dialog6TopaQ2V2,
    Dialog6TopaQ2V3,
    Dialog6TopaQ3V1,
    Dialog6TopaQ3V2,
    Dialog6TopaQ3V3,
    Dialog6TopaQ4V1,
    Dialog6TopaQ4V2,
    Dialog6TopaQ4V3,

    // Baby Racoon
    Dialog7RacoonBaby,
    Dialog7RacoonBabyQ1V1,
    Dialog7RacoonBabyQ2V1,
    Dialog7RacoonBabyQ2V2,
    Dialog7RacoonBabyQ2V3,
    Dialog7RacoonBabyQ3V1,
    Dialog7RacoonBabyQ3V2,
    Dialog7RacoonBabyQ3V3,
    Dialog7RacoonBabyQ4V1,
    Dialog7RacoonBabyQ4V2,
    Dialog7RacoonBabyQ4V3,

    // Nigel the Bird
    Dialog8NigelBird,
    Dialog8NigelBirdQ1V1,
    Dialog8NigelBirdQ2V1,
    Dialog8NigelBirdQ2V2,
    Dialog8NigelBirdQ2V3,
    Dialog8NigelBirdQ3V1,
    Dialog8NigelBirdQ3V2,
    Dialog8NigelBirdQ3V3,
    Dialog8NigelBirdQ4V1,
    Dialog8NigelBirdQ4V2,
    Dialog8NigelBirdQ4V3,

    // Cheinie
    Dialog9CheinieRacoon,
    Dialog9CheinieRacoonQ1V1,
    Dialog9CheinieRacoonQ2V1,
    Dialog9CheinieRacoonQ2V2,
    Dialog9CheinieRacoonQ3V1,
    Dialog9CheinieRacoonQ3V2,
    Dialog9CheinieRacoonQ3V3,
    Dialog9CheinieRacoonQ4V1,
    Dialog9CheinieRacoonQ4V2,
    Dialog9CheinieRacoonQ4V3,



    Book1,
    Book2,
    Book3,
    Book4,
    Book5,
    Book6,
    Book7,
    Book8,
    Book9,
    Book10,
    Book11,
    Book12,
    Book13,
    Book14,
    Book15,
    Book16,
    Book17,
    Book18,
    Book19,
    Book20,
    ;

    private Array< TextInteract > connection = new Array< TextInteract >();

    private TextInteractAsset action = null;
    private TextInteractAsset title  = null;
    private TextInteractAsset body   = null;


    public static void init () {

        // Диалог с Ёжик Колючка

        Dialog1HogPrickle
                .setTitle( TextInteractAsset.HogPrickle )
                .setBody( TextInteractAsset.Dialog1Text )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog1HogPrickleV1, Dialog1HogPrickleV2,
                          Dialog1HogPrickleV3 );

        Dialog1HogPrickleV1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog1TextV1 )
                .connect( Dialog1HogPrickle );

        Dialog1HogPrickleV2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog1TextV2 )
                .connect( Dialog1HogPrickle );

        Dialog1HogPrickleV3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog1TextV3 )
                .connect( Dialog1HogPrickle );

        // Диалог с Ёжик Приставучка

        Dialog2HogPester
                .setTitle( TextInteractAsset.HogPester )
                .setBody( TextInteractAsset.Dialog2Text )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog2HogPesterV1, Dialog2HogPesterV2,
                          Dialog2HogPesterV3 );

        Dialog2HogPesterV1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog2TextV1 )
                .connect( Dialog2HogPester );

        Dialog2HogPesterV2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog2TextV2 )
                .connect( Dialog2HogPester );

        Dialog2HogPesterV3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog2TextV3 )
                .connect( Dialog2HogPester );

        // Диалог с Лисичкой Алисой
        Dialog3FoxAlice
                .setTitle( TextInteractAsset.FoxAlice )
                .setBody( TextInteractAsset.Dialog3Text1 )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog3FoxAliceV1, Dialog3FoxAliceV2, Dialog3FoxAliceV3 );

        Dialog3FoxAliceV1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text1V1 );

        Dialog3FoxAliceV2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text1V2 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceV3
                .setTitle( TextInteractAsset.FoxAlice )
                .setBody( TextInteractAsset.Dialog3Text2 )
                .actionToGoHere( TextInteractAsset.Dialog3Text1V3 )
                .connect( Dialog3FoxAliceQ1V1, Dialog3FoxAliceQ1V2, Dialog3FoxAliceQ1V3 );

        Dialog3FoxAliceQ1V1
                .setTitle( TextInteractAsset.FoxAlice )
                .setBody( TextInteractAsset.Dialog3Text3 )
                .actionToGoHere( TextInteractAsset.Dialog3Text2V1 )
                .connect( Dialog3FoxAliceQ2V1, Dialog3FoxAliceQ2V2, Dialog3FoxAliceQ2V3 );

        Dialog3FoxAliceQ1V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text2V2 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ1V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text2V3 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ2V1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text3V1 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ2V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text3V2 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ2V3
                .setTitle( TextInteractAsset.FoxAlice )
                .setBody( TextInteractAsset.Dialog3Text4 )
                .actionToGoHere( TextInteractAsset.Dialog3Text3V3 )
                .connect( Dialog3FoxAliceQ3V1, Dialog3FoxAliceQ3V2, Dialog3FoxAliceQ3V3 );

        Dialog3FoxAliceQ3V1
                .setTitle( TextInteractAsset.FoxAlice )
                .setBody( TextInteractAsset.Dialog3Text5 )
                .actionToGoHere( TextInteractAsset.Dialog3Text4V1 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ3V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text4V2 )
                .connect( Dialog3FoxAlice );

        Dialog3FoxAliceQ3V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog3Text4V3 )
                .connect( Dialog3FoxAlice );

        // Разговор с котиком Базилио
        Dialog4Basilio
                .setTitle( TextInteractAsset.BasilioTheCat )
                .setBody( TextInteractAsset.Dialog4Text )
                .actionToGoHere( TextInteractAsset.Empty )
                .connect( Dialog4BasilioV1 );

        Dialog4BasilioV1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog4TextV );

        // Разговор с ежиком Каксоником
        Dialog5Kaksonik
                .setTitle( TextInteractAsset.Kaksonic )
                .setBody( TextInteractAsset.Dialog5Text )
                .actionToGoHere( TextInteractAsset.Empty )
                .connect( Dialog5KaksonikV1 );

        Dialog5KaksonikV1
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog5TextV );





        // Разговор со слоником Топой
        Dialog6Topa
                .setTitle( TextInteractAsset.TopaElephant )
                .setBody( TextInteractAsset.Dialog6Text )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog6TopaQ1V1 );

        Dialog6TopaQ1V1
                .setTitle( TextInteractAsset.TopaElephant )
                .setBody( TextInteractAsset.Dialog6Text2 )
                .actionToGoHere( TextInteractAsset.Dialog6Text1V1 )
                .connect( Dialog6TopaQ2V1, Dialog6TopaQ2V2, Dialog6TopaQ2V3 );

        Dialog6TopaQ2V1
                .setTitle( TextInteractAsset.TopaElephant )
                .setBody( TextInteractAsset.Dialog6Text3 )
                .actionToGoHere( TextInteractAsset.Dialog6Text2V1 )
                .connect( Dialog6TopaQ3V1, Dialog6TopaQ3V2, Dialog6TopaQ3V3 );

        Dialog6TopaQ2V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text2V2 );

        Dialog6TopaQ2V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text2V3 );

        Dialog6TopaQ3V1
                .setTitle( TextInteractAsset.TopaElephant )
                .setBody( TextInteractAsset.Dialog6Text4 )
                .actionToGoHere( TextInteractAsset.Dialog6Text3V1 )
                .connect( Dialog6TopaQ4V1, Dialog6TopaQ4V2, Dialog6TopaQ4V3 );

        Dialog6TopaQ3V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text3V2 );

        Dialog6TopaQ3V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text3V3 );

        Dialog6TopaQ4V1
                .setTitle( TextInteractAsset.TopaElephant )
                .setBody( TextInteractAsset.Dialog6Text5 )
                .actionToGoHere( TextInteractAsset.Dialog6Text4V1 );

        Dialog6TopaQ4V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text4V2 );

        Dialog6TopaQ4V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog6Text4V3 );

        // разговор к Крошкой енотом
        Dialog7RacoonBaby
                .setTitle( TextInteractAsset.RacoonBaby )
                .setBody( TextInteractAsset.Dialog7Text1 )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog7RacoonBabyQ1V1 );

        Dialog7RacoonBabyQ1V1
                .setTitle( TextInteractAsset.RacoonBaby )
                .setBody( TextInteractAsset.Dialog7Text2 )
                .actionToGoHere( TextInteractAsset.Dialog7Text1V1 )
                .connect( Dialog7RacoonBabyQ2V1, Dialog7RacoonBabyQ2V2, Dialog7RacoonBabyQ2V3 );

        Dialog7RacoonBabyQ2V1
                .setTitle( TextInteractAsset.RacoonBaby )
                .setBody( TextInteractAsset.Dialog7Text3 )
                .actionToGoHere( TextInteractAsset.Dialog7Text2V1 )
                .connect( Dialog7RacoonBabyQ3V1, Dialog7RacoonBabyQ3V2, Dialog7RacoonBabyQ3V3 );

        Dialog7RacoonBabyQ2V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text2V2 );

        Dialog7RacoonBabyQ2V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text2V3 );

        Dialog7RacoonBabyQ3V1
                .setTitle( TextInteractAsset.RacoonBaby )
                .setBody( TextInteractAsset.Dialog7Text4 )
                .actionToGoHere( TextInteractAsset.Dialog7Text3V1 )
                .connect( Dialog7RacoonBabyQ4V1, Dialog7RacoonBabyQ4V2, Dialog7RacoonBabyQ4V3 );

        Dialog7RacoonBabyQ3V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text3V2 );

        Dialog7RacoonBabyQ3V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text3V3 );

        Dialog7RacoonBabyQ4V1
                .setTitle( TextInteractAsset.RacoonBaby )
                .setBody( TextInteractAsset.Dialog7Text5 )
                .actionToGoHere( TextInteractAsset.Dialog7Text4V1 );

        Dialog7RacoonBabyQ4V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text4V2 );

        Dialog7RacoonBabyQ4V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog7Text4V3 );

        // разговор с птичкой Найджелом
        Dialog8NigelBird
                .setTitle( TextInteractAsset.NigelBird )
                .setBody( TextInteractAsset.Dialog8Text1 )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog8NigelBirdQ1V1 );

        Dialog8NigelBirdQ1V1
                .setTitle( TextInteractAsset.NigelBird )
                .setBody( TextInteractAsset.Dialog8Text2 )
                .actionToGoHere( TextInteractAsset.Dialog8Text1V1 )
                .connect( Dialog8NigelBirdQ2V1, Dialog8NigelBirdQ2V2, Dialog8NigelBirdQ2V3 );

        Dialog8NigelBirdQ2V1
                .setTitle( TextInteractAsset.NigelBird )
                .setBody( TextInteractAsset.Dialog8Text3 )
                .actionToGoHere( TextInteractAsset.Dialog8Text2V1 )
                .connect( Dialog8NigelBirdQ3V1, Dialog8NigelBirdQ3V2, Dialog8NigelBirdQ3V3 );

        Dialog8NigelBirdQ2V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text2V2 );

        Dialog8NigelBirdQ2V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text2V3 );

        Dialog8NigelBirdQ3V1
                .setTitle( TextInteractAsset.NigelBird )
                .setBody( TextInteractAsset.Dialog8Text4 )
                .actionToGoHere( TextInteractAsset.Dialog8Text3V1 )
                .connect( Dialog8NigelBirdQ4V1, Dialog8NigelBirdQ4V2, Dialog8NigelBirdQ4V3 );

        Dialog8NigelBirdQ3V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text3V2 );

        Dialog8NigelBirdQ3V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text3V3 );

        Dialog8NigelBirdQ4V1
                .setTitle( TextInteractAsset.NigelBird )
                .setBody( TextInteractAsset.Dialog8Text5 )
                .actionToGoHere( TextInteractAsset.Dialog8Text4V1 );

        Dialog8NigelBirdQ4V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text4V2 );

        Dialog8NigelBirdQ4V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog8Text4V3 );



        // разговор с енотом Чейни
        Dialog9CheinieRacoon
                .setTitle( TextInteractAsset.CheinieRacoon )
                .setBody( TextInteractAsset.Dialog9Text1 )
                .actionToGoHere( TextInteractAsset.Back )
                .connect( Dialog9CheinieRacoonQ1V1 );

        Dialog9CheinieRacoonQ1V1
                .setTitle( TextInteractAsset.CheinieRacoon )
                .setBody( TextInteractAsset.Dialog9Text2 )
                .actionToGoHere( TextInteractAsset.Dialog9Text1V1 )
                .connect( Dialog9CheinieRacoonQ2V1, Dialog9CheinieRacoonQ2V2 );

        Dialog9CheinieRacoonQ2V1
                .setTitle( TextInteractAsset.CheinieRacoon )
                .setBody( TextInteractAsset.Dialog9Text3 )
                .actionToGoHere( TextInteractAsset.Dialog9Text2V1 )
                .connect( Dialog9CheinieRacoonQ3V1, Dialog9CheinieRacoonQ3V2, Dialog9CheinieRacoonQ3V3 );

        Dialog9CheinieRacoonQ2V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog9Text2V2 );

        Dialog9CheinieRacoonQ3V1
                .setTitle( TextInteractAsset.CheinieRacoon )
                .setBody( TextInteractAsset.Dialog9Text4 )
                .actionToGoHere( TextInteractAsset.Dialog9Text3V1 )
                .connect( Dialog9CheinieRacoonQ4V1, Dialog9CheinieRacoonQ4V2, Dialog9CheinieRacoonQ4V3 );

        Dialog9CheinieRacoonQ3V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog9Text3V2 );

        Dialog9CheinieRacoonQ3V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog9Text3V3 );

        Dialog9CheinieRacoonQ4V1
                .setTitle( TextInteractAsset.CheinieRacoon )
                .setBody( TextInteractAsset.Dialog9Text5 )
                .actionToGoHere( TextInteractAsset.Dialog9Text4V1 );

        Dialog9CheinieRacoonQ4V2
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog9Text4V2 );

        Dialog9CheinieRacoonQ4V3
                .setTitle( TextInteractAsset.Empty )
                .setBody( TextInteractAsset.Empty )
                .actionToGoHere( TextInteractAsset.Dialog9Text4V3 );






        // Книги

        Book1.setBookText( TextInteractAsset.Book1Body );
        Book2.setBookText( TextInteractAsset.Book2Body );
        Book3.setBookText( TextInteractAsset.Book3Body );
        Book4.setBookText( TextInteractAsset.Book4Body );
        Book5.setBookText( TextInteractAsset.Book5Body );
        Book6.setBookText( TextInteractAsset.Book6Body );
        Book7.setBookText( TextInteractAsset.Book7Body );
        Book8.setBookText( TextInteractAsset.Book8Body );
        Book9.setBookText( TextInteractAsset.Book9Body );
        Book10.setBookText( TextInteractAsset.Book10Body );
        Book11.setBookText( TextInteractAsset.Book11Body );
        Book12.setBookText( TextInteractAsset.Book12Body );
        Book13.setBookText( TextInteractAsset.Book13Body );
        Book14.setBookText( TextInteractAsset.Book14Body );
        Book15.setBookText( TextInteractAsset.Book15Body );
        Book16.setBookText( TextInteractAsset.Book16Body );
        Book17.setBookText( TextInteractAsset.Book17Body );
        Book18.setBookText( TextInteractAsset.Book18Body );
        Book19.setBookText( TextInteractAsset.Book19Body );
        Book20.setBookText( TextInteractAsset.Book20Body );
    }

    private void setBookText(TextInteractAsset asset){
        this.setText( TextInteractAsset.BookName, asset, TextInteractAsset.Empty );
    }


    public TextInteract connect ( TextInteract... nextTextInteract ) {
        this.connection.clear();
        this.connection.addAll( nextTextInteract );
        return this;
    }


    public TextInteract addConnect ( TextInteract... nextTextInteract ) {
        this.connection.addAll( nextTextInteract );
        return this;
    }


    public TextInteract actionToGoHere ( TextInteractAsset action ) {
        this.action = action;
        return this;
    }


    public TextInteract setTitle ( TextInteractAsset title ) {
        this.title = title;
        return this;
    }


    public TextInteract setBody ( TextInteractAsset body ) {
        this.body = body;
        return this;
    }


    public Array< TextInteract > getConnections () {
        return connection;
    }


    public TextInteract setText ( TextInteractAsset titleOfTextBlock,
                                  TextInteractAsset bodyOfTextBlock,
                                  TextInteractAsset actionText ) {
        this.title = titleOfTextBlock;
        this.body = bodyOfTextBlock;
        this.action = actionText;
        return this;
    }


    public String getTitle () {
        return title.get();
    }


    public boolean haveNotBody () {
        return "".equals( body.get() );
    }


    public String getBody () {
        return body.get();
    }


    public String getAction () {
        return action.get();
    }
}
