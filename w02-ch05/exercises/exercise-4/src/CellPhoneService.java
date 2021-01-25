import java.util.Scanner;

/**
 * CellPhoneService
 */
public class CellPhoneService {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many talk minutes do you use per month?");
        int minutes = Integer.parseInt(sc.nextLine());

        System.out.println("How many text messages do you send per month?");
        int texts = Integer.parseInt(sc.nextLine());

        System.out.println("How many gigabytes of data do you use per month?");
        int gigabytes = Integer.parseInt(sc.nextLine());

        sc.close();

        if (gigabytes <= 0) {
            if (minutes < 500) {
                if (texts <= 0) {
                    System.out.println(
                            "You should select Plan A for up to 500 minutes, no texts and no data at $49 per month.");
                } else {
                    System.out.println(
                            "You should select Plan B for up to 500 minutes, unlimited texts and no data at $55 per month.");
                }
            } else {
                if (texts < 100) {
                    System.out.println(
                            "You should select Plan C for 'unlimited minutes', up to 100 texts and no data at $61 per month.");
                } else {
                    System.out.println(
                            "You should select Plan D for 'unlimited minutes', unlimited texts and no data at $70 per month.");
                }
            }
        } else if (gigabytes < 3) {
            System.out.println("You should select Plan E for up to 3 gigabytes at $79 per month.");
        } else {
            System.out.println("You should select Plan F for 3 gigabytes or more at $87 per month.");
        }
    }

}
