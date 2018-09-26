package com.test.exam.ocjp.flow.control.q02;

public class Plane {
	static String s = "-";
	public static void main(String[] args) {
		new Plane().s1();
		System.out.println(s);
	}
	void s1() {
		try { s2(); }
		catch (Exception e) { s += "c"; }
	}
	void s2() throws Exception {
		s3(); s += "2";
		s3(); s += "2b";
	}
	void s3() throws Exception {
		throw new Exception();
	} }
/*
What is the result?
A. -
B. -c
C. -c2
D. -2c
E. -c22b
F. -2c2b
G. -2c2bc
H. Compilation fails
*/








































































/*
Answer:
B is correct. Once s3() throws the exception to s2(), s2()
 throws it to s1(), and no more of s2()’s code will be 
 executed.
A, C, D, E, F, G, and H are incorrect based on the 
above. (Objective 2.5)
*/
/*
Mi Respuetsa:
	La tuve bien, el truco es seguir la propagación
	de las excepciones, debemos ver tambien que si
	se lanza una excepcion checked esta sea declarada
	en el método.
*/