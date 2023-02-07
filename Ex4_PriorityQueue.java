import java.util.*;

public class Ex4_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(60);
        pq.add(80);
        pq.add(100);

        // peek
        System.out.println("Head: " + pq.element());
        System.out.println("Head (peek): " + pq.peek());

        // remove
        // if Queue is empty it throws an exception NoSuchElementFoundException
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);

        // poll - retrieve and remove the head element
        // if queue is empty it returns null, doesn't throw an exception
        pq.poll();
        System.out.println(pq);
    }

}
