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

&nbsp;

&nbsp;
----
### Useful links ###
* []()