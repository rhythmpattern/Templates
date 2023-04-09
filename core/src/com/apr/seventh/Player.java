package com.apr.seventh;

import static com.apr.seventh.Apr7.TILE_SIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenUtils;
import aurelienribon.tweenengine.equations.Elastic;

public class Player {
    //Testing softbody
    private Sprite sprite;
    private float WIDTH = TILE_SIZE * 4;
    private float HEIGHT =  TILE_SIZE * 4;
    private SpriteBatch spriteBatch;

    private Tween tween;
    public Player(SpriteBatch sBatch, Rectangle r)
    {
        WIDTH = r.width;
        HEIGHT = r.height;
        //Tween.to(sprite,3,1).target(-15,-15).ease(Elastic.INOUT)
        Gdx.app.log("", "CREATED PLAYER");
        spriteBatch = sBatch;
        sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
        sprite.setSize(WIDTH,HEIGHT);
        sprite.setPosition(r.x, r.y);
        Gdx.app.log("", "" + sprite.getHeight() + " " + sprite.getWidth());
    }
    public void draw()
    {

        sprite.draw(spriteBatch);
    }
}
