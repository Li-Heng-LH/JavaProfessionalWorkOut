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
  
* Blocking operations: 
  * Future.get()
  * ExecutorService.invokeAll
* Non-Blocking operations: 
  * execute
  * submit
  * schedule

* After execute, submit, schedule, need to have main thread running to wait for threads. 
* using scheduleAtFixedRate with newScheduledThreadPool, an available thread will pick up 
the next scheduled task. 

