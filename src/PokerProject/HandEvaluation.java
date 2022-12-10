package PokerProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HandEvaluation {
    //method to draw two hands from the same deck
    public static void twoDifferentHands(){

        List<String> PlayerOne = Deck.drawFive();
        List<String> PlayerTwo = Deck.drawFive();

        System.out.println("Player one's cards: " + PlayerOne);
        System.out.println("Player two's cars: " + PlayerTwo);
    }
    //method that allows to remove up to 5 cards from the hand
    public static String removeCardsFromHand(){
        //Every time this method will be called a card will be removed
        List<String> getRidOfOneCard = Deck.drawFive();
        Stack<String> cards = new Stack<>();

        for(int i =0; i < getRidOfOneCard.size(); i++){
            cards.push(getRidOfOneCard.get(i));
        }
        return cards.pop();
    }
    //method that fills the hand with 5 cards
    public static List<String> refillHandWithCards(){
        List<String> calledCards = Deck.drawFive();
        List<String> refilledCards  = new ArrayList<>();

        refilledCards.addAll(calledCards);

        return refilledCards;
    }

    public static void playerOneCards(){
        System.out.println("Checking Player one's cards:");
        Deck.checkForAPair();
        //Deck.checkForFlush();
        //Deck.checkForAStraight();
    }

    public static void playerTwoCards(){
        System.out.println("Display Player two's cards");
        Deck.checkForFlush();
        //Deck.checkForAPair();
        //Deck.checkForAStraight();
    }
}
