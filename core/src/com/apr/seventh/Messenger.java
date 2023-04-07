package com.apr.seventh;

import java.lang.reflect.InvocationTargetException;

public interface Messenger {
    public void CallFunction(String message) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException;
}
