package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum SoundAsset {

    GAMEOVER( "gameover.ogg" ),
    Coin( "coin.ogg" ),

    BackSound( "click3.ogg" ),
    Click( "click4.ogg" ),

    Step1( "step1.ogg" ),
    Step2( "step2.ogg" ),
    Step3( "step3.ogg" ),

    Collect1( "collect1.ogg" ),
    Collect3( "collect3.ogg" ),
    Collect4( "collect4.ogg" ),
    Collect5( "collect5.ogg" ),
    PickupStar( "collect6.ogg" ),
    Collect7( "collect7.ogg" ),

    BoxCrush( "cratesmash.ogg" ),

    Jump1( "jump.ogg" ),
    HUU( "huu.ogg" ),

    HIT( "hit.ogg" ),
    HURT1( "hurt1.ogg" ),
    HURT2( "hurt2.ogg" ),
    HURT3( "hurt3.ogg" ),
    HURT4( "hurt4.ogg" ),

    OPENBOTTLE( "woing.ogg" ),
    ENDBOTTLE( "woing2.ogg" ),
    EQUIP( "equip.ogg" ),

    //BoxDrop( "drop.mp3" ),
    //RobotDrop( "robotdrop.mp3" ),
    //RobotTalk( "talk01.mp3" ),
    //RobotConnect1( "connect01.mp3" ),
    //PickupStar( "connect02.mp3" ),
    //RobotConnect3( "connect03.mp3" ),

    //Yell1( "yell1.mp3" ),
    //Yell2( "yell2.mp3" ),
    //Yell3( "yell3.mp3" ),
    //Yell4( "yell4.mp3" ),
    //Yell5( "yell5.mp3" ),
    ;

    private final String path;
    private        Sound snd    = null;
    private        long  id     = 0;
    private static float volume = 0.0f;


    public static void setVolume ( float fvolume ) {
        volume = fvolume;
    }


    public void setThisVolume ( float newVolume ) {
        this.snd.setVolume( id, volume * newVolume );
    }


    SoundAsset ( final String path ) {
        String DEFAULT_DIR = "sound/";
        this.path = DEFAULT_DIR + path;
    }

/*
    public static void stopAll () {
        for ( int i = 0; i < SoundAsset.values().length; i++ ) {
            SoundAsset.values()[ i ].snd.stop();
        }
    }
*/


    public static void build ( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ ) {
            SoundAsset.values()[ i ].snd = manager.get( SoundAsset.values()[ i ].path,
                                                        Sound.class );
        }
    }


    public static void load ( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ ) {
            manager.load( SoundAsset.values()[ i ].path, Sound.class );
        }
    }


    public static void unload ( final AssetManager manager ) {
        for ( int i = 0; i < SoundAsset.values().length; i++ ) {

            if ( SoundAsset.values()[ i ].snd != null ) {
                SoundAsset.values()[ i ].snd.dispose();
                SoundAsset.values()[ i ].snd = null;

                manager.unload( SoundAsset.values()[ i ].path );
            }
        }
    }


    public void playLoop () {
        if ( volume >= 0.0f ) {
            id = this.snd.loop( volume, 1, 1 );
            //this.snd.setLooping( id, true );
            //this.snd.setVolume( id, soundVolume );
        }
    }


    public void play () {
        if ( volume >= 0.0f ) {
            id = this.snd.play();
            this.snd.setLooping( id, false );
            this.snd.setVolume( id, volume );
        }
    }


    public void stop () {
        if ( id != 0 ) {
            this.snd.stop();
        }
    }

    // HARDCODE!
    //public Music get() { return Gdx.audio.newMusic( Gdx.files.internal( this.path ) ); }


    public Sound get () {
        return this.snd;
    }


    public void setPitch ( float pitch ) {
        this.snd.setPitch( id, pitch );
    }
}
