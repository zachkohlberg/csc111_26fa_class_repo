import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {

        String fname = "file1.txt";

        if (args.length >= 1) {
            fname = args[0];
        }

        File file = new File(fname);

        // nicer "try with resources" pattern
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(fname + " not found!");
        }

/*
        try {
            // code to try running that may throw an exception
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            // code to execute if a FNF exception is thrown
            System.out.println("file1.txt not found!");
        }
*/

    }
}
