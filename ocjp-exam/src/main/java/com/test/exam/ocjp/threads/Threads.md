### Threads Notes

1. So what exactly is a thread? In Java, "thread" means two different things:
    * An instance of class java.lang.Thread
    * A thread of execution

1. ##### __Extending java.lang.Thread__
    The simplest way to define code to run in a separate thread is to
    * Extend the java.lang.Thread class.
    * Override the run() method.
    
    It looks like this:

    ```java
        class MyThread extends Thread {
            public void run() {
                System.out.println("Important job running in MyThread");
            }
        }
    ```
    The limitation with this approach (besides being a poor design choice in most cases) is that if you extend Thread, you can't extend anything else
    
    Keep in mind that you're free to overload the run() method in your Thread subclass:
    ```java
            class MyThread extends Thread {
                public void run() {
                    System.out.println("Important job running in MyThread");
                }
                public void run(String s) {
                    System.out.println("String in run is " + s);
                }
            }
    ```
    
    But know this: The overloaded run(String s) method will be ignored by the Thread class unless you call it yourself. The Thread class expects a run() method with no arguments, and it will execute this method for you in a separate call stack after the thread has been started. With a run(String s) method, the Thread class won't call the method for you, and even if you call the method directly yourself, execution won't happen in a new thread of execution with a separate call stack. It will just happen in the same call stack as the code that you made the call from, just like any other normal method call.
    
1. ##### __Implementing java.lang.Runnable__

    Implementing the Runnable interface gives you a way to extend from any class you like, but still define behavior that will be run by a separate thread. It looks like this:
    ```java
        class MyRunnable implements Runnable {
            public void run() {
                System.out.println("Important job running in MyRunnable");
            }
        }
    ```
    Regardless of which mechanism you choose, you've now got yourself some code that can be run by a thread of execution.

1. ##### __Instantiating a Thread__
    Regardless of whether your run() method is in a Thread subclass or a Runnable implementation class, you still need a Thread object to do the work.

    If you extended the Thread class, instantiation is dead simple:
    ```java
        MyThread t = new MyThread()
    ```
    If you implement Runnable, instantiation is only slightly less simple (Another common way to think about this is that the Thread is the "worker," and the Runnable is the "job" to be done.).
    First, you instantiate your Runnable class:
    ```java
        MyRunnable r = new MyRunnable();
    ```
    Next, you get yourself an instance of java.lang.Thread (somebody has to run your job…), and you give it your job!
    ```java
        Thread t = new Thread(r); // Pass your Runnable to the Thread
    ```
    If you create a thread using the no-arg constructor, the thread will call its own run() method when it's time to start working. That's exactly what you want when you extend Thread, but when you use Runnable, you need to tell the new thread to use your run()method rather than its own. The Runnable you pass to the Thread constructor is called the target or the target Runnable.
    
    You can pass a single Runnable instance to multiple Thread objects, so that the same Runnable becomes the target of multiple threads, as follows:
    ```java
            public class TestThreads {
                public static void main (String [] args) {
                    MyRunnable r = new MyRunnable();
                    Thread foo = new Thread(r);
                    Thread bar = new Thread(r);
                    Thread bat = new Thread(r);
                }
            }
    ```
    Giving the same target to multiple threads means that several threads of execution will be running the very same job (and that the same job will be done multiple times).
    
    __==================================================================================__
    __Exam Watch__
    The Thread class itself implements Runnable. (After all, it has a run() method that we were overriding.) This means that you could pass a Thread to another Thread’s constructor:
    ```java
            Thread t = new Thread(new MyThread());
    ```
    This is a bit silly, but it’s legal. In this case, you really just need a Runnnable, and creating a whole other Thread is overkill.
    __==================================================================================__
    
    there are other overloaded constructors in class Thread. The constructors we care about are:
    ```java
            Thread()
    ```
    ```java
            Thread(Runnable target)
    ```
    ```java
            Thread(Runnable target, String name)
    ```
    ```java
            Thread(String name)
    ```
    You need to recognize all of them for the exam!
    
    When a thread has been instantiated but not started (in other words, the start() method has not been invoked on the Thread instance), the thread is said to be in the __new state.__ At this stage, the thread is not yet considered to be alive. Once the _start()_ method is called, the thread is considered to be __alive__ (even though the _run()_ method may not have actually started executing yet). A thread is considered __dead__ (no longer alive) after the _run()_ method completes.

