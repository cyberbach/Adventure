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
    public    Item               item           = null;
    private   TextInteract       textInteract   = null;
    private   Array< NPCAction > actionArray    = null;
    protected Entity             entity         = null;
    public    boolean            used           = false;
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
        if ( item.getModelAsset() != null ) {
            this.modelAsset = item.getModelAsset();
        }
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
                entity = AshleySubs.createPickable( position, item, this );
                break;

            case BOX:
                entity = AshleySubs.createCrate( position, modelAsset, item, this );
                break;

            case ROCK:
                entity = AshleySubs.createRock( position, modelAsset, this );
                break;

            case COLLECTABLE:
                entity = AshleySubs.createCollectable( position, item, this );
                break;

            case HOVER_COLLECTABLE:
                entity = AshleySubs.createHoverCollectable( position, item, this );
                break;

            case NPC:
                entity = AshleySubs.createNPC( position, modelAsset, textInteract, actionArray );
                break;

            case ENEMY:
                entity = AshleySubs.createEnemy( position, modelAsset, actionArray, this );
                break;

            case WEAPON:
                entity = AshleySubs.createWeapon( position, item, this );
                break;

            case INTERACTIVE:
                entity = AshleySubs.createInteractive( position, modelAsset, textInteract,
                                                       rotation );
                break;
        }
    }

/*

    void buildModel () {
        if ( item != null ) {
            modelAsset = item.getModelAsset();
        }

        if ( modelAsset != null ) {
            if ( !isWeapon( modelAsset ) ) {
                if ( entity == null && !used ) {
                    modelAsset.build();
                }
            }
        }
    }
*/


}
