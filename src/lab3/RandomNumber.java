package lab3;

import java.util.Random;

/**
 * Created by jieluo on 2017-09-20.
 */
public class RandomNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1, num2, num3a, num3b, num3c, num3d;

        // get first set
        num1 = rand.nextInt(1000);
        while((""+num1).contains("8") || (""+num1).contains("9")){
            num1 = rand.nextInt(1000);
        }

        // get second set
        num2 = rand.nextInt(656);

        // get third set
        num3a = rand.nextInt(10);
        num3b = rand.nextInt(10);
        num3c = rand.nextInt(10);
        num3d = rand.nextInt(10);
        while(num3a + num3b+num3c+num3d > 21){
            num3a = rand.nextInt(10);
            num3b = rand.nextInt(10);
            num3c = rand.nextInt(10);
            num3d = rand.nextInt(10);
        }

        System.out.printf("The random number is: \n%03d-%03d-%d%d%d%d", num1,num2,num3a,num3b,num3c,num3d);
    }
}
