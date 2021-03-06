package org.usfirst.frc.team3316.config;

import java.util.HashMap;
import java.util.Map;

public class IO {
	public static Map<String, Integer> pwmA = new HashMap<>();
	public static Map<String, Integer> canA = new HashMap<>();

	public static Map<String, Integer> pwmB = new HashMap<>();
	public static Map<String, Integer> canB = new HashMap<>();

	public static Map<String, Integer> dioA = new HashMap<>();
	public static Map<String, Integer> dioB = new HashMap<>();

	public static Map<String, Integer> aioA = new HashMap<>();
	public static Map<String, Integer> aioB = new HashMap<>();

	public static Map<String, Integer> pdpA = new HashMap<>();
	public static Map<String, Integer> pdpB = new HashMap<>();

	public static Map<String, Integer> pcmA = new HashMap<>();
  public static Map<String, Integer> pcmB = new HashMap<>();

	/**
	 * Finds the key that is mapped to a specified channel in the parameter map.
	 *
	 * @param in
	 *            The map we want to search in.
	 * @param value
	 *            The specified channel.
	 * @return The key that is mapped to the requested channel. If none exists the
	 *         method returns null.
	 */
	private static Object findKey(Map<?, ?> in, Object value) {
		for (Object key : in.keySet()) {
			if (in.get(key).equals(value)) {
				return key;
			}
		}
		return null;
	}

	/**
	 * Puts a mapping of a key to a channel in the requested map.
	 *
	 * @param in
	 *            The map to add the key.
	 * @param name
	 *            The key.
	 * @param channel
	 *            The channel to map the key to.
	 * @throws Exception
	 *             If the channel already has a mapping, throws an exception.
	 */
	private static void put(Map<String, Integer> in, String name, int channel) throws Exception {
		if (in.containsValue(channel)) {
			throw new Exception(
					"Channel " + channel + " for key " + name + " already exists and is: " + findKey(in, channel));
		}

		in.put(name, channel);
		Config.addToConstants(name, channel);
	}

	/**
	 * Puts a mapping of a key to a channel in the requested map of ROBOT A.
	 *
	 * @param in
	 *            The map to add the key.
	 * @param name
	 *            The key.
	 * @param channel
	 *            The channel to map the key to.
	 * @throws Exception
	 *             If the channel already has a mapping, throws an exception.
	 */
	private static void putA(Map<String, Integer> in, String name, int channel) throws Exception {
		if (in.containsValue(channel)) {
			throw new Exception(
					"Channel " + channel + " for key " + name + " already exists and is: " + findKey(in, channel));
		}

		in.put(name, channel);
		Config.addToConstantsA(name, channel);
	}

	/**
	 * Puts a mapping of a key to a channel in the requested map of ROBOT B.
	 *
	 * @param in
	 *            The map to add the key.
	 * @param name
	 *            The key.
	 * @param channel
	 *            The channel to map the key to.
	 * @throws Exception
	 *             If the channel already has a mapping, throws an exception.
	 */
	private static void putB(Map<String, Integer> in, String name, int channel) throws Exception {
		if (in.containsValue(channel)) {
			throw new Exception(
					"Channel " + channel + " for key " + name + " already exists and is: " + findKey(in, channel));
		}

		in.put(name, channel);
		Config.addToConstantsB(name, channel);
	}

	/**
	 * Put method for pwm channels on robot A. Read the documentation of the put
	 * method.
	 */
	private static void putPWMA(String name, int channel) throws Exception {
		putA(pwmA, name, channel);
	}

	/**
	 * Put method for can channels on robot A. Read the documentation of the put
	 * method.
	 */
	private static void putCANA(String name, int channel) throws Exception {
		putA(canA, name, channel);
	}

	/**
	 * Put method for pwm channels on robot B. Read the documentation of the put
	 * method.
	 */
	private static void putPWMB(String name, int channel) throws Exception {
		putB(pwmB, name, channel);
	}

	/**
	 * Put method for can channels on robot B. Read the documentation of the put
	 * method.
	 */
	private static void putCANB(String name, int channel) throws Exception {
		putB(canB, name, channel);
	}

