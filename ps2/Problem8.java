import java.util.Arrays;

public class Problem8 {

    // union two arrays together - sorted, no duplicates, trailing zeroes OK
    public static int[] union(int[] a1, int[] a2) {

        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException("One or both arrays are null");
        }

        Sort.mergeSort(a1); Sort.mergeSort(a2);
        int l1 = a1.length; int l2 = a2.length;
        int[] result = new int[l1 + l2];

        // indices into a1, a2, and result respectively
        int i = 0; int j = 0; int k = 0;

        // check both arrays, advancing forward through duplicates
        while (i < l1 && j < l2) {
            // if else structure guarantees just one pass per increment of k
            if (a1[i] < a2[j]) {
                result[k] = a1[i];
                i = race(a1, i);
            } else if (a1[i] > a2[j]) {
                result[k] = a2[j];
                j = race(a2, j);
            } else {
                result[k] = a1[i];
                i = race(a1, i);
                j = race(a2, j);
            }
            k++;
        }

        // copy the rest of the results in if any leftovers
        // after one array is depleted
        while (i < l1) {
            result[k] = a1[i];
            i = race(a1, i);
            k++;
        }

        while (j < l2) {
            result[k] = a2[j];
            j = race(a2, j);
            k++;
        }

        return result;
    }

    // race ahead until the next value that is different - helper function to dedupe
    // do - while loop, we only run this after adding in an value so we don't need it
    private static int race(int[] arr, int index) {
        do { index++; } while (index < arr.length && arr[index] == arr[index - 1]);
        // System.out.println("raced to: " + i);
        return index;
    }

    public static void main(String[] arr) {


        // int[] x = {-8, -3, 0, 4, 4, 4, 7, 9, 9, 15};
        // int[] y = {-8, -8, 0, 0, 4, 4, 6, 9, 9, 9, 14, 14, 20, 20, 25, 25, 25, 25};
        
        int[] x = {1,2,3,4};
        int[] y = {0,5,6,7,8,9,10};
        int[] result0 = union(x, y);
        System.out.println(Arrays.toString(result0));

        int[] b1 = {10, 5, 7, 5, 9, 4};
        int[] b2 = {7, 5, 15, 7, 7, 9, 10};
        int[] resultb1 = union(b1, b2);
        System.out.println(Arrays.toString(resultb1));

        int[] b3 = {0, 2, -4, 6, 10, 8};
        int[] b4 = {12, 0, -4, 8};
        int[] resultb2 = union(b3, b4);
        System.out.println(Arrays.toString(resultb2));



        int[] a1 = {10, 5, 7, 5, 9, 4};
        int[] a2 = {7, 5, 15, 7, 7, 9, 10};
        int[] result1 = union(a1, a2);
        System.out.println(Arrays.toString(result1));

        int[] a3 = {0, 2, -4, 6, 10, 8};
        int[] a4 = {12, 0, -4, 8};
        int[] result2 = union(a3, a4);
        System.out.println(Arrays.toString(result2));
    }


}