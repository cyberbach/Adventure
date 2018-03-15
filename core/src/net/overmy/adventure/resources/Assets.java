package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.utils.Logger;

import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.Levels;
import net.overmy.adventure.logic.TextBlock;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public final class Assets {

    private static AssetManager manager = null;


    private Assets () {
    }


    public static void init () {
        final FileHandleResolver resolver = new InternalFileHandleResolver();
        final AssetLoader fontsGenerator = new FreeTypeFontGeneratorLoader( resolver );
        final AssetLoader fontsLoader = new FreetypeFontLoader( resolver );

        manager = new AssetManager();
        manager.setLoader( FreeTypeFontGenerator.class, fontsGenerator );
        manager.setLoader( BitmapFont.class, ".ttf", fontsLoader );
    }


    public static void setManagerLogLevel ( int LOG_LEVEL ) {
        manager.getLogger().setLevel( LOG_LEVEL );
    }


    public static void load () {
        TextAsset.init();
        TextDialogAsset.init();
        TextBlock.init();

        FontAsset.load( manager );
        MusicAsset.load( manager );
        SoundAsset.load( manager );
        IMG.load( manager );

        ModelAsset.setManager( manager );
        TextureAsset.setManager( manager );

        TextureAsset.load();

        Item.setImages();

        ModelAsset.GIFT.load();
        ModelAsset.BOX_PART.load();
        ModelAsset.CLUB_WEAPON1.load();
        ModelAsset.SWORD_WEAPON1.load();
    }


    public static void build () {
        FontAsset.build( manager );
        MusicAsset.build( manager );
        SoundAsset.build( manager );
        IMG.build( manager );
        TextureAsset.build();

        ModelAsset.GIFT.build();
        ModelAsset.BOX_PART.build();
        ModelAsset.CLUB_WEAPON1.build();
        ModelAsset.SWORD_WEAPON1.build();
    }


    public static void unload () {
        Levels.dispose();

        FontAsset.unload( manager );
        MusicAsset.unload( manager );
        SoundAsset.unload( manager );
        IMG.unload( manager );


        TextureAsset.unload();

        ModelAsset.unloadAll();

        manager.finishLoading();
        manager.dispose();

        Settings.save();
    }


    public static AssetManager getManager () {
        return manager;
    }
}
