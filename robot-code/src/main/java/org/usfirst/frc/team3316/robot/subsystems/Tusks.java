package org.usfirst.frc.team3316.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc.team3316.robot.Robot;

public class Tusks extends DBugSubsystem {
  private Value openValue = Value.kReverse;
  private Value closeValue = Value.kForward;

  @Override
  public void initDefaultCommand () {
    // Nothin' here
  }

  public void open () {
    Robot.actuators.tusksSolenoid.set(this.openValue);
  }

  public void close () {
    Robot.actuators.tusksSolenoid.set(this.closeValue);
  }
}
