import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsTrueRoughlyTenPercentOfTheTime() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    int count = 0;
    boolean isTriggered;
    for (int i = 0; i < 1000; i++) {
      isTriggered = sensor.isTriggered();
      if (isTriggered) count++;
    }
    assertTrue(count > 90 && count < 110);
  }

  @Test
  public void testThatGetLocationReturnsSpecifiedLocation() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    String location = sensor.getLocation();
    assertEquals("1st floor lobby", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsSmoke() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    String sensorType = sensor.getSensorType();
    assertEquals("Smoke", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100AfterInitiation() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReturns80AfterOnePoll() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(80.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageNeverReturnsLessThanZero() {
    SmokeSensor sensor = new SmokeSensor("1st floor lobby");
    for (int i = 0; i < 6; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0.0, batteryPercentage, 0.01);
  }

}
