public class Tree<E> {
    // children/subtrees
    // - can be an array that we manage
    // - can be a list that manages its own memory
    Tree<E>[] children;

    // how many children at this level
    // necessary if we're managing the array ourselves
    int size;

    // this will hold a reversi and evaluation later, but for now it's generic
    E data;
    
    // addChild
    // getChild
    // getters for size and data
    // setter for data

    // print/display method is useful for debugging
    // print:
    //   display this tree's data
    //   for each subtree
    //     recursively display the subtree with greater indentation or something
}

