package Components;

import Events.LEDDimmedEvent;
import Events.LEDHighBeamEvent;
import Events.LEDOffEvent;
import Events.LEDOnEvent;
import com.google.common.eventbus.Subscribe;

public class LEDHeadlight extends Subscriber {

    private boolean on;
    private boolean dimmed;

    @Subscribe
    private void On(LEDOnEvent ledOnEvent){
        on = true;
        System.out.println("Headlights on");
    }
    @Subscribe
    private void Off(LEDOffEvent ledOffEvent){
        on = false;
        System.out.println("Headlights off");
    }
    @Subscribe
    private void On(LEDDimmedEvent ledDimmedEvent){
        dimmed = true;
        System.out.println("Headlights dimmed");
    }
    @Subscribe
    private void Off(LEDHighBeamEvent ledHighBeamEvent){
        dimmed = false;
        System.out.println("Headlights high beam");
    }

}
