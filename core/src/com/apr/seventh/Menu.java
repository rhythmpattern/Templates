package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class Menu implements Collection{
    public MainHub mainHub = null;
    @Override
    public void create() {
        Gdx.app.log("","Created Menu");

    }

    @Override
    public void SetHub(MainHub hub) {mainHub = hub;}
    public void Next(){}
    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            mainHub.ShowGame();
        }
    }
    public void dispose() {}
}
