package Components.Indicator;

import Events.LeftIndicatorOffEvent;
import Events.LeftIndicatorOnEvent;
import com.google.common.eventbus.Subscribe;

public class LeftIndicator extends Indicator {
    @Subscribe
    private void indicatorOn(LeftIndicatorOnEvent event){
        on = true;
        System.out.println("Left Indicator on");
    }

    @Subscribe
    private void indicatorOff(LeftIndicatorOffEvent event){
        on = false;
        System.out.println("Left Indicator off");
    }
}
