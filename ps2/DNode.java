/*
 * DNode.java
 *
 * Computer Science E-22/S-22
 */

/*
 * A class for representing a string using a doubly-linked list.
 * Each character of the string is stored in a separate node.  
 *
 * This class represents one node of the linked list.  The string as a
 * whole is represented by storing a reference to the first node in
 * the linked list. Empty strings are represented using a value of null.
 */ 
public class DNode {
    private char ch;
    private DNode prev;
    private DNode next;

    /*
     * Constructor
     */
    public DNode(char c, DNode p, DNode n) {
        this.ch = c;
        this.prev = p;
        this.next = n;
    }

    /*
     * convert - converts a standard Java String object to a
     * doubly-linked list and returns a reference to first node
     * in that doubly-linked list
     */
    public static DNode convert(String s) {
        if (s.length() == 0) {
            return null;
        }

        DNode firstNode = new DNode(s.charAt(0), null, null);
        DNode prevNode = firstNode;
        DNode nextNode;

        for (int i = 1; i < s.length(); i++) {
            nextNode = new DNode(s.charAt(i), prevNode, null);
            prevNode.next = nextNode;
            prevNode = nextNode;
        }

        return firstNode;
    }

    /*
     * toString - creates and returns the Java string that
     * the current DNode represents.  Note that this
     * method is non-static method, and thus it won't work
     * for empty strings, since they are represented by a 
     * value of null, and we can't use null to invoke this method.
     */
    public String toString() {
        String str = "";
        
        DNode trav = this;   // start trav on the current node (this)
        while (trav != null) {
            str = str + trav.ch;
            trav = trav.next;
        }
         
        return str;
    }

    public static void main(String[] args) {
        // set up the initial diagram for Problem 6
        DNode str = DNode.convert("ran");
        DNode n = str.next.next;
        DNode x = new DNode('i', null, null);

        System.out.println("before changes for 6-2: " + str);

        // put your answer for Problem 6-2 here
        x.prev = n.prev;
        x.next = n;
        n.prev.next = x;
        n.prev = x;



        System.out.println("after changes for 6-2: " + str);
    }
}
