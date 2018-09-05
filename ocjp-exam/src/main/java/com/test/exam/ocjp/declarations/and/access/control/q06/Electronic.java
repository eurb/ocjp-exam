package com.test.exam.ocjp.declarations.and.access.control.q06;
//Given:
/*1.*/ public class Electronic implements Device
			{ public void doIt() { } }
/*2.*/
/*3.*/ abstract class Phone1 extends Electronic { }
/*4.*/
/*5.*/ abstract class Phone2 extends Electronic
			{ public void doIt(int x) { } }
/*6.*/
/*7.*/ class Phone3 extends Electronic implements Device
			{ public void doStuff() { } }
/*8.*/
/*9.*/ interface Device { public void doIt(); }

/*
What is the result? (Choose all that apply
.)
A. Compilation succeeds
B. Compilation fails with an error on line 1
C. Compilation fails with an error on line 3
D. Compilation fails with an error on line 5
E. Compilation fails with an error on line 7
F. Compilation fails with an error on line 9
*/


























































/*
Answer:
	A is correct; all of these are legal declarations.
	B, C, D, E, and F are incorrect based on the above information. (Objective 1.2)
*/

/*
Mi explicación:
		Sólo debemos recordar que una clase asbtract no esta obligada a implementar los
		métodos de una interface o de otra clase asbtracta. En estas cuestiones
		Se puede diseñar una jearquia de clases con UML, para más rápido.abstract.
*/