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
* Ignore return currencyType. 
* Method parameters must vary by **currencyType** and/or **number** and/or **order**.
* Closest match first: 
  * Exact match by currencyType
  * Matching a superclass currencyType
  * Converting to a larger primitive currencyType
  * Converting to an autoboxed currencyType
  * Varargs
  
&nbsp;

### Overriding ###
* Method signature has to be the same.
* Rules: 
  * Return currencyType must be the same or a subclass
  * Access modifier must be the same or more accessible
  * Exceptions must be the same or subclass
  * The methods must not be static --> we cannot override static methods

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
* The **compilation check** only applies when instanceof is called on a concrete class.
* When checking whether an object is an instanceof an interface, Java waits until runtime to do the check.
* The reason is that a subclass could implement that interface and the compiler wouldn’t know it.
* The instanceof operator is commonly used to determine if an instance is a subclass of a particular object 
before applying an explicit cast. 

&nbsp;

### Virtual Method Invocation ###
* Call a method based on the actual currencyType at runtime, instead of variable currencyType at compile time. 
* But for instance variables, actual currencyType at runtime is not considered. 

&nbsp;

### @Override ###
For: 
* Implementing a method from an interface
* Overriding a superclass method
* Overriding a method declared in Object, such as hashCode, equals, or toString

&nbsp;

### What is null in Java? ###
* In practice, the programmer can ignore the null currencyType and just 
* pretend that null is merely a **special literal** that **can be of any reference currencyType**.
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
* An equals() method should have a **null check** and an **instanceof check**.

&nbsp;

### hashCode ###
* Default implementation: typically implemented by converting the internal address of the object into an integer.   
  As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers for distinct objects. 
* To override:`public int hashCode()`
* Contracts for hashCode(): 
  * Within the same program, the result of hashCode() must not change.   
    For example, an attribute that can change (e.g weight) should not be used for hashcode.
  * a equals b --> both have same hashcode. 
  * a has same hashcode as b !--> a equals b  
    a !equals b --> a and b can still have the same hashcode. 
    So, this is the collision case. 
* hashCode() can use a subset of the variables that equals() uses.

&nbsp;

### Enum ###
* An enum cannot be extended. The values in an enum are all that are allowed. 
You cannot add more at runtime by extending the enum.
* Enums cannot have a public constructor.
* We can assign a **state** to each enum.
* The first time we ask for any of the enum values, Java constructs all of the enum values.
* After that, Java just returns the already‐constructed enum values. 
* The enum can have an abstract method. 
This means that each and every enum value is required to implement this method.
* We can actually do these things to enum: 
  * assign a state
  * implement abstract method or override a method

&nbsp;

### Member Inner Class ###
* Defined at the member level of a class. 
* **Can access members of the outer class including private members**. 
* Cannot declare static fields or methods.
* Since a member inner class is not static, it has to be **used with an instance of the outer class**. 
* Compiling the Outer.java file will create 2 class files: 
  * Outer.class
  * Outer$Inner.class
* If Inner class is private, in Test, calling Outer.Inner will have error. 

&nbsp;

### Local Inner Class ###
* Defined within a method.
* Cannot access local variables of a method unless they are effectively final. 
* If the local variable is final, Java can pass it to inner class. 

&nbsp;

### Anonymous Inner Class ###
* Basically a local inner class that does not have a name.
* It is declared and instantiated all in one statement. 
* **Must extend an existing class or implement an existing interface**. 
* Useful for a short implementation that is only used once. 
* It can be passed in as an argument to a method. 
* Anonymous Inner Class 必须 extend or implement. 然后我们
* **当场 define, 当场 instantiate**. 

&nbsp;

### Static Nested Class ###
* is not an inner class.
* is a static class defined at the member level.
* can be instantiated without an object of the enclosing class.

&nbsp;

### Summary of inner classes ###
|                                                	|    Member Inner Class    	|     Local Inner Class    	|   Anonymous Inner Class  	|          Static Nested Class         	|
|:----------------------------------------------:	|:------------------------:	|:------------------------:	|:------------------------:	|:------------------------------------:	|
| Can access instance members of enclosing class 	| Yes, can directly access 	| Yes, can directly access 	| Yes, can directly access 	| Requires instance of enclosing class 	|
| Can access local variables of enclosing class  	|            No            	|     Effectively final    	|     Effectively final    	|                  No                  	|
| Can declare static fields or methods           	|            No            	|            No            	|            No            	|                  Yes                 	|
| Allow access modifiers                         	|            Yes           	|    No, local to method   	|  No, local to statement  	|                  Yes                 	|

&nbsp;

### import util class ###
|              UtilClass.i             	|                       i                       	|
|:------------------------------------:	|:---------------------------------------------:	|
| import me.liheng.packageA.UtilClass; 	| import static me.liheng.packageA.UtilClass.*; 	|
|     import me.liheng.packageA.*;     	| import static me.liheng.packageA.UtilClass.i; 	|

:x: import static me.liheng.packageA.UtilClass;  
:x: import static me.liheng.packageA.*;

&nbsp;

### import member inner class ###
* `import me.liheng.packageA.Outer.PublicInner;` is ok, but Outer will not be recognised. 

&nbsp;

### import static nested class ###
* No need an instance of Enclosing class to instantiate.  
Can just: `PublicInner publicInner = new PublicInner();`
* Possible import statements: 
  * `import me.liheng.packageA.Enclosing.PublicInner;`
  * `import static me.liheng.packageA.Enclosing.PublicInner;`

&nbsp;

### Helper vs. Utility Classes ###
* Helper classes can be instantiated. Utility classes are final and have private constructors. 
* Helper classes can have instance variables. Utility classes only have static variables and methods.
* Helper classes package scope. Utility classes global scope.

&nbsp;

&nbsp;
----
### Useful links ###
* [What is null in Java?](https://stackoverflow.com/questions/2707322/what-is-null-in-java)
* [How default .equals and .hashCode will work for my classes?](https://stackoverflow.com/questions/4178997/how-default-equals-and-hashcode-will-work-for-my-classes)
