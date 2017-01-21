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
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor("Lobby 1st floor");
    String location = sensor.getLocation();
    assertEquals(null, location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor("Lobby 1st floor");
    String sensorType = sensor.getSensorType();
    assertEquals(null, sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor("Lobby 1st floor");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }
}
