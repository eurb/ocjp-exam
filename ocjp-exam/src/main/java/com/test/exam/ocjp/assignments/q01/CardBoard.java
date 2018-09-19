package com.test.exam.ocjp.assignments.q01;
//Given:
class CardBoard {
	Short story = 200;
	CardBoard go(CardBoard cb) {
		cb = null;
		return cb;
	}
	public static void main(String[] args) {
		CardBoard c1 = new CardBoard();
		CardBoard c2 = new CardBoard();
		CardBoard c3 = c1.go(c2);
		c1 = null;
		// do Stuff
} }
/*
When // doStuff is reached, how many objects are eligible for GC?
A. 0
B. 1
C. 2
D. Compilation fails
E. It is not possible to know
F. An exception is thrown at runtime
*/











































/*
Answer:
C is correct. Only one CardBoard object (c1) is eligible, 
but it has an associated Short wrapper object that is also eligible.
A, B, D, E, and F are incorrect based on the above. (Objective 7.4)
*/

/*
Mi Respuesta:
	Esta si la tuve bien pero no por la respuesta que indican (fue suerte)
	ya que crei que la vairable c3 contaba contaba como un objeto como
	no hacua referencia nada lo conte como 1 objeto y el otro objeto es el c2
	ese si esta bien porque al final ese es el que realemente es elegible.
	Pero lo correcto es que en efecto el que es elegible es el c2,
	pero dentro tiene un objeo Short asi que el c2 y el short
	son los objetos elegibles.
*/
	