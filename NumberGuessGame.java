//Task 1: Number Game

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //To take user input
        Random num = new Random();  // To generate the secret/random number

        int score = 0, round = 1; // To track rounds won & current round number
        String playAgain = "yes"; // User's choice to continue or stop

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100.");

        // Game loop to handle multiple rounds
        while (playAgain.equalsIgnoreCase("yes")) {
            int secretNumber = num.nextInt(100) + 1; // Generate number between 1 and 100
            int attempts = 7; // Max attempts per round
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + " begins! You have " + attempts + " attempts.");

            // Inner loop for handling guesses within a round
            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                try 
                {
                    guess = Integer.parseInt(input.nextLine()); // Convert user input to integer
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Please enter a valid number.");
                    continue; // Skip to next iteration if input isn't a number
                }

                if (guess < secretNumber) 
                {
                    System.out.println("Too low!");
                } 
                else if (guess > secretNumber) 
                {
                    System.out.println("Too high!");
                } 
                else 
                {
                    // User guessed the correct number
                    System.out.println("Correct! You guessed it in " + (8 - attempts) + " attempt(s).");
                    score++;  // Increase score if guessed correctly
                    guessedCorrectly = true;
                    System.out.println("Your current score: " + score);

                    break; // Exit current round
                }
                attempts--; // Decrease remaining attempts

                if (attempts > 0) 
                {
                    System.out.println("Attempts remaining: " + attempts);
                }
            }

            // If user didn't guess correctly
            if (!guessedCorrectly) 
            {
                System.out.println("You've run out of attempts. The correct number was: " + secretNumber);
            }
            round++; // Move to next round

            // Ask user if they want to play another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = input.nextLine(); // Take user input to play again
        }

        // Display final score
        System.out.println("\nGame Over! You won " + score + " round(s). Thanks for playing!");
        
        input.close();
    }
}