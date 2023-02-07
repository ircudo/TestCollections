import java.util.*;

public class Ex2_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Cindy");
        names.add("Dan");

        Iterator<String> itr = names.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // adding element at a specific position
        names.add(1, "Garry");
        System.out.println(names);

        // make new names list
        List<String> names2 = new LinkedList<>();
        names2.add("Gideon");
        names2.add("Jane");

        // add second list to the first
        names.addAll(names2);
        System.out.println(names);

        // make third list of names
        List<String> names3 = new LinkedList<>();
        names3.add("John");
        names3.add("Ellen");

        // add third list to the first at a specific position
        names.addAll(3, names3);
        System.out.println(names);

        // add element at first position
        names.addFirst("Lynn");
        names.addLast("Kate");
        System.out.println(names);

        // removing elements
        names.remove("Bob"); // based on element name
        names.remove(0);   // based on element position
        System.out.println(names);

        // removing a list from the list
        names.removeAll(names3);
        System.out.println(names);

        // removing first and last
        names.removeFirst();
        System.out.println(names);

        names.add("Dan");
        names.add("Cindy");
        System.out.println(names);
        names.removeFirstOccurrence("Dan");
        names.removeLastOccurrence("Cindy");
        System.out.println(names);

        // reverse list
        itr = names.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // traverse objects
        Student s1 = new Student(101, "Sam");
        Student s2 = new Student(102, "Pat");
        Student s3 = new Student(103, "Tim");

        List<Student> students = new LinkedList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}
