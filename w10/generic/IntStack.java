public interface IntStack {
    boolean push(int e);
    int pop();
    int size();
    int peek();
    void clear();
    
    public default boolean isEmpty() {
        return size() == 0;
    }
}
