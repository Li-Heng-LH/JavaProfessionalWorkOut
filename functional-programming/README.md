# Functional Programming 


## Some Learning Notes ##

### Using Variables in Lambdas ###
* Lambdas can use these variables: 
  * static variables
  * instance variables
  * effectively final method parameters
  * effectively final local variables

&nbsp;

### Common functional interfaces ###
* These are in the java.util.function package. 


&nbsp;

### `Supplier <T>` ###
* `T get();`
* How to read the lambda code?   
  I am creating a supplier that can return a new T when I call get()

&nbsp;

### `Consumer <T>` ###
* `void accept(T t);`
* I am creating a consumer that accepts a T and process it. 

&nbsp;

### `BiConsumer<T, U>` ###
* `void accept(T t, U u);`

&nbsp;

### `Predicate<T>` and `BiPredicate<T>` ###
* `boolean test(T t);`
* `boolean test(T t, U u);`

&nbsp;


&nbsp;
----
### Useful links ###
* []()