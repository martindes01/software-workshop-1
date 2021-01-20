/**
 * The MileConversions class converts miles to yards, feet and inches.
 */
public class MileConversions {

    public static void main(String[] args) {
        final int INCHES_PER_MILE = 63360;
        final int FEET_PER_MILE = 5280;
        final int YARDS_PER_MILE = 1760;

        int miles = 30;

        System.out.println(miles + " miles is equal to " + miles * YARDS_PER_MILE + " yards.");
        System.out.println(miles + " miles is equal to " + miles * FEET_PER_MILE + " feet.");
        System.out.println(miles + " miles is equal to " + miles * INCHES_PER_MILE + " inches.");
    }

}
