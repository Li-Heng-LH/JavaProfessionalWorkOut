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
* Runnable (Functional Interface)
* Executor 
* ExecutorService
* ScheduledExecutorService
* Future
* ScheduledFuture
* Callable (Functional Interface)

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

*
| Executor        | ExecutorService         | ScheduledExecutorService  |
|-----------------|-------------------------|---------------------------|
| execute command | execute command         | execute command           |
|                 | submit command/callable | submit command/callable   |
|                 | invoke callables        | invoke callables          |
|                 |                         | schedule command/callable |
|                 |                         | scheduleAt command        |

* Yes the main thread will not wait for other threads. But JVM will finish all threads.
* using scheduleAtFixedRate with newScheduledThreadPool, an available thread will pick up 
the next scheduled task. 

### Race Conditions
* the unexpected result of two tasks executing at the same time
is referred to as a race condition. 

### Atomic ###
* single unit of execution
* no interference by another thread
* Example: Atomic increment operator: 
  * performed the read and write of the variable as a single operation, 
  * not allowing any other threads to access the variable during the operation.

### Monitor / Lock ###
* A monitor/lock is a structure that supports mutual exclusion, 
* (property that at most one thread is executing a particular segment of code at a given time)
* In Java, any Object can be used as a monitor, along with the `synchronized` keyword

### The different levels to address race conditions ###
| Solution       | Effect             |
|----------------|--------------------|
| Race condition | repetition,  1 2 2 |
| Atomic         | not ordered, 2 1 3 |
| synchronized   | ordered            |


### synchronized 
* synchronized keyword can be used on different levels:
  1. Instance methods
  2. Static methods
  3. Code blocks
* Monitor object: 
