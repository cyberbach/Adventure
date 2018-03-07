package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum TextureAsset {

    CD( "cd" ),
    BG_GRADIENT( "bggradient" ),
    ;

    private final String path;
    private Texture texture = null;

    private static AssetManager manager = null;


    public static void setManager ( final AssetManager assetManager ) {
        manager = assetManager;
    }


    TextureAsset ( final String path ) {
        String DEFAULT_DIR = "";
        String DEFAULT_EXT = ".png";
        this.path = DEFAULT_DIR + path + DEFAULT_EXT;
    }


    public static void build () {
        for ( int i = 0; i < TextureAsset.values().length; i++ ) {
            TextureAsset.values()[ i ].texture = manager.get( TextureAsset.values()[ i ].path,
                                                              Texture.class );
        }
    }


    public static void load () {
        for ( int i = 0; i < TextureAsset.values().length; i++ ) {
            manager.load( TextureAsset.values()[ i ].path, Texture.class );
        }
    }


    public static void unload () {
        for ( int i = 0; i < TextureAsset.values().length; i++ ) {

            if ( TextureAsset.values()[ i ].texture != null ) {
                TextureAsset.values()[ i ].texture.dispose();
                TextureAsset.values()[ i ].texture = null;

                manager.unload( TextureAsset.values()[ i ].path );
            }
        }
    }


    public Texture get () {
        return this.texture;
    }


    public Sprite getSprite () {
        return new Sprite( this.texture );
    }

}
