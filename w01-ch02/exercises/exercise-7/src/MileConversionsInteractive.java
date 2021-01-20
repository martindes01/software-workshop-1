import java.util.Scanner;

/**
 * The MileConversionsInteractive class converts miles to yards, feet and inches
 * with user input.
 */
public class MileConversionsInteractive {

    public static void main(String[] args) {
        final int INCHES_PER_MILE = 63360;
        final int FEET_PER_MILE = 5280;
        final int YARDS_PER_MILE = 1760;

        Scanner sc = new Scanner(System.in);

        System.out.println("How many miles?");
        int miles = sc.nextInt();

        sc.close();

        System.out.println(miles + " miles is equal to " + miles * YARDS_PER_MILE + " yards.");
        System.out.println(miles + " miles is equal to " + miles * FEET_PER_MILE + " feet.");
        System.out.println(miles + " miles is equal to " + miles * INCHES_PER_MILE + " inches.");
    }

}
