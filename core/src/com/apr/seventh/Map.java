package com.apr.seventh;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Map {
    private TiledMap map;
    private TmxMapLoader loader;

    private ArrayList<GameObject> gameobjects;
    private OrthogonalTiledMapRenderer renderer;

    Camera cam;
    public Map() {}
    public ArrayList<GameObject> create(String levelname, Camera camera, SpriteBatchRenderer mySpriteRenderer, TwoColorRenderer mySpineRenderer)
    {
        cam = camera;
        gameobjects = new ArrayList<GameObject>();
        loader = new TmxMapLoader();
        map = loader.load(levelname);
        renderer = new OrthogonalTiledMapRenderer(map);

        MapObjects objects = map.getLayers().get("GameObjects").getObjects();
        for (MapObject object : objects)
        {
            if (object.getName().equals("player"))
            {
                RectangleMapObject rectObj = (RectangleMapObject)object;
                Rectangle rect = rectObj.getRectangle();
                gameobjects.add(new Player(mySpriteRenderer,rect));
            }
            if (object.getName().equals("spine-player"))
            {
                RectangleMapObject rectObj = (RectangleMapObject)object;
                Rectangle rect = rectObj.getRectangle();
                gameobjects.add(new SpineBoy(mySpineRenderer,rect));
            }
        }
        return gameobjects;
    }
    public void render()
    {
        renderer.setView(cam.GetCamera());
        renderer.render();
    }
    public void dispose()
    {
        map.dispose();
    }
    public TiledMap GetMap()
    {
        return map;
    }
}
