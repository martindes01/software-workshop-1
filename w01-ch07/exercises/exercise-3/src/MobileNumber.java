import java.util.Scanner;

/**
 * Mobile Number
 */
public class MobileNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a mobile number:");
        String number = sc.nextLine();

        sc.close();

        int digitCount = 0;

        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                ++digitCount;
            }
        }

        System.out.println("The number of digits is: " + digitCount + '.');
    }

}
