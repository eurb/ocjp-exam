package com.test.exam.ocjp.threads.practice10;

//Given:
class MyThread extends Thread {
	MyThread() {
		System.out.print(" MyThread");
	}

	public void run() {
		System.out.print(" bar");
	}

	public void run(String s) {
		System.out.print(" baz");
	}
}

public class TestThreads {
	public static void main(String[] args) {
		Thread t = new MyThread() {
			public void run() {
				System.out.print(" foo");
			}
		};
		t.start();
	}
}

/*What is the result?
	A. foo
	B. MyThread foo
	C. MyThread bar
	D. foo bar
	E. foo bar baz
	F. bar foo
	G. Compilation fails
	H. An exception is thrown at runtime
*/








































/*
 * Answer:
	B is correct. The first line of main we're constructing an instance of an anonymous inner class extending from MyThread. So the MyThread constructor runs and prints MyThread. Next, main() invokes start() on the new thread instance, which causes the overridden run() method (the run() method in the anonymous inner class) to be invoked.
	A, C, D, E, F, G and H are incorrect based on the logic described above. (Objective 4.1)
 * */


/*
 * Mi explicaci�n:
 * 	Para emepzar vemos que la clase MyThread tiene un contructor, y sabemos que si se crea
 *  un objeto de esta clase se imprimira MyThread. Vemos tambien que esa clase hereda de Thread
 *  y vemos que sobreescribe el m�todo run() pero tambien lo sobrecarga run(String s).
 *  Cuando se sobre carga el m�todo run el sheduler no lo pela, sheduler siempre tomar�
 *  el m�todo sobreescrito con la firma publi void run().
 *  
 *  Despues en el main se crea un objeto t que dentro tiene una clase an�nima de MyThread y nuevamente
 *  sobre escribe el m�todo run. Despues se inicia el Thread con start().
 *  
 *  Al crearse el objeto Thread t = new MyThread() { se invoca el contecutor de MyThread() e imprime MyThread
 *  Despues se ejecuta el m�todo run sobreescrito en la clase an�nima e imprime foo, por lo
 *  tanto la respuesta correcta es MyTjhread foo que el inciso B.
 * */