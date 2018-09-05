package com.test.exam.ocjp.declarations.and.access.control.q08;
//Given:
public class TestDays {
	public enum Days { MON, TUE, WED };
	public static void main(String[] args) {
		for(Days d : Days.values() )
			;
		Days [] d2 = Days.values();
		System.out.println(d2[2]);
	}
 }

/*
What is the result? (Choose all that apply
.)
A. TUE
B. WED
C. The output is unpredictable
D. Compilation fails due to an error on line 4
E. Compilation fails due to an error on line 6
F. Compilation fails due to an error on line 8
G. Compilation fails due to an error on line 9
*/















































/*
Answer:
	B is correct. Every enum comes with a static values() method that 
		returns an array of the enum's values, in the order in which 
		they are declared in the enum.
	A, C, D, E, F, and G are incorrect based on the above information. (Objective 1.3)
*/