package net.overmy.adventure.logic;

/*
        Created by Andrey Mikheev on 02.03.2018
        Contact me → http://vk.com/id17317
*/

import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.logic.NPCAction.ACTION_ID;
import net.overmy.adventure.resources.TextAsset;

public final class NPCActionQueue {
    private NPCActionQueue () {
    }


    private static final int ID_ATTACK         = 2;
    private static final int ID_SOME_ANIMATION = 3;


    public static ImmutableArray< NPCAction > HOG_ON_LEVEL1 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 15.0f ) );
        queue.add( move( -25.33078f, -66.74849f ) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.TestString1, 3 ) );
        queue.add( new NPCAction( ACTION_ID.ANIMATE, 3, ID_ATTACK ) );
        queue.add( move( -18.664494f, -65.147026f ) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.TestString2, 3 ) );
        queue.add( wait( 3.0f ) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.TestString3, 3 ) );
        queue.add( wait( 5.0f ) );
        queue.add( new NPCAction( ACTION_ID.ANIMATE, 3, ID_SOME_ANIMATION ) );
        queue.add( move( -14.296296f, -65.65968f ) );
        queue.add( move( -10.035321f, -78.6422f ) );
        queue.add( move( -20.728638f, -86.38529f ) );
        queue.add( move( -27.775835f, -88.418846f ) );
        queue.add( move( -28.209415f, -85.8856f ) );
        queue.add( wait( 5.0f ) );
        queue.add( move( -21.665394f, -84.70191f ) );
        queue.add( move( -13.180926f, -78.91112f ) );
        queue.add( move( -14.756912f, -65.820145f ) );
        queue.add( move( -26.207544f, -68.05383f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > STAR1_ON_LEVEL0 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( 11.0029545f, 11.008482f ) );
        queue.add( wait( 1.0f ) );
        queue.add( move( 5.406862f, 10.36782f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( 3.7875729f, 6.9466367f ) );
        queue.add( wait( 1.0f ) );
        queue.add( move( 4.887175f, 10.677381f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > STAR2_ON_LEVEL0 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 3.0f ) );
        queue.add( move( 8.697725f, -2.0947685f ) );
        queue.add( move( 7.6969233f, 0.8624459f ) );
        queue.add( hunt() );
        queue.add( move( 3.2691898f, 0.110698976f ) );
        queue.add( move( 5.371343f, -2.410922f ) );
        queue.add( move( 9.87872f, -0.9013393f ) );
        queue.add( hunt() );
        queue.add( move( 9.266123f, -0.8731335f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > STAR1_ON_LEVEL1 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        queue.add( move( -30.599691f, -52.38856f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -33.493076f, -55.224483f ) );
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        queue.add( move( -29.038822f, -57.544582f ) );
        queue.add( hunt() );
        queue.add( move( -33.811184f, -59.12615f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > STAR2_ON_LEVEL1 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        queue.add( move( -7.1824327f, -60.462067f ) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        queue.add( move( -5.5673203f, -53.898636f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -1.2488754f, -55.292847f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > CRAB1_ON_LEVEL2 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 1.0f ) );
        queue.add( move( 26.918205f, -145.5957f ) );
        queue.add( hunt() );
        queue.add( wait( 2.0f ) );
        queue.add( move( 21.526243f, -144.10057f ) );
        queue.add( hunt() );
        queue.add( wait( 1.0f ) );
        queue.add( move( 14.106742f, -153.48633f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > CRAB2_ON_LEVEL2 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( hunt() );
        queue.add( move( -0.387003f, -162.39476f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -7.1675067f, -162.74545f ) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > STAR_ON_LEVEL3 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -58.313896f, -179.10666f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -59.6613f, -176.12453f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -65.25142f, -177.31752f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -59.097706f, -176.71507f ) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > CRAB_ON_LEVEL6 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -50.272156f, -406.55072f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -46.51943f, -410.3056f ) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        queue.add( move( -53.51205f, -433.28705f ) );
        queue.add( move( -60.112892f, -425.14523f ) );
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        queue.add( move( -59.306446f, -416.003f ) );
        queue.add( move( -61.259388f, -414.6232f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > FOX_ON_LEVEL6 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -64.75381f, -441.43292f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -69.77547f, -443.40207f ) );
        queue.add( move( -66.5813f, -443.6809f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -79.34961f, -442.19833f ) );
        queue.add( move( -80.47613f, -443.1133f ) );
        queue.add( wait( 5.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > SHEEP1_ON_LEVEL4 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -142.12982f, -368.08258f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -148.57593f, -364.6106f ) );
        queue.add( wait( 4.0f ) );
        queue.add( move( -155.29565f, -371.30493f ) );
        queue.add( move( -151.27678f, -372.23157f ) );
        queue.add( wait( 3.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > SHEEP2_ON_LEVEL4 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -139.17807f, -393.3555f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -131.78218f, -397.1868f ) );
        queue.add( wait( 1.5f ) );
        queue.add( move( -136.02168f, -403.25275f ) );
        queue.add( wait( 2.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BUTTERFLY_ON_LEVEL5 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -219.61375f, -400.35522f ) );
        queue.add( wait( 1.2f ) );
        queue.add( move( -225.82419f, -401.64832f ) );
        queue.add( wait( 2.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > SHEEP_ON_LEVEL5 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -221.7196f, -426.501f ) );
        queue.add( wait( 3.2f ) );
        queue.add( move( -220.58641f, -421.99988f ) );
        queue.add( wait( 4.0f ) );
        queue.add( move( -215.5847f, -426.56372f ) );
        queue.add( wait( 2.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BUTTERFLY_ON_LEVEL6 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -40.59898f, -420.44955f ) );
        queue.add( wait( 1.5f ) );
        queue.add( move( -43.541374f, -413.11823f ) );
        queue.add( wait( 2.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BIRD1_LEVEL4 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -137.9316f, -407.6164f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -148.53554f, -398.90326f ) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        queue.add( move( -156.10858f, -417.41608f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -166.88496f, -422.44022f ) );
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > HOG_LEVEL4 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -161.27516f, -356.9968f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -151.27046f, -348.61383f ) );
        queue.add( wait( 4.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> SHEEP1_ON_LEVEL9 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-81.33341f, -475.92508f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(-77.635574f, -478.2603f) );
        queue.add( wait( 1.0f ) );
        queue.add( move(-80.149086f, -480.21243f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(-78.71041f, -471.83655f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(-73.28597f, -472.10632f) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> SHEEP2_ON_LEVEL9 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-80.6879f, -494.6508f) );
        queue.add( move(-78.56837f, -497.12512f) );
        queue.add( move(-78.31385f, -495.4608f) );
        queue.add( move(-80.03428f, -494.19177f) );
        queue.add( move(-80.13495f, -496.98187f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(-65.698044f, -492.69052f) );
        queue.add( move(-64.75046f, -490.44183f) );
        queue.add( move(-66.56616f, -490.2914f) );
        queue.add( move(-66.63639f, -492.15094f) );
        queue.add( move(-65.24387f, -492.4636f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BUTTERFLY1_ON_LEVEL10 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-19.114065f, -460.6453f) );
        queue.add( wait( 1.0f ) );
        queue.add( move(-20.9831f, -456.65268f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(-25.675312f, -455.47873f) );
        queue.add( wait( 1.3f ) );
        queue.add( move(-25.499683f, -463.4702f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BUTTERFLY2_ON_LEVEL10 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-13.218724f, -490.88968f) );
        queue.add( wait( 1.2f ) );
        queue.add( move(-17.0502f, -485.42813f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(-21.103241f, -489.97034f) );
        queue.add( wait( 1.4f ) );
        queue.add( move(-25.296394f, -484.94818f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> CRAB1_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-84.048195f, -522.14417f) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move(-95.131874f, -531.46936f) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        queue.add( move(-74.87535f, -534.6484f) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> CRAB2_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-48.189743f, -527.33795f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move(-51.961998f, -534.35724f) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move(-47.190533f, -539.5666f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move(-59.149967f, -550.2349f) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> CRAB3_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-42.565582f, -532.7986f) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move(-45.621998f, -538.90375f) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        queue.add( move(-31.099411f, -549.78186f) );
        queue.add( wait( 2.1f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BUTTERFLY1_ON_LEVEL12 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-66.312195f, -610.7529f) );
        queue.add( wait( 1.3f ) );
        queue.add( move(-70.295906f, -603.4875f) );
        queue.add( wait( 0.3f ) );
        queue.add( move(-65.03553f, -599.2112f) );
        queue.add( wait( 0.8f ) );
        queue.add( move(-76.46246f, -599.6772f) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BUTTERFLY2_ON_LEVEL12 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-100.823044f, -622.6001f) );
        queue.add( wait( 0.5f ) );
        queue.add( move(-95.382744f, -619.458f) );
        queue.add( wait( 1.1f ) );
        queue.add( move(-93.2454f, -625.6185f) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BEAR1_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-171.49295f, -518.231f) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.BEARTEXT1, 2 ) );
        queue.add( wait( 1.2f ) );
        queue.add( move(-170.6102f, -513.2062f) );
        queue.add( wait( 1.5f ) );
        queue.add( move(-166.10829f, -514.4292f) );
        queue.add( new NPCAction( NPCAction.ACTION_ID.SAY, TextAsset.BEARTEXT2, 4 ) );
        queue.add( wait( 0.8f ) );
        queue.add( move(-169.84256f, -515.8019f) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BEAR2_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-224.54436f, -516.8102f) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        queue.add( move(-227.43858f, -511.2084f) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move(-235.1254f, -511.6314f) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        queue.add( move(-232.8137f, -502.12723f) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BEAR3_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-210.48898f, -509.05664f) );
        queue.add( wait( 2.5f ) );
        queue.add( hunt() );
        queue.add( move(-201.94029f, -504.94992f) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        queue.add( move(-207.4343f, -498.41013f) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BEAR4_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-167.88797f, -498.12292f) );
        queue.add( wait( 0.8f ) );
        queue.add( hunt() );
        queue.add( move(-161.33879f, -485.688f) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> BEAR1_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-259.59073f, -582.8954f) );
        queue.add( wait( 0.8f ) );
        queue.add( hunt() );
        queue.add( move(-247.3654f, -581.32983f) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        queue.add( move(-254.72473f, -587.25415f) );
        queue.add( wait( 1.7f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> WOLF1_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 0.5f ) );
        queue.add( move(-230.05342f, -592.1338f) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.BEWARE_ME_BUNNY, 2 ) );
        queue.add( wait( 1.7f ) );
        queue.add( hunt() );
        queue.add( move(-235.86606f, -592.9476f) );
        queue.add( wait( 1.2f ) );
        queue.add( move(-237.48083f, -600.303f) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        queue.add( move(-224.87889f, -600.3192f) );
        queue.add( move(-241.97337f, -600.2547f) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray<NPCAction> WOLF2_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-269.76822f, -632.18616f) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move(-266.36893f, -622.872f) );
        queue.add( new NPCAction( ACTION_ID.SAY, TextAsset.BEWARE_ME_BUNNY, 2 ) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        queue.add( move(-272.5677f, -612.9443f) );
        queue.add( wait( 0.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    private static NPCAction wait ( float time ) {
        return new NPCAction( ACTION_ID.WAIT, time );
    }


    private static NPCAction hunt () {
        return new NPCAction( ACTION_ID.HUNT, 5.0f );
    }


    private static NPCAction move ( float x, float y ) {
        return new NPCAction( ACTION_ID.MOVE, new Vector2( x, y ), 10.0f );
    }


}
