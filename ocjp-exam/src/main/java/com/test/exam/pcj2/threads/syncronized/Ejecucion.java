/**
 * 
 */
package com.test.exam.pcj2.threads.syncronized;

/**
 * @author eroman
 *
 */
public class Ejecucion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tarea tr = new Tarea();
		
		Thread t1 = new Thread(tr);
		Thread t2 = new Thread(tr);
		Thread t3 = new Thread(tr);
		t1.start();
		t2.start();
		t3.start();
		
		//Descomentamos para probar que los métodos
		//wait, notify y notifyAll solo funicinan
		// con la sincronizacion
		//new Ejecucion().m1();

	}
	
	/**
	 * Métodos wait(), notify() y notifyAll() 
	 * ◦La llamada a estos métodos sólo puede realizarse 
	 * en el interior de un bloque o método synchronized
	 */
	public /*synchronized*/ void m1() {
		//Descomentar para probar con notify y notifyAll
		//notifyAll();
		//notify();
		try {
			wait(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
