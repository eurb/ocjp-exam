/**
 * 
 */
package com.test.exam.pcj2.inner.classes.annonymous;




class Operaciones {
	public void imprimir () {
		System.out.println("Imprimir Original");
	}
}

class Externa {
	Operaciones op = new Operaciones() {
		//Definici�n de la clase an�nima
		public void imprimir () {
			System.out.println("Imprimir An�nimo");
		}
	}; // la l�nea de definici�n de la clase y
	//creaci�n del objeto termina con ;
	
	void proceso () {
		//llama al m�todo imprimir del objeto
		//de la clase an�nima
		op.imprimir();
	}
}



/**
 * @author eroman
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Intanciaci�n normal de la
		//clase externa
		Externa ex = new Externa();
		ex.proceso();
		

	}

}
