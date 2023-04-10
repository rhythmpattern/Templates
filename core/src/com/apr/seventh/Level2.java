package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

import java.util.Vector;

public class Level2 implements Level{
    Collection game = null;
    Vector<Renderer> myRenderers;
    TwoColorRenderer spineRenderer;
    SpriteBatchRenderer spriteRenderer;
    private OrthographicCamera camera;
    private GameObject playerSpine;
    private GameObject playerSprite;
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    public Level2(){}
    @Override
    public void create(Collection bigGame) {
        game = bigGame;
        Gdx.app.log("debug","CREATED LEVEL 2");
        spineRenderer = new TwoColorRenderer();
        spriteRenderer = new SpriteBatchRenderer();
        myRenderers.add(0,spineRenderer);
        myRenderers.add(1,spriteRenderer);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(300,300*(h/w));
        camera.position.x = 315;
        camera.position.y = 210;
        camera.update();
    }

    @Override
    public void update() {

    }
    public void resize(int width, int height)
    {

    }
    public void render()
    {

    }

    @Override
    public void dispose() {

    }
}
