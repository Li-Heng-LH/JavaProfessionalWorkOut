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

| Functional Interfaces | Single Abstract Method | #Parameters | Return Type |
|-----------------------|:----------------------:|:-----------:|:-----------:|
| Supplier<T>           |           get          |      0      |      T      |
| Consumer<T>           |         accept         |    1 (T)    |     void    |
| BiConsumer<T, U>      |         accept         |   2 (T, U)  |     void    |
| Predicate<T>          |          test          |    1 (T)    |   boolean   |
| BiPredicate<T, U>     |          test          |   2 (T, U)  |   boolean   |
| Function<T, R>        |          apply         |    1 (T)    |      R      |
| BiFunction<T, U, R>   |          apply         |   2 (T, U)  |      R      |
| UnaryOperator<T>      |          apply         |    1 (T)    |      T      |
| BinaryOperator<T>     |          apply         |   2 (T, T)  |      T      |

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

### `Predicate<T>` and `BiPredicate<T, U>` ###
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

### Practice ###
* What if I omit the generics?
  * `Predicate ex4 = String::isEmpty; // DOES NOT COMPILE`
  * This makes the parameter that was passed an Object rather than a String. 
  * The lambda expects a String because it calls a method that exists on String rather than Object.
* When you see a boolean returned, think `Predicate` unless the generics specify a Boolean return type. 

&nbsp; 

### Optional static methods ###
* `Optional<Double>`
* `Optional.empty()`
* `Optional.of(95)`
* `Optional.ofNullable(null)`: Returns an Optional describing the specified value if non-null, otherwise returns empty Optional

&nbsp;

### Optional instance methods ###
| Method                  | When Optional Is Empty                                                | When Optional Contains a Value |
|-------------------------|-----------------------------------------------------------------------|--------------------------------|
| get()                   | Throws an exception                                                   | Returns value                  |
| isPresent()             | false                                                                 | true                           |
| ifPresent(Consumer c)   | Does nothing                                                          | Calls Consumer c with value    |
| orElse(T other)         | Returns other                                                         | Returns value                  |
| orElseGet(Supplier s)   | Returns result of calling Supplier (That returns T)                   | Returns value                  |
| orElseThrow(Supplier s) | Throws exception created by calling Supplier (That returns Throwable) | Returns value                  |

&nbsp;

&nbsp;
----
### Useful links ###
* []()