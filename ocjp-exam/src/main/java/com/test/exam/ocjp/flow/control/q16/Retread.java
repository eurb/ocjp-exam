package com.test.exam.ocjp.flow.control.q16;
class MyException extends Exception { }
class Tire {
	void doStuff() { }
}
public class Retread extends Tire {
	public static void main(String[] args) {
		new Retread().doStuff();
	}
	// insert code here
	System.out.println(7/0);
	}
}
/*
And given the following four co
de fragments:
I. void doStuff() {
II. void doStuff() throws MyException {
III. void doStuff() throws RuntimeException {
IV. void doStuff() throws ArithmeticException {
*/

/*
When fragments I - IV are added, independently, at line 10, which are true? (Choose all that apply.)
A. None will compile
B. They will all compile
C. Some, but not all, will compile
D. All of those that compile will throw an exception at runtime
E. None of those that compile will throw an exception at runtime
F. Only some of those that compile will throw an exception at runtime
*/























































/*
Answer:
C and D are correct. An overriding method cannot throw checked 
exceptions that are broader than those thrown by the overridden
 method. However an overriding method can throw RuntimeExceptions not thrown by the overridden method.
A, B, E, and F are incorrect based on the above. (Objective 2.4)
*/
/*
Mi Respuesta:
	C y F
	Estoy mal en la F
	El truco es que si vas a sobreescribir un metodo y este
	no tiene checked exceptions entonces no puedes
	sobreescribirlo lanzando una checked exception solo
	se permiten un unchecked ya que esas no tienen
	restricciones
*/