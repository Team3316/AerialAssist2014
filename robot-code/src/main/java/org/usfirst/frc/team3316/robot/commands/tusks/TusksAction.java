package org.usfirst.frc.team3316.robot.commands.tusks;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.DBugCommand;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;

public class TusksAction extends DBugCommand {
  private DefenderActionType type;

  public TusksAction (DefenderActionType type) {
    requires(Robot.tusks);
    this.type = type;
  }

  @Override
  protected void init () throws ConfigException {

  }

  @Override
  protected void execute () {
    if (this.type == DefenderActionType.CLOSE) {
      Robot.tusks.close();
    } else {
      Robot.tusks.open();
    }
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

