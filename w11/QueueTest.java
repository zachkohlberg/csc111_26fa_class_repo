public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<>(5);
        // uncomment below to switch to linked queue
        // Queue<String> queue = new LinkedQueue<>();
        // enqueue every arg
        // linked queue should never fail, whereas array queue will fail after the fifth arg
        for (String arg : args) {
            boolean success = queue.enqueue(arg);
            System.out.printf("enqueue(%s) -> %s\n", arg, success);
        }

        // dequeue and print every arg to show what was enqueued and demonstrate FIFO
        while (!queue.isEmpty()) {
            String element = queue.dequeue();
            System.out.printf("dequeued %s\n", element);
        }
    }
}
