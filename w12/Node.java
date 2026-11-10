public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T v, Node<T> n) {
        value = v;
        next = n;
    }
}
