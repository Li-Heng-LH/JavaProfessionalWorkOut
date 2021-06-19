# Generics and Collections 


## Some Learning Notes ##

### Arrays and ArrayList ###
* `List<String> list = Arrays.asList(array); `   
  Returns a **fixed-size** list **backed** by the specified array. (Changes to the returned list "write through" to the array.)  
  Changes in list <--> Changes in array
* `toArray()` will return a new array.

&nbsp;

### Autoboxing ###
* Autoboxing automatically converts a primitive to the corresponding wrapper classes when needed 
if the **generic type is specified in the declaration**. 

&nbsp;

### Generic Class ###
* **Using generics gives us compile time safety**.
* `List names = new ArrayList();`  this is actually allowed. 
* No need to specify the type.
* Naming conventions: 
  * E for an element
  * K for a map key
  * V for a map value
  * N for a number
  * T for a generic data type
  * S, U, V, and so forth for multiple generic types
* Type Erasure:  
  * Behind the scenes, the compiler replaces all references to T with Object.
  * So, after the code compiles, the generics are actually just Object types. 
  * This means there is only one class file. 
  * **This process of removing the generics syntax from your code is referred to as type erasure**. 
  * The compiler adds the relevant casts if needed.

&nbsp;

### Generic Methods ###
* Generic methods are methods that introduce their own type parameters. 
* This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared.
* Generic methods have a type parameter before the return type of the method declaration.
* Type parameters can be bounded.
* Generic methods can have different type parameters separated by commas in the method signature

&nbsp;

### What is NOT allowed ###
* `List<Object> l = new ArrayList<String>();`
* function `printList(List<Object> list)` cannot take in a `List<String>`.
* Basically, `List<String>` cannot be assigned to `List<Object>`, 
* Because Java cannot catch at runtime, and need to prevent at compile time. 

&nbsp;

### What is allowed ###
* `Object[] objects = new String [2];`
* function `printArray(Object [] arr)` can take in a `String[]`.

&nbsp;

### Unbounded Wildcards ###
* `List<String>` cannot be assigned to `List<Object>`.
* `List<?>` means a List of “whatever”.  
* What is allowed now?   
  * function `printList(List<?> list)` can take in a `List<String>`.
  * `List<?> list = new ArrayList<String>();`
* Basically, `List<String>` can be assigned to `List<?>` now
* What is NOT allowed now?   
  * Cannot add any entry to a `List<?>`. This is because Java does not what the actual type is and 
  afraid of type cast exceptions later. 
  * I can only loop through a `List<?>` treating each entry as `Object`.
* `List<String>` can be assigned to a `List<?>`.    
  But, no object is a `?`.

&nbsp;

### Upper-Bounded Wildcards ### 
* `List<? extends Number> list = new ArrayList<Integer>();`
* `List<Integer>` can now be assigned to `List<? extends Number>`
* function `total(List<? extends Number> list)` can take in `List<Integer>`
* What is NOT allowed? 
  * Cannot add any entry to a `List<? extends Number>`. This is because Java does not what the actual type is and 
  afraid of type cast exceptions later. 
  * I can only loop through a `List<? extends Number>` treating each entry as `Number`.
* So how is Upper-Bounded Wildcards more useful than Unbounded Wildcards?  
  * Well, in `List<? extends Number>`, each item is treated as a Number.   
  * As for `List<?>`, each item is treated as an Object. 
  * So in the case of Upper-Bounded Wildcards, for each item we can use Numbers' methods. 
  * Objects' methods are too limited. 
* **Regarding top hierarchy parent class**
  * Yes, `List<Animal>` is a `List<? extends Animal>`
  * For a `List<? extends Animal> list`, `list.add(new Animal());` DOES NOT compile. 
* ? can extend an interface too. 

&nbsp;

### Lower-Bounded Wildcards ###
* Why do we need Lower-Bounded Wildcards? 
  * With `List<?>` and `List<? extends Object>` we can already pass in a `List<String>`
  * But, the list passed in is immutable. We cannot add elements to it. 
  * If we pass in `List<? super String>`, we can then add a String to the list, it is safe. 
* Why in a `List<? extends Animal>`, we cannot add Dog? 
  * The list can contain Cats. 
* Why in a `List<? extends Animal>`, we cannot add Animal? 
  * Later we may need certain methods of Dog, Animal may not have.
* Why in a `List<? super Dog>`, we can add Dog? 
  * Where parent is expected, child can be used. 
* Why in a `List<? super Dog>`, we still cannot add Animal? 
  * possible issues with hierarchy levels.
  * lets say this is a list of mammals, later we want to use mammals' methods, 
  but Animal does not have.

&nbsp;

### Summary ###
* Why do we need `List<?>` ?
  * `List<String>` can be assigned to `List<?>`
* Why do we need `List<? extends Number>` ?
  * So that each element can be **treated as Number**, and use its methods. 
* Why do we need `List<? super String>` ? 
  * So that we **can add String** element to list. 

&nbsp;

### My Generic class ### 
* Return type need to be specified. Cannot use wildcard. 
* pay attention to method-specific type parameter VS wildcard

