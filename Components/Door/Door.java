package Components.Door;

import Components.Subscriber;
import Events.DoorSignalEvent;
import com.google.common.eventbus.Subscribe;

public class Door extends Subscriber implements IDoorSensorListener {
    private ElectricMotor electricMotor = new ElectricMotor();
    private IDoorState doorState = new DoorStateClosed();
    private IDoorCommand doorCommand = new DoorOpenCommand(electricMotor);
    private DoorSensor sensor = new DoorSensor();



    public Door(){
        sensor.addListener(this);
    }

    @Subscribe
    public void signal (DoorSignalEvent event){
        doorState.signal(this);
    }

    public void setDoorState(IDoorState doorState){
        this.doorState = doorState;
    }

    public void sensorTriggered(){
        this.doorState.signal(this);
    }

    public DoorSensor getSensor() {
        return sensor;
    }

    public ElectricMotor getElectricMotor() {
        return electricMotor;
    }

    public IDoorCommand getDoorCommand() {
        return doorCommand;
    }

    public void setDoorCommand(IDoorCommand doorCommand) {
        this.doorCommand = doorCommand;
    }
}
