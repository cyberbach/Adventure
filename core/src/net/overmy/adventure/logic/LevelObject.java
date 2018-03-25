package net.overmy.adventure.logic;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.resources.ModelAsset;

/**
 * Created by Andrey (cb) Mikheev
 * 17.03.2017
 */

public class LevelObject {

    public    ModelAsset         modelAsset     = null;
    protected Vector3            position       = null;
    private   OBJECT_TYPE        type           = null;
    private   Item               item           = null;
    private   TextInteract       textInteract   = null;
    private   Array< NPCAction > actionArray    = null;
    protected Entity             entity         = null;
    private   boolean            used           = false;
    private   float              heightOfLadder = 0.0f;
    private   float              rotation       = 0.0f;


    public LevelObject setHeightOfLadder ( float heightOfLadder ) {
        this.heightOfLadder = heightOfLadder;
        return this;
    }


    public LevelObject setModelAsset ( ModelAsset modelAsset ) {
        this.modelAsset = modelAsset;
        return this;
    }


    public LevelObject setPosition ( Vector3 position ) {
        this.position = position;
        return this;
    }


    public LevelObject setType ( OBJECT_TYPE type ) {
        this.type = type;
        return this;
    }


    public LevelObject setItem ( Item item ) {
        this.item = item;
        return this;
    }


    public LevelObject setTextInteract ( TextInteract textInteract ) {
        this.textInteract = textInteract;
        return this;
    }


    public LevelObject setActionQueue (
            Array< NPCAction > actionArray ) {
        this.actionArray = actionArray;
        return this;
    }


    public LevelObject setRotation ( float rotation ) {
        this.rotation = rotation;
        return this;
    }
/*

    LevelObject ( OBJECT_TYPE type, Vector3 position ) {
        this.type = type;
        this.position = position;
    }

    LevelObject ( OBJECT_TYPE type, ModelAsset models, Vector3 position ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
    }


    LevelObject ( OBJECT_TYPE type, ModelAsset models, Vector3 position, float heightOfLadder ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
        this.heightOfLadder = heightOfLadder;
    }


    LevelObject ( OBJECT_TYPE type, Item id, ModelAsset models, Vector3 position ) {
        this.type = type;
        this.item = id;
        this.modelAsset = models;
        this.position = position;
    }
    LevelObject ( OBJECT_TYPE type, Item id, Vector3 position ) {
        this.type = type;
        this.item = id;
        this.position = position;
    }


    LevelObject ( OBJECT_TYPE type, TextInteract textInteract, Array< NPCAction > actionArray,
                  ModelAsset models, Vector3 position ) {
        this.type = type;
        this.textInteract = textInteract;
        this.modelAsset = models;
        this.position = position;
        this.actionArray = actionArray;
    }

    LevelObject ( OBJECT_TYPE type,
                  ModelAsset models, TextInteract textInteract, Vector3 position, float rot ) {
        this.type = type;
        this.textInteract = textInteract;
        this.modelAsset = models;
        this.position = position;
        this.rotation=rot;
    }


    LevelObject ( OBJECT_TYPE type, Array< NPCAction > actionArray,
                  ModelAsset models, Vector3 position ) {
        this.type = type;
        this.modelAsset = models;
        this.position = position;
        this.actionArray = actionArray;
    }
*/


    public void useEntity () {
        used = true;
        removeEntity();
    }


    void removeEntity () {
        if ( entity != null ) {
            AshleyWorld.getPooledEngine().removeEntity( entity );
        }

        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
            Gdx.app.debug( "removeEntity", "item=" + item + " model=" + modelAsset );
        }
        entity = null;
    }


    void buildEntity () {
        // Энтити уже создана
        if ( entity != null ) {
            return;
        }

        // Энтити была уже создана и мы её использовали (подобрали или убили)
        if ( used ) {
            return;
        }

        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
            Gdx.app.debug( "Need to build OBJECT", "" + this.type );
        }

        switch ( type ) {
            case LADDER:
                entity = AshleySubs.createLadder( position, heightOfLadder );
                break;

            case TRIGGER:
                entity = AshleySubs.createTrigger( position, item );
                break;

            case PICKABLE:
                entity = AshleySubs.createPickable( position, modelAsset, item, this );
                break;

            case BOX:
                entity = AshleySubs.createCrate( position, modelAsset, item, this );
                break;

            case ROCK:
                entity = AshleySubs.createRock( position, modelAsset, this );
                break;

            case COLLECTABLE:
                entity = AshleySubs.createCollectable( position, modelAsset, item, this );
                break;

            case HOVER_COLLECTABLE:
                entity = AshleySubs.createHoverCollectable( position, modelAsset, item, this );
                break;

            case NPC:
                entity = AshleySubs.createNPC( position, modelAsset, textInteract, actionArray );
                break;

            case ENEMY:
                entity = AshleySubs.createEnemy( position, modelAsset, actionArray );
                break;

            case WEAPON:
                entity = AshleySubs.createWeapon( position, modelAsset, item, this );
                break;

            case INTERACTIVE:
                entity = AshleySubs.createInteractive( position, modelAsset, textInteract,
                                                       rotation );
                break;
        }
    }


    void buildModel () {
        if ( entity == null && !used ) {
            modelAsset.build();
        }
    }
}
