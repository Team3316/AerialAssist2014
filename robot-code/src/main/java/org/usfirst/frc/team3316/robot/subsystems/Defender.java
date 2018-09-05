package org.usfirst.frc.team3316.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc.team3316.robot.Robot;

public class Defender extends DBugSubsystem {
  private Value closeValue = Value.kForward;
  private Value openValue = Value.kReverse;

  @Override
  public void initDefaultCommand () {
    // Nothin' here
  }

  public void close () {
    Robot.actuators.defenderSolenoid.set(this.closeValue);
  }

  public void open () {
    Robot.actuators.defenderSolenoid.set(this.openValue);
  }
}
