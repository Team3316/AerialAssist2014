package org.usfirst.frc.team3316.robot.commands.sequences;

import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderAction;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;

public class InitTeleop extends DBugCommandGroup {
  public InitTeleop () {
    addParallel(new DefenderAction(DefenderActionType.CLOSE));
  }
}
