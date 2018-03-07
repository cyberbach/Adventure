package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class ModelComponent implements Component {

    public ModelInstance modelInstance = null;

    // Модель имеет полу-прозрачный материал
    public boolean blendingPresent = false;



    public ModelComponent( ModelInstance modelInstance ) {
        this.modelInstance = modelInstance;

        for ( int i = 0; i < modelInstance.materials.size; i++ ) {
            Material material = modelInstance.materials.get( i );
            if ( material.has( BlendingAttribute.Type ) ) {
                blendingPresent = true;
                return;
            }
        }
    }
}
