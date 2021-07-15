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

### `Function<T, R>` and `BiFunction<T, U, R>` ###
* `R apply(T t);`
* `R apply(T t, U u);`

&nbsp; 

### `UnaryOperator <T>` and `BinaryOperator<T>` ###
* `UnaryOperator<T>` extends `Function<T, T>`
* `BinaryOperator<T>` extends `BiFunction<T, T, T>`
* A UnaryOperator transforms its value into one of the same type. 
* A BinaryOperator merges two values into one of the same type.
* `T apply(T t);`
* `T apply(T t1, T t2);`

&nbsp; 

### Bi-FI method reference summary ###
* BiConsumer:     `map::put`
* BiPredicate:    `String::startsWith`
* BiFunction:     `String::concat`
* BinaryOperator: `String::concat`

&nbsp; 

&nbsp;
----
### Useful links ###
* []()