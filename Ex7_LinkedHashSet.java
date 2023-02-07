import java.util.*;

public class Ex7_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        System.out.println(set);

        // remove returns true if element present
        System.out.println(set.remove("ccc"));
        System.out.println(set + ", " + set.size());
        System.out.println(set.remove("zzz"));

        //The Process to remove duplicate elements from ArrayList using the LinkedHashSet:
//
//        1. Copy all the elements of ArrayList to LinkedHashSet.
//        2. Empty the ArrayList using clear() method, which will remove all the elements from the list.
//        3. Now copy all the elements of LinkedHashset to ArrayList.
        List<Integer> intList = new ArrayList<>();
        intList.add(11);
        intList.add(3);
        intList.add(5);
        intList.add(11);
        System.out.println(intList);
        LinkedHashSet<Integer> removedDupes = new LinkedHashSet<>(intList);
        intList.clear();
        intList.addAll(removedDupes);
        System.out.println(intList);
    }
}
