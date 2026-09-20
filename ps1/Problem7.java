public class Problem7 {

    // returns nth index of c within string s
    // returns -1 if < n occurrences of c, or if s null or empty, or n <= 0
    public static int nthIndexOf(int n, char c, String s) {
        if (s == null || s == "" || n <= 0) return -1;

        // initialize x to determine the next step
        int x;
        if (s.charAt(0) != c) {
            x = nthIndexOf(n, c, s.substring(1)); // move forward in s
        } else if (n == 1) {
            return 0; // return 0 upon finding the desired occurrence
        } else {
            x = nthIndexOf(n - 1, c, s.substring(1)); // decrement n and move forward in s
        }

        if (x == -1) return -1; // upon seeing end of string without success, we return only -1
        return x + 1; // otherwise return the appropriate increment
    }


    // returns a string trimmed of leading and trailing spaces
    // " hello world  " returns "hello world"
    public static String trim(String s) {
        // return null for null strings and empty for empty strings
        if (s == null || s.length() == 0) return s;      

        if (s.charAt(0) == ' ') {
            return trim(s.substring(1));
        }

        if (s.charAt(s.length() - 1) == ' '){
            return trim(s.substring(0, s.length() - 1));
        }
        
        return s;
    }

    public static void main(String[] args) {
        System.out.println(nthIndexOf(1, 'a', "banana"));
        System.out.println(nthIndexOf(2, 'a', "banana"));
        System.out.println(nthIndexOf(3, 'a', "banana"));
        System.out.println(nthIndexOf(4, 'a', "banana"));
        System.out.println(nthIndexOf(4, 'a', ""));
        System.out.println(nthIndexOf(4, 'a', "banana"));
        // String s = trim("    hello world haha     ");
        // System.out.println(s);
        // System.out.println(s.length());
    }
}
