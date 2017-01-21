import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeSensorTest {

    @Test
    public void testThatIsTriggeredReturnsTrueAroundTenPercentOfTheTime() {
      SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
      int count = 0;
      boolean isTriggered;
      for (int i = 0; i < 1000; i++) {
        isTriggered = sensor.isTriggered();
        if (isTriggered) count++;
      }
      assertTrue(count > 90 && count < 110);
    }

  @Test
  public void testThatGetLocationReturnsLocationInputAtConstructor() {
    SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
    String location = sensor.getLocation();
    assertEquals("Lobby 1st floor", location);
  }


  @Test
  public void testThatGetSensorTypeReturnsFireSensor() {
    SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
    String sensorType = sensor.getSensorType();
    assertEquals("Smoke sensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100AfterInstantiation() {
    SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageReturns80AfterOnePoll() {
    SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
    sensor.isTriggered();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(80.0, batteryPercentage, 0.01);
  }

  @Test
  public void testThatGetBatteryPercentageNeverReturnsLessThanZero() {
    SmokeSensor sensor = new SmokeSensor("Lobby 1st floor");
    for (int i = 0; i < 6; i++) {
      sensor.isTriggered();
    }
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(0.0, batteryPercentage, 0.01);
  }
}
