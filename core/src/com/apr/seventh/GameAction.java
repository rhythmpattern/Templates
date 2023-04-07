package com.apr.seventh;

import com.badlogic.gdx.utils.Array;

//Equivalent to Unity action. For functions as first class objects.
public class GameAction {
    Array<Action> actions = new Array<Action>();
    public void invoke()
    {
        for (Action action : actions)
        {
            action.invoke();
        }
    }
}
