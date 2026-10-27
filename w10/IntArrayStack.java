public class IntArrayStack implements IntStack {
    private int[] data;
    private int size;

    // regarding question: can issues come up with constructors
    // that accept an array parameter and expect it to stay private?
    public IntArrayStack(int[] items) {
        // dangerous if we're relying on encapsulation
        // because we don't know who else has this reference
        // data = items;

        // better option: copy the array
        data = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            data[i] = items[i];
        }
        // could also use java.util.Arrays.copyOf(...)
        size = items.length;
    }

    public IntArrayStack(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // original without growable array
    /*
    public boolean push(int element) {
        if (size < data.length) {
            data[size] = element;
            size += 1;
            return true;
        } else {
            return false;
        }
    }
    */

    // guarantee we have enough room for one more element
    private void ensureCapacity() {
        // we have enough capacity to add something
        if (size < data.length) {
            return;
        }

        // we need more space, so double the array size
        // we could also do this with java.util.Arrays.copyOf(...)
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;

        // note: we're assuming the capacity is at least 1,
        // which we haven't gone to the trouble of guaranteeing
    }

    public boolean push(int element) {
        ensureCapacity();

        data[size] = element;
        size += 1;
        return true;
    }

    public int pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        size -= 1;
        return data[size];
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        return data[size - 1];
    }

    public void clear() {
        size = 0;
    }
}
