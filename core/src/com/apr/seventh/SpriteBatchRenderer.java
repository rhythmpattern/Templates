package com.apr.seventh;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

import java.util.ArrayList;

public class SpriteBatchRenderer implements Renderer{
    private ArrayList<GameObject> gameObjects;
    SpriteBatch batch;
    public SpriteBatchRenderer()
    {
        gameObjects = new ArrayList<GameObject>();
        batch = new SpriteBatch();
    }
    public void render()
    {
        if (gameObjects.size() <= 0) return;
        batch.begin();
        for (GameObject o : gameObjects)
        {
            o.render();
        }
        batch.end();
    }
    public void add(GameObject obj)
    {
        gameObjects.add(obj);
    }
    public void remove(GameObject obj)
    {
        gameObjects.remove(obj);
    }
    public SpriteBatch GetBatch()
    {
        return batch;
    }
    public void SetProjection(OrthographicCamera cam)
    {
        batch.setProjectionMatrix(cam.combined);
    }
}
