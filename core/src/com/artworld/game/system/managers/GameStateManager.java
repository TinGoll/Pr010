package com.artworld.game.system.managers;

import com.artworld.game.Application;
import com.artworld.game.states.BaseState;
import com.artworld.game.states.MenuState;
import com.artworld.game.states.PlayState;
import com.artworld.game.states.SplashState;

import java.util.Stack;

public class GameStateManager {
    private final Application app;
    private Stack<BaseState> states;
    public enum State {
        MENU,
        PLAY,
        SPLASH
    }
    public GameStateManager(Application app) {
        this.app = app;
        this.states = new Stack<BaseState>();
        this.setState(State.PLAY);
    }
    public void render() {
        states.peek().render();
    }
    public void update(float delta) {
        states.peek().update(delta);
    }
    public void resize(int w, int h) {
        states.peek().resize(w, h);
    }
    public void pause() {
        states.peek().pause();
    }
    public void resume() {
        states.peek().resume();
    }
    public void dispose() {
        for(BaseState gs : states) {
            gs.dispose();
        }
        states.clear();
    }
    public void setState(State state) {
        if(!states.isEmpty()) {
            states.pop().dispose();
        }
        BaseState screen = getState(state);
        screen.create(this);
        states.push(screen);
        states.push(screen.createLoaderScreen(this));

    }
    private BaseState getState(State state) {
        switch(state) {
            case MENU: return new MenuState();
            case PLAY: return new PlayState();
            case SPLASH: return new SplashState();
        }
        return null;
    }

    public void pushScreen(BaseState screen){
        states.push(screen);
    }
    public void deleteTopScreen(){
        if(!states.isEmpty()) {
            states.pop().dispose();
        }
    }

    public Application application() {
        return app;
    }
    public BaseState getCurrentState(){
       return states.peek();
    }
    public Stack<BaseState> getStates() {
        return states;
    }
}
