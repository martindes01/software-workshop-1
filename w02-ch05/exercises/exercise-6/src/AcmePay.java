import java.util.Scanner;

/**
 * AcmePay
 */
public class AcmePay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many hours do you work?");
        int hours = Integer.parseInt(sc.nextLine());

        System.out.println("Which shift do you work?");
        int shift = Integer.parseInt(sc.nextLine());

        boolean retirement = false;
        if ((shift == 2) || (shift == 3)) {
            System.out.println("Would you like to opt in for the retirement plan?");
            retirement = Boolean.parseBoolean(sc.nextLine());
        }

        System.out.println("You work " + hours + " hours.");
        System.out.println("You work shift " + shift + ".");

        int hourlyCents = 0;
        switch (shift) {
            case 1:
                hourlyCents = 1700;
                break;
            case 2:
                hourlyCents = 1850;
                break;
            case 3:
                hourlyCents = 2200;
                break;
            default:
                System.out.println("This is not a valid shift.");
                break;
        }
        System.out.println("You earn $" + hourlyCents / 100 + " and " + hourlyCents % 100 + " cents per hour.");

        System.out.println();

        int regularCents = hourlyCents * Math.min(hours, 40);
        System.out.println("Your regular pay is $" + regularCents / 100 + " and " + regularCents % 100 + " cents.");

        int overtimeCents = hourlyCents * Math.max(hours - 40, 0);
        System.out.println("Your overtime pay is $" + overtimeCents / 100 + " and " + overtimeCents % 100 + " cents.");

        int totalCents = regularCents + overtimeCents;
        System.out.println("Your total pay is $" + totalCents / 100 + " and " + totalCents % 100 + " cents.");

        int retirementCents = 0;
        int netCents = totalCents;

        if (retirement) {
            retirementCents = (int) (totalCents * 0.03);
            netCents -= retirementCents;

            System.out.println();
            System.out.println("You have opted in for the retirement plan.");
            System.out.println("Your retirement reduction is $" + retirementCents / 100 + " and "
                    + retirementCents % 100 + " cents.");
            System.out.println("Your net pay is $" + netCents / 100 + " and " + netCents % 100 + " cents.");
        }

        sc.close();
    }

}
