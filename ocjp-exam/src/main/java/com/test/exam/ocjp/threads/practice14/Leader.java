package com.test.exam.ocjp.threads.practice14;
//Given:
public class Leader implements Runnable {
	public static void main(String[] args) {
		Thread t = new Thread(new Leader());
		t.start();
		System.out.print("m1 ");
		t.join();
		System.out.print("m2 ");
	}
	public void run() {
		System.out.print("r1 ");
		System.out.print("r2 ");
	}
}

/*
 * Which are true? (Choose all that apply.)
	A. Compilation fails
	B. The output could be r1 r2 m1 m2
	C. The output could be m1 m2 r1 r2
	D. The output could be m1 r1 r2 m2
	E. The output could be m1 r1 m2 r2
	F. An exception is thrown at runtime
 */


































/*
 * Correct:
 * A is correct. The join() must be placed in a try/catch block. 
 * If it were, answers B and D would be correct. 
 * The join() causes the main thread to pause and join the end of the other thread, 
 * meaning "m2" must come last.
*/

/*
 * En esta es mas que obvio el método join() no declara o lanza la excepción verificada y por
 * eso da un error de sompilación.
 * 
 * Por otro lado en caso de que si fuera decalrada la excpeción las respuestas serían B y D.
 * B. The output could be r1 r2 m1 m2. Esta si e porque primero se ejecuta el run() imprimiendo
 * r1 y r2, despues entra en main e imprime m1 , hasta este punto el thread t ya termino
 * por lo que no funciona el Join entonces al final imprime m2.
 * 
 * D. The output could be m1 r1 r2 m2. El otro caso correcto es porque entra el el main e 
 * imrime m1 antes de que el Thread 1 sea incializado, una vez inicializdo el Thread
 * se usa la instruccion t.join() para obligar que a que main se pause hasta que t termine 
 * esto es que entonces t va a immprimir r1 r2, despues main reanuda e imprime m2.
*/
