public class BinarySearchTree {
    private BTNode<String> root;

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
