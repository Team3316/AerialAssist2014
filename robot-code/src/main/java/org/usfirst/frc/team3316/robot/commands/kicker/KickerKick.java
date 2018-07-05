package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerMotion;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerState;
import org.usfirst.frc.team3316.robot.motion.Trajectory;

public class KickerKick extends KickerCommand {
  private Trajectory trajectory;
  private double normal, timeout;

  public KickerKick () throws ConfigException {
    super();
    this.trajectory = KickerMotion.kickTrajectory();
    this.normal = (double) Robot.config.get("kicker.kick.normal");
    this.timeout = (double) Robot.config.get("kicker.kick.timeout");
  }

  @Override
  protected void init () throws ConfigException {
    setTimeout(this.timeout);
  }

  @Override
  protected void execute () {
    double t = timeSinceInitialized() / this.timeout;
    double v = this.trajectory.fitAngle(t) * this.normal;
    Robot.kicker.move(v);
  }

  @Override
  protected boolean isFinished () {
    return isTimedOut();
  }

  @Override
  protected void fin () {
    this.manager.setState(KickerState.ZERO);
  }

  @Override
  protected void interr () {

  }
}
