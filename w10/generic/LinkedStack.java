public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public boolean push(E element) {
        top = new Node<E>(element, top);
        size += 1;
        return true;
    }

    public E pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        size -= 1;
        E element = top.value;
        top = top.next; 
        return element;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        return top.value;
    }

    public void clear() {
        top = null;
        size = 0;
    }
}
