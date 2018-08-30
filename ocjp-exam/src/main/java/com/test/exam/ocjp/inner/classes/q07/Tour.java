package com.test.exam.ocjp.inner.classes.q07;
//Given:
public class Tour {
	public static void main(String[] args) {
		Cathedral c = new Cathedral();
		// insert code here
		s.go();
	}
}
class Cathedral {
	class Sanctum {
		void go() { System.out.println("spooky"); }
	}
 }

/*
Which, inserted independently at line 6, compile and pro
duce the output "spooky"? (Choose all that apply.)
	A. Sanctum s = c.new Sanctum();
	B. c.Sanctum s = c.new Sanctum();
	C. c.Sanctum s = Cathedral.new Sanctum();
	D. Cathedral.Sanctum s = c.new Sanctum();
	E. Cathedral.Sanctum s = Cathedral.new Sanctum();
*/
















































/*Answer:
	D is correct. It is the only code that uses the correct inner class instantiation syntax.
	A, B, C, and E are incorrect based on the above. (Objective 1.1)*/