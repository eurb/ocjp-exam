/**
 * 
 */
package com.test.exam.pcj2.threads.comunication;

/**
 * @author eroman
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// crea un objeto de la clase que realiza
		// el cálculo y lo pone en ejecución
		// concurrente con main() (recordemos que main es también un thread,
		// conocido mas comunmente como  thread principal)
		Proceso p = new Proceso();
		p.start();
		
		//aqui el método main podría realizar
		//cualquier otra tarea
		synchronized (p) {
			try {
				p.wait(); //espera a que finalice
				// el cálculo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("La suma es " + p.getTotal());

	}

}
