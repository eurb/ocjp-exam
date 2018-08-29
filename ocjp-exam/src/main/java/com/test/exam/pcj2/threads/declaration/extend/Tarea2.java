/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend;

/**
 * @author eroman
 *
 */
public class Tarea2 extends Thread {
	
	@Override
	public void run() {
		for (int i = -1; i >=-100; i--) {
			System.out.println("El número es el: "+i);
		}
	}

}
