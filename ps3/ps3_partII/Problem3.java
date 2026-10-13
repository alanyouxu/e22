/*
 * Problem3.java
 * 
 * Computer Science E-22/S-22
 */

public class Problem3 {
    public static LLList scale(int factor, ArrayList vals) {
        LLList scaled = new LLList();

        for (int i = 0; i < vals.length(); i++) {
            int val = (Integer)vals.getItem(i);
            scaled.addItem(val*factor, i);
        }

        return scaled;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 7, 8, 2, 1, 5};
        ArrayList vals = new ArrayList(arr);

        LLList result = scale(4, vals);
        System.out.println(result);
    }
}
