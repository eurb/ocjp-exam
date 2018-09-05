package com.test.exam.ocjp.threads.q10;

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
 * Mi explicación:
 * 	Para emepzar vemos que la clase MyThread tiene un contructor, y sabemos que si se crea
 *  un objeto de esta clase se imprimira MyThread. Vemos tambien que esa clase hereda de Thread
 *  y vemos que sobreescribe el método run() pero tambien lo sobrecarga run(String s).
 *  Cuando se sobre carga el método run el sheduler no lo pela, el sheduler siempre tomará
 *  el método sobreescrito con la firma public void run().
 *  
 *  Despues en el main se crea un objeto t que dentro tiene una clase anónima de MyThread y nuevamente
 *  sobre escribe el método run. Despues se inicia el Thread con start().
 *  
 *  Al crearse el objeto Thread t = new MyThread() { se invoca el constructor de MyThread() e imprime MyThread
 *  Despues se ejecuta el método run sobreescrito en la clase anónima e imprime foo, por lo
 *  tanto la respuesta correcta es MyTjhread foo que el inciso B.
 * */