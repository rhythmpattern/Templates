package com.apr.seventh;

import static com.apr.seventh.Apr7.TILE_SIZE;
import static com.apr.seventh.Apr7.mh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

import java.util.Vector;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenUtils;
import aurelienribon.tweenengine.equations.Elastic;

public class Player implements GameObject{

    private Sprite sprite = null;
    private float WIDTH = TILE_SIZE * 4;
    private float HEIGHT =  TILE_SIZE * 4;
    private SpriteBatch spriteBatch;

    private Tween tween;
    public Player(SpriteBatchRenderer rend, Rectangle r)
    {
        WIDTH = r.width;
        HEIGHT = r.height;
        //Tween.to(sprite,3,1).target(-15,-15).ease(Elastic.INOUT)
        Gdx.app.log("", "CREATED PLAYER");
        spriteBatch = rend.GetBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
        sprite.setSize(WIDTH,HEIGHT);
        sprite.setPosition(r.x, r.y);
        Gdx.app.log("", "" + sprite.getHeight() + " " + sprite.getWidth());
        Action moveaction = new MoveAction();
        ActionData data = new ActionData(hashCode(),moveaction);
        mh.Subscribe("move",data);
        rend.add(this);
    }

    public Vector2 GetPosition()
    {
        return new Vector2(sprite.getX(),sprite.getY());
    }

    public class MoveAction implements Action {

        @Override
        public void create() {

        }

        @Override
        public void invoke(GameObject caller) {
            Gdx.app.log("debug", "INVOKED MOVE ACTION");
            //sprite.setPosition(caller.GetPosition().x + 100,caller.GetPosition().y);
        }
    }

    public void update()
    {




    }
    public void render()
    {

        if (sprite != null)
        {
            sprite.draw(spriteBatch);
        }


    }
    public void dispose()
    {

    }

}
