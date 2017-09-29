package lab4;

import java.util.Random;
import java.util.Scanner;

/**
 * @Created by jieluo
 * @Version 2017-09-20
 * @Class Lab4
 * @Lab4 Generates a random user name and ask for a password from the user.
 * Write a program that generates a random user name and ask for a password from the user. The user must enter their
 * name as a string (First and Last). The program generates the user name by using the first letter of the last name
 * and the first 5 letters of the first name, plus a random 3-digitnumber. If their firstname doesn’t have 5 letters
 * you should use their whole name and if the user doesn’t have a last name,the user’sfirst letter of the first name
 * should be used instead. The password should be a 8 letters (both upper and lower) and numbers. It must have at
 * least 2 lower case letters, 2 uppers and 2 numbers. If the password is invalid the program should inform the user
 * how it is wrong and end. If itis valid it for print the user name and password and give a 12-digit activation code.
 *
 * Sorry no loops yet
 */
public class Lab4 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String name, username, password;
        boolean validated = true, normalC = true;   // variable for checking character validation and general validation
        char firstLetter;
        int numUp=0, numLow=0, numDig=0;            // collect the number of different type of characters
        String generationCode;                      // random 12 digits

        // get input from user
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your password: ");
        password = sc.nextLine();

        // start checking the validation of password.
        char temp = password.charAt(0);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(1);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(2);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(3);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(4);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(5);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(6);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        temp = password.charAt(7);
        if(Character.isUpperCase(temp)){
            numUp++;
        }else{
            if(Character.isLowerCase(temp)){
                numLow++;
            }else{
                if(Character.isDigit(temp)){
                    numDig++;
                }else{
                    normalC = false;
                }
            }
        }
        // end of the checking validation

        // result of validation
        if(numUp < 2){
            System.out.println("Not Enough uppercases");
            validated = false;
        }
        if(numLow < 2){
            System.out.println("Not Enough lower case");
            validated = false;
        }
        if(numDig < 2){
            System.out.println("Not Enough numbers");
            validated = false;
        }
        if(!normalC){
            System.out.println("Invalid character in password");
            validated = false;
        }

        // if validate, go through the username format and result printing
        if(validated) {
            if(name.contains(" ")){
                // if it has a last name
                firstLetter = name.substring(name.indexOf(" ")+1).toUpperCase().charAt(0);
            }else{
                firstLetter = name.toUpperCase().charAt(0);
            }

            if(name.substring(0, name.indexOf(" ")).length()>=5) {
                // if the length of first name is 5 or longer
                username = firstLetter + name.substring(0, 5);
            }else{
                // first name is too short, use whole name
                username = firstLetter + name.substring(0, name.indexOf(" "));
            }

            // use 2 6-digit random numbers to generate a 12 digits code
            generationCode = "" + rand.nextInt(1000000)+rand.nextInt(1000000);

            System.out.printf("User Name: %s%03d", username, rand.nextInt(1000));
            System.out.println();
            System.out.println("Activation code: "+generationCode);
        }else{
            System.out.println("Invalid Password");
        }
    }
}
