package com.apr.seventh;

import static com.apr.seventh.Apr7.TILE_SIZE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Rectangle;
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

    SkeletonRenderer skelRenderer = null;
    TextureAtlas atlas;
    Skeleton skeleton = null;
    AnimationState state;
    TwoColorPolygonBatch batch;

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
    }
    public Player(TwoColorRenderer rend, Rectangle r)
    {
        batch = new TwoColorPolygonBatch();
        skelRenderer = new SkeletonRenderer();
        atlas = new TextureAtlas(Gdx.files.internal("spineboy-pro.atlas"));
        SkeletonBinary json = new SkeletonBinary(atlas);
        json.setScale(0.1f);
        SkeletonData skeletonData = json.readSkeletonData(Gdx.files.internal("spineboy-pro.skel"));
        AnimationStateData stateData = new AnimationStateData(skeletonData);
        state = new AnimationState(stateData);
        batch = rend.GetBatch();
        skeleton = new Skeleton(skeletonData);
        // Queue the "walk" animation on the first track.
        state.setAnimation(0, "run", true);
        skeleton.setPosition(r.x,r.y);
    }
    public void update()
    {
        if (skeleton != null)
        {
            state.update(Gdx.graphics.getDeltaTime());
            state.apply(skeleton);
            skeleton.updateWorldTransform();
        }

    }
    public void render()
    {
        if (skelRenderer != null)
        {

            skelRenderer.draw(batch,skeleton);
        }
        if (sprite != null)
        {
            sprite.draw(spriteBatch);
        }


    }
    public void dispose()
    {

    }

}
