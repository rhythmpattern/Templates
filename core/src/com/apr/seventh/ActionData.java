package com.apr.seventh;

public class ActionData {
    public Action action = null;
    public Integer hashCode;
    public Integer GetHashCode()
    {
        return hashCode;
    }
    public ActionData(Integer hash,Action action)
    {
        hashCode = hash;
        this.action = action;
    }
    public void invoke(GameObject caller)
    {
        if (action != null)
            action.invoke(caller);
    }

}
