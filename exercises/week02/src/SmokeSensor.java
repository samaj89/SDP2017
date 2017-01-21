public class SmokeSensor implements Sensor {
    private String location;
    private double batteryPercentage;
    private String sensorType;

    public SmokeSensor(String location) {
        this.location = location;
        this.batteryPercentage = 100.0;
        this.sensorType = "Smoke sensor";
    }

    @Override
    public boolean isTriggered() {
    return false;
  }

    @Override
    public String getLocation() {
    return null;
  }

    @Override
    public String getSensorType() {
    return null;
  }

    @Override
    public double getBatteryPercentage() {
    return -1;
  }
}
