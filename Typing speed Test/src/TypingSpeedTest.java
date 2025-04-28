import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {
    // Array of different sentences
    private static final String[] sentences = {
    		"AI transforms industries with speed and precision",
    		"Enhancing lives through smart automation's vision.",
    		"Yet ethics and care must guide its progression",
            "To harness its power with thoughtful decision.",
    };

    private static final String[] paragraphs = {
    		"Artificial Intelligence (AI) is a transformative technology that enables machines to perform tasks typically requiring human intelligence, such as learning, reasoning, and problem-solving",
    		"By leveraging algorithms and vast datasets, AI systems can analyze patterns, make predictions, and automate complex processes across industries like healthcare, finance, and transportation.",
    		"While AI offers immense potential for efficiency and innovation, it also raises ethical concerns, including job displacement, privacy issues, and algorithmic bias.",
            "As AI continues to evolve, responsible development and regulation will be crucial to maximize its benefits while minimizing risks.",
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Typing Speed Test by Visuvanathan!");
        System.out.println();

        while (true) {
            
            System.out.println("What type of text do you want to type?");
            System.out.println("1. Sentence");
            System.out.println("2. Paragraph");
            System.out.print("Enter your choice (1 or 2): ");
            int textTypeChoice = scanner.nextInt();
            scanner.nextLine(); 

            String originalText;

            if (textTypeChoice == 1) {
            
                originalText = sentences[random.nextInt(sentences.length)];
            } else if (textTypeChoice == 2) {
               
                originalText = paragraphs[random.nextInt(paragraphs.length)];
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue; 
            }

            System.out.println("Type the following text:");
            System.out.println(originalText);
            System.out.println();

          
            System.out.println("Press Enter when you are ready to start the test.");
            scanner.nextLine();

            
            System.out.println("Type the text:");
            long startTime = System.currentTimeMillis();
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();

         
            long elapsedTime = endTime - startTime;
            double seconds = elapsedTime / 1000.0;

            int originalTextLength = originalText.length();
            int userInputLength = userInput.length();
            int correctCharacters = 0;

            
            for (int i = 0; i < Math.min(originalTextLength, userInputLength); i++) {
                if (originalText.charAt(i) == userInput.charAt(i)) {
                    correctCharacters++;
                }
            }

          
            int accuracy = (int) (((double) correctCharacters / originalTextLength) * 100);

            double wordsPerMinute = (userInputLength / 5.0) / (seconds / 60);

       
            System.out.println();
            System.out.println("Test Result:");
            System.out.println("--------------");
            System.out.println("Time elapsed: " + seconds + " seconds");
            System.out.println("Accuracy: " + accuracy + "%");
            System.out.println("Words per minute: " + wordsPerMinute);

            
            if (userInputLength > originalTextLength) {
                int extraCharacters = userInputLength - originalTextLength;
                System.out.println("Extra characters typed: " + extraCharacters);
            } else if (userInputLength < originalTextLength) {
                int missingCharacters = originalTextLength - userInputLength;
                System.out.println("Missing characters: " + missingCharacters);
            }

            System.out.println("------------------------------");

          
            System.out.println("Would you like to try again? (Y/N)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; 
            }
        }

        System.out.println("Thank you for using the Typing Speed Test by Visuvanathan. Goodbye!");
        scanner.close();
    }
}