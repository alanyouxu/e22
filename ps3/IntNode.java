// package ps3;

import java.util.Random;

public class IntNode {

    private int val;
    private IntNode next;
    

    public IntNode(int val, IntNode next) {
        this.val = val;
        this.next = next;
    }

       
    

    public static IntNode genList() {
        IntNode head = new IntNode(0, null);
        IntNode curr = head;

        for (int i = 1; i <= 6; i++) {
            IntNode newIN = new IntNode(i, null);
            curr.next = newIN;
            curr = curr.next;
        }

        return head;
    }

    public static IntNode genList2() {
        Random rand = new Random();

        IntNode head = new IntNode(rand.nextInt(10) + 1, null);
        IntNode curr = head;

        for (int i = 1; i < 16; i++) {
            IntNode newIN = new IntNode(rand.nextInt(10) + 1, null);
            curr.next = newIN;
            curr = curr.next;
        }

        return head;
    }

    public static void printInts(IntNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        printInts(head.next);
    }

    public static void printOddsRecur(IntNode first) {
        // return if empty or we reached end of list
        if (first == null) return;
        
        // use bitwise and to check even/odd, print odds only
        if ((first.val & 1) == 1) { System.out.println(first.val); }

        // call on the next node in linked list
        printOddsRecur(first.next);
    }

    public static void printOddsIter(IntNode first) {
        // check if null, check if odd, the step forward
        while (first != null) {
            if ((first.val & 1) == 1) {
                System.out.println(first.val);
            }
            first = first.next;
        }
    }


    public static void main(String[] arr) {
        IntNode f = genList2();

        System.out.println("recursive:");
        printOddsRecur(f);
        System.out.println("iterative:");
        printOddsIter(f);
    }

}
