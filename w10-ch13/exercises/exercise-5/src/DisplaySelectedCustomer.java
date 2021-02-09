import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * DisplaySelectedCustomer
 */
public class DisplaySelectedCustomer {

    public static void main(String[] args) {

        Integer queryIDNumber = null;

        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("Enter customer ID:");
                queryIDNumber = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("An input error has occurred.");
                System.out.println("Please try again.");
            }
        } while (queryIDNumber == null);

        sc.close();

        ArrayList<Integer> idNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<Integer> debts = new ArrayList<>();

        Path inPath = Paths.get(WriteCustomerList.outFile).toAbsolutePath();

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(inPath.toFile())))) {
            System.out.println("Reading customer list from " + inPath + "...");

            while (true) {
                int idNumber = in.readInt();
                String firstName = in.readUTF();
                String lastName = in.readUTF();
                int debt = in.readInt();

                // following statements do not execute if input reading throws exception
                idNumbers.add(idNumber);
                firstNames.add(firstName);
                lastNames.add(lastName);
                debts.add(debt);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + inPath + " does not exist or cannot be opened for reading.");
        } catch (EOFException e) {
            // thrown when input stream reaches end of file
        } catch (Exception e) {
            System.out.println("An input error has occurred.");
            e.printStackTrace();
        }

        int resultIndex = idNumbers.indexOf(queryIDNumber);

        if (resultIndex >= 0) {
            System.out.format("Customer %d (%s %s) owes £%01d%n", queryIDNumber, firstNames.get(resultIndex),
                    lastNames.get(resultIndex), debts.get(resultIndex));
        } else {
            System.out.println("The customer ID " + queryIDNumber + " cannot be found.");
        }

    }

}
