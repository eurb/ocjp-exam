/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.implement;

/**
 * @author eroman
 *
 */
public class TareaRb implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Nombre: " + Thread.currentThread().getName());
			try {
				// Pone la tarea a dormir
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
