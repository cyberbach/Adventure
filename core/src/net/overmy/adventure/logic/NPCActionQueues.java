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
        Array< NPCAction > queue = null;

        switch ( id ) {
            case 0:
                queue = new Array< NPCAction >();
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 15.5f, -3.166f ), 10.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 3.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 3.133f, -3.166f ), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 3.337f, -3.166f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.SAY, TextAsset.OPTIONS, 5.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 1.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 9.298f,-8.390f ), 10.0f ) );
                break;

            case 1:
                queue = new Array< NPCAction >();
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 15.5f, -3.166f ), 10.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 3.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2( 3.133f, -3.166f ), 10.0f ) );
                break;

            default:
                return null;
        }

        return queue;
    }
}
