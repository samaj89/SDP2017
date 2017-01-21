public class FireSensor implements Sensor {
    private String location;
    private double batteryPercentage;
    private String sensorType;

    public FireSensor(String location) {
        this.location = location;
        this.batteryPercentage = 100.0;
        this.sensorType = "Fire sensor";
    }

  @Override
  public boolean isTriggered() {
    return Math.random() < 0.05;
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
