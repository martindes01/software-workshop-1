import javax.swing.JOptionPane;

/**
 * The RandomGuess class ask the user to enter a number between 1 and 10. It
 * then displays a random number.
 *
 * @author Martin
 * @version 1.0.0
 */
public class RandomGuess {

	public static void main(String[] args) {
		JOptionPane.showInputDialog("Think of a number between 1 and 10:");
		JOptionPane.showMessageDialog(null, "The number is " + (1 + (int) (Math.random() * 10)) + '.');
	}

}
