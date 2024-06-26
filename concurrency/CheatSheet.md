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
* Variables or classes cannot be synchronized
#### synchronized instance methods
  * Every object in Java has exactly ONE build-in lock.
  * when we enter a synchronized instance method, we acquire the lock associated with this object instance.
  * Acquiring lock = getting the lock = locking the object = locking on the object = synchronizing on the object
  * Monitor: is the object whose lock we are acquiring
  * Once a thread acquires the lock on an object, no other thread can enter **any** synchronized method in that class.
  * A thread can acquire more than 1 lock. 
  * When a thread has acquired a lock and attempts to call a synchronized method on that same object, no problem. 
  * JVM knows that this thread already has the lock for this object,   
    so this thread is free to call other synchronized methods on the same object, using the lock the thread already has.
  * If a thread goes to sleep, it holds any locks it has. It does not release any lock. 
#### synchronized block
* when we synchronize a block of code, we can specify which object's lock we want to use as the lock.
#### synchronized static methods
```java
public static synchronized int getCount() {
    return 1;
}
```
is equivalent to 
```java
public static int getCount() {
    synchronized(MyClass.class ) {
        return 1;
    }
}
```
#### blocked state
* when a thread tires to enter a synchronized method and the lock is already taken,  
  the thread is said to be blocked on the object's lock. 
* the thread goes into a kind of pool for that object and sits there until the lock is released,   
  and the thread can become runnable/running again.
* Just because the lock is released does not mean any particular thread will get it   
  as there may be several other threads waiting for the same lock.
#### General rule of thumb
* Access to static fields should be done using static synchronized methods
* Access to non-static fields should be done using non-static synchronized methods

### "Thread-safe" classes
* A "thread-safe" class is a class that has been carefully synchronized to protect its data.
* Many classes in Java API already use synchronization internally to be "thread-safe".  

| StringBuffer  | methods are synchronized when necessary          |
|---------------|--------------------------------------------------|
| StringBuilder | a bit faster as it does not bother synchronizing |



