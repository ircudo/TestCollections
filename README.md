# Java Collections Deep Dive

## What is Collection?

- A collection is an object that groups multiple elements into a single unit. 
- Collections are used to store, retrieve, and manipulate data. 

### Collection examples:
![image](https://user-images.githubusercontent.com/49169084/216084556-6beba017-e2bd-44b9-918f-1d7edc7a8666.png)

## Collections Framework (since Java 1.2)

**Unified architecture for representing and manipulating collections in a standard way**

**Contains:** *
- Interfaces (abstract data types that represent collections)
- Implementations (concrete implementations of the collection interfaces)
- Algorithms (the methods that perform useful computations, e.g., searching and sorting)

* (Remember, the famous formula in programming? **Data Structures + Algerithms = Programs**)

**Some benefits:**
- Reduces programming effort 
- Increases program speed and quality
- Fosters software reuse 

### Interfaces
- Collection is the [base interface](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
- The core collection interfaces encapsulate different types of collections:
![image](https://user-images.githubusercontent.com/49169084/215830170-18870bcc-ba3f-4c7c-807c-245eb8255c91.png)
Note that the Map is the only interface that doesn’t inherit from the Collection interface but it’s part of the Collections framework.

#### In the figure above:
**Collection** — the root of the collection hierarchy. The Java platform doesn't provide any direct implementations of this interface but provides implementations of more specific subinterfaces, such as **Set** and **List**.
- **Set** — a collection that cannot contain duplicate elements. Example: the cards comprising a poker hand
- **List** - an ordered collection. Lists can contain duplicate elements. Example: A book library, a music records collection
- **Queue** — a collection used to hold multiple elements prior to processing. Queues typically, but not necessarily, order elements in a FIFO (first-in, first-out) manner.
- **Deque** - (short for double-ended queue) a linear collection used to hold multiple elements prior to processing. Deques can be used both as FIFO (first-in, first-out) and LIFO (last-in, first-out).
- **Map** — an object that maps keys to values. A Map cannot contain duplicate keys; each key can map to at most one value.

Note that all the core collection interfaces are generic. For example, this is the declaration of the Collection interface.
```
public interface Collection<E>...
```
The <E> syntax tells you that the interface is generic. When you declare a Collection instance you can and should specify the type of object contained in the collection.

**A more detailed diagram of Collection Hierarchy**
![image](https://user-images.githubusercontent.com/49169084/215841442-f327906c-79e9-459c-bbcd-49c2517d5907.png)

#### Methods of Iterable interface (root of all collection classes)
Iterable interface provides the facility of iterating the elements in a forward direction only.
There are three methods:
```
public boolean hasNext()	// returns true if the iterator has more elements otherwise it returns false. 
public Object next()	// returns the element and moves the cursor pointer to the next element. 
public void remove()	// removes the last elements returned by the iterator. It is less used.  
```
  
#### Methods of Collection (root) interface
There are many methods declared in the Collection interface.
Here are a few of them:
```
public boolean add(E e)  // used to insert an element into the collection
public boolean remove(Object element) // used to delete an element from the collection
public int size() // returns the total number of elements in the collection
public boolean contains(Object element) // used to search an element
public Object[] toArray() // converts collection into array
public boolean equals(Object element) // matches two collections
public int hashCode() // returns the hashcode number of the collection
```
The Collection interface extends the Iterable interface and therefore all the subclasses of Collection interface also implement the Iterable interface.

**Collection Interface Bulk Operations**
- Perform operations on an etire Collection.
```  
containsAll — returns true if the target Collection contains all of the elements in the specified Collection.
addAll — adds all of the elements in the specified Collection to the target Collection.
removeAll — removes from the target Collection all of its elements that are also contained in the specified Collection.
retainAll — removes from the target Collection all its elements that are not also contained in the specified Collection. That is, it retains only those elements in the target Collection that are also contained in the specified Collection.
clear — removes all elements from the Collection.
```  

#### List Interface
List interface is the child interface of Collection interface. 
List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack.

To instantiate the List interface, we must use:  
```
List <data-type> list1= new ArrayList();  
List <data-type> list2 = new LinkedList();  
List <data-type> list3 = new Vector();  
List <data-type> list4 = new Stack();  
```
There are various methods in List interface that can be used to insert, delete, and access the elements from the list.
##### List Interface Implementations
- ArrayList
  - uses a dynamic array to store [possible duplicate] element of different data types. 
  - maintains the insertion order and is non-synchronized. 
  - the elements can be randomly accessed.
  - has a `capacity`. It is always at least as large as the list size. As elements are added to an ArrayList, its capacity grows automatically. 
  
  ![image](https://user-images.githubusercontent.com/49169084/216713897-b5b7c588-5855-4eec-8225-65aaaecb71ac.png)
  
  _ArrayList example -->_
- LinkedList
  - uses a doubly linked list internally to store the elements. 
    - we can add and remove elements from both sides
  - can store the duplicate elements. 
  - maintains the insertion order 
  - not synchronized. 
  - manipulation is fast because no shifting is required.
  - LinkedList can be used as a list, stack, or queue. 
   _LinkedList example -->_
  
  ![image](https://user-images.githubusercontent.com/49169084/216714341-faca4d73-f9e3-440c-a3bf-edc7f51d2565.png)
  
      - Points to remember:
        - Use ArrayList when the frequency of the read scenarios is higher than addition/removal
        - Use LinkedList when the frequency of addition/removal is higher than read scenarios 
        - Memory overhead is higher in the LinkedList compared to ArrayList (because LinkedList has two extra links - next and previous). 
- Vector 
  - uses a dynamic array to store the data elements. 
  - It is similar to ArrayList. However, it is synchronized and contains many methods that are not the part of Collection framework. [see here](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Vector.html)
  - It is recommended to use the Vector class in the thread-safe implementation only. If you don't need to use the thread-safe implementation, you should use the ArrayList.
 
  ![image](https://user-images.githubusercontent.com/49169084/216714867-07a0a205-0ec7-4524-b2e4-afa132ad0ca9.png)

  (Vector is synchronized, which means only one thread at a time can access the code, while ArrayList is not synchronized, which means multiple threads can work on ArrayList at the same time.)
- Stack
  - The stack is the subclass of Vector. 
  - implements the LIFO (last-in-first-out) data structure (therefore "stack"). 
  - has two most important operations - push and pop. 
  ![image](https://user-images.githubusercontent.com/49169084/216395242-9fc40f1a-664e-465c-80ec-0613ad63188a.png)
  - If the stack has no elements it is known as 'empty stack'. When the stack is empty, the value of the top 'element' is -1. 
  
  ![image](https://user-images.githubusercontent.com/49169084/216396196-297f9149-03bf-4af5-b6b4-6b817902b15c.png)
 - _Stack example -->_
  
##### Queue Interface Implementations 
  - maintains the FIFO (first-in-first-out) order. 
  - can be defined as an ordered list that is used to hold the elements which are about to be processed. 
  - There are [various classes](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html) like PriorityQueue, Deque, and ArrayDeque which implement the Queue interface.
- PriorityQueue
  - implements the Queue interface. 
  - holds the elements or objects which are to be processed by their priorities. 
  - PriorityQueue doesn't allow null values to be stored in the queue.
  - _PriorityQueue example -->_
  ![image](https://user-images.githubusercontent.com/49169084/216716361-3f4cef95-0ef2-4c95-869c-3cb49caf200c.png)

- Deque
  - extends the Queue interface.
  - Deque stands for a double-ended queue which enables us to perform the operations at both the ends (elements can be removed and added on both sides) => therefore can be used as a stack or a queue. 
  - => therefore either of the mentioned operations [can be performed on Deque](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Deque.html). 
  
  ![image](https://user-images.githubusercontent.com/49169084/216716723-3671f611-b8a2-4633-bd24-68bf9ea8cb18.png)
  
- [ArrayDeque](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/ArrayDeque.html)
  - implements the Deque interface. 
  - unlike queue, we can add or delete the elements from both the ends.
  - null elements are not allowed
  - has no capasity restrictions
  - is faster than LinkedList and Stack
  
  ![image](https://user-images.githubusercontent.com/49169084/216718241-219aa6e4-0ad2-4c0d-9214-89b6c833b31f.png)

  - _ArrayDeque example -->_
  
##### Set Interface Implementations
Set represents unordered set of elements which doesn't allow for duplicate items. 
We can store at most one null value in Set.
  
**Set Interface Bulk Operations**
```
s1.containsAll(s2) — returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1 contains all of the elements in s2.)
s1.addAll(s2) — transforms s1 into the union of s1 and s2. (The union of two sets is the set containing all of the elements contained in either set.)
s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. (The intersection of two sets is the set containing only the elements common to both sets.)
s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. (For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2.)
```
  
- [HashSet](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/HashSet.html)
  - stores the elements by using hashing mechanism. 
  - allows null value. 
  - contains unique items only.
  - doesn't maintain insertion order, elements are inserted on the basis of their hashcode. 
  - HashSet is the best approach for search operations. 
  - the initial default capacity is 16 (with the [load factor of 0.75](https://www.geeksforgeeks.org/load-factor-in-hashmap-in-java-with-examples/))  
    - (If initial capacity is 16 and the load factor is 0.75 then the number of buckets will automatically get increased when the stack has 12 elements in it.)
  - non synchronized.
  - ![image](https://user-images.githubusercontent.com/49169084/216722937-9e96025a-d27b-4a65-8bbb-291084cbbd49.png)
  
  - _HashSet example -->_
  
- LinkedHashSet
  - extends the HashSet class and implements Set interface. 
  - like HashSet, it also contains unique elements. 
  - maintains the insertion order. 
  - allows null elements.
  - non syschronized.  
  - _LinkedHashSet example -->_
- SortedSet   
  - is the alternate of Set interface that provides a total ordering on its elements. 
  - The elements of the SortedSet are arranged in the ascending order. 
  - The SortedSet provides the additional methods that inhibit the natural ordering of the elements.
- TreeSet
  - implements the Set interface that uses a tree for storage. 
  - Like HashSet, TreeSet also contains unique elements. However, the access and retrieval time of TreeSet is faster. 
  - The elements in TreeSet stored in ascending order.
  - it does not allow null elements.
  - non synchrinized.
  - allows only those Generic types that are comparable. (For example, the Comparable interface is being implemented by StringBuffer class)
  ![image](https://user-images.githubusercontent.com/49169084/216723539-ce598bad-4906-4396-9191-593f37a6f951.png)
  - _TreeSet example -->_

**More detailed diagram of Map Hierarchy**
  
![image](https://user-images.githubusercontent.com/49169084/215879594-52928aed-fb46-44da-adb1-8d6ecb25519e.png)
- A map = key/value pair. 
- Each key and value pair is known as an entry. 
- A Map contains unique keys (but you can have duplicate values). 
- A Map can't be traversed, so you need to convert it into Set using keySet() or entrySet() method.  

##### Map Interface Implementations
- HashMap 
- LinkedHashMap
- TreeMap

##### Useful Methods of Map Interface
  ```
  V put(Object key, Object value)	// used to insert an entry into the map.
  void putAll(Map map)	// used to insert the specified map into the map.
  V remove(Object key)	// used to delete an entry for the specified key.
  boolean remove(Object key, Object value)	// removes the specified values with the associated specified keys from the map.
  Set keySet()	// returns the Set view containing all the keys.
  Set<Map.Entry<K,V>> entrySet()	// returns the Set view containing all the keys and values.
  boolean containsValue(Object value)	// returns true if some value equal to the value exists within the map, else return false.
  boolean containsKey(Object key)	// returns true if some key equal to the key exists within the map, else return false.
  void forEach(BiConsumer<? super K,? super V> action)	// performs given action for each entry in the map.
  V get(Object key)	// returns the object that contains the value associated with the key.
  boolean isEmpty()	// returns true if the map is empty; returns false if it contains at least one key.
  V replace(K key, V value)	// replaces the specified value for a specified key.
  Collection values()	It returns a collection view of the values contained in the map.
  ```

##### Useful Methods of Map.Entry Interface
[Entry](https://docs.oracle.com/javase/8/docs/api/java/util/Map.Entry.html) is the subinterface of Map. 
- It returns a collection-view of the map. 
- It provides methods to get key and value.
```
K getKey()	// used to obtain key.
V getValue()	// used to obtain value.
V setValue(V value)	// used to replace the value corresponding to this entry with the specified value.
static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey()	// returns a comparator that compare the objects in natural order on key.
static <K,V> Comparator<Map.Entry<K,V>> comparingByKey(Comparator<? super K> cmp)	// returns a comparator that compare the objects by key using the given Comparator.
static <K,V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue()	// returns a comparator that compare the objects in natural order on value.
static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp)	// returns a comparator that compare the objects by value using the given Comparator.
```

#### HashMap
- contains values based on the key.
- contains only unique keys.
- doesn't maintain any order.
- allow one null key and multiple null values
- the initial capasity is 16 with a load factor of 0.75.
- If you try to insert the duplicate key, it will replace the element of the corresponding key. 
- Since Java 5, it is denoted as HashMap<K,V>, where K stands for key and V for value.

##### Useful Methods of HashMap class
```
Set entrySet()	// used to return a collection view of the mappings contained in this map.
Set keySet() // used to return a set view of the keys contained in this map.
V put(Object key, Object value)	// used to insert an entry in the map.
void putAll(Map map)	// used to insert the specified map in the map.
V remove(Object key)	// used to delete an entry for the specified key.
boolean remove(Object key, Object value)	// removes the specified values with the associated specified keys from the map.
boolean containsValue(Object value)	// returns true if some value equal to the value exists within the map, else return false.
boolean containsKey(Object key)	// returns true if some key equal to the key exists within the map, else return false.
V get(Object key)	// returns the object that contains the value associated with the key.
V replace(K key, V value)	// replaces the specified value for a specified key.
boolean replace(K key, V oldValue, V newValue)	// replaces the old value with the new value for a specified key.
```
![image](https://user-images.githubusercontent.com/49169084/216724641-67dd65fe-7219-4c09-a4db-a9271717ef16.png)

_HashMap examples -->_

** HashMap vs. HashSet
- HashSet contains only values whereas HashMap contains an entry(key and value).

#### How HashMap Works
**Hashing** - the process of converting an object into an integer value. The integer value helps in indexing and faster searches.
- HashMap contains an array of the nodes, and the node is represented as a class
- Internally it uses an array and LinkedList data structure for storing Key and Value. There are four fields in HashMap:

![image](https://user-images.githubusercontent.com/49169084/215909755-b10e2f41-d84c-421f-a968-d8aa88c870e5.png)

[more details on inner workings of HashMap here](https://www.javaquery.com/2019/11/how-hashmap-works-internally-in-java.html).

#### LinkedHashMap
* The LinkedHashMap is quite similar to HashMap, with an additional feature of maintaining the order of the inserted element.
 - Go for a LinkedHashMap if iteration order is important 
 - And don't go for it if iretation order is not important. Because of ordering feature LinkedHashMap requires more memory (it uses doubly LinkedList to keep order of elements)

![image](https://user-images.githubusercontent.com/49169084/216725027-38d8f0ca-dbc1-4a67-bd1e-b3f3ebfc1b65.png)

#### TreeMap
* The TreeMap is similar to HashMap. 
* The differences
  - it is sorted according the natural order of items (maintains ascending order)
  - doesn't allow a null key (but just like HashMap may contain many null values).
  - can save memory (in comparison to HashMap) because it only uses the amount of memory needed to hold its items, unlike a HashMap which uses contiguous region of memory
 - In general, go for a TreeMap whenever:
    - memory limitations must be taken into consideration
    - if we want to extract objects in a natural order
    - if items will be consistently added and removed

![image](https://user-images.githubusercontent.com/49169084/216725545-8034b6fe-61b6-4b19-b7f4-20ef5611ae88.png)






  


  





