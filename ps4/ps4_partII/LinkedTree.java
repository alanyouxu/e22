/*
 * LinkedTree.java
 *
 * Computer Science E-22/S-22
 *
 * Modifications and additions by:
 *     name:
 *     username:
 */

import java.util.*;

/*
 * LinkedTree - a class that represents a binary tree containing
 * data items with integer keys.  If the nodes are inserted using
 * the insert method, the result will be a binary search tree.
 */
public class LinkedTree {
    // An inner class for the nodes in the tree
    private class Node {
        private int key;       // the key field
        private LLList data;   // list of data values for this key
        private Node left;     // ref to left child/subtree
        private Node right;    // ref to right child/subtree
        private Node parent;   // ref to parent (added for Prob 7)
        
        private Node(int key, Object data){
            this.key = key;
            this.data = new LLList();
            this.data.addItem(data, 0);
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    
    // the root of the tree as a whole
    private Node root;
    
    public LinkedTree() {
        root = null;
    }
    
    /*
     * Prints the keys of the tree in the order given by a
     * preorder traversal.  Invokes the recursive
     * preorderPrintTree method to do the work.
     */
    public void preorderPrint() {
        if (root != null) {
            preorderPrintTree(root);      
        }
        System.out.println();
    }
    
    /*
     * Recursively performs a preorder traversal of the
     * tree/subtree whose root is specified, printing the keys of
     * the visited nodes.  Note that the parameter is *not*
     * necessarily the root of the entire tree.
     */
    private static void preorderPrintTree(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            preorderPrintTree(root.left);
        }
        if (root.right != null) {
            preorderPrintTree(root.right);
        }
    }
    
    /*
     * Prints the keys of the tree in the order given by a
     * postorder traversal.  Invokes the recursive
     * postorderPrintTree method to do the work.
     */
    public void postorderPrint() {
        if (root != null) {
            postorderPrintTree(root);      
        }
        System.out.println();
    }
    
    /*
     * Recursively performs a postorder traversal of the
     * tree/subtree whose root is specified, printing the keys of
     * the visited nodes.  Note that the parameter is *not*
     * necessarily the root of the entire tree.
     */
    private static void postorderPrintTree(Node root) {
        if (root.left != null) {
            postorderPrintTree(root.left);
        }
        if (root.right != null) {
            postorderPrintTree(root.right);
        }
        System.out.print(root.key + " ");
    }
    
