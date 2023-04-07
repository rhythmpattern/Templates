package com.apr.seventh;

import com.badlogic.gdx.utils.Array;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface MessageHandler{
    public void Subscribe(Messenger object);
    public void PostMessage(String message);

    public void PostMessageByString(String message);
}
