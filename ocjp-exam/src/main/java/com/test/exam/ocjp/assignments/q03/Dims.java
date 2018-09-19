package com.test.exam.ocjp.assignments.q03;

//Given:
/*1.*/ class Dims {
/*2.*/ 	public static void main(String[] args) {
/*3.*/ 		int[][] a = {{1,2,}, {3,4}};
/*4.*/ 		int[] b = (int[]) a[1];
/*5.*/ 		Object o1 = a;
/*6.*/ 		int[][] a2 = (int[][]) o1;
/*7.*/ 		int[] b2 = (int[]) o1;
/*8.*/ 		System.out.println(b[1]);
/*9.*/ } }

/*
What is the result?
A. 2
B. 4
C. An exception is thrown at runtime
D. Compilation fails due to an error on line 4
E. Compilation fails due to an error on line 5
F. Compilation fails due to an error on line 6
G. Compilation fails due to an error on line 7
*/






















































/*
Answer:
C is correct. A ClassCastException is thrown at line 7 
because o1 refers to an int[][] not an int[]. If line 7 was 
removed, the output would be 4.

A, B, D, E, F, and G are incorrect based on the above. (Objective 1.3)
278 Chapter 3: Assignments
*/

/*
 * Mi respuesta:
 * Elegi la opción G, ya que pense que como el Object tenia un array 2d
 * entonces al tratar de  convertirlo a un array de 2d maracaria
 * error de compilación en la linea 7.
 * Sin embargo el codigo compila bien y en efecto truena en esa linea
 * pero en tiempo de ejecución y manda un ClassCastException.
 * 
 * Otra nota a tomar en cuenta es que en la linea 4 tratamos de convertir
 * el objeto de tipo int[][]  a un objeto int[] usando la variable b.
 * Esto es valido aunque no se reqiere ya que de por si vamos a obbeter
 * el objeto int[] pero aun asi se hace el cast explicito pero no es
 * necesario sin emabrgo lo hacen para confundirnos.
 * 
*/
