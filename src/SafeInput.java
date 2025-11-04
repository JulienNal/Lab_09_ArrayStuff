import java.util.Scanner;

public class SafeInput
{
    /**
     * Get a non-zero length string from the user
     * Use: String name = getNonZeroLenString(pipe, prompt);
     * @param pipe - Scanner to use for input
     * @param prompt -Propmt to display to the user (e.g. "Enter your name: ")
     * @return - a non-empty String
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do {
            System.out.print(prompt);
            retString = pipe.nextLine().trim();
            if (retString.isEmpty())
            {
                System.out.println("Input must be at least one character long. Please try again.");
            }
        } while (retString.isEmpty());

        return retString;
    }

    /**
     *
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user (e.g. "Enter your age: ")
     * @return - an integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash;
        boolean done = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else // Not a number
            {
                trash = pipe.nextLine();
                System.out.println("Illegal number: " + trash + ". Please enter a valid number.");
            }
        } while (!done);

        return retInt;
    }

    /**
     * get any double from the user
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user (e.g. "Enter your age: ")
     * @return - a double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash;
        boolean done = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else // Not a number
            {
                trash = pipe.nextLine();
                System.out.println("Illegal number: " + trash + ". Please enter a valid number.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * get an int within a specific range
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user to indicate what to enter
     * @param low - lowest acceptable value
     * @param high - highest acceptable value
     * @return - an integer within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        String trash;
        boolean done = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal < low || retVal > high)
                {
                    System.out.println("Number must be between " + low + " and " + high + ". Please try again.");
                } else
                {
                    done = true;
                }
            }
            else // Not a number
            {
                trash = pipe.nextLine();
                System.out.println("Input is invalid: " + trash + ". Please enter a valid number.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a double within a specific range
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user to indicate what to enter
     * @param low - lowest acceptable value
     * @param high - highest acceptable value
     * @return - a double within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash;
        boolean done = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal < low || retVal > high)
                {
                    System.out.println("Number must be between " + low + " and " + high + ". Please try again.");
                } else
                {
                    done = true;
                }
            }
            else // Not a number
            {
                trash = pipe.nextLine();
                System.out.println("Input is invalid: " + trash + ". Please enter a valid number.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a yes/no confirmation from the user
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user
     * @return - true if user entered Y/y, false if N/n
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print(prompt + " (Y/N): ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("Invalid input: " + response + ". Please enter Y or N.");
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a string that matches the provided regular expression
     * @param pipe - scanner to use for input
     * @param prompt - prompt to display to the user
     * @param regEx - regular expression the input must match
     * @return - a string that matches the provided regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [" + regEx + "]: ");
            retString = pipe.nextLine().trim();
            if (retString.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Input does not match the required format: " + regEx + ". Please try again.");
            }
        } while (!done);

        return retString;
    }

}
