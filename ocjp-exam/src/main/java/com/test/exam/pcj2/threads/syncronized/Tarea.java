/**
 * 
 */
package com.test.exam.pcj2.threads.syncronized;

/**
 * @author eroman
 *
 */
public class Tarea implements Runnable {

	Accesos ac;

	public Tarea() {
		super();
		this.ac = new Accesos();
	}

	/**
	 * La sincronización de un bloque de código consiste en impedir la entrada de un
	 * thread al bloque, hata que él último thread en entrar en dicho bloque
	 * finalice la ejecución del mismo, de esta forma se garantiza que todas las
	 * instrucciones del bloque son ejecutadas completamente por un thread antes de
	 * que otro entre.
	 * 
	 * En este ejemplo al agregas la palabra syncronized eveitamos que otro thread
	 * corrmpa el dato Cont.
	 * 
	 * Cada objeto tiene un monitor asociado o cerrojo, con esto un threead sabe que
	 * esta sincronizando un cierto tipo de objeto, una vez que termina, el sheduler
	 * toma otro thread que este en estado de espera y de nuevo sincroniza el objeto
	 * espeicifado o bien puede ser un bloque de código.
	 * 
	 * Si quitamos el bloque syncronized podemos ver como se corrmple.
	 */
	public void run() {
		synchronized (ac) { //Quitar para ver como se comporta de forma incorrecta.

			int actual = ac.getCont();
			actual++;

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ac.setCont(actual);
			System.out.println("Total Accesos:" + ac.getCont());
		}
	}

}
