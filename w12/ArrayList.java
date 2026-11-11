public class ArrayList<E> implements List<E> {
    // we could implement a circular arraylist like our circular arrayqueue,
    // but this would significantly complicate the code in exchange for a
    // constant time add to front and back
    private int size;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        size = 0;
        data = (E[]) (new Object[capacity]);
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("index %d out of bounds for size %d", index, size));
        }

        return data[index];
    }

    public void insert(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format("index %d out of bounds for size %d", index, size));
        }

        ensureCapacity();

        // shift elements to the right to make room
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size += 1;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("index %d out of bounds for size %d", index, size));
        }

        // we're not shrinking the list when most of the capacity is unused,
        // but that is something we could include if we were worried about
        // holding too much memory in our data array

        E element = data[index];

        size -= 1;
        // shift elements over, replacing whatever we delete and preserving the
        // order of the remaining elements
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;

        return element;
    }

    public int indexOf(E element) {
        // TODO: search data for the element
        return -1;
    }

    // just stole our array stack's implementation
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size < data.length) {
            return;
        }

        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // TODO: implement a better version of the following defaults we inherited:
    // - clear (default in O(n^2), terrible!)
    // - remove (default isn't bad, but this is still interesting to implement)
}
