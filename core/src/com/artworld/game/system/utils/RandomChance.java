package com.artworld.game.system.utils;

import java.util.HashMap;
import java.util.Map;

public class RandomChance {


    Map<Integer, Integer> numbers = new HashMap();
    int chanseSum = 0;

    public void add(int nomber, int chance){
        numbers.put(nomber, chance);
        chanseSum += chance;
    }

    public Integer randome (){
        int cube =(int)(Math.random() * chanseSum) + 1;

        int b=0;

        for(int i: numbers.keySet()){
            b += numbers.get(i);
            if(b >= cube)return i;
        }
        return null;
    }

}
