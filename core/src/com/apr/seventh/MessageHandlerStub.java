package com.apr.seventh;


//Extend this class and override only what you need.
public abstract class MessageHandlerStub implements MessageHandler{
    public void Subscribe(Messenger object)
    {
    }
    public void Subscribe(Action action)
    {
    }
    public void PostMessage(String message){}

    public void PostMessageByString(String message) {
    }

    public abstract void Subscribe(String name, Action action);
}
