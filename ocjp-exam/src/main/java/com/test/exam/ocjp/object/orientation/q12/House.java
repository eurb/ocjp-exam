package com.test.exam.ocjp.object.orientation.q12;
//Given:
 class Building {
	 Building() { System.out.print("b "); }
	 Building(String name) {
		 this(); System.out.print("bn " + name);
	 }
 }
 public class House extends Building {
	 House() { System.out.print("h "); }
	 House(String name) {
		 this(); System.out.print("hn " + name);
	 }
	 public static void main(String[] args) { new House("x "); }
 }
 /*
 What is the result?
	A. h hn x
	B. hn x h
	C. b h hn x
	D. b hn x h
	E. bn x h hn x
	F. b bn x h hn x
	G. bn x b h hn x
	H. Compilation fails
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 /*
 Answer:
	C is correct. Remember that constructors call their 
		superclass constructors, which execute first, 
		and that constructors can be overloaded.
	A, B, D, E, F, G, and H are incorrect based on the above information.
	 (Objectives 1.6, 5.4)
 */
 /*
 Este lo tuve bien y esta relax, el truco solo es ir siguiendo
 el ecadenamiento de constructores
 */