package Components.Door;

public class DoorOpenCommand implements IDoorCommand {
    private  ElectricMotor motor;

    public DoorOpenCommand(ElectricMotor motor){
        this.motor = motor;
    }

    public void execute(){
        motor.open();
    }
}
