package org.usfirst.frc.team3316.robot.subsystems.kicker;

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

  public KickerZero zeroCommand;
  public KickerShaken shakenCommand;
  public KickerResting restingCommand;

  private KickerManager () {
    this._state = KickerState.OFF;
  }

  public void setState (KickerState newState) {
    this._state = newState;
  }

  public KickerState getState () {
    return this._state;
  }
}
