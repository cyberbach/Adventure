package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 24.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextAsset;

public final class CollectableProcessor {
    private CollectableProcessor () {
    }


    public static void process ( Item item, Vector3 position ) {

        switch ( item ) {
            case TRIGGER1:
                AshleySubs.createText( TextAsset.HELP1.get() );
                break;

            case TRIGGER2:
                AshleySubs.createText( TextAsset.HELP2.get() );
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

            case GREEN_STAR:
                SoundAsset.PickupStar.play();
                AshleySubs.create5StarsFX( position );
                MyPlayer.addToBag( item );
                break;

            case BLUE_STAR:
                SoundAsset.PickupStar.play();
                AshleySubs.create5StarsFX( position );
                MyPlayer.addToBag( item );
                break;

            case YELLOW_STAR:
                SoundAsset.PickupStar.play();
                AshleySubs.create5StarsFX( position );
                MyPlayer.addToBag( item );
                break;
        }
    }
}
