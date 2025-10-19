import java.util.Scanner;
import java.util.Random;

public class inputValidation {
    public static void main(String[] args) {

        // have user input array size
        Scanner inputScanner = new Scanner(System.in);

        boolean notInt = true;

        // initialize arraySize here to avoid compiler throwing error
        int arraySize = 0;
        do {
            System.out.print("Enter the size of the array to be sorted: ");
            try {
                arraySize = inputScanner.nextInt();
                //clearing \n after parsing integer
                inputScanner.nextLine();
                if (arraySize < 1) {
                    throw new Exception();
                }

                // if code reached this point, input is valid
                notInt = false;
            } catch (Exception err) {
                System.out.println("Invalid array size... Please enter a positive integer.");
                // clearing invalid input from buffer to prevent infinite loop
                inputScanner.nextLine(); 
            }
            
        } while (notInt);

        // create int[] with specified user size
        int[] userArray = new int[arraySize];

        // fill array with user values

        // initialize before loop to avoid compiler throwing errors
        boolean userWantsToInput = true;

        int currentIndex = 0;
        do {
            System.out.printf("Enter element %d (Type \"R\" to fill rest of array with random values between 0 and 1000): ", currentIndex);
            String userInput = inputScanner.nextLine();

            // check if user wants to randomize elements
            if (userInput.equals("R")) {
                userWantsToInput = false;

                // generate random elements for the rest of the array from 0 to 1000
                Random r = new Random();
                for (int i = currentIndex; i < arraySize; i++) {
                    userArray[currentIndex] = r.nextInt(1001);
                }
            } else {
                // since user doesn't want to randomize elements, check whether the input is an
                // integer
                try {
                    int userElement = Integer.parseInt(userInput);
                    userArray[currentIndex] = userElement;
                    currentIndex++;
                } catch (Exception e) {
                    System.out.println("Invalid Input...");
                }
            }

            

            
        } while (userWantsToInput && currentIndex < arraySize);


        // close inputScanner to prevent memory leak
        inputScanner.close();
    }
}
 
