package com.test.exam.ocjp.threads.practice11;



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
 * una tendr� su propios m�todos. Sin embargo el m�todo  static synchronized void b() tiene
 * el truco ya que es static, lo cual quiere decir que al momento que lo invoquen ya sea una 
 * refrencia o la otra, obtendr� el monitor o lock completo de toda la clase ya que es compartido (static)
 * mientras que el m�todo synchronized void a() no es static y no es compartido por lo que las 2 refrencias
 * pueden invocar directo a este m�todo ya que son 2 refrencias distintas ejemplo:
 * x.a() in thread1, and y.a() in thread2 pueden aparecer al mismo tiempo y segun la pregunta
 * solo debemos seleccionar las que no aparecen al mismo tiempo.
 * 
 * Las respuestas correctasy la explicaci�n se muestra abajo.
 * 
 * Otra cosa es ver como actuBusy es static y puede ser invocado por m�todos no-static, pero deontro de un static no podemos
 * referinos algo non-static. En este sentido todo este ok ya que de m�todos que son staic nunca hacemos referencia a algo no static
 * Debemos tener cuidado en eso y recordad que lo static se carga en tiempo de compilaci�n.
 * 
 * Otra cosa es ver como x e y son declaradoas como final, esto es que esos objetos ya no pueden apuntar a otros objetos es como
 * las constantes pero para objetos, estos �ltimos puntos es solo para recordas conceptos
 */


/**
 * Mi explicaci�n:
 * 
 * Correctas:
 * A. x.a() in thread1, and x.a() in thread2 
 * 	es correcta porque las dos se refieren a 'x' tanto el thread1 como el thread2,
 *  y como el m�todo es synchrobnized pues nunca pueden aparecer juntas
 *  
 * F. x.b() in thread1, and x.b() in thread2
 *  como en la anterior usan la misma refrencia 'x' tratando de invocar al m�todo static synchronized b, pero como vimos
 *  un m�todo static synchronized adquieire todo el lock o monitor del objeto y con el simple hecho de que este m�todo
 *  es synchro y refrerise al mismo objeto 'x' ya no podr�an aparecer juntas por eso esta opci�n es correcta
 *  
 * H. x.b() in thread1, and y.b() in thread2
 * 	Esta es una de las confusas y es la del truco, ya que como se puede ver se refieren al mismo m�todo b pero son diferentes
 *  referencias una es 'x' y otra es 'y', sin embargo dada la explicaci�n de que un m�todo static adqueire el lock de toda la clase
 *  pues este tampoco nunca va aparecer al mismo tiempo ya que o lo usa x o lo usa y pero no ambas
 */
