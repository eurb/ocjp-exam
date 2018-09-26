package com.test.exam.ocjp.operators.q01;

public class Hexy {
	
	public static void main(String[] args) {
		Integer i = 42;
		String s = (i<40)?"life":(i>50)?"universe":"everything";
		System.out.println(s);
	}

}

/*
What is the result?
A. null
B. life
C. universe
D. everything
E. Compilation fails
F. An exception is thrown at runtime
*/














































































/*
Answer:
D is correct. This is a ternary nested in a ternary with
 	a little unboxing thrown in.
	Both of the ternary expressions are false.
	A, B, C, E, and F are incorrect based on the above.
(Objective 7.6)
*/

/*Ok no problem!*/