package com.test.exam.ocjp.declarations.and.access.control.q03;
//Given:
/*1.*/ class Voop {
/*2.*/ 	public static void main(String[] args) {
/*3.*/ 	doStuff(1);
/*4.*/ 	doStuff(1,2);
/*5.*/ }
/*6.*/ // insert code here
/*7.*/}
/*
Which, inserted independently at line 6, will compile? 
(Choose all that apply.)

A. static void doStuff(int... doArgs) { }
B. static void doStuff(int[] doArgs) { }
C. static void doStuff(int doArgs...) { }
D. static void doStuff(int... doArgs, int y) { }
E. static void doStuff(int x, int... doArgs) { } 

*/


































































/*
Answer:
	A and E use valid var-args syntax.
	B and C are invalid var-arg syntax, 
	and D is invalid because the var-arg must be the last 
	of a method's arguments. (Objective 1.4)
*/


/*
 * Mi explicación:
 * El truco es no confundir la declaración del var args
 * Incorrecto: int doArgs...
 * Correcto: int... doArgs
 * Para recordarlo solo basta con saber que despues del tipo de dato
 * va seguido de la elipsis "..."
 */