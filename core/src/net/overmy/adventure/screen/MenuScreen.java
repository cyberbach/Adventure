package net.overmy.adventure.screen;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.Core;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyGdxGame;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.logic.DynamicLevels;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.ModelAsset;
import net.overmy.adventure.resources.MusicAsset;
import net.overmy.adventure.resources.Settings;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextAsset;
import net.overmy.adventure.resources.TextureAsset;
import net.overmy.adventure.utils.UIHelper;

public class MenuScreen extends Base2DScreen {

    private static Group introGroup   = null;
    private static Group optionsGroup = null;

    // setting bars
    private static Slider soundBar          = null;
    private static Slider musicBar          = null;
    private static Slider verticalSensBar   = null;
    private static Slider horizontalSensBar = null;

    private GUI_TYPE guiType;

    private ModelInstance heroInstance = null;
    private Texture       bg           = null;
    private SpriteBatch   spriteBatch  = null;


    public MenuScreen ( MyGdxGame game ) {
        super( game );
    }


    private AnimationController animationController = null;


    @Override
    public void show () {
        super.show();

        bg = TextureAsset.BG_GRADIENT.get();
        spriteBatch = MyRender.getSpriteBatch();

        MyRender.getStage().addActor( optionsGroup = new Group() );
        MyRender.getStage().addActor( introGroup = new Group() );

        showIntroGUI();

        ModelAsset.PLAYER01.build();

        heroInstance = MyPlayer.modelInstance;
        if ( heroInstance == null || MyPlayer.getBody() == null ) {
            heroInstance = ModelAsset.PLAYER01.get();
        }

        heroInstance.materials.get( 0 ).clear();
        heroInstance.materials.get( 0 )
                              .set( ColorAttribute.createDiffuse( GameColor.SQUIREL.get() ) );

        animationController = new AnimationController( heroInstance );
        //String id = heroInstance.animations.first().id;
        animationController.animate( "DANCE", -1, 0.3f, null, 0f );
    }


    @Override
    public void draw ( float delta ) {
        spriteBatch.setColor( 1, 1, 1, 1 );
        spriteBatch.begin();
        spriteBatch.draw( bg, 0, 0, Core.WIDTH, Core.HEIGHT );
        spriteBatch.end();

        MyCamera.addCameraAngle( delta * 50 );
        MyCamera.addVerticalDirection( -0.001f );
        MyCamera.update( delta );

        ModelBatch batch = MyRender.getModelBatch();
        batch.begin( MyCamera.get() );
        batch.render( heroInstance, MyRender.getEnvironment() );
        batch.end();

        animationController.update( delta );

        MusicAsset.playRandom(delta);
    }


