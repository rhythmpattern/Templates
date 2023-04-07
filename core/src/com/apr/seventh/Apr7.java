package com.apr.seventh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.lang.reflect.InvocationTargetException;

public class Apr7 extends ApplicationAdapter {
	private MainHub mainHub = new MainHub();
	@Override
	public void create () {

			mainHub.create();
	}

	@Override
	public void render () {
		mainHub.update();
	}
	
	@Override
	public void dispose () {
		mainHub.dispose();
	}
}
