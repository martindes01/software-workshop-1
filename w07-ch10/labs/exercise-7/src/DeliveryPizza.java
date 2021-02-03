/**
 * DeliveryPizza
 */
public class DeliveryPizza extends Pizza {

    private int deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String description, int price, String deliveryAddress) {
        super(description, price);
        deliveryFee = (price > 1500) ? 300 : 500;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return super.toString() + " plus £" + deliveryFee / 100 + "." + String.format("%02d", deliveryFee % 100)
                + " delivery to " + deliveryAddress;
    }

}
