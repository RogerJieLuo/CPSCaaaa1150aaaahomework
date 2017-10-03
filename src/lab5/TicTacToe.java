package lab5;

import java.util.Random;
import java.util.Scanner;

/**
 * @author by jieluo on 2017-10-03.
 * @version 2017-09-20
 * Class TicTacToe
 * Lab4 create a simple AI that user can play TicTacToe with.
 * Write a java program call TicTacToe.java. This program should let the user play tic tac toe against a very basic AI.
 * You as the player will get to go first. You should pick a position on the tic tac toe board. You program should check
 * to see if that position is free. If it isn’t free you should be asked to pick a new position, if it is free it should
 * place your token(“X”) in that position. Your program should check to see if you have won. If you have, the program
 * should print out “YOU WON” else it should let the computer take its turn. The computer should pick a random free
 * position (Should not lead to a possible infinite loop). Check tosee if the computer won. If so print out “YOU LOSE”
 * else take your turn again and repeat until all positions are picked or someone wins.You can only use what have been
 * taught in class up to and including week 5.
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int position, positionAI;
        boolean won = false;
        int turn = 0;
        char pToken ='X', aiToken = 'O';
        int count = 9;      // count the rest available cell

        char[][] board = new char[][]{
                {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}
        };
        String AIOption="";     // generate the string to store the option that AI will choose

        // display the board
        for (int i = 0; i < board.length; i++) {
            for(int j= 0;j<board[i].length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }

        // start the game
        while(true) {
            // user's turn
            turn ++;
            boolean validP = false;
            int x, y;
            while(!validP) {
                System.out.println("Pick a position: ");
                position = sc.nextInt();
                x = (position - 1) / 3;
                y = (position - 1) % 3;
                if(position>0 && position < 10 && board[x][y] != pToken && board[x][y] != aiToken ) {
                    validP = true;
                    board[x][y] = pToken;
                    count--;
                }
            }
            // check if player wins
            //      check horizontal
            for(int i=0; i < board.length;i++){
                if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                    won = true;
                }
            }
            //      check vertical
            for(int i = 0;i<board[0].length;i++){
                if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                    won = true;
                }
            }
            //      check cross \
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
                won = true;
            }
            //      check cross /
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
                won = true;
            }

            //display the board
            for (int i = 0; i < board.length; i++) {
                for(int j= 0;j<board[i].length; j++){
                    System.out.print(board[i][j]+ " ");
                }
                System.out.println();
            }
            // check result of each turn
            if(count == 0 || won) break;


            // AI's turn
            turn ++;
            // generate a string for AI to avoid the occupied cells
            AIOption = "";      // clean the old value
            for (int i = 0; i < board.length; i++) {
                for(int j= 0;j<board[i].length; j++){
                    if(board[i][j] != pToken && board[i][j] !=aiToken ) {
                        AIOption += board[i][j];
                    }
                }
            }
            //System.out.println(AIOption); // this is line for testing the ai option
            // randomly choose one value from the string
            positionAI = Integer.parseInt(""+AIOption.charAt(rand.nextInt(AIOption.length())));
            board[(positionAI-1)/3][(positionAI-1)%3] = aiToken;
            count--;
            System.out.println("O picked position: "+positionAI);
            // check if player wins
            // check horizontal
            for(int i=0; i < board.length;i++){
                if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                    won = true;
                }
            }
            // check vertical
            for(int i = 0;i<board[0].length;i++){
                if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                    won = true;
                }
            }
            // check cross
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
                won = true;
            }
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
                won = true;
            }
            //display the board
            for (int i = 0; i < board.length; i++) {
                for(int j= 0;j<board[i].length; j++){
                    System.out.print(board[i][j]+ " ");
                }
                System.out.println();
            }
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
