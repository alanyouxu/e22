/*
 * Problem3.java
 * 
 * Computer Science E-22/S-22
 */

import java.util.Random;

public class Problem3 {
    public static LLList scale1(int factor, ArrayList vals) {
        LLList scaled = new LLList();

        for (int i = 0; i < vals.length(); i++) {
            int val = (Integer)vals.getItem(i);
            scaled.addItem(val*factor, i);
        }

        return scaled;
    }


    public static LLList scale(int factor, ArrayList vals) {

        LLList scaled = new LLList();

        int listLen = vals.length();

        for (int i = listLen - 1; i > -1; i = i-1) {
            int val = (Integer)vals.getItem(i);
            scaled.addItem(val * factor, 0); 
            // add to beginning of list always
            }

        return scaled;

    }


    public static void main(String[] args) {
        // Integer[] arr = {3, 7, 8, 2, 1, 5};
        
        
        Integer[] arr = new Integer[100000];
        Random rand = new Random();
        
        // Generate 300 random integers from 0 to 9
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }

        ArrayList vals = new ArrayList(arr);

        // Time scale()
        long start = System.nanoTime();
        scale(4, vals);
        long end = System.nanoTime();
        System.out.println("scale:  " + (end - start) / 1000000000.0 + " seconds");

        // Time scale1()
        start = System.nanoTime();
        scale1(4, vals);
        end = System.nanoTime();
        System.out.println("scale1: " + (end - start) / 1000000000.0 + " seconds");
    }
}
