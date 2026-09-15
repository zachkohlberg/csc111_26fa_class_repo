import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteFile {
    public static void main(String[] args) {
        File file = new File("HelloWorld.txt");

        // newer and better try with resources pattern
        // oracle tutorial on that pattern for java 8: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Hello World");
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open HelloWorld.txt");
        }

/*
        //the old way
        try {
            PrintWriter writer = new PrintWriter(file);

            writer.println("Hello World");

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't open HelloWorld.txt");
        }
*/
    }
}
