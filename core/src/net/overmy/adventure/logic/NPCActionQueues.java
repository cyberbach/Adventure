package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 02.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.ashley.components.NPCAction;
import net.overmy.adventure.ashley.components.NPCAction.NPC_ACTION_ID;

public final class NPCActionQueues {
    private NPCActionQueues () {
    }


    public static Array< NPCAction > get ( int id ) {

        switch ( id ) {
            case 0:
                Array< NPCAction > queue = new Array< NPCAction >();
                queue.add( wait( 15.0f ) );
                queue.add( move( -25.33078f, -66.74849f ) );
                queue.add( move( -18.664494f, -65.147026f ) );
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
                queue1.add( move( 11.0029545f, 11.008482f ) );
                queue1.add( wait( 3.0f ) );
                queue1.add( move( 5.406862f, 10.36782f ) );
                queue1.add( hunt() );
                queue1.add( wait( 2.0f ) );
                queue1.add( move( 3.7875729f, 6.9466367f ) );
                queue1.add( wait( 3.0f ) );
                queue1.add( move( 4.887175f, 10.677381f ) );

                return queue1;

            case 2:
                Array< NPCAction > queue2 = new Array< NPCAction >();
                queue2.add( wait( 3.0f ) );
                queue2.add( hunt() );
                queue2.add( move( 8.697725f, -2.0947685f ) );
                queue2.add( move( 7.6969233f, 0.8624459f ) );
                queue2.add( move( 3.2691898f, 0.110698976f ) );
                queue2.add( move( 5.371343f, -2.410922f ) );
                queue2.add( hunt() );
                queue2.add( move( 9.87872f, -0.9013393f ) );
                queue2.add( move( 9.266123f, -0.8731335f ) );

                return queue2;

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
