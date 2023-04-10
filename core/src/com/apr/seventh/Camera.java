package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
    OrthographicCamera camera;

    public Camera()
    {

    }
    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            camera.zoom +=0.1 ;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            camera.zoom -=0.1;
        }
        camera.update();
    }

    public void create()
    {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(300,300*(h/w));
        camera.position.x = 315;
        camera.position.y = 210;
        camera.update();
    }

    public void resize(int width, int height)
    {
        camera.viewportWidth = 300f;                 // Viewport of 30 units!
        camera.viewportHeight = 300f * height/width; // Lets keep things in proportion.
        camera.update();
    }

    public OrthographicCamera GetCamera()
    {
        return camera;
    }

}
