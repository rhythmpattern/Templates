package com.apr.seventh;

import static com.apr.seventh.Apr7.mh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

public class SpineBoy implements GameObject{

    SkeletonRenderer skelRenderer = null;
    TextureAtlas atlas;
    Skeleton skeleton = null;
    AnimationState state;
    TwoColorPolygonBatch batch;

    public SpineBoy(TwoColorRenderer rend, Rectangle r)
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
        mh.PostMessage("move",this);
    }

    public Vector2 GetPosition()
    {
        return new Vector2(skeleton.getX(),skeleton.getY());
    }

    public void update()
    {
        if (skeleton != null)
        {

            if (Gdx.input.isTouched())
            {
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            {
                skeleton.setX(skeleton.getX() - 2);
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            {
                skeleton.setX(skeleton.getX() + 2);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP))
            {
                skeleton.setY(skeleton.getY() + 2);
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            {
                skeleton.setY(skeleton.getY() - 2);
            }
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
    }
    public void dispose()
    {
        atlas.dispose();
    }
}
