import java.util.*;

public class Ex8_TreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        System.out.println(set);

        System.out.println("Reverse set: " + set.descendingSet());
        System.out.println("Head Set: " + set.headSet("ccc")); // returns the "head" - the elements less than the specified
        System.out.println("Sub Set: " + set.subSet("bbb", true, "ddd", false));
        System.out.println("Tail Set: " + set.tailSet("ccc"));

        // higher - lower
        String strToCompare = "bcd";
        System.out.println("Higher: " + set.higher(strToCompare));
        System.out.println("Lower: " + set.lower(strToCompare));

    }
}
