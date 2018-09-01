package com.artworld.game.system.asset;

import com.artworld.game.Application;
import com.artworld.game.states.BaseState;

public class BaseAsset<T> {

    protected Application app;
    protected String name;

    protected boolean loaded;
    protected Class<T> type;

    public BaseAsset(Application app, String name, Class<T> type) {
        this.app = app;
        this.name = name;
        this.type = type;
    }

    public void load() {
        app.getAssets().load(name, type);
        if (app.sDebug) {
            System.out.println("Грузим ресурс - " + name);
        }
    }
    public T get() {
        return app.getAssets().get(name, type);
    }
    public boolean isLoaded() {
        if (!loaded) {
            loaded = app.getCoreResources().manager.isLoaded(name);
            if (loaded && app.sDebug) {
                System.out.println("Ресурс - " + name + " загружен");
            }
        }
        return loaded;
    }
    public void unloadCheck(BaseAsset<?>[] assets){
        for (BaseAsset<?> asset : assets)
            if(name.equals(asset.getName()))
                return;
        unload();
    }
    public void unload() {
        loaded = false;
        app.getCoreResources().unload(name);
        if (app.sDebug) {
            System.out.println("Выгружаем ресурс - " + name);
        }
    }
    public String getName() {
        return name;
    }
}
