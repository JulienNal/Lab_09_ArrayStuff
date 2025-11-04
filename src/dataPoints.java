import java.util.Random;
import java.util.Scanner;

public class dataPoints {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];

        Random rand = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1; // values 1..100
        }

        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }

        double average = sum / (double) dataPoints.length;

        System.out.println("The sum of the values in the dataPoints array is: " + sum + ".");
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Call the new static helper to demonstrate it returns the same average
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

        Scanner sc = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(sc, "Please enter an integer between 1 and 100: ", 1, 100);
        System.out.println("You entered: " + userValue + ".");

        // Count how many times userValue appears in the array
        int occurrences = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                occurrences++;
            }
        }
        System.out.println("The value " + userValue + " was found " + occurrences + " time" + (occurrences == 1 ? "" : "s") + " in the dataPoints array.");

        // Find min and max in a single pass
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value in the dataPoints array is: " + min + ".");
        System.out.println("The maximum value in the dataPoints array is: " + max + ".");

        // Prompt again and search for the first occurrence (short-circuit with break)
        int searchValue = SafeInput.getRangedInt(sc, "Enter another integer to search for in the array (1-100): ", 1, 100);
        int foundIndex = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex >= 0) {
            System.out.println("The value " + searchValue + " was found at array index " + foundIndex + ".");
        } else {
            System.out.println("The value " + searchValue + " was not found in the dataPoints array.");
        }

        sc.close();
    }

    public static double getAverage(int values[]) {
        if (values == null || values.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (int v : values) {
            sum += v;
        }
        return sum / values.length;
    }
}
