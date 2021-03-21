package Components.Charger;

public class Charger3Pol {

    public boolean charge(int pols){
        var charger = new Charger2Pol();
        return pols == 3 && charger.charge(2);
    }
}
