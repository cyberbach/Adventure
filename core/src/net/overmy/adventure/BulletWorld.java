package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.badlogic.gdx.physics.bullet.DebugDrawer;
import com.badlogic.gdx.physics.bullet.collision.btBroadphaseInterface;
import com.badlogic.gdx.physics.bullet.collision.btCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btDbvtBroadphase;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btDispatcher;
import com.badlogic.gdx.physics.bullet.dynamics.btConstraintSolver;
import com.badlogic.gdx.physics.bullet.dynamics.btDiscreteDynamicsWorld;
import com.badlogic.gdx.physics.bullet.dynamics.btDynamicsWorld;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.dynamics.btSequentialImpulseConstraintSolver;
import com.badlogic.gdx.physics.bullet.linearmath.btIDebugDraw;
import com.badlogic.gdx.utils.Array;

public final class BulletWorld {

    public final static int GROUND_FLAG      = 1 << 9;
    public final static int PLAYER_FLAG      = 1 << 10;
    //public final static int SHOT_FLAG        = 1 << 11;
    public final static int LADDER_FLAG      = 1 << 12;
    public final static int PICKABLE_FLAG    = 1 << 13;
    public final static int COLLECTABLE_FLAG = 1 << 14;
    public final static int NPC_FLAG         = 1 << 15;

    public final static int ALL_FLAG = GROUND_FLAG | //SHOT_FLAG |
                                       PLAYER_FLAG | LADDER_FLAG |
                                       PICKABLE_FLAG | COLLECTABLE_FLAG | NPC_FLAG;

    private static btDynamicsWorld dynamicsWorld = null;
    private static int             userValue     = -1;

    private static DebugDrawer debugDrawer = null;

    private static btCollisionConfiguration collisionConfig  = null;
    private static btDispatcher             dispatcher       = null;
    private static btBroadphaseInterface    broadphase       = null;
    private static btConstraintSolver       constraintSolver = null;

    // Те UserValues, которые сейчас назначены физическим телам.
    private static Array< Integer > actualUserValues = null;


    private BulletWorld () {
    }


    public static void step ( float delta ) {
        dynamicsWorld.stepSimulation( delta, 2 );
    }


    public static void init () {
        Bullet.init();

        resetUserValue();

        collisionConfig = new btDefaultCollisionConfiguration();
        dispatcher = new btCollisionDispatcher( collisionConfig );
        broadphase = new btDbvtBroadphase();
        constraintSolver = new btSequentialImpulseConstraintSolver();

        dynamicsWorld = new btDiscreteDynamicsWorld(
                dispatcher,
                broadphase,
                constraintSolver,
                collisionConfig );

        dynamicsWorld.setGravity( new Vector3( 0, -20f, 0 ) );

        if ( DEBUG.PHYSICAL_MESH.get() ) {
            debugDrawer = new DebugDrawer();
            dynamicsWorld.setDebugDrawer( debugDrawer );
            int mode = btIDebugDraw.DebugDrawModes.DBG_MAX_DEBUG_DRAW_MODE;
            debugDrawer.setDebugMode( mode );
        }

        actualUserValues = new Array< Integer >();
    }


    public static void addBody ( btRigidBody body ) {
        // Генерируем и задаем идентификатор физического тела
        body.setUserValue( BulletWorld.getNextUserValue() );

        dynamicsWorld.addRigidBody( body );
    }


    public static void removeBody ( btRigidBody body ) {
        actualUserValues.removeValue( body.getUserValue(), true );
        dynamicsWorld.removeRigidBody( body );
    }


    public static void drawDebug () {
        debugDrawer.begin( MyCamera.get() );
        dynamicsWorld.debugDrawWorld();
        debugDrawer.end();
    }


    private static void resetUserValue () {
        userValue = -1;
    }


    private static int getNextUserValue () {
        int max = 0;
        for ( int i : actualUserValues ) {
            if ( i > max ) {
                max = i;
            }
        }

        int minEmpty = 0;
        for ( int i = 1; i <= max; i++ ) {
            if ( !actualUserValues.contains( i, false ) ) {
                minEmpty = i;
            }
        }

        if ( minEmpty != 0 ) {
            userValue = minEmpty;
        } else {
            userValue = max + 1;
        }
        actualUserValues.add( userValue );

        return userValue;
    }


    public static void dispose () {
        if ( debugDrawer != null ) {
            debugDrawer.dispose();
        }
        debugDrawer = null;

        collisionConfig.dispose();
        collisionConfig = null;

        dispatcher.dispose();
        dispatcher = null;

        broadphase.dispose();
        broadphase = null;

        constraintSolver.dispose();
        constraintSolver = null;
    }
}
