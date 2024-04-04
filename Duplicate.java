
// Import necessary libraries
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Duplicate {

    // Main method to start the program
    public static void main(String[] args) {

        // Initialize a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.println("Enter a string: ");

        // Read the user input as a string
        String str = sc.nextLine();

        // Convert the string to a character array
        char[] characters = str.toCharArray();

        // Create a HashMap to store the character counts
        Map<Character, Integer> charCount = new HashMap<>();

        // Loop through the character array
        for (char c : characters) {

            // Exclude spaces from the character count
            if (c != ' ') {

                // Increment the count for each character
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // Print out the duplicate characters
        System.out.println("Duplicate characters in the given string:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {

            // Check if the character count is greater than 1
            if (entry.getValue() > 1) {

                // Print out the duplicate character
                System.out.println(entry.getKey());
            }
        }
    }
}