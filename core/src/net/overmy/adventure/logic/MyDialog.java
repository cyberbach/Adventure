package net.overmy.adventure.logic;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.DialogAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 14.06.2017
 */

public enum MyDialog {

    // shop variants

    BUY_Broom_15coins,
    BUY_GreenBottle_10coins,
    BUY_GreenBottle_2greenStars,
    BUY_RedBottle_10coins,
    BUY_PurpleBottle_5coins,
    BUY_BlueBottle_3BlueStars,
    BUY_BlueBottle_3yellowStars,

    // prickle

    HogPrickle,

    // pester

    HogPester,

    // alice

    FoxAlice,
    FoxAliceV3,

    FoxAliceQ1V1,
    FoxAliceQ1V2,
    FoxAliceQ1V3,

    FoxAliceQ2V1,
    FoxAliceQ2V2,
    FoxAliceQ2V3,

    FoxAliceQ3V1_last,
    FoxAliceQ3V2,
    FoxAliceQ3V3,


    // kaksonik
    Kaksonik,

    // Topa
    Topa,
    TopaQ1V1,
    TopaQ2V1,
    TopaQ2V2,
    TopaQ2V3,
    TopaQ3V1,
    TopaQ3V2,
    TopaQ3V3,
    TopaQ4V1_last,
    TopaQ4V2,
    TopaQ4V3,

    // Baby Racoon
    RacoonBaby,
    RacoonBabyQ1V1,
    RacoonBabyQ2V1,
    RacoonBabyQ2V2,
    RacoonBabyQ2V3,
    RacoonBabyQ3V1,
    RacoonBabyQ3V2,
    RacoonBabyQ3V3,
    RacoonBabyQ4V1_last,
    RacoonBabyQ4V2,
    RacoonBabyQ4V3,

    // Nigel the Bird
    NigelBird,
    NigelBirdQ1V1,
    NigelBirdQ2V1,
    NigelBirdQ2V2,
    NigelBirdQ2V3,
    NigelBirdQ3V1,
    NigelBirdQ3V2,
    NigelBirdQ3V3,
    NigelBirdQ4V1_last,
    NigelBirdQ4V2,
    NigelBirdQ4V3,

    // Cheinie
    CheinieRacoon,
    CheinieRacoonQ1V1,
    CheinieRacoonQ2V1,
    CheinieRacoonQ2V2,
    CheinieRacoonQ3V1,
    CheinieRacoonQ3V2,
    CheinieRacoonQ3V3,
    CheinieRacoonQ4V1_last,
    CheinieRacoonQ4V2,
    CheinieRacoonQ4V3,

    // last dialog
    Miki,
    MikiQ1V1,
    MikiQ2V1,
    MikiQ3V1_last,


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
    Book21,
    Book22,
    Book23,
    Book24,
    Book25,
    Book26,
    Book27,
    Book28,
    Book29,
    Book30,;

    private Array< MyDialog > connection = new Array< MyDialog >();

    private DialogAsset action = null;
    private DialogAsset title  = null;
    private DialogAsset body   = null;


