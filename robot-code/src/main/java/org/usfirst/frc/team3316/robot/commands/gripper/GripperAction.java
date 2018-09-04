package org.usfirst.frc.team3316.robot.commands.gripper;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class GripperAction extends DBugCommand {
  private GripperActionType type;

  public GripperAction (GripperActionType type) {
    requires(Robot.gripper);
    this.type = type;
  }

  @Override
  protected void init () throws ConfigException {

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
    switch (this.type) {
      case ROLLIN: return Robot.gripper.isBallIn();
      case ROLLOUT: return !Robot.gripper.isBallIn();
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

  }
}
