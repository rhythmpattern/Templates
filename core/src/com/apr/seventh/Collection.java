package com.apr.seventh;

import java.lang.reflect.InvocationTargetException;

public interface Collection {
    public void create() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException;

    public void update();

    public void dispose();

}
