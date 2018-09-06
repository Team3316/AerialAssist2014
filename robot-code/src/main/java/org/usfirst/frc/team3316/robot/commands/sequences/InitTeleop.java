package org.usfirst.frc.team3316.robot.commands.sequences;

import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderAction;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;
import org.usfirst.frc.team3316.robot.commands.tusks.TusksAction;

public class InitTeleop extends DBugCommandGroup {
  public InitTeleop () {
    addParallel(new DefenderAction(DefenderActionType.CLOSE));
    addParallel(new GripperAction(GripperActionType.RETRACT));
    addParallel(new ClawAction(GripperActionType.EXTEND));
    addParallel(new TusksAction(DefenderActionType.CLOSE));
  }
}
