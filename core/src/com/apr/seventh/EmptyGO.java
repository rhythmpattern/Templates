package com.apr.seventh;

import com.badlogic.gdx.math.Vector2;

public class EmptyGO implements GameObject{
    @Override
    public void render() {

    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public Vector2 GetPosition()
    {
        return new Vector2();
    }
}
