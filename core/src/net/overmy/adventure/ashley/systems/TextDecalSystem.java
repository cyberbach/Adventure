package net.overmy.adventure.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import net.overmy.adventure.MyCamera;
import net.overmy.adventure.MyRender;
import net.overmy.adventure.ashley.MyMapper;
import net.overmy.adventure.ashley.components.OutOfCameraComponent;
import net.overmy.adventure.ashley.components.TextDecalComponent;
import net.overmy.adventure.resources.FontAsset;
import net.overmy.adventure.utils.UIHelper;


/**
 * Created by Andrey (cb) Mikheev
 * 20.12.2016
 */

public class TextDecalSystem extends IteratingSystem {

    private final SpriteBatch batch;

    private final Matrix4 textTransform = new Matrix4();
    private final Matrix4 tmpMat4       = new Matrix4();

    private final Vector3 position = new Vector3();

    private Label textLabel = null;

    private Vector2 lastPlayerPosition = new Vector2();


    public void setLastPlayerPosition ( Vector2 lastPlayerPosition ) {
        this.lastPlayerPosition.set( lastPlayerPosition );
    }


    @SuppressWarnings( "unchecked" )
    public TextDecalSystem () {
        super( Family.all( TextDecalComponent.class )
                     .exclude( OutOfCameraComponent.class ).get() );

        this.batch = MyRender.getSpriteBatch();
    }


    public void init () {
        if ( textLabel == null ) {
            this.textLabel = UIHelper.Label( "b", FontAsset.MENU_TITLE );
        }
    }


    @Override
    protected void processEntity ( Entity entity, float delta ) {
        float time = MyMapper.TEXT_DECAL.get( entity ).time - delta;
        if ( time < 0 ) {
            batch.setProjectionMatrix( MyRender.getCamera().combined );
            entity.remove( TextDecalComponent.class );
            return;
        }
        MyMapper.TEXT_DECAL.get( entity ).time = time;

        Matrix4 transform = MyMapper.PHYSICAL.get( entity ).body.getWorldTransform();
        transform.getTranslation( position );

        lastPlayerPosition.sub( position.x, position.z );
        if ( lastPlayerPosition.len() > 7 ) {
            return;
        }

        String text = MyMapper.TEXT_DECAL.get( entity ).text.get();

        textLabel.setText( text );
        float textWidth = textLabel.getPrefWidth();

        position.add( 0, 2.0f, 0 ).scl( 100 );
        // Это позиция 3д-объекта, к которому привязан текст
        // Чуть сдвигаем текст вверх
        // Умножение на 100 нужно, чтобы правильно прибавилась позиция
        // в уменьшенной матрице

        textTransform.idt().scl( 0.01f );
        // Это Трансформация шрифта
        // Сначала сильно уменьшаем шрифт

        textTransform.translate( position );
        // Потом транслируем

        textTransform.rotate( Vector3.Y, MyCamera.getCameraAngle() );
        // А потом поворачиваем лицом к камере

        tmpMat4.set( MyCamera.get().combined ).mul( textTransform );
        // Домножаем матрицу камеры на нашу новую матрицу

        batch.setProjectionMatrix( tmpMat4 );
        batch.begin();
        FontAsset.MENU_TITLE.get().draw( batch, text, -textWidth / 2, 0 );
        batch.end();

        // Восстанавливаем матрицу камеры
        batch.setProjectionMatrix( MyRender.getCamera().combined );
    }
}
