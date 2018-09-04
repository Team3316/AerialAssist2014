package org.usfirst.frc.team3316.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc.team3316.robot.Robot;

public class Gripper extends DBugSubsystem {
  private DoubleSolenoid.Value openClawValue = Value.kForward;
  private DoubleSolenoid.Value closeClawValue = Value.kReverse;

  private DoubleSolenoid.Value extendGripperValue = Value.kForward;
  private DoubleSolenoid.Value retractGripperValue = Value.kReverse;

  @Override
  public void initDefaultCommand () {
    // Nothin' here
  }

  public void openClaw () {
    Robot.actuators.clawSolenoid.set(this.openClawValue);
  }

  public void closeClaw () {
    Robot.actuators.clawSolenoid.set(this.closeClawValue);
  }

  public void extendGripper () {
    Robot.actuators.gripperSolenoid.set(this.extendGripperValue);
  }

  public void retractGripper () {
    Robot.actuators.gripperSolenoid.set(this.retractGripperValue);
  }
}
