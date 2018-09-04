/**
 * Le robot sensors
 */
package org.usfirst.frc.team3316.robot.robotIO;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
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

	/**
	 * Gripper
	 */
	public DigitalInput gripperLeftSwitch, gripperMiddleSwitch, gripperRightSwitch;

	public Sensors () throws ConfigException {
		if (config.robotA) {
		  this.kickerSensorsA();
		  this.gripperSensorsA();
    }
	}

	private void kickerSensorsA () throws ConfigException {
	  this.kickerEncoder = new Encoder(
	      (int) config.get("kicker.encoder.channelA"),
	      (int) config.get("kicker.encoder.channelB"),
        false, EncodingType.k1X
    );
	  this.kickerEncoder.setDistancePerPulse((double) config.get("kicker.encoder.distPerPulse"));
	  this.kickerEncoder.reset();

	  this.kickerRestingHE = new DigitalInput((int) config.get("kicker.restingHallEffect"));
  }

  private void gripperSensorsA () throws ConfigException {
		this.gripperLeftSwitch = new DigitalInput((int) config.get("gripper.switches.left"));
		this.gripperMiddleSwitch = new DigitalInput((int) config.get("gripper.switches.middle"));
		this.gripperRightSwitch = new DigitalInput((int) config.get("gripper.switches.right"));
	}
}
