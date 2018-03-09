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

        levelArray.add( new Level( "0, 1", level0objects() ) );
        levelArray.add( new Level( "1, 0, 2,3",level1objects() ) );
        levelArray.add( new Level( "2, 1,3" ) );
        levelArray.add( new Level( "3, 1,2" ) );
        //levelArray.add( new Level( "1, 0, 2, 3" ) );
        //levelArray.add( new Level( "2, 1" ) );
        //levelArray.add( new Level( "3, 1" ) );

        // лестница повёрнута на -63.787 по Y

        array = new ImmutableArray< Level >( levelArray );
    }

    private static Array<LevelObject> level1objects(){
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( ladder( new Vector3( -33.666f, 4.011f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 9.048f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 13.725f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 18.293f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 19.809f, -79.593f ) ) );

        objects.add( hoverCoin( new Vector3( -35.026f, 14.042f, -73.224f ) ) );
        objects.add( hoverCoin( new Vector3( -35.774f, 14.042f, -74.696f ) ) );
        objects.add( hoverCoin( new Vector3( -36.335f, 14.042f, -76.494f ) ) );
        objects.add( hoverCoin( new Vector3( -32.703f, 14.042f, -73.201f ) ) );

        objects.add( hoverCoin( new Vector3( -32.703f, 22.398f, -79.580f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( -29.120f, 22.398f, -78.803f ) ) );

        return  objects;
    }

    private static Array< LevelObject > level0objects () {
        Array< LevelObject > objects = new Array< LevelObject >();


        objects.add( hoverCoin( new Vector3( -8.942f, 3.472f, 2.984f ) ) );
        objects.add( hoverCoin( new Vector3( -8.942f, 3.366f, 4.579f ) ) );
        objects.add( hoverCoin( new Vector3( -7.728f, 3.413f, 4.181f ) ) );
        objects.add( hoverCoin( new Vector3( -0.454f, 2.537f, 6.884f ) ) );
        objects.add( hoverCoin( new Vector3( -1.239f, 2.632f, 7.613f ) ) );
        objects.add( hoverCoin( new Vector3( -1.514f, 2.606f, 8.742f ) ) );
        objects.add( hoverCoin( new Vector3( -1.313f, 2.415f, 9.890f ) ) );

        objects.add( hoverCoin( new Vector3( 9.7f, 2.198f, 3.923f ) ) );
        objects.add( hoverCoin( new Vector3( 9.887f, 1.947f, 7.158f ) ) );

        objects.add( hoverCoin( new Vector3( -2.556f, 1.039f, -10.971f ) ) );
        objects.add( hoverCoin( new Vector3( -2.879f, 1.125f, -9.551f ) ) );
        objects.add( hoverCoin( new Vector3( -2.66f, 1.01f, -6.196f ) ) );
        objects.add( hoverCoin( new Vector3( 5.713f, 3.484f, -9.442f ) ) );
        objects.add( hoverCoin( new Vector3( -13.723f, 0.958f, -4.923f ) ) );
        objects.add( hoverCoin( new Vector3( -14.363f, 0.610f, -5.439f ) ) );


        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( 8.046f, 0.709f, 19.187f ) ) );


        /*
       objects.add( new LevelObject( OBJECT_TYPE.LADDER,
                                     ModelAsset.LADDER,
                                     new Vector3( 14.994f, -0.995f, 2.719f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.PICKABLE,
                                      Item.RED_BOTTLE,
                                      ModelAsset.BOTTLE,
                                      new Vector3( -1.0f, 4, -3.5f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( 15.195f, 5.936f, -0.19f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( 15.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.COIN,
                                      ModelAsset.COIN,
                                      new Vector3( 15.195f, 6.707f, -5.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.BLUE_STAR,
                                      ModelAsset.BSTAR,
                                      new Vector3( 12.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.YELLOW_STAR,
                                      ModelAsset.YSTAR,
                                      new Vector3( 17.195f, 4.707f, -6.442f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.COLLECTABLE,
                                      Item.RED_BOTTLE,
                                      ModelAsset.BOTTLE,
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
*/

        return objects;
    }

    private static LevelObject hoverCoin(Vector3 pos){
        return new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE, Item.COIN, ModelAsset.COIN, pos );
    }

    private static LevelObject ladder(Vector3 pos){
        return new LevelObject( OBJECT_TYPE.LADDER, ModelAsset.COIN, pos );
    }


    public static void dispose () {
        array = null;
    }
}
