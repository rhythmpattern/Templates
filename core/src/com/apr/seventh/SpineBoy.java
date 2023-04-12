package com.apr.seventh;

import static com.apr.seventh.Apr7.mh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonBinary;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.utils.TwoColorPolygonBatch;

public class SpineBoy implements GameObject, InputProcessor{

    SkeletonRenderer skelRenderer = null;
    TextureAtlas atlas;
    Skeleton skeleton = null;
    AnimationState state;
    TwoColorPolygonBatch batch;

    Vector2 targetPos;
    float factor = 1f;

    Vector2 boneCoords = new Vector2();

    public SpineBoy(TwoColorRenderer rend, Rectangle r)
    {
        Gdx.input.setInputProcessor(this);
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
        state.setAnimation(1,"aim",true);
        skeleton.setPosition(r.x,r.y);
        targetPos = new Vector2(r.x,r.y);
        mh.PostMessage("move",this);
        rend.add(this);
    }

    public Vector2 GetPosition()
    {
        return new Vector2(skeleton.getX(),skeleton.getY());
    }

    public void update()
    {
        Vector2 error = new Vector2((targetPos.x - skeleton.getX())*factor, factor* (targetPos.y - skeleton.getY()));
       // skeleton.setX(skeleton.getX() + error.x * Gdx.graphics.getDeltaTime());
        //skeleton.setY(skeleton.getY() + error.y * Gdx.graphics.getDeltaTime());
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 touchPos = Camera.Screen2World(new Vector2(screenX,screenY));
        targetPos = new Vector2(touchPos.x,touchPos.y);
        Bone crosshair = skeleton.findBone("crosshair"); // Should be cached.

        boneCoords.set(targetPos.x, targetPos.y);
        crosshair.getParent().worldToLocal(boneCoords); // camera space to local bone space
        crosshair.setPosition(boneCoords.x, boneCoords.y); // override the crosshair position
        state.setAnimation(3,"shoot",false)   ;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
