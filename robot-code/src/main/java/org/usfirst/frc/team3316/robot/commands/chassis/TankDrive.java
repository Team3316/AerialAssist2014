package org.usfirst.frc.team3316.robot.commands.chassis;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3316.robot.Robot;

public class TankDrive extends Command {
  public TankDrive () {
    requires(Robot.chassis);
  }

  @Override
  protected void execute () {
    double leftVal = Robot.joysticks.getLeftDriver();
    double rightVal = Robot.joysticks.getRightDriver();
    Robot.chassis.move(leftVal, rightVal);
  }

  @Override
  protected boolean isFinished () {
    return false;
  }

  @Override
  protected void end () {
    Robot.chassis.move(0, 0);
  }
}
