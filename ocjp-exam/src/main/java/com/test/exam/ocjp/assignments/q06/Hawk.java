package com.test.exam.ocjp.assignments.q06;

//Given:
class Bird {
	{ System.out.print("b1 "); }
	public Bird() { System.out.print("b2 "); }
}
class Raptor extends Bird {
	static { System.out.print("r1 "); }
	public Raptor() { System.out.print("r2 "); }
	{ System.out.print("r3 "); }
	static { System.out.print("r4 "); }
}
class Hawk extends Raptor {
	public static void main(String[] args) {
		System.out.print("pre ");
		new Hawk();
		System.out.println("hawk ");	
	}
}
/*
What is the result?
A. pre b1 b2 r3 r2 hawk
B. pre b2 b1 r2 r3 hawk
C. pre b2 b1 r2 r3 hawk r1 r4
D. r1 r4 pre b1 b2 r3 r2 hawk
E. r1 r4 pre b2 b1 r2 r3 hawk
F. pre r1 r4 b1 b2 r3 r2 hawk
G. pre r1 r4 b2 b1 r2 r3 hawk
H. The order of output cannot be predicted
I. Compilation fails
*/




























































/*
Answer:
D is correct. Static init blocks are executed at class loading time, 
instance init blocks run right after the call to super() in a 
constructor. When multiple init blocks of a single type occur 
in a class, they run in order, from the top down.
A, B, C, E, F, G, H, and I are incorrect based on the above. 
Note: you’ll probably never see this many choices on the real exam!
 (Objective 1.3)
*/
/*
Mi Respuesta:
	Esta estuvo fácil solo hay que recordar que primero se cargan
	los bloques static de arriaba hacia abajo, despues se invocan los
	constructores y una vez que termina super se ejecutan los bloques
	de instancia y despues se continua con el cuerpo del contructor
*/