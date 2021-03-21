package Components.Ultrasonic;

import java.util.ArrayList;
import java.util.List;

public class UltrasonicSensor {

    private List<IUltrasonicListener> listeners = new ArrayList<>();
    int id;

    public  UltrasonicSensor(int id){
        this.id = id;
    }

    public void addListener(IUltrasonicListener listener){
        listeners.add(listener);
    }

    public void sendDistance(){
        for (IUltrasonicListener listener: listeners ) {
            listener.receiveDistance(42, id);
        }
    }
}
