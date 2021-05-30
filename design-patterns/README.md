#  Design Patterns and Principles
Walk through of _Oracle Certified Professional Java SE 8 Programmer II Study Guide_, by Jeanne Boyarsky and Scott Selikoff. 

## Some Learning Notes ##

### Functional Interface ###
* contains a single abstract method

&nbsp;

### Lambda Syntax ###
* parentheses can be omitted only if there is exactly one parameter and the data type is not specified
* single expression as the body --> no need {}
* one or more statements in body --> need {}


* the data types for the input parameters of a lambda expression are optional, but
* when one parameter has a data type listed, all parameters must provide a data type.

&nbsp;

### Reference Type ###
* If you use a variable to refer to an object, we can only call the reference type's methods/variables without explicit cast. 
* Reference type determines which methods and variables are accessible to the Java program.
* The reference type is any class or interface that is a supertype of the actual type. 

&nbsp;

### Casting ###
* Casting an object from a subclass to a superclass doesn’t require an explicit cast
* Casting an object from a superclass to a subclass requires an explicit cast.
* The compiler will not allow casts to unrelated types. (not related in hierarchy)
* Even when the code compiles without issue, an exception may be thrown at runtime if the object being cast is not actually an instance of that class.

&nbsp;

### Encapsulation ###
* Methods operate on the data, rather than being accessed directly by users. 

&nbsp;

### Singleton ###
* That single instance has to be sharable by all classes and **threads** within the application. 
* By marking the constructors private, we have implicitly marked the class **final**.  
  A final class is a class that cannot be extended.  
  The first line of any constructor is a call to a parent constructor with the super() command.  
  If all of the constructors are declared private in the singleton class,  
  it is impossible to create a subclass that can call parent class' constructor.
* Both the `StaffRegister` class and `HayStorage` class instantiate the singleton at the time the class is loaded.  
  Conceptually, these two implementations are equivalent, since both create the singleton when the class is loaded. 
  Since the singleton is created when the class is loaded, we are able to mark the reference `final`.  
  By marking instance `final`, it cannot be reassigned, guarantees only one instance will be created within our application. 
* Software design pattern **lazy instantiation**: delay creation of the singleton until the first time the getInstance() method is called. 

&nbsp;

### immutable object pattern ###
* The immutable object pattern is a creational pattern based on the idea of creating objects 
whose state does not change after they are created and can be easily shared across multiple classes.
* no setter methods exist that modify the object
* Immutable Strategy: 
  * Use a constructor to set all properties of the object.
  * Mark all of the instance variables private and final.
  * Don’t define any setter methods.
  * Don’t allow referenced mutable objects to be modified or accessed directly.
  * Prevent methods from being overridden.

&nbsp;

### Builder Pattern ###
* To create an object that requires numerous values to be set at the time the object is instantiated.
* All parameters in constructor? Bad. 
* A lot of setter methods?   
  Doesn’t work for immutable objects.
  For mutable objects, it could also lead to class invariants being temporarily broken.
* Builder Pattern: parameters are passed to a builder object, 
often through **method chaining**, and an object is generated with a final build call. 
* Often used with immutable objects, since immutable objects do not have setter methods.
* In some ways, using the builder pattern is analogous to taking a mutable object and making it read‐only.
* In practice, a builder class is often packaged alongside its target class, 
either as a static inner class within the target class or within the same Java package. 
* One advantage of packing them together is that if one is changed, then the other can be quickly updated.
* Another advantage is that writers of the target class can then choose to make the constructor a private or default.

&nbsp;

### Factory Pattern ###
* based on the idea of using a factory class to produce instances of objects based on a set of input parameters. 
* It is similar to the builder pattern, although it is focused on supporting class polymorphism.
* Factory patterns are often, although not always, implemented using static methods 
that return objects and do not require a pointer to an instance of the factory class.
* If we wanted to tighten our access control, we could have declared these constructors with default or package‐level access.

&nbsp;

### design principles VS design patterns ###
* A design principle is an established idea or best practice that facilitates design process. 
* A design pattern is an established general solution to a commonly occurring problem.

&nbsp;

### Interface ###
* All members of an interface are public. 
* Interfaces can never be declared final, as interfaces are assumed to be declared as abstract, 
and abstract and final can never be used together. 
* Java supports multiple inheritance through interfaces only. 
* A class can implement multiple interfaces,
* An interface can extend multiple interfaces. 
* Interface variables are public, static, and final by default, automatically inserted by the compiler. 
* By default methods are public abstract.
* default and static methods need implementations. 
* An abstract class can implement an interface without implementing any of the abstract methods.

&nbsp;

### inheritance VS object composition ###
* Good about inheritance: Inheritance supports access to protected variables.
* Good about composition: promote greater code reuse, since object composition tends to lead to classes that are 
easier to reference, as they don’t require knowledge of any parent classes. 

&nbsp;

&nbsp;
----
### Useful links ###
* []()