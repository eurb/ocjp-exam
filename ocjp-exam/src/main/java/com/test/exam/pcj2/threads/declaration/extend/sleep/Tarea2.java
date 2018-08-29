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
			System.out.println("El n�mero es el: "+i);
			try {
				//Hay que tener en cuenta que la llamada al m�todo sleep(),
				//sobre un thread puede provocar un excepci�n de tipo 
				//InterruptedException, que habr� que capturar.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
