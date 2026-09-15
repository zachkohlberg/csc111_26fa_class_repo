public class InterfaceExample {
    public static void main(String[] args) {
        // no polymorphism
        // SimplePrinter printer = new SimplePrinter();

        // the interface can be a type
        // variables with the interface type can hold objects of any class that
        // implement the interface
        // the ability to store different concrete types in this variable at
        // runtime is called "runtime polymorphism" and is one of the main
        // benefits of implementing an interface
        Printer printer = new FancyPrinter();
        
        printer.print("Hello World");
    }
}
