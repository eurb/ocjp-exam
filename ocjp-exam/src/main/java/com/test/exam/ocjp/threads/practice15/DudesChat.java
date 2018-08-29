package com.test.exam.ocjp.threads.practice15;

//Given:
class Dudes {
	static long flag = 0;

	// insert code here est� linea debe ir comentada
	/*synchronized */void chat(long id) {
		if (flag == 0)
			flag = id;
		for (int x = 1; x < 3; x++) {
			if (flag == id)
				System.out.print("yo ");
			else
				System.out.print("dude ");
		}
	}
}

public class DudesChat implements Runnable {
	static Dudes d;

	public static void main(String[] args) {
		new DudesChat().go();
	}

	void go() {
		d = new Dudes();
		new Thread(new DudesChat()).start();
		new Thread(new DudesChat()).start();
	}

	public void run() {
		d.chat(Thread.currentThread().getId());
	}
}

/*
	And given these two fragments:
	I. synchronized void chat(long id) {
	II. void chat(long id) {
	
	When fragment I or fragment II is inserted at line 5, which are true? (Choose all that apply.)
		A. An exception is thrown at runtime
		B. With fragment I, compilation fails
		C. With fragment II, compilation fails
		D. With fragment I, the output could be yo dude dude yo
		E. With fragment I, the output could be dude dude yo yo
		F. With fragment II, the output could be yo dude dude yo
*/






































/*
 * Answer:
 * F is correct. With fragment I, the chat method is synchronized, so the two threads 
 * can't swap back and forth. With either fragment, the first output must be yo.
   A, B, C, D, and E are incorrect based on the above. (Objective 4.3)
*/




/* Mi explicaci�n:
 * 
 * Si analizamos el c�digo tomando en cuenta primero I. synchronized void chat(long id),
 * vemos que la salida para este m�todo ser� yo yo dude dude, sin embargo est� opci�n
 * no aparece en las que se muestran, entonces la A, B y C que quedan descartadas porque
 * la compilaci�n no falla ni hay excpeci�n.
 * 
 * El D no es porque como vimos la salida para el I. ES yo yo dude dude.
 * El E. no es porque igual como vimos para un synchorized la salisa es yo yo dude
 * 	y en esta opcion aparece como que el primer es dude por lo que tampoco es.
 * Final mente la opci�n F. es la correcta porque el II. No es sincronizado y por lo otanto
 * puede chocolatear o mezclar la info, lo que es seguro es que en cualquier caso siempre comenzar�
 * por dude y esta es la que mas se aproxima en ese sentudi
 * 
 * */
