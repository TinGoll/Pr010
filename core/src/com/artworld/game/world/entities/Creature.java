package com.artworld.game.world.entities;


import com.artworld.game.system.managers.StateManager;
import com.artworld.game.world.GameMap;

public abstract class Creature extends GameObject {

   protected int years; // сколько лет
   protected long DOB; //дата рождения
   protected float calories; // Калории
   protected StateManager stateManager;



    @Override
    public void create(EntitySnapshot snapshot, GameMap map) {
        super.create(snapshot, map);
        this.years = snapshot.getInt("years", 0);
        this.DOB = snapshot.getLong("DOB", System.currentTimeMillis());
        this.calories = snapshot.getFloat("calories", 1000.00f);
        stateManager = new StateManager(this);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        stateManager.update(delta);
    }

    public int getYears() {
        return years;
    }
    public long getDOB() {
        return DOB;
    }
    public float getCalories() {
        return calories;
    }
    public void setCalories(float calories) {
        this.calories = calories;
    }

    public abstract EntityType getEntityType();
    public abstract void setEntityType(EntityType entityType);
    public float getAgeSecond(){
        return stateManager.getAgeSecond();
    }
    public float getAgeInDays(){
        return stateManager.getAgeInDays();
    }
}
