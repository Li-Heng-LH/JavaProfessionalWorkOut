#  Advanced Class Design
Walk through of _Oracle Certified Professional Java SE 8 Programmer II Study Guide_, by Jeanne Boyarsky and Scott Selikoff. 

## Some Learning Notes ##

### Package ###
* **There is no concept of a subpackage in Java**.
* So `me.liheng.cat` and `me.liheng.cat.BigCat` are completely separate packages. 

&nbsp;

### Access Modifiers ###
* private: same class
* default: package 
* protected: package + sub-classes
* public: all

&nbsp;

### Overloading and Overriding ###
* For both, the method name has to be the same. 
* The _method signature_ is the method name and the parameter list.

&nbsp;

### Overloading ###
* Ignore return type. 
* Method parameters must vary by **type** and/or **number** and/or **order**.
* Closest match first: 
  * Exact match by type
  * Matching a superclass type
  * Converting to a larger primitive type
  * Converting to an autoboxed type
  * Varargs
  
&nbsp;

### Overriding ###
* Method signature has to be the same.
* Rules: 
  * Return type must be the same or a subclass
  * Access modifier must be the same or more accessible
  * Exceptions must be the same or subclass
  * The methods must not be static

&nbsp;

### instanceof ###
* true if :   
  * is instance of class
  * is a subclass (directly or indirectly)
  * implements the interface
* `x instanceof Object`
  * is true unless x is null 
  * null is not an Object
  * `null instanceof Object` is false 
* The **compilation check** only applies when instanceof is called on a class.
* When checking whether an object is an instanceof an interface, Java waits until runtime to do the check.
* The reason is that a subclass could implement that interface and the compiler wouldn’t know it.
* The instanceof operator is commonly used to determine if an instance is a subclass of a particular object 
before applying an explicit cast. 

&nbsp;

### Virtual Method Invocation ###
* Call a method based on the actual type at runtime, instead of variable type at compile time. 
* But for instance variables, actual type at runtime is not considered. 

&nbsp;

### @Override ###
For: 
* Implementing a method from an interface
* Overriding a superclass method
* Overriding a method declared in Object, such as hashCode, equals, or toString

&nbsp;

### What is null in Java? ###
* In practice, the programmer can ignore the null type and just 
* pretend that null is merely a **special literal** that **can be of any reference type**.
* null instanceof any Class is false
* null == any object is false
* object.equals(null) depends on implementation
* null.equals() is invalid
&nbsp;

### toString() ###
* Default implementation: someObjectClassname@hashcodenumber
* To override: `public String toString()`

&nbsp;

### equals() ###
* Default implementation: ==
* To override: `public boolean equals(Object obj)`
* Contracts for equals():   
  * reflexive: x.equals(x) should return true
  * symmetric: x.equals(y) --> y.equals(x) and y.equals(x) --> x.equals(y)
  * transitive: x.equals(y) and y.equals(z), --> x.equals(z)
  * consistent
  * x.equals(null) should return false, rather than throw a NullPointerException

&nbsp;

### hashCode ###
* Default implementation: typically implemented by converting the internal address of the object into an integer.   
  As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers for distinct objects. 
* To override:`public int hashCode()`

&nbsp;

&nbsp;
----
### Useful links ###
* [What is null in Java?](https://stackoverflow.com/questions/2707322/what-is-null-in-java)
* [How default .equals and .hashCode will work for my classes?](https://stackoverflow.com/questions/4178997/how-default-equals-and-hashcode-will-work-for-my-classes)
