package com.test.exam.ocjp.assignments.q02;
//Given
class Alien {
	String invade(short ships) { return "a few"; }
	String invade(short... ships) { return "many"; }
}
class Defender {
	public static void main(String [] args) {
		System.out.println(new Alien().invade(7));
} }

/*
What is the result?
A. many
B. a few
C. Compilation fails
D. The output is not predictable
E. An exception is thrown at runtime
*/
































































/*
 * Answer:
	C is correct, compilation fails. The var-args declaration 
	is fine, but invade takes a short, so the argument 
	7 needs to be cast to a short. With the cast, 
	the answer is B, 'a few'.
	A, B, D, and E are incorrect based on the above. (Objective 1.3)
 */


/*
Mi Respuesta:
	La tuve mal me fui con la finta y elegi la B, pero por default 
	siempre se trata como un int cualquier operación en primitivos
	que no sean flotantes. Entonces por eso mas que obvio es la C
*/