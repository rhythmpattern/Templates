package com.apr.seventh;

public class MainHub {
    private Collection collection = null;

    public void create()
    {
        ShowMenu();
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

    }
    public void dispose()
    {

    }
}
