/**
 * 
 */
package com.test.exam.pcj2.threads.declaration.extend;

/**
 * @author eroman 
 * Cada tarea en ejecuci�n est� representada por un objeto Thread
 * por tanto, una vez se hata definido la clase o las clases thread, se
 * deber� crear tantas intancias de estas clases como tareas se desee
 * tener en ejecuci�n concurrente y hace que se ejecuten.
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//El siguiente c�digo se encarga de  crear los obetos
		//Thread y ponerlos en ejecuci�n.
		Tarea1 t1 = new Tarea1();
		Tarea2 t2 = new Tarea2();
		
		t1.start();
		t2.start();
		
		//Aunque la clase principal no hereda de thread. el c�digo 
		//contenido en el m�todo main() tambien es considerado como una
		//tarea mas por la jvm. Esto significa ue si hubiera otras 
		//instrucciones despu�s de las llamadas a start() de los threads
		//�stas ser�n ejecutadas concurrentemente con el resto 
		//de la tareas.
			
	}

}
