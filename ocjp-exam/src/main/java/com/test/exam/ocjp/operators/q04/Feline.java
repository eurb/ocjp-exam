package com.test.exam.ocjp.operators.q04;
//Given:
public class Feline {
public static void main(String[] args) {
	Long x = 42L;
	Long y = 44L;
	System.out.print(" " + 7 + 2 + " ");
	System.out.print(foo() + x + 5 + " ");
	System.out.println(x + y + foo());
}
static String foo() { return "foo"; }
}

/*
What is the result?
A. 9 foo47 86foo
B. 9 foo47 4244foo
C. 9 foo425 86foo
D. 9 foo425 4244foo
E. 72 foo47 86foo
F. 72 foo47 4244foo
G. 72 foo425 86foo
H. 72 foo425 4244foo
I. Compilation fails
*/









































































/*
Answer:
G is correct. Concatenation runs from left to right, 
and if either operand is a String, the operands are 
concatenated. If both operands are numbers they are 
added together. Unboxing works in conjunction with 
concatenation.
A, B, C, D, E, F, H, and I are incorrect based on the above. (Objective 7.6)
*/
/*Mi Respuesta: Ok no problem!*/









