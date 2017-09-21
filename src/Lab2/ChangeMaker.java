package Lab2;

import java.util.Scanner;

/**
 * @Author by Jie Luo
 * @Version 2017-09-12
 * @Class ChangeMaker
 * @Code will calculate the changes for a input value.
 */
public class ChangeMaker {
    public static void main(String[] args) {
        double amount;  // monetary amount
        int numOfHundred, numOfTwenty, numOfTen, numOfFive, numOfToonie, numOfLoonie,
            numOfQuarter, numOfDimes, numOfNickle;    // numbers for different bills

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter change amount: ");
        amount = input.nextDouble();

        // calculate each bills number
        numOfHundred = (int) amount / 100;
        amount %= 100;
        numOfTwenty = (int) amount / 20;
        amount %= 20;
        numOfTen = (int) amount / 10;
        amount %= 10;
        numOfFive = (int) amount / 5;
        amount %= 5;
        numOfToonie = (int) amount / 2;
        amount %= 2;
        numOfLoonie = (int) amount / 1;
        amount %= 1;
        numOfQuarter = (int) (amount / 0.25);
        amount %= 0.25;
        numOfDimes = (int) (amount / 0.1);
        amount %= 0.1;
        numOfNickle = (int) (amount / 0.05);

        // print values out
        System.out.println("Number of 100's are " + numOfHundred);
        System.out.println("Number of 20's are " + numOfTwenty);
        System.out.println("Number of 10's are " + numOfTen);
        System.out.println("Number of 5's are " + numOfFive);
        System.out.println("Number of Toonie's are " + numOfToonie);
        System.out.println("Number of Loonie's are " + numOfLoonie);
        System.out.println("Number of Quarter's are " + numOfQuarter);
        System.out.println("Number of Dimes' are " + numOfDimes);
        System.out.println("Number of Nickle's are " + numOfNickle);
        System.out.println("Sorry no pennies in Canada");

    }
}