    /*
     * Prints the keys of the tree in the order given by an
     * inorder traversal.  Invokes the recursive inorderPrintTree
     * method to do the work.
     */
    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);      
        }
        System.out.println();
    }
    
    /*
     * Recursively performs an inorder traversal of the
     * tree/subtree whose root is specified, printing the keys of
     * the visited nodes.  Note that the parameter is *not*
     * necessarily the root of the entire tree.
     */
    private static void inorderPrintTree(Node root) {
        if (root.left != null) {
            inorderPrintTree(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            inorderPrintTree(root.right);
        }
    }
    
    /* 
     * Inner class for temporarily associating a node's depth
     * with the node, so that levelOrderPrint can print the
     * levels of the tree on separate lines.
     */
    private class NodePlusDepth {
        private Node node;
        private int depth;
        
        private NodePlusDepth(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    /*
     * Prints the keys of the tree in the order given by a
     * level-order traversal.
     */
    public void levelOrderPrint() {
        LLQueue<NodePlusDepth> q = new LLQueue<NodePlusDepth>();
        
        // Insert the root into the queue if the root is not null.
        if (root != null) {
            q.insert(new NodePlusDepth(root, 0));
        }
        
        // We continue until the queue is empty.  At each step,
        // we remove an element from the queue, print its value,
        // and insert its children (if any) into the queue.
	// We also keep track of the current level, and add a
        // newline whenever we advance to a new level.
        int level = 0;
        while (!q.isEmpty()) {
            NodePlusDepth item = q.remove();
            
            if (item.depth > level) {
                System.out.println();
                level++;
            }
            System.out.print(item.node.key + " ");
            
            if (item.node.left != null) {
                q.insert(new NodePlusDepth(item.node.left,
					   item.depth+1));
            }
            if (item.node.right != null) {
                q.insert(new NodePlusDepth(item.node.right,
					   item.depth+1));
            }
        }
        System.out.println();
    }
    
    /*
     * Searches for the specified key in the tree.  If it finds
     * it, it returns the list of data items associated with the
     * key.  Invokes the recursive searchTree method to perform
     * the actual search.
     */
    public LLList search(int key) {
        Node n = searchTree(root, key);
        if (n == null) {
            return null;
        } else {
            return n.data;
        }
    }
    
    /*
     * Recursively searches for the specified key in the
     * tree/subtree whose root is specified. Note that the
     * parameter is *not* necessarily the root of the entire
     * tree.
     */
    private static Node searchTree(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key == root.key) {
            return root;
        } else if (key < root.key) {
            return searchTree(root.left, key);
        } else {
            return searchTree(root.right, key);
        }
    }
    
    /*
     * Inserts the specified (key, data) pair in the tree so that
     * the tree remains a binary search tree.
     */
    public void insert(int key, Object data) {
        // Find the parent of the new node.
        Node parent = null;
        Node trav = root;
        while (trav != null) {
            if (trav.key == key) {
                trav.data.addItem(data, 0);
                return;
            }
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }
        
        // Insert the new node.
        Node newNode = new Node(key, data);
        if (parent == null) {    // the tree was empty
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        
        /**** added for Problem 7 ****/
        newNode.parent = parent;
    }
    
    /*
     * FOR TESTING: Processes the integer keys in the specified
     * array from left to right, adding a node for each of them
     * to the tree.  The data associated with each key is a
     * string based on the key.
     */
    public void insertKeys(int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            insert(keys[i], "data for key " + keys[i]);
        }
    }
    
    /*
     * Deletes the node containing the (key, data) pair with the
     * specified key from the tree and return the associated data
     * item.
     */
    public LLList delete(int key) {
        // Find the node to be deleted and its parent.
        Node parent = null;
        Node trav = root;
        while (trav != null && trav.key != key) {
            parent = trav;
            if (key < trav.key) {
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }
        
        // Delete the node (if any) and return its data list.
        if (trav == null) {   // no such key    
            return null;
        } else {
            LLList removedData = trav.data;
            deleteNode(trav, parent);
            return removedData;
        }
    }
    
    /*
     * Deletes the node specified by the parameter toDelete.
     * parent specifies the parent of the node to be deleted. 
     */
    private void deleteNode(Node toDelete, Node parent) {
        if (toDelete.left != null && toDelete.right != null) {
            // Case 3: toDelete has two children.
            // Find a replacement for the item we're deleting 
            // -- as well as the replacement's parent.
            // We use the smallest item in toDelete's right subtree
            // as the replacement.
            Node replaceParent = toDelete;
            Node replace = toDelete.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }
            
            // Replace toDelete's key and data with those of the 
            // replacement item.
            toDelete.key = replace.key;
            toDelete.data = replace.data;
            
            // Recursively delete the replacement item's old node.
            // It has at most one child, so we don't have to
            // worry about infinite recursion.
            deleteNode(replace, replaceParent);
        } else {
            // Cases 1 and 2: toDelete has 0 or 1 child
            Node toDeleteChild;
            if (toDelete.left != null) {
                toDeleteChild = toDelete.left;
            } else {
                toDeleteChild = toDelete.right;  // null if no kids
            }

            /**** added for Problem 7 ****/
            if (toDeleteChild != null) {
                toDeleteChild.parent = parent;
            }
            
            if (toDelete == root) {
                root = toDeleteChild;
            } else if (toDelete.key < parent.key) {
                parent.left = toDeleteChild;
            } else {
                parent.right = toDeleteChild;
            }
        }
    }
    
    /* Returns a preorder iterator for this tree. */
    public LinkedTreeIterator preorderIterator() {
        return new PreorderIterator();
    }
    
    /* 
     * inner class for a preorder iterator
     */
    private class PreorderIterator implements LinkedTreeIterator {
        private Node nextNode;
        
        private PreorderIterator() {
            // The traversal starts with the root node.
            nextNode = root;
        }
        
        public boolean hasNext() {
            return (nextNode != null);
        }
        
        public int next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            
            // Store a copy of the key to be returned.
            int key = nextNode.key;
            
            // Advance nextNode.
            if (nextNode.left != null) {
                nextNode = nextNode.left;
            } else if (nextNode.right != null) {
                nextNode = nextNode.right;
            } else {
                // We've just visited a leaf node.
                // Go back up the tree until we find a node
                // with a right child that we haven't seen yet.
                Node parent = nextNode.parent;
                Node child = nextNode;
                while (parent != null &&
                  (parent.right == child || parent.right == null)) {
                    child = parent;
                    parent = parent.parent;
                }
                
                if (parent == null) {
                    nextNode = null;  // the traversal is complete
                } else {
                    nextNode = parent.right;
                }
            }
            
            return key;
        }
    }  

    public LinkedTreeIterator PostorderIterator() {
        return new PostorderIterator();
    }

    private Node postHelper(Node nextNode) {
        while (nextNode.left != null || nextNode.right != null) {
            if (nextNode.left != null) nextNode = nextNode.left;
            else nextNode = nextNode.right; 
        }
        return nextNode;
    }

    // @SuppressWarnings("unused")
    private class PostorderIterator implements LinkedTreeIterator {
        private Node nextNode = root;

        private PostorderIterator() {
            // traverse to first node
            nextNode = postHelper(nextNode);
        }

        public boolean hasNext() {
            return (nextNode != null);
        }

        public int next() {
            if (nextNode == null) throw new NoSuchElementException();

            int key = nextNode.key;

            Node child = nextNode;
            Node parent = nextNode.parent; // could be null

            
            if (parent == null) {
                nextNode = null; // done
            }
            else if (child == parent.right || parent.right == null) {
                nextNode = nextNode.parent; // head upwards
            } else {
                nextNode = postHelper(parent.right);
            }

            
            return key;
        }
        
    }
    
    @SuppressWarnings("unused")
    private static boolean isomorphic(Node root1, Node root2) {
        return true;
    }
    
    /*
     * "wrapper method" for the recursive maxLessThanInTree()
     * method from Problem 4
     */
    public int maxLessThan(int threshold) {
        // root is the root of the entire tree
        return maxLessThanInTree(root, threshold);
    }
    
    /*
     * original version of the recursive maxLessThanInTree()
     * method from Problem 4. You will write a more efficient
     * version of this method as part of that problem.
     * 
     * Note: For the purposes of this problem, we assume that
     * all of the keys in the tree are positive.
     */
    // private static int maxLessThanInTree(Node root, int t) {
    //     if (root == null) {
    //         return -1;
    //     } else {
    //         int maxInLeft = maxLessThanInTree(root.left, t);
    //         int maxInRight = maxLessThanInTree(root.right, t);
    //         int maxInSubtrees = Math.max(maxInLeft, maxInRight);
    //         if (root.key < t) {
    //             return Math.max(root.key, maxInSubtrees);
    //         } else {
    //             return maxInSubtrees;
    //         }
    //     }
    // }

    private static int maxLessThanInTree(Node root, int t) {
        if (root == null) {
            return -1;
        } else {
            if (root.key < t) {
                return Math.max(root.key, maxLessThanInTree(root.right, t));
            } else {
                // only go into left tree
                return maxLessThanInTree(root.left, t);
            }
        }
    }

    public int minOnPathTo(int key) {
        if (this.root == null) return -1; // exit early

        Node curr = root; 
        int minOnPath = root.key; // initialize with root

        while (curr != null) {
            if (curr.key < minOnPath) minOnPath = curr.key; // replace if new min
            
            // tree navigation
            if (key < curr.key) { curr = curr.left; }
            else if (key > curr.key) {curr = curr.right; }
            else break; // break if we found the right 
        }

        if (curr == null) { return -1; } 
        else {
            return minOnPath;
        }
    }

    private static int numOddInTree(Node root) {
        if (root == null) return 0;
        int numOdd = 0;
        if (root.key % 2 == 1) numOdd++;

        return numOdd + numOddInTree(root.left) + numOddInTree(root.right);
        // return 0;
    }

    public int numOdd() {
        return numOddInTree(this.root);
    }


    // @SuppressWarnings("unused")
    private int deleteMin() {
        if (this.root == null) return -1;

        Node curr = this.root;
        Node next = this.root.left;

        if (next == null) { // root is smallest
            this.root = this.root.right; // delete root
            this.root.parent = null;
            return curr.key;
        }

        while (next.left != null) { 
            // run to smallest node (will be leftmost)
            // next will be smallest node and curr will be its parent
            curr = curr.left;
            next = next.left;
        } 

        curr.left = next.right; // delete and reassign the right children
        next.right.parent = curr;
        return next.key;
    }
    
    public static void main(String[] args) {
        // int[] testCases;


        System.out.println("--- Testing maxLessThanInTree() ---");
        System.out.println();
        System.out.println("(0) tree from pr4, max < 60");
        try {
            LinkedTree tree = new LinkedTree();
            int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
            tree.insertKeys(keys);
            
            int result = tree.maxLessThan(60);
            System.out.println("actual result:");
            System.out.println(result);
            System.out.println("expected result:");
            System.out.println(56);
            System.out.print("MATCHES EXPECTED RESULT?: ");
            System.out.println(result == 56);
            
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW EXCEPTION: " + e);
        }
        
        System.out.println();  // include blank line between tests
        
        /*
        * Add at least two unit tests for each method
        * from Problem 6.
        * Test a variety of different cases.
        * Follow the same format that we have used above.
        */

        System.out.println("--- Testing minOnPathTo() ---");
        System.out.println();
        System.out.println("New tree, with min value 5");

        try {
       
            LinkedTree tree2 = new LinkedTree();
            int[] keys2 = {52, 23, 81, 11, 67, 38, 94, 5, 17, 31, 45, 60, 74, 88, 99, 42};
            tree2.insertKeys(keys2);
            
            int[] testCases = {94, 5, 18, 31};

            for (int i = 0; i < testCases.length; i++) {
                System.out.println("minOnPathTo(" + testCases[i] + "): " + tree2.minOnPathTo(testCases[i]));
            }
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW EXCEPTION: " + e);
        }

        // System.out.println("minOnPathTo(94): " + tree2.minOnPathTo(94)); // 52
        // System.out.println("minOnPathTo(17): " + tree2.minOnPathTo(17)); // 11
        // System.out.println("minOnPathTo(18): " + tree2.minOnPathTo(18)); // -1
        // System.out.println("minOnPathTo(31): " + tree2.minOnPathTo(31)); // 23

        // System.out.println();

        // System.out.println("numOddInTree:" + tree2.numOdd());
        
        // System.out.println();

        // System.out.println("minOnPathTo of null tree = " + tree3.minOnPathTo(13));
        // LinkedTree tree3 = new LinkedTree();
        // int[] keys3 = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree3.insertKeys(keys3);

        // int[] testCases2 = {13, 35, 37, 50};

        // for (int i = 0; i < testCases2.length; i++) {
        //     System.out.println("minOnPathTo(" + testCases2[i] + "): " + tree3.minOnPathTo(testCases2[i]));
        // }


        // System.out.println();

        // System.out.println("numOddInTree: " + tree3.numOdd());


        // LinkedTree tree4 = new LinkedTree();
        // System.out.println("numOdd of null tree = " + tree4.numOdd());
        // int[] keys = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree4.insertKeys(keys);
        // System.out.println("numOdd of tree4 = " + tree4.numOdd());



        // LinkedTree tree5 = new LinkedTree();
        // System.out.println("empty tree: " + tree5.deleteMin());

        // int[] keys5 = {37, 26, 42, 13, 35, 56, 30, 47, 70};
        // tree5.insertKeys(keys5);
        // System.out.println("levels of original tree:");
        // tree5.levelOrderPrint();

        // System.out.println("\ndeleteMin: " + tree5.deleteMin());
        // tree5.levelOrderPrint();
        // System.out.println("\ndeleteMin: " + tree5.deleteMin());
        // tree5.levelOrderPrint();


        // LinkedTree treeX = new LinkedTree();
        // int[] keysX = {40, 20, 60, 10, 30,50, 70, 5, 15, 25, 35, 45, 55, 65, 75};
        // int[] keysX =  {50, 25, 75, 10, 40, 60, 90, 5, 15, 35, 45, 80, 95};;
        // treeX.insertKeys(keysX);

        // // iterator look
        // System.out.println();
        // System.out.println("Iterator look: ");
        // System.out.println();
        // treeX.levelOrderPrint();
        // System.out.println();

        // LinkedTreeIterator iter = treeX.preorderIterator();
        // while (iter.hasNext()) {
        // // while (true) {
        //     // int key = iter.next();
        //     // System.out.println(key);
        //     System.out.println(iter.next());
        //     // do something with key
        // }

        // LinkedTreeIterator iterp = treeX.PostorderIterator();
        // while (iterp.hasNext()) {
        //     System.out.println(iterp.next());
        // }

    }
}
