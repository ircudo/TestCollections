# Q01: What happens when you compile and run the below program?

```
    public static void main(String[] args) {

        List<Integer> list = List.of(2,10,3);
        List<Integer> newList = new ArrayList<>(list);

        newList.set(0, 3);
        newList.add(1);

        System.out.println(newList);
        list.set(0, 3);
        System.out.println(list);
    }
```

Output :
[3, 10 ,3, 1], followed by exception

'list' returns a fixed-size list backed by the specified array. Therefore, it can't grow.
So, when add() is called, an exception is thrown.

# Q02: What happens when you compile and run the below program?
```   
 public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();

        newList.add(10);
        newList.add(10);

        newList.remove(10);
        System.out.println(newList);
    }
```

Output: IndexOutOfBoundsException
We added two elements. The size of the list is 2. We now trying to remove element at index 10. 

# Q03: What happens when you compile and run the below program?
```
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        pQueue.add("Apple");
        pQueue.add("Nokia");
        pQueue.add("Samsung");
        pQueue.add("Apple");

       System.out.print(pQueue.poll() + " " + pQueue.poll());
       System.out.print(" " + pQueue.peek() + " " + pQueue.poll());
```
Output:
“Apple Apple Nokia Nokia”

PriorityQueue keeps elements sorted and it can have duplicates.

add() and offer() methods both offer same functionality.

poll() method removes the first element in queue and returns it, while peek() method returns the first element without removing it.

# Q04: What happens when you compile and run the below program? Assume that 'Student' class has 'int id' and the constructor (nothing else)
```
        Set<Student> students = new HashSet<Student>();

        students.add(new Student(1));
        students.add(new Student(3));
        students.add(new Student(4));
        students.add(new Student(1));
        students.add(new Student(3));

        System.out.println(students.size());
```
Output: 5
Since Student doesn't override equals(), there are 5 objects in the HashSet.

# Q05: Predict the output of following program :
```
        Set<Short> set = new HashSet<>();

        for (Short i = 0; i < 10; i++) {
            set.add(i);
            set.remove(i - 1);
        }

        System.out.println(set.size());
```
Output: 10
The set contains Shorts and we are trying to remove integers from it. i-1 is integer.
Try `System.out.println(Short.class.isInstance(i-1));` and `System.out.println(Short.class.isInstance(i));`
Can cast int to short to achieve the expected result: ` set.remove((short)(i-1));`

# Q06: What will be the output of following program ?
```
        ArrayDeque<String> adq = new ArrayDeque<>();

        adq.add("A"); 
        adq.push("B");  
        adq.addFirst("C");  
        adq.offer("D"); 

        System.out.print(adq.peek() + " " + adq.pop() + " " + adq.poll()); 
```
Output: C C B
push() and addFirst() add elements at front of queue and add() and offer() add elements at end of queue.
peek() just retrieves the element, does not remove it.
pop() and poll() remove from front of queue.
So, it goes like this:
```
        adq.add("A");  // A
        adq.push("B");  // BA
        adq.addFirst("C");  // CBA
        adq.offer("D"); // CBAD

        System.out.print(adq.peek() + " " + adq.pop() + " " + adq.poll()); // CCB
```

# Q07: What will be the output of following program ?
```
        List<String> ll = new LinkedList<>();

        ll.add("C");
        ll.push("B");
        ll.addFirst("A");
        ll.offer("D");

        System.out.print(ll.remove() + " ");

        System.out.print(ll.poll());
```
Output
Compilation error


Methods offer(), push(), addFirst(), poll(),remove() are available to LinkedList since it implements Deque along with List interface.
List interface doesn't define these methods.

Without an explicit cast, a reference variable of an interface can only access the variables and methods defined in the interface.

# Q08: What will be the output of following program ?
```
        List<String> countries = new ArrayList<>();

        countries.addAll(Arrays.asList("Australia","Canada","India","USA"));
        countries.remove(new String("USA"));

        System.out.print(countries.size());

        List<Student> sList = new ArrayList<>();

        sList.add(new Student(1,"A"));
        sList.add(new Student(1,"B"));
        sList.add(new Student(1,"C"));

        sList.remove(new Student(1,"A"));

        System.out.print(sList.size());
```
Output: 33
remove() method in ArrayList uses equals() method to find element for removing.
String class overrides equals() method and strings are compared based on values.
But the custom Student class does not override equals() and default equals() method compares elements are compared by reference.
Hence, the string will be removed from countries list, but student will not be removed from sList.

# Q09: Write a program to convert HashSet to Array
```
        HashSet<String> hashset = new HashSet<>();

        hashset.add("Doctor");
        hashset.add("Engineer");
        hashset.add("Lawyer");
        hashset.add("Police");

        System.out.println("HashSet contains: "+ hashset);

        String[] array = new String[hashset.size()];

        hashset.toArray(array);
        System.out.println("Array contains: ");
        for (String str : array) {
            System.out.println(str);
        }
```