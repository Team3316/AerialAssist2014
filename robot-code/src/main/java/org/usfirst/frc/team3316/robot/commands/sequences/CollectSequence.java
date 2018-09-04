package org.usfirst.frc.team3316.robot.commands.sequences;

import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;

public class CollectSequence extends DBugCommandGroup {
  public CollectSequence () {
    addSequential(new ClawAction(GripperActionType.RETRACT));
    addSequential(new GripperAction(GripperActionType.EXTEND));
    addSequential(new GripperAction(GripperActionType.ROLLIN));
    addSequential(new GripperAction(GripperActionType.RETRACT));
  }
}
