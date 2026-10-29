public interface Queue<E> {
    boolean enqueue(E e);
    E dequeue();
    int size();
    E peek();
    void clear();

    public default boolean isEmpty() {
        return size() == 0;
    }
}
