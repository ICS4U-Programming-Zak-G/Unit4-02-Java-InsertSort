// Import libraries
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/** .
* This program uses insertion sorts and files.
* It will sort all the numbers in each line.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-04-13
*/

// Creating class
public final class InsertSort {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Write output string to output file
        FileWriter myWriter = new FileWriter("output.txt");

        // Introduce program to user
        System.out.println("This sorts a file of numbers"
            + " using insertion sort.");

        // Pass the path to the file as a parameter
        File file = new File("./input.txt");
        Scanner scanner = new Scanner(file);

        // Loop while there's another line in the file'
        while (scanner.hasNextLine()) {

            // Initialize current number
            int currentNum = 0;

            // Assign current line to variable
            String line = scanner.nextLine();

            // Split line into array of strings
            String[] lineArrayStr = line.split(" ");

            // Perform insertion sort on the array
            for (int counter = 1; counter < lineArrayStr.length; counter++) {
                // Set current number
                currentNum = Integer.parseInt(lineArrayStr[counter]);

                // Initialize second counter
                int counterTwo = counter - 1;

                // Loop to determine where to insert
                while (counterTwo >= 0 && Integer.parseInt(
                        lineArrayStr[counterTwo]) > currentNum) {
                    // Move larger number right
                    lineArrayStr[counterTwo + 1] = lineArrayStr[counterTwo];

                    // Decrement second counter
                    counterTwo--;
                }
                // Store current number in correct position
                lineArrayStr[counterTwo + 1] = Integer.toString(currentNum);
            }

            // Write sorted line to output string
            for (int counter = 0; counter < lineArrayStr.length; counter++) {
                // Add number to output string
                outputStr += lineArrayStr[counter] + " ";
            }
            // Add new line to output string
            outputStr += "\n";

            // Write to output file
            myWriter.write(outputStr);

            // Reset output string
            outputStr = "";
        }

        // Close scanner
        scanner.close();

        // Close writer
        myWriter.close();
    }
}
