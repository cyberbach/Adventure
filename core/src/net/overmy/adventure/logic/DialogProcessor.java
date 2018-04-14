package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 24.03.2018
        Contact me → http://vk.com/id17317
*/

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.DialogAsset;
import net.overmy.adventure.resources.TextAsset;

public final class DialogProcessor {
    private DialogProcessor () {
    }


    public static boolean gameFinished = false;


    private static void buy ( Item what, Item money, int count ) {
        if ( MyPlayer.testBagCount( money, count ) ) {
            SoundAsset.Collect7.play();
            MyPlayer.removeItemInBag( money, count );
            MyPlayer.addToBag( what );
        }else{
            AshleySubs.createText( TextAsset.NOT_ENOUGH_MONEY.get() );
        }
    }


    public static void process ( MyDialog connection ) {

        switch ( connection ) {

            case NigelBirdQ4V1_last:
                SoundAsset.Collect7.play();
                MyPlayer.addToBag( Item.KALASH_WEAPON );

                MyDialog.NigelBird
                        .connect( MyDialog.BUY_RedBottle_10coins,
                                  MyDialog.BUY_GreenBottle_10coins );
                break;

            case MikiQ3V1_last:
                // GAME OVER
                gameFinished = true;
                break;

            case TopaQ4V1_last:
                SoundAsset.Collect7.play();
                for ( int i = 0; i < 5; i++ ) {
                    MyPlayer.addToBag( Item.COIN );
                }

                MyDialog.Topa.connect( MyDialog.BUY_RedBottle_10coins );
                break;

            case RacoonBabyQ4V1_last:
                SoundAsset.Collect7.play();
                for ( int i = 0; i < 10; i++ ) {
                    MyPlayer.addToBag( Item.COIN );
                }

                MyDialog.RacoonBaby
                        .setBody( DialogAsset.Dialog7Text1_afterQuest )
                        .connect( MyDialog.BUY_BlueBottle_3BlueStars,
                                  MyDialog.BUY_BlueBottle_3yellowStars );
                break;

            case CheinieRacoonQ4V1_last:
                SoundAsset.Collect7.play();
                MyPlayer.addToBag( Item.GREEN_BOTTLE );

                MyDialog.CheinieRacoon.connect(
                        MyDialog.BUY_BlueBottle_3yellowStars,
                        MyDialog.BUY_BlueBottle_3BlueStars );
                break;

            case FoxAliceQ3V1_last:
                SoundAsset.Collect7.play();
                MyPlayer.addToBag( Item.PILLOW_WEAPON );

                MyDialog.FoxAlice.connect(
                        MyDialog.BUY_PurpleBottle_5coins,
                        MyDialog.BUY_BlueBottle_3BlueStars,
                        MyDialog.BUY_PurpleBottle_5coins );
                break;

            // --------- shop -------------

            case BUY_Broom_15coins:
                buy( Item.BROOM_WEAPON, Item.COIN, 15 );
                break;

            case BUY_RedBottle_10coins:
                buy( Item.RED_BOTTLE, Item.COIN, 10 );
                break;

            case BUY_BlueBottle_3yellowStars:
                buy( Item.BLUE_BOTTLE, Item.YELLOW_STAR, 3 );
                break;

            case BUY_GreenBottle_2greenStars:
                buy( Item.GREEN_BOTTLE, Item.GREEN_STAR, 2 );
                break;

            case BUY_BlueBottle_3BlueStars:
                buy( Item.BLUE_BOTTLE, Item.BLUE_STAR, 3 );
                break;

            case BUY_PurpleBottle_5coins:
                buy( Item.PURPLE_BOTTLE, Item.COIN, 5 );
                break;

            case BUY_GreenBottle_10coins:
                buy( Item.GREEN_BOTTLE, Item.COIN, 10 );
                break;
        }
    }
}
