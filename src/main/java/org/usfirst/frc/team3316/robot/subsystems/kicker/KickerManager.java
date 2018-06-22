package org.usfirst.frc.team3316.robot.subsystems.kicker;

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
