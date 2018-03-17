package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.ashley.core.PooledEngine;

import net.overmy.adventure.ashley.MyEntityListener;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.systems.AnimationSystem;
import net.overmy.adventure.ashley.systems.DecalSystem;
import net.overmy.adventure.ashley.systems.InteractSystem;
import net.overmy.adventure.ashley.systems.LifeSystem;
import net.overmy.adventure.ashley.systems.MyAnimationSystem;
import net.overmy.adventure.ashley.systems.MyWeaponSystem;
import net.overmy.adventure.ashley.systems.NPCSystem;
import net.overmy.adventure.ashley.systems.PhysicalSystem;
import net.overmy.adventure.ashley.systems.RemoveByTimeSystem;
import net.overmy.adventure.ashley.systems.RemoveByLevelSystem;
import net.overmy.adventure.ashley.systems.RenderSystem;
import net.overmy.adventure.ashley.systems.TextDecalSystem;

public final class AshleyWorld {
    public static PooledEngine getPooledEngine () {
        return pooledEngine;
    }


    private static PooledEngine pooledEngine = null;


    private AshleyWorld () {
    }


    public static void init () {
        pooledEngine = new PooledEngine();

        AshleySubs.init( pooledEngine );
        MyMapper.init();

        pooledEngine.addSystem( new LifeSystem() );
        pooledEngine.addSystem( new RemoveByLevelSystem() );
        pooledEngine.addSystem( new RemoveByTimeSystem() );
        pooledEngine.addSystem( new NPCSystem() );
        pooledEngine.addSystem( new MyWeaponSystem() );
        pooledEngine.addSystem( new AnimationSystem() );
        pooledEngine.addSystem( new MyAnimationSystem() );
        pooledEngine.addSystem( new PhysicalSystem() );
        pooledEngine.addSystem( new RenderSystem() );
        pooledEngine.addSystem( new TextDecalSystem() );
        pooledEngine.addSystem( new DecalSystem() );
        pooledEngine.addSystem( new InteractSystem() );

        pooledEngine.addEntityListener( new MyEntityListener() );
    }


    protected static void dispose () {
        pooledEngine.removeSystem( pooledEngine.getSystem( LifeSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( RemoveByLevelSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( RemoveByTimeSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( NPCSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( AnimationSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( MyAnimationSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( PhysicalSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( RenderSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( DecalSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( InteractSystem.class ) );
        pooledEngine.removeSystem( pooledEngine.getSystem( MyWeaponSystem.class ) );

        pooledEngine.removeAllEntities();
        pooledEngine.clearPools();
        pooledEngine = null;

        AshleySubs.dispose();
        MyMapper.dispose();
    }


    public static void update ( float delta ) {
        pooledEngine.update( delta );
    }
}
