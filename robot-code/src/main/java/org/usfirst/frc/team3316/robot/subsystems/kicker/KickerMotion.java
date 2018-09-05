package org.usfirst.frc.team3316.robot.subsystems.kicker;

import org.usfirst.frc.team3316.robot.motion.Knot;
import org.usfirst.frc.team3316.robot.motion.Trajectory;

/**
 * A class of all the trajectories needed for the kicker operations
 */
public class KickerMotion {
  public static Trajectory zeroTrajectory () {
    Knot end = new Knot(-0.75, 1.25);
    return new Trajectory(end);
  }

  public static Trajectory kickTrajectory () {
    Knot goal = new Knot(1.0, 0.65);
    return new Trajectory(goal);
  }
}
