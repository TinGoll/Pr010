package com.artworld.game.world;

import java.util.HashMap;

public enum TileType {

    GRASS(34, true, "Grass"),
    DIRT(55, true, "Dirt");


    public static final int TILE_SIZE = 64;
    private int id;
    private boolean collidable;
    private String name;
    private float damage;
    private float structure;
    private static HashMap<Integer, TileType> tileMap;
    /**
     *
     * @param id Id тайла
     * @param collidable Являеться ли припятствием
     * @param name Имя тайла
     */
    private TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0, 0);
    }
    /**
     *
     * @param id Id тайла
     * @param collidable Являеться ли припятствием
     * @param name Имя тайла
     * @param damage Наносимый урон
     * @param structure Структура
     */
    private TileType(int id, boolean collidable, String name, float damage, float structure) {
        this.id = id;
        this.collidable = collidable;
        this.name= name;
        this.damage = damage;
        this.structure = structure;
    }
    public int getId() {
        return id;
    }
    public boolean isCollidable() {
        return collidable;
    }
    public String getName() {
        return name;
    }
    public float getDamage() {
        return damage;
    }
    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }
    public static TileType getTileTypeById (int id) {
        return tileMap.get(id);
    }
    public static int getTileSize() {
        return TILE_SIZE;
    }
    public static HashMap<Integer, TileType> getTileMap() {
        return tileMap;
    }
}
