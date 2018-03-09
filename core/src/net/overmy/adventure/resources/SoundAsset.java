/**
 * OVERMY.NET - Make your device live! *
 * <p/>
 * Games: http://play.google.com/store/apps/developer?id=OVERMY
 *
 * @author Andrey Mikheev (cb)
 */

package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum SoundAsset {

    Coin( "coin.wav" ),

    BackSound( "click3.wav" ),
    Click( "click4.wav" ),

    BoxDrop( "drop.mp3" ),
    RobotDrop( "robotdrop.mp3" ),
    RobotTalk( "talk01.mp3" ),
    RobotConnect1( "connect01.mp3" ),
    RobotConnect2( "connect02.mp3" ),
    RobotConnect3( "connect03.mp3" ),

    Yell1( "yell1.mp3" ),
    Yell2( "yell2.mp3" ),
    Yell3( "yell3.mp3" ),
    Yell4( "yell4.mp3" ),
    Yell5( "yell5.mp3" ),;

    private final String path;
    private Sound snd = null;



    SoundAsset( final String path ) {
        String DEFAULT_DIR = "sound/";
        this.path = DEFAULT_DIR + path;
    }



    public static void stopAll() {
        for ( int i = 0; i < SoundAsset.values().length; i++ )
            SoundAsset.values()[ i ].snd.stop();
    }



    public static void build( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ )
            SoundAsset.values()[ i ].snd = manager.get( SoundAsset.values()[ i ].path,
                                                        Sound.class );
    }



    public static void load( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ )
            manager.load( SoundAsset.values()[ i ].path, Sound.class );
    }



    public static void unload( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ ) {

            if ( SoundAsset.values()[ i ].snd != null ) {
                SoundAsset.values()[ i ].snd.dispose();
                SoundAsset.values()[ i ].snd = null;

                manager.unload( SoundAsset.values()[ i ].path );
            }
        }
    }



    public void play() {
        float soundVolume = (float) Settings.SOUND.getInteger() / 100.0f;
        if ( soundVolume > 0.0f ) {
            long id = this.snd.play();
            this.snd.setLooping( id, false );
            this.snd.setVolume( id, soundVolume );
        }
        else {
            stopAll();
        }
    }



    public void stop() {
        this.snd.stop();
    }

    // HARDCODE!
    //public Music get() { return Gdx.audio.newMusic( Gdx.files.internal( this.path ) ); }



    public Sound get() {
        return this.snd;
    }

}
