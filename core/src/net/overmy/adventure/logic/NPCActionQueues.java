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

                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 7.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(2.8272378f, -169.52051f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(2.9068472f, -168.82805f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-6.144423f, -163.0476f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-4.8653455f, -162.5076f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 6.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-12.596195f, -160.69821f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 2.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-13.577898f, -156.70766f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.SAY, TextAsset.Title, 3.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 3.0f ) );

                queue.add( new NPCAction( NPC_ACTION_ID.MOVE, new Vector2(-12.451161f, -161.43076f), 10.0f ) );
                queue.add( new NPCAction( NPC_ACTION_ID.WAIT, 4.0f ) );

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
