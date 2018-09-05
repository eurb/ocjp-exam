package com.test.exam.ocjp.declarations.and.access.control.q07;

//Given:
class Announce {
	public static void main(String[] args) {
		for(int __x = 0; __x < 3; __x++) ;
		int #lb = 7;
		long [] x [5];
		Boolean []ba[];
		enum Traffic { RED, YELLOW, GREEN };
	}
}


/*
What is the result? (Choose all that apply
.)
A. Compilation succeeds
B. Compilation fails with an error on line 6
C. Compilation fails with an error on line 7
D. Compilation fails with an error on line 8
E. Compilation fails with an error on line 9
F. Compilation fails with an error on line 10
*/




















































/*
Answer:
	C, D, and F are correct. Variable names cannot begin with a #, an array 
		declaration can’t include a size without an instantiation, 
		and enums can’t be declared within a method.
	A, B, and E are incorrect based on the above information. (Objective 1.3)
*/