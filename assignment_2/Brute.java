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
import java.util.*;
import java.io.*;


public class Brute {
    public static void main(String args[]) throws FileNotFoundException
    { 
        int array_size=0;
        int points_x = 0;
        int points_y = 0;
        int i = 0;
        Point p,q,r,s;
        double slope_pq,slope_pr,slope_ps;
        Point[] a;
        
        File file=new File("C:/Users/satya/Desktop/input.txt");
        Scanner in = new Scanner(new FileInputStream(file));
     
        //FileInputStream in = new FileInputStream(file);
        if (in.hasNext()) {
            array_size = in.nextInt();
        }
        a = new Point[array_size];
        while(in.hasNext() && array_size>0)
        {
          points_x = in.nextInt();
          points_y = in.nextInt();
          a[i] = new Point(points_x,points_y);
          i++;     
        }
        
        for
                for
                        if compareTo >= 0
                                continue
                        slope_pq = slopeTo                        
                        for
                                if compareTo >= 0
                                   continue
                                slope_pr = slopeTo
                                if slope_pq != slope_pr
                                    continue
                                for
                                        if conpareTo >= 0
                                           continue
                                        slope_ps = slopeTo
                                        if slope_pq != slope_ps
                                            continue
                                        else
                                            store this as p,q,r,s as solution
                                end for
                        end for
                end for
        end for
        int j=0;
        while(j<i)
        {
            System.out.println(a[j].toString());
            j++;

        }
        
    }
}
