* Thread implements Runnable. 
* 2 ways to create a Thread: 
  * Pass in Runnable to Thread constructor. 
  * Extend Thread and override run. 
* `thread.start()` calls `thread.run()`, which calls `runnable.run()` 

&nbsp;

* Executor interface contains method execute. 
* ExecutorService extends Executor, and contains methods like submit, shutdown.
* From Executors we can get instances of ExecutorService. 
* Recommended to use ExecutorService over Thread directly. 

&nbsp;

Interfaces: 
* Runnable 
* Executor 
* ExecutorService
* ScheduledExecutorService
* Future
* ScheduledFuture
* Callable

&nbsp;

| Executor method                | ExecutorService methods                                                                              |
|--------------------------------|------------------------------------------------------------------------------------------------------|
| void execute(Runnable command) | void execute(Runnable command)                                                                       |
|                                | Future<?> submit(Runnable task)                                                                      |
|                                | Future<T> submit(Callable<T> task)                                                                   |
|                                | List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException       |
|                                | T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException |

&nbsp;

Functional Interfaces:  

| Runnable   | Callable                   | Supplier |
|------------|----------------------------|----------|
| void run() | V call () throws Exception | T get () |

&nbsp;


| Future methods                     |
|------------------------------------|
| V get()                            |
| V get(long timeout, TimeUnit unit) |
| boolean isDone()                   |
| boolean isCancelled()              |
| boolean cancel()                   |

* Future from submitting a Runnable returns null when get. 
* Future is NOT a functional interface. 

&nbsp;

* From Executors we get ExecutorService,   
  From ExecutorService we call submit,  
  From submit we get a Future.

* ScheduledFuture extends Future

* Executor --> ExecutorService --> ScheduledExecutorService  
  execute --> submit --> schedule
  
* Blocking operations: 
  * Future.get()
  * ExecutorService.invokeAll
  

