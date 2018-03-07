/**
 * OVERMY.NET - Make your device live! *
 * <p/>
 * Games: http://play.google.com/store/apps/developer?id=OVERMY
 *
 * @author Andrey Mikheev (cb)
 */

package net.overmy.adventure.utils;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector3;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public class Vector3Animator {

    private final Vector3 current = new Vector3();
    private final Vector3 from = new Vector3();
    private final Vector3 to = new Vector3();

    private float time = 0.0f;
    private float animationTime = 1.0f;

    private Interpolation interp = null;



    public Vector3Animator() {
        setInterpolation( Interpolation.fade );
        resetTime();
    }



    public Vector3 getCurrent() {
        return current;
    }



    public Vector3Animator setFrom( final Vector3 from ) {
        current.set( from );
        this.from.set( from );
        return this;
    }



    public Vector3Animator setTo( final Vector3 to ) {
        this.to.set( to );
        return this;
    }



    public Vector3Animator setFrom( final float x, float y, float z ) {
        current.set( x, y, z );
        from.set( x, y, z );
        return this;
    }



    public Vector3Animator setTo( final float x, float y, float z ) {
        to.set( x, y, z );
        return this;
    }



    public Vector3Animator setAnimationTime( final float time ) {
        animationTime = time;
        return this;
    }



    private Vector3Animator setInterpolation( final Interpolation interp ) {
        this.interp = interp;
        return this;
    }



    public Vector3Animator resetTime() {
        time = 0.0f;
        return this;
    }



    public void update( final float delta ) {

        if ( !isNeedToUpdate() ) {
            return;
        }

        time += delta;

        final float a = time / animationTime;
        current.x = interp.apply( from.x, to.x, a );
        current.y = interp.apply( from.y, to.y, a );
        current.z = interp.apply( from.z, to.z, a );
    }



    /**
     * Постоянное повторение петли из FROM в TO, и опять из FROM в TO
     */
    public void updateStraightLoop( final float delta ) {

        if ( !isNeedToUpdate() ) {
            current.set( from );
            resetTime();
        }

        time += delta;

        current.x = interp.apply( from.x, to.x, time / animationTime );
        current.y = interp.apply( from.y, to.y, time / animationTime );
        current.z = interp.apply( from.z, to.z, time / animationTime );
    }



    /**
     * Постоянное повторение петли из FROM в TO, и обратно из TO в FROM
     */
    public void updateLoop( final float delta ) {

        if ( !isNeedToUpdate() ) {
            reverse();
            resetTime();
        }

        time += delta;

        current.x = interp.apply( from.x, to.x, time / animationTime );
        current.y = interp.apply( from.y, to.y, time / animationTime );
        current.z = interp.apply( from.z, to.z, time / animationTime );
    }



    // Если "отведённое время" минус "прошедшее время" всё ещё больше нуля, то апдейтим
    public boolean isNeedToUpdate() {
        return animationTime - time > 0.0f;
    }



    public Vector3Animator fromCurrent() {
        from.set( current );
        return this;
    }



    private void reverse() {
        final Vector3 tempVector = new Vector3( from );
        from.set( to );
        to.set( tempVector );
    }



    // 0.0...0,1...0,2...0.3...0,4...0,5...0,6...0,7...0,8...0,9...1,0
    public float getPercentage() {
        if ( time > animationTime ) {
            return 1.0f;
        }
        else {
            return time / animationTime;
        }
    }



    // 0.0...0,2...0,4...0.6...0,8...1,0...0,8...0,6...0,4...0,2...0,0
    public float getAlphaPercentage() {
        if ( time == 0.0f || time > animationTime ) {
            return 0.0f;
        }
        else {
            if ( time < animationTime / 2.0f ) {
                return (time / animationTime) * 2.0f;
            }
            else {
                return (1.0f - time / animationTime) * 2.0f;
            }
        }
    }
}
