package org.usfirst.frc.team3316.robot.subsystems.kicker;

import java.util.TimerTask;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerResting;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerShaken;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerZero;

public class KickerTask extends TimerTask {
  private KickerManager manager = KickerManager.getInstance();

  @Override
  public void run () {
    KickerState currentState = this.manager.getState();
    this.runCommandOfState(currentState);
  }

  private void runCommandOfState (KickerState state) {
    try {
      switch (state) {
        case OFF:
          Robot.kicker.move(0);
        case ZERO:
          if (this.manager.zeroCommand == null) {
            this.manager.zeroCommand = new KickerZero();
            this.manager.zeroCommand.start();
          }
        case SHAKEN:
          if (this.manager.shakenCommand == null) {
            double currentAngle = Robot.kicker.getAngle();
            this.manager.shakenCommand = new KickerShaken(currentAngle);
            this.manager.shakenCommand.start();
          }
        case RESTING:
          if (this.manager.restingCommand == null) {
            this.manager.restingCommand = new KickerResting();
            this.manager.restingCommand.start();
          }
      }
    } catch (Exception e) {
      Robot.logger.severe(e);
    }
  }
}

