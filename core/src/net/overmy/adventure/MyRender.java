package net.overmy.adventure;

/*
      Created by Andrey Mikheev on 03.10.2017
      Contact me → http://vk.com/id17317
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.g3d.decals.GroupStrategy;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.scenes.scene2d.Stage;

import net.overmy.adventure.resources.GameColor;
import net.overmy.adventure.utils.FloatAnimator;
import net.overmy.adventure.utils.GFXHelper;

public final class MyRender {
    private static Stage stage = null;

    private static SpriteBatch spriteBatch = null;
    private static DecalBatch  decalBatch  = null;
    private static ModelBatch  modelBatch  = null;

    private static Environment environment = null;

    private static OrthographicCamera camera = null;

    private static FloatAnimator transition      = null;
    private static Sprite        blackFullScreen = null; // этот спрайт перекрывает весь экран


    private MyRender () {
    }


    public static void init () {
        Core.resize( Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );

        camera = new OrthographicCamera();
        camera.setToOrtho( false, Core.WIDTH, Core.HEIGHT );

        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix( camera.combined );

        MyCamera.init();

        final GroupStrategy groupStrategy = new CameraGroupStrategy( MyCamera.get() );
        decalBatch = new DecalBatch( groupStrategy );

        blackFullScreen = GFXHelper.createSpriteRGB888( Core.WIDTH, Core.HEIGHT, Color.BLACK );
        transition = new FloatAnimator( 0, 1, Core.FADE );

        stage = new Stage();
        stage.setDebugAll( DEBUG.STAGE.get() );

        // 3d

        DefaultShader.Config config = new DefaultShader.Config();
        config.numDirectionalLights = 1;
        config.numPointLights = 0;
        config.numBones = 16;

        modelBatch = new ModelBatch( new DefaultShaderProvider( config ) );
        environment = new Environment();

        final Color ambientColor = new Color( 0.4f, 0.4f, 0.4f, 1.0f );
        final Attribute defaultEnvLight;
        defaultEnvLight = new ColorAttribute( ColorAttribute.AmbientLight, ambientColor );
        environment.set( defaultEnvLight );


        float r = GameColor.BG.get().r;
        float g = GameColor.BG.get().g;
        float b = GameColor.BG.get().b;

        final Attribute fog = new ColorAttribute( ColorAttribute.Fog, r, g, b, 1f );
        environment.set( fog );


        environment.add( MyCamera.getLight() );
    }


    public static OrthographicCamera getCamera () {
        return camera;
    }


    public static Stage getStage () {
        return stage;
    }


    public static SpriteBatch getSpriteBatch () {
        return spriteBatch;
    }


    public static DecalBatch getDecalBatch () {
        return decalBatch;
    }


    public static ModelBatch getModelBatch () {
        return modelBatch;
    }


    public static Environment getEnvironment () {
        return environment;
    }


    public static void TransitionIN () {
        transition.fromCurrent().setTo( 1 ).resetTime();
    }


    public static void TransitionOUT () {
        transition.fromCurrent().setTo( 0 ).resetTime();
    }


    public static boolean inTransition () {
        return transition.isNeedToUpdate();
    }


    public static void drawTransitionScreen ( float delta ) {
        if ( transition.isNeedToUpdate() ) {
            spriteBatch.begin();
            // red 1, green 1, blue 1 - обязательно, чтобы вывелся перекрывающий экран
            spriteBatch.setColor( 1, 1, 1, 1 - transition.getCurrent() );
            spriteBatch.draw( blackFullScreen, 0, 0, Core.WIDTH, Core.HEIGHT );
            spriteBatch.end();
        }
        // Этот апдейт должен быть здесь, чтобы избежать ситуации
        // когда в момент перехода экранов на секунду появляется предыдущая сцена
        transition.update( delta );
    }


    public static void dispose () {
        camera = null;

        spriteBatch.dispose();
        spriteBatch = null;

        decalBatch.dispose();
        decalBatch = null;

        blackFullScreen = null;

        stage.dispose();
        stage = null;

        transition = null;

        modelBatch.dispose();
        modelBatch = null;

        environment = null;
    }
}
