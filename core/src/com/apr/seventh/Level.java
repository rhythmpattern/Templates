package com.apr.seventh;

public interface Level {
    public void create(Collection bigGame);

    public void render();
    public void resize(int width, int height);
    public void update();
    public void dispose();
}
