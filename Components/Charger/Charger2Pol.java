package Components.Charger;

public class Charger2Pol implements ICharger {
    public boolean charge(int pols){
        return pols == 2;
    }
}
