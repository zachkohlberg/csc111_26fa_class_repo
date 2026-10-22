public class IntNodeTest {
    public static void main(String[] args) {
        IntNode head = new IntNode(1, null);
        head.next = new IntNode(2, null);
        head.next.next = new IntNode(3, null);

        System.out.println(" First node value: " + head.value);
        System.out.println("Second node value: " + head.next.value);
        System.out.println(" Third node value: " + head.next.next.value);
    }
}
