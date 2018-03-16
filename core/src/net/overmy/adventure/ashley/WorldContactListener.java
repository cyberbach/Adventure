package net.overmy.adventure.ashley;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.ContactListener;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.ashley.components.COMP_TYPE;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;
import net.overmy.adventure.ashley.components.PositionComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.RemoveByLevelComponent;
import net.overmy.adventure.logic.DynamicLevels;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.resources.SoundAsset;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class WorldContactListener extends ContactListener {

    private ImmutableArray< Entity > entities = null;

    private StringBuilder stringBuilder = null;
    private Vector3       tempPosition1 = new Vector3();
    private Vector3       tempPosition2 = new Vector3();


    public WorldContactListener () {
        super();
        stringBuilder = new StringBuilder();
    }


    @Override
    public void onContactProcessed ( int userValue1, boolean m1, int userValue2, boolean m2 ) {
        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( userValue1 );
            stringBuilder.append( m1 ? " (match) " : " (not match)" );
            stringBuilder.append( " -> " );
            stringBuilder.append( userValue2 );
            stringBuilder.append( m2 ? " (match) " : " (not match)" );
            Gdx.app.debug( "onContactProcessed", stringBuilder.toString() );
        }

        // Начинаем поиск тех двух Entity, у которых userValue физических тела
        // совпадают с теми, что пришли в onContactProcessed
        Entity entity1 = null;
        Entity entity2 = null;

        for ( Entity entity : entities ) {
            PhysicalComponent comp = MyMapper.PHYSICAL.get( entity );

            if ( comp.body.getUserValue() == userValue1 ) {
                entity1 = entity;
            }
            if ( comp.body.getUserValue() == userValue2 ) {
                entity2 = entity;
            }
        }

        // Одну из Entity не нашли, вероятно, что сейчас удаляется физическое тело
        if ( entity1 == null || entity2 == null ) {
            return;
        }

        // У Entity пропал физический компонент, пока искали совпадения?
        if ( !MyMapper.PHYSICAL.has( entity1 ) || !MyMapper.PHYSICAL.has( entity2 ) ) {
            return;
        }

        startContactEntities( entity1, entity2 );
    }


    @Override
    public void onContactEnded ( int userValue1, boolean m1, int userValue2, boolean m2 ) {
        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( userValue1 );
            stringBuilder.append( m1 ? " (match) " : " (not match)" );
            stringBuilder.append( " -> " );
            stringBuilder.append( userValue2 );
            stringBuilder.append( m2 ? " (match) " : " (not match)" );
            Gdx.app.debug( "onContactEnded", stringBuilder.toString() );
        }

        // Опять поиск тех двух Entity, у которых userValue физических тела
        // совпадают с теми, что пришли в onContactEnded
        Entity entity1 = null;
        Entity entity2 = null;

        for ( Entity entity : entities ) {
            PhysicalComponent comp = MyMapper.PHYSICAL.get( entity );

            if ( comp.body.getUserValue() == userValue1 ) {
                entity1 = entity;
            }
            if ( comp.body.getUserValue() == userValue2 ) {
                entity2 = entity;
            }
        }

        if ( entity1 == null || entity2 == null ) {
            return;
        }

        if ( !MyMapper.PHYSICAL.has( entity1 ) || !MyMapper.PHYSICAL.has( entity2 ) ) {
            return;
        }

        endContactEntities( entity1, entity2 );
    }


    private void startContactEntities ( Entity entity01, Entity entity02 ) {
        COMP_TYPE type1 = MyMapper.TYPE.get( entity01 ).type;
        COMP_TYPE type2 = MyMapper.TYPE.get( entity02 ).type;

        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( type1 );
            stringBuilder.append( " -> " );
            stringBuilder.append( type2 );
            Gdx.app.debug( "startContact", stringBuilder.toString() );
        }

        boolean contact1Player = type1.equals( COMP_TYPE.MYPLAYER );
        boolean contact2MyWeapon = type2.equals( COMP_TYPE.WEAPON );
        boolean contact2Ground = type2.equals( COMP_TYPE.GROUND );
        boolean contact2Ladder = type2.equals( COMP_TYPE.LADDER );
        boolean contact1DestroyableBox = type1.equals( COMP_TYPE.DESTROYABLE_BOX );
        boolean contact2DestroyableBox = type2.equals( COMP_TYPE.DESTROYABLE_BOX );
        boolean contact1Ground = type1.equals( COMP_TYPE.GROUND );
        boolean contact1Ladder = type1.equals( COMP_TYPE.LADDER );
        boolean contact2Collectable = type2.equals( COMP_TYPE.COLLECTABLE );

        if ( contact1Player && contact2Ground ||
             contact1Player && contact2DestroyableBox ) {
            RemoveByLevelComponent zoneComponent = MyMapper.REMOVE_BY_ZONE.get( entity02 );

            int lastID = DynamicLevels.getCurrent();
            int newID = zoneComponent.id;
            DynamicLevels.setCurrent( newID );
            if ( !MyMapper.GROUNDED.get( entity01 ).grounded && lastID != newID ) {
                DynamicLevels.reload();
            }
            MyMapper.GROUNDED.get( entity01 ).grounded = true;
        }

        if ( contact1Player && contact2Ladder ) {
            MyPlayer.onLadder = true;
        }

        boolean outOfCamera = MyMapper.OUT_OF_CAMERA.has( entity02 );
        if ( !outOfCamera ) {
            if ( contact1Player && contact2Collectable ) {
                Item item = MyMapper.COLLECTABLE.get( entity02 ).item;
                MyPlayer.addToBag( item );

                // Устанавливаем в levelObject флаг, чтобы предмет
                // не создался снова, при перезагрузке уровня
                if ( MyMapper.LEVEL_OBJECT.has( entity02 ) ) {
                    MyMapper.LEVEL_OBJECT.get( entity02 ).levelObject.useEntity();
                }

                if ( MyMapper.PHYSICAL.has( entity02 ) ) {
                    MyMapper.PHYSICAL.get( entity02 ).body.getWorldTransform()
                                                          .getTranslation( tempPosition1 );
                    for ( int i = 0; i < 5; i++ ) {
                        float bubbleTime = MathUtils.random( 0.25f, 0.65f );

                        Entity entity = AshleyWorld.getPooledEngine().createEntity();
                        entity.add( DecalSubs.BubbleCoinEffect( bubbleTime ) );
                        entity.add( new PositionComponent( tempPosition1 ) );
                        entity.add( new RemoveByTimeComponent( bubbleTime ) );
                        AshleyWorld.getPooledEngine().addEntity( entity );
                    }
                }

                switch ( item ) {
                    case COIN:
                        SoundAsset.Coin.play();
                        break;
                    case RED_BOTTLE:
                        SoundAsset.Collect5.play();
                        break;
                    case GREEN_STAR:
                        SoundAsset.PickupStar.play();
                        break;
                    case BLUE_STAR:
                        SoundAsset.PickupStar.play();
                        break;
                    case YELLOW_STAR:
                        SoundAsset.PickupStar.play();
                        break;
                }

                entity02.add( new OutOfCameraComponent() );
                entity02.add( new RemoveByTimeComponent( 0 ) );
            }
        }


        if ( contact2MyWeapon && !contact1Player && MyPlayer.isAttacking ) {
            if ( !contact1Ladder && !contact1Ground ) {
                btRigidBody body1 = MyMapper.PHYSICAL.get( entity01 ).body;
                body1.getWorldTransform().getTranslation( tempPosition1 );

                for ( int i = 0; i < 5; i++ ) {
                    float bubbleTime = MathUtils.random( 0.25f, 0.65f );
                        /*AshleyWorld.getPooledEngine().addEntity(
                                EntitySubs.LightBubblesEffect( bubblePosition, bubbleTime * 6 ) );*/

                    Entity entity = AshleyWorld.getPooledEngine().createEntity();
                    entity.add( DecalSubs.BubbleEffect( bubbleTime ) );
                    entity.add( new PositionComponent( tempPosition1 ) );
                    entity.add( new RemoveByTimeComponent( bubbleTime ) );
                    AshleyWorld.getPooledEngine().addEntity( entity );

                    SoundAsset.HIT.play();

                    Matrix4 weaponTransform = MyMapper.PHYSICAL.get(
                            entity02 ).body.getWorldTransform();
                    weaponTransform.getTranslation( tempPosition1 );

                    body1.getWorldTransform().getTranslation( tempPosition2 );

                    tempPosition2.sub( tempPosition1 ).nor().scl( 50 );
                    body1.applyCentralImpulse( tempPosition2 );

                    if ( MyMapper.LIFE.has( entity01 ) ) {
                        if ( contact1DestroyableBox ) {
                            MyMapper.LIFE.get( entity01 ).life -= 60;
                        }
                    }
                }
            }
        }
    }


    private void endContactEntities ( Entity entity01, Entity entity02 ) {
        COMP_TYPE type1 = MyMapper.TYPE.get( entity01 ).type;
        COMP_TYPE type2 = MyMapper.TYPE.get( entity02 ).type;

        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( type1 );
            stringBuilder.append( " -> " );
            stringBuilder.append( type2 );
            Gdx.app.debug( "endContact", stringBuilder.toString() );
        }

        boolean contact1Player = type1.equals( COMP_TYPE.MYPLAYER );
        boolean contact2Ground = type2.equals( COMP_TYPE.GROUND );
        if ( contact1Player && contact2Ground ) {
            MyMapper.GROUNDED.get( entity01 ).grounded = false;
            DynamicLevels.reload();
            DynamicLevels.reload();
            //return;
        }

        boolean contact2Ladder = type2.equals( COMP_TYPE.LADDER );
        if ( contact1Player && contact2Ladder ) {
            MyPlayer.onLadder = false;
        }
    }


    public void setEntities ( ImmutableArray< Entity > entities ) {
        this.entities = entities;
    }


    @Override
    public void dispose () {
        super.dispose();

        entities = null;
        stringBuilder = null;
    }
}