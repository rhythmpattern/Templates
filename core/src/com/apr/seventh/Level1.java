package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bladecoder.ink.runtime.Story;

import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;

import aurelienribon.tweenengine.Tween;

public class Level1 implements Level{
    private Collection game = null;
    private OrthographicCamera camera;

    Viewport viewport;
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private Vector2 direction;

    private int width = 21*16;
    private int height = 21*16;
    Story story;
    Tween tween;
    private ActionMessageHandler mh = new ActionMessageHandler();
    private Action walk = new WalkAction();
    public ActionData aData = new ActionData(hashCode(),walk);
    public Level1()
    {

    }
    public void create(Collection bigGame) {

        camera = new OrthographicCamera(21f*16f,21*16);
        viewport = new ExtendViewport(200,200,camera);

        camera.position.x += 200;
        camera.position.y += 200;
        Gdx.app.log("debug","CREATED LEVEL1");
        game = bigGame;
        mh.Subscribe("start",aData);
        mh.PostMessage("start");
        loader = new TmxMapLoader();
        map = loader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        renderer.setView(camera);
        direction = new Vector2();
    }

    public void update()
    {

        camera.update();
        viewport.update(width,height);
        boolean isPressed = Gdx.input.isKeyPressed(Input.Keys.D);
        if (isPressed)
        {
            game.Next();
        }
    }
    public void render()
    {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setView(camera);
        renderer.render();
    }
    public void resize(int width, int height)
    {
        width = width; height = height;
    }
    public void dispose() {}
    public void CalledFunction() {
        Gdx.app.log("debug","CALLED FUNCTION");}
    /*public void CallFunction(String name) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        this.getClass().getDeclaredMethod(name).invoke(this);
    }*/

}
