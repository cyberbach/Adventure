package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 21.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.resources.ModelAsset;

class LevelSubs {


    Array< LevelObject > level0objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        //
        /*
        objects.add( hoverPurpleBottle( -7.6205816f,2.0821836f,-8.869345f ) );
*/
        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.INTERACTIVE )
                             .setModelAsset( ModelAsset.BOOK )
                             .setTextInteract( TextInteract.Book1 )
                             .setPosition( new Vector3( -7.6205816f, 1.8f, -8.869345f ) )
                             .setRotation( 110.0f ) );

        objects.add( trigger( Item.TRIGGER1, new Vector3( -3.446573f, 1.3729875f, -7.244136f ) ) );
        objects.add( trigger( Item.TRIGGER2, new Vector3( 5.328025f, 2.2757506f, 3.47663f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.WEAPON )
                             .setModelAsset( ModelAsset.BROOM_WEAPON )
                             .setItem( Item.BROOM_WEAPON )
                             .setPosition( new Vector3( -2.566254f, 0.0907035f, -4.6540112f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 1 ) )
                             .setModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( 5.8699236f, 0.9654312f, 10.142155f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 2 ) )
                             .setModelAsset( ModelAsset.STAR )
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
        objects.add( box( 5.86802f, 1.1149557f, -0.5165689f ) );

        /*

        // OLD OLD code

       objects.add( new LevelObject( OBJECT_TYPE.LADDER,
                                     ModelAsset.LADDER,
                                     new Vector3( 14.994f, -0.995f, 2.719f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.PICKABLE,
                                      Item.GREEN_BOTTLE,
                                      ModelAsset.GREEN_BOTTLE,
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
                                      Item.GREEN_BOTTLE,
                                      ModelAsset.GREEN_BOTTLE,
                                      new Vector3( 15.195f, 3.262f, -12.414f ) ) );

        objects.add( new LevelObject( OBJECT_TYPE.NPC,
                                      TextInteract.DialogNPC1,
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


    private LevelObject trigger ( Item item, Vector3 position ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.TRIGGER )
                .setItem( item )
                .setPosition( position );
    }


    Array< LevelObject > level1objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setTextInteract( TextInteract.DialogNPC1 )
                             .setActionQueue( NPCActionQueues.get( 0 ) )
                             .setModelAsset( ModelAsset.HOG )
                             .setPosition( new Vector3( -25.33078f, 5, -66.74849f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.WEAPON )
                             .setModelAsset( ModelAsset.KALASH_WEAPON )
                             .setItem( Item.KALASH_WEAPON )
                             .setPosition( new Vector3( -29.12711f, 1.3195913f, -82.997826f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.LADDER )
                             .setHeightOfLadder( 10.0f )
                             .setPosition( new Vector3( -33.666f, 12.0f, -79.593f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 3 ) )
                             .setModelAsset( ModelAsset.STAR )
                             .setPosition( new Vector3( -30.599691f, 3, -52.38856f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 4 ) )
                             .setModelAsset( ModelAsset.STAR )
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


    Array< LevelObject > level2objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 5 ) )
                             .setModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( 26.918205f, 4.0f, -145.5957f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 6 ) )
                             .setModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -0.387003f, 5, -162.39476f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.WEAPON )
                             .setModelAsset( ModelAsset.RAKE_WEAPON )
                             .setItem( Item.RAKE_WEAPON )
                             .setPosition( new Vector3( -1.1865791f, 2.7401257f, -153.47026f ) ) );

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


    Array< LevelObject > level3objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 7 ) )
                             .setModelAsset( ModelAsset.STAR )
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


    Array< LevelObject > level4objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 15 ) )
                             .setModelAsset( ModelAsset.BIRD2ANGRY )
                             .setPosition( new Vector3( -137.9316f, -1.0180426f, -407.6164f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 16 ) )
                             .setModelAsset( ModelAsset.BIRD1 )
                             .setPosition( new Vector3( -161.27516f, 0.09638158f, -356.9968f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 10 ) )
                             .setModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -142.12982f, 1.464614f, -368.08258f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 11 ) )
                             .setModelAsset( ModelAsset.SHEEP )
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


    Array< LevelObject > level5objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 12 ) )
                             .setModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -219.61375f, 1.9190593f, -400.35522f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 13 ) )
                             .setModelAsset( ModelAsset.SHEEP )
                             .setPosition( new Vector3( -221.7196f, 4.9624543f, -426.501f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.WEAPON )
                             .setItem( Item.FENCE_WEAPON )
                             .setModelAsset( ModelAsset.FENCE_WEAPON )
                             .setPosition( new Vector3( -244.39001f, 1.686245f, -420.27023f ) ) );

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


    Array< LevelObject > level6objects () {
        Array< LevelObject > objects = new Array< LevelObject >();

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 14 ) )
                             .setModelAsset( ModelAsset.BUTTERFLY )
                             .setPosition( new Vector3( -40.59898f, 1.6375828f, -420.44955f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.ENEMY )
                             .setActionQueue( NPCActionQueues.get( 8 ) )
                             .setModelAsset( ModelAsset.CRAB )
                             .setPosition( new Vector3( -46.878883f, 2.9280591f, -410.01724f ) ) );

        objects.add( new LevelObject()
                             .setType( OBJECT_TYPE.NPC )
                             .setActionQueue( NPCActionQueues.get( 9 ) )
                             .setModelAsset( ModelAsset.FOX )
                             .setPosition( new Vector3( -63.024685f, 0.6048689f, -442.56873f ) ) );

        objects.add( chest( -49.353012f, 1.195226f, -423.57303f, Item.GREEN_STAR ) );
        objects.add( chest( -49.944202f, 1.5459726f, -419.02133f, Item.BLUE_STAR ) );
        objects.add( chest( -49.78418f, 1.7487116f, -411.50516f, Item.RED_BOTTLE ) );
        objects.add( chest( -35.611767f, 1.8290501f, -413.95877f, Item.BROOM_WEAPON ) );

        return objects;
    }


    private LevelObject box ( float x, float y, float z, Item itemInBox ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setItem( itemInBox )
                .setModelAsset( ModelAsset.CRATE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject box ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setModelAsset( ModelAsset.CRATE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject chest ( float x, float y, float z, Item itemInChest ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setItem( itemInChest )
                .setModelAsset( ModelAsset.CHEST )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject chest ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.BOX )
                .setModelAsset( ModelAsset.CHEST )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject rock ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.ROCK )
                .setModelAsset( ModelAsset.ROCK )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverCoin ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setItem( Item.COIN )
                .setModelAsset( ModelAsset.COIN )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverGreenBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setItem( Item.GREEN_BOTTLE )
                .setModelAsset( ModelAsset.GREEN_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverRedBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setItem( Item.RED_BOTTLE )
                .setModelAsset( ModelAsset.RED_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject hoverPurpleBottle ( float x, float y, float z ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.HOVER_COLLECTABLE )
                .setItem( Item.PURPLE_BOTTLE )
                .setModelAsset( ModelAsset.PURPLE_BOTTLE )
                .setPosition( new Vector3( x, y, z ) );
    }


    private LevelObject ladder ( Vector3 pos ) {
        return new LevelObject()
                .setType( OBJECT_TYPE.LADDER )
                .setModelAsset( ModelAsset.COIN )
                .setPosition( pos );
    }
}
