package Components;

import Events.LEDOffEvent;
import Events.LEDOnEvent;
import Events.LidarOffEvent;
import Events.LidarOnEvent;
import com.google.common.eventbus.Subscribe;

public class Lidar extends Subscriber {

    private boolean on;

    @Subscribe
    private void On(LidarOnEvent lidarOnEvent){
        on = true;
        System.out.println("Lidar on");
    }
    @Subscribe
    private void Off(LidarOffEvent lidarOffEvent){
        on = false;
        System.out.println("Lidar off");
    }
}
