package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.AnimationComponent;
import net.overmy.adventure.ashley.components.MyWeaponComponent;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;

/*
      Created by Andrey Mikheev on 13.03.2018
      Contact me → http://vk.com/id17317
 */

public class MyWeaponSystem extends IteratingSystem {

    @SuppressWarnings( "unchecked" )
    public MyWeaponSystem () {
        super( Family.all( MyWeaponComponent.class, PhysicalComponent.class ).get() );
    }



    @Override
    protected void processEntity( Entity entity, float delta ) {
        MyWeaponComponent myWeaponComponent = MyMapper.MY_WEAPON.get( entity );
        PhysicalComponent physicalComponent = MyMapper.PHYSICAL.get( entity );

        Vector3 weaponTranslation = new Vector3(  );
        myWeaponComponent.hand.globalTransform.getTranslation( weaponTranslation );
        Quaternion weaponRotation = new Quaternion(  );
        myWeaponComponent.hand.globalTransform.getRotation( weaponRotation );

        Matrix4 matrix4 = myWeaponComponent.transform;
        matrix4.translate( weaponTranslation );
        matrix4.rotate( weaponRotation );
        physicalComponent.body.setWorldTransform( matrix4 );
    }
}
