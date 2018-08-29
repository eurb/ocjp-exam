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
		// el c�lculo y lo pone en ejecuci�n
		// concurrente con main() (recordemos que main es tambi�n un thread,
		// conocido mas comunmente como  thread principal)
		Proceso p = new Proceso();
		p.start();
		
		//aqui el m�todo main podr�a realizar
		//cualquier otra tarea
		synchronized (p) {
			try {
				p.wait(); //espera a que finalice
				// el c�lculo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("La suma es " + p.getTotal());

	}

}
