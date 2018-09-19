package com.test.exam.ocjp.assignments.q13;
//Given:
public class Dark {
	int x = 3;
	public static void main(String[] args) {
		new Dark().go1();
	}
	void go1() {
		int x;
		go2(++x);
	}
	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}
}



/*
What is the result?
A. 2
B. 3
C. 4
D. 5
E. Compilation fails
F. An exception is thrown at runtime
*/



















































/*
Answer:
E is correct. In go1() the local variable x is not initialized.
A, B, C, D, and F are incorrect based on the above. (Objective 1.3)
*/