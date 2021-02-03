/**
 * DemoPizzas
 */
public class DemoPizzas {

    public static void main(String[] args) {
        Pizza p1 = new Pizza("Pepperoni", 1600);
        Pizza p2 = new Pizza("Ham and Pineapple", 1400);
        DeliveryPizza dp1 = new DeliveryPizza("Pepperoni", 1600, "Home");
        DeliveryPizza dp2 = new DeliveryPizza("Ham and Pineapple", 1400, "Work");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(dp1);
        System.out.println(dp2);
    }

}
