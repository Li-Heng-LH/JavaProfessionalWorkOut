# Generics and Collections 


## Some Learning Notes ##

### Arrays and ArrayList ###
* `List<String> list = Arrays.asList(array); `   
  Returns a **fixed-size** list **backed** by the specified array. (Changes to the returned list "write through" to the array.)  
  Changes in list <--> Changes in array
* Arrays.asList() takes in an array 
  * the list returned is backed by the array
  * Modifications made on either one will reflect on the other, in both ways.
  * The returned list can be modified, but cannot change size (neither add nor remove). 
* `toArray()` will return a new array.

&nbsp;

### Autoboxing ###
* Autoboxing automatically converts a primitive to the corresponding wrapper classes when needed 
if the **generic type is specified in the declaration**. --> 
* therefore, Integer can do arithmetic with Integer
* int can be assigned to Integer
* Integer can be assigned into int

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
  * Cannot **add** any entry to a `List<? extends Number>`. This is because Java does not what the actual type is and 
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
  * `List<Object> list = new ArrayList<String>();` is NOT ok
  * `List<?> list = new ArrayList<String>();` is ok
* Why do we need `List<? extends Number>` Upperbound? 
  * So that each element can be **treated as Number**, and use its methods. 
* Why do we need `List<? super String>` Lowerbound? 
  * So that we **can add String** element to list. 
* `?` is only used to define, not to instantiate.

&nbsp;

### Concise Summary ###
* Why do we need unbounded?
  * `ArrayList<String>` cannot be assigned to `List<Object>` 
  * `ArrayList<String>` can be assigned to `List<?>` 
* Why do we need Upperbound? 
  * So that each element can be **treated as Upperbound**, and use its methods. 
* Why do we need Lowerbound? 
  * So that we **can add Lowerbound** element to list. 
* `?` can only be at the left hand side of `=` 

&nbsp;

### Insights ### 
* `List<String>` is not a child of `List<Object>`. They are totally different.
* We can only access the methods of an object's reference type. 

&nbsp;

### My Generic class ### 
* Return type need to be specified. Cannot use wildcard. 
* pay attention to method-specific type parameter VS wildcard

&nbsp;

### Type Parameter ###
* Use of type parameter: once passed in the actual type, T can be treated as actual type across the class.  
* Use of type parameter: can use `<T extends Number>`, T can then use Number's methods.
* `<T super Number>` is NOT allowed. Because after type erasure, T is treated as Object.

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
* Implementation classes
  * List:  ArrayList, LinkedList, Stack, Vector
  * Set:   HashSet, TreeSet
  * Queue: ArrayDeque, LinkedList
  * Map:   HashMap, TreeMap, Hashtable

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

### TreeSet ###
* lower -> greatest element that is strictly smaller than parameter  , or null
* floor -> greatest element that is smaller or equal to parameter    , or null
* ceiling -> smallest element that is greater or equal to parameter  , or null
* higher -> smallest element that is strictly greater than parameter , or null

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
  * Therefore, **use ArrayDeque to implement both queue and stack**.

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
* Better to make Comparable classes consistent with equals. 
  * compareTo() is consistent with equals <--> x.equals(y) is true whenever x.compareTo(y) equals 0

&nbsp;

### Comparator Interface ###
* We need Comparator when: 
  * we want to sort objects that do not implement Comparable
  * we want to sort objects in an order that will break the equals consistency. 
  * we want to sort objects in another order

&nbsp;

### Comparison of Comparable and Comparator ###
|            Difference            	| Comparable 	| Comparator 	|
|:--------------------------------:	|:----------:	|:----------:	|
|           Package name           	|  java.lang 	|  java.util 	|
|     Method name in interface     	|  compareTo 	|   compare  	|
|       Number of parameters       	|      1     	|      2     	|
| Common to declare using a lambda 	|     No     	|     Yes    	|

&nbsp;

### TreeSet and Comparable/Comparator ###
* Elements in TreeSet need to implement Comparable interface. 
* If element added into TreeSet does not implement Comparable,   
  an exception will be thrown at run time. 
* Another way to store elements that do not implement Comparable in a TreeSet,  
  is to initialise TreeSet with a Comparator. 

