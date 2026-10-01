import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        System.out.printf("factorialIter(%d) = %d\n", n, factorialIter(n));
        System.out.printf(
                "factorialIterBig(%d) = %s\n", n, factorialIterBig(n));
        System.out.printf("factorialRec(%d) = %d\n", n, factorialRec(n));
        System.out.printf("factorialRecBig(%d) = %s\n", n, factorialRecBig(n));
    }

    // NOTE: factorial will quickly overflow an int
    //
    // - long will work until around n=20, test this
    // - BigInteger can handle arbitrarily large numbers, but it's slower

    public static long factorialIter(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static BigInteger factorialIterBig(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    // piecewise function
    //
    // N! = { N * (N-1)!      if N > 1
    //      { 1               if N <= 1
    public static long factorialRec(int n) {
        System.out.printf("%2d!: factorialRec(%d) = ??\n", n, n);

        if (n > 1) {
            // recursive case
            // - trivial problem: multiply by n
            // - smaller factorial problem: factorial of n-1

            long f = factorialRec(n - 1);
            System.out.printf("%2d!: factorialRec(%d) = %d\n", n, n - 1, f);

            long returnValue = n * f;
            System.out.printf("%2d!: return %d\n", n, returnValue);

            return returnValue;
        } else {
            // base case
            System.out.printf("%2d!: return 1\n", n);
            return 1;
        }

        // ternary operator ?:
        // COND ? IF_TRUE : IF_FALSE
        // return n > 1 ? n * factorialRec(n - 1) : 1;
    }

    public static BigInteger factorialRecBig(int n) {
        if (n > 1) {
            return BigInteger.valueOf(n).multiply(factorialRecBig(n - 1));
        } else {
            return BigInteger.ONE;
        }
    }
}

