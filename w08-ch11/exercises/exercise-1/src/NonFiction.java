/**
 * NonFiction
 */
public class NonFiction extends Book {

    public NonFiction(String title) {
        super(title);
        setPrice();
    }

    @Override
    void setPrice() {
        price = 37.99;
    }

}
