package com.apr.seventh;

import com.badlogic.gdx.Gdx;

public class Level2 implements Level{
    Collection game = null;
    public Level2(){}
    @Override
    public void create(Collection bigGame) {
        game = bigGame;
        Gdx.app.log("debug","CREATED LEVEL 2");
    }

    @Override
    public void update() {

    }
    public void resize(int width, int height)
    {

    }
    public void render()
    {

    }

    @Override
    public void dispose() {

    }
}
