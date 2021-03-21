package Components.Door;

public class DoorCloseCommand implements IDoorCommand {
    private  ElectricMotor motor;

    public DoorCloseCommand(ElectricMotor motor){
        this.motor = motor;
    }

    public void execute(){
        motor.close();
    }
}
