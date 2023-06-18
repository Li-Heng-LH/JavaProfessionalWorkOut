# Functional Programming 


## Some Learning Notes ##

### Revision on wildcards ###
* `List<String>` is not a `List<Object>`,   
  therefore we need `List<?>`.
* In a `List<? extends Animal>`, every element can be treated as Animal,  
  because the list can contain Cats and Dogs, but all share Animal common methods.
* `List<? extends Animal>` can remove an element. 
* `List<? extends Animal>` cannot add an element, because Java does not know exactly what elements are in the list. 
* In `List<? super Dog>`, cannot treat each element as Dog,   
  because the list can contain an Animal, that does not have bark(). 
* `List<? super Dog>` can add a Dog, because Dog has all Animal's or Mammal's methods.

&nbsp;

### Revision on Method References ###
* Instance methods on an instance to be passed in at runtime. 

&nbsp;

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

### Benefits of Optional ###
* As a return type to indicate possibility of returning null
* Avoid manipulating with null directly
* Handle null in a declarative way, functional programming style.

&nbsp;

### Optional ###
* You can view `Optional` as a single-value **container** that either contains a value or doesn't.
* `Optional.of()` CANNOT take in null. 
* `Optional.ofNullable()` can take in null.
* `optional.ifPresent()` takes in a consumer that consumes the value contained in the optional. 
  * if the optional is empty, do nothing, just like empty stream.
* `optional.filter()` takes in a predicate that tests the value, returns Optional.
  * if the optional is empty, return empty optional, just like empty stream.
* `optional.map()` takes in function that applies on the value, returns Optional.
  * if the optional is empty, return empty optional, just like empty stream.
* `optional.flatMap()` takes in Optional-bearing mapping function, returns 
the result of applying the Optional-bearing mapping function. 

|          | **optional.map**                             | **optional.flatMap**              |
|----------|----------------------------------------------|-----------------------------------|
| takes in | mapping function                             | Optional-bearing mapping function |
| returns  | optional wrapping result of mapping function | result of mapping function        |

&nbsp;

### Optional static methods ###
* `Optional<Double>`
* `Optional.empty()`
* `Optional.of(95)`
* `Optional.ofNullable(null)`: Returns an Optional describing the specified value if non-null, otherwise returns empty Optional

&nbsp;

### Optional instance methods ###
| Method                      | When Optional Is Empty                                                | When Optional Contains a Value                                                                                                         |
|-----------------------------|-----------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| get()                       | Throws an exception                                                   | Returns value                                                                                                                          |
| isPresent()                 | false                                                                 | true                                                                                                                                   |
| ifPresent(Consumer c)       | Does nothing                                                          | Calls Consumer c with value                                                                                                            |
| orElse(T other)             | Returns other                                                         | Returns value                                                                                                                          |
| orElseGet(Supplier s)       | Returns result of calling Supplier (That returns T)                   | Returns value                                                                                                                          |
| orElseThrow(Supplier s)     | Throws exception created by calling Supplier (That returns Throwable) | Returns value                                                                                                                          |
| map(Function mapper)        | Returns empty Optional                                                | Apply the provided mapping function to it, and if the result is non-null, return an Optional describing the result                     |
| filter(Predicate predicate) | Returns empty Optional                                                | If the value matches the given predicate, return an Optional describing the value                                                      |
| flatMap()                   | Returns empty Optional                                                | Apply the provided Optional-returning mapping function to it, return that result, flatMap does not wrap it with an additional Optional |

&nbsp;

### Streams ###
* A stream in Java is a **sequence of data**. 
* A stream pipeline is the operations that run on a stream to produce a result. 
* A stream pipeline has 3 parts: 
  * Source: Where the stream comes from.
  * Intermediate operations: Transforms the stream into another one.  
    Since streams use lazy evaluation, the intermediate operations do not run until the terminal operation runs.
  * Terminal operation: Actually produces a result. The stream is no longer valid after a terminal operation completes.

&nbsp;

### Intermediate vs. terminal operations ###
| Scenario                                | Intermediate Operations | Terminal Operations |
|-----------------------------------------|-------------------------|---------------------|
| Required part of a useful pipeline?     | No                      | Yes                 |
| Can exist multiple times in a pipeline? | Yes                     | No                  |
| Return type is a stream type?           | Yes                     | No                  |
| Executed upon method call?              | No                      | Yes                 |
| Stream valid after call?                | Yes                     | No                  |

&nbsp;

### Creating Stream Sources ###
* `static <T> Stream<T>	empty()`: Returns an empty sequential Stream.
* `static <T> Stream<T>	of(T... values)`: Returns a sequential ordered stream.
* `static <T> Stream<T>	generate(Supplier<T> s)`:   
  Returns an infinite sequential unordered stream where each element is generated by Supplier.
* `static <T> Stream<T>	iterate(T seed, UnaryOperator<T> f)`:   
  Returns an infinite sequential ordered Stream produced by iterative application of a function f to seed,  
  producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
