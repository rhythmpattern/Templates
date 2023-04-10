package com.apr.seventh;


//Extend this class and override only what you need.
public abstract class MessageHandlerStub implements MessageHandler{
    public void Subscribe(Messenger object)
    {
    }
    public void Subscribe(String name, ActionData actionData)
    {
    }
    public void PostMessage(String message,GameObject caller){}

    public void PostMessageByString(String message) {
    }

}
