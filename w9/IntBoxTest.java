public class IntBoxTest {
    public static void main(String[] args) {
        IntBox x = new IntBox(5);

        // shallow copy of x
        // IntBox y = x;

        // deep copy of x
        // IntBox y = new IntBox(x.value);

        // deep copy of x using the clone method we wrote
        IntBox y = x.clone();

        System.out.printf("x = %d\n", x.value);
        System.out.printf("y = %d\n", y.value);
        // shallow comparison
        System.out.printf("(x == y) = %s\n", x == y);
        // deep comparison, but ONLY IF IntBox defines its own equals method that
        // performs a deep comparison
        System.out.printf("(x.equals(y)) = %s\n", x.equals(y));

        x.value = 10;

        System.out.printf("x = %d\n", x.value);
        System.out.printf("y = %d\n", y.value);
    }
}
