package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.InvocationTargetException;

public class Level1 implements Level,Messenger{
    public Level1(){}
    public void create() {}
    public void update() {}
    public void dispose() {}
    public void CalledFunction() {
        Gdx.app.log("debug","CALLED FUNCTION");}
    public void CallFunction(String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }
}
