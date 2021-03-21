package Events;

public class IncreaseRPMEvent {
    int amount;
    int time;

    public  IncreaseRPMEvent(int amount, int time){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTime() {
        return time;
    }
}
