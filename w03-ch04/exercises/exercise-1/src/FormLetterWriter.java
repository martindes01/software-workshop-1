/**
 * FormLetterWriter
 */
public class FormLetterWriter {

    public static void displaySalutation(String lastName) {
        System.out.println("Dear Mr. or Ms. " + lastName);
        shortBody();
    }

    public static void displaySalutation(String firstName, String lastName) {
        System.out.println("Dear " + firstName + " " + lastName);
        shortBody();
    }

    private static void shortBody() {
        System.out.println("Thank you for your recent order.");
    }

    public static void main(String[] args) {
        FormLetterWriter.displaySalutation("Bloggs");
        FormLetterWriter.displaySalutation("Joe", "Bloggs");
    }

}
