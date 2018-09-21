package io.anuke.mindustry.maps.missions;

import io.anuke.mindustry.Vars;
import io.anuke.mindustry.game.GameMode;

import static io.anuke.mindustry.Vars.threads;

/**A mission which simply runs a single action and is completed instantly.*/
public abstract class ActionMission implements Mission{
    private Runnable runner;

    public ActionMission(Runnable runner){
        this.runner = runner;
    }

    @Override
    public boolean isComplete(){
        if(runner != null){
            threads.run(runner);
            runner = null;
        }
        return true;
    }

    @Override
    public String displayString(){
        return "";
    }

    @Override
    public GameMode getMode(){
        return Vars.state.mode;
    }
}
