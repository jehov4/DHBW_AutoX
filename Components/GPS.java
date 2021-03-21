package Components;

import Events.GPSOnEvent;
import Events.GPSOffEvent;
import Events.GPSConnectSatelliteEvent;
import com.google.common.eventbus.Subscribe;

public class GPS extends Subscriber {

    private boolean on;
    private double satellite;

    @Subscribe
    private void On(GPSOnEvent gpsOnEvent){
        on = true;
        System.out.println("GPS on");
    }
    @Subscribe
    private void Off(GPSOffEvent gpsOffEvent){
        on = false;
        System.out.println("GPS off");
    }
    @Subscribe
    private void Connect(GPSConnectSatelliteEvent gpsConnectSatelliteEvent){
        satellite = gpsConnectSatelliteEvent.getFrequency();
        System.out.println("GPS connected to " + satellite);
    }
}
