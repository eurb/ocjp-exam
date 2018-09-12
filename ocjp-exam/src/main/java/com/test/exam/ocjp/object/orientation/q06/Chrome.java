package com.test.exam.ocjp.object.orientation.q06;
//Given the following,

/*1.*/ class X { void do1() { } }
/*2.*/ class Y extends X { void do2() { } }
/*3.*/
/*4.*/ class Chrome {
/*5.*/ 		public static void main(String [] args) {
/*6.*/ 			X x1 = new X();
/*7.*/ 			X x2 = new Y();
/*8.*/ 			Y y1 = new Y();
/*9.*/ // insert code here
/*10.*/ 	}
/*11.*/ }

/*
Which, inserted at line 9, will compile? (Choose all that apply.)
A. x2.do2();
B. (Y)x2.do2();
C. ((Y)x2).do2();
D. None of the above statements will compile
*/























































/*
Answer:
C is correct. Before you can invoke Y’s do2 method you have 
	to cast x2 to be of type Y. Statement B looks like a proper 
	cast but without the second set of parentheses, 
	the compiler thinks it’s an incomplete statement.
A, B and D are incorrect based on the preceding.
	(Objective 5.2)
*/

/*Esta la tuve bien se debe de convertir para poder 
 * usar el metodo do2
 */
