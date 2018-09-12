package com.test.exam.ocjp.object.orientation.q10;
//Given:
public class Tenor extends Singer {
	public static String sing() { return "fa"; }
	public static void main(String[] args) {
		Tenor t = new Tenor();
		Singer s = new Tenor();
		System.out.println(t.sing() + " " + s.sing());
	}
}
class Singer { public static String sing() { return "la"; } }

/*
What is the result?
A. fa fa
B. fa la
C. la la
D. Compilation fails
E. An exception is thrown at runtime
*/





























































/*
Answer:
B is correct. The code is correct, but polymorphism 
	doesn’t apply to static methods.
A, C, D, and E are incorrect based on the above information.
(Objective 5.2)
*/

/*
Esta la tuve bien solo hay qeu recordar que cuand se trata de
un método static la invoación siempre se hace a la clase en la
que la variable sea declarada y esto es opcional ya que se puede
inovcar directo con el nombre de la clase
Ese es el truco
*/