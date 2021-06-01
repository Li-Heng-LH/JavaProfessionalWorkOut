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
* Generic methods have a type parameter before the return type of the method declaration.
* Type parameters can be bounded.
* Generic methods can have different type parameters separated by commas in the method signature

&nbsp;

### Unbounded Wildcards ###
* `List<String>` cannot be assigned to `List<Object>`.
* `List<?>` means a List of “whatever”.  

&nbsp;

&nbsp;
----
### Useful links ###
* [The Basics of Java Generics](https://www.baeldung.com/java-generics)