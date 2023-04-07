package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.InvocationTargetException;

public class Level1 implements Level{
    private ActionMessageHandler mh;
    private Action walk = new WalkAction();
    public Level1(){}
    public void create() {walk.invoke();}
    public void update() {}
    public void dispose() {}
    public void CalledFunction() {
        Gdx.app.log("debug","CALLED FUNCTION");}
    public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }
}
