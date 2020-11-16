/**
 * UseBook
 */
public class UseBook {

    public static void main(String[] args) {
        Fiction fiction = new Fiction("A Work of Fiction");
        NonFiction nonFiction = new NonFiction("A Work of Fact");

        System.out.println(fiction.getTitle() + ": " + fiction.getPrice());
        System.out.println(nonFiction.getTitle() + ": " + nonFiction.getPrice());
    }

}
