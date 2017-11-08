package Lab8;

import java.util.Arrays;
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
        int N = 5;
        String[] ori = new String[N];  // store the original string input
        String[] score = new String[N];       // store the score calculate progress
        int[] total = new int[N];       // store the total score for original string
        int[] orderIndex = new int[N];      // each time order the string based on the total score
        int count = 0;                  // the input times
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

            // check size of the arrays
            if(ori[ori.length-1] != null){
                System.out.println("reach max size. DOUBLE THEM!");
                ori = dbStringArray(ori);
                score = dbStringArray(score);
                total = dbIntArray(total);
                orderIndex = dbIntArray(orderIndex);
            }

            // starting compare all the strings
            compare(s1, ori, score, total, matrix, order, count);

            // create order
            order(total, orderIndex, count);

            // print
            print(ori, score, total, orderIndex, count);

//            for(int i = 0;i<count+1;i++){
//                System.out.print(ori[i] +"\t");
//            }
//            System.out.println();
//            for(int i = 0;i<count+1;i++){
//                System.out.print(score[i] +"\t");
//            }
//            System.out.println();
//            for(int i = 0;i<count+1;i++){
//                System.out.print(total[i] +"\t");
//            }
//            System.out.println();
//            for(int i = 0;i<count+1;i++){
//                System.out.print(orderIndex[i] +"\t");
//            }
//            System.out.println();
            // count added
            count ++;
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

    public static void compare(String str, String[] ori, String[] score, int[] total, int[][] matrix, char[] order,
                               int count){

        ori[count] = str;   // insert the string to the ori array
//        for(int i = 0;i<count+1;i++){
//            System.out.println(ori[i]);
//        }
        score[count] = "";

        int len2, lenDiff, _score;
//        String s1= str, s2;
        // compare to the current
        for(int i = 0;i<count;i++){

            // start calculating
            String s1 = str;
            String s2 = ori[i];
            int len1 = str.length();

            len2 = ori[i].length();
            lenDiff = Math.max(len1, len2) - Math.min(len1, len2);

            // modify the short string
            if(len1 > len2){
                s2 = modify(s2, lenDiff);
            }else{
                s1 = modify(s1, lenDiff);
            }
            // get the score return
            _score = calScore(s1, s2, matrix, order);

            // update the score list
            if(count == 1) {
                score[i] = "" + _score;
            }else {
                score[i] = score[i] + "+" + _score;
            }
            if(i == 0){
                score[count] = "" + _score;
            }else {
                score[count] = score[count] + "+" + _score;
            }
            // update the total score
            total[i] = total[i] + _score;
            total[count] = total[count] + _score;
        }

//        for(int i = 0;i<count+1;i++){
//            System.out.println(total[i]);
//        }

    }

    public static String[] dbStringArray(String[] arr){
        return Arrays.copyOf(arr, arr.length*2);
    }

    public static int[] dbIntArray(int[] arr){
        return Arrays.copyOf(arr, arr.length*2);
    }

    // ordering
    public static void order(int[] total, int[] orderIndex, int count){
        if(count == 0){
            // only display the first string
            return;
        }
        int[] _order = new int[count+1];
        for(int i =0;i<count+1;i++){
            _order[i] = total[i];
        }
        int[] temp = Arrays.copyOf(total, count+1);
        Arrays.sort(_order);
//        for(int i = 0;i<count+1;i++){
//            System.out.println(_order[i]);
//        }
        for(int i = 0;i<_order.length;i++){
            for(int j = 0;j<count+1;j++){
                if(temp[j] == _order[i]){
                    orderIndex[i] = j;
                    temp[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
//        for(int i = 0;i<count+1;i++){
//            System.out.println(orderIndex[i]);
//        }
    }

    public static void print(String[] ori, String[] score, int[] total, int[] orderIndex, int count){
        if(count == 0){
            System.out.println(ori[0] + " "+ 0);
            return;
        }
        String s, _score="";
        for(int i = 0;i<count+1;i++){
            int index = orderIndex[i];
            s = ori[index];
            if(score[index] != null){
                _score = score[index];
            }
            System.out.println(s + " "+ _score +" "+ total[index]);
        }

//        for(int i = 0;i<count+1; i++){
//            System.out.println(total[i]);
//        }
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

        // start calculating
        while(i < s1.length()){
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            // get the index of the char
            int ai = getIndex(a, order);
            int bi = getIndex(b, order);

            total += matrix[bi][ai];
//            System.out.printf("%3d ", matrix[bi][ai]);
            i++;
        }
//        System.out.printf("%3d ", total);
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
