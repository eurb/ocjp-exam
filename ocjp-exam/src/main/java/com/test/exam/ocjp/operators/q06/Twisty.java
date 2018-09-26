package com.test.exam.ocjp.operators.q06;
//Given
public class Twisty {
 { index = 1; }
 int index;
 public static void main(String[] args) {
	 new Twisty().go();
 }
 void go() {
 int [][] dd = {{9,8,7}, {6,5,4}, {3,2,1,0}};
 System.out.println(dd[index++][index++]);
 }
}


/*
What is the result? (Choose all that apply
.)
A. 1
B. 2
C. 4
D. 6
E. 8
F. Compilation fails
G. An exception is thrown at runtime
*/








































































/*
Answer:
C is correct. Multidimensional arrays' dimensions can be 
inconsistent, the code uses an initialization block, 
and the increment operators are both post-increment 
operators.
A, B, D, E, F, and G are incorrect based on the above. (Objective 1.3)

Ok, No Problem
*/