* `Collection` Interface (List, Set, Queue, Deque) has these methods: 
  * `default Stream<E>	stream()`
  * `default Stream<E>	parallelStream()`
* To get Stream from Map: 
  * convert to Set first.

&nbsp;

### Common Terminal Operations ###
| Method                                                            	| Desc                                                       	| Signature                                                                                                                                                                                         	| Retur Type  	| Reduction? 	| What Happens for Infinite Streams 	|
|-------------------------------------------------------------------	|------------------------------------------------------------	|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	|-------------	|------------	|-----------------------------------	|
| count()                                                           	| determines the number of elements in a finite stream       	| long count()                                                                                                                                                                                      	| long        	| Yes        	| Does not terminate                	|
| min(Comparator), max(Comparator)                                  	| pass comparator and find min max                           	| Optional<T> min(<? super T> comparator)                                                                                                                                                           	| Optional<T> 	| Yes        	| Does not terminate                	|
| findAny(), findFirst()                                            	| return an element of the stream unless the stream is empty 	| Optional<T> findAny()                                                                                                                                                                             	| Optional<T> 	| No         	| Terminates                        	|
| allMatch(Predicate), anyMatch(Predicate) and noneMatch(Predicate) 	| search a stream and return boolean                         	| boolean anyMatch(Predicate <? super T> predicate)                                                                                                                                                 	| boolean     	| No         	| May or may not terminate          	|
| forEach(Consumer)                                                 	|                                                            	| void forEach(Consumer<? super T> action)                                                                                                                                                          	| void        	| No         	| Does not terminate                	|
| reduce()                                                          	| combines a stream into a single object                     	|` T reduce(T identity, BinaryOperator<T> accumulator) Optional<T> reduce(BinaryOperator<T> accumulator), <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)` 	| T or <T>    	| Yes        	| Does not terminate                	|
| collect()                                                         	| special type of reduction                                  	| <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) <R,A> R collect(Collector<? super T, A,R> collector)                                         	| R           	| Yes        	| Does not terminate                	|

* `findany()` vs `findfirst()`: findAny() is useful when working with parallel stream. 
* **Reduction is a special type of terminal operation where all contents of the stream are combined into a single primitive or Object.**  
* Note on `forEach(Consumer)`: 
  * Both `Iterable` and `Stream` have `forEach(Consumer)`.
  * Cannot use a traditional for loop on a stream, because Stream is not `Iterable`. 
* Purpose of `Optional<T> reduce(BinaryOperator<T> accumulator)`: 
  * If the stream is empty, an empty Optional is returned.
  * If the stream has one element, it is returned.
  * If the stream has multiple elements, the accumulator is applied to combine them.
  * To differentiate if the returned value is in stream or the identity. 
* Purpose of `<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)`
  * used when processing collections in parallel
* The `collect()` method is a special reduction: _mutable reduction_. 
  * more efficient than regular reduction as we use the same mutable object while accumulating.
  * Common mutable objects include `StringBuilder` and `ArrayList`
* What is the purpose of `accumulator` in `collect()` ?
  * takes in StringBuilder and String, and do something with the StringBuilder and String. 
* What is the purpose of `combiner` in `collect()` ? 
  * takes in 2 StringBuilders and do something with them. 
  * useful for parallel processing.

&nbsp;

### Common Intermediate Operations ###

#### filter ####
* `Stream<T> filter(Predicate<? super T> predicate)`
* Returns a Stream with elements that match the predicate.

&nbsp;

#### distinct ####
* `Stream<T> distinct()`
* returns a stream with duplicate values removed
* `equals()` is used to compare

&nbsp;

#### limit() and skip() ####
* `Stream<T> skip(long n)`
* returns a stream by skipping the first n elements. 
* `Stream<T> limit(long maxSize)`
* returns a stream by truncating till max size. 

&nbsp;

#### map() ####
* `<R> Stream<R> map(Function<? super T, ? extends R> mapper)`
* returns a stream by applying the one-to-one mapper. 

&nbsp;

#### flatMap() ####
* Turns `Stream<List<String>>` into `Stream<String>`.
* empty list will be omitted. 
* the mapper function is one that turns list into Stream, `l -> l.stream()`
* NOTE: the mapper function returns a Stream. 
* Can use method reference: `Collection::stream` (Instance method on running instance)

&nbsp;

#### sorted() ####
* `Stream<T> sorted()`
* `Stream<T> sorted(Comparator<? super T> comparator)`
* If the elements passed into sorted() is infinite, sorted() does not terminate, 
  sorted() needs to wait until everything to sort is present. 

&nbsp;

#### peek() ####
* `Stream<T> peek(Consumer<? super T> action)`
* Returns a stream consisting of the elements of this stream, 
* additionally performing the provided action. 
* Useful for debugging, where you want to see the elements as they flow past a certain point in a pipeline.
* Danger of using `peek()`: may change the state of elements in the stream. 

&nbsp;

