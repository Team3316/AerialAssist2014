package org.usfirst.frc.team3316.robot.subsystems.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerShaken;
import org.usfirst.frc.team3316.robot.subsystems.DBugSubsystem;

public class Kicker extends DBugSubsystem {

  @Override
  public void initDefaultCommand () {
    setDefaultCommand(new KickerShaken(0.0));
  }

  public void move (double voltage) {
    Robot.actuators.kickerLeftCIM.set(-voltage);
    Robot.actuators.kickerLeftMiniCIM.set(-voltage);

    Robot.actuators.kickerRightCIM.set(voltage);
    Robot.actuators.kickerRightMiniCIM.set(voltage);
  }

  public double getAngle () {
    return Robot.sensors.kickerEncoder.getDistance();
  }

  public double getAngularVelocity () {
    return Robot.sensors.kickerEncoder.getRate();
  }

  public void resetEncoder () {
    Robot.sensors.kickerEncoder.reset();
  }

  public boolean isResting () {
    return Robot.sensors.kickerRestingHE.get();
  }
}
