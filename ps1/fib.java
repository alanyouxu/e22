import java.math.BigInteger;

public class fib {


    public static long fibe(int n) {
       if (n <= 1) return Math.max(n, 0);
       return fibe(n - 1) + fibe(n - 2);
    }

    public static long fibIter(int n) {
        if (n <= 1) {
            return Math.max(n, 0);
        }

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) { // figure out why <= not <
            long temp = prev + curr;
            prev = curr;
            curr = temp;
        }

        return curr;
    }


//    public static int maxVal(int[] vals) {
//        return maxVal(vals, 0);
//    }

    public static BigInteger fib2(int n) {
        if (n <= 1) return BigInteger.valueOf(Math.max(n, 0));
        return fibHelper(n, BigInteger.ONE, BigInteger.ONE);
    }

    public static BigInteger fibHelper(int n, BigInteger curr, BigInteger prev) {
        if (n == 1) return curr;
        return fibHelper(n - 1, curr.add(prev), curr);
    }

    public static void main(String[] args) {
        int maxN = 50000;

        // ForkJoinPool pool = new ForkJoinPool(4);


        for (int n = 0; n <= maxN; n++) {
            long before = System.currentTimeMillis();
            BigInteger result = fib2(n);
            // long result = pool.invoke(new FibTask(n));


            // long result = fibIter(n);
            long after = System.currentTimeMillis();
            System.out.printf("F_%d = %d (%d ms)%n", n, result, after - before);
        }

    }

}