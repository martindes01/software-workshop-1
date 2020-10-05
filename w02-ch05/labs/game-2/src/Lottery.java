import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Lottery
 */
public class Lottery {

    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> winningNumbers = new ArrayList<>();
        List<Integer> guessedNumbers = new ArrayList<>();

        // randomly select three winning numbers
        for (int i = 0; i < 3; i++) {
            winningNumbers.add(rand.nextInt(10));
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Select your first winning number:");
        guessedNumbers.add(Integer.parseInt(sc.nextLine()));

        System.out.println("Select your second winning number:");
        guessedNumbers.add(Integer.parseInt(sc.nextLine()));

        System.out.println("Select your third winning number:");
        guessedNumbers.add(Integer.parseInt(sc.nextLine()));

        sc.close();

        if ((guessedNumbers.get(0) == winningNumbers.get(0)) && (guessedNumbers.get(1) == winningNumbers.get(1))
                && (guessedNumbers.get(2) == winningNumbers.get(2))) {
            System.out.println("You matched all numbers in the correct order.");
            System.out.println("You win $1,000,000!");
        } else {
            int matches = 0;
            for (Integer guess : guessedNumbers) {
                if (winningNumbers.remove(guess)) {
                    matches++;
                }
            }

            System.out.println("You matched " + matches + " numbers.");

            switch (matches) {
                case 0:
                    System.out.println("You win $0.");
                    break;
                case 1:
                    System.out.println("You win $10!");
                    break;
                case 2:
                    System.out.println("You win $100!");
                    break;
                case 3:
                    System.out.println("You win $1,000!");
                    break;
                default:
                    System.out.println("An error has occurred.");
                    break;
            }
        }
    }

}
