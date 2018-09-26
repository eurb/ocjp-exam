package com.test.exam.ocjp.operators.q07;
//Given:
public class McGee {
	public static void main(String[] args) {
		Days d1 = Days.TH;
		Days d2 = Days.M;
		for(Days d: Days.values()) {
			if(d.equals(Days.F)) break;
			d2 = d;
		}
		System.out.println((d1 == d2)?"same old" : "newly new");
	}
	enum Days {M, T, W, TH, F, SA, SU};
}

/*
What is the result?
A. same old
B. newly new
C. Compilation fails due to multiple errors
D. Compilation fails due only to an error on line 7
E. Compilation fails due only to an error on line 8
F. Compilation fails due only to an error on line 11
G. Compilation fails due only to an error on line 13
*/









































































/*
Answer:
A is correct. All of this syntax is correct. 
The for-each iterates through the enum using the values() 
method to return an array. Enums can be compared using 
either equals() or ==. Enums can be used in a ternary 
operator's Boolean test.
B, C, D, E, F, and G are incorrect based on the above. (Objective 7.6)

	ok No Problem!
*/