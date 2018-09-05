package com.test.exam.ocjp.declarations.and.access.control.q04;

//Given:
/*1.*/ enum Animals {
/*2.*/ 	DOG("woof"), CAT("meow"), FISH("burble");
/*3.*/ 	String sound;
/*4.*/ 	Animals(String s) { sound = s; }
/*5.*/ }
/*6.*/ class TestEnum {
/*7.*/ 	static Animals a;
/*8.*/ 	public static void main(String [] args) {
/*9.*/ 		System.out.println(a.DOG.sound + " " + a.FISH.sound);
/*10.*/ }
/*11.*/}


/*
What is the result?
A. woof burble
B. Multiple compilation errors
C. Compilation fails due to an error on line 2
D. Compilation fails due to an error on line 3
E. Compilation fails due to an error on line 4
F. Compilation fails due to an error on line 9
*/












































/*
Answer:
	A is correct; enums can have constructors and variables.
	B, C, D, E, and F are incorrect; these lines 
	all use correct syntax. (Objective 1.3)
*/

/*Nota: La variable static Animals a; es declarad como static para ser usada
 *Dentro de main, por lo de la regla del static que algo dentro de static
 *mo puede hacer referencia a algo non-static
 * */