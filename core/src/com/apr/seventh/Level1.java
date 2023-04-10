package com.apr.seventh;

import static com.apr.seventh.Apr7.mh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bladecoder.ink.runtime.Story;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import aurelienribon.tweenengine.Tween;

public class Level1 implements Level {
    private Collection game = null;
    private Camera cam;

    private GameObject playerSpine;
    private GameObject playerSprite;

    private int width = 21*16;
    private int height = 21*16;
    private Action walk = new WalkAction();
    public ActionData aData = new ActionData(hashCode(),walk);

    private SpriteBatchRenderer mySpriteRenderer;
    private TwoColorRenderer mySpineRenderer;

    TiledMap map;

    Map myMap;
    private Vector<Renderer> myRenderers;

    private OrthogonalTiledMapRenderer renderer;

    public Level1()
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
        mh.PostMessage("start");
        myMap = new Map();
        myMap.create("level1.tmx");
        map = myMap.GetMap();

        renderer = new OrthogonalTiledMapRenderer(map);
        MapObjects objects = map.getLayers().get("GameObjects").getObjects();
        for (MapObject object : objects)
        {
            if (object.getName().equals("player"))
            {
                RectangleMapObject rectObj = (RectangleMapObject)object;
                Rectangle rect = rectObj.getRectangle();
                playerSprite = new Player(mySpriteRenderer,rect);
                mySpriteRenderer.add((GameObject) playerSprite);
            }
            if (object.getName().equals("spine-player"))
            {
                RectangleMapObject rectObj = (RectangleMapObject)object;
                Rectangle rect = rectObj.getRectangle();
                playerSpine = new SpineBoy(mySpineRenderer,rect);
                mySpineRenderer.add((GameObject) playerSpine);
            }
        }
    }

    public void update()
    {
        playerSpine.update();
        playerSprite.update();
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
        renderer.setView(cam.GetCamera());
        mySpineRenderer.SetProjection(cam.GetCamera());
        mySpriteRenderer.SetProjection(cam.GetCamera());
        renderer.render();
        mySpineRenderer.render();
        mySpriteRenderer.render();
    }
    public void resize(int width, int height)
    {
        cam.resize(width,height);
    }
    public void dispose()
    {
        playerSpine.dispose(); playerSprite.dispose(); map.dispose();
    }
    public void CalledFunction()
    {
        Gdx.app.log("debug","CALLED FUNCTION");
    }
    /*public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }*/

}
