package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            BlackJack game = new BlackJack();
            game.play();
            playAgain = BlackJack.getYesOrNo("Would you like to play again? Type Y for yes and N for no.");
        }

        System.out.println("Goodbye");
    }
}
