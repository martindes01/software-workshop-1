import java.util.Scanner;

/**
 * Baby Names
 */
public class BabyNames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your three favourite baby names:");
        String name1 = sc.next();
        String name2 = sc.next();
        String name3 = sc.next();

        sc.close();

        System.out.println(name1 + ", " + name2 + ", " + name3);
        System.out.println(name1 + ", " + name3 + ", " + name2);
        System.out.println(name2 + ", " + name1 + ", " + name3);
        System.out.println(name2 + ", " + name3 + ", " + name1);
        System.out.println(name3 + ", " + name1 + ", " + name2);
        System.out.println(name3 + ", " + name2 + ", " + name1);
    }

}
