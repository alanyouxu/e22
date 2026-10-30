public class fib {
    public static int fibo(int n) {
        if (n <= 1) return n;
        // return fibo(n-1) + fibo(n-2);    
        return fibhelper(0,1,n);
    }

    public static int fibhelper(int i, int j, int n) {
        if (n == 2) return i + j;
        return fibhelper(j, i+j, n-1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 40; i++) {
            System.out.println(fibo(i));
        }
    }
}
