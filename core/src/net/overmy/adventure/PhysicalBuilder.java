package net.overmy.adventure;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.physics.bullet.collision.Collision;
import com.badlogic.gdx.physics.bullet.collision.PHY_ScalarType;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btBvhTriangleMeshShape;
import com.badlogic.gdx.physics.bullet.collision.btCapsuleShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btConvexHullShape;
import com.badlogic.gdx.physics.bullet.collision.btCylinderShape;
import com.badlogic.gdx.physics.bullet.collision.btIndexedMesh;
import com.badlogic.gdx.physics.bullet.collision.btTriangleIndexVertexArray;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody.btRigidBodyConstructionInfo;
import com.badlogic.gdx.physics.bullet.linearmath.btDefaultMotionState;
import com.badlogic.gdx.physics.bullet.linearmath.btMotionState;

import net.overmy.adventure.ashley.components.BVHPhysicalComponent;
import net.overmy.adventure.ashley.components.PhysicalComponent;

import java.nio.FloatBuffer;

/*
     Created by Andrey Mikheev on 30.09.2017
     Contact me → http://vk.com/id17317
 */

public class PhysicalBuilder {

    private Vector3                     inertia             = null;
    private float                       mass                = 0.0f;
    private ModelInstance               modelInstance       = null;
    private btMotionState               motionState         = null;
    private btCollisionShape            bodyShape           = null;
    private btIndexedMesh               indexedMesh         = null;
    private btTriangleIndexVertexArray  meshInterface       = null;
    private int                         collisionFlag       = 0;
    private int                         callbackFlag        = 0;
    private int                         callbackFilter      = 0;
    private boolean                     deactivationFlag    = false;
    private boolean                     disableRotationFlag = false;
    private Vector3                     startImpulse        = null;
    private float                       scale               = 1.0f;
    private Vector3                     position            = null;
    private btRigidBody                 savedBody           = null;
    private btRigidBodyConstructionInfo savedInfo           = null;


/*
    PhysicalBuilder setPosition( Vector3 newPosition ) {
        Matrix4 matrix4 = savedBody.getWorldTransform();
        matrix4.setToTranslation( newPosition );
        savedBody.setWorldTransform( matrix4 );

        return this;
    }*/


    PhysicalBuilder setScale ( float scale ) {
        this.scale = scale;
        if ( scale != 1.0f ) {
            for ( Node node : modelInstance.nodes ) {
                node.scale.set( new Vector3( scale, scale, scale ) );
            }
        }
        return this;
    }


    public PhysicalBuilder setRotation ( float p, float r, float y ) {
        for ( Node node : modelInstance.nodes ) {
            if ( p != 0.0f ) {
                node.rotation.set( Vector3.X, p );
            }
            if ( r != 0.0f ) {
                node.rotation.set( Vector3.Y, r );
            }
            if ( y != 0.0f ) {
                node.rotation.set( Vector3.Z, y );
            }
        }

        return this;
    }


    public PhysicalBuilder setCollisionFlag ( int collisionFlag ) {
        this.collisionFlag = collisionFlag;
        return this;
    }


    public PhysicalBuilder setPosition ( Vector3 position ) {
        this.position = new Vector3( position );
        return this;
    }


    public PhysicalBuilder setCallbackFlag ( int callbackFlag ) {
        this.callbackFlag = callbackFlag;
        return this;
    }


    public PhysicalBuilder setCallbackFilter ( int callbackFilter ) {
        this.callbackFilter = callbackFilter;
        return this;
    }




    public PhysicalBuilder capsuleShape( float radius, float height ) {
        // 1.1 = 0.5 + 0.2 + 0.5
        // 1.1 = 0.15 + 0.8 + 0.15
        bodyShape = new btCapsuleShape( radius, height );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }



    public PhysicalBuilder capsuleShape () {
        BoundingBox box = new BoundingBox();
        modelInstance.calculateBoundingBox( box );
        Vector3 boxSize = new Vector3();
        box.getMax( boxSize );

        float radius = boxSize.x > boxSize.z ? boxSize.x : boxSize.z;
        float height = boxSize.y > 2 * radius ? boxSize.y - 2 * radius : 0;

        bodyShape = new btCapsuleShape( radius, height );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }


    public PhysicalBuilder cylinderShape ( float radius, float height ) {
        Vector3 halfExtents = new Vector3( radius, height, radius );
        bodyShape = new btCylinderShape( halfExtents );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }


    public PhysicalBuilder boxShape () {
        BoundingBox box = new BoundingBox();
        modelInstance.calculateBoundingBox( box );
        Vector3 boxSize = new Vector3();
        box.getMax( boxSize );

        bodyShape = new btBoxShape( boxSize );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }


    public PhysicalBuilder boxShape ( float size ) {
        Vector3 boxSize = new Vector3();
        boxSize.set( 1, 1, 1 ).scl( size );

        bodyShape = new btBoxShape( boxSize );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }


