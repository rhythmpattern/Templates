package com.apr.seventh;

import com.badlogic.gdx.math.Vector2;

//Must implement render to be able to add to Renderer.
public interface GameObject {
    public void render();
    public void update();
    public void dispose();
    public Vector2 GetPosition();
}
