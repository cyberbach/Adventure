package net.overmy.adventure.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import net.overmy.adventure.Core;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.IMG;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

public final class UIHelper {

    private UIHelper () {
    }


    public static Label Label ( String text, FontAsset currentFont ) {
        Label returnLabel = new Label( text, currentFont.getStyle() );

        float x = -returnLabel.getWidth() / 2;
        float y = -returnLabel.getHeight() / 2;
        returnLabel.setPosition( x, y );

        return returnLabel;
    }
/*
    public static Label LabelWithWrap( final Text text, final FontAsset currentFont ) {
        return LabelWithWrap( text, currentFont );
    }*/


    public static Label LabelWithWrap ( final String text, final FontAsset currentFont ) {
        Label returnLabel = new Label( text, currentFont.getStyle() );

        returnLabel.setWidth( Core.WIDTH * 0.7f );
        returnLabel.setWrap( true );

        float x = -returnLabel.getWidth() / 2;
        float y = -returnLabel.getHeight() / 2;
        returnLabel.setPosition( x, y );

        return returnLabel;
    }


    /**
     * Создаем ГРУППУ и добавляем к ней АКТЁРА
     */
    public static Group convertActorToGroup ( final Actor actor ) {
        final Group returnGroup = new Group();
        returnGroup.addActor( actor );
        return returnGroup;
    }


    /**
     * Группа появляется из 0 в 1 за время (FADE * 2)
     */
    public static void scaleIn ( Actor actor ) {
        final float time = MathUtils.random( Core.FADE * 0.2f, Core.FADE );
        actor.addAction( Actions.sequence( Actions.scaleTo( 0, 0, 0 ),
                                           Actions.scaleTo( 1, 1, time ) ) );
    }

