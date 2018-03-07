package net.overmy.adventure.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import net.overmy.adventure.resources.GameColor;



/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public final class GFXHelper {

    private GFXHelper () {
    }


    public static Sprite createSpriteRGB888 ( float width, float height ) {
        Pixmap pixmap = new Pixmap( (int) width, (int) height, Pixmap.Format.RGB888 );
        pixmap.setColor( GameColor.LOADING.get() );
        pixmap.fill();

        Texture texture = new Texture( pixmap );
        pixmap.dispose();

        return new Sprite( texture );
    }


    public static Sprite createSpriteRGB888 ( int width, int height ) {
        Pixmap pixmap = new Pixmap( width, height, Pixmap.Format.RGB888 );
        pixmap.setColor( GameColor.LOADING.get() );
        pixmap.fill();

        Texture texture = new Texture( pixmap );
        pixmap.dispose();

        return new Sprite( texture );
    }


    public static Texture createTexture ( int width, int height ) {
        Pixmap pixmap = new Pixmap( width, height, Pixmap.Format.RGB888 );
        pixmap.setColor( GameColor.LOADING.get() );
        pixmap.fill();

        Texture texture = new Texture( pixmap );
        pixmap.dispose();

        return texture;
    }


    public static Sprite createSpriteRGB888 ( int width, int height, Color color ) {
        Pixmap pixmap = new Pixmap( width, height, Pixmap.Format.RGB888 );
        pixmap.setColor( color );
        pixmap.fill();

        Texture texture = new Texture( pixmap );
        pixmap.dispose();

        return new Sprite( texture );
    }
}
