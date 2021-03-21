package Configuration;

import Variants.*;

public enum Configuration {
    instance;

    public CamaraVariant camaraVariant = CamaraVariant.CameraV1;
    public LidarVariant lidarVariant = LidarVariant.LidarNG;
    public MotorVariant motorVariant = MotorVariant.EngineNG;
    public int ChassisCount = 1;
    public int EngineCount = 2;
    public int HeadLightsCount = 2;
    public int BreakLightsCount = 2;
    public int LeftIndicatorCount = 2;
    public int RightIndicatorCount = 2;
    public int DoorCount = 4;
    public int SeatCount = 6;
    public int WheelCount = 4;
    public int BreakCount = 8;
    public int GPSCount = 2;
    public int CameraCount = 2;
    public int LidarCount = 4;
    public int UltrasonicSensorCount = 8;

}
