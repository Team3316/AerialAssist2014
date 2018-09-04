package org.usfirst.frc.team3316.robot.commands.defender;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class DefenderAction extends DBugCommand {
  private DefenderActionType type;

  public DefenderAction (DefenderActionType type) {
    requires(Robot.defender);
    this.type = type;
  }

  @Override
  protected void init () throws ConfigException {

  }

  @Override
  protected void execute () {
    Robot.defender.close();
  }

  @Override
  protected boolean isFinished () {
    return true;
  }

  @Override
  protected void fin () {

  }

  @Override
  protected void interr () {

  }
}
