package com.test.exam.ocjp.assignments.q08;
//Given:
public class Ouch {
	static int ouch = 7;
	public static void main(String[] args) {
		new Ouch().go(ouch);
		System.out.print(" " + ouch);
	}
	void go(int ouch) {
		ouch++;
		for(int ouch = 3; ouch < 6; ouch++)
			;
		System.out.print(" " + ouch);
	}
}
/*
What is the result?
A. 5 7
B. 5 8
C. 8 7
D. 8 8
E. Compilation fails

*/


































































/*
Answer:
E is correct. The parameter declared on line 9 is valid 
(although ugly), but the variable name ouch cannot be declared 
again on line 11 in the same scope as the declaration on line 9.
A, B, C, D, and F are incorrect based on the above. (Objective 1.3)
*/
/*
Mi Respuesta:
	La tuve bien pero le dude ya que me confundi en el for con 
	precisamente el nombre de la variable, pero al fin si elegi
	la correcta porque no puede tener el mismo nombre una variable
	en el mismo scope
*/