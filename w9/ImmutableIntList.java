public class ImmutableIntList {
    public static final ImmutableIntList EMPTY = null;

    public final int head;
    public final ImmutableIntList tail;
    
    public ImmutableIntList(int h) {
        head = h;
        tail = null;
    }

    public ImmutableIntList(int h, ImmutableIntList t) {
        head = h;
        tail = t;
    }

    // adding cannot modify the existing list because it's immutable
    // we instead return a new list with the new element as head
    public ImmutableIntList add(int element) {
        return new ImmutableIntList(element, this);
    }

    // removing first element is easy
    // same constraint about not modifying the list
    public ImmutableIntList removeFirst() {
        return tail;
    }

    public int get(int index) {
        // base case: element at index 0 is head
        if (index == 0) {
            return head;
        }

        // base case: element at index != 0 and tail == EMPTY throws
        // IndexOutOfBoundsException
        // if index is zero we'd return earlier, so we don't have to check here
        if (tail == EMPTY) {
            throw new IndexOutOfBoundsException();
        }

        // recursive case: index > 0 and tail != EMPTY
        // returns an element from tail at index - 1
        return tail.get(index - 1);
    }

    public int last() {
        // base case: tail == EMPTY, then head is the last element
        if (tail == EMPTY) {
            return head;
        }

        // recursive case: tail != EMPTY, then return tail's last element
        return tail.last();

        // alternative way to write this:
        // return tail == EMPTY ? head : tail.last();
    }

    public int size() {
        // base case: tail == EMPTY, then size is 1
        if (tail == EMPTY) {
            return 1;
        }

        // recursive case: tail != EMPTY, then size is tail's size + 1
        return tail.size() + 1;
    }

    public int indexOf(int element) {
        // TODO: try this one yourself
        return -1; // temp return
    }

    public String toString() {
        // base case: tail == EMPTY, then convert head to string
        if (tail == EMPTY) {
            return String.valueOf(head);
        }

        // recursive case: tail != EMPTY, then concat head with tail.toString
        return head + ", " + tail.toString();
    }

    public static void main(String[] args) {
        ImmutableIntList list = new ImmutableIntList(10);
        list = list.add(8);
        list = list.add(6);
        list = list.add(4);
        list = list.add(2);

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }
        System.out.println("list.size() = " + list.size());
        System.out.println("list.last() = " + list.last());
    }
}
