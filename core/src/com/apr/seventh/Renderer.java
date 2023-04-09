package com.apr.seventh;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

//Implement this for SpriteBatch or TwoColorSpriteBatch
public interface Renderer {
    public void render();
    public void add(GameObject obj);
    public void remove(GameObject obj);
    public void SetProjection(OrthographicCamera cam);
}
