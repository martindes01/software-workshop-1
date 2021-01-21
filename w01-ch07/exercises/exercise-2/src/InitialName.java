import java.util.Scanner;

/**
 * Initial Name
 */
public class InitialName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = sc.nextLine();

        System.out.println("Enter your last name:");
        String lastName = sc.nextLine();

        System.out.println(firstName.charAt(0) + ". " + lastName);

        sc.close();
    }

}
