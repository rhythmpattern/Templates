package com.apr.seventh;

import java.util.Dictionary;
import java.util.HashMap;

public class ActionMessageHandler extends MessageHandlerStub{
    HashMap<String,HashMap<Integer,ActionData>> actions = new HashMap<String,HashMap<Integer,ActionData>>();

    @Override
    public void Subscribe(String name, ActionData actionData)
    {
        if (!actions.containsKey(name))
        {
            HashMap<Integer,ActionData> newMap = new HashMap<Integer,ActionData>();
            newMap.put(actionData.hashCode,actionData);
            actions.put(name,newMap);
            return;
        }
        actions.get(name).put(actionData.hashCode(),actionData);
    }
    @ Override
    public void PostMessage(String name, GameObject caller)
    {
        for (String entry: actions.keySet())
        {
            HashMap<Integer,ActionData> a1 = actions.get(entry);
            for (Integer innerEntry: a1.keySet())
            {
                a1.get(innerEntry).invoke(caller);
            }
        }
    }
}
