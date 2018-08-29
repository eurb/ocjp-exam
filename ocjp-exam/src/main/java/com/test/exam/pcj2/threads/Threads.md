### Threads Notas

1. El paquete java.lang incluye dos elementos para la creación de apliaciones multitarea en java: La clase **Thread** y la interfaz **Runnable**. Mediante éstos, disponemos de de dos caminos alternativos a la hora de implementar una aplicación multitarea:

	* Heredar de de la clase Thread
	* Implementar de la interfaz Runnable

1. ##### Heredar de la clase _Thread_
    Si usamos el método de heredar de la clase Thread, entonces la cración y ejecución de tareas en modo multitarea utilzando este método  requeire la realiación de los siguientes pasos:

	* Sobreescritura del método _run()_ de la clase Thread
	* Creación y ejecución de las tareas.
	
1. Cuando se crea un objeto thread éste pasa al estado de "nuevo", pero aún no se produce la ejecución de la tarea asociada. Para que esto suceda habrá que invocar explicitamente al método _start()_ de cada objeto Thread.

1. El método _start()_ se encuentra definido en la clase Thread, la llamada a este método _start()_ provoca que el _thread_ pase al estado de "preparado". En esta situación el gestor de tareas de la JVM (_thread scheduler_) podrá, en cualquier momento, elegir la tarea para su ejecución invocando al método _run()_ del objeto.

1. Todas las tareas que esten en estado "preparado", estarán listas para su ejecución. siendo responsabilidad del _gestor de tareas_ (_thread scheduler_) el reparto del tiempo de la CPU entre cada una de ellas y el orden de ejecución de las mismas.
_Ver Ejemplo_ __*com.test.exam.pcj2.threads.declaration.extend*__

1. ##### Métodos para el control de threads

	1. ###### El método _sleep()_ 
	
	 	_Ver Ejemplo_ __*com.test.exam.pcj2.threads.declaration.extend.sleep*__
		* Su formato es el siguiente:
		```java
		public static void sleep(long tiempo) throws InterruptedException
		```
		Se trata de un método estático que, al ser invocado, pone a 		"dormir" el _thread_ en 		ejecución durante los milisegundos 		especificados en el argumento. Mientras 		el 		_thead_ está dormido 		no podrá ser puesto en ejecución por el gestor de tareas, hasta 		que, una vez transcurrido el período de descanso, vuelva al 		estado de 		"preparado"
		
	1. ###### Nombre de un Thread
	     La clase Thread dispone de métodos para establecer y obtener el nombre de un thread:
    	```java
    		public void setName(String nombre)
    		public String getName()
    	```
    	Tambien se puede establecer el nombre de un _thread_ cuando se crea utlizando el siguiente constructor:
    	```java
    	    public Thread(String nombre)
    	```
    1. ###### Obtener el Thread en ejecución
        La clase Thred dispone de un método estático _currentThread()_ que permite obtener una referencia al thread actual en ejecución su formato es:
        ```java
    	    public static  Thread currentThread()
    	```
    	_Ver Ejemplo_ __*com.test.exam.pcj2.threads.declaration.extend.currentThread*__
    1. ###### Prioridad de un thread
        La prioridad de un _thread_ es un factor importante a tener en cuenta por el gestor de tareas a la hora de repartir la CPU entre las mismas. De forma predeterminada, todo _thread_ tiene asignada una prioridad al moment ode su creación, la cual es la misma que la del _thread_ que lo crea.
        Es posible establecer explicitamente una prioridad a una tarea mediante el método _setPriority()_ de la clase Thread, su formato es:
        ```java
    	    public void setPriority(int p)
    	```
    	Donde el argumento del método representa la prioridad establecida y cuyo valor puede ser cualquier entero entre el 1 y 10 (1 prioridad mínima, 10 prioridad máxima).
    
    1. ###### El método yield()
        Lo que hace este método es devolver el _thread_ en ejecución al estado de "preparado", poniendo en ejecución otro thred de su misma prioridad. su formato es:
        ```java
    	    public static void yield()
    	```
	1. ###### El método join()
	    Se utiliza para unir un _thread_ con el final de otro _thread_ de modo que el thread primero quedará bloqueado en el estado "preparado" hasta que finalice la ejecución del _thread_ con el que se ha enlazado, El formato es:
         ```java
    	    public void join() throws InterruptedException
    	```
        Si "A" es un objeto _thread_, el thread que ejecute la instrucción:
         ```java
    	    A.join();
    	```
    	
    	pasará al estado "preparado" hasta que finalize la tarea "A".
    	
