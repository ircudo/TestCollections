# Q01: Describe Map and its characteristics 

- Because a Map is not a true collection, its characteristics and behaviors are different than the other collections like List or Set.
- A Map cannot contain duplicate keys and each key can map to at most one value. 
- Some implementations allow null key and null value (HashMap and LinkedHashMap) but some do not (TreeMap).
- The order of a map depends on specific implementations, e.g TreeMap and LinkedHashMap have predictable order, while HashMap does not.

# Q02: What is the difference between List and Set?

The List can contain duplicate elements whereas Set includes unique items.
The List is an ordered collection which maintains the insertion order whereas Set is an unordered collection which does not preserve the insertion order.
The List interface contains a single legacy class which is Vector class whereas Set interface does not have any legacy class.
The List interface can allow n number of null values whereas Set interface only allows a single null value.

# Q03: What is the difference between Set and Map?
Set contains values only whereas Map contains key and values both.
Set contains unique values whereas Map can contain unique Keys with duplicate values.
Set holds a single number of null value whereas Map can include a single null key with n number of null values.

# Q04: Why we override equals() method?
The equals method is used to check whether two objects are the same or not. 
It needs to be overridden if we want to check the objects based on the property.

For example, Employee is a class that has 3 data members: id, name, and salary. 
However, we want to check the equality of employee object by the salary. 
Then, we need to override the equals() method.

# Q05: How to iterate map?
The developer cannot directly iterate map, but, this interface has two methods that gives view set of map. 
These methods are:

* Set<Map.Entry<K, V>>entrySet(): It is a method that returns a set having the entries mention in the map. 
These entries are generally objected, which has type Map. Entry.
* Set<K>keySet(): This Java method returns a set that having the map key.

# Q06: How to decide between HashMap and TreeMap?
For inserting, deleting, and locating elements in a Map, the HashMap offers the best alternative. 
If, however, you need to traverse the keys in a sorted order, then TreeMap is your better alternative. 
Depending upon the size of your collection, it may be faster to add elements to a HashMap, then convert the map to a TreeMap for sorted key traversal.

# Q07: Which collection classes provide random access of its elements?
ArrayList, HashMap, TreeMap, Hashtable, and Vector classes provide random access to its elements. 
See [java collections pdf](https://journaldev.nyc3.digitaloceanspaces.com/2013/01/java-collections-framework.pdf) for more information.

# LinkedList Exercises:
https://leetcode.com/problems/merge-two-sorted-lists/
https://leetcode.com/problems/swap-nodes-in-pairs/


