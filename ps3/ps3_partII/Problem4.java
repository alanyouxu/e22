public class Problem4 {

    public static boolean containsStack(Stack<Object> stack, Object item) {
        
        LLStack<Object> orig = new LLStack<Object>();
        // we don't know how big the original stack is

        if (stack.isEmpty()) { // base case, so we can assign curr
            return false;
        }
        
        // do one iteration first so java doesn't get mad about unassigned curr
        Object curr = stack.pop();
        orig.push(curr);

        //  pull items out until we (potentially) find the correct one
        while (!stack.isEmpty() && (curr != item)) {
            curr = stack.pop();
            orig.push(curr);
        }

        // put everything back
        while (!orig.isEmpty()) {
            stack.push(orig.pop());
        }

        if (curr == item) {
            return true;
        } 
        return false;
    }

    public static boolean containsQueue(Queue<Object> queue, Object item) {

        LLQueue<Object> orig = new LLQueue<Object>();

        return false;
    }


    public static void main(String[] args) {

        // ArrayStack<Object> alan = new ArrayStack<Object>(10);
        // alan.push("abc");
        // alan.push("def");
        // alan.push("ghi");

        // Integer x = 55;

        // System.out.println(containsStack(alan, x));

        // while (!alan.isEmpty()) {
        //     System.out.println(alan.pop());
        // }

    }
}