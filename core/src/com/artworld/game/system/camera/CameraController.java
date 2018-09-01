package com.artworld.game.system.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class CameraController {

    public enum Commands {
        STOP,
        SnaptoTarget,
        lerpToTarget,
        lerpAverageBetweenTargets


    }

    private OrthographicCamera camera = null;
    private Vector2 targetA, targetB;
    private Array<Vector2> focalPoints;
    private boolean isBoundary = false;

    public CameraController(OrthographicCamera camera) {
        this.camera = camera;
    }
    public CameraController() {

    }


    public void update(float delta){



       if(isBoundary())
           boundary();
    }


    public void boundary(){
        if(!isEmpty()) {
            float startX = camera.viewportWidth / 2;
            float startY = camera.viewportHeight / 2;
        }
    }

    public boolean isBoundary() {
        return isBoundary;
    }
    public void setBoundary(boolean boundary) {
        isBoundary = boundary;
    }
    public OrthographicCamera getCamera() {
        return camera;
    }
    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
    public boolean isEmpty(){
        return camera == null ? true : false;
    }
    public Vector2 getTargetA() {
        return targetA;
    }
    public void setTargetA(Vector2 targetA) {
        this.targetA = targetA;
    }
    public Vector2 getTargetB() {
        return targetB;
    }
    public void setTargetB(Vector2 targetB) {
        this.targetB = targetB;
    }
    public Array<Vector2> getFocalPoints() {
        return focalPoints;
    }
    public void setFocalPoints(Array<Vector2> focalPoints) {
        this.focalPoints = focalPoints;
    }
}
