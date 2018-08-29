/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend.sleep;

/**
 * @author eroman
 *
 */
public class Tarea2 extends Thread {
	
	@Override
	public void run() {
		for (int i = -1; i >=-100; i--) {
			System.out.println("El número es el: "+i);
			try {
				//Hay que tener en cuenta que la llamada al método sleep(),
				//sobre un thread puede provocar un excepción de tipo 
				//InterruptedException, que habrá que capturar.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
