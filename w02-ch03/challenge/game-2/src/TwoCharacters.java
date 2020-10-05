/**
 * TwoCharacters
 */
public class TwoCharacters {

    public static void main(String[] args) {
        MyCharacter alice = new MyCharacter("Alice", 100, 50);
        MyCharacter bob = new MyCharacter("Bob", 100, 50);

        displayCharacter(alice);
        displayCharacter(bob);
    }

    public static void displayCharacter(MyCharacter character) {
        System.out.println(character.getName() + " has " + character.getHealth() + " health and "
                + character.getAttack() + " attack.");
    }

}
