/*

how do we design loops?

    where does the loop start?
        for loop's init starts a counter (i) at 1
    how does the loop make progress?
        print a number
        increment the counter
    how does the loop end?
        when counter exceeds 10
    what if loop doesn’t end?
        infinite loop!

how do we design recursive functions?

    where does the function start?
        whatever starting value we get from our parameter(s): 1
    how does the function make progress?
        print the starting number
        pass a larger starting number to the recursive call
    how does the function end?
        when it reaches the base case
    what if function doesn’t end?
        stack overflow
*/

public class Recursion {
    public static void main(String[] args) {
        countIter(1, 10);
        countRec(1, 10);
    }

    public static void countIter(int from, int to) {
        for (int i = from; true; i++) {
            System.out.println(i);
        }
    }

    public static void countRec(int from, int to) {
        if (from <= to) {
            // recursive case
            System.out.println(from);
            // recursive call happens in the recursive case
            countRec(from + 1, to);
        } else {
            // base case
            // do nothing! (we could just leave out the else)
        }
    }
}
