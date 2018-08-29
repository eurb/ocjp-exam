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
		//Definición de la clase anónima
		public void imprimir () {
			System.out.println("Imprimir Anónimo");
		}
	}; // la línea de definición de la clase y
	//creación del objeto termina con ;
	
	void proceso () {
		//llama al método imprimir del objeto
		//de la clase anónima
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
		// Intanciación normal de la
		//clase externa
		Externa ex = new Externa();
		ex.proceso();
		

	}

}
