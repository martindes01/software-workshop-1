import java.util.Scanner;

/**
 * The MinutesConversion class converts minutes to both hours and days.
 */
public class MinutesConversion {

    public static void main(String[] args) {
        final int MINUTES_PER_HOUR = 60;
        final int MINUTES_PER_DAY = 1440;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many minutes?");
        int minutes = sc.nextInt();

        sc.close();

        System.out.println(minutes + " minutes is equal to " + (float) minutes / MINUTES_PER_HOUR + " hours or " + (float) minutes / MINUTES_PER_DAY + " days.");
    }

}
