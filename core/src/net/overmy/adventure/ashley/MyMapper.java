package net.overmy.adventure.ashley;

import com.badlogic.ashley.core.ComponentMapper;

import net.overmy.adventure.ashley.components.ActorComponent;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.BVHPhysicalComponent;
import net.overmy.adventure.ashley.components.BoundingComponent;
import net.overmy.adventure.ashley.components.CollectableComponent;
import net.overmy.adventure.ashley.components.ContainerComponent;
import net.overmy.adventure.ashley.components.DecalComponent;
import net.overmy.adventure.ashley.components.GroundedComponent;
import net.overmy.adventure.ashley.components.InteractComponent;
import net.overmy.adventure.ashley.components.LevelObjectComponent;
import net.overmy.adventure.ashley.components.LifeComponent;
import net.overmy.adventure.ashley.components.ModelComponent;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.NPCComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;
import net.overmy.adventure.ashley.components.PositionComponent;
import net.overmy.adventure.ashley.components.RemoveByLevelComponent;
import net.overmy.adventure.ashley.components.RemoveByTimeComponent;
import net.overmy.adventure.ashley.components.TextDecalComponent;
import net.overmy.adventure.ashley.components.TypeOfComponent;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public final class MyMapper {

    public static ComponentMapper< PositionComponent >      POSITION       = null;
    public static ComponentMapper< AnimationComponent >     ANIMATION      = null;
    public static ComponentMapper< PhysicalComponent >      PHYSICAL       = null;
    static        ComponentMapper< BVHPhysicalComponent >   BVH_PHYSICAL   = null;
    public static ComponentMapper< ModelComponent >         MODEL          = null;
    public static ComponentMapper< GroundedComponent >      GROUNDED       = null;
    public static ComponentMapper< OutOfCameraComponent >   OUT_OF_CAMERA  = null;
    public static ComponentMapper< BoundingComponent >      BOUNDS         = null;
    public static ComponentMapper< TypeOfComponent >        TYPE           = null;
    public static ComponentMapper< RemoveByLevelComponent > REMOVE_BY_ZONE = null;
    public static ComponentMapper< RemoveByTimeComponent >  REMOVE_BY_TIME = null;
    public static ComponentMapper< DecalComponent >       DECAL        = null;
    public static ComponentMapper< InteractComponent >    INTERACT     = null;
    static        ComponentMapper< CollectableComponent > COLLECTABLE  = null;
    public static ComponentMapper< NPCComponent >         NPC          = null;
    public static ComponentMapper< TextDecalComponent >   TEXT_DECAL   = null;
    public static ComponentMapper< LevelObjectComponent > LEVEL_OBJECT = null;
    public static ComponentMapper< MyWeaponComponent >    MY_WEAPON    = null;
    public static ComponentMapper< LifeComponent >        LIFE         = null;
    public static ComponentMapper< ContainerComponent >   CONTAINER    = null;
    public static ComponentMapper< ActorComponent >       ACTOR    = null;


    private MyMapper () {
    }


    public static void init () {
        POSITION = ComponentMapper.getFor( PositionComponent.class );
        ANIMATION = ComponentMapper.getFor( AnimationComponent.class );
        PHYSICAL = ComponentMapper.getFor( PhysicalComponent.class );
        BVH_PHYSICAL = ComponentMapper.getFor( BVHPhysicalComponent.class );
        MODEL = ComponentMapper.getFor( ModelComponent.class );
        GROUNDED = ComponentMapper.getFor( GroundedComponent.class );
        OUT_OF_CAMERA = ComponentMapper.getFor( OutOfCameraComponent.class );
        BOUNDS = ComponentMapper.getFor( BoundingComponent.class );
        TYPE = ComponentMapper.getFor( TypeOfComponent.class );
        REMOVE_BY_ZONE = ComponentMapper.getFor( RemoveByLevelComponent.class );
        REMOVE_BY_TIME = ComponentMapper.getFor( RemoveByTimeComponent.class );
        DECAL = ComponentMapper.getFor( DecalComponent.class );
        INTERACT = ComponentMapper.getFor( InteractComponent.class );
        COLLECTABLE = ComponentMapper.getFor( CollectableComponent.class );
        NPC = ComponentMapper.getFor( NPCComponent.class );
        TEXT_DECAL = ComponentMapper.getFor( TextDecalComponent.class );
        LEVEL_OBJECT = ComponentMapper.getFor( LevelObjectComponent.class );
        MY_WEAPON = ComponentMapper.getFor( MyWeaponComponent.class );
        LIFE = ComponentMapper.getFor( LifeComponent.class );
        CONTAINER = ComponentMapper.getFor( ContainerComponent.class );
        ACTOR = ComponentMapper.getFor( ActorComponent.class );
    }


    public static void dispose () {
        POSITION = null;
        ANIMATION = null;
        PHYSICAL = null;
        BVH_PHYSICAL = null;
        MODEL = null;
        GROUNDED = null;
        OUT_OF_CAMERA = null;
        BOUNDS = null;
        TYPE = null;
        REMOVE_BY_ZONE = null;
        REMOVE_BY_TIME = null;
        DECAL = null;
        INTERACT = null;
        COLLECTABLE = null;
        NPC = null;
        TEXT_DECAL = null;
        LEVEL_OBJECT = null;
        MY_WEAPON = null;
        LIFE = null;
        CONTAINER = null;
        ACTOR = null;
    }
}
