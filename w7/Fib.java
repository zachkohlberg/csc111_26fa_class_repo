import java.math.BigInteger;

public class Fib {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);

        // time the whole sequence
        long start = System.nanoTime();

        for (int n = 1; n <= count; n++) {
            long startN = System.nanoTime();
            BigInteger fibN = fibRecBigNicer(n);
            long endN = System.nanoTime();
            System.out.printf("fib(%d) = %d (took %d ns)\n", n, fibN, endN - startN);
        }

        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.printf(
                "Took %d nanoseconds to calculate the first %d fibonacci numbers.\n",
                elapsed, count);
    }

    // piecewise function
    //
    // fib(n) = { fib(n-1) + fib(n-2)       if n > 2
    //          { 1                         if n <= 2
    //
    // naive implementation just translates piecewise function
    // into a recursive method, but this is VERY slow
    //
    // if it took 2s for fib(49) and 1s for fib(48), then
    // fib(50) will take 3s
    // fib(51) will take 5s
    // fib(52) will take 8s
    public static long fib(int n) {
        if (n > 2) {
            return fib(n - 1) + fib(n - 2);
        } else {
            return 1;
        }
    }

    // iterative version works like we would do it:
    // start with 1 (prev) and 1 (curr)
    // add the current and previous numbers to get the next number
    // previous number is replaced with current number
    // current number is replaced with next number
    public static long fibIter(int n) {
        long fPrev = 1;
        long fCurr = 1;
        for (int i = 3; i <= n; i++) {
            long fNext = fPrev + fCurr;
            fPrev = fCurr;
            fCurr = fNext;
        }
        return fCurr;
    }

    public static BigInteger fibIterBig(int n) {
        BigInteger fPrev = BigInteger.ONE;
        BigInteger fCurr = BigInteger.ONE;
        for (int i = 3; i <= n; i++) {
            BigInteger fNext = fPrev.add(fCurr);
            fPrev = fCurr;
            fCurr = fNext;
        }
        return fCurr;
    }

    public static BigInteger fibRecBigNicer(int n) {
        return fibRecBig(3, n, BigInteger.ONE, BigInteger.ONE);
    }

    public static BigInteger fibRecBig(
        int i,
        int n,
        BigInteger fPrev,
        BigInteger fCurr) {
        if (i <= n) {
            // recursive case
            return fibRecBig(i + 1, n, fCurr, fPrev.add(fCurr));
        } else {
            // base case
            return fCurr;
        }
    }


    // one way to do a better recursive function: imitate
    // the loop!

    /*
    public static long fibRec(
        int i,
        int n,
        long fPrev,
        long fCurr) {
        if (i <= n) {
            // recursive case
            return fibRec(i + 1, n, fCurr, fPrev + fCurr);
        } else {
            // base case
            return fCurr;
        }
    }

    // bit it's called like this, which isn't great
    fibRec(3, 50, 1, 1);

    // so you might make a nicer function for users to
    // call, which does the init stuff for them
    public static long fib(int n) {
        return fibRec(3, n, 1, 1);
    }
    */

    // don't think there's a non-branching version of this,
    // but there might be and if so I'll add it later
    /*
    public static BigInteger fibRecBig(int n) {
        if (n <= 2) {
            return BigInteger.ONE;
        } else {
        }
    }
    */

    // TODO: fibonacci implementations

    // NOTE: as with factorial, overflow will occur quickly
    //
    // - use long for N up to the 80s
    // - use BigInteger for N in the 90s and higher
    // - demonstrate overflow with fast version
    // - could compare speed of long and BigInteger
}

