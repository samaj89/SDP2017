/**
 * Created by samaj on 21/01/17.
 */
public class MotionSensor extends SecuritySensor {
    private String location;
    private String sensorType;

    public MotionSensor(String location) {
        this.location = location;
        this.sensorType = "Motion sensor";
    }

    @Override
    public boolean isTriggered() {
        return Math.random() < 0.05;
    }

    @Override
    public String getLocation() { return location; }

    @Override
    public String getSensorType() { return sensorType; }
}
