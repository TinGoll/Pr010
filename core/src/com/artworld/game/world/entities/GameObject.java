package com.artworld.game.world.entities;

import com.artworld.game.world.GameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {

    protected Vector2 position;
    protected EntityType entityType;
    protected GameMap map;


    public void create(EntitySnapshot snapshot, GameMap map){
        this.position = snapshot.getPosition();
        this.entityType = snapshot.getEntityType();
        this.map = map;
    }

    public void update (float delta){

    }

    public abstract void render(SpriteBatch batch);

    public Vector2 getPosition() {
        return position;
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }


}
