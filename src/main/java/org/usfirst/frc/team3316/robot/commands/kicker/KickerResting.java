package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;

public class KickerResting extends KickerCommand {
  public KickerResting () {
    requires(Robot.kicker);
  }

  @Override
  protected void init () throws ConfigException {
    Robot.kicker.resetEncoder();
  }

  @Override
  protected void execute () {
    Robot.kicker.move(0);
  }

  @Override
  protected boolean isFinished () {
    return Robot.kicker.isResting();
  }

  @Override
  protected void fin () {
    this.manager.setState(KickerState.SHAKEN);
  }

  @Override
  protected void interr () {
    this.fin();
  }
}
