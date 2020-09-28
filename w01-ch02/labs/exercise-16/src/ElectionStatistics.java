import java.util.Scanner;

/**
 * The ElectionStatistics class calculates election results.
 */
public class ElectionStatistics {

    public static void main(String[] args) {
        final int PERCENTILES = 100;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the first party:");
        String firstParty = sc.nextLine();
        System.out.println("Enter the total votes " + firstParty + " received:");
        int firstPartyVotes = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name of the second party:");
        String secondParty = sc.nextLine();
        System.out.println("Enter the total votes " + secondParty + " received:");
        int secondPartyVotes = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name of the third party:");
        String thirdParty = sc.nextLine();
        System.out.println("Enter the total votes " + thirdParty + " received:");
        int thirdPartyVotes = sc.nextInt();
        sc.nextLine();

        sc.close();

        int totalVotes = firstPartyVotes + secondPartyVotes + thirdPartyVotes;
        float firstPartyProportion = (float) firstPartyVotes / totalVotes;
        float secondPartyProportion = (float) secondPartyVotes / totalVotes;
        float thirdPartyProportion = (float) thirdPartyVotes / totalVotes;

        System.out.println(firstParty + " received " + firstPartyProportion * PERCENTILES + "% of the votes.");
        System.out.println(secondParty + " received " + secondPartyProportion * PERCENTILES + "% of the votes.");
        System.out.println(thirdParty + " received " + thirdPartyProportion * PERCENTILES + "% of the votes.");
    }
}
