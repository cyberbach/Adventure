package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 21.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.ModelAsset;

class LevelObjectSubs {

    // Этот класс работает по принципу ENUM


    Array< LevelObject > LEVEL0 () {
        Array< LevelObject > objects = new Array< LevelObject >();
/*

        objects.add( new LevelObject()
                .setType( OBJECT_TYPE.DOOR )
                .setDoorAngles(305.72955f,77.70956f)
                .setDynamicModelAsset( ModelAsset.DOOR )
                .setItem( Item.KEY1 )
                .setPosition( new Vector3( 0.87952834f, 0.5416097f, -15.525002f ) ) );
*/
/*
        objects.add( new LevelObject()
                .setType( OBJECT_TYPE.DOOR )
                .setDoorAngles(105.22955f,296.64957f)
                .setDynamicModelAsset( ModelAsset.DOOR )
                .setItem( Item.COIN )
                .setPosition( new Vector3( -6.7347302f, 0.55675274f, -13.492119f ) ) );*//*


        objects.add( new LevelObject()
                .setType( OBJECT_TYPE.DOOR_SWITCH )
                .setDynamicModelAsset( ModelAsset.LOCK )
                .setItem( Item.KEY1 )
                .setPosition( new Vector3( 1.0180728f, 1.907327f, -5.882462f ) ) );
*/

        objects.add( trigger( Item.TRIGGER1, -3.446573f, 1.3729875f, -7.244136f, 4.0f ) );
        //objects.add( weapon( -2.566254f, 0.0907035f, -4.6540112f, Item.BROOM_WEAPON ) );
       // objects.add( weapon( 1.0180728f, 1.907327f, -5.882462f, Item.BROOM_WEAPON) );

        objects.add( hoverBlueBottle( 3.5297053f, 1.9786499f, -4.1287537f) );
        objects.add( weapon( 4.541143f, 1.4141711f, -2.2358634f, Item.RAKE_WEAPON) );

        objects.add( weapon( 7.5239773f, 1.326849f, -2.0801325f, Item.BAT_WEAPON) );
        objects.add( weapon( 4.942679f, 1.4902402f, 1.7424695f, Item.BAT_WEAPON) );

        objects.add( weapon( 8.667573f, 2.1916878f, 2.8152184f, Item.KALASH_WEAPON) );
        objects.add( hoverCoin( 6.8247967f, 2.3583481f, 4.868616f) );

        objects.add( weapon( 9.002632f, 2.0301335f, 7.437962f, Item.GUN_WEAPON) );
        objects.add( weapon( 7.0671344f, 1.9452436f, 9.3607435f, Item.GUN_WEAPON) );

        objects.add( weapon( 4.221447f, 1.0784031f, 10.264698f, Item.PILLOW_WEAPON) );
        objects.add( weapon( 3.3727143f, 1.2619562f, 8.226095f, Item.PILLOW_WEAPON) );

        /*objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setTextInteract( TextInteract.Book1 )
                             .setPosition( new Vector3( -7.6205816f, 1.8f, -8.869345f ) )
                             .setRotation( 110.0f ) );

        objects.add( trigger( Item.TRIGGER1, -3.446573f, 1.3729875f, -7.244136f, 4.0f ) );
        objects.add( trigger( Item.TRIGGER2, 5.328025f, 2.2757506f, 3.47663f, 3.0f ) );

        objects.add( weapon( -2.566254f, 0.0907035f, -4.6540112f, Item.BROOM_WEAPON ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.STAR1_ON_LEVEL0() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( 5.8699236f, 0.9654312f, 10.142155f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.STAR2_ON_LEVEL0() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( 8.697725f, 1.1986834f, -2.0947685f ) ) );

        //objects.add( rock( 3.8215625f, 2.909436f, -7.290692f ) );

        objects.add( hoverCoin( 3.8215625f, 2.909436f, -7.290692f ) );
        objects.add( hoverCoin( 2.0027287f, 2.5295668f, -7.6992803f ) );
        objects.add( hoverCoin( 1.7778516f, 2.652409f, -9.85341f ) );
        objects.add( hoverCoin( -8.499469f, 2.4801855f, -5.338491f ) );
        objects.add( hoverCoin( -8.047337f, 3.4476857f, 2.0262415f ) );
        objects.add( hoverGreenBottle( 9.4293437f, 2.3498673f, 5.1990445f ) );
        objects.add( hoverRedBottle( 7.4293437f, 2.3498673f, 3.1990445f ) );
        objects.add( hoverCoin( 8.339297f, 2.2162886f, 5.705835f ) );

        objects.add( box( 7.102702f, 3.5108666f, 16.62674f, Item.BLUE_STAR ) );
        objects.add( chest( -2.1007736f, 2.50011f, 10.098732f, Item.COIN ) );
        objects.add( box( -8.834456f, 1.6002967f, -1.8023157f ) );
        objects.add( box( 5.86802f, 1.1149557f, -0.5165689f, Item.COIN ) );*/

        return objects;
    }