    public static void fall ( Actor actor ) {
        final float time = MathUtils.random( Core.FADE * 0.2f, Core.FADE );
        actor.addAction( Actions.sequence( Actions.scaleTo( 2.0f, 2.0f, 0 ),
                                           Actions.scaleTo( 1.0f, 1.0f, time ) ) );
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 0, 0 ),
                                          Actions.alpha( 1, time / 2 ) ),
                        Actions.sequence( Actions.scaleTo( 2.0f, 2.0f, 0 ),
                                          Actions.scaleTo( 1.0f, 1.0f, time ) )
                                )
                       );
    }


    public static void rollIn ( Actor actor, float x, float y, float x2, float y2 ) {
        final float time = MathUtils.random( Core.FADE * 0.8f, Core.FADE );
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 0, 0 ),
                                          Actions.alpha( 1, time ) ),
                        Actions.sequence( Actions.moveTo( x, y, 0 ),
                                          Actions.moveTo( x2, y2, time ) )
                                )
                       );
    }


    public static void roller ( Actor actor, float x, float y, float x2, float y2 ) {
        float time = MathUtils.random( Core.FADE * 0.6f, Core.FADE );
        float xc = ( x2 - x ) * 0.5f + x;
        float yc = ( y2 - y ) * 0.5f + y;
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 0, 0 ),
                                          Actions.alpha( 1, time),
                                          Actions.alpha( 0, time ) ),
                        Actions.sequence( Actions.moveTo( x, y, 0 ),
                                          Actions.moveTo( xc, yc, time, Interpolation.circleOut ),
                                          Actions.moveTo( x2, y2, time, Interpolation.circleIn ) )
                                )
                       );
    }


    public static void rollInAndRun ( Actor actor, float x, float y, float x2, float y2,
                                      Runnable someRun ) {
        final float time = MathUtils.random( Core.FADE * 0.8f, Core.FADE );
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 0, 0 ),
                                          Actions.alpha( 1, time ) ),
                        Actions.sequence( Actions.moveTo( x, y, 0 ),
                                          Actions.moveTo( x2, y2, time ),
                                          Actions.delay( Core.FADE * 0.2f ),
                                          Actions.run( someRun ) )
                                )
                       );
    }


    public static void rollOut ( Actor actor, float x, float y, float x2, float y2 ) {
        final float time = MathUtils.random( Core.FADE * 0.8f, Core.FADE );
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 1, 0 ),
                                          Actions.alpha( 0, time ) ),
                        Actions.sequence( Actions.moveTo( x, y, 0 ),
                                          Actions.moveTo( x2, y2, time ) )
                                )
                       );
    }


    public static void rollOutAndRun ( Actor actor, float x, float y, float x2, float y2, Runnable
            runnable ) {
        final float time = MathUtils.random( Core.FADE * 0.8f, Core.FADE );
        actor.addAction(
                Actions.parallel(
                        Actions.sequence( Actions.alpha( 1, 0 ),
                                          Actions.alpha( 0, time ) ),
                        Actions.sequence( Actions.moveTo( x, y, 0 ),
                                          Actions.moveTo( x2, y2, time ),
                                          Actions.run( runnable )
                                        )
                                )
                       );
    }


    /**
     * Группа исчезает из 1 в 0 за время (FADE * 2)
     */
    public static void scaleOut ( Actor actor ) {
        final float time = MathUtils.random( Core.FADE * 0.2f, Core.FADE );
        actor.addAction( Actions.sequence( Actions.scaleTo( 1, 1, 0 ),
                                           Actions.scaleTo( 0, 0, time ) ) );
    }


    public static void scaleOutAndRun ( final Actor actor, Runnable runnable ) {
        final float time = MathUtils.random( Core.FADE * 0.2f, Core.FADE );

        actor.addAction( Actions.sequence( Actions.scaleTo( 1, 1, 0 ),
                                           Actions.scaleTo( 0, 0, time ),
                                           Actions.run( runnable ) ) );
    }


    public static void waitAndRun ( final Actor actor, Runnable runnable ) {
        actor.addAction( Actions.sequence( Actions.delay( Core.FADE ), Actions.run( runnable ) ) );
    }


    public static void waitAndRun ( final Actor actor, float time, Runnable runnable ) {
        actor.addAction( Actions.sequence( Actions.delay( time ), Actions.run( runnable ) ) );
    }


    public static Touchpad createTouchPad () {
        final TouchpadStyle touchpadStyle = new TouchpadStyle();

        touchpadStyle.knob = IMG.BUTTON.getDrawable();
        touchpadStyle.knob.setMinWidth( Core.HEIGHT * 0.08f );
        touchpadStyle.knob.setMinHeight( Core.HEIGHT * 0.08f );

        touchpadStyle.background = IMG.PAD.getDrawable();
        touchpadStyle.background.setMinWidth( Core.HEIGHT * 0.4f );
        touchpadStyle.background.setMinHeight( Core.HEIGHT * 0.4f );

        return new Touchpad( Core.HEIGHT * 0.01f, touchpadStyle );
    }


    public static void clickAnimation ( Actor actor ) {
        final float timeIn = Core.FADE_HALF * 0.2f;
        final float timeOut = Core.FADE_HALF * 0.8f;
        actor.addAction( Actions.sequence(
                Actions.scaleTo( 0.5f, 0.5f, timeIn, Interpolation.circleIn ),
                Actions.scaleTo( 1.0f, 1.0f, timeOut, Interpolation.circleOut )
                                         ) );
    }


    public static Image BlackBG () {
        Image bgImage = new Image( GFXHelper.createSpriteRGB888( Core.WIDTH * 0.9f,
                                                                 Core.HEIGHT * 0.8f ) );
        bgImage.setPosition( Core.WIDTH * 0.05f, Core.HEIGHT * 0.1f );
        bgImage.setColor( GameColor.BLACKGL.get() );
        return bgImage;
    }


    public static Slider Bar () {
        Texture myTexture = GFXHelper.createTexture( 4, 4 );
        Drawable myDrawable = new TextureRegionDrawable( new TextureRegion( myTexture ) );

        Texture myTexture2 = GFXHelper.createTexture( 4, 4 );
        Drawable myDrawable2 = new TextureRegionDrawable( new TextureRegion( myTexture2 ) );

        final Slider.SliderStyle sliderStyle = new Slider.SliderStyle();

        sliderStyle.knob = myDrawable;
        sliderStyle.knob.setMinWidth( Core.HEIGHT * 0.14f );
        sliderStyle.knob.setMinHeight( Core.HEIGHT * 0.1f );

        sliderStyle.background = myDrawable2;
        sliderStyle.background.setMinWidth( Core.WIDTH * 0.55f );
        sliderStyle.background.setMinHeight( Core.HEIGHT * 0.05f );

        return new Slider( 0, 100, 5, false, sliderStyle );
    }


    public static Actor MenuLabel ( String text, float height ) {
        Label label = new Label( text, FontAsset.MENU_TITLE.getStyle() );
        label.setPosition( Core.HEIGHT * 0.15f, height );
        return label;
    }
}
