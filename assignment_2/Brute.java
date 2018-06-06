/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa_assignment2;

/**
 *
 * @author satya
 */
import java.util.*;
import java.awt.*;
import daa.assignment2.StdDraw;


public class Brute {
   
    public static void main(String args[]) 
    { 
        try{
        int array_size=0;
        int points_x = 0;
        int points_y = 0;
        int x=0,y=0;
        int max_x=0, max_y=0;
        int min_x=Integer.MAX_VALUE, min_y=Integer.MAX_VALUE;        
        // Loop iterators
        int i = 0;
        int l = 0;
        int m = 0;
        int j = 0;
        int d = 0;
        Point p,q,r,s;
        ArrayList<Point> list = new ArrayList<Point>();
        double slope_pq,slope_pr,slope_ps; //Declaring slopes for lines joining  p,q,r,s.
        Point[] a; //Declaring array of points
        java.io.File file=new java.io.File("input8.txt");
        //You can also use "args[0]" in place of the input file name, to give command line arguments at runtime.

        Scanner in = new Scanner(file);
     
        if (in.hasNext()) {
            array_size = in.nextInt();
        }     //Checking the number of pairs of points in the given input file and creating an array of that size
        a = new Point[array_size];
        while(in.hasNext() && array_size>0)
        {
          points_x = in.nextInt();
          points_y = in.nextInt();
          a[i] = new Point(points_x,points_y);
          max_x = Math.max(max_x, points_x);
          min_x = Math.min(min_x, points_x);
          max_y = Math.max(max_y, points_y);
          min_y = Math.min(min_y, points_y);
          //This is to draw the axis for the points to be displayed,the aix co-ordinates should in the range of the input values.
          i++;     
        }
        StdDraw.setXscale(0, Math.max(max_x, max_y)+500);//Setting the scale for the X-axis
        StdDraw.setYscale(0, Math.max(max_x, max_y)+500);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(0, 0, Math.max(max_x, max_y), 0);//Drawing the x-axis
        StdDraw.line(0, 0, 0, Math.max(max_x, max_y));        
        int radius = 200;
        for (i=0; i<a.length;i++) {
            a[i].draw(radius); //It will draw the points of radius 200.
        }
        //While input.txt has next Lines ,the first point on the left is taken as x and second point in right is taken as y and these points x and y are stored in the array
        int length=a.length;
      
        for(l=0 ;l<length;l++) {
            p=a[l];//p can be all the points in the array because of the for loop
            for(m =0; m<a.length;m++) {
                q=a[m]; //Second Iteration,q now contains all the points
                if (p.compareTo(q) >= 0) {
                    continue; /*Using compareTo function from Point.java ,comparing points p and q ,here it will check all the points from first iteration to all the points in second iteration
                    , It will check whether the x co-ordinates and y-cordinates are equal or greater or less and accordingly return valuess,if its greater than 0 then it will terminate the for loop and go ahead.*/
                    
                }
                slope_pq = p.slopeTo(q); //Calculating slope of the line joining p and q 
                for(j=0;j<a.length;j++) {
                    r=a[j];
                    if (q.compareTo(r) >= 0) {
                        continue;
                    }
                    slope_pr = p.slopeTo(r);
                    if (slope_pq != slope_pr) {
                        continue;
                    }//If the slope of pq is less than slope pr then it will terminate the loop there and wont consider further points
                    for(d=0;d<a.length;d++) {
                        s=a[d];
                        if (r.compareTo(s) >= 0) {
                            continue;
                        }
                        slope_ps = p.slopeTo(s);
                        if (slope_pq != slope_ps) {
                            continue;
                        }//Now all 3 slopes are considered we know ,thus we got the 4 points we know.
                       
                        System.out.println(p+"->"+q+"->"+r+"->"+s);
                        p.drawTo(s);
                        /*store this  p,q,r,s as solution;*/
                        }
                        }
                }
        }
        
      
        
    }
    
    catch(Exception e)
    {
             e.printStackTrace();
    }
}
}