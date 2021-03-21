package Components.Indicator;

import Components.Subscriber;
import Events.BrakeSetEvent;
import com.google.common.eventbus.Subscribe;

public abstract class Indicator extends Subscriber {
    boolean on = false;

}