&nbsp;

### OCP Collections ###
* List, Set, Map, Queue
* `boolean add(E element)`
* `boolean remove(Object object)` or overloaded one: `boolean remove(int index)`
* `boolean isEmpty()`
* `int size()`
* `void clear()`
* `boolean contains(Object object)`
  * This method calls **equals()** on each element of the ArrayList to see if there are any matches.

&nbsp;

### List Interface ###
* interface List extends Collection
* ArrayList implements List
* LinkedList implements both List and Queue
* The main benefits of a LinkedList are that you can access, add, and remove 
from the beginning and end of the list in constant time. 
* The tradeoff is that dealing with an arbitrary index takes linear time.
* Therefore, a LinkedList is a good choice to be used as a Queue.

&nbsp;

### Set ###
* A HashSet stores its elements in a hash table. 
* HashSet: constant-time for add(), remove() and contains()
* A TreeSet stores its elements in a sorted tree structure. It sorts the elements in ascending order.
* TreeSet: log(n) time for add(), remove() and contains()
* TreeSet is a sorted collection that extends the AbstractSet class and implements the NavigableSet interface.
* The TreeSet uses a **self-balancing binary search tree**, more specifically a Red-Black tree.
* For Set, remember that 
  * the equals() method is used to determine equality
  * the hashCode() method is used to know which bucket to place the element  

&nbsp;

### Queue implementations ###
* `interface Deque<E> extends Queue<E>`
* Double ended queue, supports element insertion and removal at both ends.
* class LinkedList<E> implements Deque<E>
* class ArrayDeque<E> implements Deque<E>
* The ArrayDeque class is the resizeable array implementation of the Deque interface, 
* whereas the LinkedList class is the list implementation.
* Efficiency: 
  * Deques can also be used as stacks. 
  And it should be used in preference to the legacy Stack class. 
  * ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends.
  * ArrayDeque is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
  * Therefore, use ArrayDeque to implement both queue and stack.

&nbsp;

### Interface Queue Methods ###
* Throws exception: 
  * add(e)     -- true or exception  
  * remove()   -- E or exception
  * element()  -- E or exception
* Returns special value: 
  * offer(e)   -- true or false
  * poll()     -- E or null
  * peek()     -- E or null

&nbsp;

### Interface Deque Methods ###
* When a deque is used as a queue, 
elements are added at the end of the deque and removed from the beginning. 
* When a deque is used as a stack, 
elements are pushed and popped from the beginning of the deque. 
* Therefore, a deque has both Queue and Stack methods. 
* Stack methods: 
  * push(e)   -- void or exception
  * pop()     -- E or exception
  * peek()    -- E or null

&nbsp;

### Using Deque ###
* `Queue<Integer> queue = new ArrayDeque<>();`
* `ArrayDeque<Integer> stack = new ArrayDeque<>();`
* Note: LinkedList has all Deque methods as well.

&nbsp;

### Map Interface ###
* Map Implementations
  * HashMap: stores the keys in a hash table. hashCode() method is used to retrieve keys.   
    Constant time for adding and retrieving elements. 
  * LinkedHashMap: preserve the order of insertion
  * TreeMap: preserve the natural order.   
    Log n time for adding and retrieving elements. 
  * Hashtable: is like Vector in that it is really old. 
* Map methods: 
  * `V get(Object key)`: return value or null
  * `V put(K key, V value)`: return **previous** value or null.
  * `Set<K> keySet()`: returns Set as keys are unique
  * `Collection<V> values()`: returns Collection as values may not be unique
  * Notes: those common methods do not throw exceptions. 
  * TreeMap: Yes, as I have expected, the keySet returned from TreeMap is sorted.
  * TreeMap: the values will be sorted according to te sorted keys as well.

&nbsp;

### collections and null ###
* Data structures that involve sorting do **NOT** allow nulls
* ArrayDeque does **NOT** allow nulls because some methods use null as a special return value: 
  * poll(), peek()
* Hashtable does **NOT** allow null keys or values
* In summary, all data structures allow nulls except these:
  * TreeSet
  * TreeMap: no null keys, can have null values
  * Hashtable: no null keys and values
  * ArrayDeque 

&nbsp;

### Comparable Interface ###
* Numbers sort before letters and uppercase letters sort before lowercase letters
* A class that implements Comparable interface needs to implement compareTo() method
* Rules for compareTo(): 
  * returns 0 when this is equal to the argument
  * returns negative when this is smaller than argument
  * returns positive when this is greater than argument
  * basically, it is like: return this - argument
* 

&nbsp;

&nbsp;
----
### Useful links ###
* [The Basics of Java Generics](https://www.baeldung.com/java-generics)
* [Type Erasure in Java Explained](https://www.baeldung.com/java-type-erasure)
* [A Guide to TreeSet in Java](https://www.baeldung.com/java-tree-set)
* [Deque Implementations](https://docs.oracle.com/javase/tutorial/collections/implementations/deque.html)
* [Interface Deque<E>](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
* [Generic Methods](https://docs.oracle.com/javase/tutorial/java/generics/methods.html)