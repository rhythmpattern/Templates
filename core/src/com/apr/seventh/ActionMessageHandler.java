package com.apr.seventh;

import java.util.Dictionary;

public class ActionMessageHandler extends MessageHandlerStub{
    Dictionary<String,Action> actions;
    @Override
    public void Subscribe(String name, Action action)
    {
        actions.put(name,action);
    }
}
