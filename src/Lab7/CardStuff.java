package Lab7;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jieluo on
 * Version 2017-10-24.
 * Class CardStuff
 * CardStuff create a deck of 52 cards, cut the deck, perfect shuffle and print out the deck.
 */
public class CardStuff {
    public static void main(String[] args) {
        // create a deck
        String[] deck = createDeck();

        // random shuffle
        shuffle(deck);
        printDeck(deck);

        // cut deck
        cut(deck);
        printDeck(deck);

        // perfect shuffle
        perfectShuffle(deck);
        printDeck(deck);
    }

    public static void printDeck(String[] deck){
        for(int i = 0;i<deck.length;i++){
            System.out.print(deck[i]+" ");
//            if((i+1) % 4 == 0)
//                System.out.println();
        }
        System.out.println();
    }

    public static String[] createDeck(){
        int N = 52;
        String[] deck = new String[N];
        char[] types = {'C','D','H','S'};
        int count=0;
        for(int i = 0; i < 13 ; i++){
            String c = ""+(i+1);
            if(i+1==1){
                c = "A";
            }else if(i+1 == 11){
                c = "J";
            }else if(i+1 == 12){
                c ="Q";
            }else if(i+1 == 13){
                c = "K";
            }
            for(int j = 0;j<types.length;j++){
                deck[count++] = ""+types[j]+c;
            }
        }
        return deck;
    }

    public static void shuffle(String[] deck){
        Random rand = new Random();
        int randIndex = 0;
        String temp = "";
        for(int i = 0;i<deck.length;i++){
            randIndex = rand.nextInt(52);
            temp = deck[i];
            deck[i] = deck[randIndex];
            deck[randIndex] = temp;
        }
    }

    public static void cut(String[] deck){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cut the deck");
        int n = sc.nextInt();
        rearrange(n, deck);
    }

    public static void rearrange(int n, String[] deck){
        String[] arranged = new String[deck.length];
        // copy the cards after the number to the new array
        for(int i = n; i<deck.length;i++){
            arranged[i-n] = deck[i];
        }
        // add the first n cards to the end of the new array
        for(int i = 0;i<n;i++){
            arranged[i+deck.length-n] = deck[i];
        }
        // assign the new array value back to the deck
        for(int i =0;i<deck.length;i++){
            deck[i] = arranged[i];
        }
    }

    public static void perfectShuffle(String[] deck){
        System.out.println("Shuffle:");
        String[] shuffled = new String[deck.length];
        // put the first half deck at the perfect place
        for(int i = 0;i<deck.length/2; i++){
            shuffled[2*i] = deck[i];
            shuffled[2*i+1] = deck[deck.length/2+i];
        }

        // assign it back to deck
        for(int i = 0;i<deck.length;i++){
            deck[i] = shuffled[i];
        }

    }
}
