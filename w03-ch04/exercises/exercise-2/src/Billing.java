/**
 * Billing
 */
public class Billing {

    public static final float TAX = 1.08f;

    public static int computeBill(int price) {
        return (int) (price * TAX);
    }

    public static int computeBill(int price, int quantity) {
        return (int) (price * quantity * TAX);
    }

    public static int computeBill(int price, int quantity, int coupon) {
        return (int) ((price * quantity - coupon) * TAX);
    }

    public static void main(String[] args) {
        int price = 500;
        int quantity = 2;
        int coupon = 100;

        System.out.println("The price of a book is " + price + " pence.");

        System.out.println("The total price of a book including tax is " + computeBill(price) + " pence.");

        System.out.println("The total price of " + quantity + " books including tax is " + computeBill(price, quantity)
                + " pence.");

        System.out.println("The total price of " + quantity + " books with a " + coupon
                + " pence coupon including tax is " + computeBill(price, quantity, coupon) + " pence.");
    }

}
