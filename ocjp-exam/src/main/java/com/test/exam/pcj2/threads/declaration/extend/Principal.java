/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend;

/**
 * @author eroman 
 * Cada tarea en ejecución está representada por un objeto Thread
 * por tanto, una vez se hata definido la clase o las clases thread, se
 * deberá crear tantas intancias de estas clases como tareas se desee
 * tener en ejecución concurrente y hace que se ejecuten.
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//El siguiente código se encarga de  crear los obetos
		//Thread y ponerlos en ejecución.
		Tarea1 t1 = new Tarea1();
		Tarea2 t2 = new Tarea2();
		
		t1.start();
		t2.start();
		
		//Aunque la clase principal no hereda de thread. el código 
		//contenido en el método main() tambien es considerado como una
		//tarea mas por la jvm. Esto significa ue si hubiera otras 
		//instrucciones después de las llamadas a start() de los threads
		//éstas serán ejecutadas concurrentemente con el resto 
		//de la tareas.
			
	}

}
