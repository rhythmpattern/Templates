package com.apr.seventh;


//Extend this class and override only what you need.
public class MessageHandlerStub implements MessageHandler{
    public void Subscribe(Messenger object)
    {
    }
    public void PostMessage(String message){}

    public void PostMessageByString(String message) {
    }
}