	/**
	 * Put method for dio channels. Read the documentation of the put method.
	 */
	private static void putDIOA(String name, int channel) throws Exception {
		putA(dioA, name, channel);
	}

	/**
	 * Put method for dio channels. Read the documentation of the put method.
	 */
	private static void putDIOB(String name, int channel) throws Exception {
		putB(dioB, name, channel);
	}

	/**
	 * Put method for aio channels. Read the documentation of the put method.
	 */
	private static void putAIOA(String name, int channel) throws Exception {
		putA(aioA, name, channel);
	}

	/**
	 * Put method for aio channels. Read the documentation of the put method.
	 */
	private static void putAIOB(String name, int channel) throws Exception {
		putB(aioB, name, channel);
	}

	/**
	 * Put method for pdp channels. Read the documentation of the put method.
	 */
	private static void putPDPA(String name, int channel) throws Exception {
		putA(pdpA, name, channel);
	}

	/**
	 * Put method for pdp channels. Read the documentation of the put method.
	 */
	private static void putPDPB(String name, int channel) throws Exception {
		putB(pdpB, name, channel);
	}

  /**
   * Put method for pdp channels. Read the documentation of the put method.
   */
  private static void putPCMA(String name, int channel) throws Exception {
    putA(pcmA, name, channel);
  }

  /**
   * Put method for pdp channels. Read the documentation of the put method.
   */
  private static void putPCMB(String name, int channel) throws Exception {
    putB(pcmB, name, channel);
  }

	public static void initIO() {
		try {
			/*
			 * PWM and CAN initialization
			 */
			{
				/*
				 * Robot A
				 */
				{
				  // Chassis
					// Left side CIMs
					putPWMA("chassis.motors.leftCIM", 1);
					// Left side Mini CIM
					putPWMA("chassis.motors.leftMiniCIM", 8);
					// Right side CIMs
					putPWMA("chassis.motors.rightCIM", 0);
					// Right side Mini CIM
					putPWMA("chassis.motors.rightMiniCIM", 3);

				  // Kicker
					// Left side CIM
          putPWMA("kicker.motors.leftCIM", 6);
          // Left side Mini CIM
          putPWMA("kicker.motors.leftMiniCIM", 9);
          // Right side CIM
          putPWMA("kicker.motors.rightCIM", 4);
          // Right side Mini CIM
          putPWMA("kicker.motors.rightMiniCIM", 5);

          // Gripper
					putPWMA("gripper.motors.left", 7);
					putPWMA("gripper.motors.right", 2);
				}

				/*
				 * Robot B
				 */
				{
				}
			}

			/*
			 * DIO initialization
			 */
			{
				/*
				 * Robot A
				 */
				{
					// Kicker
					putDIOA("kicker.encoder.channelA", 6);
          putDIOA("kicker.encoder.channelB", 7);
          putDIOA("kicker.restingHallEffect", 0);

          // Gripper
					putDIOA("gripper.switches.left", 2);
					putDIOA("gripper.switches.middle", 3);
					putDIOA("gripper.switches.right", 1);
				}

				/*
				 * Robot B
				 */
				{
				}
			}

			/*
			 * AIO initialization
			 */
			{
				/*
				 * Robot A
				 */
				{
					putAIOA("gripper.ir.port", 1);
				}

				/*
				 * Robot B
				 */
				{
				}
			}

			/*
			 * PDP initialization
			 */
			{
				/*
				 * Robot A
				 */
				{
				}

				/*
				 * Robot B
				 */
				{
				}
			}

			/*
			 * PCM initialization
			 */
			{
				/*
				 * Robot A
				 */
				{
					putPCMA("defender.solenoid.forward", 6);
					putPCMA("defender.solenoid.backward", 4);

					putPCMA("gripper.solenoid.forward", 5);
					putPCMA("gripper.solenoid.backward", 7);

					putPCMA("claw.solenoid.forward", 1);
					putPCMA("claw.solenoid.backward", 0);

					putCANA("pcm.12v.port", 1);
					// SECOND PCM ID IS id - 9!!!
					putPCMA("tusks.solenoid.forward", 10);
					putPCMA("tusks.solenoid.backward", 9);
				}

				/*
				 * Robot B
				 */
				{
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
