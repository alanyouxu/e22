public class ps1ax {
    public static void main(String[] args) {
//        System.out.println("hello, world!");
        int[] a = {2, 4, 6, 8, 10, 12};
//        int[] b = new int[6];
        int[] c = new int[6];

//        b = a;
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }


        int[] b = {1, 1, 1, 3, 4, 5, 6};
        int[] d = {1, 1, 3, 4, 5, 7, 5};
//        a[2] = c[5];
//        c[2]++;
//        System.out.println(a[2] + " " + b[2] + " " + c[2]);\

//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {5, 4, 3, 2, 1};
//        int[] c = {1, 2, 4, 3, 5};

//        int[] f;
//        System.out.println();
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }

        System.out.println(isSorted(b));
        System.out.println(isSorted(d));  // true
//        System.out.println(isSorted(f));

//        System.out.println(isSorted(d));  // true
//        System.out.println(isSorted(e));  // true

    }


    public static boolean isSorted(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException(
                    "null array"
            );
        } else if (arr.length == 0) {
            return true;
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void scale(int[] arr, int factor) {
        if (arr == null) {
            throw new IllegalArgumentException(
                    "Null array"
            );
        } else if (arr.length == 0) {
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = factor * arr[i];
            }
        }

//        return;
    }
}

