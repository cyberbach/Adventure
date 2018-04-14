package net.overmy.adventure.screen;

/*
      Created by Andrey Mikheev on 10.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.TimeUtils;

import net.overmy.adventure.AshleySubs;
import net.overmy.adventure.AshleyWorld;
import net.overmy.adventure.BulletWorld;
import net.overmy.adventure.Core;
import net.overmy.adventure.DEBUG;
import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyGdxGame;
import net.overmy.adventure.MyPlayer;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.components.TYPE_OF_INTERACT;
import net.overmy.adventure.ashley.systems.DecalSystem;
import net.overmy.adventure.ashley.systems.InteractSystem;
import net.overmy.adventure.ashley.systems.NPCSystem;
import net.overmy.adventure.ashley.systems.RenderSystem;
import net.overmy.adventure.ashley.systems.TextDecalSystem;
import net.overmy.adventure.logic.DialogProcessor;
import net.overmy.adventure.logic.DynamicLevels;
import net.overmy.adventure.logic.Item;
import net.overmy.adventure.logic.ItemInBagg;
import net.overmy.adventure.logic.MyDialog;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.resources.IMG;
import net.overmy.adventure.resources.MusicAsset;
import net.overmy.adventure.resources.Settings;
import net.overmy.adventure.resources.SoundAsset;
import net.overmy.adventure.resources.TextAsset;
import net.overmy.adventure.resources.DialogAsset;
import net.overmy.adventure.resources.TextureAsset;
import net.overmy.adventure.utils.GFXHelper;
import net.overmy.adventure.utils.LoadIndicator;
import net.overmy.adventure.utils.UIHelper;

import java.util.ArrayList;

public class GameScreen extends Base2DScreen {
    private Image         showIngameMenuImage = null;
    private Image         aimImage            = null;
    private Image         attackButton        = null;
    private Image         jumpButton          = null;
    private Touchpad      touchpad            = null;
    private LoadIndicator indicatorGroup      = null;
    private Group         interactGroup       = null;
    private Group         touchPadGroup       = null;
    private Group         bagButtonGroup      = null;

    private TextDecalSystem textDecalSystem = null;

    private InteractSystem interactSystem = null;


    private GUI_TYPE guiType;

    private Group gameGroup = null;

    private long startTime;
    private StringBuilder log = new StringBuilder();


    private boolean readyToPick = false;


    public GameScreen ( MyGdxGame game ) {
        super( game );
    }


    private SpriteBatch spriteBatch;
    private Texture     bg;


    private static ArrayList< Vector3 > pushedPositions = new ArrayList< Vector3 >();


    @Override
    public void show () {
        super.show();

        textDecalSystem = AshleyWorld.getEngine().getSystem( TextDecalSystem.class );
        textDecalSystem.init();
        AshleyWorld.getEngine().getSystem( NPCSystem.class ).setWalkSound();

        interactSystem = AshleyWorld.getEngine().getSystem( InteractSystem.class );

        bg = TextureAsset.BG_GRADIENT.get();
        spriteBatch = MyRender.getSpriteBatch();

        MyCamera.setCameraPosition( new Vector3( 0, 300, 0 ) );
        MyPlayer.init();

        touchPadGroup = new Group();
        MyRender.getStage().addActor( indicatorGroup = UIHelper.initLoadIndicator() );
        MyRender.getStage().addActor( gameGroup = new Group() );

        showGameGUI();

        if ( DEBUG.GAME_MASTER_MODE.get() ) {
            /*String helpString = "ENTER - push position\n1- show bonus pos\n" +
                                "2-show box pos\n3-show NPC move pos\n" +
                                "\nBackSpace-clear positions\n\n" +
                                "9 speed up\n" +
                                "0 speed normal";*/
            String helpString = "GM";
            Label gameMasterTitle = UIHelper.Label( helpString, FontAsset.DIALOG_BODY );
            gameMasterTitle.setPosition( 16, Core.HEIGHT_HALF );

            MyRender.getStage().addActor( gameMasterTitle );
