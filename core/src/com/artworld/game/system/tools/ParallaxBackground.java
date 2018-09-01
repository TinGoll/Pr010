package com.artworld.game.system.tools;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roma on 09.12.2017.
 */

public class ParallaxBackground {
    private ParallaxLayer[] layers;
    private Vector2 speed = new Vector2();
    /**
     * @param layers  The  background layers
     * @param speed A Vector2 attribute to point out the x and y speed
     */
    public ParallaxBackground(ParallaxLayer[] layers,Vector2 speed){
        this.layers = layers;
        this.speed.set(speed);
    }
    public void render(float delta, SpriteBatch batch, Camera camera){
        camera.position.add(speed.x*delta,speed.y*delta, 0);
        for(ParallaxLayer layer:layers){
            batch.setProjectionMatrix(camera.projection);
            batch.begin();
            float currentX = - camera.position.x*layer.parallaxRatio.x % ( layer.region.getRegionWidth() + layer.padding.x) ;

            if( speed.x < 0 )currentX += -( layer.region.getRegionWidth() + layer.padding.x);
            do{
                float currentY = - camera.position.y*layer.parallaxRatio.y % ( layer.region.getRegionHeight() + layer.padding.y) ;
                if( speed.y < 0 )currentY += - (layer.region.getRegionHeight()+layer.padding.y);
                do{
                    batch.draw(layer.region,
                            -camera.viewportWidth/2+currentX + layer.startPosition.x ,
                            -camera.viewportHeight/2 + currentY +layer.startPosition.y);
                    currentY += ( layer.region.getRegionHeight() + layer.padding.y );
                }while( currentY < camera.viewportHeight);
                currentX += ( layer.region.getRegionWidth()+ layer.padding.x);
            }while( currentX < camera.viewportWidth);
            batch.end();
        }
    }
}
