public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        // an example of why we get a warning when casting Object[] to E[]
        // Object[] temp = new Object[capacity];
        // temp[0] = "hello";
        // temp[1] = 5;
        // data = (E[])temp;

        data = (E[])new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size < data.length) {
            return;
        }

        E[] newData = (E[])new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean push(E element) {
        ensureCapacity();

        data[size] = element;
        size += 1;
        return true;
    }

    public E pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        // the int stack was fine with leaving old elements in the array because
        // they're primitives and don't affect the garbage collector
        //
        // the generic stack is working with references, and keeping an unneeded
        // reference in our array will stop that object from getting deleted by
        // the garbage collector
        size -= 1;
        E element = data[size];
        data[size] = null;
        return element;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        return data[size - 1];
    }

    public void clear() {
        // we don't want to keep the references (see earlier comment)
        // option 1: make clear linear and null everything in the array
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
        // option 2: make a new array, which adds work to the GC
        // also, this won't work as written (see above examples with new arrays)
        // data = new E[data.length];
    }
}
