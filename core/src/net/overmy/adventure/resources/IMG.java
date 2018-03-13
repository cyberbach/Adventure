/**
 * OVERMY.NET - Make your device live! *
 * <p/>
 * Games: http://play.google.com/store/apps/developer?id=OVERMY
 *
 * @author Andrey Mikheev (cb)
 */

package net.overmy.adventure.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum IMG {
    AUTOREPAIR("autorepair"),
    COG("cog"),
    CONVERSATION("conversation"),
    FILES("files"),
    FULLFOLDER("fullfolder"),
    OPENBOOK("openbook"),
    USABLE("usable"),

    PAD( "pad" ),
    BUTTON( "button" ),
    AIM( "aim" ),
    INGAME( "ingame" ),

    JUMP_BUTTON( "jump" ),
    HIT_BUTTON( "hit" ),

    // inventory
    GSTAR( "gstaricon" ),
    BSTAR( "bstaricon" ),
    YSTAR( "ystaricon" ),
    BOTTLE( "bottle" ),//13
    COIN( "coin" ),

    // particles
    STAR_PARTICLE( "starpart" ),
    PARTICLE( "particle" ),

    PARTICLE_TRI1( "tri1" ),
    PARTICLE_TRI2( "tri2" ),
    PARTICLE_TRI3( "tri3" ),
    PARTICLE_TRI4( "tri4" ),
    PARTICLE_TRI5( "tri5" ),
    ;

    private final static String ATLAS_PATH = "gfx/pack.atlas";

    private static TextureAtlas atlas = null;

    private final String name;



    private IMG( final String text ) {
        this.name = text;
    }



    public static void load( AssetManager manager ) {
        manager.load( ATLAS_PATH, TextureAtlas.class );
    }



    public static void build( AssetManager manager ) {
        atlas = manager.get( ATLAS_PATH, TextureAtlas.class );
    }



    public static void unload( AssetManager manager ) {
        manager.unload( ATLAS_PATH );
        atlas.dispose();
    }



    public TextureAtlas.AtlasRegion getRegion() {
        return atlas.findRegion( this.name );
    }



    public Image getImageActor( final float width, final float height ) {
        final Image image = new Image( this.getRegion() );
        image.setSize( width, height );
        image.setPosition( -width / 2, -height / 2 );
        image.setOrigin( width / 2, height / 2 );
        return image;
    }



    public Sprite createSprite() {
        return atlas.createSprite( this.name );
    }



    public Drawable getDrawable() {
        return new TextureRegionDrawable( this.getRegion() );
    }
}
