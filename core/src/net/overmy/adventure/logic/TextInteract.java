package net.overmy.adventure.logic;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.TextInteractAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 14.06.2017
 */

public enum TextInteract {
    DialogNPC1,
    DialogNPC2,
    DialogNPC3,
    DialogNPC4,

    Book1
    ;

    private Array< TextInteract > connection = new Array< TextInteract >();

    private TextInteractAsset action = null;
    private TextInteractAsset title  = null;
    private TextInteractAsset body   = null;


    public static void init () {
        DialogNPC1.setText( TextInteractAsset.NPC1Name, TextInteractAsset.NPC1text, TextInteractAsset.Back )
                  .connect( DialogNPC2, DialogNPC3, DialogNPC4 );

        DialogNPC2.setText( TextInteractAsset.NPC1Name, TextInteractAsset.NPC2text, TextInteractAsset.NPC1variant1 )
                  .connect( DialogNPC1 );

        DialogNPC3.setText( TextInteractAsset.NPC1Name, TextInteractAsset.NPC3text, TextInteractAsset.NPC1variant2 )
                  .connect( DialogNPC1 );

        DialogNPC4.setText( TextInteractAsset.NPC1Name, TextInteractAsset.NPC4text, TextInteractAsset.NPC1variant3 );

        Book1.setText( TextInteractAsset.BookName, TextInteractAsset.Book1Body, TextInteractAsset.Empty );

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


    public String getBody () {
        return body.get();
    }


    public String getAction () {
        return action.get();
    }
}
