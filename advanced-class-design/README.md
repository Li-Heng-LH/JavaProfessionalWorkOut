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

&nbsp;
----
### Useful links ###
* []()