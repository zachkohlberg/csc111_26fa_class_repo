public interface UnorderedIntList {
    int capacity();
    int size();
    boolean add(int element);
    boolean remove(int element);
    boolean contains(int element);
    void clear();
    int[] toArray();
}

/*
UnorderedIntList ADT:
    init(capacity: int) our constructor, not an actual method and not part of the interface, initializes an empty list with the given capacity
    capacity(): int returns the amount of space in the list
    size(): int returns the number of elements stored in the list
    add(element: int): boolean adds element to the list and returns whether it succeeded (adding can fail if the list is full)
    remove(element: int): boolean removes one occurrence of element from the list (element could appear multiple times) and returns whether or not it removed anything
    contains(element: int): boolean returns whether the list contains element
    clear() removes all elements from the list
    toArray(): int[] returns an array with a length equal to the list’s size() containing every element in the list
*/
