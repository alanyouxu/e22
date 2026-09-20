public class Problem6 {
    public static int sumSquares(int[] vals, int start) {
        // take an array of vals of 1 or more integers and non-negative integer start
        // return sum of the squares from position start
        // assume vals is non-null and start is non-negative (though sometimes i took care of these exceptions)
        if (vals == null || start < 0 || start >= vals.length) {
            return 0; 
        }
        
        int x = vals[start] * vals[start];
        return x + sumSquares(vals, start + 1);
    }


    // prints string in reverse, no return value
    // "abc" prints "cba"
    public static void printReverse(String s) {
        if (s != null && s.length() > 0) {
            int x = s.length();
            System.out.print(s.charAt(x-1));
            printReverse(s.substring(0, x-1));
        }
    }


    // returns string concatenated with reversed string, "abc" returns "abccba"
    public static String reflect(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        return s.charAt(0) + reflect(s.substring(1)) + s.charAt(0);

    }

    // returns true if string contains char, otherwise false
    public static boolean contains(String s, char c) {
        if (s == null || s.length() == 0) return false;
        if (s.charAt(0) == c) return true;
        return contains(s.substring(1), c);
    }


    // returns the number of char differences in two strings, read in left to right
    // assumed non-null inputs
    public static int numDiff(String s1, String s2) {
        // assume s1, s2 non-null
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return s2.length();
        if (s2 == null) return s1.length();

        // based on char/string comparison, decide if we continue (with or without increment) or stop
        int x = 0;
        if (s1.length() == 0) {
            return s2.length();
        } else if (s2.length() == 0) {
            return s1.length();
        } else if (s1.charAt(0) != s2.charAt(0)) {
            x++;
        }
        
        return x + numDiff(s1.substring(1), s2.substring(1));
    }

    // returns the bitwise OR of two bit strings, assumed non-null inputs
    public static String bwOr(String b1, String b2) {

        // deal with exceptions just in case
        if (b1 == null && b2 == null) return "";
        if (b1 == null) return b2;
        if (b2 == null) return b1;

        char c = '0';
        if (b1.length() == 0) return b2;
        if (b2.length() == 0) return b1;
        if (b1.charAt(b1.length() - 1) == '1' || b2.charAt(b2.length() - 1) == '1') {
            c = '1';
        }
        return bwOr(b1.substring(0, b1.length() - 1), b2.substring(0, b2.length() - 1)) + c;
    }

    /* my first attempt at this used a helper function to keep track of the position
    but i was able to write a version without it */

    // // returns index of first occurence of c within s, -1 if not present 
    // public static int indexOf(char c, String s) {
    //     if (s == null || s.length() == 0) return -1;
    //     // return 0;
    //     return indexOfHelper(c, s, 0);
    // }

    // // helper function for indexOf to keep track of position
    // public static int indexOfHelper(char c, String s, int pos) {
    //     if (s == null || s.length() == 0) return -1;
    //     if (s.charAt(0) == c) return pos;
    //     return indexOfHelper(c, s.substring(1), pos + 1);
    // }


    // returns index of char c in string s
    // no helper function! looks forward to see if the string ends and passes -1 all the way back if so
    // otherwise returns an incrementing number
    public static int indexOf(char c, String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.charAt(0) == c) return 0;

        int x = indexOf(c, s.substring(1));

        if (x == -1) return -1; 
        return 1 + x;
    }


    public static void main(String[] args) {
        int[] ax = {0, 1, 2, 3, 4, 5};
        System.out.println(sumSquares(ax, 3));

        // String s = "abdft";
        // char c = 'c';
        // String s = null;
        // printReverse(s);
        // System.out.println(reflect(s));
        // System.out.println(contains(s, c));

        // System.out.println(numDiff("alien", "allen"));
        // System.out.println(numDiff("alien", "alone"));
        // System.out.println(numDiff("same", "same"));
        // System.out.println(numDiff("same", "sameness"));
        // System.out.println(numDiff("abc", ""));

        // System.out.println(numDiff("", "abc"));
        // System.out.println();

        // System.out.println(bwOr("10100", "00101"));
        // System.out.println(bwOr("10100", "1000101"));
        // System.out.println(bwOr("10111", ""));
        // System.out.println(bwOr("", "0110"));

        // System.out.println(indexOf('b', "rabbit"));
        // System.out.println(indexOf('x', "rabbit"));
    
    }

}