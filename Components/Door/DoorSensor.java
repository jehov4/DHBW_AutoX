package Components.Door;

import java.util.ArrayList;
import java.util.List;

public class DoorSensor {
    List<IDoorSensorListener> listeners = new ArrayList<>();

    public void addListener(IDoorSensorListener listener){
        listeners.add(listener);
    }

    public void trigger(){
        for (IDoorSensorListener listener: listeners) {
            listener.sensorTriggered();
        }
    }
}
