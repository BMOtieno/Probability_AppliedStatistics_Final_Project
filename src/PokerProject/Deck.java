package PokerProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    /**
     * This is a class that has a deck and can draw from the deck
     */
    static int onePair, twoPair, threeOfAKind, fullHouse, fiveOfAKind, straightPick, flushPick;
    //method to draw 5 cards
    public static List<String> drawFive() {
        //System.out.println("The 5 drawn cards are: ");
        List<String> output = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            output.add(drawRandomCard());
        }
        return output;
    }
    public static String drawRandomCard() {
        Random random = new Random();
        int index = random.nextInt(52);
        return Card.getAllCards().get(index);
    }
    //method to shuffle all cards
    public static void shuffleCards(){

        List<String> allCards = Card.getAllCards();
        //stores the order of the cards after shuffling
        List<String> shuffledCards = new ArrayList<>();

        Random random = new Random();
        int randomNumber;
        String addedCard;

        for(int i = 0; i < allCards.size(); i++){
            randomNumber = random.nextInt(allCards.size());
            addedCard = allCards.get(randomNumber).substring(0,10);
            shuffledCards.add(addedCard);
        }
    }
    public static void evaluateDrawnCards() {
        checkForFlush();
        checkForAPair();
        checkForAStraight();
    }
    public static void checkForAStraight(){
        int straight = 0;

        List<String> myCards = drawFive();
        System.out.println(myCards);
        for(int i =0; i < myCards.size(); i++){
            if(i >= myCards.size() + 1 - myCards.size()){
                if(myCards.get(i-1).charAt(0) > myCards.get(i).charAt(0)){
                    straight++;
                }
                if(i == myCards.size() - 1){
                    if(straight == 4){
                        System.out.println("I have a Straight. Game Over.");
                        straightPick++;
                    }
                }
            }
        }
    }
    public static void checkForFlush(){

        int flush = 0;

        List<String> cards = drawFive();
        System.out.println(cards);
        for(int i = 0; i < cards.size(); i++){
            if(i >= cards.size() + 1 - cards.size()){
                if(cards.get(i - 1).substring(5,10) == cards.get(i).substring(5,10)){
                    flush++;
                }
                if(i == cards.size() - 1){
                    if(flush == 4){
                        //This means cards are in descending order
                        System.out.println("Flush. Game over");
                        flushPick++;
                    }
                }
            }
        }
    }
    public static void checkForAPair() {
        int pair = 0;

        //The random drawn cards are the user's current cards at hand
        List<String> cardsAtHand = drawFive();
        System.out.println(cardsAtHand);

        for (int i = 0; i < cardsAtHand.size() - 1; i++) {
            for (int j = i + 1; j < cardsAtHand.size(); j++) {
                if (cardsAtHand.get(i) == cardsAtHand.get(j)) {
                    pair++;
                    System.out.println("Number of pairs drawn: " + pair);
                }
                if (i == cardsAtHand.size() - 2) {
                    switch (pair) {
                        case 1:
                            System.out.println("One pair drawn");
                            onePair++;
                            break;
                        case 2:
                            System.out.println("Two pair drawn");
                            twoPair++;
                            break;
                        case 3:
                            System.out.println("Three of the same kind drawn");
                            threeOfAKind++;
                            break;
                        case 4:
                            System.out.println("Full House");
                            fullHouse++;
                            break;
                        case 5:
                            System.out.println("All five suites are the same suite");
                            fiveOfAKind++;
                            break;
                        default:
                            System.out.println("No match present in the deck");
                    }
                }
            }
        }
    }
    public static void results(){
        System.out.print("%\n of a pair: " + (onePair * 100) / 100000.0 +
                "\n% of two pairs: " + (twoPair * 100) / 100000.0 +
                "\n% of three of a kind: " + (threeOfAKind * 100) / 100000.0 +
                "\n% of full house: " + (fullHouse * 100) / 100000.0 +
                "\n% of four of a kind: " + (fiveOfAKind * 100) / 100000.0 +
                "\n% of straight: " + (straightPick * 100) / 100000.0 +
                "\n% of a flush: " + (flushPick * 100) / 100000.0);
    }
    //Monte Carlo Simulation
    public static void runSimulation(){
        for(int i = 0; i < 100000; i++){
            shuffleCards();
            evaluateDrawnCards();
        }
        results();
    }
}
