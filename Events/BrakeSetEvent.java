package Events;

public class BrakeSetEvent {

    int amount;

    public  BrakeSetEvent(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
