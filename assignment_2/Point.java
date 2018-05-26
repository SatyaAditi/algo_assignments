/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.assignment2;

/**
 *
 * @author satya
 */
/*************************************************************************
 * Name:
 * Date:
 *
 * Compilation:  javac Point.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = (Point o1, Point o2) -> {
        double slope1 = o1.slopeTo(o2); //calculates slope of point o1 and o2
        if (slope1 > 0) {
            return 1;
        } else {
            return 0;
        }
    } //Defining comparator slope_order
    ;       // YOUR DEFINITION HERE
    Point x0,y0,x1,y1,x2,y2;
    double slope;
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* YOUR CODE HERE */
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
         /* YOUR CODE HERE */
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
    slope=(that.y-this.y)/(that.x-this.x); //calculating slope between this point and that point
    
     return slope;
       
    }

    /* is this point lexicographically smaller than that one?
    comparing y-coordinates and breaking ties by x-coordinates
    Formally, the invoking point (x0, y0) is less than the argument
    point (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1. 
    Return -1 if this point is less than that, 0 if same, or 1 if greater than.
    */
    @Override
    public int compareTo(Point that) {
       if(this.y<that.y || (this.y==that.y && this.x<that.x))
       {
           return -1;
       }
       else if (this.y>that.y)
       {
           return 1;
       }
       return 0;//If doesnt any any of the above conditions it will return 0 showing that this.
        }

    // return string representation of this point (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
