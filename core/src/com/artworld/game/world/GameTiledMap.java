package com.artworld.game.world;

import com.artworld.game.Application;
import com.artworld.game.states.BaseState;
import com.artworld.game.states.PlayState;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class GameTiledMap extends GameMap {

    private TiledMap map;
    private OrthogonalTiledMapRenderer tmr;


    @Override
    public void create(Application app) {
        this.app = app;
        this.state = (PlayState) app.getGsm().getCurrentState();
        world = createWorld();
        b2dr = new Box2DDebugRenderer();
        map = state.getTiledMapAsset().get();
        tmr = new OrthogonalTiledMapRenderer(map);
    }
    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(layer)).getCell(col, row);
        if (cell != null) {
            TiledMapTile tile = cell.getTile();
            if (tile != null) {
                int id = tile.getId();
                return TileType.getTileTypeById(id);
            }
        }
        return null;
    }
    @Override
    public int getWidth() {
        return ((TiledMapTileLayer) map.getLayers().get(0)).getWidth();
    }
    @Override
    public int getHeight() {
        return ((TiledMapTileLayer) map.getLayers().get(0)).getHeight();
    }
    @Override
    public int getLayers() {
        return map.getLayers().getCount();
    }
    @Override
    public TiledMap getTiledMap() {
        return map;
    }
    @Override
    public BaseState getState() {
        return state;
    }
    @Override
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        super.render(camera, batch);
        tmr.setView(camera);
        tmr.render();
        b2dr.render(world, camera.combined);
    }
    @Override
    public void update(float delta) {
        super.update(delta);

    }
    @Override
    public void dispose() {
        super.dispose();
        map.dispose();
        tmr.dispose();
    }
    @Override
    public Application getApp() {
        return app;
    }
}
