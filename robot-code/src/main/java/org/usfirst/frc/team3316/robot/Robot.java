package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Timer;
import org.usfirst.frc.team3316.robot.commands.sequences.InitTeleop;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.humanIO.Joysticks;
import org.usfirst.frc.team3316.robot.humanIO.SDB;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;
import org.usfirst.frc.team3316.robot.robotIO.Actuators;
import org.usfirst.frc.team3316.robot.robotIO.Sensors;
import org.usfirst.frc.team3316.robot.subsystems.Chassis;
import org.usfirst.frc.team3316.robot.subsystems.Defender;
import org.usfirst.frc.team3316.robot.subsystems.Gripper;
import org.usfirst.frc.team3316.robot.subsystems.Tusks;
import org.usfirst.frc.team3316.robot.subsystems.kicker.Kicker;
import org.usfirst.frc.team3316.robot.subsystems.kicker.KickerManager;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
  public static Config config;
  public static DBugLogger logger;
  public static Timer timer;

  /*
   * Human IO
   */
  public static Joysticks joysticks;
  public static SDB sdb;
  /*
   * Robot IO
   */
  public static Actuators actuators;
  public static Sensors sensors;

  /*
   * Subsystems
   */
  public static Kicker kicker;
  public static Chassis chassis;
  public static Defender defender;
  public static Gripper gripper;
  public static Tusks tusks;

  Command autonomousCommand;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  public void robotInit () {
    try {
      /*
       * Above all else
       */
      logger = new DBugLogger();
      config = new Config();
      timer = new Timer();

      /*
       * Human IO (that does not require subsystems)
       */
      joysticks = new Joysticks();

      /*
       * Robot IO
       */
      actuators = new Actuators();
      sensors = new Sensors();
      defender = new Defender();
      gripper = new Gripper();
      tusks = new Tusks();

      /*
       * Subsystems
       */
      kicker = new Kicker();
      chassis = new Chassis();

      /*
       * Human IO (that requires subsystems)
       */
      joysticks.initButtons();

      /*
       * SDB
       */
      sdb = new SDB();
      sdb.timerInit();
    } catch (Exception e) {
      System.out.println(e);
      logger.severe(e);
    }
  }

  public void disabledPeriodic () {
    Scheduler.getInstance().run();
  }

  public void autonomousInit () {
    if (autonomousCommand != null) autonomousCommand.start();
  }

  public void autonomousPeriodic () {
    Scheduler.getInstance().run();
  }

  public void teleopInit () {
    if (autonomousCommand != null) autonomousCommand.cancel();
    new InitTeleop().start();
  }

  public void disabledInit () {

  }

  public void teleopPeriodic () {
    Scheduler.getInstance().run();
  }

  public void testPeriodic () {
    LiveWindow.run();
  }

  public static synchronized Timer getTimer () {
    if (timer == null) {
      timer = new Timer(true);
    }

    return timer;
  }

  private void printTheTruth () {
    System.out.println("Vita is the Melech!!");
  }
}
