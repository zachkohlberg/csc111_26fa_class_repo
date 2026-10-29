public interface Stack<E> {
    boolean push(E e);
    E pop();
    int size();
    E peek();
    void clear();
    
    public default boolean isEmpty() {
        return size() == 0;
    }
}
