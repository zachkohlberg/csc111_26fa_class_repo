public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;

    // private Node<E> back;

    private int size;

    public LinkedQueue() {
        front = null;
        // TODO: init back
        size = 0;
    }

    public boolean enqueue(E element) {
        // special case: empty queue
        if (isEmpty()) {
            front = new Node<>(element, null);
            // TODO: back needs to point to the node as well
            size += 1;
            return true;
        }

        // TODO: if we have a back variable, then this whole
        // traversal is pointless!
        // first we need to find the last node
        // start at front
        Node<E> n = front;
        // if node points to something, we're not at the end
        while (n.next != null) {
            // move to next node in the chain
            n = n.next;
        }
        // NOTE: above assumes the chain isn't circular
        // also, this is a linear operation

        // TODO: use back instead of n
        // TODO: update back to point to the new last node
        // add the node after the last node in the chain
        n.next = new Node<>(element, null);
        size += 1;

        // can't fail because nodes can be added dynamically,
        // unless the JVM runs out of memory
        return true;
    }

    public E dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }

        // store element in temp variable
        E element = front.value;

        // TODO: remove front node
        front = ?;
        // update size
        size -= 1;

        // TODO: special case: null back if we just removed the last node
        // ^^^^--this one is a few lines of code

        return element;
    }

    public E peek() {
        if (size == 0) {
            throw new java.util.NoSuchElementException();
        }

        return front.value;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        // TODO: null front as well
        size = 0;
    }
}
