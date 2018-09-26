package com.test.exam.ocjp.operators.q09;
//Given:
public class Spock {
	public static void main(String[] args) {
		int mask = 0;
		int count = 0;
		if( ((5<7) || (++count < 10)) | mask++ < 10 ) mask = mask + 1;
		if( (6 > 8) ^ false) mask = mask + 10;
		if( !(mask > 1) && ++count > 1) mask = mask + 100;
		System.out.println(mask + " " + count);
	}
}


/*
Which two answers are true about the value of mask and the value of count at line 10?
(Choose two.)
A. mask is 0
B. mask is 1
C. mask is 2
D. mask is 10
E. mask is greater than 10
F. count is 0
G. count is greater than 0
*/














































































/*
Answer:
C and F are correct. At line 7 the || keeps count from 
being incremented, but the | allows mask to be incremented.
 At line 8 the ^ returns true only if exactly one operand 
 is true. At line 9 mask is 2 and the && keeps count from b
 eing incremented.
A, B, D, E, and G are incorrect based on the above. (Objective 7.6)
*/

/*
Mi explicación:
	La c es correcta y es la que seleccione
	sin embargo me falto seleccionar la F cuando la pregunta
	dice (Choose two.) o (Choose all thar apply) debemos
	de ver todas las posibles respuetsas.
	En esta ocacion no me percate que decia choose two
	y en efecto la F es correcta porque count permanece en
	cero
*/