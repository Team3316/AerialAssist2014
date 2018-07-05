package org.usfirst.frc.team3316.robot.subsystems.kicker;

import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerKick;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerResting;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerShaken;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerZero;

public class KickerManager {
  /*
   * Singleton stuff
   */
  private static KickerManager _instance = new KickerManager();

  public static KickerManager getInstance () {
    return _instance;
  }

  /*
   * Actual class
   */
  private KickerState _state;
  private KickerTask _task;

  public KickerZero zeroCommand;
  public KickerShaken shakenCommand;
  public KickerResting restingCommand;
  public KickerKick kickCommand;

  private KickerManager () {
    this._state = KickerState.OFF;
  }

  /**
   * Sets a new state for the kicker. This is an almost exact replica of the original version.
   */
  public void setState (KickerState newState) {
    System.out.println("Changing state from " + this._state.name() + " to " + newState.name());
    switch (newState) {
      case ZERO:
        if (this._state == KickerState.RESTING) {
          if (this.zeroCommand != null) {
            this.zeroCommand.cancel();
            this.zeroCommand = null;
          }
          this._state = newState;
        }
      case KICKING:
        if (this._state == KickerState.RESTING || this._state == KickerState.OFF) {
          if (this.kickCommand != null) {
            this.kickCommand.cancel();
            this.kickCommand = null;
          }
          this._state = newState;
        }
      case RESTING:
        if (this._state == KickerState.SHAKEN) {
          if (this.restingCommand != null) {
            this.restingCommand.cancel();
            this.restingCommand = null;
          }
          this._state = newState;
        }
      case SHAKEN:
        if (this._state == KickerState.RESTING) {
          if (this.shakenCommand != null) {
            this.shakenCommand.cancel();
            this.shakenCommand = null;
          }
          this._state = newState;
        }
      case OFF:
        if (this._state == KickerState.ZERO) {
          this._state = newState;
        }
    }
  }

  public KickerState getState () {
    return this._state;
  }

  public void timerInit () {
    this._task = new KickerTask();
    Robot.getTimer().schedule(this._task, 0, 20);
  }
}
