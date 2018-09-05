package com.test.exam.ocjp.inner.classes.q11;
//Given:
public class Navel {
	private int size = 7;
	private static int length = 3;
	public static void main(String[] args) {
		new Navel().go();
	}
	void go() {
		int size = 5;
		System.out.println(new Gazer().adder());
	}
	class Gazer {
		int adder() { return size * length; }
	}
}

/*
What is the result?
	A. 15
	B. 21
	C. An exception is thrown at runtime
	D. Compilation fails due to multiple errors
	E. Compilation fails due only to an error on line 4
	F. Compilation fails due only to an error on line 5
*/








































/*
Answer:
	B is correct. The inner class Gazer has access to Navel's private 
	static and private instance variables.
	
	A, C, D, E, and F are incorrect based on the above. (Objectives 1.1, 1.4)
*/