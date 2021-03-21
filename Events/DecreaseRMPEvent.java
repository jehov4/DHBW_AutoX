package Events;

public class DecreaseRMPEvent {

    int amount;
    int time;

    public  DecreaseRMPEvent(int amount, int time){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTime() {
        return time;
    }
}
