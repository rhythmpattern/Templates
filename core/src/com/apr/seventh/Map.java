package com.apr.seventh;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Map {
    private TiledMap map;
    private TmxMapLoader loader;

    public Map() {}
    public void create(String levelname)
    {
        loader = new TmxMapLoader();
        map = loader.load(levelname);


    }
    public TiledMap GetMap()
    {
        return map;
    }
}
