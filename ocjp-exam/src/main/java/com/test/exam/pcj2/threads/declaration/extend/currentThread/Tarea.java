/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend.currentThread;

/**
 * @author eroman
 *
 */
public class Tarea extends Thread {
	
	
	
	public Tarea(String name) {
		//Utiliza el constructor de Thread para establecer
		//el nombre de la tarea
		super(name);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	}

	@Override
	public void run() {
		for (int i = 0; i <=100; i++) {
			//Muestra el nombre del thread en ejecución
			System.out.println("Nombre: "+Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
