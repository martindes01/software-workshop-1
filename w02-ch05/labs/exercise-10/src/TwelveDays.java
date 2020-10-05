import java.util.Scanner;

/**
 * TwelveDays
 */
public class TwelveDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12:");
        int startDay = Integer.parseInt(sc.nextLine());

        sc.close();

        switch(startDay) {
            case 12:
                System.out.println("Twelve drummers drumming,");
            case 11:
                System.out.println("Eleven pipers piping,");
            case 10:
                System.out.println("Ten lords a-leaping,");
            case 9:
                System.out.println("Nine ladies dancing,");
            case 8:
                System.out.println("Eight maids a-milking,");
            case 7:
                System.out.println("Seven swans a-swimming,");
            case 6:
                System.out.println("Six geese a-laying,");
            case 5:
                System.out.println("Five gold rings,");
            case 4:
                System.out.println("Four calling birds,");
            case 3:
                System.out.println("Three French hens,");
            case 2:
                System.out.println("Two turtle doves,");
            case 1:
                System.out.println("A partridge in a pair tree.");
        }
    }

}
