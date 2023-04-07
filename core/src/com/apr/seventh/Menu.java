package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.InvocationTargetException;

public class Menu implements Collection{
    MessageHandler messageHandler = new MessageHandler();
    Messenger lev1 = new Level1();

    MessageHandler mHandler = new MessageHandler();
    public void create() {
        Gdx.app.log("","Created Menu");
    }
    public void update() {}
    public void dispose() {}
}
