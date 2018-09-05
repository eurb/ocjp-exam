package com.test.exam.ocjp.threads.q13;
//Given:
public class Starter implements Runnable {
	void go(long id) {
		System.out.println(id);
	}
	public static void main(String[] args) {
		System.out.print(Thread.currentThread().getId() + " ");
		// insert code here
	}
	public void run() {go(Thread.currentThread().getId());}
}

/*
 * And given the following five fragments:
	I. new Starter().run();
	II. new Starter().start();
	III. new Thread(new Starter());
	IV. new Thread(new Starter()).run();
	V. new Thread(new Starter()).start();
	
	When the five fragments are inserted, one at a time at line 9, which are true? (Choose all that apply.)
		A. All five will compile
		B. Only one might produce the output 4 4
		C. Only one might produce the output 4 2
		D. Exactly two might produce the output 4 4
		E. Exactly two might produce the output 4 2
		F. Exactly three might produce the output 4 4
		G. Exactly three might produce the output 4 2
 */












































/*
Answer:
	Correcta:
 		C and D are correct. Fragment I doesn't start a new thread. Fragment II doesn't compile. Fragment III creates a new thread but doesn't start it. 
 		Fragment IV creates a new thread and invokes run() directly, but it doesn�t start the new thread. Fragment V creates and starts a new thread.
	Incorrecta:
	 A, B, E, F, and G are incorrect based on the above. (Objective 4.1)
*/

/*
 * Veamos debemos de analizar cada instrucción y colocarla de forma individual en la linea donde nos dicen haciendo eso vemos que si:
 * colocamos:
 * I. new Starter().run();
 * 	Esto hará que el metodo main imprima su id actual ejemplo 1, despues se llama run de forma directa pero no  inicia el thread por lo que aun sigue teniendo
 *  el id de main que es 1 y es enviado al método go por lo que este fragemento puede imprimir 1 1
 *  
 * II. new Starter().start();
 * 	Este no hay mas es error de compilación ya que Starter implementa Runnable pero Runnable no tiene un método start solo un método run()
 *  por tanto este método no existe y es error de compilación
 *  
 * III.  new Thread(new Starter());
 * 	Este de aqui si es una instrucción valida ya que un Thread puede recibir una instancia de Runnable sin embargo nunca se inicializa el thread
 *  y solo imprime el id del main que por ejemplo sería 1 no hay mas que hacerle 
 *  
 * IV. new Thread(new Starter()).run();
 * 	Este es muy parecido al I. no marca error y crea una instancia de Thread pasandole a su constructor el objeto Starter que a su vez implemenata a Runnable
 *  y como Thread dentro de si implemnta Runnable entonces por el polimorfismo eso hace referencia al método run que estamos sobreescibiendo
 *  sin emabrgo y de nuevo esta linea lo manda llamar directo a run sin que aun inicie el hilo por lo que si id es el thread del main
 *  y al igual que en I. va a imprimir 1 1
 *  
 *  V. new Thread(new Starter()).start();
 *   Este es el bueno ya que ahora si levanta el hilo y el sheduler lo toma imprimendo en primer lugar el id de main 1 y despues mandando a llamar a go pero
 *   ya con la instancia de otro thread y eso imprime 2, como resultado imprime 1 2
*/

/*
 * Mis respuestas:
 * C,D
 * ya que  para C Only one might produce the output 4 2 es la instrucción V.
 * Para la D. Exactly two might produce the output 4 4 son las instrucciones I. y IV.
 * 
 * Las otras no son correctas.
 */
