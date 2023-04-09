package com.apr.seventh;

import java.lang.reflect.InvocationTargetException;

public interface Collection {
    public void create() ;
    public void SetHub(MainHub hub);
    public void update();
    public void Next();
    public void render();
    public void resize(int width, int height);
    public void dispose();

}
