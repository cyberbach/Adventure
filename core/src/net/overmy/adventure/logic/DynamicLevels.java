package net.overmy.adventure.logic;

import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.resources.Assets;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.Settings;

/**
 * Created by Andrey (cb) Mikheev
 * 10.02.2017
 */

public final class DynamicLevels {

    private static boolean unloaded = true;

    private static Array< Integer > currentConnections  = null;
    private static Array< Integer > previousConnections = null;

    private static ImmutableArray< Level > levels = null;


    public static void initLevels () {
        Array< Level > levelArray = new Array< Level >();

        LevelSubs ls = new LevelSubs();

        levelArray.add( new Level( "0, 1", ls.level0objects() ) );
        levelArray.add( new Level( "1, 0, 2, 3", ls.level1objects() ) );
        levelArray.add( new Level( "2, 1, 3", ls.level2objects() ) );
        levelArray.add( new Level( "3, 1, 2, 4", ls.level3objects() ) );
        levelArray.add( new Level( "4, 3, 5, 6", ls.level4objects() ) );
        levelArray.add( new Level( "5, 4", ls.level5objects() ) ); // левая глючная
        levelArray.add( new Level( "6, 4, 7", ls.level6objects() ) );
        levelArray.add( new Level( "7, 6, 8" ) ); // переход на секретную локу
        levelArray.add( new Level( "8, 7" ) ); // секретная лока зима

        levels = new ImmutableArray< Level >( levelArray );
    }


    private DynamicLevels () {
    }


    private static int current;


    public static void init () {
        current = Settings.START_LOCATION.getInteger();

        currentConnections = null;
        previousConnections = null;

        currentConnections = new Array< Integer >();
        previousConnections = new Array< Integer >();

        initLevels();
    }


    private static boolean needToUpdate = false;
    private static boolean needToBuild  = false;
    private static float   unloadDelay  = 0.0f;


    public static void reload () {
        needToUpdate = true;
        needToBuild = true;
        unloadDelay = 0.5f;
        copyCurrentConnectionsToPrevious();
        updateCurrentConnections();
        removeNotMatchEntities();
        loadNewModels();
    }


    private static void removeNotMatchEntities () {
        for ( int p : previousConnections ) {
            if ( !isZoneInCurrentConnections( p ) ) {
                Level level = levels.get( p );

                if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                    Gdx.app.debug( "remove level", "" + level );
                }

                if ( level.entity != null ) {
                    level.entity.add( new RemoveByTimeComponent( 0 ) );
                }
                level.entity = null;

                if ( level.objects != null ) {
                    if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                        Gdx.app.debug( "objects in " + p, "" + level.objects.size() );
                    }
                    for ( LevelObject object : level.objects ) {
                        object.removeEntity();
                    }
                }
            }
        }
    }


    private static void removeNotMatchModels () {
        for ( int p : previousConnections ) {
            //Gdx.app.debug( "try",""+p );
            if ( !isZoneInCurrentConnections( p ) ) {
                if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                    Gdx.app.debug( "unload level", "" + ModelAsset.values()[ p ] );
                }
                ModelAsset.values()[ p ].unload();

                Level level = levels.get( p );
                if ( level.objects != null ) {
                    for ( LevelObject object : level.objects ) {
                        if ( !isModelInAnyCurrentConnections( object.modelAsset ) ) {
                            if ( !isWeapon( object.modelAsset ) ) {
                                if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                                    Gdx.app.debug( "unload object", "" + object.modelAsset );
                                }
                                object.modelAsset.unload();
                            }
                        }
                    }
                }
            }
        }
        unloaded = true;
    }


    private static boolean isZoneInCurrentConnections ( int n ) {
        for ( int i : currentConnections ) {
            if ( n == i ) {
                return true;
            }
        }
        return false;
    }


    private static boolean isModelInAnyCurrentConnections ( ModelAsset models ) {
        for ( int i : currentConnections ) {
            Level level = levels.get( i );
            if ( level.objects != null ) {
                for ( LevelObject object : level.objects ) {
                    if ( object.modelAsset == models ) {
                        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                            Gdx.app.debug( "" + models, "in current set" );
                        }
                        return true;
                    }
                }
            }
        }

        if ( DEBUG.DYNAMIC_LEVELS.get() ) {
            Gdx.app.debug( "" + models, "NOT in current set" );
        }
        return false;
    }


    private static void updateCurrentConnections () {
        if ( unloaded ) {
            unloaded = false;
            currentConnections.clear();

            Level level = levels.get( current );
            assert level.connections != null;
            for ( int i : level.connections ) {
                currentConnections.add( i );
            }

            if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                Gdx.app.debug( "Current connections updated", "" + currentConnections );
            }
        }
    }


    private static void copyCurrentConnectionsToPrevious () {
        previousConnections.clear();
        previousConnections.addAll( currentConnections );
    }


    private static void loadNewModels () {
        for ( int i : currentConnections ) {
            // Загружаем текущий уровень
            ModelAsset.values()[ i ].load();

            Level level = levels.get( i );
            if ( level.objects != null ) {
                // Загружаем объекты на уровне
                for ( LevelObject object : level.objects ) {
                    if ( !isWeapon( object.modelAsset ) ) {
                        object.modelAsset.load();
                    }
                }
            }
        }
    }


    private static void buildEntities () {
        for ( int i : currentConnections ) {
            Level level = levels.get( i );

            ModelAsset thisLevel = ModelAsset.values()[ i ];
            thisLevel.build();

            if ( level.entity == null ) {
                if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                    Gdx.app.debug( "Need to build LEVEL", "" + thisLevel );
                }
                level.entity = AshleySubs.createGround( thisLevel );
            }

            if ( level.objects != null ) {
                for ( LevelObject object : level.objects ) {
                    if ( !isWeapon( object.modelAsset ) ) {
                        object.buildModel();
                    }
                    object.buildEntity();
                }
            }
        }
    }


    private static boolean isWeapon ( ModelAsset modelAsset ) {
        return modelAsset.equals( ModelAsset.BROOM_WEAPON ) ||
               modelAsset.equals( ModelAsset.RAKE_WEAPON ) ||
               modelAsset.equals( ModelAsset.KALASH_WEAPON ) ||
               modelAsset.equals( ModelAsset.FENCE_WEAPON )
                ;
    }


    public static void update ( float delta ) {
        if ( needToUpdate ) {
            if ( Assets.getManager().update() ) {
                needToUpdate = false;
                if ( needToBuild ) {

                    if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                        Gdx.app.debug( "Dynamic levels update", "needToBuild" );
                    }

                    // Добавляем нужные Entity, т.к. они уже загружены
                    buildEntities();
                    needToBuild = false;
                }
            }
        }

        if ( unloadDelay > 0 ) {
            unloadDelay -= delta;
            if ( unloadDelay <= 0 ) {

                if ( DEBUG.DYNAMIC_LEVELS.get() ) {
                    Gdx.app.debug( "unloadDelay", "tick" );
                }

                // Здесь ненужные модели добавляются в стэк удаления менеджера Assets
                removeNotMatchModels();
                needToUpdate = true;
            }
        }
    }


    public static int getCurrent () {
        return current;
    }


    public static void setCurrent ( int id ) {
        current = id;
    }


    public static void dispose () {
        Settings.START_LOCATION.setInteger( current );

        currentConnections = null;
        previousConnections = null;
        levels = null;
    }
}
