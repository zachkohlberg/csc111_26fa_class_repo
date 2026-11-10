public interface List<E> {
    void insert(int index, E element);
    E get(int index);
    E removeAt(int index);
    int size();

    default int indexOf(E element) {
        // this is a very bad default for a linked list because it's O(n) calls to get,
        // which itself is an O(n) operation
        for (int i = 0; i < size(); i++) {
            // this will cause an exception if the list contains a null element
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    default void clear() {
        while (!isEmpty()) {
            removeAt(0);
        }
    }

    default boolean remove(E element) {
        int index = indexOf(element);
        if (index < 0) {
            return false;
        }

        removeAt(index);
        return true;
    }

    default void add(E element) {
        insert(size(), element);
    }

    default boolean isEmpty() {
        return size() == 0;
    }
}
