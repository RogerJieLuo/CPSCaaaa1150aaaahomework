package Lab2;

import java.util.Scanner;

/**
 * @Author by jie luo
 * @Version 2017-09-12
 * @Class DistanceBTP
 * @Code will calculate the distance between two points on a Euclidean plane.
 */
public class DistanceBTP {
    public static void main(String[] args) {
        int x1, x2, y1, y2; // create variables for 2 points
        double distance;    // distance between 2 points

        // get input from user
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the x of point 1:");
        x1 = input.nextInt();
        System.out.println("Please enter the y of point 1:");
        y1 = input.nextInt();
        System.out.println("Please enter the x of point 2:");
        x2 = input.nextInt();
        System.out.println("Please enter the y of point 2:");
        y2 = input.nextInt();

        // calculate the distance
        distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        System.out.println("The distance between point1 (" + x1 + ", " + y1 + ") and point2 ("+ x2 + ", "+ y2 + ") is: "+distance);
    }
}
