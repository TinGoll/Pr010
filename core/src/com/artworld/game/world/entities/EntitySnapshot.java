package com.artworld.game.world.entities;

import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class EntitySnapshot {

    public Integer id;
    public float x, y;
    public HashMap<String, String> data;

    public EntitySnapshot(){}
    public EntitySnapshot(Integer id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
        data = new HashMap<String, String>();
    }

    public EntityType getEntityType(){
       return EntityType.getEntityType(id);
    }
    public Integer getId() {
        return id;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public HashMap<String, String> getData() {
        return data;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public Vector2 getPosition(){
        return new Vector2(getX(), getY());
    }
    public void putFloat (String key, float value) {
        data.put(key, "" + value);
    }
    public void putLong (String key, long value) {
        data.put(key, "" + value);
    }
    public void putInt (String key, int value) {
        data.put(key, "" + value);
    }
    public void putBoolean (String key, boolean value) {
        data.put(key, "" + value);
    }
    public void putString (String key, String value) {
        data.put(key, value);
    }

    public float getFloat (String key, float defaultValue) {
        if (data.containsKey(key)) {
            try {
                return Float.parseFloat(data.get(key));
            } catch (Exception e) {
                return defaultValue;
            }
        } else
            return defaultValue;
    }


    public long getLong (String key, long defaultValue) {
        if (data.containsKey(key)) {
            try {
                return Long.parseLong(data.get(key));
            } catch (Exception e) {
                return defaultValue;
            }
        } else
            return defaultValue;
    }

    public int getInt (String key, int defaultValue) {
        if (data.containsKey(key)) {
            try {
                return Integer.parseInt(data.get(key));
            } catch (Exception e) {
                return defaultValue;
            }
        } else
            return defaultValue;
    }
    public boolean getBoolean (String key, boolean defaultValue) {
        if (data.containsKey(key)) {
            try {
                return Boolean.parseBoolean(data.get(key));
            } catch (Exception e) {
                return defaultValue;
            }
        } else
            return defaultValue;
    }
    public String getString (String key, String defaultValue) {
        if (data.containsKey(key)) {
            return data.get(key);
        } else
            return defaultValue;
    }
}
