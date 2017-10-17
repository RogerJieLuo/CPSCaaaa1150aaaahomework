package Lab6;

import java.util.Scanner;

/**
 * Created by jie luo.
 * @version 2017-10-16
 * Class DNAScore
 * DNAScore calculate the score of DNA based on table
 *    A  C  G  T  -
 * A  1 -2 -2 -2 -1
 * C -2  1 -2 -2 -1
 * G -2 -2  1 -2 -1
 * T -2 -2 -2  1 -1
 * - -1 -1 -1 -1  0
 */
public class DNAScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq1 = getSequence(sc);
        String seq2 = getSequence(sc);
        printSeq(seq1, seq2);
        System.out.println("Score is: "+compare(seq1, seq2));
    }

    // print the formatting DNA sequence
    private static void printSeq(String seq1, String seq2){
        int bigLength = Math.max(seq1.length(), seq2.length());
        System.out.println("Comparing sequences: \n"+format(seq1, bigLength)+"\n"+format(seq2, bigLength));
    }

    private static String format(String seq, int len){
        String str = seq;
        if(seq.length() < len){
            for(int i = 0;i<len - seq.length();i++){
                str+='-';
            }
        }
        return str;
    }

    // get user input for DNA sequence
    private static String getSequence(Scanner sc){
        String msg;
        System.out.print("Enter a Sequence\n>");
        msg = sc.nextLine().toUpperCase();
        // if the input is invalid, ask for the input again
        while(!isValid(msg)) {
            System.out.print("Invalid sequence, Try again\n>");
            msg = sc.nextLine().toUpperCase();
        }
        return msg;
    }

    // validate the user inputs
    private static boolean isValid(String msg){
        for(int i = 0;i<msg.length();i++){
            if(msg.charAt(i)!='A' && msg.charAt(i) != 'G' && msg.charAt(i) != 'C' && msg.charAt(i) != 'T'
                    && msg.charAt(i) != '-'){
                return false;
            }
        }
        return true;
    }

    // compare the 2 DNA sequences
    private static int compare(String seq1, String seq2){
        int i = 0, j =0, count = 0;
        char a, b;
        while(i<seq1.length() || j<seq2.length()){
            if(i<seq1.length()) {
                a = seq1.charAt(i++);
            }else{
                a = '-';
            }
            if(j<seq2.length()) {
                b = seq2.charAt(j++);
            }else{
                b = '-';
            }
            // calculate the score
            count += calScore(a,b);
//            System.out.println("i: "+a+", b: "+b+", cal: "+calScore(a,b));
        }
        return count;
    }

    // calculate the score based on different match
    private static int calScore(char a, char b){
        a = Character.toLowerCase(a);
        b = Character.toLowerCase(b);
        if(a == b ){
            if(a!= '-') {
                return 1;
            }else{
                return 0;
            }
        }else {
            if(a != '-' && b != '-'){
                return -2;
            }else{
                return -1;
            }
        }
    }
}
