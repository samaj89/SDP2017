public class FireSensor extends HazardSensor implements BatteryPoweredSensor {
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
        if (getBatteryPercentage() != 0.0) batteryPercentage -= 10;
        return Math.random() < 0.05;
    }

    @Override
    public String getLocation() {
    return location;
  }

    @Override
    public String getSensorType() {
    return sensorType;
  }

    @Override
    public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
