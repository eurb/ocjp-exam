/**
 * 
 */
package com.test.exam.pcj2.inner.classes.standard;

/**
 * @author eroman
 *
 */
public class Externa {
	
	String s ="Mio";
	//Definici�n de la clase interna
	class Interna {
		public void muestra () {
			System.out.println("Objeto interno "+s);
		}
	}

}
