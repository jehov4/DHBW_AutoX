package Components.Engine;

import Components.ContorlUnit;
import Events.*;

import com.google.common.eventbus.Subscribe;

public class EngineX extends IElectricEngine {

    public  EngineX(ContorlUnit contorlUnit){
        super(contorlUnit);
        consumption = 4;
    }

}
