package com.artworld.game.system.managers;

import com.artworld.game.world.entities.Creature;

import static com.artworld.game.system.Constants.*;


public class StateManager {

    private Creature creature;
    private Boolean isCaloricIntake = true;
    private float stopwatch;

    public StateManager(Creature creature) {
        this.creature = creature;
    }
    public void update (float delta){
        CaloricIntake(delta);



    }
    private void CaloricIntake(float delta){
        if(isCaloricIntake){
            stopwatch+=delta;
            if(stopwatch>=1) {
                takeCalories(CALORIES_PER_HOUR * creature.getEntityType().getWeight());
                stopwatch = 0;
                //System.out.println(creature.getEntityType());
                //System.out.println(creature.getCalories());
            }
        }
    }
    public float getAgeInWeek(){
        return getAgeInDays() / DAYS_A_WEEK;
    }
    public float getAgeInDays(){
        return getAgeSecond() / SECOND_IN_A_DAY;
    }
    public float getAgeSecond (){
        return  (System.currentTimeMillis() - creature.getDOB()) / 1000;
    }

    private Boolean takeCalories(float amount){
        if((creature.getCalories() - amount)>=0){
            creature.setCalories(creature.getCalories() - amount);
            return true;
        }else {
            creature.setCalories(0);
            return false;
        }
    }
    private void addCalories(float amount){
        creature.setCalories(creature.getCalories() + amount);
    }

    public Boolean getCaloricIntake() {
        return isCaloricIntake;
    }
    public void setCaloricIntake(Boolean caloricIntake) {
        isCaloricIntake = caloricIntake;
    }


}
