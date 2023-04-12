package com.apr.seventh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Camera {
    static public OrthographicCamera camera;

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

     static public Vector3 Screen2World(Vector2 screen)
    {
        return camera.unproject(new Vector3(screen.x,screen.y,0));
    }

    public OrthographicCamera GetCamera()
    {
        return camera;
    }

}
