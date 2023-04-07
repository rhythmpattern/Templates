package com.apr.seventh;

import com.badlogic.gdx.Gdx;

public class Game implements Collection {
    public MainHub mainHub = null;
    Level level1 = new Level1();
    public void SetHub(MainHub hub) {mainHub = hub;}
    public void create()
    {
        Gdx.app.log("debug", "Created Game");
       level1.create();
    }
    public void update() {}
    public void dispose() {}
}
