package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerMotion;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;
import org.usfirst.frc.team3316.robot.utils.Trajectory;

/**
 * Zeroing the kicker into starting position
 */
public class KickerZero extends KickerCommand {
  private Trajectory trajectory;
  private double voltage, duration;

  public KickerZero () throws ConfigException {
    super();
    this.voltage = (double) Robot.config.get("kicker.zero.voltage");
    this.duration = (double) Robot.config.get("kicker.zero.duration");
    this.trajectory = KickerMotion.zeroTrajectory();
  }

  @Override
  protected void init () {
    setTimeout(this.duration);
  }

  @Override
  protected void execute () {
    double t = timeSinceInitialized() * this.duration;
    double v = this.trajectory.fitAngle(t) * this.voltage;
    Robot.kicker.move(v);
  }

  @Override
  protected boolean isFinished () {
    return isTimedOut() || Robot.kicker.isResting();
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
