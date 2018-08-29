
package com.test.exam.ocjp.threads.practice16;


//Given:
class Chicks {
	synchronized void yack(long id) {
		for (int x = 1; x < 3; x++) {
			System.out.print(id + " ");
			Thread.yield();
		}
	}
}

public class ChicksYack implements Runnable {
	
	/*static*/ Chicks c;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChicksYack().go();

	}
	
	void go() {
		c = new Chicks();
		new Thread(new ChicksYack()).start();
		new Thread(new ChicksYack()).start();
	}

	@Override
	public void run() {
		c.yack(Thread.currentThread().getId());
		
	}

}
/*
 * Which are true? (Choose all that apply)
	A. Compilation fails
	B. The output could be 4 4 2 3
	C. The output could be 4 4 2 2
	D. The output could be 4 4 4 2
	E. The output could be 2 2 4 4
	F. An exception is thrown at runtime
 */










































/*
 * Answer:
 * 
 * Correct:
 * F is correct. When run() is invoked, it is with a new instance of ChicksYack and c has not been assigned to an object. 
 * If c were static, then because yack is synchronized, answers C and E would have been correct.
 * 
 * Incorrect:
 * A, B, C, D, and E are incorrect based on the above. (Objective 4.3)
 */

/**
 * Aqui el truco está en que cuando se manda a llamar go desde main, dentro de go
 * inicializa la variable c. y este el el show, ya que confunde porque parece ser que si la está inicialnizando
 * entonces despues ya crea 2 threads al vuelo y los inicializa por lo que los pone en estado de "preparado"
 * listos para que el sheduler los ejecute, una vez que los ejecute entrá al método run(), sin embargo c es null
 * ya que si se inicializo en go, pero eso el objeto del thread actual osease main, los otros 2 threads no la han inicializado
 * Y por lo tanto viene null.
 */

/**
 * Mi explicación:
 * 
 * Correcta:
 * 	F. An exception is thrown at runtime
 *  Lanza un NullPointerExcpetion ya que como mencione cada hilo tiene sus propios objetos y c no fue inicialiada en ambos threads
 *  Si que lo fue en el thread main pero no en estos. De modo que si a la variable c la ponemos static, entonces aqui el show cambia
 *  ya que cuando main manda llamar a go se inicializa y cuando algo es static pues es compartido por todas las clases
 *  y entonces si ya cada thread conoce a c y no es null, por lo que si fuerá así las respyestas serían  C y E, ya que entraian los 2 threads
 *  a ejecutar el método yack uno despues del otro porque son sincronizadosl
 *  Por otro lado tenemos que dentro de yack hay un Thread.yield(); esto ocaciona que un thread espere su ejecución y le da prioridad a uno
 *  con una una priporidad mas alta sin embargo esto no es garantia de que pase, lo que si es garantia es que como es synchronized
 *  es segur oque ejecute uno thread y despues el otro poniendo como id el ejemplo 4 4 2 2 y 2 2 4 4
 */