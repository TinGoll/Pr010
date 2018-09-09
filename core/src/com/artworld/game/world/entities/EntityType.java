package com.artworld.game.world.entities;

import com.artworld.game.system.utils.RandomChance;

import java.util.HashMap;

public enum EntityType {

    KAT(1, 64, 64, 1.5f, Type.CREATURE, 50),
    DOG(2, 64, 64, 2.3f, Type.CREATURE, 30),
    TURTLE(3, 64, 64, 2, Type.CREATURE, 20);


    public enum Type {
        ITEM,
        CREATURE,
        CREATURE_ENEMY,
        PLAYER;
    }
    private Type type;
    private int id;
    private int width;
    private int height;
    private float weight;
    private int chance;
    private static HashMap<Integer, EntityType> entityTypes;

    EntityType(int id, int width, int height, float weight, Type type, int chance) {

        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public float getWeight() {
        return weight;
    }
    public int getChance() {
        return chance;
    }

    public static EntityType getEntityType(Integer id){
        if(entityTypes.containsKey(id)){
            return entityTypes.get(id);
        }
        return null;
    }
    public static EntityType getRandomEntityTupe(){
        RandomChance randomChance = new RandomChance();
        for(EntityType type : EntityType.values()){
            randomChance.add(type.getId(), type.getChance());
        }
        return getEntityType(randomChance.randome());
    }
    public Type getType() {
        return type;
    }
    public static HashMap<Integer, EntityType> getEntityTypes() {
        return entityTypes;
    }


    static {
        entityTypes = new HashMap<Integer, EntityType>();
        for(EntityType type : EntityType.values()){
            entityTypes.put(type.id, type);
        }
    }
}
