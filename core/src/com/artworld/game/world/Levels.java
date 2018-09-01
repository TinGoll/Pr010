package com.artworld.game.world;

import com.artworld.game.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.util.HashMap;

public enum Levels {
    // для добавления новой карты, внести новый ENUM, с соответствующими характеристиками.
    HOME(1, "maps/map.tmx", "home", GameTiledMap.class),
    FOREST(2, "maps/map2.tmx",  "forest",  GameTiledMap.class);

    private int id;
    private String path;
    private String nameKey;
    private Class loaderClass;
    private static HashMap<Integer, Levels> levels;

    /**
     *
     * @param id Порядковый номер карты
     * @param path путь к tmx файлу карты
     * @param loaderClass клас загрузчик для карты.
     */
    Levels(int id, String path, String nameKey, Class loaderClass) {
        this.id = id;
        this.path = path;
        this.nameKey = nameKey;
        this.loaderClass = loaderClass;

    }
    static {
        levels = new HashMap<Integer, Levels>();
        for(Levels levels : Levels.values()){
            Levels.levels.put(levels.id, levels);
        }
    }
    public int getId() {
        return id;
    }
    public String getPath() {
        return path;
    }
    public String getNameKey() {
        return nameKey;
    }
    public Class getLoaderClass() {
        return loaderClass;
    }
    public static HashMap<Integer, Levels> getLevels() {
        return levels;
    }
    public static Levels getLevel(int id){
        return levels.get(id);
    }
    public static Levels getRandomLevel(){
        return levels.get(Levels.values()[MathUtils.random(1, Levels.values().length - 1)].getId());
    }
    public static GameMap createMap(Application app){
        Levels level = GameMap.getCurrentLevel();
        try {
            @SuppressWarnings("unchecked")
            GameMap gameMap = (GameMap) ClassReflection.newInstance(level.loaderClass);
            gameMap.create(app);
            return gameMap;
        } catch (ReflectionException e) {
            Gdx.app.error("Загрузчик карт", "Не удалось загрузить уровень: " + level.name());
            return null;
        }
    }

}
