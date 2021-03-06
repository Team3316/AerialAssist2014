/**
 * Class for managing the SmartDashboard data
 */
package org.usfirst.frc.team3316.robot.humanIO;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;
import org.usfirst.frc.team3316.robot.Robot;
import org.usfirst.frc.team3316.robot.commands.defender.DefenderActionType;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperAction;
import org.usfirst.frc.team3316.robot.commands.gripper.GripperActionType;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerKick;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerShaken;
import org.usfirst.frc.team3316.robot.commands.kicker.KickerZero;
import org.usfirst.frc.team3316.robot.commands.sequences.CollectSequence;
import org.usfirst.frc.team3316.robot.commands.sequences.EjectSequence;
import org.usfirst.frc.team3316.robot.commands.sequences.KickSequence;
import org.usfirst.frc.team3316.robot.commands.tusks.TusksAction;
import org.usfirst.frc.team3316.robot.config.Config;
import org.usfirst.frc.team3316.robot.config.Config.ConfigException;
import org.usfirst.frc.team3316.robot.logger.DBugLogger;

public class SDB {
  /*
   * Runnable that periodically updates values from the robot into the SmartDashboard
   * This is the place where all of the robot data should be displayed from
   */
  private class UpdateSDBTask extends TimerTask {
    public UpdateSDBTask () {
      logger.info("Created UpdateSDBTask");
    }

    public void run () {
      /*
       * Insert put methods here
       */
      put("Is ball in", Robot.gripper.isBallIn());
      put("Left MS", Robot.sensors.gripperLeftSwitch.get());
      put("Middle MS", Robot.sensors.gripperMiddleSwitch.get());
      put("Right MS", Robot.sensors.gripperRightSwitch.get());
      put("Ball IR", Robot.sensors.ballIR.getAverageValue());
    }

    private void put (String name, double d) {
      SmartDashboard.putNumber(name, d);
    }

    private void put (String name, int i) {
      SmartDashboard.putNumber(name, i);
    }

    private void put (String name, boolean b) {
      SmartDashboard.putBoolean(name, b);
    }

    private void put (String name, String s) {
      SmartDashboard.putString(name, s);
    }
  }

  private DBugLogger logger = Robot.logger;
  private Config config = Robot.config;

  private UpdateSDBTask updateSDBTask;

  private Hashtable<String, Class<?>> variablesInSDB;

  public SDB () throws ConfigException {
    variablesInSDB = new Hashtable<String, Class<?>>();

    initSDB();
    timerInit();
  }

  public void timerInit () {
    updateSDBTask = new UpdateSDBTask();
    Robot.getTimer().schedule(updateSDBTask, 0, 100);
  }

  /**
   * Adds a certain key in the config to the SmartDashboard
   *
   * @param key the key required
   * @return whether the value was put in the SmartDashboard
   */
  public boolean putConfigVariableInSDB (String key) {
    try {
      Object value = config.get(key);
      Class<?> type = value.getClass();

      boolean constant = Character.isUpperCase(key.codePointAt(0));

      if (type == Double.class) {
        SmartDashboard.putNumber(key, (double) value);
      } else if (type == Integer.class) {
        SmartDashboard.putNumber(key, (int) value);
      } else if (type == Boolean.class) {
        SmartDashboard.putBoolean(key, (boolean) value);
      }

      if (!constant) {
        variablesInSDB.put(key, type);
        logger.info("Added to SDB " + key + " of type " + type +
            "and allows for its modification");
      } else {
        logger.info("Added to SDB " + key + " of type " + type +
            "BUT DOES NOT ALLOW for its modification");
      }

      return true;
    } catch (ConfigException e) {
      logger.severe(e);
    }
    return false;
  }

  public Set<Entry<String, Class<?>>> getVariablesInSDB () {
    return variablesInSDB.entrySet();
  }

  private void initSDB () throws ConfigException {
    SmartDashboard.putData(new UpdateVariablesInConfig()); //NEVER REMOVE THIS COMMAND

    SmartDashboard.putData("Kicker Kick", new KickerKick());
    SmartDashboard.putData("Kicker Zero", new KickerZero());
    SmartDashboard.putData("Kicker Shaken", new KickerShaken());

    SmartDashboard.putData("Kick Sequence", new KickSequence());
    SmartDashboard.putData("Collect Sequence", new CollectSequence());
    SmartDashboard.putData("Eject Sequence", new EjectSequence());

    SmartDashboard.putData("Extend Gripper", new GripperAction(GripperActionType.EXTEND));
    SmartDashboard.putData("Retract Gripper", new GripperAction(GripperActionType.RETRACT));
    SmartDashboard.putData("Eject ball", new GripperAction(GripperActionType.ROLLOUT));
    SmartDashboard.putData("Open tusks", new TusksAction(DefenderActionType.OPEN));

    logger.info("Finished initSDB()");
  }
}