1. ##### __Starting a Thread__
    To launch a new call stack. It's so simple it hardly deserves its own subheading:
    ```java
        t.start();
    ```
    So what happens after you call start()? The good stuff:
    * A new thread of execution starts (with a new call stack).
    * The thread __moves from the new state to the runnable state.__
    * When the thread gets a chance to execute, its target run() method will run.
    
    Be sure you remember the following: You start a Thread, not a Runnable. You call start() on a Thread instance, not on a Runnable instance. The following example demonstrates what we've covered so far—defining, instantiating, and starting a thread:
    ```java
            class FooRunnable implements Runnable {
                public void run() {
                    for(int x =1; x < 6; x++) {
                        System.out.println("Runnable running");
                    }
                }
            }
     ```
    ```java
            public class TestThreads {
                public static void main (String [] args) {
                    FooRunnable r = new FooRunnable();
                    Thread t = new Thread(r);
                    t.start();
                }
            }
    ```
     __==================================================================================__
    __Exam Watch__
    There’s nothing special about the run() method as far as Java is concerned. Like main(), it just happens to be the name (and signature) of the method that the new thread knows to invoke. So if you see code that calls the run() method on a Runnable (or even on a Thread instance), that’s perfectly legal. But it doesn’t mean the run() method will run in a separate thread! Calling a run() method directly just means you’re invoking a method from whatever thread is currently executing, and the run() method goes onto the current call stack rather than at the beginning of a new call stack. The following code does not start a new thread of execution:
    
    ```java
        Thread t = new Thread();
        t.run(); // Legal, but does not start a new thread
    ```
     __==================================================================================__
     The following example instantiates a thread and gives it a name, and then the name is printed out from the _run()_ method:
     ```java
             class NameRunnable implements Runnable {
                public void run() {
                    System.out.println("NameRunnable running");
                    System.out.println("Run by "
                        + Thread.currentThread().getName());
                }
            }
     ```
     ```java
            public class NameThread {
                public static void main (String [] args) {
                    NameRunnable nr = new NameRunnable();
                    Thread t = new Thread(nr);
                    t.setName("Fred");
                    t.start();
                }
            }
     ```
     Running this code produces the following, extra special, output:
     ```
        % java NameThread
        NameRunnable running
        Run by Fred
    ```
    To get the name of a thread you call—who would have guessed—getName() on the Thread instance. But the target Runnable instance doesn't even have a reference to the Thread instance, so we first invoked the static Thread.currentThread() method, which returns a reference to the currently executing thread, and then we invoked getName() on that returned reference. 
    Esto quiere decir que como no tenemos una instancia Thread, ya que implementamos de Runnable entonces debemos hacer esto __Thread.currentThread()__ para obtener el name con el método _getName()_.
    Even if you don't explicitly name a thread, it still has a name. Let's look at the previous code, commenting out the statement that sets the thread's name:
     ```java
         public class NameThread {
            public static void main (String [] args) {
                NameRunnable nr = new NameRunnable();
                Thread t = new Thread(nr);
                // t.setName("Fred");
                t.start();
            }
        }
     ```
    Running the preceding code now gives us
    ```
        % java NameThread
        NameRunnable running
        Run by Thread-0
    ```
    Esto queire decir que aunque no proporcionemos un nombre al _thread_ este tendrá por default un nombre.
    Figure 9-1 shows the process of starting a thread.
    ![Imgur](https://i.imgur.com/IRp62f1.jpg)

1. ##### __Starting and Running Multiple Thread__
    We already had two threads, because the main() method starts in a thread of its own, and then t.start() started a second thread.
    The following code creates a single Runnable instance and three Thread instances. All three Thread instances get the same Runnable instance, and each thread is given a unique name. Finally, all three threads are started by invoking start() on the Thread instances.
    ```java    
        class NameRunnable implements Runnable {
            public void run() {
                for (int x = 1; x <= 3; x++) {
                    System.out.println("Run by "
                        + Thread.currentThread().getName()
                            + ", x is " + x);
                }
            }   
        }
        
        public class ManyNames {
            public static void main(String [] args) {
                // Make one Runnable
                NameRunnable nr = new NameRunnable();
                Thread one = new Thread(nr);
                Thread two = new Thread(nr);
                Thread three = new Thread(nr);
                one.setName("Fred");
                two.setName("Lucy");
                three.setName("Ricky");
                one.start();
                two.start();
                three.start();
            }
        }
    ```   
    Just because a series of threads are started in a particular order doesn't mean they'll run in that order. A thread is done being a thread when its target run() method completes. When a thread completes its run() method, the thread ceases to be a thread of execution. The stack for that thread dissolves, and the thread is considered dead. Once a thread has been started, it can never be started again. And it's the thread scheduler that decides which thread—of all that are eligible—will actually run. When we say eligible, we really mean in the runnable state. The order in which runnable threads are chosen to run is not guaranteed.

1. ##### __Methods from the java.lang.Thread Class__
    Some of the methods that can help us influence thread scheduling are as follows:
    ```java
        public static void sleep(long millis) throws InterruptedException
        public static void yield()
        public final void join() throws InterruptedException
        public final void setPriority(int newPriority)
    ```
    Note that both sleep() and join() have overloaded versions not shown here.
    
    Methods from the java.lang.Object Class Every class in Java inherits the following three thread-related methods:
    ```java
        public final void wait() throws InterruptedException
        public final void notify()
        public final void notifyAll()
    ```
1. ##### __Thread States__
    
    * __New__ This is the state the thread is in after the Thread instance has been created, but the start() method has not been invoked on the thread. It is a live Thread object, but not yet a thread of execution. At this point, the thread is considered not alive.
     
    * __Runnable__ This is the state a thread is in when it's eligible to run, but the scheduler has not selected it to be the running thread. A thread first enters the runnable state when the _start()_ method is invoked, but a thread can also return to the runnable state after either running or coming back from a blocked, waiting, or sleeping state. When the thread is in the runnable state, it is considered alive.
    
    * __Running__ This is it. The "big time." Where the action is. This is the state a thread is in when the thread scheduler selects it (from the runnable pool) to be the currently executing process. A thread can transition out of a running state for several reasons, including because "the thread scheduler felt like it." We'll look at those other reasons shortly. Note that in Figure 9-2, there are several ways to get to the runnable state, but only one way to get to the running state: the scheduler chooses a thread from the runnable pool.
     
    * __Waiting/blocked/sleeping__ This is the state a thread is in when it'sceligible to run. Okay, so this is really three states combined into one, but they all have one thing in common: the thread is still alive, but is currently not eligible to run. In other words, it is not runnable, but it might return to a runnable state later if a particular event occurs.
    
    * __Dead__ A thread is considered dead when its run() method completes. It may still be a viable Thread object, but it is no longer a separate thread of execution. Once a thread is dead, it can never be brought back to life! If you invoke start() on a dead Thread instance, you'll get a runtime (not compiler) exception.
    ![Imgur](https://i.imgur.com/6XyADVX.jpg)

1. __Sleeping__
    The sleep() method is a static method of class Thread. You use it in your code to "slow a thread down" by forcing it to go into a sleep mode before coming back to runnable. When a thread sleeps, it drifts off somewhere and doesn't return to runnable until it wakes up.
You do this by invoking the static Thread.sleep() method, giving it a time in milliseconds as follows:
     ```java
           try {
                Thread.sleep(5*60*1000); // Sleep for 5 minutes
            } catch (InterruptedException ex) { }
    ```
    Let's modify our Fred, Lucy, Ricky code by using sleep() to try to force the threads to alternate rather than letting one thread dominate for any period of time. Where do you think the sleep() method should go?
    
      ```java
              class NameRunnable implements Runnable {
            	public void run() {
            		for (int x = 1; x < 4; x++) {
            			System.out.println("Run by " 
            			    + Thread.currentThread().getName());
            			try {
            				Thread.sleep(1000);
            			} catch (InterruptedException ex) {
            			}
            		}
            	}
            }

        public class ManyNames {
        	public static void main(String[] args) {
        		// Make one Runnable
        		NameRunnable nr = new NameRunnable();
        		Thread one = new Thread(nr);
        		one.setName("Fred");
        		Thread two = new Thread(nr);
        		two.setName("Lucy");
        		Thread three = new Thread(nr);
        		three.setName("Ricky");
        		one.start();
        		two.start();
        		three.start();
        	}
        }
    ```
    Just keep in mind that the behavior in the preceding output is still not guaranteed. You can't be certain how long a thread will actually run before it gets put to sleep, so you can't know with certainty that only one of the three threads will be in the runnable state when the running thread goes to sleep. In other words, if there are two threads awake and in the runnable pool, you can't know with certainty that the least recently used thread will be the one selected to run. Still, using sleep() is the best way to help all threads get a chance to run! Or at least to guarantee that one thread doesn't get in and stay until it's done.
         __==================================================================================__
    __Exam Watch__
    Just because a thread’s sleep() expires, and it wakes up, does not mean it will return to running! Remember, when a thread wakes up, it simply goes back to the runnable state. So the time specified in sleep() is the minimum duration in which the thread won’t run, but it is not the exact duration in which the thread won’t run. So you can’t, for example, rely on the sleep() method to give you a perfectly accurate timer. Although in many applications using sleep() as a timer is certainly good enough, you must know that a sleep() time is not a guarantee that the thread will start running again as soon as the time expires and the thread wakes.
 __==================================================================================__
Remember that _sleep()_ is a static method, so don't be fooled into thinking that one thread can put another thread to sleep. You can put sleep() code anywhere, since all code is being run by some thread. When the executing code (meaning the currently running thread's code) hits a sleep() call, it puts the currently running thread to sleep.

1. ##### __Thread Priorities__
    Threads always run with some priority, usually represented as a number between 1 and (although in some cases the range is less than 10).
You can also set a thread's priority directly by calling the setPriority() method on a Thread instance as follows:
    ```java
        FooRunnable r = new FooRunnable();
        Thread t = new Thread(r);
        t.setPriority(8);
        t.start();
    ```
    Priorities are set using a positive integer, usually between 1 and 10, and the JVM will never change a thread's priority. However, the values 1 through 10 are not guaranteed. Although the default priority is 5, the Thread class has the three following constants (static final variables) that define the range of thread priorities:
    ```java
        Thread.MIN_PRIORITY (1)
        Thread.NORM_PRIORITY (5)
        Thread.MAX_PRIORITY (10)
    ```
1. ##### __The yield( ) Method__
    So what does the static Thread.yield() have to do with all this? Not that much, in practice. What yield() is supposed to do is make the currently running thread head back to runnable to allow other threads of the same priority to get their turn.

1. ##### __The join( ) Method__
    The non-static join() method of class Thread lets one thread "join onto the end" of another thread. If you have a thread B that can't do its work until another thread A has completed its work, then you want thread B to "join" thread A. This means that thread B will not become runnable until A has finished (and entered the dead state).
    ```java
        Thread t = new Thread();
        t.start();
        t.join();
    ```
    The preceding code takes the currently running thread (if this were in the main() method, then that would be the main thread) and joins it to the end of the thread referenced by t. This blocks the current thread from becoming runnable until after the thread referenced by t is no longer alive. In other words, the code t.join() means "Join me (the current thread) to the end of t, so that t must finish before I (the current thread) can run again.
    
    So far we've looked at three ways a running thread could leave the running state:
    * A __call to sleep()__ Guaranteed to cause the current thread to stop executing for at least the specified sleep duration (although it might be interrupted before its specified time).
    
    * A __call to yield()__ Not guaranteed to do much of anything, although
typically it will cause the currently running thread to move back to runnable so that a thread of the same priority can have a chance.

    * A __call to join()__ Guaranteed to cause the current thread to stop executing until the thread it joins with (in other words, the thread it calls join()  completes, or if the thread it's trying to join with is not alive, however, the current thread won't need to back out.
    
    Besides those three, we also have the following scenarios in which a thread might leave the running state:
    
    * The thread's run() method completes. Duh.
    * A call to wait() on an object
    * A thread can't acquire the lock on the object whose method code it's
attempting to run.
    * The thread scheduler can decide to move the current thread from running
to runnable in order to give another thread a chance to run. No reason is
needed—the thread scheduler can trade threads in and out whenever it likes. 

1. ##### __Synchronizing Code__
    The following code demonstrates what happens when two different threads are accessing the same account data.
    _Ver Ejemplo_ __*com.test.exam.ocjp.threads.synchronized*__

    Figure 9-4 shows the timeline of what can happen when two threads concurrently access the same object. This problem is known as a "race condition," where multiple threads can access the same resource (typically an object's instance variables), and can produce corrupted data if one thread "races in" too quickly before an operation that should be "atomic" has completed.

    ![Imgur](https://i.imgur.com/4Cc6RoE.jpg)

1. ##### __Synchronization and Locks__
    En resumen esto es para evitar que varios threads accedan a los mismos datos que normalemnte son variables de instancia y con eso evitar que los datos se corrompan ya que como se muestra en el diagrama de arriba en un tiempo determinado 2 threads pueden acceder  a la misma referencia.
Ahora bien, cuando declaramos un método o un bloque de código como synchronized el thread actual adquiere su lock o su monitor y con esto puede hacer a que los otros threads se esperen y entran en un estado como "bloqueado" eso es un pool donde se van metiendo lso threads hasta que el thread "suelte" el monitor y entonces otro thread ya puede tomar el monitor, es como liberar un recurso.
Remember the following key points about locking and synchronization:
    *  Only methods (or blocks) can be synchronized, not variables or classes.
    *  Each object has just one lock.
    *  Not all methods in a class need to be synchronized. A class can have both synchronized and non-synchronized methods.
    *  If two threads are about to execute a synchronized method in a class, and
both threads are using the same instance of the class to invoke the method, only one thread at a time will be able to execute the method. The other thread will need to wait until the first one finishes its method call. In other words, once a thread acquires the lock on an object, no other thread can enter any of the synchronized methods in that class (for that object).
    * If a class has both synchronized and non-synchronized methods, multiple
threads can still access the class's non-synchronized methods! If you have methods that don't access the data you're trying to protect, then you don't need to synchronize them. Synchronization can cause a hit in some cases (or even deadlock if used incorrectly), so you should be careful not to overuse it.
    * If a thread goes to sleep, it holds any locks it has—it doesn't release them.
    * A thread can acquire more than one lock. For example, a thread can enter a
synchronized method, thus acquiring a lock, and then immediately invoke a synchronized method on a different object, thus acquiring that lock as well. As the stack unwinds, locks are released again. Also, if a thread acquires a lock and then attempts to call a synchronized method on that same object, no problem. The JVM knows that this thread already has the lock for this object, so the thread is free to call other synchronized methods on the same object, using the lock the thread already has.
    * You can synchronize a block of code rather than a method.

    When thinking about blocking, it's important to pay attention to which objects are being used for locking.
    *   Threads calling non-static synchronized methods in the same class will only block each other if they're invoked using the same instance. That's because they each lock on this instance, and if they're called using two different instances, they get two locks, which do not interfere with each other. Este punto es importante porque como hemos visto en los ejemplos anteriores todo se hace sobre el mismo objeto o la misma refrencia, pero si se crean 2 diferentes objetos son independientes por lo que cada uno tendrá su propio monitor.
    * Threads calling static synchronized methods in the same class will always block each other—they all lock on the same Class instance. 
    * static synchronized method and a non-static synchronized method will not block each other, ever. The static method locks on a Class instance while the non-static method locks on the this instance—these actions do not interfere with each other at all.
    * For synchronized blocks, you have to look at exactly what object has been used for locking. (What's inside the parentheses after the word synchronized?) Threads that synchronize on the same object will block each other. Threads that synchronize on different objects will not.
    * No hay que preocuparse de las vairbles locales cuando usamos threads ya que cada thread crea sus propias copias de vairables de instancia, por tanto solo hay que preocparnos de las variables de instancia o de objetos que se puedan corromper.
    * Para entender mejor esto podriamos decir que si varios threads van a manipular un mismo objeto entonces si debemos tener cuidado y en los casos que sea necesario debemos usar synchronized para que adquiere su monitor y los otros threads queden bloqueados en espera que el recurso sea liberado. Por otro lado si cada uno de esos threads va a trabajar objetos no compartidos entonces no hay problema y no se necesita la sincronización.
    
         __==================================================================================__
    __Exam Watch__
    The methods wait() , notify(), and notifyAll() are methods of only java.lang.Object, not of java.lang.Thread or java.lang.Runnable. Be sure you know which methods are defined in Thread, which in Object, and which in Runnable (just run(), so that’s an easy one). Of the key methods in Thread, be sure you know which are static—sleep() and yield(), and which are not static—join() and start(). Table 9-2 lists the key methods you’ll need to know for the exam, with the static methods shown in italics.
    ![Imgur](https://i.imgur.com/Tdfy5b7.jpg)
 __==================================================================================__   
