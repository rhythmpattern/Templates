package com.apr.seventh;

import com.badlogic.gdx.Gdx;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game implements Collection {
    int level = 1;
    ArrayList<Level> levels = new ArrayList<>();
    public MainHub mainHub = null;
    Level level1 = new Level1();
    Level level2 = new Level2();
    public void SetHub(MainHub hub) {mainHub = hub;}
    public void create()
    {
        Gdx.app.log("debug", "Created Game");
       levels.add(level1);
       levels.add(level2);
       levels.get(level - 1).create(this);
    }
    public void Next()
    {
        levels.get(level - 1).dispose();
        level +=1 ;
        levels.get(level - 1).create(this);

    }
    public void update() {}
    public void dispose() {}
}
