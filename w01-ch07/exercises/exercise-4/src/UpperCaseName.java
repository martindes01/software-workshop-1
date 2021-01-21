import java.util.Scanner;

/**
 * UpperCaseName
 */
public class UpperCaseName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String fullName = sc.nextLine();

        sc.close();

        System.out.println(fullName.toUpperCase());
    }

}