    private void showIntroGUI () {
        guiType = GUI_TYPE.MAIN_MENU;
        introGroup.clear(); // disable clearGroup Runnable

        Label title = UIHelper.Label( TextAsset.Title.get(), FontAsset.MENU_TITLE );
        title.setAlignment( Align.center );
        final Group titleGroup = UIHelper.convertActorToGroup( title );
        titleGroup.setPosition( Core.WIDTH_HALF, Core.HEIGHT * 0.8f );
        titleGroup.addAction( Actions.forever(
                Actions.sequence(
                        Actions.scaleTo( 1.2f, 1.2f, 1, Interpolation.exp5Out ),
                        Actions.scaleTo( 1.0f, 1.0f, 1, Interpolation.exp5In )
                                )
                                             ) );
        introGroup.addActor( titleGroup );

        final boolean canResume = MyPlayer.live && DynamicLevels.getCurrent() != 0;

        final float labelPosX = Core.WIDTH * 0.75f;
        final float label2PosY = Core.HEIGHT * 0.23f;
        final float label1PosY = Core.HEIGHT * 0.35f;
        final float label3PosY = Core.HEIGHT * 0.47f;
        final float leftPosX = -Core.WIDTH_HALF; // over screen position
        final float rightPosX = Core.WIDTH; // over screen position

        final Label startLabel = new Label( TextAsset.START_GAME.get(),
                                            FontAsset.MENU_TITLE.getStyle() );
        startLabel.setColor( GameColor.SQUIREL.get() );
        final Label resumeLabel = new Label( TextAsset.RESUME_GAME.get(),
                                             FontAsset.MENU_TITLE.getStyle() );
        resumeLabel.setColor( GameColor.SQUIREL.get() );
        final Label settingsLabel = new Label( TextAsset.OPTIONS.get(),
                                               FontAsset.MENU_TITLE.getStyle() );
        settingsLabel.setColor( GameColor.FOX.get() );

        introGroup.addActor( startLabel );
        introGroup.addActor( settingsLabel );
        if ( canResume ) {
            introGroup.addActor( resumeLabel );
        }

        UIHelper.rollIn( startLabel, rightPosX, label1PosY, labelPosX, label1PosY );
        startLabel.addListener( new ClickListener() {
            @Override
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.Click.play();
                UIHelper.clickAnimation( startLabel );
                UIHelper.rollOut( startLabel, labelPosX, label1PosY, leftPosX, label1PosY );
                UIHelper.rollOut( settingsLabel, labelPosX, label2PosY, leftPosX, label2PosY );
                UIHelper.rollOut( resumeLabel, labelPosX, label3PosY, leftPosX, label3PosY );

                DynamicLevels.initLevels();
                DynamicLevels.setCurrent( 0 );
                AshleyWorld.dispose();
                AshleyWorld.init();

                Settings.KEY1.setBoolean( false );
                Settings.KEY2.setBoolean( false );
                Settings.KEY3.setBoolean( false );
                Settings.KEY4.setBoolean( false );
                Settings.KEY5.setBoolean( false );
                Settings.KEY6.setBoolean( false );

                MyPlayer.clearAll();

                UIHelper.rollOut( titleGroup, Core.WIDTH_HALF, Core.HEIGHT * 0.8f, Core.WIDTH_HALF,
                                  Core.HEIGHT * 1.5f );
                transitionTo( MyGdxGame.SCREEN_TYPE.LOADING_GAME );
            }
        } );

        if ( canResume ) {
            UIHelper.rollIn( resumeLabel, rightPosX, label3PosY, labelPosX, label3PosY );
            resumeLabel.addListener( new ClickListener() {
                @Override
                public void clicked ( InputEvent event, float x, float y ) {
                    SoundAsset.Click.play();
                    UIHelper.clickAnimation( resumeLabel );
                    UIHelper.rollOut( startLabel, labelPosX, label1PosY, leftPosX, label1PosY );
                    UIHelper.rollOut( settingsLabel, labelPosX, label2PosY, leftPosX, label2PosY );
                    UIHelper.rollOut( resumeLabel, labelPosX, label3PosY, leftPosX, label3PosY );

                    transitionTo( MyGdxGame.SCREEN_TYPE.LOADING_GAME );

                    UIHelper.rollOut( titleGroup, Core.WIDTH_HALF, Core.HEIGHT * 0.8f,
                                      Core.WIDTH_HALF, Core.HEIGHT * 1.5f );
                }
            } );
        }

