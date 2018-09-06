package org.usfirst.frc.team3316.robot.commands.sequences;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;
import org.usfirst.frc.team3316.robot.commands.tusks.TusksAction;

public class CollectSequence extends DBugCommandGroup {
  public CollectSequence () {
    addSequential(new TusksAction(DefenderActionType.CLOSE));
    addSequential(new ClawAction(GripperActionType.RETRACT));
    addSequential(new GripperAction(GripperActionType.EXTEND));
    addSequential(new GripperAction(GripperActionType.ROLLIN));
    addSequential(new GripperAction(GripperActionType.RETRACT));
    addSequential(new ClawAction(GripperActionType.RETRACT));
    addSequential(new WaitCommand(2));
    addSequential(new TusksAction(DefenderActionType.OPEN));
  }
}
