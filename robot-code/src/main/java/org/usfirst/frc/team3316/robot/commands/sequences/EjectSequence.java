package org.usfirst.frc.team3316.robot.commands.sequences;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;
import org.usfirst.frc.team3316.robot.commands.tusks.TusksAction;

public class EjectSequence extends DBugCommandGroup {
  public EjectSequence () {
    addSequential(new ClawAction(GripperActionType.RETRACT));
    addSequential(new TusksAction(DefenderActionType.CLOSE));
    addSequential(new WaitCommand(0.3));
    addSequential(new GripperAction(GripperActionType.ROLLOUT));
  }
}