        UIHelper.rollIn( settingsLabel, rightPosX, label2PosY, labelPosX, label2PosY );
        settingsLabel.addListener( new ClickListener() {
            @Override
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.Click.play();
                UIHelper.rollOut( settingsLabel, labelPosX, label2PosY, leftPosX, label2PosY );
                UIHelper.rollOut( startLabel, labelPosX, label1PosY, leftPosX, label1PosY );
                UIHelper.rollOut( resumeLabel, labelPosX, label3PosY, leftPosX, label3PosY );
                titleGroup.clearActions();
                UIHelper.rollOut( titleGroup, Core.WIDTH_HALF, Core.HEIGHT * 0.8f, Core.WIDTH_HALF,
                                  Core.HEIGHT * 1.5f );
                showSettingsGUI();
            }
        } );
    }


    private void showSettingsGUI () {
        guiType = GUI_TYPE.OPTIONS;
        optionsGroup.clear(); // clear Runnable

        optionsGroup.setPosition( 0, 0 );
        optionsGroup.addActor( UIHelper.BlackBG() );
        optionsGroup.addAction( Actions.alpha( 1, Core.FADE ) );

        Label optionsTitleLabel = new Label( TextAsset.OPTIONS.get(),
                                             FontAsset.MENU_TITLE.getStyle() );
        optionsTitleLabel.setPosition( Core.WIDTH_HALF - optionsTitleLabel.getWidth() / 2,
                                       Core.HEIGHT * 0.75f );
        optionsGroup.addActor( optionsTitleLabel );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.SOUND.get(), Core.HEIGHT * 0.6f ) );
        if ( soundBar == null ) {
            soundBar = UIHelper.Bar( GameColor.SQUIREL.get() );
            soundBar.setWidth( Core.WIDTH * 0.55f );
            soundBar.invalidate();
            soundBar.setValue( Settings.SOUND.getInteger() );
            soundBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.6f );
        }
        optionsGroup.addActor( soundBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.MUSIC.get(), Core.HEIGHT * 0.45f ) );
        if ( musicBar == null ) {
            musicBar = UIHelper.Bar( GameColor.SQUIREL.get() );
            musicBar.setWidth( Core.WIDTH * 0.55f );
            musicBar.invalidate();
            musicBar.setValue( Settings.MUSIC.getInteger() );
            musicBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.45f );
        }
        optionsGroup.addActor( musicBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.HORIZ.get(), Core.HEIGHT * 0.3f ) );
        if ( horizontalSensBar == null ) {
            horizontalSensBar = UIHelper.Bar( GameColor.FOX.get() );
            horizontalSensBar.setWidth( Core.WIDTH * 0.55f );
            horizontalSensBar.invalidate();
            horizontalSensBar.setValue( Settings.HORIZ_SENS.getInteger() );
            horizontalSensBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.3f );
        }
        optionsGroup.addActor( horizontalSensBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.VERT.get(), Core.HEIGHT * 0.15f ) );
        if ( verticalSensBar == null ) {
            verticalSensBar = UIHelper.Bar( GameColor.FOX.get() );
            verticalSensBar.setWidth( Core.WIDTH * 0.55f );
            verticalSensBar.invalidate();
            verticalSensBar.setValue( Settings.VERT_SENS.getInteger() );
            verticalSensBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.15f );
        }
        optionsGroup.addActor( verticalSensBar );
    }


    @Override
    public void backButton () {
        SoundAsset.BackSound.play();
        if ( guiType == GUI_TYPE.OPTIONS ) {
            showIntroGUI();
            UIHelper.rollOut( optionsGroup, 0, 0, -Core.WIDTH, 0 );

            Settings.HORIZ_SENS.setInteger( (int) horizontalSensBar.getValue() );
            Settings.VERT_SENS.setInteger( (int) verticalSensBar.getValue() );
            Settings.MUSIC.setInteger( (int) musicBar.getValue() );
            Settings.SOUND.setInteger( (int) soundBar.getValue() );
        } else {
            UIHelper.rollOut( introGroup, 0, 0, -Core.WIDTH_HALF, 0 );

            transitionTo( MyGdxGame.SCREEN_TYPE.EXIT );
        }
    }


    @Override
    public void dispose () {
        super.dispose();

        heroInstance = null;
        bg = null;
        spriteBatch = null;

        introGroup = null;
        optionsGroup = null;
        soundBar = null;
        musicBar = null;
        verticalSensBar = null;
        horizontalSensBar = null;
    }


    private enum GUI_TYPE {
        MAIN_MENU,
        OPTIONS
    }
}
