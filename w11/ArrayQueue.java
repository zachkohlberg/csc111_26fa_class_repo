public class ArrayQueue<E> implements Queue<E> {
    // index of the next element we'll dequeue
    private int front;
    // index AFTER the last element in the queue, or the
    // index where the next element will be enqueued
    private int back;

    // we can track size or include an extra array slot to distinguish between
    // full and empty queue (see queue notes)
    private int size;

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
            // store element in array first because back is
            // the first free space in the array
            data[back] = element;

            // now we can safely update back and size
            back = (back + 1) % data.length;
            size += 1;

            // enqueue succeeded
            return true;
        } else {
            // can't enqueue if full
            return false;
        }
    }

    public E dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }

        // save element in a temp variable before removing
        E element = data[front];
        // remove reference from data array
        data[front] = null;

        // update front and size
        front = (front + 1) % data.length;
        size -= 1;

        // return saved element reference
        return element;
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
