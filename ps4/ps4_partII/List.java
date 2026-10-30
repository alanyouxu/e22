/*
 * List.java
 * 
 * Computer Science E-22/S-22
 */

/*
 * An interface that defines a simple ADT for a list of objects
 * of any type.
 */
public interface List {
    /* returns the item at position i in the list */
    Object getItem(int i);

    /* 
     * adds the specified item at position i in the list,
     * shifting the items that are currently in positions i, i+1,
     * i+2, etc. to the right by one. Returns false if the list
     * is full, and true otherwise.
     *
     * item cannot be null.
     * i must be >= 0 and <= length of list.
     */
    boolean addItem(Object item, int i);

    /* 
     * removes the item at position i in the list, reducing the
     * indices of the items that are currently in positions i+1,
     * i+2, etc. by 1 in the abstract list. Returns a reference
     * to the removed object.
     * 
     * i must be >= 0 and <= length of list.
     */
    Object removeItem(int i);

    /* returns the number of items in the list */
    int length();

    /* returns true if the list is full, and false otherwise */
    boolean isFull();

    /* returns an iterator object for this list. */
    ListIterator iterator();
}
