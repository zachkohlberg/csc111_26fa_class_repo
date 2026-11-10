import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();

        for (String arg : args) {
            list.add(arg);
        }

        Scanner stdin = new Scanner(System.in);

        // switch expression: https://docs.oracle.com/en/java/javase/17/language/switch-expressions-and-statements.html

        while (true) {
            String cmd = stdin.nextLine();
            String[] parts = cmd.split(" ");
            switch (parts[0].toLowerCase()) {
                case "add", "a" -> list.add(parts[1]);
                case "insert", "i" -> list.insert(Integer.parseInt(parts[1]), parts[2]);
                case "removeAt", "ra" -> list.removeAt(Integer.parseInt(parts[1]));
                case "remove", "r" -> list.remove(parts[1]);
                case "get", "g" -> System.out.println(list.get(Integer.parseInt(parts[1])));
                case "size", "s" -> System.out.println(list.size());
                case "print", "p" -> {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                }
                case "quit", "q" -> System.exit(0);
            };
        }
    }
}
