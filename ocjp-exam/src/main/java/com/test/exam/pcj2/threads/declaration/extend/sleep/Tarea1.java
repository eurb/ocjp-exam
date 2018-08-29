/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend.sleep;

/**
 * @author eroman
 *
 */
public class Tarea1 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i <=100; i++) {
			System.out.println("El número es el: "+i);
			//Poner a dormir un thread es un mecanimso de 
			//ralentización de procesos que se utliza por ejemplo, 
			//cuando las operaciones realizadas por un thread implican
			// el acceso a dipositivos lentos
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
