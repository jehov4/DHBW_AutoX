package Components;
import Components.Battery.IBatteryListener;
import Components.Ultrasonic.IUltrasonicListener;
import com.google.common.eventbus.EventBus;
import Events.*;

public class ContorlUnit implements IBatteryListener, IUltrasonicListener {

    private final EventBus eventBus;

    public ContorlUnit() {
        eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber){
        eventBus.register(subscriber);
    }

    public void startup(){
        eventBus.post(new EngineOnEvent());
        eventBus.post(new LEDOnEvent());
        eventBus.post(new GPSOnEvent());
        eventBus.post(new GPSConnectSatelliteEvent(118.75));
        eventBus.post(new CameraOnEvent());
        eventBus.post(new LidarOnEvent());
        eventBus.post(new LeftIndicatorOffEvent());
    }

    public void move(int deltaRPM, int seconds){
        eventBus.post(new LeftIndicatorOffEvent());
        eventBus.post(new RightIndicatorOffEvent());
        eventBus.post(new LEDDimmedEvent());
        eventBus.post(new IncreaseRPMEvent(deltaRPM, seconds));
        eventBus.post(new BrakeSetEvent(0));
        eventBus.post(new BrakeLightOffEvent());
    }

    public void leftTurn(int deltaRPM, int seconds){
        eventBus.post(new LeftIndicatorOnEvent());
        eventBus.post(new DecreaseRMPEvent(deltaRPM, seconds));
        eventBus.post(new BrakeSetEvent(70));
        eventBus.post(new BrakeLightOnEvent());
    }

    public void rigthTurn(int deltaRPM, int seconds){
        eventBus.post(new RightIndicatorOnEvent());
        eventBus.post(new DecreaseRMPEvent(deltaRPM, seconds));
        eventBus.post(new BrakeSetEvent(70));
        eventBus.post(new BrakeLightOnEvent());
    }

    public void  stop(){
        eventBus.post(new BrakeSetEvent(70));
        eventBus.post(new BrakeLightOnEvent());
    }

    public void emergencyStop(){
        eventBus.post(new BrakeSetEvent(100));
        eventBus.post(new BrakeLightOnEvent());
        eventBus.post(new HazardWarningOnEvent());
        eventBus.post(new EngineOffEvent());
        eventBus.post(new LEDHighBeamEvent());
        eventBus.post(new CameraOffEvent());
        eventBus.post(new LidarOffEvent());
    }

    public void shutdown(){
        eventBus.post(new BrakeSetEvent(100));
        eventBus.post(new EngineOffEvent());
        eventBus.post(new BrakeLightOffEvent());
        eventBus.post(new LEDOffEvent());
        eventBus.post(new HazardWarningOffEvent());
        eventBus.post(new GPSOnEvent());
        eventBus.post(new CameraOffEvent());
        eventBus.post(new LidarOffEvent());
    }

    @Override
    public void receiveTemperature(int temperature) {
        System.out.println("Received temperature " + temperature);
    }

    @Override
    public void receiveDistance(int distance, int sensor) {
        System.out.println("Received distance " + distance + " from " + sensor);
    }
}
