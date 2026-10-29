public class StackTest {
    public static void  main(String[] args) {
        // parse args array assuming all are ints
        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        // show array is in expected order
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // add contents to stack
        // we can use any of our stack implementations here
        // Stack<Integer> stack = new ArrayStack<Integer>(1);
        Stack<Integer> stack = new LinkedStack<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        // overwrite array with stack contents
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = stack.pop();
        }

        // show array is now reversed
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
