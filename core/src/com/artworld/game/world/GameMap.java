package com.artworld.game.world;

import com.artworld.game.Application;
import com.artworld.game.states.BaseState;
import com.artworld.game.states.PlayState;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public abstract class GameMap {

    protected World world;
    protected Box2DDebugRenderer b2dr;
    protected PlayState state;
    protected Application app;

    public static Levels currentLevel;

    public void render (OrthographicCamera camera, SpriteBatch batch) {

    }

    public void update (float delta) {
        world.step(1 / 60f, 6 , 2);
    }

    public void dispose () {
        world.dispose();
        b2dr.dispose();
    }

    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }
    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }
    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;
    }
    /** Создание нового мира без гравитации, мир спяший. */
    public World createWorld () {
        return createWorld(0);
    }
    /** Создание нового мира с указанием гравитации. */
    public World createWorld (float gravity) {
        return new World(new Vector2(0, gravity), true);
    }
    public World getWorld() {
        return world;
    }

    public static float pixelsToMeters (int pixels) {
        return (float)pixels * 0.01f;
    }
    public static int metersToPixels (float meters) {
        return (int)(meters * 100.0f);
    }

    public static Levels getCurrentLevel() {
        if(currentLevel == null)
            setCurrentLevel(Levels.getLevel(1));
        return currentLevel;
    }
    public void setWorld(World world) {
        this.world = world;
    }
    public static void setCurrentLevel(Levels currentLevel) {
        GameMap.currentLevel = currentLevel;
    }

    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();
    public abstract TiledMap getTiledMap();
    public abstract void create(Application app);
    public abstract BaseState getState();
    public abstract Application getApp();


}
