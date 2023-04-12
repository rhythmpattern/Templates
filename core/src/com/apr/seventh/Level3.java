package com.apr.seventh;

import static com.apr.seventh.Apr7.mh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Vector;

public class Level3 implements Level{
    private Collection game = null;
    private Camera cam;

    private GameObject playerSpine;
    private GameObject playerSprite;

    private ArrayList<GameObject> gameObjects;

    private int width = 21*16;
    private int height = 21*16;
    private Action walk = new WalkAction();
    public ActionData aData = new ActionData(hashCode(),walk);

    private SpriteBatchRenderer mySpriteRenderer;
    private TwoColorRenderer mySpineRenderer;

    Map myMap;
    private Vector<Renderer> myRenderers;

    public Level3()
    {

    }
    public void create(Collection bigGame) {
        cam = new Camera();
        cam.create();
        //Create the renderers
        myRenderers = new Vector<Renderer>(2);
        mySpriteRenderer =  new SpriteBatchRenderer();
        mySpineRenderer =  new TwoColorRenderer();
        myRenderers.add((Renderer) mySpriteRenderer);
        myRenderers.add((Renderer) mySpineRenderer);

        Gdx.app.log("debug","CREATED LEVEL1");
        game = bigGame;
        mh.Subscribe("start",aData);
        mh.PostMessage("start",(GameObject) new EmptyGO());
        myMap = new Map();
        gameObjects = myMap.create("level3.tmx", cam, mySpriteRenderer,mySpineRenderer);

    }

    public void update()
    {
        for (GameObject o : gameObjects)
        {
            o.update();
        }
        //  viewport.update(width,height);

        cam.update();
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q))
        {
            game.Next();
        }
    }
    public void render()
    {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mySpineRenderer.SetProjection(cam.GetCamera());
        mySpriteRenderer.SetProjection(cam.GetCamera());
        myMap.render();
        mySpineRenderer.render();
        mySpriteRenderer.render();
    }
    public void resize(int width, int height)
    {
        cam.resize(width,height);
    }
    public void dispose()
    {
        for (GameObject o : gameObjects)
        {
            o.dispose();
        }
        myMap.dispose();
    }
    public void CalledFunction()
    {
        Gdx.app.log("debug","CALLED FUNCTION");
    }
    /*public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }*/


}
