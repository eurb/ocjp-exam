package com.test.exam.ocjp.inner.classes.q05;
//Given:
/*1.*/ public class HorseTest {
/*2.*/ 	public static void main(String[] args) {
/*3.*/ 		class Horse {
/*4.*/ 			public String name;
/*5.*/ 			public Horse(String s) {
/*6.*/ 				name = s;
/*7.*/ 			}
/*8.*/ 		}
/*9.*/ 		Object obj = new Horse("Zippo");
/*10.*/ 	System.out.println(obj.name);
/*11.*/ }
/*12.*/}

/*
 * What is the result?
	A. An exception occurs at runtime at line 10
	B. Zippo
	C. Compilation fails because of an error on line 3
	D. Compilation fails because of an error on line 9
	E. Compilation fails because of an error on line 10
 */















































/*
Answer:
	E. If you use a reference variable of type Object, you can access only those members
defined in class Object.
	A, B, C, and D are incorrect based on the program logic described above.
*/

/*Mi explicación:
 * No hay más la E es correcta porque objet no conoce el atributo name
 * */
