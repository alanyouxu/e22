public class Problem4 {

    public static boolean containsStack(Stack<Object> stack, Object item) {
        
        // use LL as we don't know how big the original stack is
        LLStack<Object> orig = new LLStack<Object>();

        Object curr;
        if (stack == null || item == null || stack.isEmpty()) return false;

        // special case so we don't have to pull out ALL items
        curr = stack.pop();
        orig.push(curr);

        //  pull items out until we (potentially) hit the correct one
        while (!stack.isEmpty() && !item.equals(curr)) {
            curr = stack.pop();
            orig.push(curr);
        }

        // put everything back that we took out
        while (!orig.isEmpty()) {
            stack.push(orig.pop());
        }

        return (item.equals(curr));
    }

    public static boolean containsQueue(Queue<Object> queue, Object item) {

        LLQueue<Object> orig = new LLQueue<Object>(); // don't know how long queue will be

        // same principle as last time
        if (queue == null || item == null || queue.isEmpty()) return false;

        boolean rvalue = false;
        Object curr;


        // here, we need to pull everything out to maintain the same order
        while (!queue.isEmpty()) {
            curr = queue.remove();
            orig.insert(curr);
            if (item.equals(curr)) rvalue = true;
        }
        // put everything back
        while (!orig.isEmpty()) queue.insert(orig.remove());

        return rvalue;
    }


    public static void main(String[] args) {

        // ArrayStack<Object> alan = new ArrayStack<Object>(10);
        // alan.push(new String("abc"));
        // alan.push(new String("def"));
        // alan.push(new String("ghi"));

        // System.out.println(containsStack(alan, "ffpfwc"));

        // while (!alan.isEmpty()) {
        //     System.out.println(alan.pop());
        // }

        ArrayQueue<Object> xu = new ArrayQueue<Object>(10);

        xu.insert(new String("ab"));
        xu.insert(new String("cd"));
        xu.insert(new String("ef"));
        xu.insert(new String("gh"));

        // while (!xu.isEmpty()) System.out.println(xu.remove());

        System.out.println(containsQueue(xu, "a b"));

        while (!xu.isEmpty()) System.out.println(xu.remove());

    }
}