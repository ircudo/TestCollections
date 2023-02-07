import java.util.*;

public class Ex5_ArrayDeque {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("Adam");
        deque.add("Bob");
        deque.add("Cindy");
        deque.add("Victor");
        System.out.println(deque);

        // offer - inserts the specified element at the tail
        deque.offer("Andy");
        System.out.println(deque);
        deque.offerFirst("Sandy");
        System.out.println(deque);

        // pollFirst == poll
        deque.poll();

        // pollLast
        deque.pollLast();
        System.out.println(deque);
    }
}
