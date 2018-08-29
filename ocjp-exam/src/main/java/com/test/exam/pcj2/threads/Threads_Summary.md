### Threads Resumen

1. ###### __El _thread_ Scheduler__
    Es la parte de la JVM que se encarga de decidir en cada comento que _thread_ debe entrar en ejecución. Cualquier _thread_ que este en el estado de "prepaparado" puede ser elegido para la ejecución, si bien hay que tener en  cuenta que __no está garantizado el orden en el que estos _thread_ se ejecutarán__, dependiendo este hecho de la implementación de la JVM.

1. ###### __Métodos de control de un Thread__
    Los siguientes métodos de la clase Thread pueden untilizarse para controlar el funcionamiento de un _thread_:
    ```java
        public Thread currentThread()
    ```
    ```java
        public void setName(String name)
    ```
     ```java
        public static void sleep(int ms) throws InterruptedException
    ```
     ```java
        public static void yield()
    ```
     ```java
        public final void join() throws InterruptedException
    ```
     ```java
        public final void setPriority(int pt)
    ```
    Además de éstos la clase Object proporciona los siguientes métodos para ser utilizados en aplcaciones multitarea:
    ```java
        public final void wait()
    ```
    ```java
        public final void notify()
    ```
    ```java
        public final void notifyAll()
    ```
    Es muy probable encontrar algun pregunta de examen en el que se tenga que  elegir entre una lista de métodos, aquellos que esten definidos explicitamente en la clase Thread. Por lo que los de Object no deben ser elegidos o puede ser visceversa. de todos modos solo hay que aprendernos cuales son de Object y cuales don de Thread.
    
1. ###### __Situaciones que podrían provocar que un _thread_ abandonase la ejecución__
    Es prácticmaente seguro encontrar alguna pregunta de examen relativa a los métodos que pueden hacer que un _thread_ abandone su ejecución. Para responder correctamente a estas cuestiones, es necesario tener en cuenta una serie de aspectos sobre los siguientes métodos:

    * _sleep()_. Como sabemos, la llamada a _sleep()_ provoca que el _thread_ abandone la ejecución, por lo menos, durante el periodo de tiempo especificado. Es necesario inicidir en un hecho importante y es que __una vez que el _thread_ despierte volverá al estado "prepaparado", no a ejecución,__ por tanto, el tiempo especificado en la llamada a _sleep()_ será el __mínimo__ tiempo que el _thread_ esté fuera de ejecución.
    
    * _yield()_. Normalmente, devuelve el _thread_ al estado de "prepaparado", de modo que otro _thread_ con su misma prioridad tenga la oportunidad de ejecutarse, no obstante, no está garantizado que esto suceda por lo que __no puede asegurarse que un _thread_ abandone la ejecución cuando invoque a este método.__
    
    * _join()_. Aunque podría darse el caso de que el _thread_ al que se intenta unir ya haya finalizado su ejecución y, por tanto, no necesita esperar a que esto suceda, __cuando un _thread_ invoca al método join() sobre otro abandona automáticamente el estado de ejecución.__
    
    * _wait()_. Cando un _thread_ invoca al método _wait()_ sobre un objeto __abandona automáticamente el estado de ejecución__.
    
    Evidentemente cuando un _thread_ finaliza la ejecución del método _run()_ también abandonará el estado de ejecución.
    
1. ###### __Sincronización y acceso concurrente__
    Sobre el tema de sincronización y monitores debemos tener en cuenta los siguientes puntos importantes:
    * Se puede sincronizar tanto un bloque de código como un método entero: 
        ```java
        synchronized void metodo1() {
            //método sincronizado
        }
        ```
        ```java
        void metodo2() {
                .
                .
                synchronized (objeto) {
                    //bloque sincronizado
                }
        }
        ```
    * Las __variables no se pueden sincronizar__. Cuidado con  las cuestiones de examen en las que aparece _synchronized_ como modificador de acceso de una variable, esto no esta permitido.
    
    * Si hay más de un método _synchronized_ en una clase, __solamente un _thread_ puede acceder a uno de los métodos _synchronized.___ Ningún otro _thread_ podrá acceder a los otros métodos  _synchronized_ mientras el primer _thread_ tenga el monitor del objeto, aunque si podrán hacerlo a los métodos no sincronizados.
    
    * Un _thread_ puede adquirir más de un monitor, Si un _thread_ entra en un bloque _synchronized_ adueire el monitor del objeto, pero si desde este método se hace una llamada a otro método _synchronized_ de otro objeto, también adquirirá su monitor.
    
    * Un método estático puede ser _synchronized_. En este caso, se adquiere un monitor para la clase completa.

1. ###### __Métodos wait(), notify() y notifyAll()__
    Estos métodos permiten comunicar _threads_ entre sí. De cara a las cuestiones de examen en las que directa o indirectamente estén involucrados estos métodos hay que tener en cuenta los siguientes puntos:

    *  La llamada a estos métodos sólo puede realizarse en el interior de un bloque o método  _synchronized_.
    
    * Un _thread_ solamente puede invocar al método _wiat()_ o _notify()_ de un objeto si dispone del monitor de éste. Si un _thread_ invoca al método _wait()_ de un objeto sin disponer de su monitor se producirá una excepción de tipo __IllegalMonitorStateException.__
    
    * Cuando se invoca al método _notify()_ de un objeto, su monitor no se libera inmediatamente. Esto no se produce hasta que se completa la ejecución del código sincronizado.
    