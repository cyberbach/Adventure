package net.overmy.adventure.logic;

import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.TextDialogAsset;


/**
 * Created by Andrey (cb) Mikheev
 * 14.06.2017
 */

public enum TextBlock {
    DialogNPC1,
    DialogNPC2,
    DialogNPC3,
    DialogNPC4,
    ;

    private Array< TextBlock > connection = new Array< TextBlock >();

    private TextDialogAsset action = null;
    private TextDialogAsset title  = null;
    private TextDialogAsset about  = null;


    public static void init () {
        DialogNPC1.setText( TextDialogAsset.NPC1Name, TextDialogAsset.NPC1text, TextDialogAsset.Back )
                  .connect( DialogNPC2, DialogNPC3, DialogNPC4 );

        DialogNPC2.setText( TextDialogAsset.NPC1Name, TextDialogAsset.NPC2text, TextDialogAsset.NPC1variant1 )
                  .connect( DialogNPC1 );

        DialogNPC3.setText( TextDialogAsset.NPC1Name, TextDialogAsset.NPC3text, TextDialogAsset.NPC1variant2 )
                  .connect( DialogNPC1 );

        DialogNPC4.setText( TextDialogAsset.NPC1Name, TextDialogAsset.NPC4text, TextDialogAsset.NPC1variant3 );

    }


    public TextBlock connect ( TextBlock... nextTextBlock ) {
        this.connection.clear();
        this.connection.addAll( nextTextBlock );
        return this;
    }


    public TextBlock addConnect ( TextBlock... nextTextBlock ) {
        this.connection.addAll( nextTextBlock );
        return this;
    }


    public Array< TextBlock > getConnections () {
        return connection;
    }


    public TextBlock setText ( TextDialogAsset titleOfTextBlock,
                               TextDialogAsset bodyOfTextBlock,
                               TextDialogAsset actionText ) {
        this.title = titleOfTextBlock;
        this.about = bodyOfTextBlock;
        this.action = actionText;
        return this;
    }


    public String getTitle () {
        return title.get();
    }


    public String getAbout () {
        return about.get();
    }


    public String getAction () {
        return action.get();
    }
}
