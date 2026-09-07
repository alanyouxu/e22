/* 
 * ArrayBag.java
 * 
 * Computer Science E-22
 */

import java.util.*;

/*
 * An simple implementation of a bag data structure that uses 
 * an array to store the items.
 */
public class ArrayBag {
    /* 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /* 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /*
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /* 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /*
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }

    // return the size of the bag
    public int bagSize() { return this.items.length;}
    
    /* 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /* 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /*
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /*
     * containsAll - does this ArrayBag contain all of the items in
     * otherBag?  Returns false if otherBag is null or empty. 
     */
    public boolean containsAll(ArrayBag otherBag) {
        if (otherBag == null || otherBag.numItems == 0) {
            return false;
        }
        
        for (int i = 0; i < otherBag.numItems; i++) {
            if (! this.contains(otherBag.items[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    /*
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /*
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /*
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }

    // return amount of space left in ArrayBag
    public int roomLeft() {
        return this.items.length - this.numItems;
    }

    // returns true if bag is empty
    public boolean isEmpty() {
        if (this.numItems == 0) {
            return true;
        }
        return false;
    }

    public void increaseCapacity(int amount) {
        if (amount == 0) {
            return;
        } else if (amount < 0) {
            throw new IllegalArgumentException("Must increase by non-negative amount");
        }
        int new_bag_size = this.items.length + amount;
        Object[] new_bag = new Object[new_bag_size];

        for (int i = 0; i < this.numItems; i++) {
            new_bag[i] = this.items[i];
        }

        this.items = new_bag;

    }

    // add items from another bag, returns false if there's no room
    // , adds and returns true if there is
    public boolean addItems(ArrayBag other) {
        if (other == null) {
            throw new IllegalArgumentException("No bag found");
        } else if (this.numItems + other.numItems() > this.items.length) {
            return false;
        }

        for (int i = 0; i < other.numItems(); i++) {
            this.add(other.items[i]);
        }
        return true;
    }

    public ArrayBag intersectionWith(ArrayBag other) {
        // throw error for null bag
        if (other == null) {
            throw new IllegalArgumentException("No bag found");
        }


        // initialize bag size (3)
        int intersectBagSize = 1;

        if (this.numItems() == 0 || other.numItems() == 0) {
//            intersectBagSize = 1;
        } else if (this.numItems() <= other.numItems()) {
            intersectBagSize = this.numItems();
        } else {
            intersectBagSize = other.numItems();
        }

        ArrayBag intersectBag = new ArrayBag(intersectBagSize);

        for (int i = 0; i < this.numItems(); i++) {
            if (other.contains(this.items[i])) {
                if (intersectBag.contains(this.items[i])) {
                    // do nothing
                } else {
                    intersectBag.add(this.items[i]);
                }
            }
        }

        return intersectBag;
    }

    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        int test_cond = 1;
        if (test_cond == 0) {


            Scanner scan = new Scanner(System.in);

            // Create an ArrayBag named bag1.
            System.out.print("size of bag 1: ");
            int size = scan.nextInt();
            ArrayBag bag1 = new ArrayBag(size);
            scan.nextLine();    // consume the rest of the line

            // Read in strings, add them to bag1, and print out bag1.
            String itemStr;
            for (int i = 0; i < size; i++) {
                System.out.print("item " + i + ": ");
                itemStr = scan.nextLine();
                bag1.add(itemStr);
            }
            System.out.println("bag 1 = " + bag1);
            System.out.println();

            // Select a random item and print it.
            Object item = bag1.grab();
            System.out.println("grabbed " + item);
            System.out.println();

            // Iterate over the objects in bag1, printing them one per
            // line.
            Object[] items = bag1.toArray();
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
            System.out.println();

            // Get an item to remove from bag1, remove it, and reprint the bag.
            System.out.print("item to remove: ");
            itemStr = scan.nextLine();
            if (bag1.contains(itemStr)) {
                bag1.remove(itemStr);
            }
            System.out.println("bag 1 = " + bag1);
            System.out.println();

            System.out.print("bag increase size:");
            int capacityStr = scan.nextInt();
            System.out.println("bag 1 old capacity = " + bag1.bagSize());
            bag1.increaseCapacity(capacityStr);
            System.out.println("bag 1 new capacity = " + bag1.bagSize());

            ArrayBag bag2 = new ArrayBag(10);
            for (int i = 10; i < 10 + bag2.bagSize(); i++) {
                bag2.add(i);
            }
            System.out.println("bag 2 = " + bag2);

            //        bag1.addItems(bag2);
            System.out.println("added bag2 to bag1 = " + bag1.addItems(bag2));
            System.out.println("adding bag2 to bag1 = " + bag1);

            // intersect bags
            ArrayBag iBag = bag1.intersectionWith(bag2);
            System.out.println("the intersection bag is now = " + iBag);
            System.out.println("the intersection bag has size = " + iBag.bagSize());

            scan.close();
        } else {
            ArrayBag bag3 = new ArrayBag();
            ArrayBag bag4 = new ArrayBag();
            for (int j = 0; j < 20; j++) {
                bag3.add(j);
                bag3.add(j);
                if (j < 8) {bag4.add(2 * j); bag4.add(2 * j);}
            }

            ArrayBag iBag2 = bag3.intersectionWith(bag4);
            System.out.println("bag3 = " + bag3);
            System.out.println("bag4 = " + bag4);
            System.out.println("the intersection bag is now = " + iBag2);
            System.out.println("the intersection bag has size = " + iBag2.bagSize());


        }
    }
}
