# Concurrency


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
  Causes this thread to begin execution, JVM calls the run method of this thread.
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
  1. Provide a Runnable object or lambda expression to the Thread constructor `Thread(Runnable target)`    
  2. Create a class that extends Thread and overrides the `run()` method.

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

&nbsp;
----
### Useful links ###
* []()