1. ##### Estados de un _thread_
    Un _thread_ puede encontrarse en uno de los siguientes estados:
    * __*Nuevo.*__ El _thread_ entra en este estado al crear la instancia de la clase Thread asociada, permaneciendo en él hasta que se produzca la llamada a _start()_. Un _thread_  en el estado "nuevo" aún no se considera vivo.
    
    *  __*Preparado.*__ Un _thread_ entra en este estado al invocar al método _start()_, aunque también puede regresar a él después de haber estado en ejecución, dormido o bloqueado. Un _thread_ en estado "preparado" ya se considera vivo.
     
    *   __*Ejecución.*__ El _thread_ entra en este estado cuando el _sheduler_ lo selecciona para su ejecución.
    
    *   __*Esperando/bloqueado/dormido.*__ Son tres estados combinados en uno y se caracterizan porque el _thread_ aún esta vivo pero no preparado, pudiendo estar dormido, bloqueado, a la  espera de algún recurso o en espera.
    
    *   __*Finalizado.*__ Un _thread_ se considera que ha finalizado cuando termina la ejecución de su método _run()_. __Una vez que el _thread_ finaliza no puede volver de nuevo al estado preparado__, por ello, si se invoca al método _start()_ por seguna vez sobre un _thread_ __se producirá una excepción__ de tipo IllegalThreadStateException.

1. ##### Implementar de la interfaz _Runnable_
    Es la más común y la que mas se utiliza en lugar de heredar de la clase _Thread_. Si optamos por esta via las acciones que tenemos que llevar acabo serán:

    * Implementar el método _run()_ de la interfaz _Runnable_
    * Creación y ejecución de tareas
    
    _Ver Ejemplo_ __*com.test.exam.pcj2.threads.declaration.implement*__
    
    1. ###### Creación y ejecución de tareas
    
        Toda tarea en ejecución es un thread. Esto significa que habrpa que crear __tantos objetos de la clase Thread como tareas queramos poner en ejecución__
        
        Para crear objetos Thread debemos usar alguno de los siguientes constructores de la clase Thread:
        ```java
            Thread(Runnable obj)
        ```
         ```java
            Thread(Runnable obj, String nombre)
        ```

1. ##### Sincronización y monitores
    La sincronización de un bloque de código consiste en impedir la entrada de un _thread_ al bloque hasta que el último thread en entrar a ducho bloque finalice la ejecución del mismo, de esta forma se garantiza que todas las instrucciones del bloque son ejecutadas completamente por un _thread_ antes de que otro entre en el mismo.

    La sincronización de bloques de cpodigo se basa en el uso de monitores o _"cerrojos"_. Todo objeto lleva asociado un monitor, el cual puede ser adquirido por un único _thread_. Cuando se sincroniza un bloque de código, es neceario indicar el objeto cuyo monitor será utilizado para controlar el proceso de sincronización de la sigiente forma:
    
    ```java
        synchronized(ref_objeto) 
        {
            //bloque de instrucciones a sincronizar
        }
    ```
    En el momento en que un _thread_ entra en un bloque sincronizado, adquiere el monitor del objeto especificado, bloquendo la entrada de otros _threads_ al bloque hata que el monitor del objeto sea liberado,, hecho que sucede automáticamente cunado el _thread_ finaliza la ejecución del bloque sincronizado. A partir de este instante, el monitor del objeto queda libre y cualquier _thread_ que este a la espera de entrar en el bloque sincronizado puede adquirirlo.
     _Ver Ejemplo_ __*com.test.exam.pcj2.threads.syncronized*__

1. ##### Métodos de comunicación de la clase Object
    Existen tres métodos en la clase object que permiten enviar señales de unos _threds_ a otros, cuando estos están ejecutando bloques de código _synchronized_, condicionando la ejecución de uno de estos bloques a la del otro.
Estos métodos son __invocado en el interior de un bloque _synchronized___ sobre el objeto del que se adquiere el monitor los métodos son:

    * __wait().__ Cuando un thread invoca a este método sobre un objeto, libera el monitor del mismo, y pasa al estado de "esperando", estado en el que permanecerá hasta que reciba una señal por parte del _thread_ que en ese momento tenga el monitor del objeto para poder continuar con su ejecución la sintaxis es:
        ```java
            public final void wait() throws InterruptedException
        ```
        ```java
            public final void  wait(int milisegundos) throws InterruptedException
        ```
        Si transcurrido ese tiempo el _thread_ no h recibido una señal para salir del estado de espera, automáticamente pasa a "preparado". 
        
    * __notify().__ Al invocarlo se envía una señal al _thread_ que hizo la llamada a _wait()_ sobre el objeto. A partir de este momento, el _thread_ podrá continuar su ejecución, pasando al estado de "preparado".
    
    * __notifyAll().__ Si hay varios threads que han invocado al método _wait()_ sobre el objeto, la llamada a _notify()_ afectará solamente a uno de ellos. Para notificar a todos los _threads_ que estan a la espera se utiliza _notifyAll()_.
     _Ver Ejemplo_ __*com.test.exam.pcj2.threads.comunication*__


