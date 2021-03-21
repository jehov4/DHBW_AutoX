package Components.Door;

public class DoorStateOpen implements IDoorState {
    @Override
    public void signal(Door door) {
        door.setDoorState(new DoorStateClosed());
        door.getDoorCommand().execute();
        door.setDoorCommand(new DoorOpenCommand(door.getElectricMotor()));
    }
}
