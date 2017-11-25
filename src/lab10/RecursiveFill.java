package lab10;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveFill {
    public static void main(String[] args) {
        // get 2 strings
        String[] seqs = getInput();
        String str1 = seqs[0];
        String str2 = seqs[1];

        // convert strings to int array
        int[] seq1 = convertToIntArray(str1);
        int[] seq2 = convertToIntArray(str2);

        int rows = seq2.length+2;
        int cols = seq1.length+2;

        // initiate the 2D array
        int[][] board = new int[rows][cols];

        // fill the 2D array
        fillArray(board, seq1, seq2);

        display(board);
    }

    public static String[] getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the first sequence: ");
        String str1 = sc.nextLine();

        System.out.printf("Enter the second sequence: ");
        String str2 = sc.nextLine();
        return new String[]{str1, str2};
    }

    public static int[] convertToIntArray(String str){
        String[] c = str.split(",");
        int[] res = new int[c.length];
        assignArray(res, c, 0);
        return res;
    }

    public static void assignArray(int[] arr, String[] source, int n){
        if(n == arr.length) return;
        arr[n] = Integer.parseInt(source[n]);
        assignArray(arr, source, n+1);
    }

    public static void fillArray(int[][] board, int[] seq1, int[] seq2){
        // fill the first row
        fillFirstRow(board, seq1, 2);
        // fill the first column
        fillFirstColumn(board, seq2, 2);
        // fill the rest
        fillRest(board, board.length, board[0].length);
    }

    public static void fillFirstRow(int[][] board,int[] seq1, int j){
        if(j >= board[0].length ) return;
        board[0][j] = seq1[j-2];

        fillFirstRow(board, seq1, j + 1);

    }

    public static void fillFirstColumn(int[][] board,int[] seq2, int i){
        if(i >= board.length ) return;
        board[i][0] = seq2[i-2];

        fillFirstColumn(board,seq2,i+1);
    }

    public static void fillRest(int[][] board, int rows, int cols){
        recColumn(board, rows, cols, 2, 2);
    }

    public static void recColumn(int[][] board, int rows, int cols, int i, int j){
        if( i >= rows) return;

        int a = board[i - 1][j];
        int b = board[i][j - 1];
        int c = board[i-1][j-1] + funcCal(board, i, j);
        board[i][j] = Math.max(a, Math.max(b, c));

        if(j >= cols-1) {
            // if it hits the end of the row, goes to next row
            recColumn(board, rows, cols, i + 1, 2);
        }else {
            // go to next cell
            recColumn(board, rows, cols, i, j + 1);
        }
    }

    public static int funcCal(int[][] board, int i, int j){
        if(board[0][j] == board[i][0]) return 1;
        return 0;
    }

    public static void display(int[][] arr){
        for (int[] row : arr){
            for(int c: row){
                System.out.print(c +" ");
            }
            System.out.println();
        }
    }
}
