# Q01: What are the differences between Array and ArrayList in Java

# A01: 
- Array serves as a container that holds the constant number of values of the same type. 
  - It has a contiguous memory location. 
  - Once an array is created, we cannot change its size. 
  - can store both `objects` and `primitives` type
  - cannot use generics (not type-safe)
  - We can create an array by using the following statement:
   `int array[]=new int[size];`
  - When we try to add more than its size, it throws ArrayIndexOutOfBoundsException. 
  - performs faster in comparison to ArrayList because of fixed size
  - can be multi-dimensional
- ArrayList is a class of Collection framework.
  - ArrayList is internally backed by the array in Java. 
  - it is dynamic (can be resized when needed)
    - it doesn't have length() method
    - size() method provides the number of objects available in the collection
  - it is always single-dimensional
  - The resize operation in ArrayList slows down the performance as it involves new array and copying content from an old array to a new array. 
  - We cannot store primitive type in ArrayList
  - We can store only objects.
  - Type-safe due to storing Generics
  - It automatically converts primitive type to object. For example:
  ```
  ArrayList <Integer> list = new ArrayList<>();  //object of ArrayList  
  list.add(12); // The JVM converts it into Integer object through auto-boxing.
  ```
# Q02: What are the similarities between Array and ArrayList in Java

# A02:
- Array and ArrayList both are used for storing elements.
- Array and ArrayList both can store null values.
- They can have duplicate values.
- They do not preserve the order of elements.

# Q03: Can an ArrayList contain duplicates? If so, how can we remove them?

# A03: 
There are two ways to remove duplicates from the ArrayList (as in: with use of Collection Framework).

Using HashSet: By using HashSet we can remove the duplicate element from the ArrayList, but it will not then preserve the insertion order.
Using LinkedHashSet: We can also maintain the insertion order by using LinkedHashSet instead of HashSet.
The Process to remove duplicate elements from ArrayList using the LinkedHashSet:

- Copy all the elements of ArrayList to LinkedHashSet.
- Empty the ArrayList using clear() method, which will remove all the elements from the list.
- Now copy all the elements of LinkedHashset to ArrayList.

# Q04: Describe a Real-World scenario where you'd use ArrayList

# A04:
from tasks such as storing a list of names, grocery list, or keeping information about train cars (nice example!) to more complex tasks such as representing a graph.





