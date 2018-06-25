package org.usfirst.frc.team3316.robot.subsystems.kicker;

import org.usfirst.frc.team3316.robot.utils.Knot;
import org.usfirst.frc.team3316.robot.utils.Trajectory;

/**
 * A class of all the trajectories needed for the kicker operations
 */
public class KickerMotion {
  public static Trajectory zeroTrajectory () {
    Knot start = new Knot(1, 0);
    Knot end = new Knot(-1, 0.5);
    return new Trajectory(start, end);
  }
}
