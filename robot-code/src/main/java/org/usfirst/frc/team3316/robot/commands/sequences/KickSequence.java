package org.usfirst.frc.team3316.robot.commands.sequences;

import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderAction;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.commands.gripper.ClawAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerKick;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerZero;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class KickSequence extends DBugCommandGroup {
  public KickSequence () throws ConfigException {
    addSequential(new DefenderAction(DefenderActionType.OPEN));
    addParallel(new ClawAction(GripperActionType.EXTEND));
    addSequential(new WaitCommand(0.3));
    addSequential(new KickerKick());
    addSequential(new KickerZero());
  }
}
