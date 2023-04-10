package com.apr.seventh;

import com.badlogic.gdx.Gdx;

public class WalkAction implements Action{

    @Override
    public void create() {

    }

    @Override
    public void invoke(GameObject caller) {
        Gdx.app.log("","INVOKED WALK");
    }
}
