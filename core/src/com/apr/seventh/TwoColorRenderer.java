package com.apr.seventh;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

import java.util.ArrayList;
//To render spines
public class TwoColorRenderer implements Renderer {
    private ArrayList<GameObject> gameObjects;
    TwoColorPolygonBatch batch;
    public TwoColorRenderer()
    {
        gameObjects = new ArrayList<GameObject>();
        batch = new TwoColorPolygonBatch();
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
    public TwoColorPolygonBatch GetBatch()
    {
        return batch;
    }
    public void SetProjection(OrthographicCamera cam)
    {
        batch.setProjectionMatrix(cam.combined);
    }
}
