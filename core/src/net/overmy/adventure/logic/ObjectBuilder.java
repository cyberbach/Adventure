package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 21.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.ModelAsset;

class ObjectBuilder {

    // Этот класс работает по принципу ENUM


    Array< LevelObject > LEVEL0 () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( weapon( -4.6829085f, 2.5688787f, 5.136475f, Item.BROOM_WEAPON ) );
        objects.add( hoverGreenBottle( 7.7638564f, 2.0202222f, 8.130696f ) );
        objects.add( hoverCoin( 7.908807f, 3.2400737f, 6.374561f ) );
        objects.add( hoverCoin( 8.051812f, 2.3276892f, 4.6176887f ) );
        objects.add( box( 9.30934f, 2.0510876f, 7.063234f, Item.COIN ) );
        objects.add( hoverRedBottle( 1.4620435f, 2.0471134f, 11.686789f ) );
        objects.add( box( 2.0894058f, 0.9661126f, 17.144102f, Item.COIN ) );
        objects.add( box( -14.651095f, 0.5416093f, -0.73911595f, Item.COIN ) );
        objects.add( box( -14.834895f, 0.546132f, -5.104841f ) );
        objects.add( trigger( Item.TRIGGER_INTRO_GUNS, -3.2423413f, 0.5587765f, -12.5487385f, 3 ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.STAR_ON_LEVEL0() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -5.6010785f, 0.6358346f, -15.179978f ) ) );

        objects.add( trigger( Item.TRIGGER_INTRO_GUNS2, -3.2168756f, 2.4004748f, 5.7865267f, 4 ) );
        objects.add( trigger( Item.TRIGGER_INTRO_BOTTLE, 5.9339743f, 2.269684f, 6.585695f, 3 ) );
        return objects;
    }


    Array< LevelObject > LEVEL1 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( trigger( Item.TRIGGER_INTRO_BOX, -15.007243f, 2.5831919f, -53.823032f, 3 ) );
        objects.add( trigger( Item.TRIGGER_INTRO_TALK, -25.42757f, 2.9511707f, -67.447815f, 2 ) );
        objects.add( trigger( Item.TRIGGER_TRY_TO_JUMP, -34.39248f, 13.887711f, -74.07386f, 2 ) );
        objects.add( trigger( Item.TRIGGER_A_LONG_WAY, -63.436752f, 0.54160935f, -67.39833f, 5 ) );

        objects.add( ladder( new Vector3( -33.666f, 12.0f, -79.593f ), 10.0f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setMyDialog( MyDialog.HogPrickle )
                             .setScript( ScriptBuilder.HOG_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.HOG )
                             .setPosition( new Vector3( -25.33078f, 5, -66.74849f ) ) );

        objects.add( weapon( -29.12711f, 1.3195913f, -82.997826f, Item.RAKE_WEAPON ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.STAR_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -7.297408f, 0.49786925f, -42.540188f ) ) );
        objects.add( box( -5.340666f, 5.637866f, -56.715485f, Item.COIN ) );
        objects.add( hoverCoin( -29.644548f, 3.4147549f, -55.15648f ) );
        objects.add( box( -39.514046f, 3.9463546f, -54.580338f, Item.RED_BOTTLE ) );
        objects.add( hoverCoin( -39.28138f, 2.3142998f, -74.20508f ) );
        objects.add( hoverGreenBottle( -35.72479f, 15.461235f, -71.00958f ) );
        objects.add( hoverCoin( -28.74289f, 22.323881f, -78.382675f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY_ON_LEVEL1() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -47.33847f, 3.982127f, -53.481728f ) ) );

        return objects;
    }


    Array< LevelObject > LEVEL2 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( trigger( Item.TRIGGER_INTRO_WEAPON_COMBINE, 2.624308f, 2.3249323f, -153.69887f,
                              3 ) );
        objects.add( trigger( Item.TRIGGER_INTRO_HIDDEN_WALL, -4.0632124f, 2.0375128f, -163.06961f,
                              4 ) );
        objects.add( weapon( -1.1865791f, 2.7401257f, -153.47026f, Item.RAKE_WEAPON ) );

        objects.add( hoverGreenBottle( -5.3636923f, 1.8259449f, -155.13283f ) );
        objects.add( hoverCoin( -4.838867f, 1.8350161f, -157.48666f ) );
        //objects.add( rock( -4.409675f,1.8589246f,-157.52556f ) );

        objects.add( hoverCoin( 23.473248f, 3.3257918f, -149.59673f ) );
        objects.add( hoverGreenBottle( 26.942774f, 3.3635728f, -151.56834f ) );
        objects.add( hoverCoin( 16.20091f, 2.1369853f, -156.37874f ) );
        objects.add( hoverCoin( -0.08271152f, 3.3794906f, -155.92131f ) );

        objects.add( box( -12.749359f, 0.83835983f, -158.29185f, Item.BLUE_STAR ) );
        objects.add( box( 21.482891f, 0.69398946f, -163.47675f ) );
        objects.add( box( 30.171566f, 0.9804662f, -155.9155f, Item.COIN ) );
        objects.add( box( 4.2649007f, 2.3494797f, -150.69984f, Item.GREEN_STAR ) );

        return objects;
    }


    Array< LevelObject > LEVEL3 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( trigger( Item.TRIGGER_SHARK_HELP, -75.267586f, 0.69686496f, -236.18509f, 7 ) );
        objects.add( trigger( Item.TRIGGER_GATE_HELP, -104.46029f, 1.6846528f, -274.8887f, 3 ) );
        objects.add( trigger( Item.TRIGGER_BLUE_BOTTLE, -147.7052f, 0.5416111f, -262.5539f, 2 ) );

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_SEA, -108.447365f, 0.54161114f, -293.61478f, 4 ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.SHARK_ON_LEVEL3() )
                             .setDynamicModelAsset( ModelAsset.SHARK )
                             .setItem( Item.KEY1 )
                             .setPosition( new Vector3( -69.446945f, 1.2875233f, -251.36264f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.STAR_ON_LEVEL3() )
                             .setDynamicModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -58.313896f, 3, -179.10666f ) ) );

        objects.add( hoverCoin( -75.930626f, 4.587798f, -189.51195f ) );
        objects.add( hoverGreenBottle( -79.52511f, 4.0374074f, -189.01859f ) );
        objects.add( hoverCoin( -78.972694f, 5.2645297f, -192.8407f ) );
        objects.add( box( -62.12069f, 1.772642f, -216.14336f, Item.COIN ) );
        objects.add( hoverCoin( -66.58269f, 1.1613581f, -250.24501f ) );

        objects.add( box( -98.25061f, 0.15273489f, -251.49251f, Item.BLUE_STAR ) );
        objects.add( box( -109.57931f, 2.135044f, -255.94427f, Item.COIN ) );
        objects.add( hoverCoin( -110.871895f, 2.261999f, -268.09924f ) );
        objects.add( hoverCoin( -105.03497f, 1.5416111f, -286.58466f ) );
        objects.add( box( -88.986496f, 0.5552391f, -286.54108f, Item.COIN ) );

        objects.add( box( -116.59903f, 2.5893686f, -263.89517f, Item.YELLOW_STAR ) );
        objects.add( box( -104.25894f, 7.7526255f, -236.18323f, Item.BLUE_STAR ) );
        objects.add( box( -71.027985f, 7.992463f, -263.79257f ) );

        objects.add( hoverBlueBottle( -146.42044f, 0.54161066f, -270.32394f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 265.0f, 198.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY1 )
                             .setPosition( new Vector3( -100.838f, 0.005f, -285.133f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 93.0f, 178.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY1 )
                             .setPosition( new Vector3( -108.735f, 0.005f, -285.133f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY1 )
                             .setRotation( 328.0f )
                             .setPosition( new Vector3( -102.785645f, 1.5347735f, -275.53137f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY1 )
                             .setRotation( 221.0f )
                             .setPosition( new Vector3( -105.03991f, 0.541611f, -293.63644f ) ) );

        return objects;
    }


    Array< LevelObject > LEVEL4 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_FOREST, -142.3424f, 0.54161084f, -329.46494f, 6 ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book1 )
                             .setRotation( 0.0f )
                             .setPosition( new Vector3( -142.84814f, 0.56055367f, -343.7017f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BIRD1_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.BIRD2ANGRY )
                             .setItem( Item.FENCE_WEAPON )
                             .setPosition( new Vector3( -137.9316f, -1.0180426f, -407.6164f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.HOG_LEVEL4() )
                             .setMyDialog( MyDialog.HogPester )
                             .setDynamicModelAsset( ModelAsset.HOG )
                             .setPosition( new Vector3( -161.27516f, 0.09638158f, -356.9968f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP1_ON_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -142.12982f, 1.464614f, -368.08258f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP2_ON_LEVEL4() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -139.17807f, 1.187504f, -393.3555f ) ) );

        objects.add( hoverGreenBottle( -134.07967f, 3.0370257f, -367.3695f ) );
        objects.add( hoverCoin( -131.90904f, 4.248974f, -364.48978f ) );
        objects.add( hoverCoin( -127.98646f, 3.9535644f, -367.3582f ) );
        objects.add( hoverCoin( -112.93195f, 3.9779391f, -388.627f ) );

        objects.add( hoverCoin( -107.47616f, 4.7119007f, -393.81418f ) );
        objects.add( hoverCoin( -133.87976f, -0.002511868f, -402.92636f ) );

        objects.add( box( -146.9402f, -0.80520976f, -409.57574f, Item.BLUE_STAR ) );
        objects.add( box( -156.81668f, 1.937732f, -388.8988f ) );
        objects.add( box( -169.97949f, 2.3963823f, -404.33224f, Item.COIN ) );
        objects.add( box( -189.49858f, 0.5438573f, -413.93027f, Item.YELLOW_STAR ) );

        return objects;
    }


    Array< LevelObject > LEVEL5 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book2 )
                             .setRotation( 160.0f )
                             .setPosition( new Vector3( -238.29837f, 2.9409232f, -383.93765f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BURDOK_ON_LEVEL5() )
                             .setDynamicModelAsset( ModelAsset.BURDOK )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3( -221.65602f, 3.282184f, -416.17563f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY_ON_LEVEL5() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -219.61375f, 1.9190593f, -400.35522f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP_ON_LEVEL5() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -221.7196f, 4.9624543f, -426.501f ) ) );

        objects.add( weapon( -244.39001f, 1.686245f, -420.27023f, Item.KALASH_WEAPON ) );

        objects.add( hoverCoin( -218.1792f, 1.2710103f, -408.69302f ) );
        objects.add( hoverCoin( -218.30159f, 2.1370168f, -404.0892f ) );
        objects.add( hoverCoin( -236.23094f, 1.7357274f, -415.68683f ) );

        objects.add( hoverCoin( -240.30139f, 2.2858207f, -382.78412f ) );

        objects.add( box( -244.96101f, 0.96003973f, -381.426f, Item.COIN ) );
        objects.add( box( -251.01166f, 1.698267f, -429.71417f, Item.BLUE_STAR ) );
        objects.add( box( -239.39738f, 2.5849354f, -433.67297f, Item.COIN ) );
        objects.add( box( -215.69734f, 4.1981606f, -432.03983f ) );

        return objects;
    }


    Array< LevelObject > LEVEL6 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( trigger( Item.TRIGGER_ALICE, -67.582634f, 0.55653006f, -431.0696f, 3 ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book3 )
                             .setRotation( 326.0f )
                             .setPosition( new Vector3( -62.17136f, 0.57809526f, -448.0939f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY_ON_LEVEL6() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -40.59898f, 1.6375828f, -420.44955f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.CRAB_ON_LEVEL6() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -46.878883f, 2.9280591f, -410.01724f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.FOX_ON_LEVEL6() )
                             .setMyDialog( MyDialog.FoxAlice )
                             .setDynamicModelAsset( ModelAsset.FOX )
                             .setPosition( new Vector3( -63.024685f, 0.6048689f, -442.56873f ) ) );

        objects.add( hoverGreenBottle( -49.353012f, 1.195226f, -423.57303f ) );
        objects.add( chest( -49.78418f, 1.7487116f, -411.50516f, Item.RED_BOTTLE ) );
        objects.add( chest( -35.611767f, 1.8290501f, -413.95877f ) );

        return objects;
    }


    Array< LevelObject > LEVEL7 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add(
                trigger( Item.TRIGGER_SECRETLOCATION1, -103.11569f, 2.023168f, -440.53986f, 2 ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 0.0f, 100.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3( -112.542f, 2.127f, -441.846f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 173.0f, 100.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY2 )
                             .setPosition( new Vector3( -113.021f, 2.086f, -434.052f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY2 )
                             .setRotation( 102.0f )
                             .setPosition( new Vector3( -107.369316f, 2.3024127f, -440.83386f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY2 )
                             .setRotation( 236.0f )
                             .setPosition( new Vector3( -119.332405f, 2.6150074f, -435.88257f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL8 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book4 )
                             .setRotation( 130.0f )
                             .setPosition( new Vector3( -216.14719f, 7.427118f, -460.93408f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR1_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setItem( Item.GUN_WEAPON )
                             .setPosition( new Vector3( -171.49295f, 6.6022253f, -518.231f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR2_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -224.54436f, 2.4063842f, -516.8102f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR3_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -210.48898f, 1.7850372f, -509.05664f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR4_ON_LEVEL8() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -167.88797f, 5.4292164f, -498.12292f ) ) );

        objects.add( hoverGreenBottle( -210.48468f, 7.024612f, -471.9825f ) );
        objects.add( hoverCoin( -216.46123f, 2.8955421f, -490.04166f ) );
        objects.add( hoverCoin( -218.1026f, 3.4937649f, -494.65573f ) );
        objects.add( hoverCoin( -219.36427f, 2.7714198f, -498.1379f ) );
        objects.add( hoverCoin( -229.38776f, 3.8697674f, -512.4073f ) );
        objects.add( hoverCoin( -235.3857f, 2.6575413f, -519.5951f ) );
        objects.add( hoverCoin( -239.52682f, 3.691349f, -524.5798f ) );
        objects.add( hoverCoin( -243.74919f, 2.6288273f, -533.02795f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL9 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book7 )
                             .setRotation( 66.0f )
                             .setPosition( new Vector3( -104.541176f, 3.6797745f, -476.30933f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP1_ON_LEVEL9() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -81.33341f, 3.6375828f, -475.92508f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP2_ON_LEVEL9() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -80.6879f, 2.2810526f, -494.6508f ) ) );

        objects.add( hoverCoin( -58.12171f, 2.095977f, -476.83038f ) );
        objects.add( hoverCoin( -59.177914f, 3.3366253f, -474.5389f ) );
        objects.add( hoverCoin( -63.63271f, 4.1093438f, -473.07233f ) );
        objects.add( hoverCoin( -60.6767f, 5.441463f, -495.30865f ) );
        objects.add( hoverCoin( -63.5629f, 4.4407034f, -496.05893f ) );
        objects.add( hoverCoin( -62.72697f, 5.149046f, -502.2121f ) );
        objects.add( hoverPurpleBottle( -81.8414f, 2.281053f, -494.192f ) );

        objects.add( hoverGreenBottle( -93.72113f, 2.8023152f, -482.6676f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL10 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 360.0f, 360.0f - 71.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY4 )
                             .setPosition( new Vector3( -3.875f, 3.202f, -484.588f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 360.0f - 177.0f, 360.0f - 88.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY4 )
                             .setPosition( new Vector3( -3.837f, 3.202f, -476.819f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY4 )
                             .setRotation( 257.0f )
                             .setPosition( new Vector3( -10.499138f, 3.9870257f, -475.7233f ) ) );

        objects.add( hoverCoin( -48.00395f, 3.2169616f, -482.1736f ) );
        objects.add( hoverCoin( -43.452667f, 2.0220072f, -481.96835f ) );
        objects.add( hoverCoin( -39.90795f, 3.1651149f, -482.22363f ) );
        objects.add( hoverCoin( -27.60128f, 2.9553905f, -480.87576f ) );
        objects.add( hoverCoin( -24.873093f, 3.1316793f, -480.59894f ) );

        objects.add( chest( -5.6118073f, 3.5440261f, -488.37814f, Item.PILLOW_WEAPON ) );
        objects.add( chest( -6.689987f, 3.9579542f, -474.2815f, Item.RED_BOTTLE ) );
        objects.add( chest( -12.008289f, 6.912627f, -457.6871f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BOSS_STONE_ON_LEVEL10() )
                             .setDynamicModelAsset( ModelAsset.ROCKBOSS )
                             .setItem( Item.KEY4 )
                             .setPosition( new Vector3( -13.899722f, 3.4850523f, -483.95493f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY2_ON_LEVEL10() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -13.218724f, 3.2738621f, -490.88968f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL11 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book18 )
                             .setRotation( 267.0f )
                             .setPosition( new Vector3( -18.540747f, 2.300292f, -529.1308f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book19 )
                             .setRotation( 331.0f )
                             .setPosition( new Vector3( -16.038496f, 0.9700879f, -558.2357f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 270.0f, 360.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3( -100.095f, 2.622f, -554.844f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 90.0f, 0.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3( -107.958f, 2.622f, -554.844f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY3 )
                             .setRotation( 34.0f )
                             .setPosition( new Vector3( -109.41304f, 0.8357556f, -542.67914f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BOSS_RED_CRAB_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -84.048195f, 2.627729f, -522.14417f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.CRAB2_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setItem( Item.BAT_WEAPON )
                             .setPosition( new Vector3( -48.189743f, 1.3030697f, -527.33795f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.CRAB3_ON_LEVEL11() )
                             .setDynamicModelAsset( ModelAsset.CRAB )
                             .setItem( Item.KEY3 )
                             .setPosition( new Vector3( -42.565582f, 1.7068304f, -532.7986f ) ) );

        objects.add( hoverCoin( -16.361292f, 1.8263655f, -561.09094f ) );
        objects.add( hoverCoin( -12.581354f, 2.8918121f, -559.5787f ) );
        objects.add( hoverCoin( -11.679665f, 2.8914082f, -548.3028f ) );
        objects.add( hoverCoin( -14.917933f, 2.235294f, -538.73193f ) );
        objects.add( hoverCoin( -55.476734f, 1.2184845f, -526.9232f ) );
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
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY3 )
                             .setRotation( 181.0f )
                             .setPosition( new Vector3( -100.08671f, 3.245918f, -565.0366f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book20 )
                             .setRotation( 342.0f )
                             .setPosition( new Vector3( -88.89619f, 4.218597f, -648.4376f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY1_ON_LEVEL12() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -81.55028f, 3.8594851f, -597.2928f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTERFLY2_ON_LEVEL12() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -100.823044f, 4.4190073f, -622.6001f ) ) );


        objects.add( hoverCoin( -114.81785f, 5.7118063f, -614.2721f ) );
        objects.add( hoverCoin( -113.83685f, 6.114312f, -626.1583f ) );
        objects.add( hoverCoin( -108.039696f, 6.897209f, -636.67316f ) );
        objects.add( hoverCoin( -100.61613f, 5.7539616f, -641.0951f ) );
        objects.add( hoverCoin( -90.344696f, 3.6528409f, -640.7886f ) );
        objects.add( hoverCoin( -83.120316f, 4.3251157f, -634.3404f ) );

        objects.add( box( -62.397404f, 5.7943006f, -631.7061f, Item.GREEN_STAR ) );
        objects.add( box( -69.153275f, 5.886171f, -635.40906f, Item.COIN ) );
        objects.add( box( -39.48968f, 8.332032f, -604.6501f ) );
        objects.add( box( -35.885094f, 8.539717f, -601.6625f, Item.BLUE_STAR ) );
        objects.add( box( -40.352875f, 8.430564f, -602.41583f, Item.GREEN_BOTTLE ) );

        return objects;
    }


    public Array< LevelObject > LEVEL13 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_FOREST, -2.384388f, 2.9306993f, -687.5016f, 8 ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book21 )
                             .setRotation( 29.0f )
                             .setPosition( new Vector3( -29.889652f, 2.1643414f, -656.9323f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book22 )
                             .setRotation( 276.0f )
                             .setPosition( new Vector3( 22.841076f, 2.8081324f, -677.21844f ) ) );

        objects.add( hoverCoin( -27.482477f, 2.2798924f, -651.31683f ) );
        objects.add( hoverCoin( -22.793148f, 2.4052672f, -649.64197f ) );
        objects.add( hoverCoin( -13.693137f, 2.9688635f, -634.6157f ) );

        objects.add( hoverGreenBottle( 3.1004431f, 2.7050533f, -672.6742f ) );
        objects.add( hoverCoin( 3.9622355f, 2.6634638f, -676.0032f ) );
        objects.add( hoverCoin( 7.4769382f, 2.546321f, -680.27f ) );

        objects.add( hoverRedBottle( -7.3736234f, 3.823609f, -645.5372f ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BIRD_NIGEL_ON_LEVEL13() )
                             .setDynamicModelAsset( ModelAsset.BIRD1 )
                             .setMyDialog( MyDialog.NigelBird )
                             .setPosition( new Vector3( -20.31813f, 1.7718098f, -678.26215f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL14 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverCoin( 8.325413f, -12.7240715f, -599.3439f ) );
        objects.add( hoverGreenBottle( 11.756399f, -13.028046f, -597.12427f ) );
        objects.add( hoverCoin( 10.839822f, -12.793727f, -592.21375f ) );
        objects.add( box( 21.306444f, -13.593897f, -585.63354f, Item.BAT_WEAPON ) );
        objects.add( hoverCoin( 18.307556f, -11.784177f, -576.92114f ) );
        objects.add( hoverCoin( 27.744362f, -10.38092f, -571.53265f ) );
        objects.add( box( 24.299982f, -9.233858f, -560.9618f, Item.YELLOW_STAR ) );
        objects.add( hoverCoin( 19.769403f, -2.9720454f, -519.43097f ) );
        objects.add( box( 21.610739f, -2.3029711f, -513.0358f, Item.GREEN_STAR ) );
        objects.add( hoverPurpleBottle( 15.532761f, -1.4892286f, -513.135f ) );
        objects.add( hoverCoin( 7.1455574f, 1.6216613f, -508.3141f ) );
        objects.add( hoverCoin( -1.5353625f, 2.973329f, -509.11398f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL15 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book5 )
                             .setRotation( 303.0f )
                             .setPosition( new Vector3( -218.9553f, 14.2520685f, -605.8526f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book6 )
                             .setRotation( 104.0f )
                             .setPosition( new Vector3( -273.6948f, 13.17102f, -604.2974f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR1_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setPosition( new Vector3( -259.59073f, 10.645375f, -582.8954f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.WOLF1_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.WOLF )
                             .setPosition( new Vector3( -259.59073f, 10.645375f, -582.8954f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.WOLF2_ON_LEVEL15() )
                             .setDynamicModelAsset( ModelAsset.WOLF )
                             .setPosition( new Vector3( -269.76822f, 13.451155f, -632.18616f ) ) );

        objects.add( chest( -254.06767f, 12.832488f, -623.66327f ) );
        objects.add( box( -255.02972f, 12.845569f, -620.29126f, Item.PURPLE_BOTTLE ) );
        objects.add( hoverGreenBottle( -256.42844f, 12.830629f, -617.1979f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.RACOOR_ON_LEVEL15() )
                             .setMyDialog( MyDialog.CheinieRacoon )
                             .setDynamicModelAsset( ModelAsset.RACOON )
                             .setPosition( new Vector3( -239.92676f, 15.249353f, -631.5311f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL16 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book23 )
                             .setRotation( 263.0f )
                             .setPosition( new Vector3( 32.24161f, 5.9829903f, -744.49854f ) ) );

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_WINTER, 11.770343f, 3.6465282f, -698.8538f, 10 ) );

        objects.add( hoverGreenBottle( -7.8974643f, 5.6301675f, -732.95526f ) );

        objects.add( hoverCoin( 6.180406f, 4.92046f, -755.2134f ) );
        objects.add( hoverCoin( 6.5615478f, 6.033896f, -759.8981f ) );
        objects.add( hoverCoin( 6.9435754f, 5.235846f, -764.89624f ) );
        objects.add( hoverCoin( 8.855463f, 5.854029f, -765.96893f ) );
        objects.add( hoverCoin( 12.120924f, 4.1332316f, -764.93915f ) );
        objects.add( hoverCoin( -6.454001f, 6.343664f, -740.2662f ) );

        objects.add( chest( 23.842335f, 5.420668f, -755.87427f, Item.GREEN_STAR ) );
        objects.add( box( 20.534079f, 4.2681427f, -757.6646f, Item.BLUE_STAR ) );
        objects.add( box( 13.007382f, 4.336457f, -759.8387f, Item.COIN ) );
        objects.add( chest( 1.7633396f, 4.5069704f, -764.7865f, Item.RED_BOTTLE ) );
        objects.add( box( -7.8266315f, 5.279884f, -760.28284f, Item.COIN ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUNNY1_ON_LEVEL16() )
                             .setDynamicModelAsset( ModelAsset.LITTLE_BUNNY )
                             .setPosition( new Vector3( -5.0102077f, 4.598358f, -753.8307f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUNNY2_ON_LEVEL16() )
                             .setDynamicModelAsset( ModelAsset.LITTLE_BUNNY )
                             .setPosition( new Vector3( 15.807984f, 3.0455422f, -754.7011f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL17 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book30 )
                             .setPositionR( -27.309698f, 5.5962043f, -836.9834f, 60.0f ) );

        objects.add( hoverCoin( -7.7378583f, 5.4489617f, -836.1298f ) );
        objects.add( hoverCoin( -10.758249f, 5.796095f, -834.1596f ) );
        objects.add( hoverCoin( -23.012491f, 6.0994725f, -836.59576f ) );
        objects.add( hoverCoin( -25.855799f, 4.1877203f, -830.0857f ) );
        objects.add( hoverCoin( -22.660063f, 5.445558f, -810.1364f ) );
        objects.add( hoverCoin( -25.024685f, 6.4443707f, -808.82117f ) );
        objects.add( hoverCoin( -24.42993f, 5.4369473f, -805.3749f ) );
        objects.add( hoverCoin( -20.635303f, 6.414798f, -803.8069f ) );

        objects.add( box( -5.0326953f, 3.6815329f, -802.6161f ) );
        objects.add( box( 17.296389f, 6.279765f, -807.19037f, Item.COIN ) );
        objects.add( box( 7.6474934f, 3.245613f, -837.31085f, Item.GREEN_BOTTLE ) );

        objects.add( hoverRedBottle( -1.3750398f, 3.7980022f, -817.3871f ) );
        objects.add( hoverPurpleBottle( -0.83791935f, 3.857041f, -812.11957f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL18 () {
        Array< LevelObject > objects = new Array< LevelObject >();
        return objects;
    }


    public Array< LevelObject > LEVEL19 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 2.0f, 104.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( -125.976f, 0.827f, -846.7f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 174.0f, 68.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( -126.168f, 0.827f, -838.903f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY6 )
                             .setRotation( 84.0f )
                             .setPosition( new Vector3( -120.39172f, 1.9265f, -837.22784f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY6 )
                             .setRotation( 267.0f )
                             .setPosition( new Vector3( -133.99472f, 2.0027666f, -850.478f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.SNOWMAN_ON_LEVEL19() )
                             .setDynamicModelAsset( ModelAsset.SNOWMAN )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( -111.52003f, 2.680404f, -844.50574f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL20 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( hoverBlueBottle( 45.492798f, 6.524384f, -839.609f ) );
        objects.add( hoverGreenBottle( 42.138107f, 6.1654263f, -861.3935f ) );
        objects.add( box( 35.686115f, 6.0288854f, -866.81726f, Item.COIN ) );
        objects.add( hoverRedBottle( 57.030735f, 5.4931827f, -882.1655f ) );
        objects.add( box( 70.81902f, 3.9406092f, -874.9075f, Item.COIN ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUNNY_ON_LEVEL20() )
                             .setDynamicModelAsset( ModelAsset.LITTLE_BUNNY )
                             .setPosition( new Vector3( 70.92023f, 6.7268715f, -845.7677f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL21 () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( hoverCoin( 156.76332f, 8.490572f, -857.2877f ) );
        objects.add( hoverCoin( 154.05219f, 4.2644234f, -838.41f ) );
        objects.add( hoverCoin( 134.03911f, 5.552184f, -823.2897f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BEAR_BOSS_ON_LEVEL21() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setItem( Item.KEY5 )
                             .setColorTint( GameColor.WHITE )
                             .setPosition( new Vector3( 125.90772f, 5.6211596f, -870.429f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL22 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book24 )
                             .setRotation( 318.0f )
                             .setPosition( new Vector3( 58.60276f, 4.6676145f, -776.42194f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book25 )
                             .setRotation( 97.0f )
                             .setPosition( new Vector3( 123.64364f, 3.8215775f, -793.63666f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 96.0f, 170.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY5 )
                             .setPosition( new Vector3( 75.701f, 3.583f, -738.804f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 260.0f, 180.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY5 )
                             .setPosition( new Vector3( 83.427f, 3.583f, -738.77f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY5 )
                             .setRotation( 179.0f )
                             .setPosition( new Vector3( 81.432076f, 4.096556f, -747.964f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY5 )
                             .setRotation( 7.0f )
                             .setPosition( new Vector3( 77.33728f, 4.0414004f, -730.25726f ) ) );

        objects.add( box( 87.43035f, 3.886915f, -792.7565f ) );
        objects.add( box( 82.15717f, 3.8504152f, -794.7379f ) );
        objects.add( box( 76.073166f, 3.90613f, -790.49023f ) );

        objects.add( box( 126.537735f, 3.5056064f, -764.1802f, Item.COIN ) );
        objects.add( box( 134.49216f, 2.460532f, -778.761f ) );
        objects.add( box( 137.36403f, 2.9549937f, -784.97534f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL23 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book26 )
                             .setRotation( 327.0f )
                             .setPosition( new Vector3( 125.99288f, 3.772008f, -716.2907f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book27 )
                             .setRotation( 45.0f )
                             .setPosition( new Vector3( 8.650201f, 3.6307302f, -649.01654f ) ) );

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_WINTER, 57.33409f, 4.9017806f, -607.8461f, 10 ) );

        objects.add( hoverCoin( 119.385124f, 5.2080026f, -703.41846f ) );
        objects.add( hoverGreenBottle( 125.96447f, 5.1128645f, -703.307f ) );
        objects.add( hoverCoin( 136.06882f, 5.8890643f, -714.3209f ) );
        objects.add( hoverCoin( 139.26462f, 6.011526f, -711.488f ) );
        objects.add( hoverCoin( 138.49075f, 4.9282749f, -684.64966f ) );
        objects.add( box( 134.19417f, 3.8336446f, -675.05945f, Item.RED_BOTTLE ) );
        objects.add( hoverCoin( 84.924675f, 4.6871655f, -669.8853f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setColorTint( GameColor.BLUE )
                             .setScript( ScriptBuilder.KAKSONIK_ON_LEVEL23() )
                             .setDynamicModelAsset( ModelAsset.HOG )
                             .setMyDialog( MyDialog.Kaksonik )
                             .setPosition( new Vector3( 80.42447f, 4.103434f, -676.7018f ) ) );
        objects.add( chest( 34.233124f, 4.425891f, -683.7455f ) );
        objects.add( box( 30.061287f, 5.2189856f, -657.3103f ) );
        objects.add( box( 32.657066f, 5.289451f, -652.7026f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL24 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add(
                trigger( Item.TRIGGER_MUSIC_TO_FOREST, 67.42714f, 6.327668f, -578.48334f, 10 ) );

        objects.add( box( 64.614624f, 6.352461f, -579.0819f, Item.RED_BOTTLE ) );
        objects.add( box( 65.64196f, 6.6177845f, -571.94354f, Item.COIN ) );
        objects.add( hoverPurpleBottle( 78.57974f, 7.144694f, -559.2202f ) );
        objects.add( box( 76.23968f, 7.3509884f, -555.60706f, Item.COIN ) );
        objects.add( box( 60.988968f, 8.327591f, -534.76227f, Item.COIN ) );
        objects.add( box( 62.988968f, 8.327591f, -534.76227f, Item.KEY4 ) );
        objects.add( hoverRedBottle( 48.669895f, 8.318932f, -538.196f ) );
        objects.add( box( 43.34707f, 8.466038f, -579.97675f, Item.GUN_WEAPON ) );
        objects.add( hoverBlueBottle( 43.151905f, 9.481845f, -584.6953f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL25 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book28 )
                             .setRotation( 183.0f )
                             .setPosition( new Vector3( 50.235424f, 14.07548f, -500.00418f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book29 )
                             .setRotation( 168.0f )
                             .setPosition( new Vector3( 5.9082966f, 15.008845f, -500.5114f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book8 )
                             .setRotation( 0.0f )
                             .setPosition( new Vector3( 24.11309f, 3.6817803f, -501.70892f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book9 )
                             .setRotation( 309.0f )
                             .setPosition( new Vector3( 54.985355f, 3.6817815f, -488.08624f ) ) );

        objects.add( hoverRedBottle( 19.500439f, 3.6817815f, -493.19937f ) );
        objects.add( hoverGreenBottle( 40.1507f, 3.6817815f, -489.07715f ) );
        objects.add( hoverCoin( 44.46308f, 3.6794279f, -475.19965f ) );
        objects.add( hoverCoin( 43.98868f, 4.6808317f, -469.98956f ) );
        objects.add( hoverCoin( 45.126163f, 3.6815305f, -465.59164f ) );

        objects.add( hoverCoin( 20.961477f, 8.8018475f, -462.9154f ) );
        objects.add( hoverPurpleBottle( 22.374445f, 7.2441154f, -460.8769f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.ELEPHANT_TOPA_ON_LEVEL25() )
                             .setMyDialog( MyDialog.Topa )
                             .setDynamicModelAsset( ModelAsset.ELEPHANT )
                             .setColorTint( GameColor.PURPLE )
                             .setPosition( new Vector3( 40.55069f, 3.681771f, -463.58136f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY4 )
                             .setRotation( 98.0f )
                             .setPosition( new Vector3( 0.46133935f, 3.6817818f, -485.6289f ) ) );

        objects.add( hoverGreenBottle( 24.077932f, 16.83891f, -499.51627f ) );
        objects.add( hoverBlueBottle( 16.463919f, 16.461495f, -495.5802f ) );
        objects.add( hoverCoin( 8.41675f, 16.335941f, -494.3725f ) );
        objects.add( hoverCoin( 6.5798264f, 16.012314f, -494.01224f ) );
        objects.add( hoverCoin( 3.5310376f, 16.335941f, -493.43625f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL26 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book10 )
                             .setRotation( 157.0f )
                             .setPosition( new Vector3( 37.180817f, 3.6817734f, -419.48877f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book11 )
                             .setRotation( 35.0f )
                             .setPosition( new Vector3( 76.62763f, 3.6817024f, -496.05392f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book12 )
                             .setRotation( 272.0f )
                             .setPosition( new Vector3( 118.292404f, 3.6817815f, -496.50342f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 100.0f, 189.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( 115.899f, 3.2f, -423.713f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR )
                             .setDoorAngles( 271.0f, 160.0f )
                             .setDynamicModelAsset( ModelAsset.DOOR )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( 123.632f, 3.2f, -424.493f ) ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY6 )
                             .setRotation( 222.0f )
                             .setPosition( new Vector3( 121.02051f, 3.6817818f, -429.78204f ) ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.DOOR_SWITCH )
                             .setDynamicModelAsset( ModelAsset.LOCK )
                             .setItem( Item.KEY6 )
                             .setRotation( 10.0f )
                             .setPosition( new Vector3( 117.88512f, 3.6817815f, -416.97433f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setScript( ScriptBuilder.BAMSI_BOSS_ON_LEVEL26() )
                             .setDynamicModelAsset( ModelAsset.BEAR )
                             .setColorTint( GameColor.SQUIREL )
                             .setItem( Item.KEY6 )
                             .setPosition( new Vector3( 106.69007f, 3.6817815f, -466.44888f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL27 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book13 )
                             .setRotation( 173.0f )
                             .setPosition( new Vector3( 104.036064f, 3.603501f, -396.69916f ) ) );
        objects.add( chest( 118.239105f, 3.6768372f, -381.03702f ) );

        objects.add( hoverGreenBottle( 120.674675f, 4.7841527f, -400.37845f ) );
        objects.add( chest( 138.64107f, 3.9085371f, -408.1089f ) );

        objects.add( hoverCoin( 133.36534f, 3.6799679f, -401.76685f ) );
        objects.add( hoverCoin( 131.26073f, 3.5736165f, -396.87714f ) );
        objects.add( hoverCoin( 134.99786f, 4.9320524f, -391.84518f ) );
        objects.add( hoverCoin( 139.51044f, 4.084862f, -387.53348f ) );
        objects.add( box( 136.68161f, 3.4317925f, -379.14432f, Item.RED_BOTTLE ) );
        return objects;
    }


    public Array< LevelObject > LEVEL28 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book14 )
                             .setRotation( 163.0f )
                             .setPosition( new Vector3( 140.96918f, 3.6781952f, -338.83157f ) ) );

        objects.add( weapon( 124.6337f, 3.8980358f, -356.72656f, Item.FENCE_WEAPON ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTER1_ON_LEVEL28() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( 124.14843f, 2.6166801f, -363.11023f ) ) );
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.BUTTER2_ON_LEVEL28() )
                             .setDynamicModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( 146.89696f, 4.263083f, -351.98505f ) ) );

        objects.add( box( 149.15324f, 5.5427837f, -342.08868f ) );
        objects.add( box( 153.32574f, 4.019588f, -351.6611f, Item.COIN ) );
        objects.add( box( 151.01051f, 4.3754964f, -360.60553f ) );
        objects.add( box( 111.76163f, 5.085724f, -356.4495f, Item.GREEN_BOTTLE ) );
        objects.add( box( 110.84757f, 5.340686f, -350.90497f, Item.COIN ) );
        objects.add( box( 112.12677f, 4.4811945f, -348.49518f, Item.COIN ) );

        objects.add( hoverGreenBottle( 119.17969f, 3.8504348f, -357.0277f ) );
        return objects;
    }


    public Array< LevelObject > LEVEL29 () {
        Array< LevelObject > objects = new Array< LevelObject >();
        objects.add( box( 119.17969f, 3.8504348f, -357.0277f, Item.COIN ) );
        objects.add( chest( 123.77172f, 3.6716413f, -317.04858f, Item.COIN ) );
        objects.add( hoverCoin( 122.35327f, 4.5027664f, -313.3654f ) );
        objects.add( hoverCoin( 135.85274f, 3.3933597f, -310.70547f ) );
        objects.add( box( 138.87085f, 3.4291122f, -307.43936f, Item.COIN ) );
        objects.add( box( 141.56155f, 3.7035723f, -304.6718f ) );
        objects.add( box( 142.93164f, 4.335754f, -294.5687f ) );
        objects.add( hoverCoin( 141.50421f, 4.2291846f, -291.30292f ) );
        objects.add( box( 118.3027f, 3.6428094f, -300.60953f, Item.COIN ) );
        objects.add( chest( 118.37793f, 3.585391f, -303.6922f, Item.GREEN_BOTTLE ) );
        objects.add( hoverCoin( 106.292625f, 5.0615335f, -309.0212f ) );
        objects.add( hoverCoin( 103.701675f, 3.776405f, -304.35788f ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP1_ON_LEVEL29() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( 138.26875f, 3.6580613f, -287.6845f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP2_ON_LEVEL29() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( 105.49505f, 3.6580613f, -313.06177f ) ) );

        return objects;
    }


    public Array< LevelObject > LEVEL30 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book15 )
                             .setRotation( 90.0f )
                             .setPosition( new Vector3( 102.91206f, 4.0369787f, -258.38925f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book16 )
                             .setRotation( 5.0f )
                             .setPosition( new Vector3( 149.60074f, 3.7898595f, -248.03104f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setDynamicModelAsset( ModelAsset.BOOK )
                             .setMyDialog( MyDialog.Book17 )
                             .setRotation( 55.0f )
                             .setPosition( new Vector3( 124.604576f, 5.074566f, -229.64171f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.RACOON_BABY_ON_LEVEL30() )
                             .setMyDialog( MyDialog.RacoonBaby )
                             .setDynamicModelAsset( ModelAsset.RACOON )
                             .setPosition( new Vector3( 124.16762f, 5.360819f, -234.56926f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP1_ON_LEVEL30() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( 143.18132f, 4.3688307f, -222.95808f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.SHEEP2_ON_LEVEL30() )
                             .setDynamicModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( 141.78217f, 4.032937f, -244.33516f ) ) );
        objects.add( hoverGreenBottle( 133.16759f, 4.333866f, -253.51202f ) );
        objects.add( hoverGreenBottle( 111.76997f, 5.588354f, -248.95076f ) );
        objects.add( box( 104.13993f, 4.1218762f, -229.21765f, Item.BLUE_STAR ) );
        objects.add( box( 139.24007f, 3.4452322f, -208.44476f, Item.COIN ) );
        objects.add( hoverCoin( 142.43042f, 4.515439f, -206.49643f ) );

        return objects;
    }


    public Array< LevelObject > LEVEL31 () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setScript( ScriptBuilder.MIKI_ON_LEVEL31() )
                             .setDynamicModelAsset( ModelAsset.SQUIRREL )
                             .setMyDialog( MyDialog.Miki )
                             .setColorTint( GameColor.GREEN )
                             .setPosition( new Vector3( -171.53989f, 3.8552082f, -875.62476f ) ) );

        return objects;
    }

    // helpers


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
