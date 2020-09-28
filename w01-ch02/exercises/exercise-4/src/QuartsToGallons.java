/**
 * The QuartsToGallons class converts quarts to gallons.
 *
 * @author Martin
 * @version 1.0.0
 */
public class QuartsToGallons {

    public static void main(String[] args) {
        final int QUARTS_PER_GALLON = 4;
        int quartsNeeded = 18;

        System.out.println("A job that needs " + quartsNeeded + " quarts requires " + quartsNeeded / QUARTS_PER_GALLON
                + " gallons plus " + quartsNeeded % QUARTS_PER_GALLON + " quarts.");
    }

}
