package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;

/**
 * Zeroing the kicker into starting position
 */
public class KickerZero extends KickerCommand {
  private double voltage;

  @Override
  protected void init () {
    this.voltage = (double) Robot.config.get("kicker.zero.voltage");
    this.manager.setState(KickerState.ZERO);
  }

  @Override
  protected void execute () {
    Robot.kicker.move(this.voltage);
  }

  @Override
  protected boolean isFinished () {
    return Robot.kicker.isResting();
  }

  @Override
  protected void fin () {
    this.manager.setState(KickerState.OFF);
  }

  @Override
  protected void interr () {
    this.fin();
  }
}
