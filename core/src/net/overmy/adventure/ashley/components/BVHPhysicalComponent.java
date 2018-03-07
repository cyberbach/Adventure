package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.bullet.collision.btIndexedMesh;
import com.badlogic.gdx.physics.bullet.collision.btTriangleIndexVertexArray;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class BVHPhysicalComponent implements Component {

    public btIndexedMesh              indexedMesh   = null;
    public btTriangleIndexVertexArray meshInterface = null;



    public BVHPhysicalComponent( btIndexedMesh indexedMesh,
                                 btTriangleIndexVertexArray meshInterface ) {
        this.indexedMesh = indexedMesh;
        this.meshInterface = meshInterface;
    }
}
