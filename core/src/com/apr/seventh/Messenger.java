package com.apr.seventh;

import java.lang.reflect.InvocationTargetException;

public interface Messenger {
    public void CallFunction(String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
