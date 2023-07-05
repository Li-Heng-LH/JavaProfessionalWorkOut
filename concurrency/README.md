# Concurrency
[Cheat Sheet](./CheatSheet.md)

## Some Learning Notes ##

### Threads ###
* A **thread** is the smallest unit of execution that can be scheduled by OS.
* A **process** is a group of associated threads that execute in the same, shared environment.
* Threads in the same process share the same memory space and can communicate directly with one another.
* Static:  
  If one thread updates the value of a static object, then this information is immediately available for other threads **within the process** to read.
* A **task** is a single unit of work performed by a thread.  
  A task will commonly be implemented as a lambda expression.  
  A thread can complete multiple independent tasks but only one task at a time.

&nbsp;

### Thread Types ###
* A system thread is created by the JVM and runs in the background of the application.  
  E.g: garbage-collection thread
* User-defined thread

* **User threads** are high-priority threads. The JVM will wait for any user thread to complete its task before terminating it.
* A **daemon thread** is a thread that does not prevent the JVM from exiting when the program finishes but the thread is still running. 
* Daemon threads are low-priority threads. 
* An example for a daemon thread is the garbage collection. 
* Daemon threads are not recommended for I/O tasks. 

&nbsp;

### Concurrency ###
* The property of executing multiple threads and processes at the same time is referred to as **concurrency**. 
* When a thread’s allotted time is complete but the thread has not finished processing, a context switch occurs. 
* A context switch is the process of storing a thread’s current state and later restoring the state of the thread to continue execution. 
* Thread.MIN_PRIORITY : 1  
  Thread.NORM_PRIORITY : 5
  Thread.MAX_PRIORITY : 10
* By default, user-defined threads receive a thread priority value of Thread.NORM_PRIORITY.

&nbsp;

### Thread VS Runnable ###
* Both in `java.lang`
* **Functional Interface** Runnable
* **Class** Thread 
* Thread **implements** Runnable

* The Runnable interface should be implemented by any class   
  whose instances are intended to be executed by a thread.
* `thread.start()`  
  Causes this thread to begin execution, JVM calls the `run` method of this thread.
* `thread.run()`  
  If this thread was constructed using a separate Runnable run object, then that Runnable object's run method is called;   
  otherwise, this method does nothing and returns.  
  Subclasses of Thread should override this method.
  
* Constructor of Thread:   
  `Thread(Runnable target)`  
  run() method of target is invoked when this thread is started.

&nbsp;

### Creating a Thread ###
* Executing a task with Thread is a two-step process:  
  1. define the Thread with the corresponding task to be done
  2. start the task by using the `Thread.start()`

* Two ways to define a task:  
  1. Provide a `Runnable` object or lambda expression to the Thread constructor `Thread(Runnable target)`    
  2. Create a class that extends `Thread` and overrides the `run()` method.

* Two ways to define a task in short:
  1. **Implementing Runnable**
  2. **Extending Thread**  

* `thread.start()` vs `thread.run()`  
  `thread.run()` will not execute a task on a separate processing thread.   
  Instead, the thread that made the `run()` call will be used to execute the task.

* Which way to create a thread?   
  * In general, you should extend the Thread class only under very specific circumstances,   
  such as when you are creating your own priority-based thread.
  * In most situations, you should implement the Runnable interface rather than extend the Thread class.
  * Implementing Runnable is often a better object-oriented design practice since   
    it separates the task being performed from the Thread object performing it. 
  * Extending Thread does not allow you to extend any other class, whereas implementing Runnable lets you extend another class.

&nbsp;

### Polling with Sleep ###
* Polling is the process of intermittently checking data at **some fixed interval**.
* `Thread.sleep()` method requests **current** thread of execution to rest for a specified number of milliseconds. 

&nbsp;

### Little Summary ###
* `thread.start()` will start in a separate thread, and calls `thread.run()`, which calls `runnable.run()`
* Simply calling `thread.run()` will not start a separate thread.

&nbsp;

### ExecutorService ###
* Concurrency API: `java.util.concurrent`. 
* In Concurrency API, `ExecutorService` creates and manages threads for you.
* Recommended to use this framework anytime you need to create and execute a separate task, 
even if you need only a single thread.

&nbsp;

### ExecutorService, Executors, Executor ### 
* `Executors.newSingleThreadExecutor()` creates an `ExecutorService`. 
* `executorService.execute(Runnable)` executes a given task sometime in the future. 
* `execute` method takes in a Runnable lambda expression or instance and   
  completes the task **asynchronously**.
* Return type of `execute` is void ->   
  * it does not tell us anything about the result of the task
  * fire-and-forget
  * once it is submitted, the results are not directly available to the calling thread

* `interface Executor`
* `interface ExecutorService extends Executor`

&nbsp;

### Executors.newSingleThreadExecutor() ###
* `Executors.newSingleThreadExecutor()`:  
  - Creates an Executor that uses a single worker thread.   
  - Tasks added are guaranteed to execute sequentially, and no more than one task will be active at any given time.
  - 2 threads running: main() thread and ExecutorService thread. 
  - ExecutorService thread will run the added tasks sequentially. 

&nbsp;

### Shutting Down a Thread Executor ###
* After using a thread executor, important to call the `shutdown()` method. 
* A thread executor creates a non-daemon thread on the first task that is executed, 
* failing to call shutdown() will result in your application never terminating. 
* ExecutorService life cycle:   
  - New Thread Executor
  - Active : Accepts New Tasks, Executes Tasks
  - Shutting Down: Rejects New Tasks, Executes Tasks
  - Shutdown : Rejects New Tasks, No Tasks Running
* Calling `shutdown()` will transit into Shutting Down state. 
* Good practice to use try-finally to shut down ExecutorService.

&nbsp;

### Submitting Tasks ###
* In `ExecutorService`:  
  * `void execute(Runnable command)`
  * `Future<?> submit(Runnable task)`
  * `<T> Future<T> submit(Callable<T> task)`
* `execute()` supports only `Runnable`,   
  while `submit()` supports both `Runnable` and `Callable`.
* Therefore in practice, we prefer `submit()` over `execute()`,   
  even if we do not store the reference for the returned Future.   
  We recommend submit() over execute() whenever possible. 

&nbsp;

### Interface Future<V> ###
* where _V_ is the type of the result returned from the get method.
* Simply put, a Future represents the result of an asynchronous computation.

&nbsp;

&nbsp;
----
### Useful links ###
* []()