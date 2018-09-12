package com.test.exam.ocjp.object.orientation.q08;
//Given:
class Dog {
	public void bark() { System.out.print("woof "); }
}
class Hound extends Dog {
	public void sniff() { System.out.print("sniff "); }
	public void bark() { System.out.print("howl "); }
}
public class DogShow {
	public static void main(String[] args) { new DogShow().go(); }
		void go() {
			new Hound().bark();
			((Dog) new Hound()).bark();
			((Dog) new Hound()).sniff();
		}
}
/*
What is the result? (Choose all that apply.)
A. howl howl sniff
B. howl woof sniff
C. howl howl followed by an exception
D. howl woof followed by an exception
E. Compilation fails with an error at line 14
F. Compilation fails with an error at line 15
*/























































/*
Answer:
F is correct. Class Dog doesn’t have a sniff method.
A, B, C, D, and E are incorrect based on the above information.
(Objective 5.2)
*/

/*Esta estaba fácil y la tuve mal es mas que simple la clase
 * Dog no tiene el método sniff
 */