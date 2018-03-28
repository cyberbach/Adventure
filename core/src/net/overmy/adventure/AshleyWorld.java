package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;

import net.overmy.adventure.ashley.MyEntityListener;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.systems.AnimationSystem;
import net.overmy.adventure.ashley.systems.DecalSystem;
import net.overmy.adventure.ashley.systems.InteractSystem;
import net.overmy.adventure.ashley.systems.LifeSystem;
import net.overmy.adventure.ashley.systems.MyRotationSystem;
import net.overmy.adventure.ashley.systems.MyWeaponSystem;
import net.overmy.adventure.ashley.systems.NPCSystem;
import net.overmy.adventure.ashley.systems.PhysicalSystem;
import net.overmy.adventure.ashley.systems.RemoveByTimeSystem;
import net.overmy.adventure.ashley.systems.RenderSystem;
import net.overmy.adventure.ashley.systems.TextDecalSystem;

public final class AshleyWorld {
    public static Engine getEngine () {
        return engine;
    }


    private static Engine engine = null;


    private AshleyWorld () {
    }


    public static void init () {
        engine = new Engine();

        AshleySubs.init( engine );
        MyMapper.init();

        engine.addSystem( new LifeSystem() );
        //engine.addSystem( new RemoveByLevelSystem() );
        engine.addSystem( new RemoveByTimeSystem() );
        engine.addSystem( new NPCSystem() );
        engine.addSystem( new MyWeaponSystem() );
        engine.addSystem( new AnimationSystem() );
        engine.addSystem( new MyRotationSystem() );
        engine.addSystem( new PhysicalSystem() );
        engine.addSystem( new RenderSystem() );
        engine.addSystem( new TextDecalSystem() );
        engine.addSystem( new DecalSystem() );
        engine.addSystem( new InteractSystem() );

        engine.addEntityListener( new MyEntityListener() );
    }


    public static void dispose () {
        engine.removeSystem( engine.getSystem( LifeSystem.class ) );
        //engine.removeSystem( engine.getSystem( RemoveByLevelSystem.class ) );
        engine.removeSystem( engine.getSystem( RemoveByTimeSystem.class ) );
        engine.removeSystem( engine.getSystem( NPCSystem.class ) );
        engine.removeSystem( engine.getSystem( AnimationSystem.class ) );
        engine.removeSystem( engine.getSystem( MyRotationSystem.class ) );
        engine.removeSystem( engine.getSystem( PhysicalSystem.class ) );
        engine.removeSystem( engine.getSystem( RenderSystem.class ) );
        engine.removeSystem( engine.getSystem( DecalSystem.class ) );
        engine.removeSystem( engine.getSystem( InteractSystem.class ) );
        engine.removeSystem( engine.getSystem( MyWeaponSystem.class ) );

        engine.removeAllEntities();
        //engine.clearPools();
        engine = null;

        AshleySubs.dispose();
        MyMapper.dispose();
    }


    public static void update ( float delta ) {
        engine.update( delta );
        if ( DEBUG.CONTACTS.get() ){
            Gdx.app.debug( "==================================",
                           "tick ===============================" );
        }
    }
}
