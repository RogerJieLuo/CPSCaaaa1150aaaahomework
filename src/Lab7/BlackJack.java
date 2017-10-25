package Lab7;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jie luo
 * Date: 2017-10-24.
 * Class BlackJack
 * BlackJack allow user to play BlackJack with computer.
 * sample output:
     You have H4, S6 : 10
     Dealer has HA, ? : 11
     Would you like to hit or stand:
     hit
     You have H4, S6, DQ : 20
     Would you like to hit or stand:
     stand
     Dealer has HA, S2 : 13
     YOU WIN!!!
     Would you like to play again(Y/N)
     N

 * (end of game)
 */
public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // initialize 2 arrys for player and the dealer(AI)
        String[] deck, userCards, AICards;
        String ans; // some answers from user

        // main game start here
        while(true){
            // initiate the deck and shuffle
            deck = createDeck();
            shuffle(deck);
            userCards = new String[9];     // set it 9 cells, as there is no way to get 10 cards before bust
            AICards = new String[2];        // dealer only has 2 cards
            boolean bust = false;
            ans = "";

            // deal cards to player the the dealer
            deal(deck, userCards, AICards);

            // display open cards
            displayUserCards(userCards);
            displayAICards(AICards, false); // the dealer only shows the first card, so set open to false

            // player's turn for hit or stand
            while (true){
                // ask user choice hit or stand
                ans = userHitChoice(sc);

                // if stand, jump out of the loop
                if(ans.equals("stand")) break;

                // hit another card
                hit(deck, userCards);

                // display the new hand cards
                displayUserCards(userCards);

                // if bust, jump out of loop
                if(calculateScore(userCards, true) > 21){
                    bust = true;
                    break;
                }
            }
            // display all the dealer's cards
            displayAICards(AICards, true);

            // show the result
            result(userCards, AICards, bust);

            // ans: Y: play another round; N: quit game
            ans = userNewGameChoice(sc);

            // quit game
            if(ans.equals("N")) break;
        }
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

    public static void deal(String[] deck, String[] userCards, String[] AICards){
        userCards[0] = deck[0];
        userCards[1] = deck[2];

        AICards[0] = deck[1];
        AICards[1] = deck[3];

        // take those 4 cards off from the deck
        for(int i =0;i<4;i++){
            deck[i] = null;
        }

    }

    public static void hit(String[] deck, String[] userCards){
        int firstCard = 0;
        for(int i = 0;i<deck.length;i++){
            if(deck[i] != null) {
                firstCard = i;
                break;
            }
        }
        for(int i = 0;i<userCards.length;i++){
            if(userCards[i]==null){
                userCards[i] = deck[firstCard];
                break;
            }
        }

        // take the card off from the deck
        deck[firstCard] = null;
    }

    // display user hand cards
    public static void displayUserCards(String[] usersCards){
        String msg = "You have ";
        for(int i = 0;i<usersCards.length;i++){
            if(usersCards[i]==null){
                break;
            }else {
                msg += usersCards[i] + ", ";
            }
        }
        System.out.println(msg.substring(0, msg.length()-2)+" : "+calculateScore(usersCards, true));
    }

    // display dealer hand cards. @param boolean open declare if shows the second card
    public static void displayAICards(String[] AICards, boolean open){
        String msg = "Dealer has ";
        if(open){
            msg += (AICards[0]+", "+AICards[1]+"  ");
        }else{
            msg +=(AICards[0]+", ?  ");
        }
        System.out.println(msg.substring(0, msg.length()-2)+" : "+calculateScore(AICards, open));
    }

    // the open variable is declare for AI, if it's not the open time, it only display the 1st card
    public static int calculateScore(String[] cards, boolean open){
        int total = 0;
        int length = cards.length;
        if(!open){
            length = 1;
        }
        for(int i = 0;i<length;i++){
            if(cards[i]==null){
                break;
            }else{
//                System.out.println(cards[i]);
                int score = 0;
                String card = cards[i];
                String num = card.length()==3 ? card.substring(1) : ""+card.charAt(1);
                if(num.equals("A")){
                    score = 11;
                }else if(num.equals("J") || num.equals("Q") || num.equals("K") ){
                    score = 10;
                }else{
                    score = Integer.parseInt(num);
                }
                total += score;
            }
        }
        return total;
    }

    // user decides go hit or stand
    public static String userHitChoice(Scanner sc){
        System.out.println("Would you like to hit or stand:");
        String ans = sc.nextLine();
        while(!ans.equals("hit") && !ans.equals("stand")){
            System.out.println("(invalid input)\nWould you like to hit or stand:");
            ans = sc.nextLine();
        }
        return ans;
    }

    // user decide if goes another round
    public static String userNewGameChoice(Scanner sc){
        System.out.println("Would you like to play again(Y/N)");
        String ans = sc.nextLine();
        while(!ans.equals("N") && !ans.equals("Y")){
            System.out.println("(Invalid answer.)\nWould you like to play again(Y/N).");
            ans = sc.nextLine();
        }
        return ans;
    }

    public static void result(String[] userCards, String[] AICards, boolean bust){
        String msg = "";

        if(bust){
            msg = "YOU Busted! DEALER WIN!";
        }else {
            // calculate scores
            int userScore = calculateScore(userCards, true);
            int AIScore = calculateScore(AICards, true);

            if (AIScore > userScore) {
                msg = "DEALER WIN!";
            } else if (AIScore < userScore) {
                msg = "YOU WIN!!!";
            } else {
                msg = "It's a tie.";
            }
        }
        System.out.println(msg);
    }
}
