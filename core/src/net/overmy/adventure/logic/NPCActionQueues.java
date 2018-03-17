package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 02.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.ashley.components.NPCAction;
import net.overmy.adventure.ashley.components.NPCAction.NPC_ACTION_ID;
import net.overmy.adventure.resources.TextAsset;

public final class NPCActionQueues {
    private NPCActionQueues () {
    }


    public static Array< NPCAction > get ( int id ) {

        switch ( id ) {
            case 0:
                Array< NPCAction > queue = new Array< NPCAction >();
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 15.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-25.33078f, -66.74849f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-18.664494f, -65.147026f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-14.296296f, -65.65968f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-10.035321f, -78.6422f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-20.728638f, -86.38529f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-27.775835f, -88.418846f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-28.209415f, -85.8856f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 5.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-21.665394f, -84.70191f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-13.180926f, -78.91112f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-14.756912f, -65.820145f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-26.207544f, -68.05383f), 10.0f ) );

                return queue;

            case 1:
                Array< NPCAction > queue1 = new Array< NPCAction >();
                queue1.add( new NPCAction( NPC_ACTION_ID.WAIT, 1.0f ) );
                queue1.add( new NPCAction( NPC_ACTION_ID.SAY, TextAsset.Title, 2.0f ) );
                queue1.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );

                queue1.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(6.204556f, 2.757347f), 10.0f ) );
                queue1.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );

                queue1.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(6.5746555f, 7.6863904f), 10.0f ) );
                queue1.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );

                queue1.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(6.591744f, 5.2940097f ), 10.0f) );
                return queue1;

            case 2:
                Array< NPCAction > queue2 = new Array< NPCAction >();
                queue2.add( new NPCAction( NPC_ACTION_ID.WAIT, 1.0f ) );



                return queue2;

            default:
                return null;
        }

    }
}
