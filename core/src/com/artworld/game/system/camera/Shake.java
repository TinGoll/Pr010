package com.artworld.game.system.camera;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Shake {

    private float[] samples;
    private Random rand = new Random();
    private float internalTimer = 0;
    private   float shakeDuration = 0;
    private int duration = 5; // Секунд тряски
    private int hz = 60; // Герцы
    private float amplitude = 20; // амплитуда
    private boolean falloff = true; // плавное убывание
    private int sampleCount;



    public Shake(){
        sampleCount = duration * hz;
        samples = new float[sampleCount];
        for (int i =0; i < sampleCount; i++){
            samples[i] = rand.nextFloat() * 2f - 1f;
        }
    }

    /**
     * Вызывается, каждый кадр .
     * @param delta Gdx.graphics.getDeltaTime()
     * @param camera камера
     * @param center позиция
     */
    public void update(float delta, Camera camera, Vector2 center){
        internalTimer += delta;
        if (internalTimer > duration) internalTimer -= duration;
        if (shakeDuration > 0){
            shakeDuration -= delta;
            float shakeTime = (internalTimer * hz);
            int first = (int)shakeTime;
            int second = (first + 1)%sampleCount;
            int third = (first + 2)%sampleCount;
            float deltaT = shakeTime - (int)shakeTime;
            float deltaX = samples[first] * deltaT + samples[second] * ( 1f - deltaT);
            float deltaY = samples[second] * deltaT + samples[third] * ( 1f - deltaT);

            camera.position.x = center.x + deltaX * amplitude * (falloff ? Math.min(shakeDuration, 1f) : 1f);
            camera.position.y = center.y + deltaY * amplitude * (falloff ? Math.min(shakeDuration, 1f) : 1f);
            camera.update();
        }
    }

    /**
     * задать длительность встряххивания
     * @param d секунды.
     */
    public void shake(float d){
        shakeDuration = d;
    }

    public void setHz(int hz) {
        if(hz <=60){
            this.hz = hz;
        }else{
            this.hz = 60;
        }

    }
    public void setAmplitude(float amplitude) {
        this.amplitude = amplitude;
    }
    public void setFalloff(boolean falloff) {
        this.falloff = falloff;
    }
}