/*
            Image image1 = IMG.SPEAKER.getImageActor( 64, 64 );
            image1.setPosition( Core.WIDTH * 0.3f, Core.HEIGHT * 0.8f );
            image1.addListener( new ClickListener() {
                public void clicked ( InputEvent event, float x, float y ) {
                    // TODO
                    MusicAsset.WINDFILTER.play( true );
                    MusicAsset.FOREST.stopLoop();
                }
            } );

            Image image2 = IMG.SOUNDON.getImageActor( 64, 64 );
            image2.setPosition( Core.WIDTH * 0.3f, Core.HEIGHT * 0.6f );
            image2.addListener( new ClickListener() {
                public void clicked ( InputEvent event, float x, float y ) {
                    // TODO
                    MusicAsset.FOREST.play( true );
                    MusicAsset.WINDFILTER.stopLoop();
                }
            } );

            MyRender.getStage().addActor( image1 );
            MyRender.getStage().addActor( image2 );*/
        }

        //MusicAsset.WINDFILTER.play( true );

        if ( Settings.KEY1.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY1 ) ) {
                MyPlayer.addToBag( Item.KEY1 );
            }
        }
        if ( Settings.KEY2.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY2 ) ) {
                MyPlayer.addToBag( Item.KEY2 );
            }
        }
        if ( Settings.KEY3.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY3 ) ) {
                MyPlayer.addToBag( Item.KEY3 );
            }
        }
        if ( Settings.KEY4.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY4 ) ) {
                MyPlayer.addToBag( Item.KEY4 );
            }
        }
        if ( Settings.KEY5.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY5 ) ) {
                MyPlayer.addToBag( Item.KEY5 );
            }
        }
        if ( Settings.KEY6.getBoolean() ) {
            if ( !MyPlayer.testBag( Item.KEY6 ) ) {
                MyPlayer.addToBag( Item.KEY6 );
            }
        }

        switch ( DynamicLevels.getCurrent() ) {
            case 0:
            case 1:
            case 2:
            case 3:
                MusicAsset.SEA.play( true );
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 31:
                MusicAsset.WINTER.play( true );
                break;
            default:
                MusicAsset.FOREST.play( true );
                break;
        }

        // FIXME удалить после теста

        for(int i=0;i<40;i++) {
            MyPlayer.addToBag( Item.COIN );
            MyPlayer.addToBag( Item.YELLOW_STAR );
            MyPlayer.addToBag( Item.BLUE_STAR );
            MyPlayer.addToBag( Item.GREEN_STAR );
        }

        MyPlayer.addToBag( Item.KEY1 );
        MyPlayer.addToBag( Item.KEY2 );
        MyPlayer.addToBag( Item.KEY3 );
        MyPlayer.addToBag( Item.KEY4 );
        MyPlayer.addToBag( Item.KEY5 );
        MyPlayer.addToBag( Item.KEY6 );
        MyPlayer.addToBag( Item.GUN_WEAPON_UPGRADED );
    }


    @Override
    public boolean touchDragged ( float x, float y ) {
        if ( guiType == GUI_TYPE.INGAME_MENU ) {
            return false;
        }

        final float SPEED_BY_X = 0.02f;
        final float SPEED_BY_Y = 0.0005f;

        MyCamera.addCameraAngle( x * SPEED_BY_X );
        MyCamera.addVerticalDirection( -y * SPEED_BY_Y );
        return true;
    }


    @Override
    public void draw ( float delta ) {
        spriteBatch.setColor( 1, 1, 1, 1 );
        spriteBatch.begin();
        spriteBatch.draw( bg, 0, 0, Core.WIDTH, Core.HEIGHT );
        spriteBatch.end();

        AshleyWorld.update( delta );

        if ( DEBUG.PHYSICAL_MESH.get() ) {
            BulletWorld.drawDebug();
        }

        MyRender.getDecalBatch().flush();
    }


    private final float MAX_CLOUD_TIMER = 2.0f;
    private       float cloudTimer      = MAX_CLOUD_TIMER;

    private Label fpsLabel = null;


    @Override
    public void update ( float delta ) {
        super.update( delta );

        MusicAsset.playRandom( delta );

        if ( DEBUG.GAME_MASTER_MODE.get() ) {
            if ( Gdx.input.isKeyJustPressed( Input.Keys.NUM_9 ) ) {
                MyPlayer.extraSpeed2 = 15.0f;
            }

            if ( Gdx.input.isKeyJustPressed( Input.Keys.NUM_0 ) ) {
                MyPlayer.extraSpeed2 = 0.0f;
            }

            if ( Gdx.input.isKeyJustPressed( Input.Keys.INSERT ) ) {
                MyPlayer.extraJump = 1.0f;
            }

            if ( Gdx.input.isKeyJustPressed( Input.Keys.ENTER ) ) {
                Matrix4 thisTransform = MyPlayer.getBody().getWorldTransform();
                Vector3 thisPosition = new Vector3();
                thisTransform.getTranslation( thisPosition );
                pushedPositions.add( thisPosition );

                Quaternion rotation = new Quaternion();
                thisTransform.getRotation( rotation );

                String pos = "new Vector3( " + thisPosition.x + "f, " +
                             thisPosition.y + "f, " + thisPosition.z + "f )";
                Gdx.app.debug( "Pushed angle = " +
                               rotation.getAngleAround( Vector3.Y ), "\n" + pos );
                Gdx.app.debug( "THIS LOCATION", "" + DynamicLevels.getCurrent() );
            }

            if ( Gdx.input.isKeyJustPressed( Input.Keys.BACKSPACE ) ) {
                pushedPositions.clear();
                Gdx.app.debug( "♦ Positions", "cleared ♦" );
            }

            if ( Gdx.input.isKeyPressed( Input.Keys.W ) ) {
                MyPlayer.move( 0, -1 );
            }

            if ( Gdx.input.isKeyPressed( Input.Keys.S ) ) {
                MyPlayer.move( 0, 1 );
            }

            if ( Gdx.input.isKeyPressed( Input.Keys.A ) ) {
                MyPlayer.move( -1, 0 );
            }

            if ( Gdx.input.isKeyPressed( Input.Keys.D ) ) {
                MyPlayer.move( 1, 0 );
            }

            if ( Gdx.input.isKeyJustPressed( Input.Keys.SPACE ) ) {
                MyPlayer.startJump();
            }

            // GameMaster Mode
            // add hover coin
            if ( Gdx.input.isKeyJustPressed( Input.Keys.NUM_1 ) ) {
                StringBuilder stringBuilder = new StringBuilder();

                for ( Vector3 pushed : pushedPositions ) {
                    stringBuilder.append( "objects.add( hoverCoin( " );
                    stringBuilder.append( pushed.x );
                    stringBuilder.append( "f, " );
                    stringBuilder.append( pushed.y );
                    stringBuilder.append( "f, " );
                    stringBuilder.append( pushed.z );
                    stringBuilder.append( "f) );\n" );
                }

                Gdx.app.debug( "Pushed positions", "\n" + stringBuilder.toString() );
            }
            // add box
            if ( Gdx.input.isKeyJustPressed( Input.Keys.NUM_2 ) ) {
                StringBuilder stringBuilder = new StringBuilder();

                for ( Vector3 pushed : pushedPositions ) {
                    stringBuilder.append( "objects.add( box( " );
                    stringBuilder.append( pushed.x );
                    stringBuilder.append( "f, " );
                    stringBuilder.append( pushed.y );
                    stringBuilder.append( "f, " );
                    stringBuilder.append( pushed.z );
                    stringBuilder.append( "f) );\n" );
                }

                Gdx.app.debug( "Pushed positions", "\n" + stringBuilder.toString() );
            }
            // add move point
            if ( Gdx.input.isKeyJustPressed( Input.Keys.NUM_3 ) ) {
                StringBuilder stringBuilder = new StringBuilder();

                for ( Vector3 pushed : pushedPositions ) {
                    //queue.add( new NPCAction( ACTION_ID.MOVE, new Vector2( 15.5f, -3.166f ), 10.0f ) );
                    stringBuilder.append(
                            "queue.add( move(" );
                    stringBuilder.append( pushed.x );
                    stringBuilder.append( "f, " );
                    //stringBuilder.append( pushed.y );
                    //stringBuilder.append( "f, " );
                    stringBuilder.append( pushed.z );
                    stringBuilder.append( "f) );\n" );
                }

                Gdx.app.debug( "Pushed positions", "\n" + stringBuilder.toString() );
            }
        }

        DynamicLevels.update( delta );
        MyPlayer.updateControls( delta );
        MyCamera.update( delta );

        textDecalSystem.setLastPlayerPosition( MyPlayer.getPosition() );

        if ( guiType == GUI_TYPE.GAME_GUI ) {
            MyPlayer.move( touchpad.getKnobPercentX(), -touchpad.getKnobPercentY() );
        } else {
            if ( !DEBUG.GAME_MASTER_MODE.get() ) {
                MyPlayer.move( 0, 0 );
            }
        }

        if ( DEBUG.FPS.get() ) {
            if ( TimeUtils.nanoTime() - startTime > 1000000000 ) /* 1,000,000,000ns == one second */ {
                log.setLength( 0 );
                log.append( "▓▒░ FPS = " );
                log.append( Gdx.graphics.getFramesPerSecond() );
                log.append( " " );

                RenderSystem rend = AshleyWorld.getEngine().getSystem( RenderSystem.class );
                int models = rend.getVisibleModelsCount();
                int totalModels = rend.getTotalModelsCount();
                log.append( " Models=" );
                log.append( models );
                log.append( "/" );
                log.append( totalModels );

                DecalSystem decalSystem = AshleyWorld.getEngine().getSystem( DecalSystem.class );
                log.append( " Decals=" );
                log.append( decalSystem.getVisibleDecalCount() );
                log.append( "/" );
                log.append( decalSystem.getDecalCount() );

                log.append( " ░▒▓" );

                Gdx.app.log( "", log.toString() );
                startTime = TimeUtils.nanoTime();
                if ( DEBUG.SCREEN_FPS.get() ) {
                    fpsLabel.setText( log.toString() );
                }
            }
        }

        // Работа интерактивной системы

        TYPE_OF_INTERACT typeOfInteract = interactSystem.getCurrentType();

        if ( !typeOfInteract.equals( TYPE_OF_INTERACT.EMPTY ) ) {
            if ( !readyToPick ) {
                readyToPick = true;

                boolean isBook = false;
                boolean itemInInventory = false;
                boolean USEinteract = false;

                log.setLength( 0 );
                switch ( typeOfInteract ) {
                    case EMPTY:
                        break;
                    case LOOT:
                        log.append( TextAsset.LOOT.get() );
                        break;
                    case TALK:
                        log.append( TextAsset.TALK.get() );
                        break;
                    case READ:
                        isBook = true;
                        log.append( TextAsset.READ.get() );
                        break;
                    case USE:
                        USEinteract = true;
                        log.append( TextAsset.USE.get() );

                        break;
                }
                if ( interactSystem.getCurrentItem() != null ) {
                    log.append( interactSystem.getCurrentItem().getName() );
                    itemInInventory = MyPlayer.testBag( interactSystem.getCurrentItem() );
                } else {
                    log.append( interactSystem.getCurrentMyDialog().getTitle() );
                }
                Label interactText = UIHelper.Label( log.toString(), FontAsset.IVENTORY_ITEM );
                float w = interactText.getWidth();
                float h = interactText.getHeight();
                //GlyphLayout glyphLayout = pickText.getGlyphLayout();

                Sprite lineSprite = GFXHelper.createSpriteRGB888(
                        w + h * 0.5f,
                        h * 1.5f );
                Image lineImage = new Image( lineSprite );
                lineImage.setColor( GameColor.BLACKGL.get() );
                lineImage.setPosition( -lineImage.getWidth() / 2, -lineImage.getHeight() / 2 );

                if ( !showGameOver ) {
                    interactGroup.addActor( lineImage );
                    interactGroup.addActor( interactText );
                    final boolean finalIsBook = isBook;
                    final boolean finalUSEinteract = USEinteract;
                    final boolean finalItemInInventory = itemInInventory;
                    interactGroup.addListener( new ClickListener() {
                        public void clicked ( InputEvent event, float x, float y ) {
                            SoundAsset.EQUIP.play();
                            UIHelper.clickAnimation( interactGroup );
                            if ( finalUSEinteract ) {
                                if ( finalItemInInventory ) {
                                    interactSystem.act();
                                }
                            } else {
                                interactSystem.act();
                            }

                            if ( interactSystem.getCurrentMyDialog() != null ) {
                                showDialogMenu( interactSystem.getCurrentMyDialog(),
                                                finalIsBook );
                            }
                        }
                    } );
                }
            }
        } else {
            readyToPick = false;
            interactGroup.clear();
            interactGroup.addAction( Actions.scaleTo( 1, 1, 0 ) );
        }

        // Create clouds
        cloudTimer -= delta;
        if ( cloudTimer < 0 ) {
            cloudTimer = MathUtils.random( MAX_CLOUD_TIMER * 0.5f, MAX_CLOUD_TIMER );
            AshleySubs.createCloudFX();
        }

        // GAME is OVER

        if ( !MyPlayer.live && !showGameOver || DialogProcessor.gameFinished && !showGameOver ) {
            showGameOver = true;

            SoundAsset.GAMEOVER.play();

            Label gameOverLabel = UIHelper.Label( TextAsset.END_GAME.get(), FontAsset.MENU_TITLE );
            final Group gameOverGroup = UIHelper.convertActorToGroup( gameOverLabel );
            gameOverGroup.setPosition( -Core.WIDTH, Core.HEIGHT_HALF );
            gameOverGroup.addAction( Actions.sequence(
                    Actions.scaleTo( 0, 0, 0 ),
                    Actions.moveTo( Core.WIDTH_HALF, Core.HEIGHT_HALF, 0 ),
                    Actions.scaleTo( 1, 1, Core.FADE * 4.0f, Interpolation.bounceOut )
                                                     ) );

            gameOverGroup.addListener( new ClickListener() {
                public void clicked ( InputEvent event, float x, float y ) {
                    SoundAsset.BackSound.play();
                    UIHelper.scaleOut( gameOverGroup );
                    DialogProcessor.gameFinished=false;
                    MyPlayer.live=false;
                    transitionTo( MyGdxGame.SCREEN_TYPE.MENU );
                }
            } );

            MyRender.getStage().addActor( gameOverGroup );

            attackButton.clearActions();
            touchPadGroup.clearActions();
            jumpButton.clearActions();

            UIHelper.scaleOut( aimImage );
            UIHelper.scaleOut( attackButton );
            UIHelper.scaleOut( touchPadGroup );
            UIHelper.scaleOut( jumpButton );
            UIHelper.scaleOut( showIngameMenuImage );

            MyPlayer.stopSound();
        }
    }


    private boolean showGameOver = false;


    private void showInGameMenu () {
        guiType = GUI_TYPE.INGAME_MENU;

        gameGroup.clear();

        float inGameIconSize = Core.HEIGHT * 0.1f;

        final Image showIngameMenuImage = IMG.INGAME.getImageActor( inGameIconSize,
                                                                    inGameIconSize );
        showIngameMenuImage.setPosition( Core.WIDTH - inGameIconSize,
                                         Core.HEIGHT - inGameIconSize );
        gameGroup.addActor( showIngameMenuImage );

        showIngameMenuImage.addListener( new ClickListener() {
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.BackSound.play();
                UIHelper.clickAnimation( showIngameMenuImage );
                showGameGUI();
            }
        } );

        // scroll pane?

        final int SCR_H_01 = (int) ( Core.HEIGHT * 0.1f );
        gameGroup.addActor( UIHelper.BlackBG() );

        Label ingameMenuTitle = UIHelper.Label( TextAsset.INVENTORY.get(), FontAsset.MENU_TITLE );
        //float fontOffset = ingameMenuTitle.getHeight() * 1.5f;
        ingameMenuTitle.setPosition( SCR_H_01 * 2.0f,
                                     Core.HEIGHT - SCR_H_01 * 2.0f );
        gameGroup.addActor( ingameMenuTitle );

        Table table = new Table();
        table.setWidth( Core.WIDTH - SCR_H_01 * 2 );

        for ( final ItemInBagg itemInBagg : MyPlayer.getBag() ) {
            Item thisItem = itemInBagg.item;

            Image upgradeIcon = IMG.UPGRADE.getImageActor( SCR_H_01, SCR_H_01 );
            Image img = thisItem.getImage( SCR_H_01, SCR_H_01 );
            Label txt = UIHelper.Label( thisItem.getName(), FontAsset.IVENTORY_ITEM );
            txt.setWrap( true );
            String cntString = itemInBagg.count > 1 ? "" + itemInBagg.count : "";
            Label count = UIHelper.Label( cntString, FontAsset.IVENTORY_ITEM_TEXT );
            Label fullTxt = UIHelper.Label( thisItem.getAbout(), FontAsset.IVENTORY_ITEM_TEXT );
            fullTxt.setWrap( true );

            boolean itemIsMoney = thisItem.equals( Item.COIN ) ||
                                  thisItem.equals( Item.BLUE_STAR ) ||
                                  thisItem.equals( Item.YELLOW_STAR ) ||
                                  thisItem.equals( Item.GREEN_STAR ) ||
                                  thisItem.equals( Item.KEY1 ) ||
                                  thisItem.equals( Item.KEY2 ) ||
                                  thisItem.equals( Item.KEY3 ) ||
                                  thisItem.equals( Item.KEY4 ) ||
                                  thisItem.equals( Item.KEY5 ) ||
                                  thisItem.equals( Item.KEY6 );

            boolean itemIsBottle = thisItem.equals( Item.BLUE_BOTTLE ) ||
                                   thisItem.equals( Item.RED_BOTTLE ) ||
                                   thisItem.equals( Item.GREEN_BOTTLE ) ||
                                   thisItem.equals( Item.PURPLE_BOTTLE );

            final Image useImage = IMG.USABLE.getImageActor( SCR_H_01, SCR_H_01 );
            if ( !itemIsMoney ) {
                useImage.addListener( new ClickListener() {
                    public void clicked ( InputEvent event, float x, float y ) {
                        SoundAsset.Click.play();
                        UIHelper.clickAnimation( useImage );

                        MyPlayer.useItemInBag( itemInBagg );

                        showGameGUI();
                    }
                } );
            }

            table.add( img ).left().minWidth( SCR_H_01 );
            table.add( count ).left().pad( 0, SCR_H_01 / 4, 0, SCR_H_01 / 4 );
            table.add( txt ).left().width( SCR_H_01 * 3.6f );
            table.add( fullTxt ).left().width( SCR_H_01 * 6 ).pad( 0, 0, 0, SCR_H_01 / 4 );
            if ( !itemIsMoney ) {
                if ( itemInBagg.count > 1 && !itemIsBottle ) {
                    table.add( upgradeIcon ).left().minWidth( SCR_H_01 );
                    upgradeIcon.addListener( new ClickListener() {
                        public void clicked ( InputEvent event, float x, float y ) {
                            SoundAsset.Click.play();
                            UIHelper.clickAnimation( useImage );
                            MyPlayer.upgradeWeapon( itemInBagg );
                            showInGameMenu();
                        }
                    } );
                } else {
                    table.add().left().minWidth( SCR_H_01 );
                }
                table.add( useImage ).left().minWidth( SCR_H_01 );
            }
            table.row();

            Sprite lineSprite = GFXHelper.createSpriteRGB888( Core.WIDTH - SCR_H_01 * 2.5f,
                                                              SCR_H_01 / 8 );
            Image lineImage = new Image( lineSprite );
            lineImage.setColor( GameColor.BLACKGL.get() );
            table.add( lineImage ).center().colspan( 6 ).row();
        }

        ScrollPane scrollPane = new ScrollPane( table );
        scrollPane.setPosition( SCR_H_01, SCR_H_01 );
        scrollPane.setSize( Core.WIDTH - SCR_H_01 * 2, Core.HEIGHT - SCR_H_01 * 3.5f );
        scrollPane.setFadeScrollBars( true );
        scrollPane.setScrollingDisabled( true, false );

        gameGroup.addActor( scrollPane );
    }


    private void showDialogMenu ( MyDialog currentMyDialog, final boolean isBook ) {
        if ( currentMyDialog.haveNotBody() ) {
            showGameGUI();
            return;
        }

        guiType = GUI_TYPE.INGAME_MENU;

        gameGroup.clear();

        final Image showIngameMenuImage = IMG.BUTTON.getImageActor( 64, 64 );
        showIngameMenuImage.setPosition( Core.WIDTH - 64, Core.HEIGHT - 64 );
        gameGroup.addActor( showIngameMenuImage );

        showIngameMenuImage.addListener( new ClickListener() {
            public void clicked ( InputEvent event, float x, float y ) {
                UIHelper.clickAnimation( showIngameMenuImage );
                showGameGUI();
            }
        } );

        ////// dialog

        int offset = (int) ( Core.HEIGHT * 0.1f );
        int w = Core.WIDTH - offset * 2;
        int h = Core.HEIGHT - offset;
        Sprite bgSprite = GFXHelper.createSpriteRGB888( w, h );
        Image bgImage = new Image( bgSprite );
        bgImage.setColor( GameColor.BLACKGL.get() );
        bgImage.setPosition( offset, offset / 2 );
        gameGroup.addActor( bgImage );

        // title

        Label dialogTitle = UIHelper.Label( currentMyDialog.getTitle(), FontAsset.MENU_TITLE );
        dialogTitle.setWrap( true );
        float fontOffset = dialogTitle.getHeight() * 1.5f;
        dialogTitle.setPosition( offset * 1.4f, Core.HEIGHT - offset * 2.0f );
        dialogTitle.setWidth( offset * 3.5f );
        gameGroup.addActor( dialogTitle );

        // body

        Label dialogBody = UIHelper.Label( currentMyDialog.getBody(), FontAsset.DIALOG_BODY );
        dialogBody.setWidth( Core.WIDTH - offset * 6.5f );
        dialogBody.setWrap( true );
        Gdx.app.debug( "height", "" + dialogBody.getHeight() );
        dialogBody.setPosition( offset * 5.5f,
                                Core.HEIGHT - offset * 1.5f - dialogBody.getHeight() );
        gameGroup.addActor( dialogBody );

        Gdx.app.debug( "connections", "" + currentMyDialog.getConnections() );

        // variants

        int j = 0;
        for ( int i = 0; i < currentMyDialog.getConnections().size; i++ ) {
            final MyDialog connection = currentMyDialog.getConnections().get( i );

            Label dialogVariant = UIHelper.Label( connection.getAction(),
                                                  FontAsset.DIALOG_VARIANT );
            dialogVariant.setPosition( offset * 2,
                                       Core.HEIGHT_HALF - offset - i * offset );
            dialogVariant.addListener( new ClickListener() {
                public void clicked ( InputEvent event, float x, float y ) {
                    SoundAsset.Click.play();
                    DialogProcessor.process( connection );
                    showDialogMenu( connection, isBook );
                }
            } );
            gameGroup.addActor( dialogVariant );
            j++;
        }

        Label dialogVariant;
        if ( isBook ) {
            dialogVariant = UIHelper.Label( DialogAsset.CloseBook.get(),
                                            FontAsset.DIALOG_VARIANT );
        } else {
            dialogVariant = UIHelper.Label( DialogAsset.CloseDialog.get(),
                                            FontAsset.DIALOG_VARIANT );
        }

        dialogVariant.setPosition( offset * 2,
                                   Core.HEIGHT_HALF - offset - j * offset );
        dialogVariant.addListener( new ClickListener() {
            public void clicked ( InputEvent event, float x, float y ) {
                SoundAsset.Click.play();
                showGameGUI();
            }
        } );
        gameGroup.addActor( dialogVariant );
    }

