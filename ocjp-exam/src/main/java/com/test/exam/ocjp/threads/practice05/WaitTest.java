package com.test.exam.ocjp.threads.practice05;

//Given:
/*1. */	public class WaitTest {
/*2. */		public static void main(String[] args) {
/*3. */			System.out.print("1 ");
/*4. */			synchronized (args) {
/*5. */				System.out.print("2 ");
/*6. */				try {
/*7. */					args.wait();
/*8. */				} 
/*9. */				catch (InterruptedException e) {}
/*10. */		}
/*11. */		System.out.print("3 ");
/*12. */	}
/*13. */}

//What is the result of trying to compile and run this program?
//A. It fails to compile because the IllegalMonitorStateException of wait() is not dealt with in line 7
//B. 1 2 3
//C. 1 3
//D. 1 2
//E. At runtime, it throws an IllegalMonitorStateException when trying to wait
//F. It will fail to compile because it has to be synchronized on the this object




















































//Answer:
//D is correct. 1 and 2 will be printed, but there will be no return from the wait call 
//because no other thread will notify the main thread, so 3 will never be printed. It's frozen at line 7.
//
//A is incorrect; IllegalMonitorStateException is an unchecked exception. 
//B and C are incorrect; 3 will never be printed, since this program will wait forever. 
//E is incorrect because IllegalMonitorStateException will never be thrown because the wait() is done on args within a block of code synchronized on args. 
//F is incorrect because any object can be used to synchronize on and this and static don't mix. (Objective 4.4)



/*
 * Mi explicación:
 * Puedes irte con la finta de que la respuesta es B. 1 2 3 pero no es así, todo compila perfecto
 * Analizamos las respuetsas:
 * 
 * A es incorrecto ya que dice que falla porque no es tratada la excpeción IllegalMonitorStateException, esta
 *  excepción es unchecked o no vrificada por lo que no hay que atraparla, además el método wait lanza un
 *  InterruptedException la cual si es checked o verificada y esta siendo tratada.
 *  
 * B y C son incorrectas ya que este programa queda en espera para siempre y nunca llega a imprimir el 3. Esto es la
 * clave ya que todo parece estar bien, pero nadie le notifica a main que el recurso ya se desbloqueo
 * por lo que se queda congelado.
 * 
 * E es incorrecto ya que la excpeción IllegalMonitorStateException nunca se va a lanzar porque wait() esta bien definido y el objeto args
 * que es el que manda a llamar a wait si esta dentro de un bloque synchronized osea esta obteniendo su minitor de args.
 * 
 * F es incorrect oporque cualquier onejto puede usar la sincrobización
 * 
 * Entonces la respuetsa CORRECTA es D imprime solo 1 y 2 ya que despues de ejecutar wait() main se queda esperando
 * por siempre y  queda congelado.
 * Si le hubieramos pasado un tiempo de espera en ms a wait este se iba a esperar ese tiempo
 * pero despues hubiera notificad de forma automática y entonces si hubiera imprimdo 1 2 3
 * 
 * */