    Array< LevelObject > LEVEL1 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        /*
        Pushed angle = 316.11386:
new Vector3( -65.847916f, 0.5416059f, -73.49805f )
         */
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles(316.0f,50.0f)
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY1 )
                             .setPosition( new Vector3( -65.847916f, 0.5416059f, -73.49805f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY1 )
                             .setRotation( 50.0f )
                             .setPosition( new Vector3( -61.363125f, 0.54160416f, -69.18484f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setTextInteract( TextInteract.Dialog1HogPrickle )
                             .setActionQueue( NPCActionQueue.HOG_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.HOG )
                             .setPosition( new Vector3( -25.33078f, 5, -66.74849f ) ) );

        objects.add( weapon( -29.12711f, 1.3195913f, -82.997826f, Item.KALASH_WEAPON ) );
        objects.add( ladder( new Vector3( -33.666f, 12.0f, -79.593f ), 10.0f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.STAR1_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -30.599691f, 3, -52.38856f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.STAR2_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setItem( Item.KEY1 )
                             .setPosition( new Vector3( -7.1824327f, 5, -60.462067f ) ) );

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
        objects.add( hoverPurpleBottle( -28.578236f, 22.314957f, -79.04957f ) );
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


    Array< LevelObject > LEVEL2 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB1_ON_LEVEL2() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( 26.918205f, 4.0f, -145.5957f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB2_ON_LEVEL2() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -0.387003f, 5, -162.39476f ) ) );

        objects.add( weapon( -1.1865791f, 2.7401257f, -153.47026f, Item.RAKE_WEAPON ) );

        objects.add( hoverGreenBottle( -5.3636923f, 1.8259449f, -155.13283f ) );
        objects.add( hoverCoin( -4.838867f, 1.8350161f, -157.48666f ) );
        //objects.add( rock( -4.409675f,1.8589246f,-157.52556f ) );

        objects.add( hoverCoin( 23.473248f, 3.3257918f, -149.59673f ) );
        objects.add( hoverCoin( 26.19768f, 3.3371155f, -149.85556f ) );
        objects.add( hoverGreenBottle( 26.942774f, 3.3635728f, -151.56834f ) );
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


    Array< LevelObject > LEVEL3 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.STAR_ON_LEVEL3() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -58.313896f, 3, -179.10666f ) ) );

        objects.add( hoverCoin( -75.930626f, 4.587798f, -189.51195f ) );
        objects.add( hoverGreenBottle( -79.52511f, 4.0374074f, -189.01859f ) );
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


    Array< LevelObject > LEVEL4 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.BIRD1_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.BIRD2ANGRY )
                             .setPosition( new Vector3( -137.9316f, -1.0180426f, -407.6164f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.HOG_LEVEL4() )
                             .setTextInteract( TextInteract.Dialog2HogPester )
                             .setDynamicModelAsset( ModelAsset.HOG )
                             .setPosition( new Vector3( -161.27516f, 0.09638158f, -356.9968f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.SHEEP1_ON_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -142.12982f, 1.464614f, -368.08258f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.SHEEP2_ON_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -139.17807f, 1.187504f, -393.3555f ) ) );

        objects.add( hoverGreenBottle( -134.07967f, 3.0370257f, -367.3695f ) );
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


    Array< LevelObject > LEVEL5 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY_ON_LEVEL5() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -219.61375f, 1.9190593f, -400.35522f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.SHEEP_ON_LEVEL5() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -221.7196f, 4.9624543f, -426.501f ) ) );

        objects.add( weapon( -244.39001f, 1.686245f, -420.27023f, Item.FENCE_WEAPON ) );

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


    Array< LevelObject > LEVEL6 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY_ON_LEVEL6() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -40.59898f, 1.6375828f, -420.44955f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB_ON_LEVEL6() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3( -46.878883f, 2.9280591f, -410.01724f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.FOX_ON_LEVEL6() )
                             .setTextInteract( TextInteract.Dialog3FoxAlice )
                             .setDynamicModelAsset( ModelAsset.FOX )
                             .setPosition( new Vector3( -63.024685f, 0.6048689f, -442.56873f ) ) );

        objects.add( chest( -49.353012f, 1.195226f, -423.57303f, Item.GREEN_STAR ) );
        objects.add( chest( -49.944202f, 1.5459726f, -419.02133f, Item.BLUE_STAR ) );
        objects.add( chest( -49.78418f, 1.7487116f, -411.50516f, Item.RED_BOTTLE ) );
        objects.add( chest( -35.611767f, 1.8290501f, -413.95877f, Item.BROOM_WEAPON ) );

        return objects;
    }

    Array< LevelObject > LEVEL7 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles(2.0f,105.0f)
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3( -111.437614f, 2.6524525f, -440.5856f ) ) );


        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles(158.0f,122.0f)
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3(  -113.05335f, 2.6433806f, -430.00235f  ) ) );




        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY2 )
                             .setRotation( 83.0f )
                             .setPosition( new Vector3( -102.94945f, 2.0175083f, -440.3557f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL8 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BEAR1_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -171.49295f, 6.6022253f, -518.231f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.BEAR2_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -224.54436f, 2.4063842f, -516.8102f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.BEAR3_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -210.48898f, 1.7850372f, -509.05664f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.BEAR4_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -167.88797f, 5.4292164f, -498.12292f ) ) );

        objects.add( weapon( -168.6412f, 6.6022253f, -517.167f, Item.GUN_WEAPON ) );

        objects.add( hoverGreenBottle( -210.48468f, 7.024612f, -471.9825f ) );
        objects.add( hoverCoin( -214.6377f, 4.6362476f, -484.83377f ) );
        objects.add( hoverCoin( -216.46123f, 2.8955421f, -490.04166f ) );
        objects.add( hoverCoin( -218.1026f, 2.4937649f, -494.65573f ) );
        objects.add( hoverCoin( -219.36427f, 2.7714198f, -498.1379f ) );
        objects.add( hoverCoin( -226.00545f, 2.8844836f, -508.34943f ) );
        objects.add( hoverCoin( -229.38776f, 2.8697674f, -512.4073f ) );
        objects.add( hoverCoin( -235.3857f, 2.6575413f, -519.5951f ) );
        objects.add( hoverCoin( -239.52682f, 2.691349f, -524.5798f ) );
        objects.add( hoverCoin( -243.74919f, 2.6288273f, -533.02795f ) );
        objects.add( hoverCoin( -245.20413f, 2.8369527f, -537.6428f ) );

        objects.add( weapon( -181.3168f, 4.165142f, -467.5465f, Item.KALASH_WEAPON ) );

        return objects;
    }


    public Array< LevelObject > LEVEL9 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.SHEEP1_ON_LEVEL9() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -81.33341f, 3.6375828f, -475.92508f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.SHEEP2_ON_LEVEL9() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -80.6879f, 2.2810526f, -494.6508f ) ) );

        objects.add( hoverCoin( -58.12171f, 2.095977f, -476.83038f ) );
        objects.add( hoverCoin( -59.177914f, 2.3366253f, -474.5389f ) );
        objects.add( hoverCoin( -63.63271f, 3.1093438f, -473.07233f ) );
        objects.add( hoverCoin( -60.6767f, 4.441463f, -495.30865f ) );
        objects.add( hoverCoin( -63.5629f, 4.4407034f, -496.05893f ) );
        objects.add( hoverCoin( -62.72697f, 5.149046f, -502.2121f ) );
        objects.add( hoverPurpleBottle( -81.8414f, 2.281053f, -494.192f ) );

        objects.add( hoverGreenBottle( -93.72113f, 2.8023152f, -482.6676f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL10 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( -48.00395f, 2.2169616f, -482.1736f ) );
        objects.add( hoverCoin( -43.452667f, 2.0220072f, -481.96835f ) );
        objects.add( hoverCoin( -39.90795f, 2.1651149f, -482.22363f ) );
        objects.add( hoverCoin( -27.60128f, 2.9553905f, -480.87576f ) );
        objects.add( hoverCoin( -24.873093f, 3.1316793f, -480.59894f ) );
        objects.add( hoverCoin( -21.504444f, 3.3492925f, -480.2426f ) );
        objects.add( hoverCoin( -12.959673f, 3.6491039f, -480.1446f ) );
        objects.add( hoverCoin( -10.064625f, 3.6915903f, -480.49643f ) );
        objects.add( hoverCoin( -6.6824374f, 3.7104113f, -480.84433f ) );

        objects.add( chest( -5.6118073f, 3.5440261f, -488.37814f, Item.PILLOW_WEAPON ) );
        objects.add( chest( -6.689987f, 3.9579542f, -474.2815f, Item.RED_BOTTLE ) );
        objects.add( chest( -12.008289f, 6.912627f, -457.6871f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY1_ON_LEVEL10() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -19.114065f, 7.0864205f, -460.6453f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY2_ON_LEVEL10() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -13.218724f, 3.2738621f, -490.88968f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL11 () {
        Array< LevelObject > objects = new Array< LevelObject >();


        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles(251.0f,350.0f)
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3( -100.048386f, 3.0279393f, -554.2773f ) ) );


        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles(75.0f,305.0f)
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3(  -114.85803f, 3.9332876f, -563.1705f   ) ) );




        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY3 )
                             .setRotation( 34.0f )
                             .setPosition( new Vector3( -109.41304f, 0.8357556f, -542.67914f ) ) );





        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB1_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3( -84.048195f, 2.627729f, -522.14417f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB2_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -48.189743f, 1.3030697f, -527.33795f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.CRAB3_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -42.565582f, 1.7068304f, -532.7986f ) ) );

        objects.add( hoverCoin( -16.361292f, 1.8263655f, -561.09094f ) );
        objects.add( hoverCoin( -12.581354f, 1.8918121f, -559.5787f ) );
        objects.add( hoverCoin( -11.679665f, 1.8914082f, -548.3028f ) );
        objects.add( hoverCoin( -14.917933f, 2.235294f, -538.73193f ) );
        objects.add( hoverCoin( -29.773043f, 2.6531353f, -527.09644f ) );
        objects.add( hoverCoin( -33.861378f, 2.0955467f, -530.23035f ) );
        objects.add( hoverCoin( -55.476734f, 0.2184845f, -526.9232f ) );
        objects.add( box( -66.84727f, 0.7216492f, -542.59534f ) );
        objects.add( box( -88.407104f, 2.0471447f, -534.7304f ) );

        objects.add( hoverCoin( -87.91464f, 3.344211f, -554.1267f ) );
        objects.add( hoverCoin( -85.8045f, 3.5456748f, -553.71796f ) );
        objects.add( hoverCoin( -79.23923f, 3.0514371f, -553.7844f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL12 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY1_ON_LEVEL12() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -66.312195f, 4.388742f, -610.7529f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueue.BUTTERFLY2_ON_LEVEL12() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -100.823044f, 4.4190073f, -622.6001f ) ) );

        objects.add( weapon( -94.020935f, 3.9820504f, -651.5067f, Item.BROOM_WEAPON ) );

        objects.add( hoverCoin( -114.81785f, 5.7118063f, -614.2721f ) );
        objects.add( hoverCoin( -113.83685f, 6.114312f, -626.1583f ) );
        objects.add( hoverCoin( -108.039696f, 5.897209f, -636.67316f ) );
        objects.add( hoverCoin( -100.61613f, 4.7539616f, -641.0951f ) );
        objects.add( hoverCoin( -90.344696f, 3.6528409f, -640.7886f ) );
        objects.add( hoverCoin( -83.120316f, 3.3251157f, -634.3404f ) );

        objects.add( box( -62.397404f, 5.7943006f, -631.7061f, Item.GREEN_STAR ) );
        objects.add( box( -69.153275f, 5.886171f, -635.40906f, Item.COIN ) );
        objects.add( box( -39.48968f, 8.332032f, -604.6501f ) );
        objects.add( box( -35.885094f, 8.539717f, -601.6625f, Item.BLUE_STAR ) );
        objects.add( box( -40.352875f, 8.430564f, -602.41583f, Item.GREEN_BOTTLE ) );

        return objects;
    }


    public Array< LevelObject > LEVEL13 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( -27.482477f, 2.2798924f, -651.31683f ) );
        objects.add( hoverCoin( -22.793148f, 2.4052672f, -649.64197f ) );
        objects.add( hoverCoin( -13.693137f, 2.9688635f, -634.6157f ) );

        objects.add( hoverGreenBottle( 3.1004431f, 2.7050533f, -672.6742f ) );
        objects.add( hoverCoin( 3.9622355f, 2.6634638f, -676.0032f ) );
        objects.add( hoverCoin( 7.4769382f, 2.546321f, -680.27f ) );

        objects.add( hoverRedBottle( -7.3736234f, 3.823609f, -645.5372f ) );
        objects.add( hoverPurpleBottle( 5.545152f, 4.282848f, -642.38434f ) );
        return objects;
    }


    public Array< LevelObject > LEVEL14 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( 8.325413f, -12.7240715f, -599.3439f ) );
        objects.add( hoverGreenBottle( 11.756399f, -13.028046f, -597.12427f ) );
        objects.add( hoverCoin( 10.839822f, -12.793727f, -592.21375f ) );
        objects.add( box( 21.306444f, -13.593897f, -585.63354f, Item.BLUE_STAR ) );
        objects.add( hoverCoin( 18.307556f, -11.784177f, -576.92114f ) );
        objects.add( hoverCoin( 27.744362f, -10.38092f, -571.53265f ) );
        objects.add( box( 24.299982f, -9.233858f, -560.9618f, Item.YELLOW_STAR ) );
        objects.add( hoverCoin( 19.769403f, -2.9720454f, -519.43097f ) );
        objects.add( box( 21.610739f, -2.3029711f, -513.0358f, Item.GREEN_STAR ) );
        objects.add( hoverPurpleBottle( 15.532761f, -1.4892286f, -513.135f ) );
        objects.add( hoverCoin( 7.1455574f, 0.6216613f, -508.3141f ) );
        objects.add( hoverCoin( -1.5353625f, 1.973329f, -509.11398f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL15 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.BEAR1_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -259.59073f, 10.645375f, -582.8954f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.WOLF1_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.WOLF )
                             .setPosition( new Vector3( -259.59073f, 10.645375f, -582.8954f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueue.WOLF2_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.WOLF )
                             .setPosition( new Vector3( -269.76822f, 13.451155f, -632.18616f ) ) );

        objects.add( box( -255.68948f, 12.216464f, -631.1988f, Item.YELLOW_STAR ) );
        objects.add( box( -251.45757f, 13.189624f, -631.7736f, Item.BLUE_STAR ) );
        objects.add( chest( -249.34569f, 13.797852f, -626.9244f, Item.COIN ) );
        objects.add( chest( -253.18262f, 12.960269f, -627.9354f, Item.COIN ) );
        objects.add( chest( -254.06767f, 12.832488f, -623.66327f, Item.COIN ) );
        objects.add( box( -255.02972f, 12.845569f, -620.29126f, Item.PURPLE_BOTTLE ) );
        objects.add( hoverGreenBottle( -256.42844f, 12.830629f, -617.1979f ) );

        objects.add( weapon( -227.31902f, 15.315568f, -618.19995f, Item.FENCE_WEAPON ) );

        return objects;
    }


    public Array< LevelObject > LEVEL16 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverGreenBottle( -7.8974643f, 5.6301675f, -732.95526f ) );

        objects.add( hoverCoin( 6.180406f, 4.92046f, -755.2134f ) );
        objects.add( hoverCoin( 6.5615478f, 5.033896f, -759.8981f ) );
        objects.add( hoverCoin( 6.9435754f, 5.235846f, -764.89624f ) );
        objects.add( hoverCoin( 8.855463f, 4.854029f, -765.96893f ) );
        objects.add( hoverCoin( 12.120924f, 4.1332316f, -764.93915f ) );
        objects.add( hoverCoin( -6.454001f, 5.343664f, -740.2662f ) );
        objects.add( hoverCoin( -4.166939f, 5.064516f, -740.4975f ) );
        objects.add( hoverCoin( -1.7513978f, 4.980602f, -739.159f ) );
        objects.add( hoverCoin( -1.903142f, 5.5439205f, -736.5664f ) );
        objects.add( hoverCoin( -4.1848755f, 6.268874f, -735.02905f ) );

        objects.add( chest( 23.842335f, 5.420668f, -755.87427f, Item.GREEN_STAR ) );
        objects.add( box( 20.534079f, 4.2681427f, -757.6646f, Item.BLUE_STAR ) );
        objects.add( box( 13.007382f, 4.336457f, -759.8387f, Item.COIN ) );
        objects.add( chest( 1.7633396f, 4.5069704f, -764.7865f, Item.RED_BOTTLE ) );
        objects.add( box( -7.8266315f, 5.279884f, -760.28284f, Item.COIN ) );

        objects.add( weapon( -5.9854608f, 3.357563f, -747.3548f, Item.BROOM_WEAPON ) );

        return objects;
    }

    public Array< LevelObject > LEVEL17 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( -7.7378583f, 5.4489617f, -836.1298f) );
        objects.add( hoverCoin( -10.758249f, 5.796095f, -834.1596f) );
        objects.add( hoverCoin( -23.012491f, 5.0994725f, -836.59576f) );
        objects.add( hoverCoin( -25.855799f, 4.1877203f, -830.0857f) );
        objects.add( hoverCoin( -22.660063f, 5.445558f, -810.1364f) );
        objects.add( hoverCoin( -25.024685f, 5.4443707f, -808.82117f) );
        objects.add( hoverCoin( -24.42993f, 5.4369473f, -805.3749f) );
        objects.add( hoverCoin( -20.635303f, 5.414798f, -803.8069f) );

        objects.add( box( -5.0326953f, 3.6815329f, -802.6161f, Item.BROOM_WEAPON) );
        objects.add( box( 17.296389f, 6.279765f, -807.19037f, Item.COIN) );
        objects.add( box( 7.6474934f, 3.245613f, -837.31085f,Item.GREEN_BOTTLE) );

        objects.add( hoverRedBottle( -1.3750398f, 3.7980022f, -817.3871f) );
        objects.add( hoverPurpleBottle( -0.83791935f, 3.857041f, -812.11957f) );

        return objects;
    }


    private LevelObject weapon ( float x, float y, float z, Item itemInBox ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.WEAPON )
                .setItem( itemInBox )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject box ( float x, float y, float z, Item itemInBox ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setDynamicModelAsset( ModelAsset.CRATE )
                .setItem( itemInBox )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject box ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setDynamicModelAsset( ModelAsset.CRATE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject chest ( float x, float y, float z, Item itemInChest ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setDynamicModelAsset( ModelAsset.CHEST )
                .setItem( itemInChest )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject chest ( float x, float y, float z ) {
        return new LevelObject()
                .setDynamicModelAsset( ModelAsset.CHEST )
                .setType( OBJECT_TYPE.BOX )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject rock ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.ROCK )
                .setDynamicModelAsset( ModelAsset.ROCK )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverCoin ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setDynamicModelAsset( ModelAsset.COIN )
                .setItem( Item.COIN )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverGreenBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setDynamicModelAsset( ModelAsset.GREEN_BOTTLE )
                .setItem( Item.GREEN_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverRedBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setDynamicModelAsset( ModelAsset.RED_BOTTLE )
                .setItem( Item.RED_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }

    private LevelObject hoverBlueBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setDynamicModelAsset( ModelAsset.BLUE_BOTTLE )
                .setItem( Item.BLUE_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverPurpleBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setDynamicModelAsset( ModelAsset.PURPLE_BOTTLE )
                .setItem( Item.PURPLE_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject ladder ( Vector3 pos, float height ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.LADDER )
                .setPosition( pos )
                .setHeightOfLadder( height );
    }


    private LevelObject trigger ( Item item, float x, float y, float z, float size ) {
        return new LevelObject()
                .setSize( size )
                .setType( OBJECT_TYPE.TRIGGER )
                .setItem( item )
                .setPosition( new Vector3( x, y, z ) );
    }
}
