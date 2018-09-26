package com.test.exam.ocjp.operators.q08;

//Given:
public class SpecialOps {
	public static void main(String[] args) {
		String s = "";
		Boolean b1 = true;
		Boolean b2 = false;
		if((b2 = false) | (21%5) > 2) s += "x";
		if(b1 || (b2 = true)) s += "y";
		if(b2 == true) s += "z";
		System.out.println(s);
	}
}

/*
Which are true? (Choose all that apply
.)
A. Compilation fails
B. x will be included in the output
C. y will be included in the output
D. z will be included in the output
E. An exception is thrown at runtime
*/










































































/*
Answer:
C is correct. First of all, boxing takes care of the 
Boolean. Line 9 uses the modulus operator, 
which returns the remainder of the division, 
which in this case is 1. Also, line 9 sets b2 to false, 
and it doesn't test b2's value. Line 10 sets b2 to true, 
and it doesn’t test its value; however, the short circuit
operator keeps the expression b2 = true from being executed.
A, B, D, and E are incorrect based on the above. 
(Objective 7.6)


Ok No problem!
*/