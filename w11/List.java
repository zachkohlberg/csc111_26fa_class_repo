public interface List<E> {
    void insert(int index, E element);
    E get(int index);
    E removeAt(int index);
    int size();
    int indexOf(E element);

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
