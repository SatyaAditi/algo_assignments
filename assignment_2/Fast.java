/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa_assignment2;

import java.awt.Color;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import daa.assignment2.StdDraw;
/**
 *
 * @author satya
 */
public class Fast {
  public static void main(String args[])
  {
        
      try{
      int array_size=0;
      int points_x=0,points_y=0;
      int i=0,j=0,k=0,m=0;
      int max_x=0, max_y=0;
      int min_x=Integer.MAX_VALUE, min_y=Integer.MAX_VALUE;
      Point p,q,r;
      
      ArrayList<Point> collinear_points = new ArrayList<Point>(); 
      ArrayList<Point> temp = new ArrayList<Point>();
      ArrayList<Point> temp_last = new ArrayList<Point>();
      ArrayList<ArrayList<Point>> list_collinear = new ArrayList<ArrayList<Point>>();
      

      double slope_pq=0,slope_pr=0; //Declaring slopes for lines joining  p,q,r,s.
      Point[] a,b; //Declaring array of points
      java.io.File file=new java.io.File("input8.txt");
      Scanner in = new Scanner(file);

      
        if (in.hasNext()) {
            array_size = in.nextInt();
        }     //Checking the number of pairs of points in the given input file and creating an array of that size
        a = new Point[array_size];
        b = new Point[array_size];
        while(in.hasNext() && array_size>0)
        {
          points_x = in.nextInt();
          points_y = in.nextInt();
          a[i] = new Point(points_x,points_y);
          b[i] = new Point(points_x,points_y);
          max_x = Math.max(max_x, points_x);
          min_x = Math.min(min_x, points_x);
          max_y = Math.max(max_y, points_y);
          min_y = Math.min(min_y, points_y);
           //This is to draw the axis for the points to be displayed,the aix co-ordinates should in the range of the input values.
          i++;     
        }
        StdDraw.setXscale(0, Math.max(max_x, max_y)+500);//Setting scale for x and y axis
        StdDraw.setYscale(0, Math.max(max_x, max_y)+500);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.line(0, 0, Math.max(max_x, max_y), 0);//Drawing the axis
        StdDraw.line(0, 0, 0, Math.max(max_x, max_y));        
        int radius = 200;
        for (i=0; i<a.length;i++) {
            a[i].draw(radius);
        }

        Arrays.sort(b,b[0].POINT_ORDER);
        //All the points in the given file are added in the arraylist.
         //sorting the array of points according to point order which compares the points whether they are less than other points or not.
        for(i=0;i<array_size;i++)
        {
            p=b[i];//Point p is considered an initial or origin point with which all other points are compared.Point p changes with each iterartion.

            Arrays.sort(a, p.SLOPE_ORDER);// sorting array a with respect to point p based on slope_order comaparator, as a array gets sorted,point p has to be constantly taken from the loop,from an array which is not sorted,hence b.

            for(j=1;j<a.length;j++) {
                q=a[j-1];
                r=a[j];
                if(p.compareTo(q)==0) {
                    continue;//If p and q are same points it will return a degenerate line hence checking that condition and terminating the loop to go to next point.

                }
                slope_pq = p.slopeTo(q);//Calculating slope of pq and pr 
                slope_pr = p.slopeTo(r);
                if (slope_pq==slope_pr) {
                    if (collinear_points.isEmpty()) {                    
                        collinear_points.add(q);//If slopes are equal the corresponding point q is added.

                    }
                    collinear_points.add(r); //adding point r
 
                }else if (collinear_points.size()>=3) {
                    collinear_points.add(p);//If the list has more than 3 points,the last point added is p as p is collinear to those points.
                    collinear_points.sort(p.POINT_ORDER);
                if (list_collinear.isEmpty() || //list_collinear is the arraylist of rraylist of points.
                  !itExists(list_collinear,collinear_points)){//calling the boolean function defined below
                    temp = new ArrayList(collinear_points);//Stored in another temporary arraylist
                    list_collinear.add(temp);
                    }
                    collinear_points.clear();//Clearing off the arraylist for next iterartion
                }else {
                    collinear_points.clear();
                }

            }
            /*Now only point p is considered.Point p is again sorted with respect to whether it is smaller than other points or not and then if the collinear_points arraylist is empty,
            and not exists in the arraylist of arraylist of points ,it is added to temporary collinear points which are added in the list_collinear list of arraylist of points.
            */
            if (collinear_points.size()>=3) {
                    collinear_points.add(p);
                    collinear_points.sort(p.POINT_ORDER);
                    if (list_collinear.isEmpty() || 
                            !itExists(list_collinear,collinear_points)){
                        temp = new ArrayList(collinear_points);
                        list_collinear.add(temp);
                    }
                    collinear_points.clear();
            }
        }
        
//To display the points
        for (i=0;i<list_collinear.size();i++) {
            temp_last = list_collinear.get(i);
            System.out.print(temp_last.get(0));//The first point is printed
            for (j=1;j<temp_last.size();j++) {
                System.out.print("->");
                System.out.print(temp_last.get(j));//Other points are printed
            }
            temp_last.get(0).drawTo(temp_last.get(temp_last.size()-1));//Draw line joining the collinear points starting from first point to other points.
            System.out.println();
        }
        
        
        
      }
catch(Exception e)
  {
      e.printStackTrace();
  }
  }
  /**
   * Checks if an ArraList exists in the master list. The ArrayList can be a 
   * subset of one of the ArrayList. If it is a superset it will replace but 
   * return positive so that the main code will not add the superset.
   * @param a ArraList of ArrayList of Points i.e. Master List
   * @param b ArrayList of Points i.e Line that needs to be checked
   * @return 1 if List exists else 0
   */
  public static boolean 
        itExists(ArrayList<ArrayList<Point>> a, ArrayList<Point> b) {
      int i=0,j=0,k=0;
      int exists=0;
      ArrayList<Point> temp;
      for (i=0; i<a.size();i++) {
          temp = a.get(i);
          k=0;
          for (j=0; j<Math.min(temp.size(),b.size()); j++) {
              if(temp.get(j).compareTo(b.get(k)) != 0) {
                  exists = 0;
                  k=0;
              } else {
                  k++;
                  exists=1;
              }
          }
          if (exists==1 && (k==b.size())) {
              // b exists in a as a subset or whole
              return true;
          } else if (exists == 1 && (k < b.size() && k==temp.size())) {
              // b is the superset and temp is the subset
              a.remove(temp);
              a.add(b);
              return true;
          }
      }
      return false;
  }
}

