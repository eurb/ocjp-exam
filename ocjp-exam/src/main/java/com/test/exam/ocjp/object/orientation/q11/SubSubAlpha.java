package com.test.exam.ocjp.object.orientation.q11;
//Given:
class Alpha {
	static String s = " ";
	protected Alpha() { s += "alpha "; }
 }
 class SubAlpha extends Alpha {
	 private SubAlpha() { s += "sub "; }
 }
 public class SubSubAlpha extends Alpha {
	 private SubSubAlpha() { s += "subsub "; }
	 public static void main(String[] args) {
		 new SubSubAlpha();
		 System.out.println(s);
	 }
 }
 /*
 What is the result?
	A. subsub
	B. sub subsub
	C. alpha subsub
 	D. alpha sub subsub
	E. Compilation fails
	F. An exception is thrown at runtime
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
/* 
 Answer:
 	C is correct. Watch out, SubSubAlpha extends Alpha! 
 		Since the code doesn’t attempt to make a SubAlpha, 
 		the private constructor in SubAlpha is okay.
	A, B, D, E, and F are incorrect based on the above 
	information.
	 (Objective 5.3)
 */
 /*
 Esta es una estupidez, la tuve mal por error de ojo ya que la
 clase SubAlpha nunca es usada realemnte solo se usa en extends
 directamente a Alpha, entonces la cadenita de contructores es:
 se llama al contructo de Alpha y al final del subsubAlpha
 El contructor private si se permitesin embargo no se usa para nada
 al menos en este ejemplo.
 */