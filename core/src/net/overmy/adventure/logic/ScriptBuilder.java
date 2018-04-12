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

/** Билдер скриптов */
public final class ScriptBuilder {
    private ScriptBuilder () {
    }


    public static ImmutableArray< NPCAction > STAR_ON_LEVEL0 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-5.6010785f, -15.179978f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move(-4.091829f, -17.306948f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(-1.0492718f, -15.046353f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > STAR_ON_LEVEL1 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-7.297408f, -42.540188f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move(-10.403938f, -40.797947f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(-18.388197f, -45.05218f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUTTERFLY_ON_LEVEL1 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-47.33847f, -53.481728f) );
        queue.add( wait( 0.3f ) );
        queue.add( move(-45.964718f, -59.90169f) );
        queue.add( wait( 0.1f ) );
        queue.add( move(-33.058754f, -61.05838f) );
        queue.add( wait( 0.4f ) );
        queue.add( move(-24.529562f, -58.58642f) );
        queue.add( wait( 0.1f ) );
        queue.add( move(-23.378159f, -53.181225f) );
        queue.add( wait( 0.2f ) );
        queue.add( move(-40.015022f, -40.91456f) );
        queue.add( wait( 0.1f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUNNY_ON_LEVEL0 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -1.7200319f, 10.46532f ) );
        queue.add( wait( 1.0f ) );
        queue.add( move( -1.9040691f, 7.416032f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( 2.7612164f, 5.5861015f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -0.47394562f, 3.526068f ) );
        queue.add( move( -3.5705903f, 5.456116f ) );
        queue.add( wait( 1.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > HOG_ON_LEVEL1 () {
        final int ID_ATTACK = 2;
        final int ID_SOME_ANIMATION = 3;

        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 15.0f ) );
        queue.add( move( -25.33078f, -66.74849f ) );
        queue.add( say( TextAsset.TestString1, 3 ) );
        queue.add( animate( ID_ATTACK, 3 ) );
        queue.add( move( -18.664494f, -65.147026f ) );
        queue.add( say( TextAsset.TestString2, 3 ) );
        queue.add( wait( 3.0f ) );
        queue.add( say( TextAsset.TestString3, 3 ) );
        queue.add( wait( 5.0f ) );
        queue.add( animate( ID_SOME_ANIMATION, 3 ) );
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


    public static ImmutableArray< NPCAction > SHARK_ON_LEVEL3 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -69.446945f, -251.36264f ) );
        queue.add( wait( 0.6f ) );
        queue.add( hunt() );
        queue.add( move( -75.144844f, -252.5359f ) );
        queue.add( wait( 1.4f ) );
        queue.add( hunt() );
        queue.add( move( -77.29335f, -242.72508f ) );
        queue.add( hunt() );
        queue.add( move( -66.97161f, -244.6279f ) );
        queue.add( wait( 0.8f ) );
        queue.add( hunt() );
        queue.add( move( -58.487083f, -265.92316f ) );
        queue.add( wait( 2.4f ) );
        queue.add( hunt() );
        queue.add( move( -69.66185f, -243.60669f ) );
        queue.add( wait( 0.7f ) );
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


    public static ImmutableArray< NPCAction > BURDOK_ON_LEVEL5 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -221.65602f, -416.17563f ) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        queue.add( move( -219.22012f, -410.15714f ) );
        queue.add( wait( 0.5f ) );
        queue.add( move( -224.89061f, -408.55685f ) );
        queue.add( wait( 1.7f ) );
        queue.add( hunt() );
        queue.add( move( -214.65916f, -412.53247f ) );
        queue.add( wait( 0.3f ) );
        queue.add( hunt() );
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


    public static ImmutableArray< NPCAction > SHEEP1_ON_LEVEL9 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -81.33341f, -475.92508f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -77.635574f, -478.2603f ) );
        queue.add( wait( 1.0f ) );
        queue.add( move( -80.149086f, -480.21243f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -78.71041f, -471.83655f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -73.28597f, -472.10632f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > SHEEP2_ON_LEVEL9 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -80.6879f, -494.6508f ) );
        queue.add( move( -78.56837f, -497.12512f ) );
        queue.add( move( -78.31385f, -495.4608f ) );
        queue.add( move( -80.03428f, -494.19177f ) );
        queue.add( move( -80.13495f, -496.98187f ) );
        queue.add( wait( 3.0f ) );
        queue.add( move( -65.698044f, -492.69052f ) );
        queue.add( move( -64.75046f, -490.44183f ) );
        queue.add( move( -66.56616f, -490.2914f ) );
        queue.add( move( -66.63639f, -492.15094f ) );
        queue.add( move( -65.24387f, -492.4636f ) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BOSS_STONE_ON_LEVEL10 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-13.899722f, -483.95493f) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move(-17.391619f, -479.6962f) );
        queue.add( wait( 3.0f ) );
        queue.add( hunt() );
        queue.add( move(-14.257755f, -475.6039f) );
        queue.add( wait( 0.6f ) );
        queue.add( hunt() );
        queue.add( move(-14.9206915f, -479.75253f) );
        queue.add( wait( 4.0f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BUTTERFLY2_ON_LEVEL10 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -13.218724f, -490.88968f ) );
        queue.add( wait( 1.2f ) );
        queue.add( move( -17.0502f, -485.42813f ) );
        queue.add( wait( 2.0f ) );
        queue.add( move( -21.103241f, -489.97034f ) );
        queue.add( wait( 1.4f ) );
        queue.add( move( -25.296394f, -484.94818f ) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BOSS_RED_CRAB_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -84.048195f, -522.14417f ) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move( -95.131874f, -531.46936f ) );
        queue.add( wait( 2.0f ) );
        queue.add( hunt() );
        queue.add( move( -74.87535f, -534.6484f ) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > CRAB2_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -48.189743f, -527.33795f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -51.961998f, -534.35724f ) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move( -47.190533f, -539.5666f ) );
        queue.add( wait( 1.0f ) );
        queue.add( hunt() );
        queue.add( move( -59.149967f, -550.2349f ) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > CRAB3_ON_LEVEL11 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -42.565582f, -532.7986f ) );
        queue.add( wait( 1.3f ) );
        queue.add( hunt() );
        queue.add( move( -45.621998f, -538.90375f ) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        queue.add( move( -31.099411f, -549.78186f ) );
        queue.add( wait( 2.1f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BUTTERFLY1_ON_LEVEL12 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-81.55028f, -597.2928f) );
        queue.add( wait( 0.5f ) );
        queue.add( move(-89.02247f, -593.2276f) );
        queue.add( wait( 1.5f ) );
        queue.add( move(-93.18661f, -596.1083f) );
        queue.add( wait( 0.5f ) );
        queue.add( move(-84.850136f, -591.6094f) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BUTTERFLY2_ON_LEVEL12 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -100.823044f, -622.6001f ) );
        queue.add( wait( 0.5f ) );
        queue.add( move( -95.382744f, -619.458f ) );
        queue.add( wait( 1.1f ) );
        queue.add( move( -93.2454f, -625.6185f ) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BIRD_NIGEL_ON_LEVEL13 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-20.31813f, -678.26215f) );
        queue.add( wait( 1.5f ) );
        queue.add( move(-14.423321f, -684.92334f) );
        queue.add( wait( 2.5f ) );
        queue.add( move(-18.909407f, -692.0248f) );
        queue.add( wait( 3.5f ) );
        queue.add( move(-11.305454f, -686.09485f) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > RACOOR_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-239.92676f, -631.5311f) );
        queue.add( wait( 1.1f ) );
        queue.add( move(-238.55551f, -621.48303f) );
        queue.add( wait( 0.3f ) );
        queue.add( move(-228.49037f, -617.5171f) );
        queue.add( wait( 1.5f ) );
        queue.add( move(-225.46667f, -623.6073f) );
        queue.add( wait( 1.1f ) );
        queue.add( wait( 0.5f ) );
        queue.add( move(-222.05035f, -616.7315f) );
        queue.add( move(-235.6314f, -614.72266f) );
        queue.add( wait( 1.8f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUNNY1_ON_LEVEL16 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-5.0102077f, -753.8307f) );
        queue.add( wait( 1.8f ) );
        queue.add( move(1.3185447f, -756.57166f) );
        queue.add( wait( 2.8f ) );
        queue.add( move(-2.8788311f, -744.6776f) );
        queue.add( wait( 1.8f ) );
        queue.add( move(4.4421f, -749.08026f) );
        queue.add( wait( 0.8f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUNNY2_ON_LEVEL16 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(15.807984f, -754.7011f) );
        queue.add( wait( 1.3f ) );
        queue.add( move(17.893818f, -742.88885f) );
        queue.add( wait( 2.8f ) );
        queue.add( move(18.946476f, -756.02545f) );
        queue.add( wait( 0.4f ) );
        queue.add( move(19.989016f, -746.5833f) );
        queue.add( wait( 0.8f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BEAR1_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -171.49295f, -518.231f ) );
        queue.add( say( TextAsset.BEARTEXT1, 2 ) );
        queue.add( wait( 1.2f ) );
        queue.add( move( -170.6102f, -513.2062f ) );
        queue.add( wait( 1.5f ) );
        queue.add( move( -166.10829f, -514.4292f ) );
        queue.add( say( TextAsset.BEARTEXT2, 4 ) );
        queue.add( wait( 0.8f ) );
        queue.add( move( -169.84256f, -515.8019f ) );
        queue.add( wait( 1.5f ) );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BEAR2_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -224.54436f, -516.8102f ) );
        queue.add( wait( 1.1f ) );
        queue.add( hunt() );
        queue.add( move( -227.43858f, -511.2084f ) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move( -235.1254f, -511.6314f ) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        queue.add( move( -232.8137f, -502.12723f ) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BEAR3_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -210.48898f, -509.05664f ) );
        queue.add( wait( 2.5f ) );
        queue.add( hunt() );
        queue.add( move( -201.94029f, -504.94992f ) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        queue.add( move( -207.4343f, -498.41013f ) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BEAR4_ON_LEVEL8 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -167.88797f, -498.12292f ) );
        queue.add( wait( 0.8f ) );
        queue.add( hunt() );
        queue.add( move( -161.33879f, -485.688f ) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > BEAR1_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -259.59073f, -582.8954f ) );
        queue.add( wait( 0.8f ) );
        queue.add( hunt() );
        queue.add( move( -247.3654f, -581.32983f ) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        queue.add( move( -254.72473f, -587.25415f ) );
        queue.add( wait( 1.7f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > WOLF1_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( wait( 0.5f ) );
        queue.add( move( -230.05342f, -592.1338f ) );
        queue.add( say( TextAsset.BEWARE_ME_BUNNY, 3 ) );
        queue.add( wait( 1.7f ) );
        queue.add( hunt() );
        queue.add( move( -235.86606f, -592.9476f ) );
        queue.add( wait( 1.2f ) );
        queue.add( move( -237.48083f, -600.303f ) );
        queue.add( wait( 0.7f ) );
        queue.add( hunt() );
        queue.add( move( -224.87889f, -600.3192f ) );
        queue.add( move( -241.97337f, -600.2547f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > WOLF2_ON_LEVEL15 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -269.76822f, -632.18616f ) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move( -266.36893f, -622.872f ) );
        queue.add( say( TextAsset.BEWARE_ME_BUNNY, 2 ) );
        queue.add( wait( 1.5f ) );
        queue.add( hunt() );
        queue.add( move( -272.5677f, -612.9443f ) );
        queue.add( wait( 0.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }


    public static ImmutableArray< NPCAction > SNOWMAN_ON_LEVEL19 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move( -111.52003f, -844.50574f ) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        queue.add( move( -109.27993f, -837.82465f ) );
        queue.add( wait( 0.5f ) );
        queue.add( move( -115.48555f, -833.6619f ) );
        queue.add( wait( 2.2f ) );
        queue.add( hunt() );
        queue.add( move( -118.73633f, -842.1679f ) );
        queue.add( wait( 0.7f ) );
        queue.add( move( -112.3849f, -839.33093f ) );
        queue.add( wait( 0.3f ) );
        queue.add( hunt() );
        queue.add( move( -111.86092f, -846.1629f ) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        queue.add( move( -99.80032f, -847.01196f ) );
        queue.add( move( -96.21273f, -832.92755f ) );
        queue.add( wait( 0.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BEAR_BOSS_ON_LEVEL21 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(125.90772f, -870.429f) );
        queue.add( wait( 2.2f ) );
        queue.add( hunt() );
        queue.add( move(137.43683f, -867.1958f) );
        queue.add( wait( 1.2f ) );
        queue.add( hunt() );
        queue.add( move(126.87403f, -859.1964f) );
        queue.add( wait( 3.2f ) );
        queue.add( hunt() );
        queue.add( move(135.68953f, -881.2747f) );
        queue.add( wait( 2.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUNNY_ON_LEVEL20 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(70.92023f, -845.7677f) );
        queue.add( wait( 0.2f ) );
        queue.add( move(69.24515f, -850.9215f) );
        queue.add( wait( 0.4f ) );
        queue.add( move(72.19409f, -852.89307f) );
        queue.add( wait( 0.1f ) );
        queue.add( move(76.559326f, -849.68176f) );
        queue.add( wait( 0.6f ) );
        queue.add( move(70.39825f, -847.6796f) );
        queue.add( wait( 0.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > KAKSONIK_ON_LEVEL23 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(80.42447f, -676.7018f) );
        queue.add( wait( 0.5f ) );
        queue.add( move(88.8546f, -673.2525f) );
        queue.add( wait( 0.3f ) );
        queue.add( move(87.5384f, -678.16394f) );
        queue.add( wait( 0.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > ELEPHANT_TOPA_ON_LEVEL25 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(40.55069f, -463.58136f) );
        queue.add( wait( 0.2f ) );
        queue.add( move(40.554077f, -464.06888f) );
        queue.add( wait( 2.2f ) );
        queue.add( move(36.49026f, -464.09866f) );
        queue.add( wait( 3.2f ) );
        queue.add( move(43.396687f, -464.0491f) );
        queue.add( wait( 0.2f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BAMSI_BOSS_ON_LEVEL26 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(106.69007f, -466.44888f) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move(91.20345f, -465.21283f) );
        queue.add( wait( 0.2f ) );
        queue.add( hunt() );
        queue.add( move(98.61486f, -475.86343f) );
        queue.add( wait( 0.9f ) );
        queue.add( hunt() );
        queue.add( move(93.551384f, -485.62473f) );
        queue.add( wait( 2.2f ) );
        queue.add( hunt() );
        queue.add( move(99.82308f, -479.3f) );
        queue.add( wait( 0.6f ) );
        queue.add( hunt() );
        queue.add( move(105.9238f, -486.53162f) );
        queue.add( wait( 3.2f ) );
        queue.add( hunt() );
        queue.add( move(98.258415f, -474.7326f) );
        queue.add( wait( 0.5f ) );
        queue.add( hunt() );
        queue.add( move(106.11287f, -469.69705f) );
        queue.add( wait( 0.4f ) );
        queue.add( hunt() );
        queue.add( move(99.90267f, -475.58292f) );
        queue.add( wait( 2.2f ) );
        queue.add( hunt() );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUTTER1_ON_LEVEL28 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(124.14843f, -363.11023f) );
        queue.add( wait( 1.2f ) );
        queue.add( move(118.99271f, -360.3389f) );
        queue.add( wait( 2.2f ) );
        queue.add( move(116.01389f, -362.8613f) );
        queue.add( wait( 3.2f ) );
        queue.add( move(114.91176f, -354.94705f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > BUTTER2_ON_LEVEL28 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(146.89696f, -351.98505f) );
        queue.add( wait( 1.0f ) );
        queue.add( move(148.44313f, -345.75458f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(141.62358f, -341.28983f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > SHEEP1_ON_LEVEL29 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(138.26875f, -287.6845f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(131.9345f, -296.7361f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(137.89957f, -304.266f) );
        queue.add( wait( 4.0f ) );
        queue.add( move(134.51886f, -307.13388f) );
        queue.add( wait( 2.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > SHEEP2_ON_LEVEL29 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(105.49505f, -313.06177f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(106.027084f, -316.41776f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(102.505974f, -316.9396f) );
        queue.add( wait( 1.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > RACOON_BABY_ON_LEVEL30 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(124.16762f, -234.56926f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(123.12308f, -231.53256f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(120.707825f, -234.01454f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(123.06682f, -236.23929f) );
        queue.add( wait( 4.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > SHEEP1_ON_LEVEL30 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(143.18132f, -222.95808f) );
        queue.add( wait( 2.0f ) );
        queue.add( move(147.17924f, -221.25908f) );
        queue.add( wait( 4.0f ) );
        queue.add( move(144.13625f, -214.26913f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(149.83136f, -212.43866f) );
        queue.add( wait( 4.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > SHEEP2_ON_LEVEL30 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(141.78217f, -244.33516f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(138.91772f, -238.39264f) );
        queue.add( wait( 1.0f ) );
        queue.add( move(136.54291f, -245.88583f) );
        queue.add( wait( 4.0f ) );
        return new ImmutableArray< NPCAction >( queue );
    }

    public static ImmutableArray< NPCAction > MIKI_ON_LEVEL31 () {
        Array< NPCAction > queue = new Array< NPCAction >();
        queue.add( move(-171.53989f, -875.62476f) );
        queue.add( wait( 1.0f ) );
        queue.add( move(-172.55685f, -870.7101f) );
        queue.add( wait( 4.0f ) );
        queue.add( move(-176.55176f, -867.1971f) );
        queue.add( wait( 3.0f ) );
        queue.add( move(-180.68776f, -871.80096f) );
        queue.add( wait( 4.0f ) );
        queue.add( move(-172.4051f, -869.19025f) );
        queue.add( wait( 2.0f ) );
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


    private static NPCAction say ( TextAsset text, float time ) {
        return new NPCAction( ACTION_ID.SAY, text, time );
    }


    private static NPCAction animate ( int ID, float time ) {
        return new NPCAction( ACTION_ID.ANIMATE, time, ID );
    }
}
