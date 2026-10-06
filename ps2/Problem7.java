// package ps2;

public class Problem7 {


    public static void pairSums(int k, int[] arr) {
        // assume array is sorted
        // do not assume array is non-null or non-empty
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] > k) {
                j--;
            } else if (arr[i] + arr[j] < k) {
                i++;
            } else {
                System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                i++;
                j--;
            }
        }
    }


    public static void main(String[] args) {

        int[] x = {1, 2, 4, 5, 5, 5, 6, 7, 7, 8, 10, 11, 15};
        // int[] x = {4, 5, 5, 5, 6, 7, 7, 8, 10, 15};

        Sort.mergeSort(x);
        
        pairSums(12, x);


        System.out.println("");
        int[] y = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16};

        pairSums(17, y);


    }
}
