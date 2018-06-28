package org.usfirst.frc.team3316.robot.subsystems.kicker;

import org.usfirst.frc.team3316.robot.motion.Knot;
import org.usfirst.frc.team3316.robot.motion.Trajectory;

/**
 * A class of all the trajectories needed for the kicker operations
 */
public class KickerMotion {
  public static Trajectory zeroTrajectory () {
    Knot start = new Knot(1, 0);
    Knot end = new Knot(-1, 0.75);
    return new Trajectory(start, end);
  }

  public static Trajectory kickTrajectory () {
    Knot goal = new Knot(225, 0.75);
    return new Trajectory(goal);
  }
}
