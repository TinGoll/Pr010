package com.artworld.game.world.entities;

import com.artworld.game.world.GameMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pet extends Creature {

    private EntityType entityType;


    public void create(EntityType entityType, float x, float y, GameMap map){
        create(new EntitySnapshot(entityType.getId(), x, y), map);
    }
    public void create(int id, float x, float y, GameMap map){
        create(new EntitySnapshot(id, x, y), map);
    }
    @Override
    public void create(EntitySnapshot snapshot, GameMap map) {
        super.create(snapshot, map);
        entityType = snapshot.getEntityType();
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
