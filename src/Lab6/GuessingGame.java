package Lab6;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jie luo.
 * @version 2017-10-16
 * Class GuessingGame
 * GuessingGame allows user to play a guessing game from 1 to 10.
 */
public class GuessingGame {
    public static void main(String[] args) {
        int number = getNumber(1,10);
        Scanner sc = new Scanner(System.in);
        int guess;
        int count = 0;
        do{
            guess = getGuess(sc);
            count = increaseCount(count);
        }while(!isRight(guess, number));
        System.out.println(winMsg(count)+number);
    }

    // use Random to get a target number int range from i to j
    private static int getNumber(int i, int j){
        Random rand = new Random();
        return rand.nextInt(j-i+1)+i;
    }

    // get user input for guessing
    private static int getGuess(Scanner sc){
        System.out.print("What is your guess \n>");
        return sc.nextInt();
    }

    // calculate how many times the user guess
    private static int increaseCount(int count){
        return ++count;
    }

    // check if the guess is correct
    private static boolean isRight(int guess, int number){
        if(guess != number){
            System.out.println("WRONG!!!");
        }
        return (guess == number);
    }

    // return the winning message
    private static String winMsg(int count){
        return "It took you "+count+" guesses to guess the number ";
    }

}
