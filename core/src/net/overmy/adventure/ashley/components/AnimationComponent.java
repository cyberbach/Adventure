package net.overmy.adventure.ashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;

/*
      Created by Andrey Mikheev on 30.09.2017
      Contact me → http://vk.com/id17317
 */

public class AnimationComponent implements Component {
    
    public AnimationController controller = null;
    
    private ImmutableArray< Animation > animations = null;
    
    public AnimationComponent( ModelInstance modelInstance ) {
        controller = new AnimationController( modelInstance );
        controller.allowSameAnimation = true;
        
        animations = new ImmutableArray< Animation >( modelInstance.animations );
    }
    
    public void queue( int n, float newSpeed ) {
        float duration = animations.get( n ).duration * newSpeed;
        controller.queue( animations.get( n ).id, 1, duration, null, 0f );
    }
    
    public void play( int n, float newSpeed ) {
        float duration = animations.get( n ).duration * newSpeed;
        controller.animate( animations.get( n ).id, 1, duration, null, 0f );
    }


    public String getID() {
        if ( controller.current != null ) { return controller.current.animation.id; }
        else { return ""; }
    }
    /*
    public String getQueuedID() {
        if ( controller.queued != null ) { return controller.queued.animation.text; }
        else { return ""; }
    }*/
}
