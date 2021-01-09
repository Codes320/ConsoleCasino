package academy.learnprogramming;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    private Random randomCard = new Random();
    private static Scanner scanner = new Scanner(System.in);

    private int playerNumber = 0;
    private int dealerNumber = 0;
    private int faceCard1 = 1 + randomCard.nextInt(10);
    private int faceCard2 = 1 + randomCard.nextInt(10);

    private String playerChoice;
    private String playerValue;

    public void printIntroParagraph() {
        System.out.println("");
        System.out.println("Hello, and welcome to the Console Casino's signature game, Blackjack!");
        System.out.println("I hope you're ready to get started!");
        System.out.println("");
        System.out.println("Dealer plays to a soft 16");
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("DEAL - Ask the dealer to begin the game");
        System.out.println("HIT - Take a card from the dealer");
        System.out.println("STAY - Stay with your current hand.");
        System.out.println("");
        System.out.println("Type DEAL to begin the game!");
    }

    public void play() {
        printIntroParagraph();
        if (scanner.nextLine().equalsIgnoreCase("deal")) {
            deal();
        }
    }

    public void deal() {

        playerNumber = faceCard1 + faceCard2;
        dealerNumber = 1 + randomCard.nextInt(10);

        System.out.printf("Your face cards are %d and %d. That makes %d your total.%n", faceCard1, faceCard2, playerNumber);
        System.out.printf("The dealer's face card is %d.%n", dealerNumber);

        do {
            System.out.println("Will you HIT or STAY? ");
            playerChoice = scanner.nextLine();

            if (playerChoice.equalsIgnoreCase("hit")) {
                int hitCard = 1 + randomCard.nextInt(10);
                playerNumber = playerNumber + hitCard;
                System.out.printf("You've chosen to hit! You drew a %d. Your total amount is %d.%n", hitCard, playerNumber);
            } else if (playerChoice.equals("stay")) {
               System.out.printf("You've chosen to stay! ");
               break;
            } else {
                System.out.printf("Sorry, I don't understand what %s means.", playerChoice);
            }
        } while (playerNumber <= 21);

        dealerTurn();
    }

    public void dealerTurn() {
        if (playerNumber > 21) {
            System.out.println("Oh no! You went over 21. The dealer wins. :(");
        } else {
            do {
                dealerNumber = dealerNumber + 1 + (randomCard.nextInt(10));
            } while (dealerNumber < 16);

            if (dealerNumber > 21) {
                System.out.printf("The dealer drew to %d. You win!%n", dealerNumber);
            } else if (dealerNumber == playerNumber) {
                System.out.printf("You drew to %d and the dealer also drew to %d. It's a tie!%n", playerNumber, dealerNumber);
            } else if (playerNumber > dealerNumber) {
                System.out.printf("You drew a %d and the dealer drew a %d. You win!%n", playerNumber, dealerNumber);
            } else if (playerNumber < dealerNumber) {
                System.out.printf("You drew a %d and the dealer drew a %d. You lose.%n", playerNumber, dealerNumber);
            }
        }
    }

    public static boolean getYesOrNo(String question) {
        String answer;

        while (true) {  // infinite loop.  return will exit the method, thus terminating the loop
            System.out.printf("%s%n", question);
            answer = scanner.nextLine();
            answer = answer.toLowerCase();

            if (answer.equals("y")) {
                return true;
            }

            if (answer.equals("n")) {
                return false;

            }
        }
    }
}