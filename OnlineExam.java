import java.util.Scanner;
public class OnlineExam {
 
    public static void main(String[ ] args) {
        Scanner scanner = new Scanner(System.in);
        String password, enteredPassword;
        int numQuestions, numChoices, correctChoice, choice, score = 0;
        String question, feedback;
        long startTime, endTime, timeElapsed, timeLimit;
        
        // Set the password
        System.out.print("Set a password to secure the quiz: ");
        password = scanner.nextLine();
        
        // Ask for password to start the quiz
        do {
            System.out.print("Enter the password to start the quiz: ");
            enteredPassword = scanner.nextLine();
        } while (!password.equals(enteredPassword));
        
        // Ask user to enter number of questions
        System.out.print("Enter the number of questions: ");
        numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
        
        // Initialize the question and answer arrays
        String[ ] questions = new String[numQuestions];
        String[ ][ ] choices = new String[numQuestions][];
        int[ ] correctChoices = new int[numQuestions];
        
        // Ask user to enter each question and its answer choices
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Question " + (i+1) + ":");
            System.out.print("Enter the question text: ");
            questions[i] = scanner.nextLine();
            System.out.print("Enter the number of answer choices: ");
            numChoices = scanner.nextInt();
            scanner.nextLine(); 
            choices[i] = new String[numChoices];
            for (int j = 0; j < numChoices; j++) {
                System.out.print("Enter choice " + (j+1) + ": ");
                choices[i][j] = scanner.nextLine();
            }
            System.out.print("Enter the number of the correct answer choice: ");
            correctChoice = scanner.nextInt();
            scanner.nextLine(); 
            correctChoices[i] = correctChoice;
        }
        // Ask user to enter time limit for quiz
        System.out.print("Enter the time limit for the quiz in seconds: ");
        timeLimit = scanner.nextInt();
        
        // Start the quiz
        System.out.println("QUIZ STARTS ………..");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Question " + (i+1) + ": " + questions[i]);
            for (int j = 0; j < choices[i].length; j++) {
                System.out.println((j+1) + ". " + choices[i][j]);
            }
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            if (choice == correctChoices[i]) {
                score++;
            }
        }
        endTime = System.currentTimeMillis();
        
        // Calculate time elapsed and display results
        timeElapsed = (endTime - startTime) / 1000;
        System.out.println("Quiz completed in " + timeElapsed + " seconds.");
        System.out.println("Your score is " + score + " out of " + 
        numQuestions + ".");
        if (score == numQuestions) {
            feedback = "Excellent job!";
        }
        else if (score >= (numQuestions / 2)) {
            feedback = "Good job.";
        } 
        else {
            feedback = "Better luck next time.";
        }
        System.out.println(feedback);
    }
}