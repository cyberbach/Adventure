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
        levelArray.add( new Level( "1, 0, 2, 3", level1objects() ) );
        levelArray.add( new Level( "2, 1, 3", level2objects() ) );
        levelArray.add( new Level( "3, 1, 2, 4", level3objects() ) );
        levelArray.add( new Level( "4, 3, 5", level4objects() ) );
        levelArray.add( new Level( "5, 4", level5objects() ) );

        array = new ImmutableArray< Level >( levelArray );
    }


    private static Array< LevelObject > level0objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.BROOM_WEAPON,
                                      ModelAsset.BROOM_WEAPON1,
                                      new Vector3( -2.566254f, 0.907035f, -4.6540112f ) ) );

        objects.add( hoverCoin( 3.8215625f, 2.909436f, -7.290692f ) );
        objects.add( hoverCoin( 2.0027287f, 2.5295668f, -7.6992803f ) );
        objects.add( hoverCoin( 1.7778516f, 2.652409f, -9.85341f ) );
        objects.add( hoverCoin( -8.499469f, 2.4801855f, -5.338491f ) );
        objects.add( hoverCoin( -8.047337f, 3.4476857f, 2.0262415f ) );
        objects.add( hoverBottle( 7.4293437f, 2.3498673f, 3.1990445f ) );
        objects.add( hoverCoin( 8.339297f, 2.2162886f, 5.705835f ) );

        objects.add( box( 7.102702f, 3.5108666f, 16.62674f, Item.BLUE_STAR ) );
        objects.add( box( -2.1007736f, 2.50011f, 10.098732f ) );
        objects.add( box( -8.834456f, 1.6002967f, -1.8023157f ) );
        objects.add( box( 5.86802f, 1.1149557f, -0.5165689f ) );

        /*

        // OLD OLD code

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


    private static Array< LevelObject > level1objects () {
        Array< LevelObject > objects = new Array< LevelObject >();
        //-29.12711,1.3195913,-82.997826
        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.KALASH_WEAPON,
                                      ModelAsset.KALASH_WEAPON3,
                                      new Vector3( -29.12711f, 1.3195913f, -82.997826f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.LADDER,
                                      ModelAsset.COIN,
                                      new Vector3( -33.666f, 12.0f, -79.593f ),
                                      10 ) );

        objects.add( hoverCoin( -59.468754f, 0.54161084f, -63.818703f ) );

        objects.add( hoverCoin( -0.06948589f, 5.3373847f, -57.303333f ) );
        objects.add( hoverCoin( -3.8032222f, 5.3736916f, -58.75824f ) );
        objects.add( hoverCoin( -13.801162f, 4.147485f, -61.89045f ) );
        objects.add( hoverCoin( 10.466883f, 4.095286f, -71.61301f ) );
        objects.add( hoverCoin( 10.423982f, 4.017071f, -75.613754f ) );
        objects.add( hoverCoin( -28.563711f, 3.4057555f, -54.43523f ) );

        objects.add( box( -43.054924f, 1.1326197f, -86.90576f, Item.COIN ) );
        objects.add( box( -32.695198f, 1.8836857f, -89.45806f, Item.GREEN_STAR ) );
        objects.add( box( -23.90081f, 1.2262814f, -88.17595f, Item.COIN ) );
        objects.add( box( 18.394983f, 2.3045547f, -82.30265f ) );

        objects.add( box( -34.71902f, 13.961574f, -72.98996f, Item.COIN ) );
        objects.add( box( -31.49834f, 22.330067f, -79.208176f, Item.COIN ) );
        objects.add( box( -28.578236f, 22.314957f, -79.04957f ) );
/*

        objects.add( hoverCoin( -32.703f, 14.042f, -73.201f ) );

        objects.add( hoverCoin( -32.703f, 22.398f, -79.580f ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( -29.120f, 22.398f, -78.803f ) ) );

        objects.add( hoverCoin( -13.326f, 0.557f, -43.258f ) );
        objects.add( hoverCoin( -20.228f, 0.775f, -86.2f ) );
*/

        return objects;
    }


    private static Array< LevelObject > level2objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.RAKE_WEAPON,
                                      ModelAsset.RAKE_WEAPON2,
                                      new Vector3( -1.1865791f, 2.7401257f, -153.47026f ) ) );

        objects.add( hoverCoin( 23.473248f, 3.3257918f, -149.59673f ) );
        objects.add( hoverCoin( 26.19768f, 3.3371155f, -149.85556f ) );
        objects.add( hoverBottle( 26.942774f, 3.3635728f, -151.56834f ) );
        objects.add( hoverCoin( 16.20091f, 2.1369853f, -156.37874f ) );
        objects.add( hoverCoin( 2.8433032f, 1.9630667f, -156.65167f ) );
        objects.add( hoverCoin( -0.08271152f, 2.3794906f, -155.92131f ) );

        objects.add( box( -12.749359f, 0.83835983f, -158.29185f, Item.COIN ) );
        objects.add( box( -12.904193f, 0.8978082f, -154.0391f, Item.COIN ) );
        objects.add( box( 21.482891f, 0.69398946f, -163.47675f ) );
        objects.add( box( 30.171566f, 0.9804662f, -155.9155f, Item.COIN ) );
        objects.add( box( 4.2649007f, 2.3494797f, -150.69984f, Item.GREEN_STAR ) );

        return objects;
    }


    private static Array< LevelObject > level3objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( -75.930626f, 4.587798f, -189.51195f ) );
        objects.add( hoverBottle( -79.52511f, 4.0374074f, -189.01859f ) );
        objects.add( hoverCoin( -78.972694f, 4.2645297f, -192.8407f ) );
        objects.add( hoverCoin( -62.12069f, 1.772642f, -216.14336f ) );
        objects.add( hoverCoin( -66.58269f, 1.1613581f, -250.24501f ) );

        objects.add( hoverCoin( -98.25061f, 0.15273489f, -251.49251f ) );
        objects.add( hoverCoin( -109.57931f, 2.135044f, -255.94427f ) );
        objects.add( hoverCoin( -110.871895f, 2.261999f, -268.09924f ) );
        objects.add( hoverCoin( -105.03497f, 0.5416111f, -286.58466f ) );

        objects.add( box( -116.59903f, 2.5893686f, -263.89517f ) );
        objects.add( box( -104.25894f, 7.7526255f, -236.18323f, Item.COIN ) );
        objects.add( box( -71.027985f, 7.992463f, -263.79257f ) );

        return objects;
    }


    private static Array< LevelObject > level4objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverBottle( -134.07967f, 3.0370257f, -367.3695f ) );
        objects.add( hoverCoin( -131.90904f, 3.248974f, -364.48978f ) );
        objects.add( hoverCoin( -127.98646f, 2.9535644f, -367.3582f ) );
        objects.add( hoverCoin( -130.32939f, 3.0170774f, -371.31467f ) );
        objects.add( hoverCoin( -112.93195f, 3.9779391f, -388.627f ) );

        objects.add( hoverCoin( -107.47616f, 4.7119007f, -393.81418f ) );
        objects.add( hoverCoin( -133.87976f, -0.002511868f, -402.92636f ) );

        objects.add( box( -146.9402f, -0.80520976f, -409.57574f, Item.GREEN_STAR ) );
        objects.add( box( -156.81668f, 1.937732f, -388.8988f ) );
        objects.add( box( -169.97949f, 2.3963823f, -404.33224f, Item.COIN ) );
        objects.add( box( -189.49858f, 0.5438573f, -413.93027f ) );

        return objects;
    }


    private static Array< LevelObject > level5objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.BORDER_WEAPON,
                                      ModelAsset.FENCE_WEAPON4,
                                      new Vector3( -244.39001f,1.686245f,-420.27023f ) ) );

        objects.add( hoverCoin( -218.1792f, 1.2710103f, -408.69302f ) );
        objects.add( hoverCoin( -218.30159f, 1.1370168f, -404.0892f ) );
        objects.add( hoverCoin( -221.48405f, 1.0303565f, -406.00296f ) );
        objects.add( hoverCoin( -235.96443f, 2.0197074f, -412.43854f ) );
        objects.add( hoverCoin( -236.23094f, 1.7357274f, -415.68683f ) );

        objects.add( hoverCoin( -244.9137f, 0.68355834f, -403.81934f ) );
        objects.add( hoverCoin( -246.35252f, 1.096554f, -385.27545f ) );
        objects.add( hoverCoin( -240.30139f, 2.2858207f, -382.78412f ) );

        objects.add( box( -244.96101f, 0.96003973f, -381.426f, Item.COIN ) );
        objects.add( box( -248.59004f, 0.55163205f, -402.9684f, Item.COIN ) );
        objects.add( box( -251.01166f, 1.698267f, -429.71417f, Item.BLUE_STAR ) );
        objects.add( box( -239.39738f, 2.5849354f, -433.67297f, Item.COIN ) );
        objects.add( box( -215.69734f, 4.1981606f, -432.03983f ) );

        return objects;
    }


    private static LevelObject box ( float x, float y, float z, Item itemInBox ) {
        return new LevelObject( OBJECT_TYPE.BOX,
                                itemInBox,
                                ModelAsset.CRATE,
                                new Vector3( x, y, z ) );
    }


    private static LevelObject box ( float x, float y, float z ) {
        return new LevelObject( OBJECT_TYPE.BOX,
                                ModelAsset.CRATE,
                                new Vector3( x, y, z ) );
    }


    private static LevelObject hoverCoin ( float x, float y, float z ) {
        return new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE, Item.COIN, ModelAsset.COIN,
                                new Vector3( x, y, z ) );
    }


    private static LevelObject hoverBottle ( float x, float y, float z ) {
        return new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE, Item.RED_BOTTLE, ModelAsset.BOTTLE,
                                new Vector3( x, y, z ) );
    }


    private static LevelObject ladder ( Vector3 pos ) {
        return new LevelObject( OBJECT_TYPE.LADDER, ModelAsset.COIN, pos );
    }


    public static void dispose () {
        array = null;
    }
}
