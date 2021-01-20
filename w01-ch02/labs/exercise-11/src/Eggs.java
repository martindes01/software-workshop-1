import javax.swing.JOptionPane;

/**
 * The Eggs class calculates the total cost to buy some eggs by the dozen or
 * loose.
 */
public class Eggs {

    public static void main(String[] args) {
        final int DOZEN = 12;
        final int CENTS_PER_DOLLAR = 100;
        final int CENTS_PER_DOZEN = 325;
        final int CENTS_PER_LOOSE = 45;

        int totalEggs = Integer.parseInt(JOptionPane.showInputDialog(null, "How many eggs would you like to order?"));

        int totalDozens = totalEggs / DOZEN;
        int totalLoose = totalEggs % DOZEN;

        float dozenCost = (float) CENTS_PER_DOZEN / CENTS_PER_DOLLAR;
        float totalCost = (float) (totalDozens * CENTS_PER_DOZEN + totalLoose * CENTS_PER_LOOSE) / CENTS_PER_DOLLAR;

        JOptionPane.showMessageDialog(null,
                "You ordered " + totalEggs + "eggs.  That's " + totalDozens + " dozen at $" + dozenCost
                        + " per dozen and " + totalLoose + " loose eggs at " + CENTS_PER_LOOSE
                        + " cents each for a total of $" + totalCost + '.');
    }

}
