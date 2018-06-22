package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;

/**
 * Bang-bang control on the kicker's position for holding it in place while driving.
 */
public class KickerShaken extends DBugCommand {
  private double setpoint, voltage, tolerance;

  public KickerShaken (double setpoint) {
    requires(Robot.kicker);
    this.setpoint = setpoint;
  }

  @Override
  protected void init () {
    this.voltage = (double) Robot.config.get("kicker.shaken.voltage");
    this.tolerance = (double) Robot.config.get("kicker.shaken.tolerance");
    Robot.kicker.setState(KickerState.SHAKEN);
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
    Robot.kicker.resetEncoder();
    Robot.kicker.setState(KickerState.OFF);
  }

  @Override
  protected void interr () {

  }
}
