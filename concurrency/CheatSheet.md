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
* Runnable, Executor, ExecutorService, Future, Callable

&nbsp;

Executor method: 
* void execute(Runnable command);

ExecutorService methods: 
* 

&nbsp;