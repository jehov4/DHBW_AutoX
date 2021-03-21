package Components.Engine;

import Components.ContorlUnit;
import Events.*;

import com.google.common.eventbus.Subscribe;

public class EngineNG extends IElectricEngine {

    public  EngineNG(ContorlUnit contorlUnit){
        super(contorlUnit);
        consumption = 3;
    }
}
