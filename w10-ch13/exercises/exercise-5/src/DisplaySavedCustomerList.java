import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * DisplaySavedCustomerList
 */
public class DisplaySavedCustomerList {

    public static void main(String[] args) {

        Path inPath = Paths.get(WriteCustomerList.outFile).toAbsolutePath();

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(inPath.toFile())))) {
            System.out.println("Reading customer list from " + inPath + "...");

            while (true) {
                int idNumber = in.readInt();
                String firstName = in.readUTF();
                String lastName = in.readUTF();
                int debt = in.readInt();

                System.out.format("Customer %d (%s %s) owes £%01d.%n", idNumber, firstName, lastName, debt);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + inPath + " does not exist or cannot be opened for reading.");
        } catch (EOFException e) {
            // thrown when input stream reaches end of file
        } catch (Exception e) {
            System.out.println("An input error has occurred.");
            e.printStackTrace();
        }

    }

}