### Ways to initialise a primitive stream ### 
* `DoubleStream.of()`
* `DoubleStream.empty()`
* `DoubleStream.generate(Math::random)`
* `DoubleStream.iterate(T seed, UnaryOperator<T> f)`
* `IntStream.range(1, 6)`
* `IntStream.rangeClosed(1, 5)`

### Using Optional with Primitive Streams ###
* `OptionalDouble` vs `Optional<Double>`:   
  * The difference is that OptionalDouble is for a primitive and Optional<Double> is for the Double wrapper class. 

### Statistics ###
* `IntSummaryStatistics stats = ints.summaryStatistics();`
* `stats.getMax()`
* `stats.getMin()`

&nbsp;

### Linking Streams to the Underlying Data ###
* Get `.stream()` from an ArrayList, 
* streams are lazily evaluated
* when terminal operation is reached, 
* stream pipeline then looks at the source and starts running. 

&nbsp;

### optional.map vs optional.flatMap ###
* mapper function in flatMap returns an Optional

&nbsp;

### Mapper functions in flatMaps ###
* Stream.flatMap:  
  Both mapper function and method return Stream
* Optional.flatMap:  
  Both mapper function and method return Optional

&nbsp;

### reduce() vs collect() ###
* reduce() takes in identity and BinaryOperator
* collect() takes in Supplier and BiConsumer

&nbsp;

### mapper function lambda examples ###
* `aKnownList::contains`
* `aKnownSet::contains`
* `String::isEmpty`
* `String::length`

&nbsp;

### collect, Collector, and Collectors ###
* stream.collect()
* stream.collect() can take in a Collector
* Collector.of() can create a Collector
* Collectors can be used to obtain a predefined Collector.

&nbsp;

### Advanced Collectors ###
| Collector                                                 | Description                                                                                                                                                   | Return Value When Passed to collect | Notes                                    |
|-----------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|------------------------------------------|
| Collectors.toList()                                       |                                                                                                                                                               |                                     |                                          |
| Collectors.toSet()                                        |                                                                                                                                                               |                                     |                                          |
| toCollection(Supplier s)                                  |                                                                                                                                                               |                                     |                                          |
| joining()                                                 | Creates a String from elements                                                                                                                                | String                              | Only applicable to Stream<String>        |
| joining(CharSequence cs)                                  | Creates a String from elements using cs as delimiter                                                                                                          | String                              | The last element will not have delimiter |
| averagingDouble(ToDoubleFunction f)                       |                                                                                                                                                               | Double                              |                                          |
| averagingInt(ToIntFunction f)                             |                                                                                                                                                               | Double                              |                                          |
| averagingLong(ToLongFunction f)                           |                                                                                                                                                               | Double                              |                                          |
| toMap(keyMapper, valueMapper)                             | keys and values are the result of applying the provided mapping functions to the input elements                                                               | Map                                 |                                          |
| toMap(keyMapper, valueMapper, mergeFunction)              | If the mapped keys contains duplicates, mapping function is applied to each equal element, <br>and the results are merged using the provided merging function |                                     |                                          |
| toMap(keyMapper, valueMapper, mergeFunction, mapSupplier) |                                                                                                                                                               |                                     |                                          |
| groupingBy(classifier)                                    | classifier maps elements to some key type K                                                                                                                   | Map<K, List<T>>                     |                                          |
| groupingBy(classifier, downstreamCollector)               | downstreamCollector is applied to the values                                                                                                                  |                                     |                                          |
| groupingBy(classifier, mapFactory, downstreamCollector)   | change the type of Map returned                                                                                                                               |                                     |                                          |
| partitioningBy(predicate)                                 | With partitioning, there are only two possible groups: true and false.                                                                                        | Map<Boolean,List<T>>                |                                          |
| partitioningBy(predicate, downstreamCollector)            | reduces the values in each partition according to downstreamCollector                                                                                         |                                     |                                          |
| counting()                                                | Counts number of elements                                                                                                                                     | Long                                |                                          |
| minBy(comparator)                                         |                                                                                                                                                               | Optional minimal element            |                                          |
| mapping(Function f, Collector dc)                         | Adds another level of collectors.<br>Map first.Then pass to downstream.                                                                                       | Collector                           |                                          |

* I can collect into Long, String, Double, Optional<T>, Map, List, Set...
&nbsp;

### Misc ###
* Function.identity() means s -> s.
* Exception: “stream has already been operated upon or closed.”
* **Reductions are a special type of terminal operation where all of the contents of the stream are combined into a single primitive or Object**.  
  Reductions use all elements of the stream in determining the result.   
  The reductions : count(), max(), min(), reduce(), and collect().  
  The collect() method is a mutable reduction.
* collect() method needs to take in either 1 Collector, or 3 parameters. 
* partitioningBy() operation always returns a map with two Boolean keys,   
  even if there are no corresponding values.   
  By contrast, groupingBy() returns only keys that are actually needed.
* Primitive streams and optionals: **double**, **int**, and **long**  
  There is one exception, which is BooleanSupplier --> boolean
  
&nbsp;

&nbsp;
----
### Useful links ###
* []()