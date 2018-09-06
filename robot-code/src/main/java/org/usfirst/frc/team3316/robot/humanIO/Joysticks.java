/**
 * Class for joysticks and joystick buttons
 */
package org.usfirst.frc.team3316.robot.humanIO;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.sequences.CollectSequence;
import org.usfirst.frc.team3316.robot.commands.sequences.EjectSequence;
import org.usfirst.frc.team3316.robot.commands.sequences.KickSequence;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class Joysticks {
  /*
   * Defines a button in a gamepad POV for an array of angles
   */
  private class POVButton extends Button {
    Joystick m_joystick;
    int m_deg;

    public POVButton (Joystick joystick, int deg) {
      m_joystick = joystick;
      m_deg = deg;
    }

    public boolean get () {
      if (m_joystick.getPOV() == m_deg) {
        return true;
      }
      return false;
    }
  }

  Config config = Robot.config;
  DBugLogger logger = Robot.logger;

  private Joystick mLeftJoystick, mRightJoystick, mOperatorJoystick;

  public Joysticks () throws ConfigException {
    this.mLeftJoystick = new Joystick((int) this.config.get("joysticks.left"));
    this.mRightJoystick = new Joystick((int) this.config.get("joysticks.right"));
    this.mOperatorJoystick = new Joystick((int) this.config.get("joysticks.operator"));
  }

  public void initButtons () throws ConfigException {
    DBugJoystickButton collectButton = new DBugJoystickButton(this.mOperatorJoystick, 1);
    collectButton.whenPressed(new CollectSequence());

    DBugJoystickButton ejectButton = new DBugJoystickButton(this.mOperatorJoystick, 2);
    ejectButton.whenPressed(new EjectSequence());

    DBugJoystickButton kickButton = new DBugJoystickButton(this.mOperatorJoystick, 8);
    kickButton.whenPressed(new KickSequence());
  }

  public double getLeftDriver () {
    return this.mLeftJoystick.getY();
  }

  public double getRightDriver () {
    return this.mRightJoystick.getY();
  }
}
