import java.util.Scanner;

/**
 * FullName
 */
public class FullName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String firstName = sc.nextLine();

        System.out.println("Enter your last name:");
        String lastName = sc.nextLine();

        System.out.println(firstName + '\n' + lastName);

        sc.close();
    }

}
