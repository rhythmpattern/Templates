package com.apr.seventh;

public class MainHub {
    private Collection collection = null;

    public void create()
    {
        ShowGame();
    }

    public void ShowGame()
    {
        if ((collection == null) || collection != null && collection.getClass() != Game.class)
        {
            if (collection != null)
                collection.dispose();
            collection = new Game();
            collection.create();

        }
    }
    public void ShowMenu()
    {
        if ((collection == null) || collection != null && collection.getClass() != Menu.class)
        {
            if (collection != null)
                collection.dispose();
            collection = new Menu();
            collection.create();
            collection.SetHub(this);
        }
    }
    public void update()
    {
        collection.update();
    }
    public void render()
    {
        collection.render();
    }
    public void resize(int width, int height)
    {
        collection.resize(width,height);
    }
    public void dispose()
    {
        collection.dispose();
    }
}
