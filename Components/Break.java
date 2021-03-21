package Components;
import Events.BrakeSetEvent;
import com.google.common.eventbus.Subscribe;

public class Break extends Subscriber {

    private int amount;

    @Subscribe
    private void setBreak(BrakeSetEvent brakeSetEvent){
        amount = brakeSetEvent.getAmount();
        System.out.println("Brakes set to " + amount);
    }
}
