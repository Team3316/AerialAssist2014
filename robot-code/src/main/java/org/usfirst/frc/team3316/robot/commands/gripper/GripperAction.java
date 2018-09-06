package org.usfirst.frc.team3316.robot.commands.gripper;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class GripperAction extends DBugCommand {
  private long startTime, delay;
  private GripperActionType type;

  public GripperAction (GripperActionType type) {
    requires(Robot.gripper);
    this.type = type;
    this.delay = (long) 3000; // 2 seconds in milliseconds
  }

  @Override
  protected void init () throws ConfigException {
    this.startTime = System.currentTimeMillis();
  }

  @Override
  protected void execute () {
    switch (this.type) {
      case EXTEND:
        Robot.gripper.extendGripper();
        return;
      case RETRACT:
        Robot.gripper.retractGripper();
        return;
      case ROLLIN:
        Robot.gripper.rollIn();
        return;
      case ROLLOUT:
        Robot.gripper.rollOut();
        return;
      case STOP:
        Robot.gripper.stopRolling();
        return;
      default:
        Robot.gripper.stopRolling();
        return;
    }
  }

  @Override
  protected boolean isFinished () {
    long err = System.currentTimeMillis() - this.startTime;
    switch (this.type) {
      case ROLLIN: return Robot.gripper.isBallIn() && err >= this.delay;
      case ROLLOUT: return !Robot.gripper.isBallIn() && err >= this.delay;
      default: return true;
    }
  }

  @Override
  protected void fin () {
    switch (this.type) {
      case ROLLIN:
      case ROLLOUT:
        Robot.gripper.stopRolling();
        return;
      default:
          return;
    }
  }

  @Override
  protected void interr () {
    this.fin();
  }
}