&nbsp;

### Method References ###
* Sometimes,  a lambda expression does nothing but call an existing method. 
* In this case, it is clearer to refer to the existing method by name. 
* How this actually works is:  
  The :: operator tells Java to pass the parameters automatically into the method referred.
* `Interface Predicate<T>` : `boolean test(T t)`  
  `Interface Consumer<T>`  : `void accept(T t)`
  `Interface Supplier<T>`  : `T get()`
  `Interface UnaryOperator<T>` : `R apply(T t)`
  `Interface BiFunction<T,U,R>` : `R apply(T t, U u)`
* Static method format: `Collections::sort`
* Instance methods on a known instance: `str::startsWith`, usually static/instance/eff.final variables (no need pass in)
* Instance methods on an instance to be passed in at runtime: `String::isEmpty` , `String::concat`  
  It looks like a static method, but it isn’t. 
  Java knows that isEmpty is an instance method that does not take any parameters.
  **Java uses the parameter supplied at runtime as the instance on which the method is called**.  
* Constructor format: `ArrayList::new`
* 规律: Referred method 只需要 method name, 不需要(). 
* 规律: Referred method 可以是 an instance method that takes in arguments. 
* 规律: Method reference can get rid of the () -> structure. 

&nbsp;

### Collections util method: sort ###
* `public static <T extends Comparable<? super T>> void sort(List<T> list)`
* Sorts the specified list into ascending order, according to the natural ordering of its elements
* `public static <T> void sort(List<T> list, Comparator<? super T> c)`
* Sorts the specified list according to the order induced by the specified comparator. 
* Collections.sort

&nbsp;

### Collections.sort vs list.sort ###
* Interface List<E> instance method: `default void sort(Comparator<? super E> c)` 
* The method List.sort(comparator) that you are referring to was introduced in Java 8,   
  whereas the utility method Collections.sort has been there since Java 1.2.

&nbsp;

### Collections util method: binarySearch ###
* `static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)`
* The list must be sorted into **ascending** order according to the natural ordering of its elements.
* `static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c)`
* The list must be sorted into **ascending** order according to the specified comparator. 
* If it is not sorted, the results are undefined. 
* Returns the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1).
* Collections.binarySearch

&nbsp;

### Insights on sort and binary search ### 
* The Arrays and Collections classes have static methods sort() and binarySearch().
* Both take in **List** and not something else.
* Both take an optional **Comparator** parameter. 
* **It is _necessary_ to use the same sort order for both sorting and searching,**   
  **else the result is undefined.** 
* binarySearch requirements: 
  * sorted with same comparator can alr. 
  * does NOT mean must be "1,2,3,4,5" 

&nbsp;

### Collection instance method: removeIf ###
* `boolean removeIf(Predicate<? super E> filter)`
* Removes all of the elements of this collection that satisfy the given predicate.

&nbsp;

### List instance method: replaceAll ###
* `void replaceAll(UnaryOperator<E> o)`
* Replaces each element of this list with the result of applying the operator to that element.

&nbsp;

### Collections util method: replaceAll ###
* `static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)`
* Replaces all occurrences of one specified value in a list with another. 

&nbsp;

### Collection instance method: forEach ### 
* `default void forEach(Consumer<? super T> action)`
* and the default implementation behaves as if: `for (T t : this) action.accept(t);`
* Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception. 

&nbsp;

### Java 8 Map instance methods ### 
* `putIfAbsent`: puts if
  * key is not there at all
  * value is null
* `merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)`:   
  * if key is not there at all
  * or value is null
  * associates it with the given non-null value
  * Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.
  * returns the new value associated with the specified key, or null if no value is associated with the key
  * When the mapping function is called and returns null： the key is removed from the map. 

&nbsp;

### Summary of key points ###
* Generics
  * `<? extends Object>` is Upper bound. --> extend upper bound
  * `<? super Number>` is Lower bound.   --> super lower bound
  * Add or remove to a list with an **unbounded** or **upper-bounded** wildcard --> compiler error
  * Add or remove to a list with _?_ or _extends_ --> compiler error
  
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
