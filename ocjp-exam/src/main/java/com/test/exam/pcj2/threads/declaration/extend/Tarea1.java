/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend;

/**
 * @author eroman
 *
 */
public class Tarea1 extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i <=100; i++) {
			System.out.println("El número es el: "+i);
		}
	}

}
