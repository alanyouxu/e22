/*
 * Problem8.java, CSCI E-22/S-22
 * 
 * modified by:
 *   name:
 *   email:
 */
   
public class Problem8 {
    public static boolean isPal(String s) {
        // replace the following return statement with your implementation
        // of the method.

        if (s == null) throw new IllegalArgumentException("Null string!");
        if (s.length() < 2) return true; // trivially palindromic


        LLStack<Character> pstack = new LLStack<Character>();

        // move inwards on both ends of the string
        int i = 0; int j = s.length() - 1;

        while (i < j) {
            // race forward to find alphabetic character, stop when passing each other;
            while ((i < j) && !Character.isAlphabetic(s.charAt(i))) i++;
            while ((i < j) && !Character.isAlphabetic(s.charAt(j))) j--;

            if (i < j) { // if we've passed each other, just move on
                pstack.push(Character.toLowerCase(s.charAt(i)));
                pstack.push(Character.toLowerCase(s.charAt(j)));
                i++; j--; // move forward
            } // note this method guarantees an EVEN number in our ArrayStack;
        }

        Character front; Character back;        
        while (pstack.peek() != null) { // see if there are more to check
            front = pstack.pop(); back = pstack.pop();
            if (front != back) return false; // no cases for null, as we guaranteed non-null values
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        String s = "racecar";
        s = "Was it a car o//////////r a cat I saw?";
        // String s = null;

        System.out.println("(0) Testing on \"" + s + "\"");
        try {
            boolean results = isPal(s);
            System.out.println("actual results:");
            System.out.println(results);
            // System.out.println("expected results:");
            // System.out.println("true");
            // System.out.print("MATCHES EXPECTED RESULTS?: ");
            // System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * We encourage you to add more unit tests below that test a variety 
         * of different cases, although doing so is not required.
         */
    }
}