public interface List<E> {
    void insert(int index, E element);
    E get(int index);
    E removeAt(int index);
    int size();
    void add(E element);
    boolean remove(E element);
    int indexOf(E element);
    void clear();
    boolean isEmpty();
}
