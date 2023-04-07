package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.InvocationTargetException;

public class Menu implements Collection{
    MessageHandler messageHandler = new MessageHandler();
    Messenger lev1 = new Level1();

    MessageHandler mHandler = new MessageHandler();
    public void create() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException {
        Gdx.app.log("","Created Menu");
       // lev1.CallFunction("CalledFunction");
        mHandler.Subscribe(lev1);
        mHandler.PostMessage("CalledFunction");
    }
    public void update() {}
    public void dispose() {}
}
