package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

import net.overmy.adventure.logic.DynamicLevels;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.TextInteract;

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
        TextInteractAsset.init();
        TextInteract.init();

        FontAsset.load( manager );
        MusicAsset.load( manager );
        SoundAsset.load( manager );
        IMG.load( manager );

        ModelAsset.setManager( manager );
        TextureAsset.setManager( manager );

        TextureAsset.load();

        Item.init();

        ModelAsset.GIFT.load();
        ModelAsset.CRATE_PART.load();
        ModelAsset.KALASH_WEAPON.load();
        ModelAsset.RAKE_WEAPON.load();
        ModelAsset.BROOM_WEAPON.load();
        ModelAsset.FENCE_WEAPON.load();
        ModelAsset.ROCK_PART.load();
        ModelAsset.GUN_WEAPON.load();
    }


    public static void build () {
        FontAsset.build( manager );
        MusicAsset.build( manager );
        SoundAsset.build( manager );
        IMG.build( manager );
        TextureAsset.build();

        ModelAsset.GIFT.build();
        ModelAsset.CRATE_PART.build();
        ModelAsset.KALASH_WEAPON.build();
        ModelAsset.RAKE_WEAPON.build();
        ModelAsset.BROOM_WEAPON.build();
        ModelAsset.FENCE_WEAPON.build();
        ModelAsset.ROCK_PART.build();
        ModelAsset.GUN_WEAPON.build();
    }


    public static void unload () {

        FontAsset.unload( manager );
        MusicAsset.unload( manager );
        SoundAsset.unload( manager );
        IMG.unload( manager );


        TextureAsset.unload();

        ModelAsset.unloadAll();

        manager.finishLoading();
        manager.dispose();

        DynamicLevels.dispose();
        Settings.save();
    }


    public static AssetManager getManager () {
        return manager;
    }
}
