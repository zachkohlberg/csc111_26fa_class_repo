public class LinkedList<E> implements List<E> {
    private int size;
    private Node<E> head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    public void insert(int index, E element) {
        // insert can allow size because that's an acceptable
        // place to add a new element
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        size += 1;

        if (index == 0) {
            // special case: inserting at the beginning of the list
            head = new Node<>(element, head);
        } else {
            // traverse to the node at INDEX-1
            Node<E> n = head;
            for (int i = 1; i < index; i++) {
                n = n.next;
            }

            // add the new element after this one
            n.next = new Node<>(element, n.next);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> n = head;
        // traverse to the node at INDEX
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.value;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        size -= 1;
        E element;

        if (index == 0) {
            // save the node's element
            element = head.value;
            // special case: removing first node
            head = head.next;
        } else {
            // traverse to the node at INDEX-1
            Node<E> n = head;
            for (int i = 1; i < index; i++) {
                n = n.next;
            }
            // save the node's element
            element = n.value;

            // skip over the next node
            n.next = n.next.next;
        }

        // return the element we just removed
        return element;
    }

    public int size() {
        return size;
    }

    // TODO: something to implement for homework
}
