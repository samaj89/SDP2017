import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FireSensorTest {

    @Test
    public void testThatIsTriggeredReturnsTrueAroundFivePercentOfTheTime() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        int count = 0;
        boolean isTriggered;
        for (int i = 0; i < 1000; i++) {
            isTriggered = sensor.isTriggered();
            if (isTriggered) count++;
        }
        assertTrue(count > 40 && count < 60);
    }

    @Test
    public void testThatGetLocationReturnsLocationInputAtConstructor() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        String location = sensor.getLocation();
        assertEquals("Lobby 1st floor", location);
    }


    @Test
    public void testThatGetSensorTypeReturnsFireSensor() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        String sensorType = sensor.getSensorType();
        assertEquals("Fire sensor", sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturns100AfterInstantiation() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(100.0, batteryPercentage, 0.01);
    }

    @Test
    public void testThatGetBatteryPercentageReturns90AfterOnePoll() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        sensor.isTriggered();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(90.0, batteryPercentage, 0.01);
    }

    @Test
    public void testThatGetBatteryPercentageNeverReturnsLessThanZero() {
        FireSensor sensor = new FireSensor("Lobby 1st floor");
        for (int i = 0; i < 11; i++) {
            sensor.isTriggered();
        }
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(0.0, batteryPercentage, 0.01);
    }
}
