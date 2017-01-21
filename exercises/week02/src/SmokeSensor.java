public class SmokeSensor extends HazardSensor implements BatteryPoweredSensor {
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
        if (getBatteryPercentage() != 0.0) batteryPercentage -= 20;
        return Math.random() < 0.1;
    }

    @Override
    public String getLocation() {
    return location;
  }

    @Override
    public String getSensorType() { return sensorType; }

    @Override
    public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
