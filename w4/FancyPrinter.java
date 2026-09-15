public class FancyPrinter implements Printer {
    @Override
    public void print(String s) {
        // this prints the string with a border around it:
        // ###############
        // # Hello World #
        // ###############

        String border = "#".repeat(s.length() + 4);

        System.out.println(border);

        System.out.print("# ");
        System.out.print(s);
        System.out.println(" #");

        System.out.println(border);
    }
}
