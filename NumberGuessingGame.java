import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 5;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean play = true;

        System.out.println("Welcome to the Guess the Number game!");

        while (play) {
            int target = random.nextInt(MAX_RANGE) + 1;
            int attempt = 0;
            boolean guessed = false;

            System.out.println("\nI'm thinking of a number between 1 and " + MAX_RANGE + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the correct number.");

            while (attempt < MAX_ATTEMPTS) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();
                attempt++;

                if (guess == target) {
                    guessed = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (guessed) {
                int roundScore = MAX_ATTEMPTS - attempt + 1;
                score += roundScore;
                System.out.println("\nCongratulations! You guessed the correct number in " + attempt + " attempts.");
                System.out.println("Round Score: " + roundScore);
            } else {
                System.out.println("\nSorry, you ran out of attempts. The correct number was " + target + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playInput = scanner.next();
            play = playInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + score);
    }
}
