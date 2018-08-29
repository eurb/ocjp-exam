/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend.currentThread;

/**
 * @author eroman 
 * 
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Se crean tres tareas que solo muestran su nombre por pantalla 100 veces
		//cada una ejecutandose en modo multitarea.
		
		Tarea t1 = new Tarea("Edgar");
		Tarea t2 = new Tarea("Uriel");
		Tarea t3 = new Tarea("Matias");
		
		t1.start();
		t2.start();
		t3.start();
			
	}

}
