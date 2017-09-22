package lab3;

import java.util.Scanner;

/**
 * @Created by jieluo
 * @Version 2017-09-20
 * @Class Encrypt
 * @Encrypt will encrypt the input plain text
 *
 * Create a new Java program called Encrypt.java that will get a message from the user and use a shift cypher that
 * will shift each letter to the right by three(A ->D,B->E,...,Z->C).to encrypt the message. Your program should remove
 * all spaces and punctuation (‘,’,’.’,’!’,’?’,’(‘,’)’,’;’,’:’ only worry about those ones). Your encryption will ignore
 * numbers (leave them unchanged) and only encryption letters. Your encrypted message should be printed to console with
 * all upper-case letters.
 *
 * You are not allowed to use if statements or loops to solve this problem.
 *
 * Hint:use the Java String class API.
 * Example the message ‘The quick red fox jumped over the lazy brown dog!’ Would be encoded to
 * ‘WKHTXLFNUHGIRAMXPSHGRYHUWKHODCBEURZQGRJ’
 */
public class Encrypt {
    public static void main(String[] args) {
        String plain;   // input plain text from user

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a message, I will encrypt it.");
        plain = sc.nextLine();

        // lower all the case
        plain = plain.toLowerCase();
        // encrypt them with upper case
        plain = plain.replace('a','D');
        plain = plain.replace('b','E');
        plain = plain.replace('c','F');
        plain = plain.replace('d','G');
        plain = plain.replace('e','H');
        plain = plain.replace('f','I');
        plain = plain.replace('g','J');
        plain = plain.replace('h','K');
        plain = plain.replace('i','L');
        plain = plain.replace('j','M');
        plain = plain.replace('k','N');
        plain = plain.replace('l','O');
        plain = plain.replace('m','P');
        plain = plain.replace('n','Q');
        plain = plain.replace('o','R');
        plain = plain.replace('p','S');
        plain = plain.replace('q','T');
        plain = plain.replace('r','U');
        plain = plain.replace('s','V');
        plain = plain.replace('t','W');
        plain = plain.replace('u','X');
        plain = plain.replace('v','Y');
        plain = plain.replace('w','Z');
        plain = plain.replace('x','A');
        plain = plain.replace('y','B');
        plain = plain.replace('z','C');

        // replace all the punctuation to space
        plain = plain.replace(',',' ');
        plain = plain.replace('.',' ');
        plain = plain.replace('!',' ');
        plain = plain.replace('?',' ');
        plain = plain.replace('(',' ');
        plain = plain.replace(')',' ');
        plain = plain.replace(';',' ');
        plain = plain.replace(':',' ');

        // remove all number
        plain = plain.replaceAll("[0-9]","");
        // remove all the space
        plain = plain.replaceAll(" ","");

        System.out.println("The encrypted text is:\n"+plain);
    }
}
