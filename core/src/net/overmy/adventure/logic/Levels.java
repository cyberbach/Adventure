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
        //levelArray.add( new Level( "1, 0, 2, 3" ) );
        //levelArray.add( new Level( "2, 1" ) );
        //levelArray.add( new Level( "3, 1" ) );

        // лестница повёрнута на -63.787 по Y

        array = new ImmutableArray< Level >( levelArray );
    }


    private static Array<LevelObject> level5objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( -196.35855f, 0.63509166f, -404.04517f) );
        objects.add( hoverCoin( -200.1569f, 0.79951113f, -404.2366f) ) ;
        objects.add( hoverCoin( -202.12108f, 0.8834061f, -404.47586f) ) ;
        objects.add( hoverCoin( -205.16072f, 1.0139244f, -404.76074f) ) ;
        objects.add( hoverCoin( -220.7892f, 0.8514296f, -404.15768f) ) ;
        objects.add( hoverCoin( -222.1618f, 1.3190395f, -402.74313f) ) ;
        objects.add( hoverCoin( -224.30893f, 1.6019378f, -402.92404f) ) ;
        objects.add( hoverCoin( -225.74881f, 1.4579816f, -406.06696f) ) ;
        objects.add( hoverCoin( -222.92104f, 1.2211504f, -407.3873f) ) ;
        objects.add( hoverCoin( -220.82198f, 1.0568011f, -406.67303f) ) ;
        objects.add( hoverCoin( -237.05054f, 1.2573936f, -418.9383f) ) ;
        objects.add( hoverCoin( -236.98131f, 1.3925382f, -417.85236f) ) ;
        objects.add( hoverCoin( -236.56612f, 1.6427253f, -416.248f) ) ;
        objects.add( hoverCoin( -236.45978f, 1.7283484f, -415.01315f) ) ;
        objects.add( hoverCoin( -236.5322f, 1.8263453f, -413.7054f) ) ;
        objects.add( hoverCoin( -236.52136f, 1.9231768f, -412.4781f) ) ;
        objects.add( hoverCoin( -253.90889f, 3.9663527f, -421.66592f) ) ;
        objects.add( hoverCoin( -255.2404f, 4.20833f, -420.43478f) ) ;
        objects.add( hoverCoin( -257.82523f, 4.4995456f, -417.61618f) ) ;
        objects.add( hoverCoin( -246.25876f, 1.0632147f, -384.66144f) ) ;
        objects.add( hoverCoin( -246.90839f, 1.1631004f, -387.29358f) ) ;
        objects.add( hoverCoin( -239.58675f, 2.8124866f, -384.094f) ) ;
        objects.add( hoverCoin( -236.86656f, 3.7752507f, -386.75186f) ) ;
        objects.add( hoverCoin( -220.27519f, 3.9543576f, -392.55505f) ) ;
        objects.add( hoverCoin( -216.68436f, 3.6974113f, -393.39847f) ) ;

        return objects;
    }


    private static Array< LevelObject > level4objects () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( hoverCoin( -146.47934f, 0.54161084f, -338.95984f ) );
        objects.add( hoverCoin( -142.402f, 0.5415975f, -341.18814f ) );
        objects.add( hoverCoin( -135.8123f, 0.5416082f, -339.46304f ) );
        objects.add( hoverCoin( -138.46185f, 0.54161084f, -338.8946f ) );
        objects.add( hoverCoin( -143.92328f, 0.54161084f, -338.21707f ) );
        objects.add( hoverCoin( -154.52682f, -0.766466f, -366.08273f ) );
        objects.add( hoverCoin( -155.96092f, -0.8442566f, -368.12518f ) );
        objects.add( hoverCoin( -157.23453f, -0.8623356f, -369.96616f ) );
        objects.add( hoverCoin( -166.12473f, 1.8369017f, -382.42297f ) );
        objects.add( hoverCoin( -167.07478f, 2.3342664f, -384.55765f ) );
        objects.add( hoverCoin( -166.30888f, 2.8117545f, -387.69772f ) );
        objects.add( hoverCoin( -106.67366f, 6.0303354f, -399.642f ) );
        objects.add( hoverCoin( -104.91859f, 5.111605f, -396.66156f ) );
        objects.add( hoverCoin( -106.36855f, 4.3706264f, -392.27832f ) );
        objects.add( hoverCoin( -112.74228f, 4.5704446f, -392.91406f ) );
        objects.add( hoverCoin( -113.17369f, 4.9738655f, -397.32996f ) );
        return objects;
    }


    private static Array< LevelObject > level2objects () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( hoverCoin( 22.46439f, 0.62907183f, -127.67026f ) );
        objects.add( hoverCoin( 21.75979f, 0.6560357f, -129.4644f ) );
        objects.add( hoverCoin( 21.247566f, 0.6560613f, -132.86165f ) );
        objects.add( hoverCoin( 20.78694f, 0.6534292f, -136.15164f ) );
        objects.add( hoverCoin( 26.177689f, 3.3268213f, -150.30537f ) );
        objects.add( hoverCoin( 24.476652f, 3.2425523f, -150.44772f ) );
        objects.add( hoverCoin( 23.184046f, 3.2617517f, -150.0954f ) );
        objects.add( hoverCoin( 24.779282f, 2.2560663f, -155.02608f ) );
        objects.add( hoverCoin( 24.855629f, 2.03795f, -156.69939f ) );
        objects.add( hoverCoin( 23.421154f, 1.9849491f, -157.05704f ) );

        objects.add( hoverCoin( 21.557129f, 1.9643793f, -157.36612f ) );
        objects.add( hoverCoin( 19.71909f, 2.019936f, -156.89787f ) );
        objects.add( hoverCoin( 17.292744f, 2.1273012f, -155.85327f ) );
        objects.add( hoverCoin( 18.927511f, 2.2689106f, -153.90501f ) );
        objects.add( hoverCoin( 22.067165f, 2.7526138f, -152.61664f ) );
        objects.add( hoverCoin( 24.025759f, 3.0277567f, -152.11678f ) );
        objects.add( hoverCoin( 22.3938f, 2.2497418f, -154.77184f ) );
        objects.add( hoverCoin( 2.5163205f, 1.8718746f, -157.71204f ) );
        objects.add( hoverCoin( 0.65861064f, 2.1633549f, -157.27907f ) );
        objects.add( hoverCoin( 3.717751f, 1.992257f, -155.65111f ) );

        objects.add( hoverCoin( 4.5719023f, 2.0877464f, -154.10124f ) );
        objects.add( hoverCoin( 5.0739f, 2.1667337f, -152.14627f ) );
        objects.add( hoverCoin( 4.7956643f, 2.295328f, -150.67197f ) );
        objects.add( hoverCoin( 4.487303f, 2.2590215f, -149.35686f ) );
        objects.add( hoverCoin( 2.8429134f, 2.4266045f, -149.53572f ) );
        objects.add( hoverCoin( 0.62220025f, 2.7666993f, -150.12163f ) );
        objects.add( hoverCoin( 8.600548f, 0.63876903f, -161.74582f ) );
        objects.add( hoverCoin( 7.9740896f, 0.7134469f, -164.41498f ) );
        objects.add( hoverCoin( 7.6578517f, 0.8603675f, -167.87555f ) );
        objects.add( hoverCoin( 6.3579803f, 0.6661473f, -164.87384f ) );

        objects.add( hoverCoin( 9.302555f, 0.71296954f, -164.96626f ) );
        objects.add( hoverCoin( 23.937551f, 0.67368287f, -164.0812f ) );
        objects.add( hoverCoin( 26.885487f, 0.62506574f, -163.64415f ) );
        objects.add( hoverCoin( 25.364252f, 0.7418456f, -161.19092f ) );
        objects.add( hoverCoin( -5.6590705f, 2.6435177f, -165.19545f ) );
        objects.add( hoverCoin( -6.1894236f, 2.1926687f, -163.69919f ) );
        objects.add( hoverCoin( -6.736097f, 1.7890724f, -162.36333f ) );
        objects.add( hoverCoin( -7.323409f, 1.2222024f, -160.47807f ) );

        // npc new Vector3(-4.53393f, 1.8664804f, -162.51537f)
        objects.add( new LevelObject( OBJECT_TYPE.NPC,
                                      TextBlock.DialogNPC1,
                                      NPCActionQueues.get( 0 ),
                                      ModelAsset.HOG,
                                      new Vector3( -4.53393f, 1.8664804f, -162.51537f ) ) );

        return objects;
    }


    private static Array< LevelObject > level3objects () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( hoverCoin( -94.68628f, 0.14566536f, -252.02551f ) );
        objects.add( hoverCoin( -92.642815f, 0.12475335f, -252.07326f ) );
        objects.add( hoverCoin( -90.6411f, 0.12383649f, -251.93196f ) );
        objects.add( hoverCoin( -95.21356f, 0.31643194f, -255.27287f ) );
        objects.add( hoverCoin( -93.26875f, 0.33046085f, -255.43474f ) );
        objects.add( hoverCoin( -90.98106f, 0.30813295f, -255.17671f ) );
        objects.add( hoverCoin( -111.264f, 2.1737888f, -255.99652f ) );
        objects.add( hoverCoin( -111.703674f, 2.3945343f, -258.863f ) );
        objects.add( hoverCoin( -111.31209f, 2.3795605f, -262.07272f ) );
        objects.add( hoverCoin( -111.228f, 2.318276f, -265.58017f ) );

        objects.add( hoverCoin( -112.858284f, 2.4043128f, -265.94736f ) );
        objects.add( hoverCoin( -109.42588f, 2.2117765f, -265.8811f ) );
        objects.add( hoverCoin( -107.33408f, 1.9091709f, -274.8806f ) );
        objects.add( hoverCoin( -104.57579f, 1.0964588f, -280.70157f ) );
        objects.add( hoverCoin( -79.214775f, 4.0852847f, -188.73549f ) );
        objects.add( hoverCoin( -78.20081f, 4.2385297f, -190.7036f ) );
        objects.add( hoverCoin( -78.829f, 4.1737056f, -192.30806f ) );
        objects.add( hoverCoin( -80.10368f, 4.74481f, -194.70271f ) );
        objects.add( hoverCoin( -81.293274f, 5.2491465f, -196.65297f ) );
        objects.add( hoverCoin( -85.93721f, 5.7634697f, -198.36472f ) );

        objects.add( hoverCoin( -87.368286f, 5.3984456f, -207.74004f ) );
        objects.add( hoverCoin( -81.62797f, 4.8763623f, -207.57915f ) );
        objects.add( hoverCoin( -59.05054f, 2.0482202f, -217.98193f ) );
        objects.add( hoverCoin( -55.98276f, 2.336635f, -218.2739f ) );
        objects.add( hoverCoin( -52.62847f, 2.64752f, -218.85062f ) );
        objects.add( hoverCoin( -48.4337f, 3.0398157f, -219.36934f ) );
        objects.add( hoverCoin( -43.837643f, 3.438235f, -220.35843f ) );
        objects.add( hoverCoin( -62.118633f, 1.6388345f, -221.29987f ) );
        objects.add( hoverCoin( -61.508625f, 1.5597901f, -225.58488f ) );
        objects.add( hoverCoin( -60.681103f, 1.4876857f, -230.35454f ) );

        objects.add( hoverCoin( -59.470505f, 1.4617426f, -236.13351f ) );
        objects.add( hoverCoin( -52.226948f, 6.040577f, -273.026f ) );
        objects.add( hoverCoin( -57.028984f, 6.8131833f, -272.6064f ) );
        objects.add( hoverCoin( -60.372543f, 7.0008044f, -272.27924f ) );
        objects.add( hoverCoin( -86.139015f, 0.6043578f, -255.68942f ) );
        objects.add( hoverCoin( -92.363686f, 1.0824846f, -259.0186f ) );
        objects.add( hoverCoin( -97.684845f, 1.2213831f, -259.9052f ) );
        objects.add( hoverCoin( -103.64628f, 1.4208131f, -260.40207f ) );
        objects.add( hoverCoin( -96.30071f, 0.24253976f, -253.25688f ) );
        objects.add( hoverCoin( -93.86384f, 0.25448945f, -253.83777f ) );

        objects.add( hoverCoin( -92.38739f, 0.22335388f, -253.62717f ) );
        objects.add( hoverCoin( -90.009285f, 0.19499949f, -253.62129f ) );
        objects.add( hoverCoin( -75.96941f, 4.582231f, -189.16896f ) );

        return objects;
    }


    private static Array< LevelObject > level1objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( ladder( new Vector3( -33.666f, 4.011f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 9.048f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 13.725f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 18.293f, -79.593f ) ) );
        objects.add( ladder( new Vector3( -33.666f, 19.809f, -79.593f ) ) );

        objects.add( hoverCoin( -35.026f, 14.042f, -73.224f ) );
        objects.add( hoverCoin( -35.774f, 14.042f, -74.696f ) );
        objects.add( hoverCoin( -36.335f, 14.042f, -76.494f ) );
        objects.add( hoverCoin( -32.703f, 14.042f, -73.201f ) );

        objects.add( hoverCoin( -32.703f, 22.398f, -79.580f ) );

        objects.add( new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE,
                                      Item.GREEN_STAR,
                                      ModelAsset.GSTAR,
                                      new Vector3( -29.120f, 22.398f, -78.803f ) ) );

        objects.add( hoverCoin( -13.326f, 0.557f, -43.258f ) );
        objects.add( hoverCoin( -15.502f, 0.761f, -44.705f ) );
        objects.add( hoverCoin( -28.709f, 3.262f, -53.931f ) );
        objects.add( hoverCoin( -29.671f, 3.393f, -56.369f ) );
        objects.add( hoverCoin( -32.464f, 3.514f, -55.651f ) );
        objects.add( hoverCoin( -37.472f, 4.184f, -53.221f ) );
        objects.add( hoverCoin( -39.235f, 3.807f, -55.963f ) );

        objects.add( hoverCoin( -1.38f, 5.25f, -54.671f ) );
        objects.add( hoverCoin( 0.0f, 5.156f, -56.981f ) );
        objects.add( hoverCoin( 1.891f, 4.616f, -58.667f ) );

        objects.add( hoverCoin( 10.558f, 4.044f, -72.004f ) );
        objects.add( hoverCoin( 13.641f, 4.151f, -72.004f ) );
        objects.add( hoverCoin( 16.057f, 4.128f, -72.474f ) );
        objects.add( hoverCoin( 13.521f, 3.894f, -77.896f ) );
        objects.add( hoverCoin( 15.629f, 3.963f, -77.896f ) );

        objects.add( hoverCoin( -14.018f, 0.579f, -83.645f ) );
        objects.add( hoverCoin( -17.0f, 0.628f, -84.841f ) );
        objects.add( hoverCoin( -20.228f, 0.775f, -86.2f ) );

        return objects;
    }


    private static Array< LevelObject > level0objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        //new Vector3(6.591744f, 2.3367777f, 5.2940097f)
        objects.add( new LevelObject( OBJECT_TYPE.NPC,
                                      TextBlock.DialogNPC1,
                                      NPCActionQueues.get( 1 ),
                                      ModelAsset.HOG,
                                      new Vector3( 6.591744f, 2.3367777f, 5.2940097f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.CLUB_WEAPON,
                                      ModelAsset.CLUB_WEAPON,
                                      new Vector3( -8.942f, 3.472f, 2.984f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.WEAPON,
                                      Item.SWORD_WEAPON,
                                      ModelAsset.SWORD_WEAPON,
                                      new Vector3( -8.942f, 3.366f, 4.579f ) ) );

        objects.add( hoverCoin( -7.728f, 3.413f, 4.181f ) );
        objects.add( hoverCoin( -0.454f, 2.537f, 6.884f ) );
        objects.add( hoverCoin( -1.239f, 2.632f, 7.613f ) );
        objects.add( hoverCoin( -1.514f, 2.606f, 8.742f ) );
        objects.add( hoverCoin( -1.313f, 2.415f, 9.890f ) );

        objects.add( hoverCoin( 9.7f, 2.198f, 3.923f ) );
        objects.add( hoverCoin( 9.887f, 1.947f, 7.158f ) );

        objects.add( hoverCoin( -2.556f, 1.039f, -10.971f ) );
        objects.add( hoverCoin( -2.879f, 1.125f, -9.551f ) );
        objects.add( hoverCoin( -2.66f, 1.01f, -6.196f ) );
        objects.add( hoverCoin( 5.713f, 3.484f, -9.442f ) );
        objects.add( hoverCoin( -13.723f, 0.958f, -4.923f ) );
        objects.add( hoverCoin( -14.363f, 0.610f, -5.439f ) );

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


    private static LevelObject hoverCoin ( float x, float y, float z ) {
        return new LevelObject( OBJECT_TYPE.HOVER_COLLECTABLE, Item.COIN, ModelAsset.COIN,
                                new Vector3( x, y, z ) );
    }


    private static LevelObject ladder ( Vector3 pos ) {
        return new LevelObject( OBJECT_TYPE.LADDER, ModelAsset.COIN, pos );
    }


    public static void dispose () {
        array = null;
    }
}
