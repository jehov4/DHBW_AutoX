package Events;

public class GPSConnectSatelliteEvent {

    double frequency;

    public  GPSConnectSatelliteEvent(double frequency){
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }
}
