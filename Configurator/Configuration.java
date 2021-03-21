package Configurator;

public class Configuration {
    private boolean rejectDrunkenPassenger = false;
    private boolean stopByPoliceRequest = true;
    private boolean allowDriveByNight = true;
    private String behaviorWithNaggingPassengers = "stopWaitforExcuse";
    private String musicDuringDrive = "ac/dc";

    public  Configuration (Configuration configuration){
        this.rejectDrunkenPassenger = configuration.isRejectDrunkenPassenger();
        this.stopByPoliceRequest = configuration.isStopByPoliceRequest();
        this.allowDriveByNight = configuration.isAllowDriveByNight();
        this.behaviorWithNaggingPassengers = configuration.getBehaviorWithNaggingPassengers();
        this.musicDuringDrive = configuration.getMusicDuringDrive();
    }

    public Configuration(){

    }

    public void print(){
        System.out.println(String.format("[1] %-36s - %s", "Reject drunken Passenger", rejectDrunkenPassenger));
        System.out.println(String.format("[2] %-36s - %s", "Stop by police Request", stopByPoliceRequest));
        System.out.println(String.format("[3] %-36s - %s", "Allow drive by night", allowDriveByNight));
        System.out.println(String.format("[4] %-36s - %s", "Behavior with nagging Passengers", behaviorWithNaggingPassengers));
        System.out.println(String.format("[5] %-36s - %s", "Music during drive", musicDuringDrive));
    }

    public boolean printConfigurationOption(int option){
        switch (option){
            case 1:
                System.out.println("enter value for Reject drunken passenger | current " + rejectDrunkenPassenger + " allowed [true/false] > ");
                break;
            case 2:
                System.out.println("enter value for Stop by police Request | current " + stopByPoliceRequest + " allowed [true/false] > ");
                break;
            case 3:
                System.out.println("enter value for Allow drive by night | current " + allowDriveByNight + " allowed [true/false] > ");
                break;
            case 4:
                System.out.println("enter value for Behavior with nagging Passengers | current " + behaviorWithNaggingPassengers + " allowed [doNothing/stopAndWaitForExcuse] > ");
                break;
            case 5:
                System.out.println("enter value for Music during drive | current " + musicDuringDrive + " allowed [ac/dc/helene fischer] > ");
                break;
            default:
                System.out.println("Option " + option + " not found");
                return false;
        }
        return true;
    }

    public boolean newValue(int option, String value){
        switch (option){
            case 1:
                if (value.equals("true")){
                    rejectDrunkenPassenger = true;
                    return true;
                } else if (value.equals("false")){
                    rejectDrunkenPassenger = false;
                    return true;
                }
            case 2:
                if (value.equals("true")){
                    stopByPoliceRequest = true;
                    return true;
                } else if (value.equals("false")){
                    stopByPoliceRequest = false;
                    return true;
                }
            case 3:
                if (value.equals("true")){
                    allowDriveByNight = true;
                    return true;
                } else if (value.equals("false")){
                    allowDriveByNight = false;
                    return true;
                }
            case 4:
                if (value.equals("doNothing") || value.equals("stopAndWaitForExcuse")){
                    behaviorWithNaggingPassengers = value;
                    return true;
                }

            case 5:
                if (value.equals("ac/dc") || value.equals("helene fischer")){
                    musicDuringDrive = value;
                    return true;
                }
            default:
                System.out.println("Invalid Input try again > ");
                return false;
        }
    }

    public boolean isRejectDrunkenPassenger() {
        return rejectDrunkenPassenger;
    }

    public boolean isStopByPoliceRequest() {
        return stopByPoliceRequest;
    }

    public boolean isAllowDriveByNight() {
        return allowDriveByNight;
    }

    public String getBehaviorWithNaggingPassengers() {
        return behaviorWithNaggingPassengers;
    }

    public String getMusicDuringDrive() {
        return musicDuringDrive;
    }

    public void setRejectTrunkenPassenger(boolean rejectTrunkenPassenger) {
        this.rejectDrunkenPassenger = rejectTrunkenPassenger;
    }

    public void setStopByPoliceRequest(boolean stopByPoliceRequest) {
        this.stopByPoliceRequest = stopByPoliceRequest;
    }

    public void setAllowDriveByNight(boolean allowDriveByNight) {
        this.allowDriveByNight = allowDriveByNight;
    }

    public void setBehaviorWithNaggingPassengers(String behaviorWithNaggingPassengers) {
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
    }

    public void setMusicDuringDrive(String musicDuringFrive) {
        this.musicDuringDrive = musicDuringFrive;
    }
}
