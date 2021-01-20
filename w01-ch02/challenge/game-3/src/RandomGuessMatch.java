import javax.swing.JOptionPane;

/**
 * RandomGuessMatch
 */
public class RandomGuessMatch {

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 5;

        int random = MIN + (int) (Math.random() * MAX);

        int guess = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Enter a random number between " + MIN + " and " + MAX + ':'));

        JOptionPane.showMessageDialog(null, "Your guess was " + (random - guess) + " away from the random number.");

        JOptionPane.showMessageDialog(null,
                "The random number was " + random + ".  Did you guess it correctly?  " + (guess == random) + '.');
    }

}
