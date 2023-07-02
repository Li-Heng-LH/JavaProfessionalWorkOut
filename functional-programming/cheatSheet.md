* stream.collect only has 2 variants: 
  * takes in a Collector
  * takes in (Supplier, Biconsumer accumulator, Biconsumer **combiner**)
* Biconsumer combiner takes in 2 parameters, each of type supplied by Supplier. 
* If there is no methods like 'addAll' for combiner, we can definitely self implement it. 
* Collector is an interface. 
* To get a Collector, we use Collectors. 
* (Supplier, Accumulator, Combiner) is NOT to instantiate a Collector. 

&nbsp;

* Collectors.toMap() most complicated form: 
(keyMapper, valueMapper, mergeFunction, mapSupplier)
  * Function keyMapper, 
  * Function valueMapper,
  * BinaryOperator **mergeFunction**, 
  * Supplier mapSupplier
  