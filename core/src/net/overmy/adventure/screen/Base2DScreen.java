package net.overmy.adventure.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import net.overmy.adventure.Core;
import net.overmy.adventure.MyGdxGame;
import net.overmy.adventure.MyGdxGame.SCREEN_TYPE;
import net.overmy.adventure.MyRender;

/*
     Created by Andrey Mikheev on 29.09.2017
     Contact me → http://vk.com/id17317
 */

class Base2DScreen implements Screen, GestureDetector.GestureListener {

    private final MyGdxGame game;
    protected float       xTouch        = 0.0f;
    protected float       yTouch        = 0.0f;
    private   boolean     buttonClicked = false;
    private   SCREEN_TYPE nextScreen    = null;



    Base2DScreen( MyGdxGame game ) {
        this.game = game;
    }



    @Override
    public void show() {
        MyRender.TransitionIN();
        setInputProcessors();
    }



    @Override
    public void render( float delta ) {
        update( delta );

        draw( delta );
        MyRender.getStage().draw();
        drawOverStage( delta );

        MyRender.drawTransitionScreen( delta );
        if ( nextScreen != null && !MyRender.inTransition() ) {
            switchCurrentScreen();
        }
    }



    @Override
    public void resize( int width, int height ) {}



    @Override
    public void pause() {

    }



    @Override
    public void resume() {}



    @Override
    public void hide() {

    }



    @Override
    public void dispose() {
        MyRender.getStage().clear();
    }



    public boolean touchDragged( float x, float y ) {
        return false;
    }



    private void setInputProcessors() {
        InputProcessor keys = new MyKeysProcessor();
        InputProcessor gestures = new GestureDetector( this );
        InputProcessor processor = new InputMultiplexer( MyRender.getStage(), keys, gestures );
        Gdx.input.setInputProcessor( processor );
        Gdx.input.setCatchBackKey( true );
        Gdx.input.setCatchMenuKey( true );
    }



    public void draw( float delta ) {
    }



    public void drawOverStage( float delta ) {
    }


/*

    private void drawBlackScreen( float delta ) {
        if ( inTransition() ) {
            float r = 0;
            float g = 0;
            float b = 0;
            Sprite blackSprite = MyRender.getBlackFullScreen();
            Batch batch = MyRender.getSpriteBatch();
            batch.begin();
            batch.setColor( r, g, b, 1 - transition.getCurrent() );
            batch.draw( blackSprite, 0, 0, Core.WIDTH, Core.HEIGHT );
            batch.end();
        }
        // Этот апдейт должен быть здесь, чтобы избежать ситуации
        // когда в момент перехода экранов на секунду появляется предыдущая сцена
        transition.update( delta );
        if ( nextScreen != null && !inTransition() ) {
            switchCurrentScreen();
        }
    }




    /**
     * true - экраны переключаются
     * false - экраны не переключаются

    private boolean inTransition() {
        return transition.isNeedToUpdate();
    }
*/



    public void update( float delta ) {
        MyRender.getStage().act( delta );
    }



    /**
     * Включаем переключение экрана. Время перехода (Core.FADE)
     */
    void transitionTo( MyGdxGame.SCREEN_TYPE screen ) {
        if ( nextScreen != null ) {
            return;
        }
        MyRender.TransitionOUT();
        nextScreen = screen;
    }



    private void switchCurrentScreen() {
        game.switchTo( nextScreen );
    }



    @Override
    public boolean touchDown( float x, float y, int pointer, int button ) {
        xTouch = x;
        yTouch = Core.HEIGHT - y;
        return true;
    }



    @Override
    public boolean tap( float x, float y, int count, int button ) {
        return false;
    }



    @Override
    public boolean longPress( float x, float y ) {
        return false;
    }



    @Override
    public boolean fling( float velocityX, float velocityY, int button ) {
        return false;
    }



    @Override
    public boolean pan( float x, float y, float deltaX, float deltaY ) {
        return true;
    }



    @Override
    public boolean panStop( float x, float y, int pointer, int button ) {
        return false;
    }



    @Override
    public boolean zoom( float initDistance, float distance ) {
        return false;
    }



    @Override
    public boolean pinch( Vector2 initPointer1, Vector2 initPointer2, Vector2 pointer1,
                          Vector2 pointer2 ) {
        return false;
    }



    @Override
    public void pinchStop() {
    }



    protected boolean touchUp( float x, float y, int pointer, int button ) {
        return false;
    }



    protected boolean scrolled( int amount ) {
        return false;
    }



    public void backButton() {
        if ( buttonClicked ) {
            return;
        }
        buttonClicked = true;

        // Default transition to MENU
        transitionTo( SCREEN_TYPE.MENU );
    }



    private boolean keyDown( int keycode ) {
        return false;
    }



    private boolean keyUp( int keycode ) {
        return false;
    }



    private class MyKeysProcessor implements InputProcessor {

        @Override
        public boolean keyDown( int keycode ) {
            if ( !MyRender.inTransition() ) {
                boolean escapePressed = keycode == Input.Keys.ESCAPE;
                boolean backPressed = keycode == Input.Keys.BACK;

                if ( escapePressed || backPressed ) {
                    backButton();
                }
                else {
                    Base2DScreen.this.keyDown( keycode );
                }
            }
            return false;
        }



        @Override
        public boolean keyUp( int keycode ) {
            Base2DScreen.this.keyUp( keycode );
            return false;
        }



        @Override
        public boolean keyTyped( char character ) {
            return false;
        }



        @Override
        public boolean touchDown( int screenX, int screenY, int pointer, int button ) {
            xTouch = screenX;
            yTouch = Core.HEIGHT - screenY;
            return false;
        }



        @Override
        public boolean touchUp( int screenX, int screenY, int pointer, int button ) {
            return Base2DScreen.this.touchUp( screenX, Core.HEIGHT - screenY, pointer, button );
        }



        @Override
        public boolean touchDragged( int screenX, int screenY, int pointer ) {
            return Base2DScreen.this.touchDragged( xTouch - screenX,
                                                   yTouch - Core.HEIGHT + screenY );
        }



        @Override
        public boolean mouseMoved( int screenX, int screenY ) {
            return false;
        }



        @Override
        public boolean scrolled( int amount ) {
            return Base2DScreen.this.scrolled( amount );
        }
    }
}
