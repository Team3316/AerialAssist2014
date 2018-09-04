/**
 * Le robot actuators
 */
package org.usfirst.frc.team3316.robot.robotIO;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class Actuators {
  Config config = Robot.config;
  DBugLogger logger = Robot.logger;

  /**
   * Kicker
   */
  public Talon kickerLeftCIM, kickerLeftMiniCIM, kickerRightCIM, kickerRightMiniCIM;

  /**
   * Chassis
   */
  public Talon chassisLeftCIM, chassisLeftMiniCIM, chassisRightCIM, chassisRightMiniCIM;

  /**
   * Compressor
   */
  public Compressor compressor;

  /**
   * Defender
   */
  public DoubleSolenoid defenderSolenoid;

  /**
   * Gripper
   */
  public DoubleSolenoid gripperSolenoid, clawSolenoid;

  public Actuators () throws ConfigException {
    if (config.robotA) {
      this.generalActuatorsA();
      this.kickerActuatorsA();
      this.chassisActuatorsA();
      this.defenderActuatorsA();
      this.gripperActuatorsA();
    }
  }

  private void kickerActuatorsA () throws ConfigException {
    this.kickerLeftCIM = new Talon((int) config.get("kicker.motors.leftCIM"));
    this.kickerLeftMiniCIM = new Talon((int) config.get("kicker.motors.leftMiniCIM"));
    this.kickerRightCIM = new Talon((int) config.get("kicker.motors.rightCIM"));
    this.kickerRightMiniCIM = new Talon((int) config.get("kicker.motors.rightMiniCIM"));
  }

  private void chassisActuatorsA () throws ConfigException {
    this.chassisLeftCIM = new Talon((int) config.get("chassis.motors.leftCIM"));
    this.chassisLeftMiniCIM = new Talon((int) config.get("chassis.motors.leftMiniCIM"));
    this.chassisRightCIM = new Talon((int) config.get("chassis.motors.rightCIM"));
    this.chassisRightMiniCIM = new Talon((int) config.get("chassis.motors.rightMiniCIM"));
  }

  private void defenderActuatorsA () throws ConfigException {
    this.defenderSolenoid = new DoubleSolenoid(
        (int) config.get("defender.solenoid.forward"),
        (int) config.get("defender.solenoid.backward")
    );
  }

  private void gripperActuatorsA () throws ConfigException {
    this.gripperSolenoid = new DoubleSolenoid(
        (int) config.get("gripper.solenoid.forward"),
        (int) config.get("gripper.solenoid.backward")
    );

    this.clawSolenoid = new DoubleSolenoid(
        (int) config.get("claw.solenoid.forward"),
        (int) config.get("claw.solenoid.backward")
    );
  }

  private void generalActuatorsA () throws ConfigException {
    this.compressor = new Compressor(0);
    this.compressor.setClosedLoopControl(true);
  }
}
