package com.test.exam.ocjp.threads.q09;

public class Main {

	//Given:
	public synchronized static void main(String[] args) throws InterruptedException {
		Thread t = new Thread();
		t.start();
		System.out.print("X");
		t.wait(10000);
		System.out.print("Y");

	}

}

/**
 * What is the result of this code?
	A. It prints X and exits
	B. It prints X and never exits
	C. It prints XY and exits almost immeditately
	D. It prints XY with a 10-second delay between X and Y
	E. It prints XY with a 10000-second delay between X and Y
	F. The code does not compile
	G. An exception is thrown at runtime
 */
/*
Answer:
	G is correct. The code does not acquire a lock on t before calling t.wait(), 
	so it throws an IllegalMonitorStateException. The method is synchronized, 
	but it's not synchronized on t so the exception will be thrown. 
	If the wait were placed inside a synchronized(t) block, then the answer would have been D.
	
	A, B, C, D, E, and F are incorrect based the logic described above. (Objective 4.2)
*/

/*
 * Mi explicación:
 * 	Esta tiene truco, ya que si vemos el método main tiene dentro una instrucción t.wait, recordemos que
 *  wait se usa para threds sincronizados, ahora vemos que el método main lo ponen como
 *  synchronized es raro pero si se puede y al ponerlo asi entonces se cumple que no marque
 *  error el método wait ya que main está sincronizado, ademas con wait
 *  nos obliga a atrapar o lanzar un InterruptedException lo cual main si lo hace.
 *  En otras palabras este código compila chido.
 *  Ahora aqui viene el truco cuando main ejecuta t.wait() lanza un IllegalMonitorStateException,
 *  esto es porque aunque el m�todo esta siendo sincronizado el lock o monitor no esta en t sino en 
 *  el método main por lo tanto el lock de t.wait no esta sincronizado osease el objeto t
 *  por eso nos lanza la exepción lo cual es confuso ya que se podria pensar que si se sincronizo
 *  el método todo en su inyerior esta sincronizado pero no es asi el método si esta protegido por fuera
 *  para que otros threads no accedan al mismo tiempo pero ya dentro del metodo t debe ser sincronizada.
 *  
 *  Si t fuera synchronized entonces la resouesta sería D, que es la que seleccionas si te vas con la finta.
 * */
