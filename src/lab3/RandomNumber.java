package lab3;

import java.util.Random;

/**
 * @Created by jieluo
 * @Version 2017-09-20
 * @Class RandomNumber
 * @RandomNumber will give a random phone number
 *
 *
 * question:
 * Write a program that creates and prints a random phone number of the form XXX-XXX-XXXX.
 * Include the dashes in the output. Do not let the first three digits contain an 8 or a 9 (but don’t be more
 * restrictive than that), and make sure that the second set of three digits is not greater than 655.And the sum of
 * the last 4 digits should not be greater than21Hint: Think through the easiest way to construct the phone number.
 * Each digit does not have to be, and should not be, determined separately. You are not allowed to use if statements
 * to solve this problem
 */
public class RandomNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1, num2, num3a, num3b, num3c, num3d; // variables for number set 1,2,3

        // get first set number: get the biggest number in octal base. 777 in octal is 511 in decimal
        num1 = rand.nextInt(512);
        num1 = Integer.parseInt(Integer.toString(num1, 8));

        // get second set which not greater than 655
        num2 = rand.nextInt(656);

        // get third set: the sum of 4 digits is not greater than 21

        num3a = rand.nextInt(10);
        num3b = rand.nextInt(10);
        num3c = rand.nextInt((22 - num3a - num3b)) % 10;
        num3d = rand.nextInt((22 - num3a - num3b - num3c)) % 10;

        System.out.printf("The random number is: \n%03d-%03d-%d%d%d%d", num1,num2,num3a,num3b,num3c,num3d);
    }
}
