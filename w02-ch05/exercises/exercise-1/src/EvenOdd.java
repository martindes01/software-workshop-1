import java.util.Scanner;

/**
 * EvenOdd
 */
public class EvenOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = sc.nextInt();

        sc.close();

        System.out.println("The number " + number + " is " + ((number % 2 == 0) ? "even" : "odd") + ".");
    }

}
