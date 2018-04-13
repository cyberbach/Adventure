package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 24.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.MusicAsset;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextAsset;

public final class CollectableProcessor {
    private CollectableProcessor () {
    }


    //       триггер1 триггер2          триггер2 триггер3
    // ............1 ..........................2 ..............3

    public static void process ( Item item, Vector3 position ) {

        switch ( item ) {
            case TRIGGER_MUSIC_TO_FOREST:
                if ( DEBUG.ON_WINDOWS.get() ) {
                    return;
                }
                if(!MusicAsset.FOREST.get().isPlaying())MusicAsset.FOREST.play( true );
                MusicAsset.WINTER.stopLoop();
                MusicAsset.SEA.stopLoop();
                break;

            case TRIGGER_MUSIC_TO_SEA:
                if ( DEBUG.ON_WINDOWS.get() ) {
                    return;
                }
                if(!MusicAsset.SEA.get().isPlaying())MusicAsset.SEA.play( true );
                MusicAsset.WINTER.stopLoop();
                MusicAsset.FOREST.stopLoop();
                break;

            case TRIGGER_MUSIC_TO_WINTER:
                if ( DEBUG.ON_WINDOWS.get() ) {
                    return;
                }
                if(!MusicAsset.WINTER.get().isPlaying())MusicAsset.WINTER.play( true );
                MusicAsset.FOREST.stopLoop();
                MusicAsset.SEA.stopLoop();
                break;

            case TRIGGER_INTRO_GUNS:
                AshleySubs.createText( TextAsset.TRIGGER_HELP1.get() );
                break;

            case TRIGGER_INTRO_GUNS2:
                AshleySubs.createText( TextAsset.TRIGGER_HELP2.get() );
                break;

            case TRIGGER_INTRO_BOTTLE:
                AshleySubs.createText( TextAsset.TRIGGER_HELP3.get() );
                break;

            case TRIGGER_INTRO_BOX:
                AshleySubs.createText( TextAsset.TRIGGER_HELP4.get() );
                break;

            case TRIGGER_INTRO_TALK:
                AshleySubs.createText( TextAsset.TRIGGER_HELP5.get() );
                break;

            case TRIGGER_INTRO_WEAPON_COMBINE:
                AshleySubs.createText( TextAsset.TRIGGER_HELP6.get() );
                break;

            case TRIGGER_INTRO_HIDDEN_WALL:
                AshleySubs.createText( TextAsset.TRIGGER_HELP7.get() );
                break;

            case TRIGGER_TRY_TO_JUMP:
                AshleySubs.createText( TextAsset.TRIGGER_HELP8.get() );
                break;

            case TRIGGER_A_LONG_WAY:
                AshleySubs.createText( TextAsset.TRIGGER_HELP9.get() );
                break;

            case TRIGGER_SHARK_HELP:
                AshleySubs.createText( TextAsset.TRIGGER_HELP10.get() );
                break;

            case TRIGGER_GATE_HELP:
                AshleySubs.createText( TextAsset.TRIGGER_HELP11.get() );
                break;

            case TRIGGER_BLUE_BOTTLE:
                AshleySubs.createText( TextAsset.TRIGGER_HELP12.get() );
                break;

            case TRIGGER_ALICE:
                AshleySubs.createText( TextAsset.TRIGGER_HELP13.get() );
                break;

            case TRIGGER_SECRETLOCATION1:
                AshleySubs.createText( TextAsset.TRIGGER_HELP14.get() );
                break;

            case COIN:
                SoundAsset.Coin.play();
                AshleySubs.create5BubblesFX( position, GameColor.YELLOW );
                MyPlayer.addToBag( item );
                break;

            case GREEN_BOTTLE:
                SoundAsset.Collect5.play();
                AshleySubs.create5BubblesFX( position, GameColor.GREEN );
                MyPlayer.addToBag( item );
                break;

            case PURPLE_BOTTLE:
                SoundAsset.Collect5.play();
                AshleySubs.create5StarsFX( position );
                MyPlayer.addToBag( item );
                break;

            case RED_BOTTLE:
                SoundAsset.Collect5.play();
                AshleySubs.create5BubblesFX( position, GameColor.RED );
                MyPlayer.addToBag( item );
                break;

            default:
                SoundAsset.PickupStar.play();
                AshleySubs.create5StarsFX( position );
                MyPlayer.addToBag( item );
                break;
        }
    }
}
