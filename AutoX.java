import Components.*;
import Components.Door.Door;
import Components.Engine.EngineNG;
import Components.Engine.EngineX;
import Components.Engine.IElectricEngine;
import Components.Indicator.Indicator;
import Components.Indicator.LeftIndicator;
import Components.Indicator.RightIndicator;
import Components.Ultrasonic.UltrasonicSensor;
import Configuration.Configuration;
import Variants.MotorVariant;

public class AutoX {
    private Chassis[] chassis;
    private Components.Engine.IElectricEngine[] IElectricEngine;
    private LEDHeadlight[] ledHeadlight;
    private BreakLight[] breakLight;
    private Indicator[] rightIndicator;
    private Indicator[] leftIndicator;
    private Door[] door;
    private Seat[] seat;
    private Wheel[] wheel;
    private Break[] break_;
    private GPS[] gps;
    private Camera[] camera;
    private Lidar[] lidar;
    private UltrasonicSensor[] ultrasonic;

    public AutoX(Builder builder){
            this.chassis = builder.chassis;
            this.IElectricEngine = builder.iElectricEngine;
            this.ledHeadlight = builder.ledHeadlight;
            this.breakLight = builder.breakLight;
            this.leftIndicator = builder.leftIndicator;
            this.rightIndicator = builder.rightIndicator;
            this.door = builder.door;
            this.seat = builder.seat;
            this.wheel = builder.wheel;
            this.break_ = builder.break_;
            this.gps = builder.gps;
            this.camera = builder.camera;
            this.lidar = builder.lidar;
            this.ultrasonic = builder.ultrasonic;
    }

    public static AutoX BuildAutoX(){

        return new Builder()
                .Chassis(Configuration.instance.ChassisCount)
                .ElectricEngine(Configuration.instance.EngineCount)
                .LEDHeadlight(Configuration.instance.HeadLightsCount)
                .BreakLight(Configuration.instance.BreakLightsCount)
                .LeftIndicator(Configuration.instance.LeftIndicatorCount)
                .RightIndicator(Configuration.instance.RightIndicatorCount)
                .Door(Configuration.instance.DoorCount)
                .Seat(Configuration.instance.SeatCount)
                .Wheel(Configuration.instance.WheelCount)
                .Break(Configuration.instance.BreakCount)
                .GPS(Configuration.instance.GPSCount)
                .Lidar(Configuration.instance.LidarCount)
                .Ultrasonic(Configuration.instance.UltrasonicSensorCount)
                .build();

    }

    public static class Builder {

        ContorlUnit contorlUnit = new ContorlUnit();

        Chassis[] chassis;
        IElectricEngine[] iElectricEngine;
        LEDHeadlight[] ledHeadlight;
        BreakLight[] breakLight;
        Indicator[] leftIndicator;
        Indicator[] rightIndicator;
        Door[] door;
        Seat[] seat;
        Wheel[] wheel;
        Break[] break_;
        GPS[] gps;
        Camera[] camera;
        Lidar[] lidar;
        UltrasonicSensor[] ultrasonic;

        public Builder Chassis(int amount){
            chassis = new Chassis[amount];
            for (; amount > 0; amount--){
                chassis[amount] = new Chassis();
            }
            return this;
        }
        public Builder ElectricEngine(int amount){
            iElectricEngine = new IElectricEngine[amount];
            for (; amount > 0; amount--){

                iElectricEngine[amount] = Configuration.instance.motorVariant.equals(MotorVariant.EngineX) ? new EngineX(contorlUnit) : new EngineNG(contorlUnit);
                contorlUnit.addSubscriber(iElectricEngine[amount]);
            }
            return this;
        }
        public Builder Lidar (int amount){
            lidar = new Lidar[amount];
            for (; amount > 0; amount--){
                lidar[amount] = new Lidar();
                contorlUnit.addSubscriber(lidar[amount]);
            }
            return this;
        }
        public Builder LEDHeadlight(int amount){
            ledHeadlight = new LEDHeadlight[amount];
            for (; amount > 0; amount--){
                ledHeadlight[amount] = new LEDHeadlight();
                contorlUnit.addSubscriber(ledHeadlight[amount]);
            }
            return this;
        }
        public Builder BreakLight(int amount){
            breakLight = new BreakLight[amount];
            for (; amount > 0; amount--){
                breakLight[amount] = new BreakLight();
                contorlUnit.addSubscriber(breakLight[amount]);
            }
            return this;
        }
        public Builder RightIndicator(int amount){
            rightIndicator = new RightIndicator[amount];
            for (; amount > 0; amount--){
                rightIndicator[amount] = new RightIndicator();
                contorlUnit.addSubscriber(rightIndicator[amount]);
            }
            return this;
        }
        public Builder LeftIndicator(int amount){
            leftIndicator = new LeftIndicator[amount];
            for (; amount > 0; amount--){
                leftIndicator[amount] = new LeftIndicator();
                contorlUnit.addSubscriber(leftIndicator[amount]);
            }
            return this;
        }
        public Builder Door(int amount){
            door = new Door[amount];
            for (; amount > 0; amount--){
                door[amount] = new Door();
                contorlUnit.addSubscriber(door[amount]);
            }
            return this;
        }
        public Builder Seat(int amount){
            seat = new Seat[amount];
            for (; amount > 0; amount--){
                seat[amount] = new Seat();
            }
            return this;
        }
        public Builder Wheel(int amount){
            wheel = new Wheel[amount];
            for (; amount > 0; amount--){
                wheel[amount] = new Wheel();
            }
            return this;
        }
        public Builder Break(int amount){
            break_ = new Break[amount];
            for (; amount > 0; amount--){
                break_[amount] = new Break();
                contorlUnit.addSubscriber(break_[amount]);
            }
            return this;
        }
        public Builder GPS(int amount){
            gps = new GPS[amount];
            for (; amount > 0; amount--){
                gps[amount] = new GPS();
                contorlUnit.addSubscriber(gps[amount]);
            }
            return this;
        }
        public Builder Camera(int amount){
            camera = new Camera[amount];
            for (; amount > 0; amount--){
                camera[amount] = new Camera();
                contorlUnit.addSubscriber(camera[amount]);
            }
            return this;
        }
        public Builder Ultrasonic(int amount){
            ultrasonic = new UltrasonicSensor[amount];
            for (; amount > 0; amount--){
                var sensor = new UltrasonicSensor(amount);
                sensor.addListener(contorlUnit);
                ultrasonic[amount] = sensor;
            }
            return this;
        }

        public AutoX build() {
            return new AutoX(this);
        }
    }
}


