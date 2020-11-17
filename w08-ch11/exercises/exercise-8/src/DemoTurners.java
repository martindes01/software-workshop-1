/**
 * DemoTurners
 */
public class DemoTurners {

    public static void main(String[] args) {
        Turner leaf = new Leaf();
        Turner page = new Page();
        Turner pancake = new Pancake();

        System.out.println("Leaf:");
        leaf.turn();

        System.out.println("Page:");
        page.turn();

        System.out.println("Pancake:");
        pancake.turn();
    }

}
