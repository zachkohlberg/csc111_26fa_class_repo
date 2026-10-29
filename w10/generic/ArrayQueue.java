public class ArrayQueue<E> implements Queue<E> {
    // we can track size or include an extra array slot to distinguish between
    // full and empty queue (see queue notes)
    private int front, back, size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        front = 0;
        back = 0;
        size = 0;
        data = (E[]) new Object[capacity];
    }

    public boolean enqueue(E element) {
        if (size < data.length) {
        } else {
        }
    }

    public E dequeue() {
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }

        return data[front];
    }

    public void clear() {
        // we could be smarter and skip the parts that are already null
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    }
}
