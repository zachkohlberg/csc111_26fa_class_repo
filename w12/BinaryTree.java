// just some static methods to practice binary tree node operations
public class BinaryTree {
    /*
                 D
                / \
              /     \
            A         C
          /   \         \
        B       F         G
               /
              E
    */

    public static void main(String[] args) {
        BTNode<String> root = new BTNode<>("D");
        root.left = new BTNode<>("A");
        root.right = new BTNode<>("C");
        root.left.left = new BTNode<>("B");
        root.left.right = new BTNode<>("F");
        root.right.right = new BTNode<>("G");
        root.left.right.left = new BTNode<>("E");

        System.out.print("inorder:  ");
        inorder(root);
        System.out.println();

        System.out.println("expected: BAEFDCG");

        // functional programming nonsense, not necessary but very fun
        System.out.print("inorder again: ");
        inorder(root, data -> System.out.print(data + 1));
        System.out.println();
    }

    // preorder means visit root, traverse left, traverse right
    // inorder means traverse left, visit root, traverse right
    // postorder means traverse left, traverse right, visit root
    public static <E> void inorder(BTNode<E> root) {
        if (root != null) {
            // traverse left
            inorder(root.left);
            // visit root
            System.out.print(root.data);
            // traverse right
            inorder(root.right);
        }
    }

    // functional version of inorder, again not necessary but cool
    public static <E> void inorder(BTNode<E> root, java.util.function.Consumer<E> f) {
        if (root != null) {
            inorder(root.left, f);
            f.accept(root.data);
            inorder(root.right, f);
        }
    }
}
