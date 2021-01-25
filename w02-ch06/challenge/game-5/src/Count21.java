import java.util.Scanner;

/**
 * Count21
 */
public class Count21 {

    public static void main(String[] args) {
        final int THRESHOLD = 21;
        final int TARGET_MULTIPLE = 4;

        Scanner sc = new Scanner(System.in);

        int total = 0;

        do {
            int playerChoice = 0;

            do {
                System.out.println("Enter a number to add from 1, 2 and 3:");
                playerChoice = Integer.parseInt(sc.nextLine());
            } while ((playerChoice < 1) || (playerChoice > 3));

            total += playerChoice;

            System.out.println("The total is " + total + ".");
            System.out.println();

            if (total >= THRESHOLD) {
                System.out.println("Oops!  You reached " + THRESHOLD + ".");
                break;
            }

            int computerChoice = TARGET_MULTIPLE - total % TARGET_MULTIPLE;
            total += computerChoice;

            System.out.println("The computer chose " + computerChoice + ".");
            System.out.println("The total is now " + total + ".");
            System.out.println();
        } while (total < THRESHOLD);

        sc.close();
    }

}
