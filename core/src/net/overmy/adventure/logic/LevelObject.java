package net.overmy.adventure.logic;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.ModelAsset;

/**
 * Created by Andrey (cb) Mikheev
 * 17.03.2017
 */

public class LevelObject {

    public    ModelAsset                  dynamicModelAsset = null;
    protected Vector3                     position          = null;
    private   OBJECT_TYPE                 type              = null;
    public    Item                        item              = null;
    private   MyDialog                    myDialog          = null;
    private   ImmutableArray< NPCAction > script            = null; // очередь действий - это скрипт
    protected Entity                      entity            = null;
    public    boolean                     used              = false;
    private   float                       heightOfLadder    = 0.0f;
    private   float                       rotation          = 0.0f;
    private   float                       size              = 1.0f;
    private   GameColor                   tint              = null;

    private Vector2 doorAngles = null;


    public LevelObject setHeightOfLadder ( float heightOfLadder ) {
        this.heightOfLadder = heightOfLadder;
        return this;
    }


    public LevelObject setDynamicModelAsset ( ModelAsset dynamicModelAsset ) {
        this.dynamicModelAsset = dynamicModelAsset;
        return this;
    }


    public LevelObject setPosition ( Vector3 position ) {
        this.position = position;
        return this;
    }

    public LevelObject setPositionR ( float x, float y, float z, float rot ) {
        this.position = new Vector3( x,y,z );
        setRotation( rot );
        return this;
    }


    public LevelObject setType ( OBJECT_TYPE type ) {
        this.type = type;
        return this;
    }


    public LevelObject setItem ( Item item ) {
        this.item = item;/*
        if ( item.getModelAsset() != null ) {
            this.dynamicModelAsset = item.getModelAsset();
        }*/
        return this;
    }


    public LevelObject setMyDialog ( MyDialog myDialog ) {
        this.myDialog = myDialog;
        return this;
    }


    public LevelObject setScript ( ImmutableArray< NPCAction > actionsQueue ) {
        this.script = actionsQueue;
        return this;
    }


    public LevelObject setRotation ( float rotation ) {
        this.rotation = rotation;
        return this;
    }


    public LevelObject setSize ( float size ) {
        this.size = size;
        return this;
    }


    public void useEntity () {
        used = true;
        removeEntity();
    }


    void removeEntity () {
        if ( entity != null ) {
            AshleyWorld.getEngine().removeEntity( entity );
        }

        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
            Gdx.app.debug( "removeEntity", "item=" + item + " model=" + dynamicModelAsset );
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
            case DOOR:
                entity = AshleySubs.createDoor( position, item, doorAngles );
                break;

            case DOOR_SWITCH:
                entity = AshleySubs.createDoorSwitch( position, item, rotation );
                break;

            case LADDER:
                entity = AshleySubs.createLadder( position, heightOfLadder );
                break;

            case TRIGGER:
                entity = AshleySubs.createTrigger( position, item, size );
                break;

            case PICKABLE:
                entity = AshleySubs.createPickable( position, item, dynamicModelAsset, this );
                break;

            case BOX:
                entity = AshleySubs.createCrate( position, dynamicModelAsset, item, this );
                break;

            case ROCK:
                entity = AshleySubs.createRock( position, dynamicModelAsset, this );
                break;

            case COLLECTABLE:
                entity = AshleySubs.createCollectable( position, item, dynamicModelAsset, this );
                break;

            case HOVER_COLLECTABLE:
                entity = AshleySubs.createHoverCollectable( position, item,
                                                            dynamicModelAsset, this );
                break;

            case NPC:
                entity = AshleySubs.createNPC( position, dynamicModelAsset, myDialog,
                                               script );
                break;

            case ENEMY:
                entity = AshleySubs.createEnemy( position, dynamicModelAsset, script, item, this );
                break;

            case WEAPON:
                entity = AshleySubs.createWeapon( position, item, this );
                break;

            case INTERACTIVE:
                entity = AshleySubs.createInteractive( position, dynamicModelAsset,
                                                       myDialog, rotation );
                break;
        }

        if(tint!=null){
            ModelInstance instance = entity.getComponent( ModelComponent.class ).modelInstance;
            AshleySubs.changeMaterialColor(instance, tint);
        }
    }


    public LevelObject setDoorAngles ( float fromAngle, float toAngle ) {
        doorAngles=new Vector2(  );
        doorAngles.set( fromAngle,toAngle );
        return this;
    }


    public LevelObject setColorTint ( GameColor colorTint ) {
        this.tint = colorTint;
        return this;
    }

/*

    void buildModel () {
        if ( item != null ) {
            dynamicModelAsset = item.getModelAsset();
        }

        if ( dynamicModelAsset != null ) {
            if ( !isWeapon( dynamicModelAsset ) ) {
                if ( entity == null && !used ) {
                    dynamicModelAsset.build();
                }
            }
        }
    }
*/
}
