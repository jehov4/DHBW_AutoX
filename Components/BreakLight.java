package Components;
import Events.BrakeLightOnEvent;
import Events.BrakeLightOffEvent;
import com.google.common.eventbus.Subscribe;

public class BreakLight extends Subscriber {

    boolean on;

    @Subscribe
    private void lightsOn(BrakeLightOnEvent brakeLightOnEvent){
        on = true;
        System.out.println("Brake Lights on");
    }
    @Subscribe
    private void lightsOff(BrakeLightOffEvent brakeLightOffEvent){
        on = false;
        System.out.println("Brake Lights off");
    }

}
