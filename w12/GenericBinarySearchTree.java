// one solution to making the tree generic: bounded type parameter:
// public class GenericBinarySearchTree<Element extends Comparable<Element>> {
// further reading: https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
public class GenericBinarySearchTree<Element> {
    private BTNode<Element> root;
    // other solution to making the tree generic: take a comparator function and
    // use it to compare elements
    private Comparator<Element> comp;

    public GenericBinarySearchTree(Comparator<Element> c) {
        comp = c;
    }

    // helper method to handle empty tree case
    public void insert(String data) {
        if (root == null) {
            // make root node
        } else {
            // call recursive insert on root node
        }
    }

    // recursive method to do everything else
    private void insert(BTNode<String> node, String data) {
        // this is the problem we need to solve if the tree is generic: how do we compare
        // elements to determine the proper order?
        // compare element to data
        if (???) {
            // case 1: element goes on left side

            // check if left is empty (null)
            if (???) {
                // left empty, base case: left = new node
            } else {
                // left nonempty, recursive case: call insert on left
            }
        } else {
            // case 2: element goes on right side

            // check if right is empty (null)
            if (???) {
                // right empty, base case: left = new node
            } else {
                // right nonempty, recursive case: call insert on left
            }
        }
    }
}
