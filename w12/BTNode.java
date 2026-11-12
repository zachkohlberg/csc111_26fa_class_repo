// TODO: generic binary tree node class
// one generic type parameter
// two child pointers
// no getters/setters needed
// constructor nice but optional

public class BTNode<Element> {
    // variables
    public Element data;
    public BTNode<Element> left, right;

    // constructor
    public BTNode(Element d) {
        data = d;
    }
}