    public PhysicalBuilder hullShape () {
        final Mesh mesh = modelInstance.model.meshes.first();
        final FloatBuffer buffer = mesh.getVerticesBuffer();
        final int numVertices = mesh.getNumVertices();
        final int stride = mesh.getVertexSize(); // шаг
        // Замкнутая форма
        bodyShape = new btConvexHullShape( buffer, numVertices, stride );
        bodyShape.calculateLocalInertia( mass, inertia );
        return this;
    }


    public PhysicalBuilder bvhShape () {
        indexedMesh = calcIndexedMesh( modelInstance );
        meshInterface = new btTriangleIndexVertexArray();
        meshInterface.addIndexedMesh( indexedMesh, PHY_ScalarType.PHY_SHORT );
        // Bounding volume hierarchy
        bodyShape = new btBvhTriangleMeshShape( meshInterface, true, true );
        return this;
    }


    public PhysicalBuilder setModelInstance ( ModelInstance instance ) {
        modelInstance = instance;
        return this;
    }


    public PhysicalBuilder defaultMotionState () {
        motionState = new btDefaultMotionState();
        return this;
    }


    public PhysicalBuilder zeroMass () {
        mass = 0.0f;
        inertia = Vector3.Zero;
        return this;
    }


    public PhysicalBuilder setMass ( float mass ) {
        this.mass = mass;
        inertia = new Vector3();
        return this;
    }


    public PhysicalBuilder setStartImpulse ( Vector3 impulse ) {
        startImpulse = new Vector3( impulse );
        return this;
    }



/*

    btRigidBodyConstructionInfo getSavedInfo() {
        return savedInfo;
    }
*/


    public PhysicalBuilder disableDeactivation () {
        disableRotation();
        deactivationFlag = true;
        return this;
    }


    private void disableRotation () {
        disableRotationFlag = true;
    }


    public PhysicalBuilder build () {
        final btRigidBodyConstructionInfo constructionInfo = new btRigidBodyConstructionInfo(
                mass,
                motionState,
                bodyShape,
                inertia );

        savedInfo = constructionInfo;


        // Создание физического тела
        final btRigidBody body = new btRigidBody( constructionInfo );

        // Размещаем физическое тело
        if ( modelInstance != null ) {
            body.proceedToTransform( modelInstance.transform );
            modelInstance.transform.scl( scale,scale,scale );
        }
        if ( position != null ) {
            body.proceedToTransform( new Matrix4().translate( position ) );
        }

        body.setCollisionFlags( body.getCollisionFlags() | collisionFlag );
        body.setContactCallbackFlag( callbackFlag );
        body.setContactCallbackFilter( callbackFilter );
/*
        body.setAnisotropicFriction( new Vector3(  ),
                                     btCollisionObject.AnisotropicFrictionFlags.CF_ANISOTROPIC_ROLLING_FRICTION );
*/

        if ( disableRotationFlag ) {
            body.setDamping( 0, 0 );
            body.setAngularFactor( 0 );
        }

        if ( deactivationFlag ) {
            body.setActivationState( Collision.DISABLE_DEACTIVATION );
            //body.forceActivationState( Collision.ACTIVE_TAG );
        }

        if ( scale != 1.0f ) {
            body.getCollisionShape().setLocalScaling( new Vector3( scale, scale, scale ) );
        }

        if ( startImpulse != null ) {
            body.applyCentralImpulse( startImpulse );
        }

        savedBody = body;

        return this;
    }


    public PhysicalComponent buildPhysicalComponent () {
        build();
        return new PhysicalComponent( savedBody, savedInfo );
    }


    public btRigidBody getSavedBody () {
        return savedBody;
    }


    public BVHPhysicalComponent buildBVHPhysicalComponent () {
        return new BVHPhysicalComponent( indexedMesh, meshInterface );
    }


    private btIndexedMesh calcIndexedMesh ( ModelInstance instance ) {
        final Mesh mesh = instance.model.meshes.first();

        final short[] indices = new short[ mesh.getNumIndices() ];
        final float[] vertices = new float[ mesh.getNumVertices() * mesh.getVertexSize() / 4 ];

        mesh.getIndices( indices );
        mesh.getVertices( vertices );

        final btIndexedMesh indexedMesh = new btIndexedMesh();
        indexedMesh.setNumTriangles( mesh.getNumIndices() / 3 );
        indexedMesh.setNumVertices( mesh.getNumVertices() );
        indexedMesh.setVertexStride( mesh.getVertexSize() );
        indexedMesh.setVertexType( PHY_ScalarType.PHY_FLOAT );
        indexedMesh.setTriangleIndexStride( 6 );
        indexedMesh.setTriangleIndexBase( mesh.getIndicesBuffer() );
        indexedMesh.setVertexBase( mesh.getVerticesBuffer() );

        return indexedMesh;
    }
}
