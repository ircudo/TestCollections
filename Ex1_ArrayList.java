import java.util.*;
import java.util.stream.*;

public class Ex1_ArrayList {
    public static void main(String[] args) {
    // Remember, we use Generics with Collections

        // We cannot create Collection with primitive types
        //    List<int> al = new ArrayList<>(); ==> won't work
    List<Integer> intList = new ArrayList<>();
    intList.add(11);
    intList.add(3);
    intList.add(5);
    intList.add(14);

    // Since Java 9 we can create a List collection from a fixed set of elements:
        List<Integer> numList = List.of(1,2,3,4,5,6,7);
        // note that in this case numList is immutable - you can't add more elements to it

    // It is also possible to construct a list that takes elements from an existing collection
    List<Integer> intList1 = new ArrayList<>(intList);
        System.out.println(intList1);

     List<String> list = new ArrayList<>();
     list.add("Grapes");
     list.add("Apple");
     // add at specified index:
     list.add(1, "Banana");

    System.out.println(list);

     // Iterating ArrayList with Iterator
     Iterator itr = list.iterator();
     while (itr.hasNext()) {
        System.out.println(itr.next());
     }

     // Iterator traverses the elements in the forward direction only
        // whereas ListIterator traverses the elements into forward and backward direction.

        // Iterating with ListIterator in reverse order
     ListIterator<String> litr = list.listIterator(list.size());
     while (litr.hasPrevious()) {
         String str = litr.previous() + "--";
         System.out.println(str);
     }

     // Iterating ArrayList with For-each loop
     for (String fruit: list) {
         System.out.println(fruit);
     }

     // using forEach with lambda
        list.forEach(a -> System.out.println(a));

     // get() returns element at specified index
        System.out.println("Returning 2nd element: " + list.get(1));
     // set() changes the element
     list.set(2, "Mango");
        System.out.println(list);

     // remove
     list.remove("Mango");
     System.out.println(list);

     // sort list using utility 'Collections'
     Collections.sort(list);
        System.out.println(list);

     // int arrayList sort
        System.out.println(intList);
        Collections.sort(intList);
        System.out.println(intList);

    // sort in reverse order
    Collections.sort(intList, Collections.reverseOrder());
        System.out.println(intList);

        // OR: use reverse()
        Collections.reverse(intList);
        System.out.println("After reversing: " + intList);

     // using user-defined (custom) class objects
     // ==> create Student object
     Student s1 = new Student(101, "Alice");
     Student s2 = new Student(102, "Bob");
     Student s3 = new Student(103, "Charlie");
     Student s4 = new Student(104, "Dan");

     List<Student> all = new ArrayList<>();
     all.add(s1);
     all.add(s2);
     all.add(s3);
     all.add(s4);
     // traverse 'all' using one of the methods above
     all.forEach(s -> System.out.println(s.toString()));

        // update element
        all.set(1, new Student(102, "Melissa"));
        System.out.println(all);

        // remove elements
        System.out.println("Student list size before removal: " + all.size());
        all.remove(s3);
        System.out.println("Student list size after removal: " + all.size());
        System.out.println(all);
        if (all.remove(s3)) {  // s2 is already removed
            System.out.println("Removed");
        } else System.out.println("No such element");

    // searching for an element
    if (all.contains(new Student(101, "Alice"))) {
        System.out.println("Found element");
    } else {
        System.out.println("Not found");
    }

    // why "not found"? It compares the specified object with the elements
        // in the listing using their `equals` method.


     // size vs capacity
     List<Integer> newList = new ArrayList<>();
        System.out.println(newList.size());

     List<Integer> newList2 = new ArrayList<>(3);
        System.out.println(newList2.size());
     // note: 3 is 'initial capacity' (default capacity is 10)
     newList2.add(1);
     newList2.add(2);
     newList2.add(3);
        System.out.println(newList2.size());
        newList2.add(4);
        System.out.println(newList2.size());

    // Compare two array lists
    List<Integer> listToCompare = new ArrayList<>();
    listToCompare.add(1);
    listToCompare.add(2);
    listToCompare.add(3);
    listToCompare.add(4);

    boolean areEqual = newList2.equals(listToCompare);
        System.out.println(areEqual);

    // Remove all
//    listToCompare.removeAll(newList2);
//        System.out.println(listToCompare + " isEmpty? = " + listToCompare.isEmpty());

    // Retain all -- returns common elements in both lists
    listToCompare.add(50);
//    listToCompare.retainAll(newList2);
//        System.out.println("Common elements in both lists: " + listToCompare);

        System.out.println(listToCompare);
    // Contains -- checks the presence of an element in list
    for (Integer i : listToCompare) {
        System.out.println((newList2.contains(i) ? "Yes" : "No"));
    }
    // OR - contains the whole list
        System.out.println(listToCompare.containsAll(newList2));

    // Stream Interface
        System.out.println("Common elements: " + listToCompare.stream()
                .filter(newList2::contains).collect(Collectors.toList()));

    // Converting between array and array list
    String[] fruit = list.toArray(new String[list.size()]);
    for (String s : fruit) {
        System.out.println(s);
    }
    // and back:
        List<String> listFromArray = Arrays.asList(fruit);
        System.out.println(listFromArray);

    // can we remove duplicates from array list?
    // jumping a bit ahead, we can do, using Set

        System.out.println(list);
        list.add("Apple");
        System.out.println(list);
        Set<String> noDupes = new HashSet<>(list);
        System.out.println(noDupes);

    // List to Stream
    int sum = intList.stream().reduce(0, (x,y) -> x+y);
        System.out.println(sum);

        System.out.println(list);
        list.removeAll(numList);
        System.out.println(list);

    }
}
