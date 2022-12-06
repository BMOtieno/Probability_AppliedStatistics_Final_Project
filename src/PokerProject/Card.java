package PokerProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    /**
     * This is a class that constructs and holds a 52 card deck
     */
    //suites
    public static List<String> clubs = new ArrayList<>();
    public static List<String> diamonds = new ArrayList<>();
    public static List<String> hearts = new ArrayList<>();
    public static List<String> spades = new ArrayList<>();
    public static List<String> getClubs(){
        clubs = Arrays.asList("Ace of Clubs", "2 of Clubs", "3 of Clubs", "4 of Clubs",
                "5 of Clubs", "6 of Clubs", "7 of Clubs", "8 of Clubs", "9 of Clubs",
                "10 of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs");
        return clubs;
    }
    public static List<String> getDiamonds(){
        diamonds = Arrays.asList("Ace of Diamonds", "2 of Diamonds", "3 of Diamonds",
                "4 of Diamonds", "5 of Diamonds", "6 of Diamonds", "7 of Diamonds", "8 of Diamonds",
                "9 of Diamonds", "10 of Diamonds", "Jack of Diamonds", "Queen of Diamonds",
                "King of Diamonds");
        return diamonds;
    }
    public static List<String> getHearts(){
        hearts = Arrays.asList("Ace of Hearts", "2 of Hearts", "3 of Hearts", "4 of Hearts",
                "5 of Hearts", "6 of Hearts", "7 of Hearts", "8 of Hearts", "9 of Hearts",
                "10 of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts");
        return hearts;
    }
    public static List<String> getSpades(){
        spades = Arrays.asList("Ace of Spades", "2 of Spades", "3 of Spades", "4 of Spades",
                "5 of Spades", "6 of Spades", "7 of Spades", "8 of Spades", "9 of Spades",
                "10 of Spades", "Jack of Spades", "Queen of Spades", "King of Spades");
        return spades;
    }
    public static List<String> getAllCards(){
        CardHolder.cards.addAll(getSpades());
        CardHolder.cards.addAll(getClubs());
        CardHolder.cards.addAll(getDiamonds());
        CardHolder.cards.addAll(getHearts());
        return CardHolder.cards;
    }
}
