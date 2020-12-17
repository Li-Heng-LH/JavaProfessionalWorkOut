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
* The compilation check only applies when instanceof is called on a class.
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


&nbsp;
----
### Useful links ###
* []()