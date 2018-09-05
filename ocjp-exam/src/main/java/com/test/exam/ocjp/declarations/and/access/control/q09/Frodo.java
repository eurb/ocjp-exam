package com.test.exam.ocjp.declarations.and.access.control.q09;

//Given:
public class Frodo extends Hobbit {
	public static void main(String[] args) {
		Short myGold = 7;
		System.out.println(countGold(myGold, 6));
	}
}
class Hobbit {
	int countGold(int x, int y) { return x + y; }
}

/*
What is the result?
A. 13
B. Compilation fails due to multiple errors
C. Compilation fails due to an error on line 6
D. Compilation fails due to an error on line 7
E. Compilation fails due to an error on line 11
*/






















































/*
Answer:
	D is correct. The Short myGold is autoboxed correctly, 
		but the countGold() method cannot be invoked 
		from a static context.
®˚ A, B, C, and E are incorrect based on the above information. (Objective 1.4)
*/