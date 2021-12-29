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

&nbsp;
----
### Useful links ###
* []()