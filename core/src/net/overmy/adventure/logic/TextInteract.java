package net.overmy.adventure.logic;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.TextInteractAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 14.06.2017
 */

public enum TextInteract {
    Dialog1HogPrickle,
    Dialog1HogPrickleV1,
    Dialog1HogPrickleV2,
    Dialog1HogPrickleV3,

    Dialog2HogPester,
    Dialog2HogPesterV1,
    Dialog2HogPesterV2,
    Dialog2HogPesterV3,

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


    Book1;

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
                .connect( Dialog3FoxAliceV1, Dialog3FoxAliceV2,
                          Dialog3FoxAliceV3 );

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

        // Книги

        Book1.setText( TextInteractAsset.BookName, TextInteractAsset.Book1Body,
                       TextInteractAsset.Empty );
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
