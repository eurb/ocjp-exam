/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.implement;

/**
 * @author eroman 
 * Si observamos este comportamiento es idéntico al 
 * {@link com.test.exam.pcj2.threads.declaration.extend} 
 * Sólo que aqui en lugar de heredar se implementa a la interfaz Ruunable
 * Y para colocarlos en estado de ejecución se usan los contructores
 * sobrecargados de Thread pasandole como paramétro la interfaz y el nombre
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Se crea un único objeto tarearb, el cual
		//es compartido por todos los thread
		TareaRb t = new TareaRb();
		//Las tareas son instancias de la 
		//clase Thread
		Thread t1 = new Thread(t, "Edgar");
		Thread t2 = new Thread(t, "Uriel");
		Thread t3 = new Thread(t, "Matias");
		
		//Los thread se ponen en estado de ejecución.
		t1.start();
		t2.start();
		t3.start();
		
			
	}

}
