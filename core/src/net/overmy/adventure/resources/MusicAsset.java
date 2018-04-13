/**
 * OVERMY.NET - Make your device live! *
 * <p/>
 * Games: http://play.google.com/store/apps/developer?id=OVERMY
 *
 * @author Andrey Mikheev (cb)
 */

package net.overmy.adventure.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.MathUtils;

import net.overmy.adventure.DEBUG;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum MusicAsset {
    SEA( "sea.ogg" ),
    WINTER( "winter.ogg" ),
    FOREST( "forest.ogg" ),

    TRACK1( "track1.ogg" ),
    TRACK2( "track2.ogg" ),
    TRACK3( "track3.ogg" ),
    TRACK4( "track4.ogg" ),
    TRACK5( "track5.ogg" ),;

    private final String path;
    private        Music music = null;
    private static float timer = 0.01f;


    MusicAsset ( final String path ) {
        String DEFAULT_DIR = "music/";
        //String DEFAULT_EXT = ".mp3";
        this.path = DEFAULT_DIR + path;// + DEFAULT_EXT;
    }


/*

    public static void updateVolume( float newVolume ) {
        //float musicVolume = (float) Settings.MUSIC.getInteger() / 100.0f;
        currentTrack.setVolume( newVolume );
    }

*/


    public static void stopEnvironment () {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }
/*
        for ( int i = 0; i < MusicAsset.values().length; i++ ) {
            if ( MusicAsset.values()[ i ].music != null ) {
                MusicAsset.values()[ i ].music.stop();
            }
        }*/
        if ( MusicAsset.WINTER.music.isPlaying() ) {
            MusicAsset.WINTER.music.stop();
        }
        if ( MusicAsset.FOREST.music.isPlaying() ) {
            MusicAsset.FOREST.music.stop();
        }
        if ( MusicAsset.SEA.music.isPlaying() ) {
            MusicAsset.SEA.music.stop();
        }
    }


    public static void stopAll () {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        for ( int i = 0; i < MusicAsset.values().length; i++ ) {
            if ( MusicAsset.values()[ i ].music != null ) {
                MusicAsset.values()[ i ].music.stop();
            }
        }
    }


    public static void build ( final AssetManager manager ) {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        for ( int i = 0; i < MusicAsset.values().length; i++ ) {
            MusicAsset.values()[ i ].music = manager.get( MusicAsset.values()[ i ].path,
                                                          Music.class );
        }
    }


    public static void load ( final AssetManager manager ) {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        for ( int i = 0; i < MusicAsset.values().length; i++ ) {
            manager.load( MusicAsset.values()[ i ].path, Music.class );
        }
    }


    public static void unload ( final AssetManager manager ) {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        stopAll();
        for ( int i = 0; i < MusicAsset.values().length; i++ ) {

            if ( MusicAsset.values()[ i ].music != null ) {
                MusicAsset.values()[ i ].music.dispose();
                MusicAsset.values()[ i ].music = null;

                manager.unload( MusicAsset.values()[ i ].path );
            }
        }
    }


    public static void playRandom ( float delta ) {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        timer -= delta;
        if ( timer > 0 ) {
            return;
        }
        timer = 3.0f;

        boolean track1Playing = MusicAsset.TRACK1.music.isPlaying();
        boolean track2Playing = MusicAsset.TRACK2.music.isPlaying();
        boolean track3Playing = MusicAsset.TRACK3.music.isPlaying();
        boolean track4Playing = MusicAsset.TRACK4.music.isPlaying();
        boolean track5Playing = MusicAsset.TRACK5.music.isPlaying();

        if ( track1Playing || track2Playing || track3Playing || track4Playing || track5Playing ) {
            return;
        }

        MusicAsset.TRACK1.music.stop();
        MusicAsset.TRACK2.music.stop();
        MusicAsset.TRACK3.music.stop();
        MusicAsset.TRACK4.music.stop();
        MusicAsset.TRACK5.music.stop();

        int nextTrack = MusicAsset.TRACK1.ordinal() + MathUtils.random( 0, 4 );
        MusicAsset.values()[ nextTrack ].play( false );
    }


    public void play ( boolean loop ) {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        float musicVolume = (float) Settings.MUSIC.getInteger() / 100.0f;
        if ( musicVolume > 0 ) {
            this.music.setVolume( musicVolume );
            this.music.setLooping( loop );

            Gdx.app.debug( "play( loop=" + loop + " ) volume " + musicVolume, "" + this.music );

            this.music.play();
        } else {
            stopAll();
        }
    }


    public void setPan ( float x ) {
        this.music.setPan( x, 1 );
    }


    public void play () {
        play( false );
    }


    public void stop () {
        this.music.stop();
    }

    // HARDCODE!
    //public Music get() { return Gdx.audio.newMusic( Gdx.files.internal( this.path ) ); }


    public Music get () {
        return this.music;
    }


    public void stopLoop () {
        if ( DEBUG.ON_WINDOWS.get() ) {
            return;
        }

        if ( this.music.isPlaying() ) {
            this.music.setLooping( false );
        }
    }

}
