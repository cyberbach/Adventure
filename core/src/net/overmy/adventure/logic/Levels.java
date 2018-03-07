package net.overmy.adventure.logic;

import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.ModelAsset;

/**
 * Created by Andrey (cb) Mikheev
 * 01.03.2017
 */

public final class Levels {

    private static ImmutableArray< Level > array = null;


    static Level get ( int n ) {
        return array.get( n );
    }


    static void init () {
        Array< Level > levelArray = new Array< Level >();

        levelArray.add( new Level( "0, 1", level01objects() ) );
        levelArray.add( new Level( "1, 0, 2, 3" ) );
        levelArray.add( new Level( "2, 1" ) );
        levelArray.add( new Level( "3, 1" ) );

        array = new ImmutableArray< Level >( levelArray );
    }


    private static Array< LevelObject > level01objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

       objects.add( new LevelObject( OBJECT_TYPE.LADDER,
                                     ModelAsset.LADDER,
                                     new Vector3( 14.994f, -0.995f, 2.719f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.PICKABLE,
                                      Item.GAME_STUFF1,
                                      ModelAsset.STUFF,
                                      new Vector3( -3.5f, 3, 0 ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.PICKABLE,
                                      Item.GAME_STUFF2,
                                      ModelAsset.STUFF,
                                      new Vector3( -1.0f, 4, -3.5f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.GAME_STUFF3,
                                      ModelAsset.STUFF,
                                      new Vector3( 15.195f, 5.936f, -0.19f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.GAME_STUFF4,
                                      ModelAsset.STUFF,
                                      new Vector3( 15.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GAME_STUFF4,
                                      ModelAsset.STUFF,
                                      new Vector3( 12.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GAME_STUFF4,
                                      ModelAsset.STUFF,
                                      new Vector3( 17.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.GAME_STUFF5,
                                      ModelAsset.STUFF,
                                      new Vector3( 15.195f, 3.262f, -12.414f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.NPC,
                                      TextBlock.DialogNPC1,
                                      NPCActionQueues.get( 0 ),
                                      ModelAsset.HOG,
                                      new Vector3( 9.298f, 0.0f, -8.390f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.ENEMY,
                                      NPCActionQueues.get( 1 ),
                                      ModelAsset.FOX,
                                      new Vector3( 9.298f, 0.0f, -8.390f ) ) );

        return objects;
    }



    public static void dispose () {
        array = null;
    }
}
