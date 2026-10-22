public class IntArrayStack {
    private int[] data;
    private int size;

    public IntArrayStack(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean push(int element) {
        if (size < data.length) {
            data[size] = element;
            size += 1;
            return true;
        } else {
            return false;
        }
    }

    public int pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }

        size -= 1;
        return data[size];
    }
}
