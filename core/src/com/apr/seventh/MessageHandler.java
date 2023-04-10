package com.apr.seventh;

public interface MessageHandler{
    public void Subscribe(Messenger object);
    public void Subscribe(String name, ActionData actionData);
    public void PostMessage(String message, GameObject caller);

    public void PostMessageByString(String message);
}
