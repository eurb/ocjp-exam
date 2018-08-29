/**
 * 
 */
package com.test.exam.pcj2.threads.comunication;

/**
 * @author eroman
 *
 */
public class Proceso extends Thread {
	
	private int valor;
	
	public int getTotal() {
		
		//Devuelve el calculo realizado
		return valor;
	}
	
	@Override
	public void run() {
		//bloque de c�digo sincronizado donde
		//se obtiene el monitor del propio objeto
		//Proceso para que ningun otro thread pueda
		//utilizarlo mientras completa el c�lculo
		synchronized (this) {
			for(int i=1;i<=100;i++)
			{
				valor+=i;
			}
			this.notify(); //avisa de que ha 
			//finalizado el c�lculo al
			//thread que invoco a wait()
			//sobre el objeto, a fin de que
			//pueda continuar la ejecuci�n.
		}
	}

}
