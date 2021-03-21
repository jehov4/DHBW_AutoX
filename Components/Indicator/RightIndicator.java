package Components.Indicator;

import Events.RightIndicatorOffEvent;
import Events.RightIndicatorOnEvent;
import com.google.common.eventbus.Subscribe;

public class RightIndicator extends Indicator {
    @Subscribe
    private void indicatorOn(RightIndicatorOnEvent event){
        on = true;
        System.out.println("Right Indicator on");
    }

    @Subscribe
    private void indicatorOff(RightIndicatorOffEvent event){
        on = false;
        System.out.println("Right Indicator off");
    }
}
