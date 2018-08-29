/**
 * 
 */
package com.test.exam.pcj2.inner.classes.in.method;

/**
 * @author eroman
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Externa ex = new Externa();
		ex.proceso();

	}

}

class Externa {
	void proceso () {
		class Interna {
			void muestra() {
				 System.out.println("Local a m�todo ");
			}
		}
		//S�lo podr� instanciarse en el interior
		//de proceso() a partir de aqu�
		Interna in = new Interna();
		in.muestra();
	}
}
