package com.apr.seventh;

import com.badlogic.gdx.utils.Array;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MessageHandler {
    Array<Messenger> subscribers = new Array<Messenger>();

    public void Subscribe(Messenger object)
    {
        subscribers.add(object);
    }

    public void PostMessage(String message) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for ( Messenger s : subscribers)
        {
            s.CallFunction(message);
        }
    }
    private void blank(){}
}
