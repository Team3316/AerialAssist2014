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
    if (this.type == GripperActionType.EXTEND) {
      Robot.gripper.extendGripper();
    } else {
      Robot.gripper.retractGripper();
    }
  }

  @Override
  protected boolean isFinished () {
    return false;
  }

  @Override
  protected void fin () {

  }

  @Override
  protected void interr () {

  }
}
