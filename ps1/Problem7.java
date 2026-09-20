public class Problem7 {

    // returns nth index of c within string s
    // returns -1 if < n occurrences of c, or if s null or empty, or n <= 0
    public static int nthIndexOf(int n, char c, String s) {
        if (n <= 0) return -1;
        if (s == null || s == "") return -1;

        int x;

        if (s.charAt(0) != c) {
            x = nthIndexOf(n, c, s.substring(1)); // move forward
        } else if (n == 1) {
            return 0; // return 0 upon finding the desired occurrence
        } else {
            x = nthIndexOf(n - 1, c, s.substring(1)); // decrement n and move forward
        }

        if (x == -1) {
            return -1; // upon seeing end of string without finding, we return only 0
        } 
        return x + 1; // otherwise return the appropriate increment
    }

    public static String trim(String s) {
        if (s == null) return null;
        if (s.charAt(0) == ' ') {
            return trim(s.substring(1));
        }
        if (s.charAt(s.length() - 1) == ' '){
            return trim(s.substring(0, s.length() - 1));
        }
        return s;
    }

    public static void main(String[] args) {
        // System.out.println(nthIndexOf(1, 'a', "banana"));
        // System.out.println(nthIndexOf(2, 'a', "banana"));
        // System.out.println(nthIndexOf(3, 'a', "banana"));
        // System.out.println(nthIndexOf(4, 'a', "banana"));
        // System.out.println(nthIndexOf(4, 'a', ""));
        // System.out.println(nthIndexOf(4, 'a', "banana"));
        String s = trim("    hello world haha     ");
        System.out.println(s);
        System.out.println(s.length());
    }
}