    public static void init () {

        // Диалог с Ёжик Колючка

        HogPrickle
                .setTitle( DialogAsset.HogPrickle )
                .setBody( DialogAsset.Dialog1Text )
                .actionToGoHere( DialogAsset.Back )
                .connect( BUY_RedBottle_10coins, BUY_GreenBottle_10coins, BUY_Broom_15coins );

        // Диалог с Ёжик Приставучка

        HogPester
                .setTitle( DialogAsset.HogPester )
                .setBody( DialogAsset.Dialog2Text )
                .actionToGoHere( DialogAsset.Back )
                .connect( BUY_RedBottle_10coins, BUY_GreenBottle_2greenStars );

        // Диалог с Лисичкой Алисой
        FoxAlice
                .setTitle( DialogAsset.FoxAlice )
                .setBody( DialogAsset.Dialog3Text1 )
                .actionToGoHere( DialogAsset.Back )
                .connect( BUY_BlueBottle_3BlueStars, BUY_PurpleBottle_5coins, FoxAliceV3 );

        FoxAliceV3
                .setTitle( DialogAsset.FoxAlice )
                .setBody( DialogAsset.Dialog3Text2 )
                .actionToGoHere( DialogAsset.Dialog3Text1V3 )
                .connect( FoxAliceQ1V1, FoxAliceQ1V2, FoxAliceQ1V3 );

        FoxAliceQ1V1
                .setTitle( DialogAsset.FoxAlice )
                .setBody( DialogAsset.Dialog3Text3 )
                .actionToGoHere( DialogAsset.Dialog3Text2V1 )
                .connect( FoxAliceQ2V1, FoxAliceQ2V2, FoxAliceQ2V3 );
        FoxAliceQ1V2.actionToGoHereEE( DialogAsset.Dialog3Text2V2 ).connect( FoxAlice );
        FoxAliceQ1V3.actionToGoHereEE( DialogAsset.Dialog3Text2V3 ).connect( FoxAlice );

        FoxAliceQ2V1.actionToGoHereEE( DialogAsset.Dialog3Text3V1 ).connect( FoxAlice );
        FoxAliceQ2V2.actionToGoHereEE( DialogAsset.Dialog3Text3V2 ).connect( FoxAlice );
        FoxAliceQ2V3
                .setTitle( DialogAsset.FoxAlice )
                .setBody( DialogAsset.Dialog3Text4 )
                .actionToGoHere( DialogAsset.Dialog3Text3V3 )
                .connect( FoxAliceQ3V1_last, FoxAliceQ3V2, FoxAliceQ3V3 );

        FoxAliceQ3V1_last
                .setTitle( DialogAsset.FoxAlice )
                .setBody( DialogAsset.Dialog3Text5 )
                .actionToGoHere( DialogAsset.Dialog3Text4V1 )
                .connect( FoxAlice );
        FoxAliceQ3V2.actionToGoHereEE( DialogAsset.Dialog3Text4V2 ).connect( FoxAlice );
        FoxAliceQ3V3.actionToGoHereEE( DialogAsset.Dialog3Text4V3 ).connect( FoxAlice );

        // Разговор с ежиком Каксоником
        Kaksonik
                .setTitle( DialogAsset.Kaksonic )
                .setBody( DialogAsset.Dialog5Text )
                .actionToGoHere( DialogAsset.Empty )
                .connect( BUY_GreenBottle_10coins, BUY_GreenBottle_2greenStars );

        // Разговор со слоником Топой
        Topa
                .setTitle( DialogAsset.TopaElephant )
                .setBody( DialogAsset.Dialog6Text )
                .actionToGoHere( DialogAsset.Back )
                .connect( TopaQ1V1 );

        TopaQ1V1
                .setTitle( DialogAsset.TopaElephant )
                .setBody( DialogAsset.Dialog6Text2 )
                .actionToGoHere( DialogAsset.Dialog6Text1V1 )
                .connect( TopaQ2V1, TopaQ2V2, TopaQ2V3 );

        TopaQ2V1
                .setTitle( DialogAsset.TopaElephant )
                .setBody( DialogAsset.Dialog6Text3 )
                .actionToGoHere( DialogAsset.Dialog6Text2V1 )
                .connect( TopaQ3V1, TopaQ3V2, TopaQ3V3 );
        TopaQ2V2.actionToGoHereEE( DialogAsset.Dialog6Text2V2 );
        TopaQ2V3.actionToGoHereEE( DialogAsset.Dialog6Text2V3 );

        TopaQ3V1
                .setTitle( DialogAsset.TopaElephant )
                .setBody( DialogAsset.Dialog6Text4 )
                .actionToGoHere( DialogAsset.Dialog6Text3V1 )
                .connect( TopaQ4V1_last, TopaQ4V2, TopaQ4V3 );
        TopaQ3V2.actionToGoHereEE( DialogAsset.Dialog6Text3V2 );
        TopaQ3V3.actionToGoHereEE( DialogAsset.Dialog6Text3V3 );

        TopaQ4V1_last
                .setTitle( DialogAsset.TopaElephant )
                .setBody( DialogAsset.Dialog6Text5 )
                .actionToGoHere( DialogAsset.Dialog6Text4V1 );
        TopaQ4V2.actionToGoHereEE( DialogAsset.Dialog6Text4V2 );
        TopaQ4V3.actionToGoHereEE( DialogAsset.Dialog6Text4V3 );

        // разговор к Крошкой енотом
        RacoonBaby
                .setTitle( DialogAsset.RacoonBaby )
                .setBody( DialogAsset.Dialog7Text1 )
                .actionToGoHere( DialogAsset.Back )
                .connect( RacoonBabyQ1V1 );

        RacoonBabyQ1V1
                .setTitle( DialogAsset.RacoonBaby )
                .setBody( DialogAsset.Dialog7Text2 )
                .actionToGoHere( DialogAsset.Dialog7Text1V1 )
                .connect( RacoonBabyQ2V1, RacoonBabyQ2V2, RacoonBabyQ2V3 );

        RacoonBabyQ2V1
                .setTitle( DialogAsset.RacoonBaby )
                .setBody( DialogAsset.Dialog7Text3 )
                .actionToGoHere( DialogAsset.Dialog7Text2V1 )
                .connect( RacoonBabyQ3V1, RacoonBabyQ3V2, RacoonBabyQ3V3 );
        RacoonBabyQ2V2.actionToGoHereEE( DialogAsset.Dialog7Text2V2 );
        RacoonBabyQ2V3.actionToGoHereEE( DialogAsset.Dialog7Text2V3 );

        RacoonBabyQ3V1
                .setTitle( DialogAsset.RacoonBaby )
                .setBody( DialogAsset.Dialog7Text4 )
                .actionToGoHere( DialogAsset.Dialog7Text3V1 )
                .connect( RacoonBabyQ4V1_last, RacoonBabyQ4V2, RacoonBabyQ4V3 );
        RacoonBabyQ3V2.actionToGoHereEE( DialogAsset.Dialog7Text3V2 );
        RacoonBabyQ3V3.actionToGoHereEE( DialogAsset.Dialog7Text3V3 );

        RacoonBabyQ4V1_last
                .setTitle( DialogAsset.RacoonBaby )
                .setBody( DialogAsset.Dialog7Text5 )
                .actionToGoHere( DialogAsset.Dialog7Text4V1 );
        RacoonBabyQ4V2.actionToGoHereEE( DialogAsset.Dialog7Text4V2 );
        RacoonBabyQ4V3.actionToGoHereEE( DialogAsset.Dialog7Text4V3 );

        // разговор с птичкой Найджелом
        NigelBird
                .setTitle( DialogAsset.NigelBird )
                .setBody( DialogAsset.Dialog8Text1 )
                .actionToGoHere( DialogAsset.Back )
                .connect( NigelBirdQ1V1 );

        NigelBirdQ1V1
                .setTitle( DialogAsset.NigelBird )
                .setBody( DialogAsset.Dialog8Text2 )
                .actionToGoHere( DialogAsset.Dialog8Text1V1 )
                .connect( NigelBirdQ2V1, NigelBirdQ2V2, NigelBirdQ2V3 );

        NigelBirdQ2V1
                .setTitle( DialogAsset.NigelBird )
                .setBody( DialogAsset.Dialog8Text3 )
                .actionToGoHere( DialogAsset.Dialog8Text2V1 )
                .connect( NigelBirdQ3V1, NigelBirdQ3V2, NigelBirdQ3V3 );
        NigelBirdQ2V2.actionToGoHereEE( DialogAsset.Dialog8Text2V2 );
        NigelBirdQ2V3.actionToGoHereEE( DialogAsset.Dialog8Text2V3 );

        NigelBirdQ3V1
                .setTitle( DialogAsset.NigelBird )
                .setBody( DialogAsset.Dialog8Text4 )
                .actionToGoHere( DialogAsset.Dialog8Text3V1 )
                .connect( NigelBirdQ4V1_last, NigelBirdQ4V2, NigelBirdQ4V3 );
        NigelBirdQ3V2.actionToGoHereEE( DialogAsset.Dialog8Text3V2 );
        NigelBirdQ3V3.actionToGoHereEE( DialogAsset.Dialog8Text3V3 );

        NigelBirdQ4V1_last
                .setTitle( DialogAsset.NigelBird )
                .setBody( DialogAsset.Dialog8Text5 )
                .actionToGoHere( DialogAsset.Dialog8Text4V1 );
        NigelBirdQ4V2.actionToGoHereEE( DialogAsset.Dialog8Text4V2 );
        NigelBirdQ4V3.actionToGoHereEE( DialogAsset.Dialog8Text4V3 );

        // разговор с енотом Чейни
        CheinieRacoon
                .setTitle( DialogAsset.CheinieRacoon )
                .setBody( DialogAsset.Dialog9Text1 )
                .actionToGoHere( DialogAsset.Back )
                .connect( CheinieRacoonQ1V1 );

        CheinieRacoonQ1V1
                .setTitle( DialogAsset.CheinieRacoon )
                .setBody( DialogAsset.Dialog9Text2 )
                .actionToGoHere( DialogAsset.Dialog9Text1V1 )
                .connect( CheinieRacoonQ2V1, CheinieRacoonQ2V2 );

        CheinieRacoonQ2V1
                .setTitle( DialogAsset.CheinieRacoon )
                .setBody( DialogAsset.Dialog9Text3 )
                .actionToGoHere( DialogAsset.Dialog9Text2V1 )
                .connect( CheinieRacoonQ3V1, CheinieRacoonQ3V2, CheinieRacoonQ3V3 );
        CheinieRacoonQ2V2.actionToGoHereEE( DialogAsset.Dialog9Text2V2 );

        CheinieRacoonQ3V1
                .setTitle( DialogAsset.CheinieRacoon )
                .setBody( DialogAsset.Dialog9Text4 )
                .actionToGoHere( DialogAsset.Dialog9Text3V1 )
                .connect( CheinieRacoonQ4V1_last, CheinieRacoonQ4V2, CheinieRacoonQ4V3 );
        CheinieRacoonQ3V2.actionToGoHereEE( DialogAsset.Dialog9Text3V2 );
        CheinieRacoonQ3V3.actionToGoHereEE( DialogAsset.Dialog9Text3V3 );

        CheinieRacoonQ4V1_last
                .setTitle( DialogAsset.CheinieRacoon )
                .setBody( DialogAsset.Dialog9Text5 )
                .actionToGoHere( DialogAsset.Dialog9Text4V1 );
        CheinieRacoonQ4V2.actionToGoHereEE( DialogAsset.Dialog9Text4V2 );
        CheinieRacoonQ4V3.actionToGoHereEE( DialogAsset.Dialog9Text4V3 );

        // диалог с Мики

        Miki
                .setTitle( DialogAsset.Miki )
                .setBody( DialogAsset.Dialog10Text1 )
                .actionToGoHere( DialogAsset.Back )
                .connect( MikiQ1V1 );

        MikiQ1V1
                .setTitle( DialogAsset.Miki )
                .setBody( DialogAsset.Dialog10Text2 )
                .actionToGoHere( DialogAsset.Dialog10Text1V )
                .connect( MikiQ2V1 );

        MikiQ2V1
                .setTitle( DialogAsset.Miki )
                .setBody( DialogAsset.Dialog10Text3 )
                .actionToGoHere( DialogAsset.Dialog10Text2V )
                .connect( MikiQ3V1_last );

        MikiQ3V1_last
                .actionToGoHereEE( DialogAsset.Dialog10Text3V );

        // Книги

        Book1.setBookText( DialogAsset.Book1Body );
        Book2.setBookText( DialogAsset.Book2Body );
        Book3.setBookText( DialogAsset.Book3Body );
        Book4.setBookText( DialogAsset.Book4Body );
        Book5.setBookText( DialogAsset.Book5Body );
        Book6.setBookText( DialogAsset.Book6Body );
        Book7.setBookText( DialogAsset.Book7Body );
        Book8.setBookText( DialogAsset.Book8Body );
        Book9.setBookText( DialogAsset.Book9Body );
        Book10.setBookText( DialogAsset.Book10Body );
        Book11.setBookText( DialogAsset.Book11Body );
        Book12.setBookText( DialogAsset.Book12Body );
        Book13.setBookText( DialogAsset.Book13Body );
        Book14.setBookText( DialogAsset.Book14Body );
        Book15.setBookText( DialogAsset.Book15Body );
        Book16.setBookText( DialogAsset.Book16Body );
        Book17.setBookText( DialogAsset.Book17Body );
        Book18.setBookText( DialogAsset.Book18Body );
        Book19.setBookText( DialogAsset.Book19Body );
        Book20.setBookText( DialogAsset.Book20Body );
        Book21.setBookText( DialogAsset.Book21Body );
        Book22.setBookText( DialogAsset.Book22Body );
        Book23.setBookText( DialogAsset.Book23Body );
        Book24.setBookText( DialogAsset.Book24Body );
        Book25.setBookText( DialogAsset.Book25Body );
        Book26.setBookText( DialogAsset.Book26Body );
        Book27.setBookText( DialogAsset.Book27Body );
        Book28.setBookText( DialogAsset.Book28Body );
        Book29.setBookText( DialogAsset.Book29Body );
        Book30.setBookText( DialogAsset.Book30Body );

        // магазин

        BUY_GreenBottle_10coins.actionToGoHereEE( DialogAsset.BuyGreenBottle10coins );
        BUY_GreenBottle_2greenStars.actionToGoHereEE( DialogAsset.BuyGreenBottle2green );
        BUY_BlueBottle_3BlueStars.actionToGoHereEE( DialogAsset.BuyBlueBottle3blue );
        BUY_PurpleBottle_5coins.actionToGoHereEE( DialogAsset.BuyPurpleBottle5coins );
        BUY_RedBottle_10coins.actionToGoHereEE( DialogAsset.BuyRedBottle10coins );
        BUY_Broom_15coins.actionToGoHereEE( DialogAsset.BuyBroom15coins );
        BUY_BlueBottle_3yellowStars.actionToGoHereEE( DialogAsset.BuyBlueBottle3yellow );
    }


