package Components;

import Events.CameraOnEvent;
import Events.CameraOffEvent;
import com.google.common.eventbus.Subscribe;


public class Camera extends Subscriber {

    private boolean on;

    @Subscribe
    private void On(CameraOnEvent cameraOnEvent){
        on = true;
        System.out.println("Camera on");
    }
    @Subscribe
    private void Off(CameraOffEvent cameraOffEvent){
        on = false;
        System.out.println("Camera off");
    }
}
