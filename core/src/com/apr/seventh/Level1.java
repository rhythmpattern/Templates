package com.apr.seventh;

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
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import aurelienribon.tweenengine.Tween;

public class Level1 implements Level{
    private Collection game = null;
    private OrthographicCamera camera;

    Viewport viewport;
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private Vector2 direction;

    private Player playerSpine;
    private Player playerSprite;

    private TwoColorPolygonBatch spriteBatch;

    private int width = 21*16;
    private int height = 21*16;

    static final int WORLD_WIDTH = 1000;
    static final int WORLD_HEIGHT = 1000;
    Story story;
    Tween tween;
    private ActionMessageHandler mh = new ActionMessageHandler();
    private Action walk = new WalkAction();
    public ActionData aData = new ActionData(hashCode(),walk);

    private SpriteBatchRenderer mySpriteRenderer;
    private TwoColorRenderer mySpineRenderer;

    private Vector<Renderer> myRenderers;
    public Level1()
    {

    }
    public void create(Collection bigGame) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(300,300*(h/w));
        camera.position.x = 315;
        camera.position.y = 210;
        camera.update();
        spriteBatch = new TwoColorPolygonBatch();

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
        loader = new TmxMapLoader();
        map = loader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        direction = new Vector2();
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
                playerSpine = new Player(mySpineRenderer,rect);
                mySpineRenderer.add((GameObject) playerSpine);
            }
        }
    }

    public void update()
    {


        playerSpine.update();
        playerSprite.update();
      //  viewport.update(width,height);
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            camera.zoom +=0.1 ;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            camera.zoom -=0.1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            camera.position.x -= 10;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            camera.position.x += 10;
        }
         if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            camera.position.y += 10;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            camera.position.y -= 10;
        }
    }
    public void render()
    {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        mySpineRenderer.SetProjection(camera);
        mySpriteRenderer.SetProjection(camera);
        renderer.render();
        mySpineRenderer.render();
        mySpriteRenderer.render();
    }
    public void resize(int width, int height)
    {
        camera.viewportWidth = 300f;                 // Viewport of 30 units!
        camera.viewportHeight = 300f * height/width; // Lets keep things in proportion.
        camera.update();
    }
    public void dispose() {playerSpine.dispose(); playerSprite.dispose(); map.dispose();}
    public void CalledFunction() {
        Gdx.app.log("debug","CALLED FUNCTION");}
    /*public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }*/

}
