package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody.btRigidBodyConstructionInfo;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class PhysicalComponent implements Component {

    public btRigidBody                 body             = null;
    public btRigidBodyConstructionInfo constructionInfo = null;



    public PhysicalComponent(
            btRigidBody body,
            btRigidBodyConstructionInfo constructionInfo ) {
        this.body = body;
        this.constructionInfo = constructionInfo;
    }
}
