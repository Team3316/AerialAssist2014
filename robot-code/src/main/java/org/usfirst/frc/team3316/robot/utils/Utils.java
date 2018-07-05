package org.usfirst.frc.team3316.robot.utils;

public class Utils {
  public static double scale (double x, Point a, Point b) {
    return ((x - a.x) * (a.y - b.y) / (a.x - b.x) + a.y);
  }

  /**
   * Maps a number, t, from the interval [l1, r1] to [l2, r2].
   * @param t A number between l1 and r1
   * @param l1 The first interval's left bound
   * @param r1 The first interval's right bound
   * @param l2 The second interval's left bound
   * @param r2 The second interval's right bound
   * @return A number between l2 and r2
   */
  public static double mapBetweenIntervals (double t, double l1, double r1, double l2, double r2) {
    double c = (r2 - l2) / (r1 - l1);
    return l2 + c * (t - l1);
  }

  /*
   * returns a linear interpolation from a lookup table
   * assuming x=0 is for x values and x=1 is for y values
   * if the requiredIndex is lower than the min x value or higher than the max x value,
   * returns the minimum or maximum value accordingly
   */
  public static double valueInterpolation (double requiredIndex, double table[][]) {
    if (requiredIndex < table[0][0]) {
      return table[1][0];
    }
    if (requiredIndex > table[0][table[0].length - 1]) {
      return table[1][table[1].length - 1];
    }

    //binary search to find the appropriate indexes
    int bot = 0, top = table[0].length - 1;

    int mid = (bot + top) / 2;
    while (mid != bot) {
      if (table[0][mid] > requiredIndex) {
        top = mid;
        mid = (bot + top) / 2;
      } else {
        bot = mid;
        mid = (bot + top) / 2;
      }
    }

    //linear interpolation between the points in the lookup table
    double valueToReturn = scale(requiredIndex,
        new Point(table[0][bot], table[1][bot]),
        new Point(table[0][top], table[1][top]));
    return valueToReturn;
  }
}
