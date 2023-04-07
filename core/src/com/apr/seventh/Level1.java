package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

public class Level1 implements Level{
    private Collection game = null;
    private ActionMessageHandler mh;
    private Action walk = new WalkAction();
    public Level1()
    {

    }
    public void create(Collection bigGame) {
        game = bigGame;
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                game.Next();
            }
        }, 3000);walk.invoke();}*/
    }
    @Override
    public void update()
    {
        boolean isPressed = Gdx.input.isKeyPressed(Input.Keys.A);
        if (isPressed)
        {
            game.Next();
        }
    }
    public void dispose() {}
    public void CalledFunction() {
        Gdx.app.log("debug","CALLED FUNCTION");}
    public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }

}
