package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Timer;

import java.lang.reflect.InvocationTargetException;
import java.util.TimerTask;

public class Menu implements Collection{
    public MainHub mainHub = null;
    @Override
    public void create() {
        Gdx.app.log("","Created Menu");
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                Gdx.app.log("","Delayed Timer");
                mainHub.ShowGame();
            }

        },1.0f);
        timer.start();
    }

    @Override
    public void SetHub(MainHub hub) {mainHub = hub;}
    public void Next(){}
    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {

        }
    }
    public void render()
    {

    }

    public void resize(int width, int height)
    {

    }
    public void dispose() {}
}
