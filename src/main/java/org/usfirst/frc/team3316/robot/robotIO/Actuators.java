/**
 * Le robot actuators
 */
package org.usfirst.frc.team3316.robot.robotIO;

import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class Actuators {
  Config config = Robot.config;
  DBugLogger logger = Robot.logger;

  /**
   * Kicker
   */
  public Talon kickerLeftCIM, kickerLeftMiniCIM, kickerRightCIM, kickerRightMiniCIM;

  public Actuators () {
    if (config.robotA) {
      this.kickerActuatorsA();
    }
  }

  private void kickerActuatorsA () {
    this.kickerLeftCIM = new Talon((int) config.get("kicker.motors.leftCIM"));
    this.kickerLeftMiniCIM = new Talon((int) config.get("kicker.motors.leftMiniCIM"));
    this.kickerRightCIM = new Talon((int) config.get("kicker.motors.rightCIM"));
    this.kickerRightMiniCIM = new Talon((int) config.get("kicker.motors.rightMiniCIM"));
  }
}
