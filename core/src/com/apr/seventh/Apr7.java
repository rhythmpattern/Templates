package com.apr.seventh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.lang.reflect.InvocationTargetException;

public class Apr7 extends ApplicationAdapter {
	private Collection mainCollection = new Menu();
	@Override
	public void create () {

			mainCollection.create();
	}

	@Override
	public void render () {
		mainCollection.update();
	}
	
	@Override
	public void dispose () {
		mainCollection.dispose();
	}
}
