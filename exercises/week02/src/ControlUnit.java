import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
    private List<Sensor> sensors;

    public ControlUnit(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void pollSensors() {
        for (Sensor sensor : sensors) {
            if (sensor.isTriggered()) {
                System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
            } else {
                System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
            }
        }
    }
}

/**
 * Q3/5: The original pollSensors() method's responsibilities were to instantiate a list of sensors, instantiate sensors
 * and them to the list of the sensors, then poll all the sensors in the list. By passing ControlUnit a list of sensors
 * in the constructor, we can limit the responsibilities of pollSensors() to just polling all the sensors in the list
 * that was passed in.
 */
