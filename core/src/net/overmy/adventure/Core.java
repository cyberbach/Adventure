package net.overmy.adventure;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public final class Core {

    public static final float FADE      = 0.3f;
    public static final float FADE_HALF = FADE * 0.5f;

    public static int WIDTH;
    public static int WIDTH_HALF;
    public static int HEIGHT;
    public static int HEIGHT_HALF;

    public static float SensitivitySpeedByX = 0.0f;
    public static float SensitivitySpeedByY = 0.0f;


    private Core () {
    }


    static void resize ( int width, int height ) {
        WIDTH = width;
        HEIGHT = height;
        WIDTH_HALF = WIDTH / 2;
        HEIGHT_HALF = HEIGHT / 2;
    }
}
