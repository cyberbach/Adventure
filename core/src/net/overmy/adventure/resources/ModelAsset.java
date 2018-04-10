package net.overmy.adventure.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.collision.BoundingBox;

import net.overmy.adventure.DEBUG;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public enum ModelAsset {
    Level0, Level1, Level2, Level3, Level4, Level5,
    Level6, Level7, Level8, Level9, Level10,
    Level11, Level12, Level13, Level14, Level15,
    Level16, Level17, Level18, Level19, Level20,
    Level21, Level22, Level23, Level24, Level25,
    Level26, Level27, Level28, Level29, Level30,
    Level31,

    // weapons

    BROOM_WEAPON( "weapon_broom" ),// 1
    RAKE_WEAPON( "weapon_rake" ), // 2
    KALASH_WEAPON( "weapon_kalash" ), // 3
    FENCE_WEAPON( "weapon_fence" ),// 4
    PILLOW_WEAPON( "weapon_pillow" ),// 5
    GUN_WEAPON( "weapon_gun" ),// 6
    BAT_WEAPON( "weapon_bat" ),// 7

    // items

    COIN( "item_coin" ),
    CHEST( "item_chest" ),
    GIFT( "item_gift" ),
    CRATE( "item_crate" ),
    CRATE_PART( "item_cratepart" ),
    GSTAR( "item_gstar" ),
    BSTAR( "item_bstar" ),
    YSTAR( "item_ystar" ),
    ROCK( "item_rock" ),
    ROCK_PART( "item_rockpart" ),

    BOOK( "item_book" ),
    KEY( "item_key" ),
    LOCK( "item_lock" ),
    DOOR( "item_door" ),

    GREEN_BOTTLE( "item_greenbottle" ),
    RED_BOTTLE( "item_redbottle" ),
    PURPLE_BOTTLE( "item_purplebottle" ),
    BLUE_BOTTLE( "item_bluebottle" ),

    // npc / enemy

    LITTLE_BUNNY( "npc_littlebunny" ),
    SNOWMAN( "npc_snowman" ),
    BURDOK( "npc_burdok" ),
    SHARK( "npc_shark" ),

    BIRD1( "npc_bird1" ),
    BIRD2ANGRY( "npc_bird2" ),
    BUTTERFLY( "npc_butterfly" ),
    SHEEP( "npc_sheep" ),
    CRAB( "npc_crab" ),
    STAR( "npc_star" ),
    FOX( "npc_fox" ),
    HOG( "npc_hog" ),
    BEAR( "npc_bear" ),
    WOLF( "npc_wolf" ),

    PLAYER01( "npc_squirrel" ),;

    private StringBuilder stringBuilder = new StringBuilder();

    private static AssetManager manager = null;
    private final String name;

    private ModelInstance instance       = null;
    private ModelInstance simpleInstance = null;
    private BoundingBox   boundingBox    = null;
    private int           copies         = 0;


    ModelAsset ( String s ) {
        String DEFAULT_PATH = "models/";
        String DEFAULT_EXT = ".g3db";
        name = DEFAULT_PATH + s + DEFAULT_EXT;
    }


    ModelAsset () {
        String levelName = this.name().replace( "Level", "" );
        String DEFAULT_PATH = "models/world/";
        String DEFAULT_EXT = ".g3db";
        name = DEFAULT_PATH + levelName + DEFAULT_EXT;
    }


    public static void setManager ( final AssetManager assetManager ) {
        manager = assetManager;
    }


    private void updateMaterials ( ModelInstance instance ) {
        if ( DEBUG.SHOW_MODEL_INFO.get() ) {
            Gdx.app.debug( "" + this.name, "updateMaterials" );
        }

        for ( int i = 0; i < instance.materials.size; i++ ) {
            final Material material = instance.materials.get( i );

            ColorAttribute ambient = material.get( ColorAttribute.class, ColorAttribute.Ambient );
            ColorAttribute diffuse = material.get( ColorAttribute.class, ColorAttribute.Diffuse );
            ColorAttribute specular = material.get( ColorAttribute.class, ColorAttribute.Specular );
            Attribute shine = material.get( FloatAttribute.Shininess );

            material.clear();
            if ( ambient != null ) {
                material.set( ambient );
            }
            if ( diffuse != null ) {
                material.set( diffuse );
            }
            if ( specular != null ) {
                material.set( specular );
            }
            if ( shine != null ) {
                material.set( shine );
            }
        }
    }


    public void load () {
        if ( !manager.isLoaded( name ) ) {
            if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                Gdx.app.debug( "Need to load", "" + this );
            }

            if ( DEBUG.SHOW_MODEL_INFO.get() ) {
                Gdx.app.debug( "" + this.name, "load" );
            }
            manager.load( name, Model.class );
        }
    }


    public static void unloadAll () {
        for ( ModelAsset asset : ModelAsset.values() ) {
            asset.unload();
        }
    }


    public void unload () {
        if ( manager.isLoaded( name ) ) {
            if ( DEBUG.SHOW_MODEL_INFO.get() ) {
                Gdx.app.debug( "" + this.name, "unload" );
            }

            simpleInstance = null;
            instance = null;
            manager.unload( name );
            copies = 0;
        }
    }


    public ModelInstance get () {
        if ( DEBUG.SHOW_MODEL_INFO.get() ) {
            Gdx.app.debug( "" + this.name, "get one more instance" );
        }

        if ( copies > 0 ) {
            copies++;
            return instance.copy();
        } else {
            copies++;
            return instance;
        }
    }


    private ModelInstance getInstance () {
        final Model model = manager.get( name, Model.class );

        if ( DEBUG.SHOW_MODEL_INFO.get() ) {
            stringBuilder.append( "nodes: " );
            stringBuilder.append( model.nodes.size );
            stringBuilder.append( " (" );
            for ( int i = 0; i < model.nodes.size; i++ ) {
                if ( i != 0 ) {
                    stringBuilder.append( ", " );
                }
                stringBuilder.append( model.nodes.get( i ).id );
            }
            stringBuilder.append( ") " );
            stringBuilder.append( ", " );
            stringBuilder.append( "meshParts: " );
            stringBuilder.append( model.meshParts.size );
            stringBuilder.append( " (" );
            for ( int i = 0; i < model.meshParts.size; i++ ) {
                if ( i != 0 ) {
                    stringBuilder.append( ", " );
                }
                stringBuilder.append( model.meshParts.get( i ).id );
            }
            stringBuilder.append( ") " );
            stringBuilder.append( ", " );
            stringBuilder.append( "materials: " );
            stringBuilder.append( model.materials.size );
            stringBuilder.append( " (" );
            for ( int i = 0; i < model.materials.size; i++ ) {
                if ( i != 0 ) {
                    stringBuilder.append( ", " );
                }
                stringBuilder.append( model.materials.get( i ).id );
            }
            stringBuilder.append( ") " );
            if ( model.animations.size > 0 ) {
                stringBuilder.append( ", " );
                stringBuilder.append( "animations: " );
                stringBuilder.append( model.animations.size );
                stringBuilder.append( " (" );
                for ( int i = 0; i < model.animations.size; i++ ) {
                    if ( i != 0 ) {
                        stringBuilder.append( ", " );
                    }
                    stringBuilder.append( model.animations.get( i ).id );
                }
                stringBuilder.append( ") " );
            }

            Gdx.app.debug( "MODEL INFO (" + name + ")", stringBuilder.toString() );
        }

        final Node simpleNode = model.getNode( "simple" );
        if ( simpleNode != null ) {
            final Model normalModel = new Model();
            normalModel.meshes.addAll( model.meshes );
            normalModel.materials.addAll( model.materials );
            normalModel.nodes.addAll( model.nodes );
            if ( model.meshParts.size > 0 ) {
                normalModel.meshParts.addAll( model.meshParts );
            }
            if ( model.animations.size > 0 ) {
                normalModel.animations.addAll( model.animations );
            }

            final int indexOfSimpleMesh = model.nodes.indexOf( simpleNode, true );
            normalModel.meshes.removeIndex( indexOfSimpleMesh );
            normalModel.nodes.removeIndex( indexOfSimpleMesh );

            return new ModelInstance( normalModel );
        }

        return new ModelInstance( model );
    }


    public ModelInstance getSimple () {
        if ( DEBUG.SHOW_MODEL_INFO.get() ) {
            Gdx.app.debug( "" + this.name, "getSimple" );
        }

        if ( copies > 0 ) {
            return simpleInstance.copy();
        } else {
            return simpleInstance;
        }
    }


    public void build () {
        if ( simpleInstance == null ) {
            simpleInstance = getSimpleInstance();
        }

        if ( instance == null ) {
            if ( DEBUG.SHOW_MODEL_INFO.get() ) {
                Gdx.app.debug( "" + this.name, "build" );
            }

            instance = getInstance();
            updateMaterials( instance );

            calculateBoundingBox();
        }
    }


    private void calculateBoundingBox () {
        boundingBox = new BoundingBox();

        if ( simpleInstance != null ) {
            simpleInstance.calculateBoundingBox( boundingBox );
        } else {
            instance.calculateBoundingBox( boundingBox );
        }
    }


    public BoundingBox getBoundingBox () {
        return boundingBox;
    }


    private ModelInstance getSimpleInstance () {
        final Model model = manager.get( name, Model.class );

        final Node simpleNode = model.getNode( "simple" );
        if ( simpleNode != null ) {
            final Model simpleModel = new Model();
            final int indexOfSimpleMesh = model.nodes.indexOf( simpleNode, true );
            simpleModel.meshes.add( model.meshes.get( indexOfSimpleMesh ) );
            simpleModel.nodes.add( model.nodes.get( indexOfSimpleMesh ) );

            return new ModelInstance( simpleModel );
        }

        return null;
    }
}
