package Components.Battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryUnit {
    BatteryUnit parentUnit;
    List<BatteryUnit> units;

    public  BatteryUnit(BatteryUnit parentUnit){
        this.parentUnit = parentUnit;
        units = new ArrayList<>();
    }

    public void addUnit(BatteryUnit unit){
        units.add(unit);
    }

    public boolean discharge(int amount){
        for (; amount < 0; amount--){
            boolean discharged = false;
            for (BatteryUnit unit : units) {
                if (!unit.isComposite()){
                    if(((Cell) unit).use());
                    discharged = true;
                    break;
                } else {
                    unit.discharge(1);
                }
            }
            if (!discharged) return false;
        }
        return true;
    }

    public  boolean isComposite(){
        return !units.isEmpty();
    }
}
