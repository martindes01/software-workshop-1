import java.util.Scanner;

/**
 * The QuartsToGallonsInteractive class converts quarts to gallons with user
 * input.
 *
 * @author Martin
 * @version 1.0.0
 */
public class QuartsToGallonsInteractive {

    public static void main(String[] args) {
        final int QUARTS_PER_GALLON = 4;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many quarts does the job need?");
        int quartsNeeded = sc.nextInt();

        sc.close();

        System.out.println("A job that needs " + quartsNeeded + " quarts requires " + quartsNeeded / QUARTS_PER_GALLON
                + " gallons plus " + quartsNeeded % QUARTS_PER_GALLON + " quarts.");
    }

}
