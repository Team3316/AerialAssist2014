package org.usfirst.frc.team3316.robot.utils;

/**
 * Kicker trajectory planning
 * This trajectory is very simple, and it was made in order to get the kicker
 * from angle a0 to angle a1 smoothly, and not to fit a lot of angles
 * into the loop, which is why it takes only two inputs.
 */
public class Trajectory {
  public static int NUM_OF_SAMPLES = 100; // Number of samples to use in curve fitting
  private Knot _startAngle, _endAngle, _inter1, _inter2;
  private double[][] _positionPoints, _velocityPoints;

  /**
   * Initializes a new Trajectory instance that goes through all the given knots.
   * @param start The starting configuration, usually Knot<0, 0>
   * @param end The end goal
   */
  public Trajectory (Knot start, Knot end) {
    this._startAngle = start;
    this._endAngle = end;

    this._inter1 = new Knot(start.getAngle(), end.getTime());
    this._inter2 = new Knot(end.getAngle(), start.getTime());

    this._positionPoints = new double[Trajectory.NUM_OF_SAMPLES + 1][2];
    this._velocityPoints = new double[Trajectory.NUM_OF_SAMPLES + 1][2];
  }

  /**
   * Initializes a new Trajectory with starting configuration as the zero knot.
   * @param end The end goal
   */
  public Trajectory (Knot end) {
    this(Knot.ZERO, end);
  }

  private double positionFitting (double t, double[] xvec) {
    // Manually multiplying the Bézier basis matrix with the base vector and x vector.
    double t3 = Math.pow(t, 3) * (-xvec[0] + 3 * xvec[1] - 3 * xvec[2] + xvec[3]);
    double t2 = Math.pow(t, 2) * (3 * xvec[0] - 6 * xvec[1] + 3 * xvec[2]);
    double t1 = t * (-3 * xvec[0] + 3 * xvec[1]);
    double t0 = xvec[0];
    return t3 + t2 + t1 + t0;
  }

  private double velocityFitting (double t, double[] xvec) {
    // Multiplying the derived Bézier matrices to get angular velocity
    double t3 = 3 * Math.pow(t, 2) * (-xvec[0] + 3 * xvec[1] - 3 * xvec[2] + xvec[3]);
    double t2 = 2 * t * (3 * xvec[0] - 6 * xvec[1] + 3 * xvec[2]);
    double t1 = -3 * xvec[0] + 3 * xvec[1];
    return t3 + t2 + t1;
  }

  private double fitAngle (double t) {
    double a0 = this._startAngle.getAngle(),
           da0 = this._inter1.getAngle(),
           da1 = this._inter2.getAngle(),
           a1 = this._endAngle.getAngle();
    double[] vec = { a0, da0, da1, a1 };
    return positionFitting(t, vec);
  }

  private double fitAngularVelocity (double t) {
    double a0 = this._startAngle.getAngle(),
           da0 = this._inter1.getAngle(),
           da1 = this._inter2.getAngle(),
           a1 = this._endAngle.getAngle();
    double[] vec = { a0, da0, da1, a1 };
    return velocityFitting(t, vec);
  }

  public double[][] fitPositionCurve () {
    for (int i = 0; i < Trajectory.NUM_OF_SAMPLES + 1; i++) {
      // TODO - Make this work for start time more than 0
      double x = ((double) i) / Trajectory.NUM_OF_SAMPLES;
      this._positionPoints[i][0] = x * this._endAngle.getTime();
      this._positionPoints[i][1] = this.fitAngle(x);
    }
    return this._positionPoints;
  }

  public double[][] fitVelocityCurve () {
    for (int i = 0; i < Trajectory.NUM_OF_SAMPLES + 1; i++) {
      // TODO - Make this work for start time more than 0
      double x = ((double) i) / Trajectory.NUM_OF_SAMPLES;
      this._velocityPoints[i][0] = x * this._endAngle.getTime();
      this._velocityPoints[i][1] = this.fitAngularVelocity(x);
    }
    return this._velocityPoints;
  }

  public String toString () {
    String posStr = "position:\n";
    String velStr = "velocity:\n";
    int lasti = Trajectory.NUM_OF_SAMPLES - 1;

    for (int i = 0; i < Trajectory.NUM_OF_SAMPLES - 1; i++) {
      posStr += "(" + this._positionPoints[i][0] + "," + this._positionPoints[i][1] + "), ";
    }
    posStr += "(" + this._positionPoints[lasti][0] + "," + this._positionPoints[lasti][1] + ")";

    for (int i = 0; i < Trajectory.NUM_OF_SAMPLES - 1; i++) {
      velStr += "(" + this._velocityPoints[i][0] + "," + this._velocityPoints[i][1] + "), ";
    }
    velStr += "(" + this._velocityPoints[lasti][0] + "," + this._velocityPoints[lasti][1] + ")";

    return posStr + "\n" + velStr;
  }

  public static void main (String[] args) {
    Knot goal = new Knot(45, 9);
    Trajectory trajectory = new Trajectory(goal);
    trajectory.fitPositionCurve();
    trajectory.fitVelocityCurve();
    System.out.println(trajectory);
  }
}
