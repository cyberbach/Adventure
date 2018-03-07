package net.overmy.adventure.ashley;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.MathUtils;

import net.overmy.adventure.ashley.components.DecalComponent;
import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.utils.Vector3Animator;



/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

public final class DecalSubs {

    private DecalSubs () {
    }


    public static DecalComponent LightDustEffect ( float time ) {

        final float decalSize = 0.12f;

        final Decal decal = Decal.newDecal( decalSize, decalSize, randomTriangle(), true );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -0.5f, 0.5f );
        final float toY = MathUtils.random( 0.5f, 1.5f );
        final float toZ = MathUtils.random( -0.5f, 0.5f );

        final float myTime = MathUtils.random( 0.5f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    static DecalComponent BubbleEffect ( float time ) {

        final float decalSize = 0.12f;

        TextureRegion bubbleTextureRegion = IMG.PARTICLE.getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -0.8f, 0.8f );
        final float toY = MathUtils.random( 0.5f, 1.8f );
        final float toZ = MathUtils.random( -0.8f, 0.8f );

        final float myTime = MathUtils.random( 0.5f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    private static TextureRegion randomTriangle () {
        final int imageOffset = IMG.PARTICLE_TRI1.ordinal();
        final int randomOffset = imageOffset + MathUtils.random( 0, 4 );
        return IMG.values()[ randomOffset ].getRegion();
    }
}
