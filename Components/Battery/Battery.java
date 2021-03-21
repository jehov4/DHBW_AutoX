package Components.Battery;

import Components.Charger.Charger3Pol;

import java.util.ArrayList;
import java.util.List;

public class Battery extends BatteryUnit {

    private int temperature = 60;
    private List<IBatteryListener> listeners = new ArrayList<>();

    public Battery(){
        super(null);
        for (int i = 0; i < 32; i++){
            MainCell mainCell = new MainCell(this);
            this.addUnit(mainCell);
            for (int j = 0; j < 8; j++){
                SubCell subCell = new SubCell(mainCell);
                mainCell.addUnit(subCell);
                for (int k = 0; k < 2; k++){
                    Cell cell = new Cell(subCell);
                    subCell.addUnit(cell);
                }
            }
        }
    }

    public void addListener(IBatteryListener listener){
        listeners.add(listener);
    }

    public void reportTemperature(){
        for (IBatteryListener listener : listeners) {
            listener.receiveTemperature(temperature);
        }
    }

    public void charge(Charger3Pol charger3Pol){
        charger3Pol.charge(3);
        for (BatteryUnit unit: units) {
            if (!unit.isComposite()) ((Cell)unit).fill();
        }
    }

}
