/**
 * Le robot sensors
 */
package org.usfirst.frc.team3316.robot.robotIO;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class Sensors 
{
	Config config = Robot.config;
	DBugLogger logger = Robot.logger;

  /**
   * Kicker
   */
  public Encoder kickerEncoder;
  public DigitalInput kickerRestingHE;
	
	public Sensors () {
		if (config.robotA) {
		  this.kickerSensorsA();
    }
	}

	private void kickerSensorsA () {
	  this.kickerEncoder = new Encoder(
	      (int) config.get("kicker.encoder.channelA"),
	      (int) config.get("kicker.encoder.channelB"),
        false, EncodingType.k4X
    );
	  this.kickerEncoder.setDistancePerPulse((double) config.get("kicker.encoder.distPerPulse"));

	  this.kickerRestingHE = new DigitalInput((int) Robot.config.get("kicker.restingHallEffect"));
  }
}
