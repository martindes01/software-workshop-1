import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * WriteCustomerList
 */
public class WriteCustomerList {

    public static final String outFile = "CustomerList.dat";

    public static void main(String[] args) {

        final String yes = "y";
        final String no = "n";

        ArrayList<Integer> idNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<Integer> debts = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String input;

        do {
            try {
                System.out.println("Enter customer ID:");
                int idNumber = Integer.parseInt(sc.nextLine());

                System.out.println("Enter customer first name:");
                String firstName = sc.nextLine();

                System.out.println("Enter customer last name:");
                String lastName = sc.nextLine();

                System.out.println("Enter customer debt:");
                int debt = Integer.parseInt(sc.nextLine());

                // following statements do not execute if input parsing throws exception
                idNumbers.add(idNumber);
                firstNames.add(firstName);
                lastNames.add(lastName);
                debts.add(debt);
            } catch (Exception e) {
                System.out.println("An input error has occurred.");
                System.out.println("The customer information has not been saved.");
            }

            System.out.println("Would you like to enter another customer? (" + yes + "/" + no + ")");
            input = sc.nextLine();
        } while (input.equalsIgnoreCase(yes));

        sc.close();

        Path outPath = Paths.get(outFile).toAbsolutePath();

        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(outPath.toFile())))) {
            System.out.println("Writing customer list to " + outPath + "...");

            for (int i = 0; i < idNumbers.size(); ++i) {
                out.writeInt(idNumbers.get(i));
                out.writeUTF(firstNames.get(i));
                out.writeUTF(lastNames.get(i));
                out.writeInt(debts.get(i));
            }

            System.out.println("The file has been saved.");
        } catch (FileNotFoundException e) {
            System.out.println("The file " + outPath + " cannot be created or cannot be opened for reading.");
        } catch (Exception e) {
            System.out.println("An output error has occurred.");
            System.out.println("The file has not been saved.");
            e.printStackTrace();
        }

    }

}