    public void setText ( DialogAsset titleOfTextBlock,
                              DialogAsset bodyOfTextBlock,
                              DialogAsset actionText ) {
        this.title = titleOfTextBlock;
        this.body = bodyOfTextBlock;
        this.action = actionText;
    }

    private void setBookText ( DialogAsset asset ) {
        this.setText( DialogAsset.BookName, asset, DialogAsset.Empty );
    }


    public void connect ( MyDialog... nextMyDialog ) {
        this.connection.clear();
        this.connection.addAll( nextMyDialog );
    }

/*
    public MyDialog addConnect ( MyDialog... nextMyDialog ) {
        this.connection.addAll( nextMyDialog );
        return this;
    }
*/


    public MyDialog actionToGoHere ( DialogAsset action ) {
        this.action = action;
        return this;
    }


    public MyDialog actionToGoHereEE ( DialogAsset action ) {
        this.setTitle( DialogAsset.Empty );
        this.setBody( DialogAsset.Empty );
        this.action = action;
        return this;
    }


    public MyDialog setTitle ( DialogAsset title ) {
        this.title = title;
        return this;
    }


    public MyDialog setBody ( DialogAsset body ) {
        this.body = body;
        return this;
    }


    public Array< MyDialog > getConnections () {
        return connection;
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
