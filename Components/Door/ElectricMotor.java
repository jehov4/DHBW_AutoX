package Components.Door;

public class ElectricMotor {
    private boolean isOpen = false;

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }
}
