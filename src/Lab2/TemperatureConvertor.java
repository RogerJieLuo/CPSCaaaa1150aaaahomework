package Lab2;

import java.util.Scanner;

/**
 * @Author by Jie Luo
 * @Version 2017-09-12
 * @Class TemperatureConvertor
 * @Code will convert temperature from Celsius to both Fahrenheit and Kelvin.
 */

public class TemperatureConvertor {
    public static void main(String[] args) {
        int tempInC;   // temperature in Celsius
        double tempInF, tempInK;    // temperature in Fahrenheit and Kelvin

        // get input from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Temperature in Celsius: ");
        tempInC = input.nextInt();

        tempInF = tempInC * (9.0 / 5) + 32;    // convert the Celsius temperature to Fahrenheit
        tempInK = tempInC + 273.15;             // convert Celsius temperature to Kelvin

        // print out the result
        System.out.println("Temperature in Fahrenheit is " + tempInF);
        System.out.printf("Temperature in Kelvin is %.2f", tempInK);
        System.out.println();   // an empty line make the print result looks clean
    }
}
