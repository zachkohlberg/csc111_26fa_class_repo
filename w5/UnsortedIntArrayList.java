public class UnsortedIntArrayList implements UnorderedIntList {
    private int[] data;
    private int size;
    // capacity is data.length, so it doesn't get its own variable

    public UnsortedIntArrayList(int capacity) {
        // make an array that can store capacity integers
        data = new int[capacity];
        // list starts empty
        size = 0;
    }

    // how much space the list has reserved for its elements
    public int capacity() {
        return data.length;
    }

    // how many elements the list currently has
    public int size() {
        return size;
    }

    public boolean add(int element) {
        if (size() < capacity()) {
            // add succeeds
            data[size] = element;
            size += 1;

            // you may see people do this to make the add more concise, but as
            // discussed in class I don't recommend it:
            // data[size++] = element;

            // true means the add succeeded
            return true;
        } else {
            // add fails
            return false;
        }
    }

    public boolean remove(int element) {
        // important to loop from 0 to size, not capacity/data.length
        // we only want to check the portion of the array we're using, not the
        // garbage data in the unused portion after the list's elements
        for (int i = 0; i < size(); i++) {
            if (data[i] == element) {
                // found the element, so we remove it

                size -= 1;
                data[i] = data[size];

                // true indicates we succeeded in removing something
                // returning prevents us from searching more of the array (pointless)
                // and removing additional copies (incorrect behavior)
                return true;
            }
        }

        // if we reach the end of the loop and get here, then we didn't remove
        // anything and should return false to indicate the remove failed
        return false;
    }

    public boolean contains(int element) {
        // this is exactly the same as remove, but we left out the remove part
        for (int i = 0; i < size(); i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        size = 0;
    }

    public int[] toArray() {
        int[] array = new int[size()];

        for (int i = 0; i < size(); i++) {
            array[i] = data[i];
        }

        return array;
    }
}

/*
    init(capacity: int) our constructor, not an actual method and not part of
        the interface, initializes an empty list with the given capacity
    capacity(): int returns the amount of space in the list
    size(): int returns the number of elements stored in the list
    add(element: int): boolean adds element to the list and returns whether it
        succeeded (adding can fail if the list is full)
    remove(element: int): boolean removes one occurrence of element from the
        list (element could appear multiple times) and returns whether or not it
        removed anything
    contains(element: int): boolean returns whether the list contains element
    clear() removes all elements from the list
    toArray(): int[] returns an array with a length equal to the list’s size()
        containing every element in the list
*/