/*

    private void processTextBlock ( MyDialog connection ) {

        Vector3 pos1 = new Vector3( MyPlayer.getNotFilteredPos() ).add( 0, 0.5f, 0 );

        switch ( connection ) {
            case FoxAliceQ3V1_last:
                CollectableProcessor.process( Item.PILLOW_WEAPON, pos1 );
                MyDialog.FoxAlice.getConnections().clear();
                MyDialog.FoxAlice.connect( MyDialog.BUY_BlueBottle_3BlueStars,
                                                      MyDialog.BUY_PurpleBottle_5coins );
                break;

            case NigelBirdQ4V1_last:
                CollectableProcessor.process( Item.KALASH_WEAPON, pos1 );
                break;

            case BUY_GreenBottle_10coins:
                if ( MyPlayer.testBagCount( Item.COIN, 5 ) ) {
                    SoundAsset.Collect7.play();
                    MyPlayer.removeItemInBag( Item.COIN, 5 );
                    MyPlayer.addToBag( Item.GREEN_BOTTLE );
                }
                break;

            case TopaQ4V1_last:
                CollectableProcessor.process( Item.COIN, pos1 );
                CollectableProcessor.process( Item.COIN, pos1 );
                CollectableProcessor.process( Item.COIN, pos1 );
                CollectableProcessor.process( Item.COIN, pos1 );
                CollectableProcessor.process( Item.COIN, pos1 );
                break;

            case RacoonBabyQ4V1_last:
                pos1.add( 0.0f, 1.2f, 0 );
                for ( int i = 0; i < 10; i++ ) {
                    CollectableProcessor.process( Item.COIN, pos1 );
                }

                break;

            case CheinieRacoonQ4V1_last:
                CollectableProcessor.process( Item.GREEN_BOTTLE, pos1 );
                break;
        }
    }
*/


    private void showGameGUI () {
        guiType = GUI_TYPE.GAME_GUI;

        gameGroup.clear();
        touchPadGroup.clear();

        if ( DEBUG.SCREEN_FPS.get() ) {
            if ( fpsLabel == null ) {
                fpsLabel = UIHelper.Label( "", FontAsset.IVENTORY_ITEM );
                fpsLabel.setPosition( 0, Core.HEIGHT * 0.9f );
            }
            gameGroup.addActor( fpsLabel );
        }

        if ( touchpad == null ) {
            touchpad = UIHelper.createTouchPad();
            touchpad.setPosition( Core.HEIGHT * 0.05f, Core.HEIGHT * 0.05f );
            touchPadGroup.addActor( touchpad );
            touchPadGroup.setOrigin( Core.HEIGHT * 0.05f + Core.HEIGHT * 0.3f / 2,
                                     Core.HEIGHT * 0.05f + Core.HEIGHT * 0.3f / 2 );
        } else {
            touchpad.setPosition( Core.HEIGHT * 0.05f, Core.HEIGHT * 0.05f );
            touchPadGroup.addActor( touchpad );
            touchPadGroup.setOrigin( Core.HEIGHT * 0.05f + Core.HEIGHT * 0.3f / 2,
                                     Core.HEIGHT * 0.05f + Core.HEIGHT * 0.3f / 2 );
        }
        UIHelper.scaleIn( touchPadGroup );
        gameGroup.addActor( touchPadGroup );

        if ( jumpButton == null ) {
            jumpButton = new Image( IMG.JUMP_BUTTON.createSprite() );
            jumpButton.setSize( Core.HEIGHT * 0.24f, Core.HEIGHT * 0.24f );
            jumpButton.setPosition( Core.WIDTH - jumpButton.getWidth() * 1.3f,
                                    jumpButton.getHeight() * 0.9f );
            jumpButton.setOrigin( jumpButton.getWidth() / 2,
                                  jumpButton.getHeight() / 2 );

            jumpButton.addListener( new ClickListener() {
                @Override
                public void clicked ( InputEvent event, float x, float y ) {
                    if ( showGameOver ) {
                        return;
                    }
                    if ( MyPlayer.canJump ) {
                        MyPlayer.startJump();
                        UIHelper.clickAnimation( jumpButton );
                    }
                }
            } );
        }
        UIHelper.scaleIn( jumpButton );
        gameGroup.addActor( jumpButton );

        if ( attackButton == null ) {
            attackButton = new Image( IMG.HIT_BUTTON.createSprite() );
            attackButton.setSize( Core.HEIGHT * 0.24f, Core.HEIGHT * 0.24f );
            attackButton.setPosition( Core.WIDTH - attackButton.getWidth() * 2.5f,
                                      attackButton.getHeight() * 0.4f );
            attackButton.setOrigin( attackButton.getWidth() / 2,
                                    attackButton.getHeight() / 2 );

            attackButton.addListener( new ClickListener() {
                @Override
                public void clicked ( InputEvent event, float x, float y ) {
                    if ( showGameOver ) {
                        return;
                    }
                    if ( MyPlayer.canAttack ) {
                        MyPlayer.startAttack();
                        SoundAsset.HUU.play();
                        UIHelper.clickAnimation( attackButton );
                    }
                }
            } );
        }
        UIHelper.scaleIn( attackButton );
        gameGroup.addActor( attackButton );

        if ( aimImage == null ) {
            float aimSize = Core.HEIGHT * 0.1f;
            aimImage = IMG.AIM.getImageActor( aimSize, aimSize );
            aimImage.setPosition( Core.WIDTH_HALF - aimSize / 2, Core.HEIGHT_HALF - aimSize / 2 );
        }
        gameGroup.addActor( aimImage );

        if ( interactGroup != null ) {
            interactGroup.clear();
        } else {
            interactGroup = new Group();
        }
        interactGroup.setPosition( Core.WIDTH_HALF, Core.HEIGHT * 0.3f );

        gameGroup.addActor( interactGroup );

        float inGameIconSize = Core.HEIGHT * 0.16f;

        if ( showIngameMenuImage == null ) {
            showIngameMenuImage = IMG.INGAME.getImageActor( inGameIconSize,
                                                            inGameIconSize );
            showIngameMenuImage.setPosition( Core.WIDTH - inGameIconSize,
                                             Core.HEIGHT - inGameIconSize );
            showIngameMenuImage.addListener( new ClickListener() {
                public void clicked ( InputEvent event, float x, float y ) {
                    if ( showGameOver ) {
                        return;
                    }
                    SoundAsset.Click.play();
                    UIHelper.clickAnimation( showIngameMenuImage );
                    showInGameMenu();
                }
            } );
        }
        gameGroup.addActor( showIngameMenuImage );
    }


    @Override
    public void backButton () {
        SoundAsset.BackSound.play();
        if ( guiType == GUI_TYPE.INGAME_MENU ) {
            showGameGUI();
        } else {
            touchPadGroup.clearActions();
            jumpButton.clearActions();
            UIHelper.scaleOut( touchPadGroup );
            UIHelper.scaleOut( jumpButton );
            transitionTo( MyGdxGame.SCREEN_TYPE.MENU );
        }
    }


    @Override
    public void dispose () {
        super.dispose();

        textDecalSystem = null;
        AshleyWorld.getEngine().getSystem( NPCSystem.class ).disableWalkSound();

        MyPlayer.stopSound();
        MusicAsset.stopEnvironment();

        jumpButton = null;
        touchpad = null;
        indicatorGroup = null;
        touchPadGroup = null;
        gameGroup = null;

        interactSystem = null;
    }


    private enum GUI_TYPE {
        GAME_GUI,
        INGAME_MENU
    }
}
