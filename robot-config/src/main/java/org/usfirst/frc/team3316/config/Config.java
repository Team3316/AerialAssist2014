package org.usfirst.frc.team3316.config;

import java.util.Hashtable;

public class Config {
  public static Hashtable<String, Object> variablesB;
  public static Hashtable<String, Object> constantsB;

  public static Hashtable<String, Object> variablesA;
  public static Hashtable<String, Object> constantsA;

  static {
    variablesB = new Hashtable<String, Object>();
    constantsB = new Hashtable<String, Object>();

    variablesA = new Hashtable<String, Object>();
    constantsA = new Hashtable<String, Object>();

    initConfig();
    IO.initIO();
  }

  public static void addToConstantsA(String key, Object value) {
    System.out.println("Trying to add to constants A: key " + key + " value " + value);

    if (constantsA.containsKey(key)) {
      constantsA.replace(key, value);
    } else {
      constantsA.put(key, value);
    }
  }

  public static void addToVariablesA(String key, Object value) {
    System.out.println("Trying to add to variables A: key " + key + " value " + value);

    if (variablesA.containsKey(key)) {
      variablesA.replace(key, value);
    } else {
      variablesA.put(key, value);
    }
  }

  public static void addToConstantsB(String key, Object value) {
    System.out.println("Trying to add to constants B: key " + key + " value " + value);

    if (constantsB.containsKey(key)) {
      constantsB.replace(key, value);
    } else {
      constantsB.put(key, value);
    }
  }

  public static void addToVariablesB(String key, Object value) {
    System.out.println("Trying to add to variables B: key " + key + " value " + value);

    if (variablesB.containsKey(key)) {
      variablesB.replace(key, value);
    } else {
      variablesB.put(key, value);
    }
  }

  public static void addToConstants(String key, Object value) {
    addToConstantsA(key, value);
    addToConstantsB(key, value);
  }

  public static void addToVariables(String key, Object value) {
    addToVariablesA(key, value);
    addToVariablesB(key, value);
  }

  /*
   * NOTE: constants and variables that are common to both robot A and robot B
   * should be added with addToConstants() or addToVariables()
   *
   * Use different constants and variables for the two robots only if there is a
   * difference. TestModeStuff
   */
  private static void initConfig() {
    /*
     * Human IO
     */
    {
      /*
       * Constants
       */
      {
        /*
         * Joysticks
         */
        {
          addToConstants("joysticks.left", 0);
          addToConstants("joysticks.right", 1);
          addToConstants("joysticks.operator", 2);
        }

        /*
         * Buttons and axis
         */
        {
        }
      }
    }

    /*
     * RobotIO
     */
    {
      /*
       * Constants
       */
      {
        /*
         * Kicker
         */
        addToConstantsA("kicker.encoder.distPerPulse", 360.0 / 1024.0);
      }
    }

    /*
     * Chassis
     */
    {
      /*
       * Constants
       */
      {
      }

      /*
       * Variables
       */
      {
      }
    }

    /*
     * Kicker
     */
    {
      /*
       * Constants
       */
      {
        addToConstants("kicker.kick.normal", 1.75);
        addToConstants("kicker.kick.timeout", 0.75);

        addToConstants("kicker.shaken.voltage", -0.3316);
        addToConstants("kicker.shaken.tolerance", 3.0);

        addToConstants("kicker.zero.voltage", 0.8);
        addToConstants("kicker.zero.duration", 0.75);
      }

      /*
       * Variables
       */
      {
      }
    }

    /*
     * Gripper
     */
    {
      /*
       * Constants
       */
      {
        addToConstants("gripper.collection.voltage", 0.82);
        addToConstants("gripper.ejection.voltage", -0.45);
      }
    }
  }
}
