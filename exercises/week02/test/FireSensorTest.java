import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsTrueRoughlyFivePercentOfTheTime() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    int count = 0;
    boolean isTriggered;
    for (int i = 0; i < 1000; i++) {
      isTriggered = sensor.isTriggered();
      if (isTriggered) count++;
    }
    assertTrue(count > 40 && count < 60);
  }

  @Test
  public void testThatGetLocationReturnsSpecifiedLocation() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    String location = sensor.getLocation();
    assertEquals("1st floor lobby", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsFire() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    String sensorType = sensor.getSensorType();
    assertEquals("Fire", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100AfterInitiation() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReturns90AfterOnePoll() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(90.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageNeverReturnsLessThanZero() {
    FireSensor sensor = new FireSensor("1st floor lobby");
    for (int i = 0; i < 11; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0.0, batteryPercentage, 0.01);
  }
}
