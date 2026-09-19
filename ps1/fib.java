public class fib {


    public static long fib(int n) {
//        if (n <= 0) return 0;
//        if (n == 1) return 1;
//        if (n <= 1) return Math.max(n, 0);
//        return fib(n - 1) + fib(n - 2);
        if (n <= 0) return 0;

        return fibHelper(n, 1, 0);
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

    public static long fibHelper(int n, long curr, long prev) {
        if (n == 1) return curr;
        return fibHelper(n - 1, curr + prev, curr);
    }

    public static void main(String[] args) {
        int maxN = 10;


        for (int n = 0; n <= maxN; n++) {
            long before = System.currentTimeMillis();
//            long result = fib(n);
            long result = fibIter(n);
            long after = System.currentTimeMillis();
            System.out.printf("F_%d = %d (%d ms)%n", n, result, after - before);
        }

    }

}