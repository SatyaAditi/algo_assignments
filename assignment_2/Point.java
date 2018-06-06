package daa_assignment2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

import daa.assignment2.StdDraw;
import java.util.Comparator;
import java.awt.*;
import javax.swing.*;

class DemoPanel extends JPanel
{
  public DemoPanel()
  {
    setPreferredSize( new Dimension(20000, 20000) );
    setBackground( Color.WHITE );    
  }  
}
//another class for declaring JPanel

public class Point implements Comparable<Point> {

    // compare points by slope,defining a comparator SLOPE_ORDER which compares slopes between two points and returns 1 if equal.

   public final Comparator<Point> SLOPE_ORDER = (Point o1, Point o2) -> {
       double slope1=o1.slopeTo(o2);
       if (slopeTo(o1) > slopeTo(o2)) {
           return 1;
       } else {
           return -1;
       }
  
   };
   //This comparator is to compare points using compareTo function and return the compareTo return value
   public final Comparator<Point> POINT_ORDER = (Point o1, Point o2) -> {
       return o1.compareTo(o2);
   } ;      
   
    double slope = 0;
    public final int x;                              // x coordinate
    public final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

   
    // plot this point to standard drawing
    public void draw(int r) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(this.x,this.y, r);
        
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.line(this.x, this.y, that.x, that.y);
         
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
       if(that.x!=this.x) {
           slope = (((double)(that.y-this.y))/((double)(that.x-this.x))); //calculating slope between this point and that point and castng it as double.
       } else if(that.x==this.x && that.y!=this.y) {
           slope = Double.POSITIVE_INFINITY; //If it is a vertical line
       } else if(that.x==this.x && that.y==this.y) {
           slope=Double.NEGATIVE_INFINITY; //If it is a degenerate line
       }
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
       else if (this.y==that.y && this.x==that.x)
       {
           return 0;
       }
       return 1;//If doesnt satisfy any of the above conditions it will return 0 showing that this.y ,that.y and this.x and that.x are all equal.
    }

    // return string representation of this point (x, y)
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

 
        
        
    }
    
    

