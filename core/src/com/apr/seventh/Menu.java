package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class Menu implements Collection{
    public MainHub mainHub = null;
    @Override
    public void create() {
        Gdx.app.log("","Created Menu");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
               mainHub.ShowGame();
            }
        }, 3000);
    }

    @Override
    public void SetHub(MainHub hub) {mainHub = hub;}

    public void update() {}
    public void dispose() {}
}
