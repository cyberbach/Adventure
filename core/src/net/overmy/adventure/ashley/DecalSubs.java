package net.overmy.adventure.ashley;

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

public class DecalSubs {

    private DecalSubs () {
    }


    public static DecalComponent LightDustEffect ( float time ) {
        float decalSize = 0.1f;

        Decal decal = Decal.newDecal( decalSize, decalSize, randomTriangle(), true );

        float fromX = MathUtils.random( -0.5f, 0.5f );
        float fromY = -0.1f;
        float fromZ = MathUtils.random( -0.5f, 0.5f );

        float toX = MathUtils.random( -0.5f, 0.5f );
        float toY = MathUtils.random( 0.5f, 1.5f );
        float toZ = MathUtils.random( -0.5f, 0.5f );

        //float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( time );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent StarsEffect ( float time ) {
        float decalSize = 0.12f;

        TextureRegion bubbleTextureRegion = IMG.STAR_PARTICLE.getRegion();
        Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        float fromX = 0.0f;
        float fromY = 0.0f;
        float fromZ = 0.0f;

        float toX = MathUtils.random( -1.5f, 1.5f );
        float toY = MathUtils.random( 0.5f, 2.0f );
        float toZ = MathUtils.random( -1.5f, 1.5f );

        float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent CloudEffect ( float x, float z, float time ) {

        float decalSize = 5.0f + MathUtils.random( -1.0f, 7.0f );

        randomNumber++;
        if ( randomNumber > 2 ) {
            randomNumber = 0;
        }

        int nRandomCloud = IMG.CLOUD1.ordinal() + randomNumber;
        TextureRegion bubbleTextureRegion = IMG.values()[ nRandomCloud ].getRegion();
        Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        float randomHeight = MathUtils.random( 5.0f, 15.0f );

        float fromX = MathUtils.random( -50.5f, 50.5f ) + x;
        float fromY = 30.0f + randomHeight;
        float fromZ = MathUtils.random( 70.5f, 80.5f ) + z;

        float toX = fromX + MathUtils.random( -1.5f, 1.5f ) + x;
        float toY = 30.0f + randomHeight;
        float toZ = -60.0f + z;

        float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );
        animator.setInterpolation( Interpolation.linear );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent CoinEffect ( float time ) {
        float decalSize = 0.08f;

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        float fromX = MathUtils.random( -0.5f, 0.5f );
        float fromY = 0.0f;
        float fromZ = MathUtils.random( -0.5f, 0.5f );

        float toX = MathUtils.random( -1.5f, 1.5f );
        float toY = MathUtils.random( 0.5f, 2.0f );
        float toZ = MathUtils.random( -1.5f, 1.5f );

        float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent GreenBubbleEffect ( float time ) {
        float decalSize = 0.1f;

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        decal.setColor( GameColor.GREEN.get() );

        float fromX = MathUtils.random( -0.5f, 0.5f );
        float fromY = 0.0f;
        float fromZ = MathUtils.random( -0.5f, 0.5f );

        float toX = MathUtils.random( -2.5f, 2.5f );
        float toY = MathUtils.random( 0.5f, 2.0f );
        float toZ = MathUtils.random( -2.5f, 2.5f );

        float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    public static DecalComponent RedBubbleEffect ( float time ) {
        float decalSize = 0.1f;

        TextureRegion bubbleTextureRegion = IMG.COIN.getRegion();
        Decal decal = Decal.newDecal( decalSize, decalSize, bubbleTextureRegion, true );

        decal.setColor( GameColor.RED.get() );

        float fromX = MathUtils.random( -0.5f, 0.5f );
        float fromY = 0.0f;
        float fromZ = MathUtils.random( -0.5f, 0.5f );

        float toX = MathUtils.random( -2.5f, 2.5f );
        float toY = MathUtils.random( 0.5f, 2.0f );
        float toZ = MathUtils.random( -2.5f, 2.5f );

        float myTime = MathUtils.random( 0.8f * time, time );

        Vector3Animator animator = new Vector3Animator();
        animator.setFrom( fromX, fromY, fromZ );
        animator.setTo( toX, toY, toZ );
        animator.setAnimationTime( myTime );

        return new DecalComponent( decal, animator );
    }


    private static int randomNumber = 0;


    private static TextureRegion randomTriangle () {
        randomNumber++;
        if ( randomNumber > 4 ) {
            randomNumber = 0;
        }
        int imageOffset = IMG.PARTICLE_TRI1.ordinal() + randomNumber;

        return IMG.values()[ imageOffset ].getRegion();
    }
}
