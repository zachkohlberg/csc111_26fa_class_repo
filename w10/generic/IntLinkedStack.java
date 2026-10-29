public class IntLinkedStack implements IntStack {
    private IntNode top;
    private int size;

    public IntLinkedStack() {
        top = null;
        size = 0;
    }

    public boolean push(int element) {
        top = new IntNode(element, top);
        size += 1;
        return true;
    }

    public int pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        size -= 1;
        int element = top.value;
        top = top.next; 
        return element;
    }

    public int size() {
        return size;
    }

    public int peek() {
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
