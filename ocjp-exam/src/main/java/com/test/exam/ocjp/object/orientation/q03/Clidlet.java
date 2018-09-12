package com.test.exam.ocjp.object.orientation.q03;

//Given:
class Clidder {
private final void flipper() { System.out.println("Clidder"); }
}
public class Clidlet extends Clidder {
public final void flipper() { System.out.println("Clidlet"); }
public static void main(String [] args) {
new Clidlet().flipper();
} }
/*
What is the result?
A. Clidlet
B. Clidder
C. Clidder
Clidlet
D. Clidlet
Clidder
E. Compilation fails
*/


















































/*
Answer:
	A is correct. Although a final method cannot be overridden, 
	in this case, the method is private, and therefore hidden. 
	The effect is that a new, accessible, method flipper is created. 
	Therefore, no polymorphism occurs in this example, 
	the method invoked is simply that of the child class, 
	and no error occurs.
	B, C, D, and E are incorrect based on the preceding.(Objective 5.3)
*/



/*Esta estuvo fácil la tuve bien*/