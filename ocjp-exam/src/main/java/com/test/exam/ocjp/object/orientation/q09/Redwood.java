package com.test.exam.ocjp.object.orientation.q09;
//Given:
public class Redwood extends Tree {
	public static void main(String[] args) {
		new Redwood().go();
	}
	void go() {
		go2(new Tree(), new Redwood());
		go2((Redwood) new Tree(), new Redwood());
	}
	void go2(Tree t1, Redwood r1) {
		Redwood r2 = (Redwood)t1;
		Tree t2 = (Tree)r1;
	}
}
class Tree { }



/*
What is the result? (Choose all that apply.)
A. An exception is thrown at runtime
B. The code compiles and runs with no output
C. Compilation fails with an error at line 8
D. Compilation fails with an error at line 9
E. Compilation fails with an error at line 12
F. Compilation fails with an error at line 13
*/







































































/*
Answer:
A is correct, a ClassCastException will be thrown when the code 
	attempts to downcast a Tree to a Redwood.
B, C, D, E, and F are incorrect based on the above information.
(Objective 5.2)
*/
/*
La tuve mal aqui el truco es ver cuando se hace un downcast,
para que un downcast sea seguro se debe usar el operador instanceof
si es un upcast no es necesario siempre es seguro, en este ejemplo
en la linea 12 se hace el downcast y todo compila bien
pero al ejecutar manda un ClassCastException
*/

































