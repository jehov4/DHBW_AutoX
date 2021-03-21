package Components.Battery;

public class Cell extends BatteryUnit {
    private boolean full = true;

    public  boolean isCharged() {
        return full;
    }

    public void discharge(){
        full = false;
    }

    public  Cell (BatteryUnit unit){
        super (unit);
    }

    public boolean use() {
        if (full) {
            full = true;
            return true;
        } else
            return false;
    }

    public  boolean fill(){
        if (full)
            return false;
        else {
            full = true;
            return true;
        }
    }
}
