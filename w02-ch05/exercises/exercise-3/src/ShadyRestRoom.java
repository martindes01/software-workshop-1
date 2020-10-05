import java.util.Scanner;

/**
 * ShadyRestRoom
 */
public class ShadyRestRoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose 1 for a queen bed.");
        System.out.println("Choose 2 for a king bed.");
        System.out.println("Choose 3 for a king bed and a pullout couch.");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();

        sc.close();

        int price = 0;

        switch (choice) {
            case 1:
                price = 125;
                System.out.println("You chose a queen bed.");
                break;
            case 2:
                price = 139;
                System.out.println("You chose a king bed.");
                break;
            case 3:
                price = 165;
                System.out.println("You chose a king bed and a pullout couch.");
                break;
            default:
                price = 0;
                System.err.println("You chose and invalid option.");
                break;
        }

        System.out.println("This costs $" + price + ".");
    }

}
