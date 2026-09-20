public class alan {


    public static int io(String s, char c) {
        // return index of c within s
        if (s.length() == 0) return -1;
        if (s.charAt(0) == c) return 0;

        int x = io(s.substring(1), c);
        if (x == -1) return -1;
        return x + 1;

        // return 1 + io(s.substring(1), c);
    }

    static int foul;

    public static int mystery(int a, int b) {
        foul++;

        if (foul > 30) {
            return 1; // bottoming out
        }


        if (a < 0) {
            return 1;
        } else {
            int myst_rest = mystery(a - b, b);
            System.out.print("a: " + a + " / b: " + b + " / mr: " + myst_rest);
            System.out.println("");
            return 2 + myst_rest;
        }
    }


    public static boolean searchNum(int item, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }

    public static boolean recSearchNum(int item, int[] arr, int start) {
//        System.out.println("start: " + start);
        if (start >= arr.length) {
            return false;
        }

        if (arr[start] == item) {
            return true;
        }

        return recSearchNum(item, arr, start + 1);
    }

    public static boolean search(Object item, Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }


    public static boolean recSearch(Object item, Object[] arr, int start) {
        if (start >= arr.length) {
            return false;
        }

        if (arr[start].equals(item)) {
            return true;
        }

        return recSearch(item, arr, start + 1);
    }

    public static void main(String[] args) {

//        int x = mystery(20, -1);
//        System.out.println("x: " + x);
        int[] x = {0, 1, 2, 3, 4, 5, 8, 19, 240};
        System.out.println("5: " + recSearchNum(5, x, 0));
        System.out.println("1: " + recSearchNum(1, x, 0));
        System.out.println("9: " + recSearchNum(9, x, 0));
//        System.out.println("5: " + recSearchNum(5, x, 0));


    }

}