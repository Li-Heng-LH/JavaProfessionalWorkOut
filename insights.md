## Some things to remember ##

### Default .equals and .hashCode ###
* In both cases it's just comparing the memory addresses of the objects

&nbsp;

### Overloading vs Overriding ###
* For Overloading, we talk about closest match for parameters.   
  For Overriding, the return type must be the same or a subclass. 
  
&nbsp;

### Contract between equals and hashCode ###
* a equals b --> both have same hashcode. 
* Reverse is not true. And that is the case of collision. 

&nbsp;
