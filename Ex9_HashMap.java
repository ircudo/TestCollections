import java.util.*;

public class Ex9_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> fruit = new HashMap<>();
        fruit.put(1, "Banana");
        fruit.put(2, "Apple");
        fruit.put(3, "Mango");
        fruit.put(4, "Peach");
        fruit.put(5, null);
        fruit.put(null, "Crazy fruit");
        fruit.putIfAbsent(1, "Grapes");
        fruit.putIfAbsent(10, "Melon");

        // iterate using entrySet
        for (Map.Entry f : fruit.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }

        // iterate using iterator
        Iterator<Map.Entry<Integer, String>> entrySet = fruit.entrySet().iterator();
        while (entrySet.hasNext()) {
            Map.Entry<Integer, String> entry = entrySet.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // another way using iterator
        Iterator keySetIterator = fruit.keySet().iterator();
        while (keySetIterator.hasNext()) {
            Integer key = (Integer) keySetIterator.next();
            System.out.println("--Key: " + key + " Value: " + fruit.get(key));
        }

        // for-each loop with keySet
        Set<Integer> keySet = fruit.keySet();
        for (Integer key : keySet) {
            System.out.println(key + ": " + fruit.get(key));
        }

        // using lambda expressions
        fruit.forEach((k,v) -> System.out.println("|Key: " + k + "|Value: " + v));

        // etc.

        // return only values
        System.out.println(fruit.values());

        // trying to store a duplicate key
        fruit.put(1, "Pear");
        System.out.println(fruit);

        // remove element
        fruit.remove(3); // key-based removal
        System.out.println(fruit);
        fruit.remove(4, "Peach");
        System.out.println(fruit);

        // replace
        fruit.replace(1, "Banana");
        fruit.replace(2, "Apple", "Grapes");
        System.out.println(fruit);

        // compute - apply a function on all mapping
        System.out.println("*** Before compute: " + fruit);
        for (Integer key : fruit.keySet()) {
            fruit.compute(key, (k,v) -> {return k+v;});
        }
        System.out.println("*** After compute: " + fruit);

        // replaceAll
        fruit.replaceAll((k,v) -> "Apple");
        System.out.println(fruit);

        // contains key?
        System.out.println(fruit.containsKey(2));

        // contains value
        System.out.println(fruit.containsValue("Mango"));

        // checking if empty
        System.out.println(fruit.isEmpty());

        // creating HashMap with a specific capacity
        Map<String, String> map1 = new HashMap<>(2^5);
        Map<String, String> map2 = new HashMap<>(32, 80f);
    }
}
