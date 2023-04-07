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

		try {
			mainCollection.create();
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
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
