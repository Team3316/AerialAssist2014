package org.usfirst.frc.team3316.robot.subsystems;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.chassis.TankDrive;

public class Chassis extends DBugSubsystem {
  @Override
  public void initDefaultCommand () {
    setDefaultCommand(new TankDrive());
  }

  public void move (double leftVoltage, double rightVoltage) {
    Robot.actuators.chassisLeftCIM.set(leftVoltage);
    Robot.actuators.chassisLeftMiniCIM.set(leftVoltage);

    Robot.actuators.chassisRightCIM.set(-rightVoltage);
    Robot.actuators.chassisRightMiniCIM.set(-rightVoltage);
  }
}
