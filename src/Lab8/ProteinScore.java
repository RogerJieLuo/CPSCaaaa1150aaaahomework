package Lab8;

import java.util.Scanner;

/**
 * Created by jie luo
 * 2017-10-31.
 * Class ProteinScore
 * ProteinScore calculate the protein score based on the matrix table
 *
 */
public class ProteinScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int score = 0;
        String s1, s2;
        // record the order of the matrix
        char[] order = {'A','R','N','D','C','Q','E','G','H','I','L','K', 'M','F','P','S','T','W','Y','V','*'};
        // generate the matrix
        int[][] matrix = {
                { 4, -1, -2, -2, 0, -1, -1, 0, -2, -1, -1, -1, -1, -2, -1, 1, 0, -3, -2, 0, -4},
                {-1, 5, 0, -2, -3, 1, 0, -2, 0, -3, -2, 2, -1, -3, -2, -1, -1, -3, -2, -3, -4},
                {-2, 0, 6, 1, -3, 0, 0, 0, 1, -3, -3, 0, -2, -3, -2, 1, 0, -4, -2, -3, -4},
                {-2, -2, 1, 6, -3, 0, 2, -1, -1, -3, -4, -1, -3, -3, -1, 0, -1, -4, -3, -3, -4},
                { 0, -3, -3, -3, 9, -3, -4, -3, -3, -1, -1, -3, -1, -2, -3, -1, -1, -2, -2, -1, -4},
                {-1, 1, 0, 0, -3, 5, 2, -2, 0, -3, -2, 1, 0, -3, -1, 0, -1, -2, -1, -2, -4},
                {-1, 0, 0, 2, -4, 2, 5, -2, 0, -3, -3, 1, -2, -3, -1, 0, -1, -3, -2, -2, -4},
                { 0, -2, 0, -1, -3, -2, -2, 6, -2, -4, -4, -2, -3, -3, -2, 0, -2, -2, -3, -3, -4},
                {-2, 0, 1, -1, -3, 0, 0, -2, 8, -3, -3, -1, -2, -1, -2, -1, -2, -2, 2, -3, -4},
                {-1, -3, -3, -3, -1, -3, -3, -4, -3, 4, 2, -3, 1, 0, -3, -2, -1, -3, -1, 3, -4},
                {-1, -2, -3, -4, -1, -2, -3, -4, -3, 2, 4, -2, 20, -3, -2, -1, -2, -1, 1, -4},
                {-1, 2, 0, -1, -3, 1, 1, -2, -1, -3, -2, 5, -1, -3, -1, 0, -1, -3, -2, -2, -4},
                {-1, -1, -2, -3, -1, 0, -2, -3, -2, 1, 2, -1, 5, 0, -2, -1, -1, -1, -1, 1, -4},
                {-2, -3, -3, -3, -2, -3, -3, -3, -1, 0, 0, -3, 0, 6, -4, -2, -2, 1, 3, -1, -4},
                {-1, -2, -2, -1, -3, -1, -1, -2, -2, -3, -3, -1, -2, -4, 7, -1, -1, -4, -3, -2, -4},
                { 1, -1, 1, 0, -1, 0, 0, 0, -1, -2, -2, 0, -1, -2, -1, 4, 1, -3, -2, -2, -4},
                { 0, -1, 0, -1, -1, -1, -1, -2, -2, -1, -1, -1, -1, -2, -1, 1, 5, -2, -2, 0, -4},
                {-3, -3, -4, -4, -2, -2, -3, -2, -2, -3, -2, -3, -1, 1, -4, -3, -2, 11, 2, -3, -4},
                {-2, -2, -2, -3, -2, -1, -2, -3, 2, -1, -1, -2, -1, 3, -3, -2, -2, 2, 7, -1, -4},
                { 0, -3, -3, -3, -1, -2, -2, -3, -3, 3, 1, -2, 1, -1, -2, -2, 0, -3, -1, 4, -4},
                {-4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, 1}
        };

        while(true){
            s1 = valInput(sc);
            if(s1.equals("-1")) break;
            s2 = valInput(sc);
            if(s2.equals("-1")) break;

            // compare 2 strings
            int len1 = s1.length();
            int len2 = s2.length();
            int lenDiff = Math.max(len1, len2) - Math.min(len1, len2);
            // modify the short string
            if(len1 > len2){
                s2 = modify(s2, lenDiff);
            }else{
                s1 = modify(s1, lenDiff);
            }

            // calculate score
            calScore(s1, s2, matrix, order);

            System.out.println("\nStart over:");
        }

        System.out.println("End");

    }

    // check validated input
    public static String valInput(Scanner sc){
        System.out.println("Enter a sequence: ");
        String s = sc.nextLine();
        if(s.equals("-1")){
            return s;
        }
        while(!checkValid(s)) {
            System.out.println("re-Enter a sequence: ");
            s = sc.nextLine();
        }
        return s;
    }

    public static boolean checkValid(String seq){
        for(int i = 0;i<seq.length();i++){
            char c = seq.charAt(i);
            if( c == '*') continue;
            if(c < 'A' || c > 'Z' || c == 'B' || c == 'J' || c == 'O' || c == 'U' || c == 'X' || c == 'Z' )
                return false;
        }
        return true;
    }

    // modify the short string
    public static String modify(String str, int lenDiff){
        String newStr = "";
        int pre = lenDiff / 2;
        int rem = lenDiff % 2;

        for(int i = 0;i<pre;i++){
            newStr += "*";
        }
        newStr += str;
        for(int i = 0;i<pre;i++){
            newStr += "*";
        }
        if(rem == 1){
            newStr += "*";
        }
        return newStr;
    }

    // calculate the score of 2 strings
    public static int calScore(String s1, String s2, int[][] matrix, char[] order){
        int i = 0;
        int total = 0;

        // print 2 sequences
        for(int j = 0;j< s1.length();j++){
            System.out.printf("%3s ",s1.charAt(j));
        }
        System.out.println();
        for(int j = 0;j< s2.length();j++){
            System.out.printf("%3s ",s2.charAt(j));
        }
        System.out.println();

        // start calculating
        while(i < s1.length()){
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            // get the index of the char
            int ai = getIndex(a, order);
            int bi = getIndex(b, order);

            total += matrix[bi][ai];
            System.out.printf("%3d ", matrix[bi][ai]);
            i++;
        }
        System.out.printf("%3d ", total);
        return total;
    }

    // get the index of the protein
    public static int getIndex(char a, char[] order){
        for(int i = 0;i<order.length;i++){
            if(a == order[i]) return i;
        }
        return -1;
    }

}
