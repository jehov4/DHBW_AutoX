package Components.Engine;
import Components.Battery.Battery;
import Components.ContorlUnit;
import Components.Subscriber;
import Events.DecreaseRMPEvent;
import Events.EngineOffEvent;
import Events.EngineOnEvent;
import Events.IncreaseRPMEvent;
import com.google.common.eventbus.Subscribe;

public abstract class IElectricEngine extends Subscriber {

    protected boolean on = false;
    protected int RPM = 0;
    protected int consumption;
    protected Battery battery = new Battery();

    public IElectricEngine(ContorlUnit controlUnit){
        battery.addListener(controlUnit);
    }

    public Battery getBattery() {
        return battery;
    }

    @Subscribe
    public boolean move(){
        if (!battery.discharge(consumption)){
            System.out.println("Battery empty");
            return false;
        }
        return true;
    }

    @Subscribe
    private void On(EngineOnEvent engineOnEvent){
        on = true;
        System.out.println("Engine on");
    }
    @Subscribe
    private void Off(EngineOffEvent engineOffEvent){
        on = false;
        System.out.println("Engine off");
    }
    @Subscribe
    private void Increase(IncreaseRPMEvent increaseRPMEvent){
        if(!move()) return;
        RPM = increaseRPMEvent.getAmount();
        System.out.println("Increased RPM by " + increaseRPMEvent.getAmount() + " in " + increaseRPMEvent.getTime());
    }
    @Subscribe
    private void Decrease(DecreaseRMPEvent decreaseRMPEvent){
        if(!move()) return;
        RPM = decreaseRMPEvent.getAmount();
        System.out.println("Decreased RPM by " + decreaseRMPEvent.getAmount() + " in " + decreaseRMPEvent.getTime());
    }


}
