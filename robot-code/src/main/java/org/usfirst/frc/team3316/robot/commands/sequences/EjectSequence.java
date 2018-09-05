package org.usfirst.frc.team3316.robot.commands.sequences;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;

public class EjectSequence extends DBugCommandGroup {
  public EjectSequence () {
    addSequential(new ClawAction(GripperActionType.EXTEND));
    addSequential(new GripperAction(GripperActionType.EXTEND));
    addSequential(new WaitCommand(1.5));
    addSequential(new GripperAction(GripperActionType.RETRACT));
    addSequential(new ClawAction(GripperActionType.RETRACT));
  }
}
