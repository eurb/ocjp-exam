package com.test.exam.ocjp.threads.q12;

//Given:
public class TwoThreads {
	static Thread laurel, hardy;

	public static void main(String[] args) {
		laurel = new Thread() {
			public void run() {
				System.out.println("A");
				try {
					hardy.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("B");
				}
				System.out.println("C");
			}
		};
		hardy = new Thread() {
			public  void run() {
				System.out.println("D");
				try {
					//synchronized (laurel) {
						laurel.wait();
					//}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("E");
				}
				System.out.println("F");
			}
		};
		laurel.start();
		hardy.start();
	}
}

/*
 * Which letters will eventually appear somewhere in the output? (Choose all that apply.)
	A. A
	B. B
	C. C
	D. D
	E. E
	F. F
	G. The answer cannot be reliably determined
	H. The code does not compile
*/


















































/*
 *Answer:
 *
 *Correct:
 *A, C, D, E, and F are correct. This may look like laurel and hardy are battling to cause the other to sleep() or wait()—but that's 
 *not the case. Since sleep() is a static method, it affects the current thread, which is laurel 
 *(even though the method is invoked using a reference to hardy). That's misleading but perfectly legal, 
 *and the Thread laurel is able to sleep with no exception, printing A and C (after a 1-second delay). Meanwhile hardy tries to call laurel.wait()—but hardy
 * has not synchronized on laurel, so calling laurel.wait() immediately causes an IllegalMonitorStateException, and so hardy prints D, E, and F. 
 * Although the order of the output is somewhat indeterminate (we have no way of knowing whether A is printed before D, for example) 
 * it is guaranteed that A, C, D, E, and F will all be printed in some order, eventually—so G is incorrect.
 * 
 * Incorrect:
 * B, G, and H are incorrect based on the above. (Objective 4.4)
 * 
 */

/*
 * Aqui el truco es ver bien como laurel y hardy son dos objetos diferentes y son threads que se colocan en estado de preparado para despues
 * ser ejecutados por el sheduler, pero bueno el truco es que en el método run() del objeto heardy al momento de invocar laurel.wait(); nos truena
 * y manda excepción por lo que entra al catch e impirme 'E' el método wait recordemos que wait, notify y notifyAll se usan en bloues sincronizados.
 * Además la isntrucción laurel.wait(); si hace refrencia a laurel ya que no es static, si queremos corregir esto entonces sybcronizamos esta instrucción
 * y al hacerlo ya no imrprimira 'E' porque ya no entraría al catch.
 * 
 * Esto nos lleva a el método run de laurel lo anterior fue para hardy...ahora es l turno de laurel, hay que prestar atencipon en la instrucción hardy.sleep(1000);
 * esta linea pareciera que esta usando la referencia a hardy pero como sleep es static realemnte se esta refirendo al objeto actual en este caso a laurel
 * este truco es muy confuso y parece raro pero no hace refrencia a hardy sino a laurel porque static entonces ahi pone a dormir por  1s a laurel, no a hardy
 * 
*/

/**
 * Mi explicación:
 * 
 * Correcta:
 * 	A, C, D, E, and F
 *  Esas letras aparecen eventualemnte debido a la explicación anterior no hay que olvidarse de cuando se usa synchonized ya que solo es para wait,notify y notifyAll
 *  En este caso si sincornizamos laurel.wait(); le estamos diciendo que nos de el monitor del objeto laurel y se espere a que alguien (hardy tal vez) le notifique que ya puede
 *  continuar.
 *  
 *  Incorrecta:
 *  los otros inciso no son correctos
 */


