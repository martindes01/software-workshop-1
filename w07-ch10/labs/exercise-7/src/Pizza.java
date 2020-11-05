/**
 * Pizza
 */
public class Pizza {

    private String description;
    private int price;

    public Pizza(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return description + " £" + price / 100 + "." + String.format("%02d", price % 100);
    }
}
