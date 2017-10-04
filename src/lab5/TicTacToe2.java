package lab5;

import java.util.Random;
import java.util.Scanner;

/**
 * @author by jieluo on 2017-10-03.
 * @version 2017-09-20
 * Class TicTacToe2
 * Lab4 create a simple AI that user can play TicTacToe with.
 * Write a java program call TicTacToe.java. This program should let the user play tic tac toe against a very basic AI.
 * You as the player will get to go first. You should pick a position on the tic tac toe board. You program should check
 * to see if that position is free. If it isn’t free you should be asked to pick a new position, if it is free it should
 * place your token(“X”) in that position. Your program should check to see if you have won. If you have, the program
 * should print out “YOU WON” else it should let the computer take its turn. The computer should pick a random free
 * position (Should not lead to a possible infinite loop). Check tosee if the computer won. If so print out “YOU LOSE”
 * else take your turn again and repeat until all positions are picked or someone wins.You can only use what have been
 * taught in class up to and including week 5.
 *
 * No array
 */
public class TicTacToe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int position, positionAI;
        boolean won = false;
        int turn = 0;
        char pToken ='X', aiToken = 'O';
        int count = 9;      // count the rest available cell
        String b = "123456789";
        String AIOption="";     // generate the string to store the option that AI will choose

        // display the board
        for(int i = 0;i<b.length();i++){
            System.out.print(b.charAt(i)+" ");
            if(i %3 ==2)
                System.out.println();
        }
        System.out.println();

        // start the game
        while(true) {
            // user's turn
            turn ++;
            boolean validP = false;
            int x, y;
            while(!validP) {
                System.out.println("Pick a position: ");
                position = sc.nextInt();
                if(position>0 && position < 10 && b.charAt(position-1) != pToken && b.charAt(position-1) != aiToken){
                    validP = true;
                    String str1 = b.substring(0, position-1);
                    String str2 = b.substring(position);
                    b = str1+pToken+str2;
                    count--;
                }
            }
            // check if player wins
            //      check horizontal
            for(int i=0; i < b.length();i+=3){
                if(b.charAt(i) == b.charAt(i+1) && b.charAt(i) == b.charAt(i+2)){
                    won = true;
                }
            }
            // check vertical
            for(int i = 0;i<b.length()/3;i++){
                if(b.charAt(i) == b.charAt(i+3) && b.charAt(i) == b.charAt(6)){
                    won = true;
                }
            }
            // check cross
            if(b.charAt(0) == b.charAt(4) && b.charAt(0) == b.charAt(8)){
                won = true;
            }
            if(b.charAt(2) == b.charAt(4) && b.charAt(2) == b.charAt(6)){
                won = true;
            }

            //display the board
            for(int i = 0;i<b.length();i++){
                System.out.print(b.charAt(i)+" ");
                if(i %3 ==2)
                    System.out.println();
            }
            System.out.println();

            // check result of each turn
            if(count == 0 || won) break;


            // AI's turn
            turn ++;
            // generate a string for AI to avoid the occupied cells
            AIOption = "";      // clean the old value
            for (int i = 0; i < b.length(); i++) {
                if(b.charAt(i)!=pToken && b.charAt(i)!=aiToken ) {
                    AIOption += b.charAt(i);
                }
            }
            //System.out.println(AIOption); // this is line for testing the ai option
            // randomly choose one value from the string
            positionAI = Integer.parseInt(""+AIOption.charAt(rand.nextInt(AIOption.length())));
            String str1 = b.substring(0, positionAI-1);
            String str2 = b.substring(positionAI);
            b = str1+aiToken+str2;
            count--;
            System.out.println("O picked position: "+positionAI);
            // check if player wins
            // check horizontal
            for(int i=0; i < b.length();i+=3){
                if(b.charAt(i) == b.charAt(i+1) && b.charAt(i) == b.charAt(i+2)){
                    won = true;
                }
            }
            // check vertical
            for(int i = 0;i<b.length()/3;i++){
                if(b.charAt(i) == b.charAt(i+3) && b.charAt(i) == b.charAt(6)){
                    won = true;
                }
            }
            // check cross
            if(b.charAt(0) == b.charAt(4) && b.charAt(0) == b.charAt(8)){
                won = true;
            }
            if(b.charAt(2) == b.charAt(4) && b.charAt(2) == b.charAt(6)){
                won = true;
            }
            //display the board
            for(int i = 0;i<b.length();i++){
                System.out.print(b.charAt(i)+" ");
                if(i %3 ==2)
                    System.out.println();
            }
            System.out.println();

            // check result of each turn
            if(count == 0 || won) break;
            // end of AI turn
        }

        // print out the game result
        if(won){
            if(turn%2 == 1){
                System.out.println("YOU WIN");
            }else{
                System.out.println("YOU LOSE");
            }
        }else{
            System.out.println("It's a tie.");
        }

    }

}
