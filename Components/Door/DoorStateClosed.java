package Components.Door;

public class DoorStateClosed implements IDoorState {

    @Override
    public void signal(Door door) {
        door.setDoorState(new DoorStateOpen());
        door.getDoorCommand().execute();
        door.setDoorCommand(new DoorCloseCommand(door.getElectricMotor()));
    }
}
