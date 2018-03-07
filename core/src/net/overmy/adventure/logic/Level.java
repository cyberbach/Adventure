package net.overmy.adventure.logic;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Andrey (cb) Mikheev
 * 17.03.2017
 */

public class Level {

    // Связь между уровнями. Какой уровень с каким - соседние.
    // Обязательно должен указывать сам на себя!
    final int[] connections;

    // Объекты на уровне, включая NPC и Enemy - это тоже объекты
    ImmutableArray< LevelObject > objects = null;


    public Entity entity = null;


    Level ( String connectionString, Array< LevelObject > objects ) {
        this.objects = new ImmutableArray< LevelObject >( objects );
        this.connections = toInts( connectionString );
    }


    Level ( String connectionString ) {
        this.connections = toInts( connectionString );
    }


    private static int[] toInts ( String str ) {
        if ( "".equals( str ) ) {
            return null;
        }
        String[] separated = str.replaceAll( " ", "" ).split( "," );
        final int[] result = new int[ separated.length ];
        for ( int p = 0; p < separated.length; p++ ) {
            result[ p ] = Integer.parseInt( separated[ p ] );
        }
        return result;
    }
}
