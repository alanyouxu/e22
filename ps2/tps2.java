public class tps2 {
    public static void generateSums(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            System.out.println(sum);
        }
    }


    public static void main(String[] args) {
        generateSums(10);
    }
}
