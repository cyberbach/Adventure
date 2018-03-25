package net.overmy.adventure.ashley;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.ContactListener;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.ashley.components.LevelIDComponent;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.SkipActionComponent;
import net.overmy.adventure.ashley.components.TYPE_OF_ENTITY;
import net.overmy.adventure.logic.CollectableProcessor;
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

        if ( !m1 || !m2 ) {
            if ( DEBUG.CONTACTS.get() ) {
                Gdx.app.debug( "onContactProcessed", "drop" );
            }
            return;
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

        if ( !m1 || !m2 ) {
            if ( DEBUG.CONTACTS.get() ) {
                Gdx.app.debug( "onContactEnded", "drop" );
            }
            return;
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
        TYPE_OF_ENTITY type1 = MyMapper.TYPE.get( entity01 ).type;
        TYPE_OF_ENTITY type2 = MyMapper.TYPE.get( entity02 ).type;

        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( type1 );
            stringBuilder.append( " -> " );
            stringBuilder.append( type2 );
            Gdx.app.debug( "startContact", stringBuilder.toString() );
        }

        boolean contact1Player = type1.equals( TYPE_OF_ENTITY.MYPLAYER );
        boolean contact2Player = type2.equals( TYPE_OF_ENTITY.MYPLAYER );
        boolean contact1Ground = type1.equals( TYPE_OF_ENTITY.GROUND );
        boolean contact2Ground = type2.equals( TYPE_OF_ENTITY.GROUND );
        boolean contact1DestroyableBox = type1.equals( TYPE_OF_ENTITY.DESTROYABLE_BOX );
        boolean contact2DestroyableBox = type2.equals( TYPE_OF_ENTITY.DESTROYABLE_BOX );

        if ( contact1Player && contact2Ground ) {
            LevelIDComponent levelComponent = MyMapper.REMOVE_BY_ZONE.get( entity02 );

            int lastID = DynamicLevels.getCurrent();
            int newID = levelComponent.id;
            DynamicLevels.setCurrent( newID );
            if ( !MyMapper.GROUNDED.get( entity01 ).grounded && lastID != newID ) {
                DynamicLevels.reload();
            }
            MyMapper.GROUNDED.get( entity01 ).grounded = true;
            return;
        }

        if ( contact2Player && contact1Ground ) {
            LevelIDComponent levelComponent = MyMapper.REMOVE_BY_ZONE.get( entity01 );

            int lastID = DynamicLevels.getCurrent();
            int newID = levelComponent.id;
            DynamicLevels.setCurrent( newID );
            if ( !MyMapper.GROUNDED.get( entity02 ).grounded && lastID != newID ) {
                DynamicLevels.reload();
            }
            MyMapper.GROUNDED.get( entity02 ).grounded = true;
            return;
        }

        boolean contact2Ladder = type2.equals( TYPE_OF_ENTITY.LADDER );

        if ( contact1Player && contact2Ladder ) {
            MyPlayer.onLadder = true;
            return;
        }

        boolean contact2MyWeapon = type2.equals( TYPE_OF_ENTITY.WEAPON );
        boolean contact1MyWeapon = type1.equals( TYPE_OF_ENTITY.WEAPON );
        boolean contact2NPC = type2.equals( TYPE_OF_ENTITY.NPC );
        boolean contact1NPC = type1.equals( TYPE_OF_ENTITY.NPC );
        boolean contact1DestroyableRock = type1.equals( TYPE_OF_ENTITY.DESTROYABLE_ROCK );
        boolean contact2DestroyableRock = type2.equals( TYPE_OF_ENTITY.DESTROYABLE_ROCK );
        boolean contact1Ladder = type1.equals( TYPE_OF_ENTITY.LADDER );
        boolean contact1Collectable = type1.equals( TYPE_OF_ENTITY.COLLECTABLE );
        boolean contact2Collectable = type2.equals( TYPE_OF_ENTITY.COLLECTABLE );

        boolean outOfCamera = MyMapper.OUT_OF_CAMERA.has( entity02 );
        if ( !outOfCamera ) {
            if ( MyMapper.PHYSICAL.has( entity02 ) ) {
                MyMapper.PHYSICAL.get( entity02 ).body.getWorldTransform()
                                                      .getTranslation( tempPosition1 );
            }

            if ( contact1Player && contact2Collectable ) {
                entity02.add( new OutOfCameraComponent() );

                Item item = MyMapper.COLLECTABLE.get( entity02 ).item;
                CollectableProcessor.process( item, tempPosition1 );

                // Устанавливаем в levelObject флаг, чтобы предмет
                // не создался снова, при перезагрузке уровня
                if ( MyMapper.LEVEL_OBJECT.has( entity02 ) ) {
                    MyMapper.LEVEL_OBJECT.get( entity02 ).levelObject.useEntity();
                } else {
                    entity02.add( new RemoveByTimeComponent( 0 ) );
                }
            }
        }

        if ( ( contact1NPC && contact2Player ) || ( contact2NPC && contact1Player ) ) {
            // мы получаем урон от Enemy
            if ( MyMapper.NPC.has( entity01 ) ) {
                NPCComponent component = MyMapper.NPC.get( entity01 );
                if ( component.hunting ) {
                    component.time = 0.0f; // drop to next action
                    btRigidBody body2 = MyMapper.PHYSICAL.get( entity02 ).body;
                    body2.getWorldTransform().getTranslation( tempPosition2 );
                    AshleySubs.create5StarsFX( tempPosition2 );
                    SoundAsset.HIT.play();

                    MyPlayer.hurt = true;

                    if ( MyMapper.LIFE.has( entity02 ) ) {
                        MyMapper.LIFE.get( entity02 ).decLife( component.damage );
                        if ( MathUtils.randomBoolean() ) {
                            SoundAsset.HURT1.play();
                        } else {
                            SoundAsset.HURT2.play();
                        }
                    }
                    component.hunting = false; // drop HUNT action
                }
            }
            if ( MyMapper.NPC.has( entity02 ) ) {
                NPCComponent component = MyMapper.NPC.get( entity02 );
                if ( component.hunting ) {
                    component.time = 0.0f; // drop to next action
                    btRigidBody body1 = MyMapper.PHYSICAL.get( entity01 ).body;
                    body1.getWorldTransform().getTranslation( tempPosition1 );
                    AshleySubs.create5StarsFX( tempPosition1 );
                    SoundAsset.HIT.play();

                    MyPlayer.hurt = true;

                    component.hunting = false; // drop HUNT action
                    if ( MyMapper.LIFE.has( entity01 ) ) {
                        MyMapper.LIFE.get( entity01 ).decLife( component.damage );
                        if ( MathUtils.randomBoolean() ) {
                            SoundAsset.HURT1.play();
                        } else {
                            SoundAsset.HURT2.play();
                        }
                    }
                }
            }
            return;
        }

        if ( MyPlayer.isAttacking ) {
            btRigidBody body1 = MyMapper.PHYSICAL.get( entity01 ).body;
            btRigidBody body2 = MyMapper.PHYSICAL.get( entity02 ).body;

            body1.getWorldTransform().getTranslation( tempPosition1 );
            body2.getWorldTransform().getTranslation( tempPosition2 );

            if ( contact2MyWeapon && !contact1Player ) {
                MyPlayer.isAttacking = false;

                AshleySubs.create5StarsFX( tempPosition1 );

                SoundAsset.HIT.play();

                tempPosition1.sub( tempPosition2 ).nor().scl( 50 );
                body1.applyCentralImpulse( tempPosition1 );

                if ( MyMapper.LIFE.has( entity01 ) ) {
                    if ( contact1DestroyableBox || contact1DestroyableRock || contact1NPC ) {
                        MyMapper.LIFE.get( entity01 ).decLife( MyPlayer.damage );

                        if ( contact1NPC ) {
                            NPCComponent component = MyMapper.NPC.get( entity01 );
                            if ( !component.die ) {
                                entity01.add( new SkipActionComponent() );
                                component.hunting = false;
                                component.hurt = true;

                                if ( MathUtils.randomBoolean() ) {
                                    SoundAsset.HURT3.play();
                                } else {
                                    SoundAsset.HURT4.play();
                                }
                            }
                        }
                    }
                }
                return;
            }

            if ( contact1MyWeapon && !contact2Player ) {
                MyPlayer.isAttacking = false;

                AshleySubs.create5StarsFX( tempPosition2 );

                SoundAsset.HIT.play();

                tempPosition2.sub( tempPosition1 ).nor().scl( 50 );
                body2.applyCentralImpulse( tempPosition2 );

                if ( MyMapper.LIFE.has( entity02 ) ) {
                    if ( contact2DestroyableBox || contact2DestroyableRock || contact2NPC ) {
                        MyMapper.LIFE.get( entity02 ).decLife( MyPlayer.damage );

                        if ( contact2NPC ) {
                            NPCComponent component = MyMapper.NPC.get( entity02 );
                            if ( !component.die ) {
                                entity02.add( new SkipActionComponent() );
                                component.hunting = false;
                                component.hurt = true;

                                if ( MathUtils.randomBoolean() ) {
                                    SoundAsset.HURT3.play();
                                } else {
                                    SoundAsset.HURT4.play();
                                }
                            }
                        }
                    }
                    //return;
                }
            }
        }
    }


    private void endContactEntities ( Entity entity01, Entity entity02 ) {
        TYPE_OF_ENTITY type1 = MyMapper.TYPE.get( entity01 ).type;
        TYPE_OF_ENTITY type2 = MyMapper.TYPE.get( entity02 ).type;

        if ( DEBUG.CONTACTS.get() ) {
            stringBuilder.setLength( 0 );
            stringBuilder.append( type1 );
            stringBuilder.append( " -> " );
            stringBuilder.append( type2 );
            Gdx.app.debug( "endContact", stringBuilder.toString() );
        }

        boolean contact1Player = type1.equals( TYPE_OF_ENTITY.MYPLAYER );
        boolean contact2Ground = type2.equals( TYPE_OF_ENTITY.GROUND );

        if ( contact1Player && contact2Ground ) {
            MyMapper.GROUNDED.get( entity01 ).grounded = false;
            DynamicLevels.reload();
            if ( DEBUG.CONTACTS.get() ) {
                Gdx.app.debug( "=== DynamicLevels", "must RELOAD ===" );
            }
            return;
        }

        boolean contact2Player = type2.equals( TYPE_OF_ENTITY.MYPLAYER );
        boolean contact1Ground = type1.equals( TYPE_OF_ENTITY.GROUND );

        if ( contact2Player && contact1Ground ) {
            MyMapper.GROUNDED.get( entity02 ).grounded = false;
            DynamicLevels.reload();
            if ( DEBUG.CONTACTS.get() ) {
                Gdx.app.debug( "=== DynamicLevels", "must RELOAD ===" );
            }
            return;
        }

        boolean contact2Ladder = type2.equals( TYPE_OF_ENTITY.LADDER );
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