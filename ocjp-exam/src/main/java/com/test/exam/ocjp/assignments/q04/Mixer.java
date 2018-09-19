package com.test.exam.ocjp.assignments.q04;

class Mixer {
	Mixer() { }
	Mixer(Mixer m) { m1 = m; }
	Mixer m1;
	public static void main(String[] args) {
		Mixer m2 = new Mixer();
		Mixer m3 = new Mixer(m2); m3.go();
		Mixer m4 = m3.m1; m4.go();
		Mixer m5 = m2.m1; m5.go();
	}
	void go() { System.out.print("hi "); }
}

/*
What is the result?
A. hi
B. hi hi
C. hi hi hi
D. Compilation fails
E. hi, followed by an exception
F. hi hi, followed by an exception
*/


























































/*
Answer:
F is correct. The m2 object’s m1 instance variable 
is never initialized, so when m5 tries to
use it a NullPointerException is thrown.
A, B, C, D, and E are incorrect based on the above. (Objective 7.3)
*/

/*
 * Mi Respuesta:
 * La tuve bien seleccione F. El truco en estas ver bien la cración de las
 * instancias igual se puede diagramar pero en este caso cuadno se llega 
 * a la linea Mixer m5 = m2.m1; m5.go(); en tiempo de ejecución m5 es null
 * y por eso nos manda un NullPointerException
 */