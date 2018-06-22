package org.usfirst.frc.team3316.robot.commands.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerManager;

public abstract class KickerCommand extends DBugCommand {
  protected final KickerManager manager = KickerManager.getInstance();

  public KickerCommand () {
    requires(Robot.kicker);
  }
}
