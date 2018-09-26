package com.test.exam.ocjp.flow.control.q09;
//Given:
class Infinity { }
public class Beyond extends Infinity {
	static Integer i;
	public static void main(String[] args) {
		int sw = (int)(Math.random() * 3);
		switch(sw) {
			case 0: { for(int x = 10; x > 5; x++)
				if(x > 10000000) x = 10;
			break; }
			case 1: { int y = 7 * i; break; }
			case 2: { Infinity inf = new Beyond();
			Beyond b = (Beyond)inf; }
		}
	}
}

/*
And given that line 7 will assign the value 0, 1, or 2 to sw, which are true? (Choose all that apply.)
A. Compilation fails
B. A ClassCastException might be thrown
C. A StackOverflowError might be thrown
D. A NullPointerException might be thrown
E. An IllegalStateException might be thrown
F. The program might hang without ever completing
G. The program will always complete without exception
*/



































































/*
Answer:
D and F are correct. Because i was not initialized, 
case 1 will throw an NPE. Case 0 will initiate an endless loop,
not a stack overflow. Case 2's downcast will not cause an 
exception.
A, B, C, E, and G are incorrect based on the above. (Objective 2.6)
*/

/*
Mi Respuetsa:
	B y D, la Tuve mal ya que La D si esta bien y es obvio ya que
	el atributo static Integer i es null y va marcar un NPE
	cuando se use, lo que estuvo mal fue seleccionar la B
	ya que pense que iba lanzar un classCastException pero no
	ya que el downcast esta bien ya que se instancia de la subclase
	ahora bien. mi otro error fue que en el case o se hace
	un ciclo infinito y no lo vi pense
	que el for era finito pero pues si es infinito y por lo tanto
	esto hace a que el programa se cuelgue en un cliclo infinito
	lo cual es diferente a que sea un metodo recursivo, en un metodo
	recursivo se llena el stack y nos puede mandar un StackOverFlowError
	ya que puede acabarse la memoria, pero en este caso no
	se llena la pila sino que es un ciclo infinito
	y solo hace a que el programa se quede colgado y es por eso
	que la otra opcion correcta era la F.
*/




