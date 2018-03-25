package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 02.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.logic.NPCAction.NPC_ACTION_ID;
import net.overmy.adventure.resources.TextAsset;

public final class NPCActionQueues {
    private NPCActionQueues () {
    }

    static final int ID_ATTACK = 2;
    static final int ID_SOME_ANIMATION = 3;

    public static Array< NPCAction > get ( int id ) {

        switch ( id ) {
            case 0:
                Array< NPCAction > queue = new Array< NPCAction >();
                queue.add( wait( 15.0f ) );
                queue.add( move( -25.33078f, -66.74849f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.SAY, TextAsset.BLUE_STAR,3 ) );
                queue.add( new NPCAction( NPC_ACTION_ID.ANIMATE, 3, ID_ATTACK ));
                queue.add( move( -18.664494f, -65.147026f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.SAY, TextAsset.OPTIONS,3 ) );
                queue.add( new NPCAction( NPC_ACTION_ID.ANIMATE, 3, ID_SOME_ANIMATION ));
                queue.add( move( -14.296296f, -65.65968f ) );
                queue.add( move( -10.035321f, -78.6422f ) );
                queue.add( move( -20.728638f, -86.38529f ) );
                queue.add( move( -27.775835f, -88.418846f ) );
                queue.add( move( -28.209415f, -85.8856f ) );
                queue.add( wait( 5.0f ) );
                queue.add( move( -21.665394f, -84.70191f ) );
                queue.add( move( -13.180926f, -78.91112f ) );
                queue.add( move( -14.756912f, -65.820145f ) );
                queue.add( move( -26.207544f, -68.05383f ) );
                return queue;

            case 1:
                Array< NPCAction > queue1 = new Array< NPCAction >();
                queue1.add( wait( 2.0f ) );
                queue1.add( hunt() );
                queue1.add( move( 11.0029545f, 11.008482f ) );
                queue1.add( wait( 3.0f ) );
                queue1.add( move( 5.406862f, 10.36782f ) );
                queue1.add( wait( 2.0f ) );
                queue1.add( hunt() );
                queue1.add( move( 3.7875729f, 6.9466367f ) );
                queue1.add( wait( 3.0f ) );
                queue1.add( move( 4.887175f, 10.677381f ) );
                return queue1;

            case 2:
                Array< NPCAction > queue2 = new Array< NPCAction >();
                queue2.add( wait( 3.0f ) );
                queue2.add( move( 8.697725f, -2.0947685f ) );
                queue2.add( move( 7.6969233f, 0.8624459f ) );
                queue2.add( hunt() );
                queue2.add( move( 3.2691898f, 0.110698976f ) );
                queue2.add( move( 5.371343f, -2.410922f ) );
                queue2.add( move( 9.87872f, -0.9013393f ) );
                queue2.add( hunt() );
                queue2.add( move( 9.266123f, -0.8731335f ) );
                return queue2;

            case 3:
                Array< NPCAction > queue3 = new Array< NPCAction >();
                queue3.add( wait( 3.0f ) );
                queue3.add( hunt() );
                queue3.add( move(-30.599691f, -52.38856f) );
                queue3.add( wait( 2.0f ) );
                queue3.add( move(-33.493076f, -55.224483f) );
                queue3.add( wait( 3.0f ) );
                queue3.add( hunt() );
                queue3.add( move(-29.038822f, -57.544582f));
                queue3.add( hunt() );
                queue3.add( move(-33.811184f, -59.12615f) );
                return queue3;

            case 4:
                Array< NPCAction > queue4 = new Array< NPCAction >();
                queue4.add( wait( 3.0f ) );
                queue4.add( hunt() );
                queue4.add( move(-7.1824327f, -60.462067f) );
                queue4.add( wait( 2.0f ) );
                queue4.add( hunt() );
                queue4.add( move(-5.5673203f, -53.898636f) );
                queue4.add( wait( 3.0f ) );
                queue4.add( move(-1.2488754f, -55.292847f) );
                return queue4;

            case 5:
                Array< NPCAction > queue5 = new Array< NPCAction >();
                queue5.add( wait( 1.0f ) );
                queue5.add( move(26.918205f, -145.5957f) );
                queue5.add( hunt() );
                queue5.add( wait( 2.0f ) );
                queue5.add( move(21.526243f, -144.10057f) );
                queue5.add( hunt() );
                queue5.add( wait( 1.0f ) );
                queue5.add( move(14.106742f, -153.48633f) );
                queue5.add( hunt() );
                return queue5;

            case 6:
                Array< NPCAction > queue6 = new Array< NPCAction >();
                queue6.add( hunt() );
                queue6.add( move(-0.387003f, -162.39476f) );
                queue6.add( wait( 1.0f ) );
                queue6.add( hunt() );
                queue6.add( move(-7.1675067f, -162.74545f) );
                queue6.add( wait( 2.0f ) );
                return queue6;

            case 7:
                Array< NPCAction > queue7 = new Array< NPCAction >();
                queue7.add( move(-58.313896f, -179.10666f) );
                queue7.add( wait( 2.0f ) );
                queue7.add( move(-59.6613f, -176.12453f) );
                queue7.add( wait( 2.0f ) );
                queue7.add( move(-65.25142f, -177.31752f) );
                queue7.add( wait( 2.0f ) );
                queue7.add( move(-59.097706f, -176.71507f) );
                queue7.add( wait( 2.0f ) );
                queue7.add( hunt() );
                return queue7;

            case 8:
                Array< NPCAction > queue8 = new Array< NPCAction >();
                queue8.add( move(-50.272156f, -406.55072f) );
                queue8.add( wait( 1.0f ) );
                queue8.add( hunt() );
                queue8.add( move(-46.51943f, -410.3056f) );
                queue8.add( wait( 2.0f ) );
                queue8.add( hunt() );
                queue8.add( move(-53.51205f, -433.28705f) );
                queue8.add( move(-60.112892f, -425.14523f) );
                queue8.add( wait( 3.0f ) );
                queue8.add( hunt() );
                queue8.add( move(-59.306446f, -416.003f) );
                queue8.add( move(-61.259388f, -414.6232f) );
                queue8.add( wait( 1.0f ) );
                queue8.add( hunt() );
                return queue8;

            case 9: // лисичка на зелёной локации
                Array< NPCAction > queue9 = new Array< NPCAction >();
                queue9.add( move(-64.75381f, -441.43292f) );
                queue9.add( wait( 2.0f ) );
                queue9.add( move(-69.77547f, -443.40207f) );
                queue9.add( move(-66.5813f, -443.6809f) );
                queue9.add( wait( 3.0f ) );
                queue9.add( move(-79.34961f, -442.19833f) );
                queue9.add( move(-80.47613f, -443.1133f) );
                queue9.add( wait( 5.0f ) );
                return queue9;

            case 10: // овечка на первой зелёной локации
                Array< NPCAction > queue10 = new Array< NPCAction >();
                queue10.add( move(-142.12982f, -368.08258f) );
                queue10.add( wait( 2.0f ) );
                queue10.add( move(-148.57593f, -364.6106f) );
                queue10.add( wait( 4.0f ) );
                queue10.add( move(-155.29565f, -371.30493f) );
                queue10.add( move(-151.27678f, -372.23157f) );
                queue10.add( wait( 3.0f ) );
                return queue10;

            case 11: // 2 овечка на первой зелёной локации
                Array< NPCAction > queue11 = new Array< NPCAction >();
                queue11.add( move(-139.17807f, -393.3555f) );
                queue11.add( wait( 3.0f ) );
                queue11.add( move(-131.78218f, -397.1868f) );
                queue11.add( wait( 1.5f ) );
                queue11.add( move(-136.02168f, -403.25275f) );
                queue11.add( wait( 2.2f ) );
                return queue11;

            case 12: // овечка на левой зелёной локации
                Array< NPCAction > queue12 = new Array< NPCAction >();
                queue12.add( move(-219.61375f, -400.35522f) );
                queue12.add( wait( 1.2f ) );
                queue12.add( move(-225.82419f, -401.64832f) );
                queue12.add( wait( 2.2f ) );
                return queue12;

            case 13: // 2 овечка на левой зелёной локации
                Array< NPCAction > queue13 = new Array< NPCAction >();
                queue13.add( move(-221.7196f, -426.501f) );
                queue13.add( wait( 3.2f ) );
                queue13.add( move(-220.58641f, -421.99988f) );
                queue13.add( wait( 4.0f ) );
                queue13.add( move(-215.5847f, -426.56372f) );
                queue13.add( wait( 2.2f ) );
                return queue13;

            case 14: // овечка на правой зелёной локации
                Array< NPCAction > queue14 = new Array< NPCAction >();
                queue14.add( move(-40.59898f, -420.44955f) );
                queue14.add( wait( 1.5f ) );
                queue14.add( move(-43.541374f, -413.11823f) );
                queue14.add( wait( 2.2f ) );
                return queue14;

            case 15: // злая птица на первой зелёной локации
                Array< NPCAction > queue15 = new Array< NPCAction >();
                queue15.add( move(-137.9316f, -407.6164f) );
                queue15.add( wait( 1.0f ) );
                queue15.add( hunt() );
                queue15.add( move(-148.53554f, -398.90326f) );
                queue15.add( wait( 2.0f ) );
                queue15.add( hunt() );
                queue15.add( move(-156.10858f, -417.41608f) );
                queue15.add( wait( 1.0f ) );
                queue15.add( hunt() );
                queue15.add( move(-166.88496f, -422.44022f) );
                queue15.add( wait( 3.0f ) );
                queue15.add( hunt() );
                return queue15;

            case 16: // добрая птица на первой зелёной локации
                Array< NPCAction > queue16 = new Array< NPCAction >();
                queue16.add( move(-161.27516f, -356.9968f) );
                queue16.add( wait( 3.0f ) );
                queue16.add( move(-151.27046f, -348.61383f) );
                queue16.add( wait( 4.0f ) );
                return queue16;

            default:
                return null;
        }
    }


    private static NPCAction wait ( float time ) {
        return new NPCAction( NPC_ACTION_ID.WAIT, time );
    }


    private static NPCAction hunt () {
        return new NPCAction( NPC_ACTION_ID.HUNT, 5.0f );
    }


    private static NPCAction move ( float x, float y ) {
        return new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( x, y ), 10.0f );
    }
}
