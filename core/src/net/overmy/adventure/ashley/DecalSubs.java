package net.overmy.adventure.ashley;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;

import net.overmy.adventure.ashley.components.DecalComponent;
import net.overmy.adventure.resources.GameColor;
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

        final float myTime = MathUtils.random( 0.8f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent StarsEffect ( float time ) {

        final float decalSize = 0.18f;

        TextureRegion bubbleTextureRegion = IMG.STAR_PARTICLE.getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -1.5f, 1.5f );
        final float toY = MathUtils.random( 0.5f, 2.0f );
        final float toZ = MathUtils.random( -1.5f, 1.5f );

        final float myTime = MathUtils.random( 0.8f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent CloudEffect ( float x, float z, float time ) {

        final float decalSize = 5.0f + MathUtils.random( -1.0f, 4.0f );

        int nRandomCloud = IMG.CLOUD1.ordinal() + MathUtils.random( 0, 2 );
        TextureRegion bubbleTextureRegion = IMG.values()[ nRandomCloud ].getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        float randomHeight = MathUtils.random( 5.0f, 15.0f );

        final float fromX = MathUtils.random( -50.5f, 50.5f ) + x;
        final float fromY = 30.0f + randomHeight;
        final float fromZ = MathUtils.random( 70.5f, 80.5f ) + z;

        final float toX = fromX + MathUtils.random( -1.5f, 1.5f ) + x;
        final float toY = 30.0f + randomHeight;
        final float toZ = -60.0f + z;

        final float myTime = MathUtils.random( 0.8f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );
        animator.setInterpolation( Interpolation.linear );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent CoinEffect ( float time ) {

        final float decalSize = MathUtils.random( 0.1f,0.3f );

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -1.5f, 1.5f );
        final float toY = MathUtils.random( 0.5f, 2.0f );
        final float toZ = MathUtils.random( -1.5f, 1.5f );

        final float myTime = MathUtils.random( 0.8f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }

    public static DecalComponent GreenBubbleEffect ( float time ) {

        final float decalSize = MathUtils.random( 0.2f,0.4f );

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        decal.setColor( GameColor.GREEN.get() );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -2.5f, 2.5f );
        final float toY = MathUtils.random( 0.5f, 2.0f );
        final float toZ = MathUtils.random( -2.5f, 2.5f );

        final float myTime = MathUtils.random( 0.8f * time, time );

        final Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }

    public static DecalComponent RedBubbleEffect ( float time ) {

        final float decalSize = MathUtils.random( 0.2f,0.4f );

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        final Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        decal.setColor( GameColor.RED.get() );

        final float fromX = MathUtils.random( -0.5f, 0.5f );
        final float fromY = 0.0f;
        final float fromZ = MathUtils.random( -0.5f, 0.5f );

        final float toX = MathUtils.random( -2.5f, 2.5f );
        final float toY = MathUtils.random( 0.5f, 2.0f );
        final float toZ = MathUtils.random( -2.5f, 2.5f );

        final float myTime = MathUtils.random( 0.8f * time, time );

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
