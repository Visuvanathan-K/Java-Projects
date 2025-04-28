import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {
    // Array of different sentences
    private static final String[] sentences = {
        "Your journey to excellence starts at Project Gurukul.",
        "Elevate learning experiences with Project Gurukul's resources.",
        "Discover, learn, and thrive with Project Gurukul's expertise.",
        "Project Gurukul's website hosts an impressive collection of diverse projects.",
        "Each project featured on Project Gurukul's website is thoughtfully documented.",
    };

    private static final String[] paragraphs = {
        "Welcome to Project Gurukul, your gateway to a world of hands-on learning and innovation. Explore our website's diverse collection of projects, each accompanied by its source code. Embark on a journey of practical discovery with Project Gurukul's rich resource of project-based learning.",
        "Project Gurukul's website brings you projects backed by source code. It's like peeking behind the scenes of software and learning from the inside out. Dive in, have fun, and level up your coding skills.",
        "Ever wondered how to turn coding theory into practice? Project Gurukul has your answer. On our website, projects come alive with source code you can study and use. It's a hands-on way to grasp coding concepts and make them your own.",
        "Join us at Project Gurukul and explore various projects with their source code. It's like having a peek behind the scenes of how things work. Dive in, learn, and have fun coding!",
        "Dive into Project Gurukul's website where you'll find projects along with their own source code. Aspiring developers can gain valuable insights into best practices and coding techniques by examining the well-commented source code available on Project Gurukul's website."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Typing Speed Test by ProjectGurukul!");
        System.out.println();

        while (true) {
            // Prompt the user to select the text type
            System.out.println("What type of text do you want to type?");
            System.out.println("1. Sentence");
            System.out.println("2. Paragraph");
            System.out.print("Enter your choice (1 or 2): ");
            int textTypeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            String originalText;

            if (textTypeChoice == 1) {
                // Randomly select a sentence from the array
                originalText = sentences[random.nextInt(sentences.length)];
            } else if (textTypeChoice == 2) {
                // Randomly select a paragraph from the array
                originalText = paragraphs[random.nextInt(paragraphs.length)];
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue; // Restart the loop to get a valid choice
            }

            System.out.println("Type the following text:");
            System.out.println(originalText);
            System.out.println();

            // Prompt user to start the test
            System.out.println("Press Enter when you are ready to start the test.");
            scanner.nextLine();

            // User types the text
            System.out.println("Type the text:");
            long startTime = System.currentTimeMillis();
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();

            // Calculate elapsed time in seconds
            long elapsedTime = endTime - startTime;
            double seconds = elapsedTime / 1000.0;

            int originalTextLength = originalText.length();
            int userInputLength = userInput.length();
            int correctCharacters = 0;

            // Compare the user's input with the original text to count correct characters
            for (int i = 0; i < Math.min(originalTextLength, userInputLength); i++) {
                if (originalText.charAt(i) == userInput.charAt(i)) {
                    correctCharacters++;
                }
            }

            // Calculate accuracy as a percentage
            int accuracy = (int) (((double) correctCharacters / originalTextLength) * 100);

            // Calculate words per minute
            double wordsPerMinute = (userInputLength / 5.0) / (seconds / 60);

            // Display test results
            System.out.println();
            System.out.println("Test Result:");
            System.out.println("--------------");
            System.out.println("Time elapsed: " + seconds + " seconds");
            System.out.println("Accuracy: " + accuracy + "%");
            System.out.println("Words per minute: " + wordsPerMinute);

            // Additional functionality - Check for extra or missing characters
            if (userInputLength > originalTextLength) {
                int extraCharacters = userInputLength - originalTextLength;
                System.out.println("Extra characters typed: " + extraCharacters);
            } else if (userInputLength < originalTextLength) {
                int missingCharacters = originalTextLength - userInputLength;
                System.out.println("Missing characters: " + missingCharacters);
            }

            System.out.println("------------------------------");

            // Prompt the user to try again
            System.out.println("Would you like to try again? (Y/N)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; // Exit the loop if the user doesn't want to try again
            }
        }

        System.out.println("Thank you for using the Typing Speed Test by ProjectGurukul. Goodbye!");
        scanner.close(); // Close the scanner after the loop ends
    }
}