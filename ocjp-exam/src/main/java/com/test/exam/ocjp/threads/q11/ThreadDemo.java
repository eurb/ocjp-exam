package com.test.exam.ocjp.threads.q11;



//Given:
public class ThreadDemo {
	synchronized void a() {
		actBusy();
	}

	static synchronized void b() {
		actBusy();
	}

	static void actBusy() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		final ThreadDemo x = new ThreadDemo();
		final ThreadDemo y = new ThreadDemo();
		Runnable runnable = new Runnable() {
			public void run() {
				int option = (int) (Math.random() * 4);
				switch (option) {
				case 0:
					x.a();
					break;
				case 1:
					x.b();
					break;
				case 2:
					y.a();
					break;
				case 3:
					y.b();
					break;
				}
			}
		};
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
	}
}
/*
 * Which of the following pairs of method invocations could NEVER be executing at the same time? (Choose all that apply.)
 * A. x.a() in thread1, and x.a() in thread2
 * B. x.a() in thread1, and x.b() in thread2
 * C. x.a() in thread1, and y.a() in thread2
 * D. x.a() in thread1, and y.b() in thread2
 * E. x.b() in thread1, and x.a() in thread2
 * F. x.b() in thread1, and x.b() in thread2
 * G. x.b() in thread1, and y.a() in thread2
 * H. x.b() in thread1, and y.b() in thread2
*/




































/*
 * Answer:
 * 
	Correct: 
	A, F, and H. A is a right answer because when synchronized instance methods are called
	on the same instance, they block each other. F and H can't happen because synchronized
	static methods in the same class block each other, regardless of which instance was used
	to call the methods. (An instance is not required to call static methods; only the class.)
	
	Incorrect:
	C could happen because synchronized instance methods called on different instances do not block each other. 
	B, D, E, and G could all happen because instance methods and static methods lock on different objects, 
	and do not block each other. (Objective 4.3)
*/

/**
 * 
 * El truco aqui es ver bien que x e y son dos refrencias diferentes por lo tanto cada
 * una tendrá su propios métodos. Sin embargo el método  static synchronized void b() tiene
 * el truco ya que es static, lo cual quiere decir que al momento que lo invoquen ya sea una 
 * referencia o la otra, obtendrá el monitor o lock completo de toda la clase ya que es compartido (static)
 * mientras que el método synchronized void a() no es static y no es compartido por lo que las 2 referencias
 * pueden invocar directo a este método ya que son 2 refrencias distintas ejemplo:
 * x.a() in thread1, and y.a() in thread2 pueden aparecer al mismo tiempo y segun la pregunta
 * solo debemos seleccionar las que no aparecen al mismo tiempo.
 * 
 * Las respuestas correctas y la explicación se muestra abajo.
 * 
 * Otra cosa es ver como actBusy es static y puede ser invocado por métodos no-static, pero deontro de un static no podemos
 * referirnos a algo non-static. En este sentido todo esta ok ya que los métodos que son staic nunca hacemos referencia a algo no static
 * Debemos tener cuidado en eso y recordar que lo static se carga en tiempo de compilación.
 * 
 * Otra cosa es ver como x e y son declaradoas como final, esto es que esos objetos ya no pueden apuntar a otros objetos es como
 * las constantes pero para objetos, estos últimos puntos es solo para recordas conceptos
 */


/**
 * Mi explicación:
 * 
 * Correctas:
 * A. x.a() in thread1, and x.a() in thread2 
 * 	es correcta porque las dos se refieren a 'x' tanto el thread1 como el thread2,
 *  y como el método es synchronized pues nunca pueden aparecer juntas
 *  
 * F. x.b() in thread1, and x.b() in thread2
 *  como en la anterior usan la misma refrencia 'x' tratando de invocar al método static synchronized b, pero como vimos
 *  un método static synchronized adquiere todo el lock o monitor del objeto y con el simple hecho de que este método
 *  es synchronized y referirse al mismo objeto 'x' ya no podrán aparecer juntas por eso esta opción es correcta
 *  
 * H. x.b() in thread1, and y.b() in thread2
 * 	Esta es una de las confusas y es la del truco, ya que como se puede ver se refieren al mismo método b pero son diferentes
 *  referencias una es 'x' y otra es 'y', sin embargo dada la explicación de que un método static adquiere el lock de toda la clase
 *  pues este tampoco nunca va aparecer al mismo tiempo ya que o lo usa x o lo usa y pero no ambas
 */
