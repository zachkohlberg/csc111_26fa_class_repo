public class SimplePrinter implements Printer {
    // this class must override the print method because we declared that we're implementing
    // the printer interface
    @Override
    public void print(String a) {
        System.out.println(a);
    }
}
