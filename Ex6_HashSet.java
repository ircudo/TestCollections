import java.util.*;

public class Ex6_HashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        System.out.println(set);

        // remove
        set.remove("ccc");
        System.out.println(set);

        // remove if
        set.removeIf(str -> str.contains("b"));
        System.out.println(set);

        // HashSet storing ArrayLists
        HashSet<ArrayList> setL = new HashSet<>();
        ArrayList<Integer> li1 = new ArrayList<>();
        ArrayList<Integer> li2 = new ArrayList<>();
        li1.add(1);
        li1.add(2);
        li2.add(10);
        li2.add(20);
        setL.add(li1);
        setL.add(li2);
        System.out.println(setL);
        // if we change li2 to [1,2] it won't add li2
            // since set doesn't allow for duplicates

        // Remove duplicates from array list
        List<Integer> intList = new ArrayList<>();
        intList.add(11);
        intList.add(3);
        intList.add(5);
        intList.add(11);
        System.out.println(intList);
        Set<Integer> noDupes = new HashSet<>(intList);
        System.out.println(noDupes);

    }
}
