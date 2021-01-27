/**
 * NineInts
 */
public class NineInts {

    public static void main(String[] args) {
        int[] ints = new int[9];

        for (int i = 0; i < ints.length; ++i) {
            ints[i] = i * i;
            System.out.println(ints[i]);
        }

        for (int i = ints.length - 1; i >= 0; --i) {
            System.out.println(ints[i]);
        }
    }

}
