package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;

/**
 * Bang-bang control on the kicker's position for holding it in place while driving.
 */
public class KickerShaken extends KickerCommand {
  private double setpoint, voltage, tolerance;

  public KickerShaken (double setpoint) {
    requires(Robot.kicker);
    this.setpoint = setpoint;
  }

  public KickerShaken () {
    this(Robot.kicker.getAngle());
  }

  @Override
  protected void init () throws ConfigException {
    this.voltage = (double) Robot.config.get("kicker.shaken.voltage");
    this.tolerance = (double) Robot.config.get("kicker.shaken.tolerance");
  }

  @Override
  protected void execute () {
    double encoderValue = Robot.kicker.getAngle();
    if (setpoint < encoderValue - setpoint) {
      Robot.kicker.move(voltage);
    } else if (setpoint > encoderValue + setpoint) {
      Robot.kicker.move(-voltage);
    }
  }

  @Override
  protected boolean isFinished () {
    double encoderValue = Robot.kicker.getAngle();
    return encoderValue - tolerance <= setpoint && setpoint <= encoderValue + tolerance;
  }

  @Override
  protected void fin () {
    this.manager.setState(KickerState.RESTING);
  }

  @Override
  protected void interr () {

  }
}
