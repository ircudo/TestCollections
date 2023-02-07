import java.util.*;

public class Ex3_Stack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        // check if it is empty
        System.out.println("Is stack empty? " + stk.empty());

        // push
        stk.push(4);
        stk.push(14);
        stk.push(16);
        stk.push(5);
        System.out.println(stk);

        // pop - returns object at the top of the stack
        int x = stk.pop();
        System.out.println(x);

        // peek - ... returns object at the top of the stack (not removing it)
        int y = stk.peek();
        System.out.println(y);

        // search - searches the object in the stack from the top
        int location = stk.search(4);
        System.out.println(stk + " size: " + stk.size());
        System.out.println("location: " + location);

        // iterate elements
            // iterator()
            // forEach()
            // listIterator
        stk.forEach(n -> System.out.println(n));

        // pop or peek on empty stack - EmptyStackException

        stk.pop();
        System.out.println(stk);
        stk.pop();
        stk.pop();
        System.out.println(stk);
        stk.peek();


    }
}
