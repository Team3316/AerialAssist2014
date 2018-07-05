package org.usfirst.frc.team3316.robot.commands.sequences;

import org.usfirst.frc.team3316.robot.commands.DBugCommandGroup;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerKick;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerZero;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class KickSequence extends DBugCommandGroup {
  public KickSequence () throws ConfigException {
    addSequential(new KickerKick());
    addSequential(new KickerZero());
  }
}
