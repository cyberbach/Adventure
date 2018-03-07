package net.overmy.adventure.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import net.overmy.adventure.MyGdxGame;

public class DesktopLauncher {


    public static void main( String[] arg ) {
        /*
        String myRussianUserName = "\\xD0\\x90\\xD0\\xBD\\xD0\\xB4\\xD1\\x80\\xD0\\xB5\\xD0\\xB9";
        System.setProperty( "user.name", myRussianUserName );
*/
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        SCREEN_CFG screenConfig = SCREEN_CFG.DEFAULT;
        screenConfig.setScreenOrientation( SCREEN_ORIENTATION.LANDSCAPE );

        config.width = screenConfig.getWidth();
        config.height = screenConfig.getHeight();
        String appName = DesktopLauncher.class.getPackage().getName();
        config.title = "" + appName + " [ " + config.width + " x " + config.height + " ]";

        new LwjglApplication( new MyGdxGame(), config );
    }



    private enum SCREEN_ORIENTATION {
        PORTRAIT,
        LANDSCAPE
    }


    private enum SCREEN_CFG {
        DEMO( 1280, 720 ),
        GALAXY_TAB2( 1024, 554 ),// not 600
        SQUARE( 1024, 768 ),
        FULL_HD( 1920, 1080 ),
        SMALL( 320, 240 ),
        SCREEN_SHOT( 1024, 500 ),
        DEFAULT( 800, 480 );

        private final int width;
        private final int height;
        private SCREEN_ORIENTATION screenOrientation;



        SCREEN_CFG( final int width, final int height ) {
            this.width = width;
            this.height = height;
        }



        public void setScreenOrientation( SCREEN_ORIENTATION screenOrientation ) {
            this.screenOrientation = screenOrientation;
        }



        public int getWidth() {
            return screenOrientation.equals( SCREEN_ORIENTATION.LANDSCAPE ) ? width : height;
        }



        public int getHeight() {
            return screenOrientation.equals( SCREEN_ORIENTATION.LANDSCAPE ) ? height : width;
        }
    }
}
