// show that our generic type isn't limited to ints
public class StackTest2 {
    public static void  main(String[] args) {
        // show array is in expected order
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();

        // add contents to stack
        // we can use any of our stack implementations here
        Stack<String> stack = new ArrayStack<String>(1);
        // Stack<String> stack = new LinkedStack<String>();
        for (int i = 0; i < args.length; i++) {
            stack.push(args[i]);
        }

        // overwrite array with stack contents
        for (int i = 0; i < args.length; i++) {
            args[i] = stack.pop();
        }

        // show array is now reversed
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}
