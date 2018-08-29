/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend.sleep;

/**
 * @author eroman 
 * Con
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tarea1 t1 = new Tarea1();
		Tarea2 t2 = new Tarea2();
		
		t1.start();
		t2.start();
			
	}

}
