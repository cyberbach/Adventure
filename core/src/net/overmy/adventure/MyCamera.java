package net.overmy.adventure;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import net.overmy.adventure.utils.Vector3Animator;

/*
      Created by Andrey Mikheev on 29.09.2017
      Contact me → http://vk.com/id17317
 */

public class MyCamera {

    private static Vector3           cameraOffset        = new Vector3( 0, 1.4f, 4 );
    private static Vector3           cameraDirection     = new Vector3( 0, 0, -1 );
    private static Vector3           cameraPosition      = new Vector3( 0, 0, 0 );
    private static Vector3           frustumOffset       = new Vector3( 0, 0, 2 );
    private static Vector3           camPosition         = new Vector3();
    private static Vector3Animator   camMotion           = new Vector3Animator();
    private static Vector3           filteredPosition    = new Vector3();
    private static DirectionalLight  light               = null;
    private static float             cameraAngle         = 0.0f;
    private static PerspectiveCamera camera              = null;
    private static PerspectiveCamera cullingCamera       = null;
    private static float             filteredCameraAngle = 0.0f;


    private MyCamera () {
    }


    public static void init () {
        float backCullingDistance = 150.0f;// Задняя плоскость отсечения (дальность тумана)
        float defaultFOV = 58.0f; // Угол обзора (67 - стандартный)
        float cullingFOV = 70.0f;

        Vector3 upVector = new Vector3( 0, 10000, 0 );

        camera = new PerspectiveCamera( defaultFOV, Core.WIDTH, Core.HEIGHT );
        camera.near = 0.1f;
        camera.far = backCullingDistance;
        camera.up.set( upVector );

        cullingCamera = new PerspectiveCamera( cullingFOV, Core.WIDTH, Core.HEIGHT );
        cullingCamera.near = 0.1f;
        cullingCamera.far = backCullingDistance * 1.1f;
        cullingCamera.up.set( upVector );

        Color lightColor = new Color( 0.6f, 0.6f, 0.6f, 1.0f );
        light = new DirectionalLight();
        light.set( lightColor, 0, 0, 0 );
    }


    public static float getCameraAngle () {
        return cameraAngle;
    }


    public static PerspectiveCamera get () {
        return camera;
    }


    public static boolean isVisible ( Matrix4 matrix4 ) {
        matrix4.getTranslation( camPosition );
        return cullingCamera.frustum.pointInFrustum( camPosition );
    }


    private static void updateMotion ( float delta ) {
        camMotion.update( delta );
        if ( !camMotion.isNeedToUpdate() ) {
            float x = MathUtils.random( -0.2f, 0.2f );
            float y = MathUtils.random( 0.0f, 0.5f );
            float time = MathUtils.random( 8.0f, 12.0f );
            camMotion.fromCurrent().setTo( x, y, 0 );
            camMotion.setAnimationTime( time ).resetTime();
        }
    }


    public static void update ( float delta ) {
        updateMotion( delta );

        float ALPHA = 0.2f;//16
        filteredCameraAngle = filteredCameraAngle + ALPHA * ( cameraAngle - filteredCameraAngle );

        camera.position.set( cameraOffset );
        camera.position.add( camMotion.getCurrent() );
        camera.position.rotate( Vector3.Y, filteredCameraAngle );
        camera.position.add( cameraPosition );
        camera.direction.set( cameraDirection );
        camera.direction.rotate( Vector3.Y, filteredCameraAngle );
        camera.update();

        cullingCamera.position.set( cameraOffset );
        cullingCamera.position.add( frustumOffset );
        cullingCamera.position.rotate( Vector3.Y, filteredCameraAngle );
        cullingCamera.position.add( cameraPosition );
        cullingCamera.direction.set( camera.direction );
        cullingCamera.update();

        light.direction.set( 0, -1, -2 );
        light.direction.rotate( Vector3.Y, filteredCameraAngle );
    }


    static DirectionalLight getLight () {
        return light;
    }


    public static void addCameraAngle ( float nextCameraAngle ) {
        cameraAngle += nextCameraAngle;
    }


    public static void addVerticalDirection ( float y ) {
        float nextY = cameraDirection.y + y;
        if ( nextY > 0.25f || nextY < -0.4f ) {
            return;
        }
        cameraDirection.add( 0, y, 0 );
    }


    static void setCameraPosition ( Vector3 v3 ) {
        float ALPHA = 0.25f;
        filteredPosition.x = filteredPosition.x + ALPHA * ( v3.x - filteredPosition.x );
        filteredPosition.y = filteredPosition.y + ALPHA * ( v3.y - filteredPosition.y );
        filteredPosition.z = filteredPosition.z + ALPHA * ( v3.z - filteredPosition.z );

        cameraPosition.set( filteredPosition );
    }


    public static boolean isVisible ( BoundingBox boundingBox ) {
        return cullingCamera.frustum.boundsInFrustum( boundingBox );
    }


    public static boolean isVisible ( Vector3 testPosition ) {
        return cullingCamera.frustum.pointInFrustum( testPosition );
    }


    public void dispose () {
        camera = null;
        cullingCamera = null;
    }
}
