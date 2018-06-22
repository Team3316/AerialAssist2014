package org.usfirst.frc.team3316.robot.utils;

/**
 * Knot class for kicker trajectory
 */

public class Knot {
  public static final Knot ZERO = new Knot(0, 0);
  private double _angle, _t;

  public Knot (double angle, double time) {
    this._angle = angle;
    this._t = time;
  }

  public double getAngle () {
    return this._angle;
  }

  public double getTime () {
    return this._t;
  }
}
