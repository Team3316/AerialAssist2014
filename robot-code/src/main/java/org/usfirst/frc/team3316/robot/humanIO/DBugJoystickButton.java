package org.usfirst.frc.team3316.robot.humanIO;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is using for changing the button number, via the config, while the
 * code is running.
 *
 * @author D-Bug
 *
 */
public class DBugJoystickButton extends Button {
  private GenericHID mJoystick;
  private int mButtonNumber;

  /**
   * Create a joystick button for triggering commands $
   *
   * @param joystick
   *            The GenericHID object that has the button (e.g. Joystick,
   *            KinectStick, etc)
   * @param buttonNumber
   *            The button's number on the joystick
   */
  public DBugJoystickButton (GenericHID joystick, int buttonNumber) {
    this.mJoystick = joystick;
    this.mButtonNumber = buttonNumber;
  }

  /**
   * Gets the value of the joystick button $
   *
   * @return The value of the joystick button
   */
  public boolean get() {
    return mJoystick.getRawButton(this.mButtonNumber);
  }

}

