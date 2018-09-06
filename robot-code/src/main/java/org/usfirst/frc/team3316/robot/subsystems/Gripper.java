package org.usfirst.frc.team3316.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class Gripper extends DBugSubsystem {
  private DoubleSolenoid.Value openClawValue = Value.kReverse;
  private DoubleSolenoid.Value closeClawValue = Value.kForward;

  private DoubleSolenoid.Value extendGripperValue = Value.kForward;
  private DoubleSolenoid.Value retractGripperValue = Value.kReverse;

  private double collectionVoltage, ejectionVoltage;

  public Gripper () throws ConfigException {
    this.collectionVoltage = (double) Robot.config.get("gripper.collection.voltage");
    this.ejectionVoltage = (double) Robot.config.get("gripper.ejection.voltage");
  }

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

  public void rollIn () {
    Robot.actuators.gripperLeft.set(collectionVoltage);
    Robot.actuators.gripperRight.set(collectionVoltage);
  }

  public void rollOut () {
    Robot.actuators.gripperLeft.set(ejectionVoltage);
    Robot.actuators.gripperRight.set(ejectionVoltage);
  }

  public void stopRolling () {
    Robot.actuators.gripperLeft.set(0);
    Robot.actuators.gripperRight.set(0);
  }

  public boolean isBallIn () {
    boolean isMiddle = Robot.sensors.gripperMiddleSwitch.get();
    boolean isRight = Robot.sensors.gripperRightSwitch.get();
    boolean isIR = Robot.sensors.ballIR.getAverageValue() >= 370; // TODO - Add in config
    return (isMiddle || isRight) && isIR;
  }
}
