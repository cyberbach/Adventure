package net.overmy.adventure.screen;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import net.overmy.adventure.Core;
import net.overmy.adventure.MyGdxGame;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.resources.Settings;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextAsset;
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


    public MenuScreen ( MyGdxGame game ) {
        super( game );
    }


    @Override
    public void show () {
        super.show();

        MyRender.getStage().addActor( optionsGroup = new Group() );
        MyRender.getStage().addActor( introGroup = new Group() );

        showIntroGUI();
    }


    private void showIntroGUI () {
        guiType = GUI_TYPE.MAIN_MENU;
        introGroup.clear(); // disable clearGroup Runnable

        final float labelPosX = Core.WIDTH * 0.6f;
        final float label1PosY = Core.HEIGHT * 0.4f;
        final float label2PosY = Core.HEIGHT * 0.25f;
        final float leftPosX = -Core.WIDTH_HALF; // over screen position
        final float rightPosX = Core.WIDTH; // over screen position

        final Label startLabel = new Label( TextAsset.START_GAME.get(), FontAsset.MENU_TITLE.getStyle() );
        final Label settingsLabel = new Label( TextAsset.OPTIONS.get(), FontAsset.MENU_TITLE.getStyle() );

        introGroup.addActor( startLabel );
        introGroup.addActor( settingsLabel );

        UIHelper.rollIn( startLabel, rightPosX, label1PosY, labelPosX, label1PosY );
        startLabel.addListener( new ClickListener() {
            @Override
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.Click.play();
                UIHelper.clickAnimation( startLabel );
                UIHelper.rollOut( startLabel, labelPosX, label1PosY, leftPosX, label1PosY );
                UIHelper.rollOut( settingsLabel, labelPosX, label2PosY, leftPosX, label2PosY );
                transitionTo( MyGdxGame.SCREEN_TYPE.LOADING_GAME );
            }
        } );

        UIHelper.rollIn( settingsLabel, rightPosX, label2PosY, labelPosX, label2PosY );
        settingsLabel.addListener( new ClickListener() {
            @Override
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.Click.play();
                UIHelper.rollOut( settingsLabel, labelPosX, label2PosY, leftPosX, label2PosY );
                UIHelper.rollOut( startLabel, labelPosX, label1PosY, leftPosX, label1PosY );
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
            soundBar = UIHelper.Bar();
            soundBar.setWidth( Core.WIDTH * 0.55f );
            soundBar.invalidate();
            soundBar.setValue( Settings.SOUND.getInteger() );
            soundBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.6f );
        }
        optionsGroup.addActor( soundBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.MUSIC.get(), Core.HEIGHT * 0.45f ) );
        if ( musicBar == null ) {
            musicBar = UIHelper.Bar();
            musicBar.setWidth( Core.WIDTH * 0.55f );
            musicBar.invalidate();
            musicBar.setValue( Settings.MUSIC.getInteger() );
            musicBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.45f );
        }
        optionsGroup.addActor( musicBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.HORIZ.get(), Core.HEIGHT * 0.3f ) );
        if ( horizontalSensBar == null ) {
            horizontalSensBar = UIHelper.Bar();
            horizontalSensBar.setWidth( Core.WIDTH * 0.55f );
            horizontalSensBar.invalidate();
            horizontalSensBar.setValue( Settings.HORIZ_SENS.getInteger() );
            horizontalSensBar.setPosition( Core.WIDTH * 0.35f, Core.HEIGHT * 0.3f );
        }
        optionsGroup.addActor( horizontalSensBar );

        optionsGroup.addActor( UIHelper.MenuLabel( TextAsset.VERT.get(), Core.HEIGHT * 0.15f ) );
        if ( verticalSensBar == null ) {
            verticalSensBar = UIHelper.Bar();
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
