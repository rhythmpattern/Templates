package com.apr.seventh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.lang.reflect.InvocationTargetException;

public class Apr7 extends ApplicationAdapter {
	static final int TILE_SIZE = 21;

	static ActionMessageHandler mh = new ActionMessageHandler();
	private MainHub mainHub = new MainHub();
	@Override
	public void create () {

			mainHub.create();
	}

	@Override
	public void render () {
		mainHub.update();
		mainHub.render();
	}

	@Override
	public void resize(int width, int height)
	{
		mainHub.resize(width, height);
	}
	@Override
	public void dispose () {
		mainHub.dispose();
	}
}
