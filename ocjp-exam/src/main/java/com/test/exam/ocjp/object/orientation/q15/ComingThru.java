package com.test.exam.ocjp.object.orientation.q15;
//Given:
class A { }
class B extends A { }
public class ComingThru {
	static String s = "-";
	public static void main(String[] args) {
		A[] aa = new A[2];
		B[] ba = new B[2];
		sifter(aa);
		sifter(ba);
		sifter(7);
		System.out.println(s);
	}
	static void sifter(A[]... a2) { s += "1"; }
	static void sifter(B[]... b1) { s += "2"; }
	static void sifter(B[] b1) { s += "3"; }
	static void sifter(Object o) { s += "4"; }
}
/*
What is the result?
A. -124
B. -134
C. -424
D. -434
E. -444
F. Compilation fails
*/



















































/*
Answer:
D is correct. In general, overloaded var-args methods are chosen
	last. Remember that arrays are objects. 
	Finally, an int can be boxed to an Integer and then 
	"widened" to an Object.
A, B, C, E, and F are incorrect based on the above information.
(Objective 1.5)
*/
/*
Sólo hay que seguir lo que nos indican que los var args son 
tomados al último por el compilador, osea primero le da 
priporidad a los objetos comunes y al final a los var args
*/