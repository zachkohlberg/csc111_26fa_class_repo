public class SortedIntArrayList implements UnorderedIntList {
    // all of this is exactly the same as the unsorted list

    private int[] data;
    private int size;

    public SortedIntArrayList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return size;
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

    // the add, remove, and contains method are the only changes

    public boolean add(int element) {
        if (size() >= capacity()) {
            return false;
        }

        // start at the end of the list
        int i = size();
        // shift elements over to make room until we find the correct place for
        // our new element
        while (i > 0 && data[i - 1] > element) {
            data[i] = data[i - 1];

            // we're moving from the end of the list (size) to the start (0), so
            // we decrement i
            i -= 1;
        }

        data[i] = element;
        size += 1;
        return true;
    }

    public boolean remove(int element) {
        // uses a binary search to locate the element we want to remove
        int index = indexOf(element);

        // can't remove it if it doesn't exist
        if (index == -1) {
            return false;
        }

        size -= 1;

        // shift everything after the removed element one space to the left
        for (int i = index; i < size(); i++) {
            data[i] = data[i + 1];
        }

        return true;
    }

    public boolean contains(int element) {
        // uses a binary search to locate the element
        int index = indexOf(element);

        return index != -1;
    }

    // binary search
    private int indexOf(int element) {
        // lower bound, inclusive
        int min = 0;
        // upper bound, inclusive
        int max = size - 1;

        // same condition as our guessing game because the bounds are inclusive
        while (min < max) {
            int mid = (min + max) / 2;

            if (data[mid] < element) {
                min = mid + 1;
            } else {
                max = mid;
            }

            // this will not work, try a few examples to see the issue
            /*
            if (element < data[mid]) {
                max = mid - 1;
            } else {
                min = mid;
            }
            */
        }

        // min and max are the same at this point, so we can use either as the
        // element's index
        //
        // we need to check for equality because it's possible that the element
        // doesn't exist (we've just found where it should be if it does exist)

        if (data[min] == element) {
            return min;
        } else {
            return -1;
        }
    }
}

